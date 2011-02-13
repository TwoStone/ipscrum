package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.shared.model.Project;

public interface IProjectView extends IView{

	public abstract void addNewProjectEventHandler(EventHandler<EventArgs> arg);
	public abstract void addDeleteProjectEventHandler(EventHandler<ProjectEventArgs> arg);
	public abstract void addProjectSelectionHandler(EventHandler<ProjectEventArgs> arg);
	
	public abstract Panel getMasterProductBackloglPanel();
	public abstract Panel getMasterReleasePanel();
	public abstract Panel getMasterSprintPanel();
	public abstract Panel getMasterSprintProductBackloglPanel();
	
	
	
	public abstract void refreshProjects(Vector<Project> projects);
}
