package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.ProjectView;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.SessionManager;

public class ProjectPresenter extends Presenter<IProjectView> {

	public ProjectPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IProjectView createView() {
		final IProjectView view = new ProjectView();
		final Label dummy = new Label();
		
		view.addNewProjectEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				dummy.setText("New Project Click Event fired");
				view.getMasterProductBackloglPanel().add(dummy);
				view.getMasterReleasePanel().clear();
			}
		});
		
		view.addDeleteProjectEventHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				dummy.setText("Delete Project Click Event fired");
				view.getMasterReleasePanel().add(dummy);
				view.getMasterProductBackloglPanel().clear();
			}
		});
		
		view.addProjectSelectionHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				view.getMasterProductBackloglPanel().clear();
				new ProductBacklogPresenter(view.getMasterProductBackloglPanel(), eventArgs.getProject());
			}
			
		});
		
		view.refreshProjects(SessionManager.getInstance().getModel().getProjects());
		
		return view;
	}
}
