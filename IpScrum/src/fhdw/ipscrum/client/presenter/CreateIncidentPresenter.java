package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.viewinterfaces.ICreateIncidentView;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;

/**
 * This class represents the presenter which controls the view to create Incidents.
 */
public class CreateIncidentPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private ICreateIncidentView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.CreateIncidentPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public CreateIncidentPresenter(final ClientContext context) {
		super(context);
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Neues Ereignis erstellen";
	}

	@Override
	public ICreateIncidentView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createCreateIncidentView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					CreateIncidentPresenter.this.save();
					CreateIncidentPresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					CreateIncidentPresenter.this.showQuestion("Änderungen verwerfen?",
							new Answer("Ja") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									CreateIncidentPresenter.this.close();
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
			// this.doCommand(new IncidentIllnessCreateCommand(this.view.getStartDate(),
			// this.view.getEndDate(), ));
			this.doCommand(new IncidentOtherIssueCreateCommand(
					this.view.getStartDate(), this.view.getEndDate(), this.view
							.getType().getId(), this.view.getDescription(), this.view
							.getPersons(), this.view.getProjects()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.refreshPersons(this.getContext().getModel().getAllPersons());
		this.view.refreshProjects(this.getContext().getModel().getAllProjects());
		this.view.refreshTypes(this.getContext().getModel().getAllIncidentTypes());

	}

	@Override
	public void onModelUpdate() {

	}

}
