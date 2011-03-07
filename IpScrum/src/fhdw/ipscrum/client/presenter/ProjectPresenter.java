package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;
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
import fhdw.ipscrum.shared.model.System;

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
	 * @param parentPresenter
	 */
	public ProjectPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
	}

	@Override
	protected IProjectView createView() {

		// Creates a new instance of a ProjectView
		final IProjectView view = new ProjectView();

		// Add a handler for a event which opens a dialog for creating new
		// projects
		view.addNewProjectEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				box.setGlassEnabled(true);
				final CreateProjectPresenter presenter = new CreateProjectPresenter(
						box, ProjectPresenter.this);

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						box.hide();
					}
				});

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						ProjectPresenter.this.initialize();
						box.hide();
					}
				});
				box.center();
			}
		});

		// Add a handler for a event which delete the selected project
		view.addDeleteProjectEventHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(final Object sender,
					final ProjectEventArgs eventArgs) {
				if (eventArgs.getProject() != null) {
					SessionManager.getInstance().getModel()
							.removeProject(eventArgs.getProject());
					ProjectPresenter.this.initialize();
				} else {
					GwtUtils.displayError(TextConstants.NO_PROJECT_SELECTED);
				}
			}
		});

		view.addEditProjectEvent(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(final Object sender,
					final ProjectEventArgs eventArgs) {
				final Project project = eventArgs.getProject();
				final DialogBox box = GwtUtils.createDialog("Systeme von "
						+ project.getName());
				final List<System> list = new ArrayList<System>();
				list.addAll(project.getPossibleSystems());
				final Presenter<?> presenter = new SelectSystemPresenter(box,
						ProjectPresenter.this, list, ProjectPresenter.this
								.getSessionManager().getModel().getSysManager()
								.getSystems().getSystems());
				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						for (final System system : list) {
							if (!project.getPossibleSystems().contains(system)) {
								project.addPossibleSystem(system);
							}
						}
					}
				});

				// TODO dialog wieder schließen bei abbrechen

				box.center();
			}
		});

		// Add a handler for a event which opens the sprintoverview,
		// releaseoverview and productbacklog for a project
		view.addProjectSelectionHandler(new EventHandler<ProjectEventArgs>() {

			@Override
			public void onUpdate(final Object sender,
					final ProjectEventArgs eventArgs1) {
				view.getMasterProductBackloglPanel().clear();
				view.getMasterReleasePanel().clear();
				view.getMasterSprintPanel().clear();

				final ReleasePresenter rel = new ReleasePresenter(view
						.getMasterReleasePanel(), eventArgs1.getProject(),
						ProjectPresenter.this);

				rel.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						new SprintPresenter(view.getMasterSprintPanel(),
								eventArgs1.getProject(), ProjectPresenter.this);
						new ProductBacklogPresenter(view
								.getMasterProductBackloglPanel(), eventArgs1
								.getProject(), ProjectPresenter.this);
					}

				});

				new SprintPresenter(view.getMasterSprintPanel(), eventArgs1
						.getProject(), ProjectPresenter.this);
				new ProductBacklogPresenter(view
						.getMasterProductBackloglPanel(), eventArgs1
						.getProject(), ProjectPresenter.this);

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
	private void initialize() {
		this.getView().refreshProjects(
				new Vector<Project>(SessionManager.getInstance().getModel()
						.getProjects()));
	}
}
