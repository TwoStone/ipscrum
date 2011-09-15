package fhdw.ipscrum.client.presenter;

import java.util.Collection;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.eventargs.SystemArgs;
import fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand;
import fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * This class represents the presenter which controls the view to select systems for a
 * project.
 */
public class ProjectSelectSystemPresenter extends WritePresenter {

	/**
	 * represents the project related to this presenter. It is needed to make clear to
	 * which project the systems should be added or removed.
	 */
	private Project project;
	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private ISelectSystemView view;

	/**
	 * represents a flag to check if the question asking if the view should been left
	 * without saving should be asked.
	 */
	private boolean saved;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.ProjectSelectSystemPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project to select systems for
	 */
	public ProjectSelectSystemPresenter(final ClientContext context,
			final Project project) {
		super(context);
		this.project = project;
		this.beginTransaction();
	}

	/**
	 * interface of the view class for systems. this view is used to select systems of an
	 * amount of available systems.
	 */
	public interface ISelectSystemView extends IView {

		/**
		 * Returns the event fired when the workflow shell be aborted.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event handling the abort
		 */
		EventRegistration registerAbortHandler(DefaultEventHandler handler);

		/**
		 * Returns the event fired when the object shell be saved.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event handling the save
		 */
		EventRegistration registerSaveHandler(DefaultEventHandler handler);

		/**
		 * @return the currently selected System of the available Systems
		 */
		System getSelectedOfAvailableSystems();

		/**
		 * This method is used to obtain the selected System of the selected
		 * Systems-table.
		 * 
		 * @return System the selected System
		 */
		System getSelectedOfSelectedSystems();

		/**
		 * This method is used to update or fill the entries of the team display.
		 * 
		 * @param selectedSystems
		 *            a collection of the selected systems to be displayed.
		 */
		void updateSelectedSystemData(Collection<System> selectedSystems);

		/**
		 * This method is used to update or fill the entries of the person display.
		 * 
		 * @param availableSystems
		 *            a collection of the available systems to be displayed.
		 * @param selectedSystems
		 *            is the collection of the systems the user has already collected for
		 *            the project
		 */
		void updateAvailableSystemData(Collection<System> availableSystems,
				Collection<System> selectedSystems);

		/**
		 * use this method to define the action of the
		 * remove-system-from-selected-systems-button.
		 * 
		 * @param args
		 *            empty arguments
		 * @return the event needed to handle the remove.
		 */
		EventRegistration removeRemoveSelectedSystemHandler(
				EventHandler<SystemArgs> args);

		/**
		 * use this method to define the action of the
		 * add-system-from-selected-systems-button.
		 * 
		 * @param args
		 *            empty arguments
		 * @return the event needed to handle the addition.
		 */
		EventRegistration
				registerAddSelectedSystemHandler(EventHandler<SystemArgs> args);
	}

	@Override
	public String getName() {
		return "Systemzuordnung";
	}

	@Override
	public ISelectSystemView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSelectSystemView();
			this.view.registerAddSelectedSystemHandler(new EventHandler<SystemArgs>() {

				@Override
				public void onUpdate(final Object sender, final SystemArgs eventArgs) {
					ProjectSelectSystemPresenter.this.addSelectedSystem(eventArgs
							.getSystem());
				}
			});
			this.view.removeRemoveSelectedSystemHandler(new EventHandler<SystemArgs>() {

				@Override
				public void onUpdate(final Object sender, final SystemArgs eventArgs) {
					ProjectSelectSystemPresenter.this.removeSelectedSystem(eventArgs
							.getSystem());
				}
			});
			this.view.registerSaveHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectSelectSystemPresenter.this.save();
					ProjectSelectSystemPresenter.this.close();
				}
			});
			this.view.registerAbortHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectSelectSystemPresenter.this.close();
				}
			});
		}

		return this.view;
	}

	/**
	 * this method is needed to remove the selected system.
	 * 
	 * @param system
	 *            to remove from the project
	 */
	private void removeSelectedSystem(final System system) {
		try {
			this.doCommand(new ProjectRemoveSystemCommand(this.project, system));
			this.updateView();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this is the method needed to add the selected systems.
	 * 
	 * @param system
	 *            to add to the project
	 */
	private void addSelectedSystem(final System system) {
		try {
			this.doCommand(new ProjectAddSystemCommand(this.project, system));
			this.updateView();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public Boolean onSave() {
		this.commitTransaction();
		this.saved = true;
		return true;
	}

	@Override
	protected void onClose(final CloseCallback callback) {
		if (!this.saved) {
			this.showQuestion("Wollen sie die Seite ohne Speichern verlassen?",
					new Answer("Ja!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							callback.closed();
							ProjectSelectSystemPresenter.this.rollbackTransaction();
						}
					}, new Answer("Nein!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							callback.closeAborted();
						}
					});
		} else {
			callback.closed();
		}
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager()
				.getProjectRight());
		this.getView().updateAvailableSystemData(
				this.getContext().getModel().getSystems().getSystems(),
				this.project.getSystems());
		this.getView().updateSelectedSystemData(this.project.getSystems());
	}

	@Override
	public void onModelUpdate() {
		try {
			this.project = this.getContext().getModel().getObject(this.project);
			this.beginTransaction();
			this.saved = false;
			this.updateView();
		} catch (final NoObjectFindException e) {
			this.toastMessage("Projekt nicht verfügbar!");
			this.close();
		}
	}
}
