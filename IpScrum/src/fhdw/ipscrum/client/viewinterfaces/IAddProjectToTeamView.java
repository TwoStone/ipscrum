package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * View interface required by
 * {@link fhdw.ipscrum.client.presenter.AddProjectToTeamPresenter}.
 */
public interface IAddProjectToTeamView extends IView {

	/**
	 * Displays the list of already added project.
	 * 
	 * @param projects
	 *            list of added projects
	 */
	void setAddedProjects(List<Project> projects);

	/**
	 * Displays the list of possibly added projects.
	 * 
	 * @param projects
	 *            list of possible added project
	 */
	void setProjectsToAdd(List<Project> projects);

	/**
	 * Registers the handler to the event when a project should be deleted.
	 * 
	 * @param handler
	 *            The handler that will get notified
	 */
	void registerDeleteProject(EventHandler<TypedEventArg<Project>> handler);
}
