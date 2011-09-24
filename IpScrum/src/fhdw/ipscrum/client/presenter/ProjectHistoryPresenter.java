package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.viewinterfaces.IProjectHistoryView;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * This class represents the presenter which controls the view to show the project history and administer incidents.
 */
public class ProjectHistoryPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private IProjectHistoryView view;

	/**
	 * represents the project related to this view. It is needed to make clear for which project this is the project
	 * history.
	 */
	private final Project project;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ProjectHistoryPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param project
	 *            is the related project to which the project history is related
	 */
	public ProjectHistoryPresenter(final ClientContext context, final Project project) {
		super(context);
		this.project = project;
	}

	@Override
	public String getName() {
		return "Projekthistorie";
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createProjectHistoryView();

			this.view.addcreateIncidentHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectHistoryPresenter.this.createIncident();
				}
			});

			this.view.addcreateTypeHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectHistoryPresenter.this.createType();
				}
			});

			this.view.addchangeTypHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectHistoryPresenter.this.changeType();
				}
			});

		}

		return this.view;
	}

	/**
	 * this method is needed to change the type of an incident in the project history.
	 */
	private void changeType() {
		this.toastMessage("Ändern von Ereignis-Typen ist bisher noch nicht vorgesehen.");
	}

	/**
	 * this method opens the function to create a new incident type. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.IncidentTypeCreatePresenter .
	 */
	private void createType() {
		final IncidentTypeCreatePresenter presenter = new IncidentTypeCreatePresenter(this.getContext());
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to create a new incident. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.CreateIncidentPresenter .
	 */
	private void createIncident() {
		final CreateIncidentPresenter presenter = new CreateIncidentPresenter(this.getContext());
		this.startPresenter(presenter);
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager().getProjectHistoryRight());
		this.view.refreshProjectHistoryTable(this.getContext().getModel().getIncidentsByProject(this.project));
		this.view.refreshTypes(this.getContext().getModel().getAllIncidentTypes());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
