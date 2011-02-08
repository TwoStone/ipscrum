package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.shared.model.Project;

public interface IProjectView extends IView{

	public abstract HasClickHandlers getImgNewProject();
	public abstract HasClickHandlers getImgDeleteProject();
	public abstract Panel getMasterProductBackloglPanel();
	public abstract Panel getMasterReleasePanel();
	public abstract SingleSelectionModel<Project> getSelectedProject();
	public abstract void refreshProjects(Vector<Project> projects);
}
