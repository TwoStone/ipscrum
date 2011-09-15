package fhdw.ipscrum.client.presenter;

import java.util.Date;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.viewinterfaces.ICreateSprintView;
import fhdw.ipscrum.shared.commands.project.SprintCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This class represents the presenter which controls the view to create Sprints.
 */
public class CreateSprintPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ICreateSprintView view;
	/**
	 * represents the project related to this view. It is needed to make clear for which
	 * project this sprint should be created.
	 */
	private final Project project;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.CreateSprintPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project in which the sprint should be created
	 */
	public CreateSprintPresenter(final ClientContext context, final Project project) {
		super(context);
		this.project = project;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Rolle erstellen";
	}

	@Override
	public ICreateSprintView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createCreateSprintView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					CreateSprintPresenter.this.save();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					CreateSprintPresenter.this.showQuestion(
							"Do you want to leave without saving?", new Answer("Yes!") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									CreateSprintPresenter.this.close();
								}
							}, new Answer("No!") {

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
			final String name = this.getView().getName();
			final String description = this.getView().getDescription();
			final Date startDate = this.getView().getStart();
			final Date endDate = this.getView().getEnd();
			final Team selectedTeam = this.getView().getSelectedTeam();

			if (selectedTeam == null) {
				this.toastMessage("Bitte wählen Sie ein Team aus!");
				return false;
			}

			this.doCommand(new SprintCreateCommand(name, startDate, endDate,
					description, selectedTeam, this.project));
			this.commitTransaction();
			this.close();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.fillComboBoxTeams(this.getContext().getModel().getAllTeams());
	}

	@Override
	public void onModelUpdate() {

	}

}
