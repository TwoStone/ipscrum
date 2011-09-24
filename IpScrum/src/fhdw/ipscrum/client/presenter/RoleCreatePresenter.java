package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;

/**
 * This class represents the presenter which controls the view to create Roles.
 */
public class RoleCreatePresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.RoleCreateView).
	 */
	public static interface IRoleCreateView extends IView {
		/**
		 * Represents the Event to handle the save.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the save
		 */
		EventRegistration registerSave(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the abort.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the abort
		 */
		EventRegistration registetAbort(DefaultEventHandler handler);

		/**
		 * Getter of the text of the name field on the view.
		 * 
		 * @return the text in the name field
		 */
		String getName();
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IRoleCreateView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.RoleCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public RoleCreatePresenter(final ClientContext context) {
		super(context);
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Rolle erstellen";
	}

	@Override
	public IRoleCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createRoleCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					RoleCreatePresenter.this.save();
					RoleCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					RoleCreatePresenter.this.showQuestion("Änderungen verwerfen?",
							new Answer("Ja") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									RoleCreatePresenter.this.close();
								}
							}, new Answer("Nein") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
								}
							});
				}
			});
		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			this.doCommand(new RoleCreateCommand(this.view.getName()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {

	}

	@Override
	public void onModelUpdate() {

	}

}
