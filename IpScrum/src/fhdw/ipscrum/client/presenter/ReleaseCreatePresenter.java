package fhdw.ipscrum.client.presenter;

import java.util.Date;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * This class represents the presenter which controls the view to create Releases.
 */
public class ReleaseCreatePresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.ReleaseCreateView).
	 */
	public static interface IReleaseCreateView extends IView {
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
		 * Getter of the text of the description field on the view.
		 * 
		 * @return the text in the description field
		 */
		String getDescription();

		/**
		 * Getter of the date of the releaseDate field on the view.
		 * 
		 * @return the text in the releaseDate field
		 */
		Date getReleaseDateBox();
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IReleaseCreateView view;

	/**
	 * represents the project related to this view. It is needed to make clear for which
	 * project this release should be created.
	 */
	private final Project project;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ReleaseCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project in which the release should be created
	 */
	public ReleaseCreatePresenter(final ClientContext context, final Project project) {
		super(context);
		this.project = project;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Neues Release erstellen";
	}

	@Override
	public IReleaseCreateView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createReleaseCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ReleaseCreatePresenter.this.save();
					ReleaseCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ReleaseCreatePresenter.this.showQuestion("Änderungen verwerfen?",
							new Answer("Ja") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									ReleaseCreatePresenter.this.close();
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
			this.doCommand(new ReleaseCreateCommand(this.project, this.view
					.getDescription(), this.view.getReleaseDateBox()));
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
