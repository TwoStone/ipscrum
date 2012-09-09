package fhdw.ipscrum.client.presenter;

import java.util.Collection;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.PersonTeamArgs;
import fhdw.ipscrum.client.view.widgets.charts.VelocityChart;
import fhdw.ipscrum.client.viewinterfaces.ITeamView;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This class represents the presenter which controls the view to administer teams and persons in teams.
 */
public class TeamPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ITeamView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TeamPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public TeamPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Teamübersicht";
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTeamView();

			this.view.defineAddPersonToTeamEvent(new EventHandler<PersonTeamArgs>() {
				@Override
				public void onUpdate(final Object sender, final PersonTeamArgs eventArgs) {
					TeamPresenter.this.addPersonToTeam(eventArgs.getTeam(), eventArgs.getPersons());
				}
			});

			this.view.defineRemovePersonFromTeamEvent(new EventHandler<PersonTeamArgs>() {
				@Override
				public void onUpdate(final Object sender, final PersonTeamArgs eventArgs) {
					TeamPresenter.this.removePersonFromTeam(eventArgs.getTeam(), eventArgs.getPersons());
				}
			});

			this.view.defineNewTeamEvent(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TeamPresenter.this.newTeam();
				}
			});

			this.view.defineModifyTeamEvent(new EventHandler<PersonTeamArgs>() {
				@Override
				public void onUpdate(final Object sender, final PersonTeamArgs eventArgs) {
					TeamPresenter.this.editTeam(eventArgs.getTeam());
				}
			});

			this.view.defineVelocityChartEvent(new EventHandler<TypedEventArg<Team>>() {
				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Team> eventArgs) {
					TeamPresenter.this.startPresenter(new WidgetPresenter(TeamPresenter.this.getContext(),
							new VelocityChart(eventArgs.getObject()), "Velocitychart"));
				}
			});

			this.view.defineAddProjectsEvent(new EventHandler<TypedEventArg<Team>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Team> eventArgs) {
					if (eventArgs.getObject() != null) {
						TeamPresenter.this.startPresenter(new AddProjectToTeamPresenter(
								TeamPresenter.this.getContext(), eventArgs.getObject()));
					}
				}
			});
		}

		return this.view;
	}

	/**
	 * this method opens the function to create a new team. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.TeamCreatePresenter .
	 */
	private void newTeam() {
		final TeamCreatePresenter teamCreatePresenter = new TeamCreatePresenter(this.getContext());
		this.startPresenter(teamCreatePresenter);
	}

	/**
	 * this method opens the function to edit a team. The edit is done in the {@link}
	 * fhdw.ipscrum.client.presenter.TeamEditPresenter .
	 * 
	 * @param team
	 *            to edit
	 */
	private void editTeam(final Team team) {
		final TeamEditPresenter teamEditPresenter = new TeamEditPresenter(this.getContext(), team);
		this.startPresenter(teamEditPresenter);
	}

	/**
	 * this method opens the function to add persons to a team.
	 * 
	 * @param team
	 *            to add the persons to
	 * @param collection
	 *            the persons to add to the team
	 * 
	 */
	private void addPersonToTeam(final Team team, final Collection<Person> collection) {
		try {
			this.beginTransaction();
			for (final Person person : collection) {
				final TeamAddMemberCommand command = new TeamAddMemberCommand(team, person);
				this.doCommand(command);
			}
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this method opens the function to remove persons from a team.
	 * 
	 * @param team
	 *            to remove the persons from
	 * @param collection
	 *            the persons to remove from the team
	 * 
	 */
	private void removePersonFromTeam(final Team team, final Collection<Person> collection) {
		try {
			this.beginTransaction();
			for (final Person person : collection) {
				final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(team, person);
				this.doCommand(command);
			}
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager().getTeamAdminRight());
		this.view.updatePersonTableData(this.getContext().getModel().getAllPersons());
		this.view.updateTeamTreeData(this.getContext().getModel().getAllTeams());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
