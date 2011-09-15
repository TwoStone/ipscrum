package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.viewinterfaces.IEditSprintView;
import fhdw.ipscrum.shared.commands.project.SprintChangeCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This class represents the presenter which controls the view to edit Sprints.
 */
public class EditSprintPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IEditSprintView view;

	/**
	 * represents the sprint related to this view. It is needed to make clear which sprint
	 * should be edited.
	 */
	private Sprint sprint;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.EditSprintPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param sprint
	 *            is the related sprint which should be edited
	 */
	public EditSprintPresenter(final ClientContext context, final Sprint sprint) {
		super(context);
		this.sprint = sprint;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Sprint bearbeiten";
	}

	@Override
	public IEditSprintView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createEditSprintView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					EditSprintPresenter.this.save();
					EditSprintPresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					EditSprintPresenter.this.showQuestion(
							"Wollen Sie die Seite ohne zu speichern verlassen?",
							new Answer("Ja!") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									EditSprintPresenter.this.close();
								}
							}, new Answer("Nein!") {

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
			this.doCommand(new SprintChangeCommand(this.sprint, this.view.getName(),
					this.view.getDescription(), this.view.getStart(), this.view
							.getEnd(), this.view.getSelectedTeam()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.fillComboBoxTeams(this.getContext().getModel().getAllTeams());
		this.view.updateFields(this.sprint);
	}

	@Override
	public void onModelUpdate() {
		this.sprint = this.updateObject(this.sprint);
		this.updateView();
	}

}
