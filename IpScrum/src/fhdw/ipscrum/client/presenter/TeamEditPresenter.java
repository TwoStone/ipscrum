package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This class represents the presenter which controls the view to edit Teams.
 */
public class TeamEditPresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.TeamEditView).
	 */
	public interface ITeamEditView extends IView {
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

		/**
		 * this method is needed to fill the fields in the view with the data of the team to edit.
		 * 
		 * @param team
		 *            to edit
		 */
		void updateTeam(Team team);
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ITeamEditView view;

	/**
	 * represents the team related to this view. It is needed to make clear which team should be edited.
	 */
	private final Team team;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TeamEditPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param team
	 *            is the related team which should be edited
	 */
	public TeamEditPresenter(final ClientContext context, final Team team) {
		super(context);
		this.team = team;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Team bearbeiten";
	}

	@Override
	public ITeamEditView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTeamEditView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TeamEditPresenter.this.save();
					TeamEditPresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TeamEditPresenter.this.showQuestion("Änderungen verwerfen?", new Answer("Ja") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
							TeamEditPresenter.this.close();
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
			this.doCommand(new TeamSetDescriptionCommand(this.team, this.view.getName()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.updateTeam(this.team);
	}

	@Override
	public void onModelUpdate() {

	}

}
