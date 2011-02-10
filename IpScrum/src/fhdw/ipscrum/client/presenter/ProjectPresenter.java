package fhdw.ipscrum.client.presenter;

import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.ProjectView;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Project;

public class ProjectPresenter extends Presenter<IProjectView> {

	public ProjectPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IProjectView createView() {
		final IProjectView view = new ProjectView();
		
		view.addNewProjectEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				box.setGlassEnabled(true);
				CreateProjectPresenter presenter = new CreateProjectPresenter(box);
				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						view.refreshProjects(new Vector<Project>(SessionManager.getInstance().getModel().getProjects()));
						box.hide();
					}
				});
				box.center();
			}
		});
		
		view.addDeleteProjectEventHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				if(eventArgs.getProject()!=null){
					SessionManager.getInstance().getModel().removeProject(eventArgs.getProject());
					view.refreshProjects(new Vector<Project>(SessionManager.getInstance().getModel().getProjects()));
				}
			}
		});
		
		view.addProjectSelectionHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				view.getMasterProductBackloglPanel().clear();
				new ProductBacklogPresenter(view.getMasterProductBackloglPanel(), eventArgs.getProject());
			}
			
		});
		
		view.refreshProjects(new Vector<Project>(SessionManager.getInstance().getModel().getProjects()));
		
		return view;
	}
}
