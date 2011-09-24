package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;

/**
 * This class represents the presenter which controls the view to create Teams.
 */
public class ProjectCreatePresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.ProjectCreateView).
	 */
	public static interface IProjectCreateView extends IView {

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
	private IProjectCreateView view;

	/**
	 * represents a flag to check if the question asking if the view should been left without saving should be asked.
	 */
	private boolean saved = false;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ProjectCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public ProjectCreatePresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Projekt erstellen";
	}

	@Override
	public IProjectCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createProjectCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectCreatePresenter.this.save();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectCreatePresenter.this.close();
				}
			});
		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			this.beginTransaction();
			this.doCommand(new ProjectCreateCommand(this.view.getName()));
			this.commitTransaction();
			this.saved = true;
			ProjectCreatePresenter.this.close();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			return false;
		}
	}

	@Override
	protected void onClose(final CloseCallback callback) {
		if (!this.saved) {
			this.showQuestion("Möchten sie den Vorgang wirklich abbrechen?", new Answer("Ja!") {

				@Override
				public void onAction(final QuestionDialog widget) {
					widget.hide();
					callback.closed();
				}
			}, new Answer("Nein!") {

				@Override
				public void onAction(final QuestionDialog widget) {
					widget.hide();
					callback.closeAborted();
				}
			});
		} else {
			callback.closed();
		}
	}

	@Override
	public void updateView() {

	}

	@Override
	public void onModelUpdate() {

	}

}
