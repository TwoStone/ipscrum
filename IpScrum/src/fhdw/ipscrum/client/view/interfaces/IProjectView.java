package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.shared.model.Project;

public interface IProjectView extends IView{

	public abstract HasClickHandlers getImgNewProject();
	public abstract HasClickHandlers getImgDeleteProject();
	public abstract Panel getMasterProductBackloglPanel();
	public abstract Panel getMasterReleasePanel();
	public abstract AbstractHasData<Project> getSelectedPBI();
	
}
