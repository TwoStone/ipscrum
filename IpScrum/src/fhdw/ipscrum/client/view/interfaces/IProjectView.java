package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.ReleaseView;
import fhdw.ipscrum.client.view.SprintView;
import fhdw.ipscrum.shared.model.Project;

/**
 * @author Phase II / Gruppe I
 * 
 */
public interface IProjectView extends IView {

	/**
	 * Method addNewProjectEventHandler Use this to register a handler for an
	 * event which opens a new dialog to create a new {@link Project}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addNewProjectEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method addDeleteProjectEventHandler Use this to register a handler for an
	 * event which deletes a {@link Project}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addDeleteProjectEventHandler(
			EventHandler<ProjectEventArgs> arg);

	public void addEditProjectEvent(EventHandler<ProjectEventArgs> handler);

	/**
	 * Method addProjectSelectionEventHandler Use this to register a handler for
	 * an event which opens the {@link ProductBacklogView}, the
	 * {@link ReleaseView} and the {@link SprintView} for the selected
	 * {@link Project}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addProjectSelectionHandler(
			EventHandler<ProjectEventArgs> arg);

	/**
	 * Method getMasterProductBacklogPanel Returns the MasterProductBacklogPanel
	 * 
	 * @return Panel
	 */
	public abstract Panel getMasterProductBackloglPanel();

	/**
	 * Method getMasterReleasePanel Returns the MasterReleasePanel
	 * 
	 * @return Panel
	 */
	public abstract Panel getMasterReleasePanel();

	/**
	 * Method getMasterSprintPanel Returns the MasterSprintPanel
	 * 
	 * @return Panel
	 */
	public abstract Panel getMasterSprintPanel();

	/**
	 * Method getMasterSprintProductBacklogPanel Returns the
	 * MasterSprintProductBacklogPanel
	 * 
	 * @return Panel
	 */
	public abstract Panel getMasterSprintProductBackloglPanel();

	/**
	 * Method refreshProjects Refreshes the projects
	 * 
	 * @param projects
	 */
	public abstract void refreshProjects(Vector<Project> projects);
}
