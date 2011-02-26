package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SprintView;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.client.view.widgets.SprintBurndownChart;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Sprint;

/**
 * Presenter for {@link Sprint}
 * 
 * @author Phase II / Gruppe I
 *
 */
public class SprintPresenter extends Presenter<ISprintView>{

	private ISprintView concreteView;
	private final Project project;


	/**
	 * Creates a new instance of {@link SprintPresenter}
	 * 
	 * @param parent
	 * @param project
	 */
	public SprintPresenter(Panel parent, Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	/**
	 * Fills the widget {@linkSprintTableView} in the {@link SprintView} with all existing sprints for the selected project
	 */
	private void initialize() {
		if (this.project.getReleasePlan() != null) {
			this.getView().refreshSprints(this.project.getSprints());
		}
	}

	@Override
	protected ISprintView createView() {

		// New instance of SprintView
		this.concreteView = new SprintView();

		// Add a handler for the event which opens a dialog to create new sprint
		this.concreteView.addNewSprintEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final SprintDialogPresenter presenter = new SprintDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setGlassEnabled(true);
				box.setText(TextConstants.CREATE_NEW_SPRINT);

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						try {
							SprintPresenter.this.project.addSprint(presenter.getSprint());
							SprintPresenter.this.initialize();
							box.hide();
						} catch (DoubleDefinitionException e) {
							GwtUtils.displayError(e.getMessage());
						}
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});


		// Add a handler for the event which opens a dialog for editing an existing sprint
		this.concreteView.addSprintDetailsEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				if(eventArgs.getSprint()!=null){
					final DialogBox box = new DialogBox();
					final SprintDialogPresenter presenter = new SprintDialogPresenter(box, eventArgs.getSprint());
					box.setAnimationEnabled(true);
					box.setGlassEnabled(true);
					box.setText("Sprint " + eventArgs.getSprint().getName() + " bearbeiten");

					presenter.getFinished().add(new EventHandler<EventArgs>() {
						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							SprintPresenter.this.initialize();
							box.hide();
						}
					});

					presenter.getAborted().add(new EventHandler<EventArgs>() {
						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							box.hide();
						}
					});
					box.center();
				} else {
					GwtUtils.displayError(TextConstants.NO_SPRINT_SELECTED);
				}
			}
		});

		// Adding a handler for the event of chart-displaying
		this.concreteView.addShowChartEventHandler(new EventHandler<SprintArgs>() {
			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				DialogBox box = new DialogBox();
				box.setAutoHideEnabled(true); // thats okay because no separate presenter will be created
				box.setAnimationEnabled(true);
				box.setGlassEnabled(true);
				box.setText(TextConstants.CHARTPOPUP_TITLE);
				box.add(new SprintBurndownChart(eventArgs.getSprint(), 300, 200));
				box.center();
			}
		});

		// Add a handler for the event which should delete the selected sprint
		// This function is not implementated now
		this.concreteView.addDeleteSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				GwtUtils.displayError(TextConstants.SPRINT_DELETE_NOT_ALLOWED);
			}
		});

		return this.concreteView;

	}


}