package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * This class represents the presenter which controls the view to create and switch to
 * projects.
 */
public class ProjectSelectionPresenter extends ReadPresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.ProjectSelectionView).
	 */
	public static interface IProjectSelectionView extends IView {

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing projects.
		 * 
		 * @param projects
		 *            are the existing projects
		 */
		void setProjects(List<Project> projects);

		/**
		 * Represents the Event to handle the switch to the project details.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the switch, and also knows the project to
		 *         switch to
		 */
		EventRegistration registerGotoProjectHandler(
				EventHandler<TypedEventArg<Project>> handler);

		/**
		 * Represents the Event to handle the creation of a new project.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles to create a new project
		 */
		EventRegistration registerNewProjectHandler(DefaultEventHandler handler);
	}

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private IProjectSelectionView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.PersonRolePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public ProjectSelectionPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Projektübersicht";
	}

	@Override
	public IProjectSelectionView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createProjectSelectionView();
			this.view
					.registerGotoProjectHandler(new EventHandler<TypedEventArg<Project>>() {

						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Project> eventArgs) {
							ProjectSelectionPresenter.this.gotoProject(eventArgs
									.getObject());
						}
					});
			this.view.registerNewProjectHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectSelectionPresenter.this.newProject();
				}
			});
		}
		return this.view;
	}

	/**
	 * this method opens the function to create a new project. The creation is done in the
	 * {@link} fhdw.ipscrum.client.presenter.ProjectCreatePresenter .
	 */
	private void newProject() {
		final ProjectCreatePresenter projectCreatePresenter =
				new ProjectCreatePresenter(this.getContext());
		this.startPresenter(projectCreatePresenter);
	}

	/**
	 * this method is needed to switch to a selected project.
	 * 
	 * @param object
	 *            is the project to show the details of
	 */
	private void gotoProject(final Project object) {
		this.startPresenter(new ProjectDisplayPresenter(this.getContext(), object));
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager()
				.getProjectRight());
		this.getView().setProjects(this.getContext().getModel().getProjects());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
