package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.presenter.SystemManagementPresenter.ISystemManagementView.NewSystemEventArgs;
import fhdw.ipscrum.client.view.SystemManagementView;
import fhdw.ipscrum.shared.commands.admin.SystemCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * 
 */
public class SystemManagementPresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.SystemManagementView).
	 */
	public static interface ISystemManagementView extends IView {

		/**
		 * Represents new EvetnArgs which contains data for a new system (name, parent).
		 */
		static class NewSystemEventArgs extends EventArgs {

			/**
			 * represents the name of the new system.
			 */
			private final String name;
			/**
			 * represents the parent system of the new system.
			 */
			private final System parent;

			/**
			 * constructor of the NewSystemEventArgs.
			 * 
			 * @param name
			 *            of the new system
			 * @param parent
			 *            is the parent system of the new system
			 */
			public NewSystemEventArgs(final String name, final System parent) {
				super();
				this.name = name;
				this.parent = parent;
			}

		}

		/**
		 * Represents the Event to handle to create a new system.
		 * 
		 * @param handler
		 *            needed to handle the event, which also knows the data of the new
		 *            system
		 * @return the event which handles to create the new system
		 */
		EventRegistration registerCreateSystemHandler(
				EventHandler<SystemManagementView.NewSystemEventArgs> handler);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing rootSystems.
		 * 
		 * @param group
		 *            are the existing rootSystems
		 */
		void setRootSystemGroup(List<System> group);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * possible parentSystems.
		 * 
		 * @param parents
		 *            are the possible parentSystems
		 */
		void setPossibleParents(List<System> parents);
	}

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private ISystemManagementView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.StateFieldAndTickettypeAdministrationPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public SystemManagementPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Systemverwaltung";
	}

	@Override
	public ISystemManagementView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSystemManagementView();
			this.view
					.registerCreateSystemHandler(new EventHandler<SystemManagementPresenter.ISystemManagementView.NewSystemEventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final NewSystemEventArgs eventArgs) {
							SystemManagementPresenter.this.createSystem(eventArgs.name,
									eventArgs.parent);
						}
					});
		}
		return this.view;
	}

	/**
	 * this method is needed for creating new systems.
	 * 
	 * @param name
	 *            is the name of the new system
	 * @param parent
	 *            is a system which is the parent of the system
	 */
	private void createSystem(final String name, final AbstractSystem parent) {
		try {
			this.beginTransaction();
			final Command<?> command;
			if (parent == null) {
				command = new SystemCreateCommand(name, this.getContext().getModel());
			} else {
				command = new SystemCreateCommand(name, parent);
			}
			this.doCommand(command);

			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.rollbackTransaction();
			this.toastMessage(e.getMessage());
		}
	}

	@Override
	public void updateView() {
		this.getView().setPossibleParents(this.getContext().getModel().getAllSystems());
		this.getView().setRootSystemGroup(
				this.getContext().getModel().getSystems().getSystems());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
