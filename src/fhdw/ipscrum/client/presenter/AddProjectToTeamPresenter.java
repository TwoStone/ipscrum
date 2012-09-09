package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.viewinterfaces.IAddProjectToTeamView;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This class represents the presenter which controls the view to add projects to teams.
 */
public class AddProjectToTeamPresenter extends WritePresenter {

	/**
	 * represents the team related to this view. It is needed to make clear to which team the project should be added.
	 */
	private Team team;

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IAddProjectToTeamView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.AddProjectToTeamPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param team
	 *            is the related team which should be edited
	 */
	public AddProjectToTeamPresenter(final ClientContext context, final Team team) {
		super(context);
		this.team = team;
	}

	@Override
	public String getName() {
		return "Projekt Zuordnung";
	}

	@Override
	public IAddProjectToTeamView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createAddProjectToTeamView();

			this.view.registerDeleteProject(new EventHandler<TypedEventArg<Project>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Project> eventArgs) {
					AddProjectToTeamPresenter.this.addProject(eventArgs.getObject());

				}
			});
		}

		return this.view;
	}

	/**
	 * this method is needed to add a project to the team.
	 * 
	 * @param object
	 *            is the project to add
	 */
	protected void addProject(final Project object) {
		this.beginTransaction();
		try {
			this.doCommand(new TeamAddProjectCommand(this.team, object));
			this.commitTransaction();
			this.updateView();
		} catch (final IPScrumGeneralException e) {
			this.rollbackTransaction();
			this.toastMessage(e.getMessage());
		}
	}

	@Override
	public void updateView() {
		try {
			this.team = this.getContext().getModel().getObject(this.team);
		} catch (final NoObjectFindException e) {
			this.toastMessage(e.getMessage());
		}
		this.view.setAddedProjects(this.team.getProjects());
		this.view.setProjectsToAdd(this.getContext().getModel().getProjects());
	}

	@Override
	public void onModelUpdate() {
		this.team = this.updateObject(this.team);
		this.updateView();
	}

}
