package fhdw.ipscrum.client.presenter;

import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ProjectView;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Project;

/**
 * Presenter for {@link Project}
 * 
 * * @author Phase II / Gruppe I
 * 
 */
public class ProjectPresenter extends Presenter<IProjectView> {

	/**
	 * Creates a new instance of {@link ProductBacklogPresenter}
	 * 
	 * @param parent
	 */
	public ProjectPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IProjectView createView() {

		// Creates a new instance of a ProjectView
		final IProjectView view = new ProjectView();

		// Add a handler for a event which opens a dialog for creating new
		// projects
		view.addNewProjectEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				box.setGlassEnabled(true);
				CreateProjectPresenter presenter = new CreateProjectPresenter(
						box);

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						initialize();
						box.hide();
					}
				});
				box.center();
			}
		});

		// Add a handler for a event which delete the selected project
		view.addDeleteProjectEventHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				if (eventArgs.getProject() != null) {
					SessionManager.getInstance().getModel()
							.removeProject(eventArgs.getProject());
					initialize();
				} else {
					GwtUtils.displayError(TextConstants.NO_PROJECT_SELECTED);
				}
			}
		});

		// Add a handler for a event which opens the sprintoverview,
		// releaseoverview and productbacklog for a project
		view.addProjectSelectionHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				view.getMasterProductBackloglPanel().clear();
				view.getMasterReleasePanel().clear();
				view.getMasterSprintPanel().clear();

				new ReleasePresenter(view.getMasterReleasePanel(), eventArgs
						.getProject());
				new SprintPresenter(view.getMasterSprintPanel(), eventArgs
						.getProject());
				new ProductBacklogPresenter(view
						.getMasterProductBackloglPanel(), eventArgs
						.getProject());

			}

		});

		// Refills the table in 'view' with all existing projects
		view.refreshProjects(new Vector<Project>(SessionManager.getInstance()
				.getModel().getProjects()));

		return view;
	}
	
	/**
	 * Fills the cellTable of {@link ProjectView} with all existing projects 
	 */
	private void initialize(){
		this.getView().refreshProjects(new Vector<Project>(SessionManager
				.getInstance().getModel().getProjects()));
	}
}
