package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.ProjectView;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.SessionManager;

public class ProjectPresenter extends Presenter<IProjectView> {

	public ProjectPresenter(Panel parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IProjectView createView() {
		final IProjectView view = new ProjectView();
		final Label dummy = new Label();
		
		view.getImgNewProject().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				dummy.setText("New Project Click Event fired");
				view.getMasterProductBackloglPanel().add(dummy);
				view.getMasterReleasePanel().clear();
			}
			
		});
		
		view.getImgDeleteProject().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				dummy.setText("Delete Project Click Event fired");
				view.getMasterReleasePanel().add(dummy);
				view.getMasterProductBackloglPanel().clear();
			}
		});
		
		view.refreshProjects(SessionManager.getInstance().getModel().getProjects());
		
		return view;
	}
}