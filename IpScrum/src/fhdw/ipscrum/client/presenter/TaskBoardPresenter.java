package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.TaskboardView;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for the taskboard
 * @author Phase III / Group I
 *
 */
public class TaskBoardPresenter extends Presenter<ITaskboardView> {

	// Thats a variable to save the selected sprint
	private ISprint sprint;

	/**
	 * Creates a new instance of {@link TaskBoardPresenter}
	 * @param parent
	 * @param parentPresenter
	 */
	public TaskBoardPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.addHandler();
	}

	/**
	 * This method is used to add any specific Event-Handler for the taskboard
	 */
	private void addHandler() {

		//Handler for SelectSprintEvent
		this.getView().addSelectSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(final Object sender, final SprintArgs eventArgs) {
				TaskBoardPresenter.this.sprint = eventArgs.getSprint();
				TaskBoardPresenter.this.getView().setTaskboardVisibility(true);
				TaskBoardPresenter.this.refreshPBIs();
				TaskBoardPresenter.this.refreshTasks();
			}
		});

		//Handler for addNewTaskEvent
		// Opens a Dialog
		this.getView().addNewTaskEventHandler(
				new EventHandler<MultiplePBIArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final MultiplePBIArgs eventArgs) {

						//Creating DialogBox
						final DialogBox diaBox = new DialogBox();
						diaBox.setAnimationEnabled(true);
						diaBox.setText(TextConstants.CREATE_TASK);

						//Creating CreateTaskPresenter
						final CreateTaskPresenter tPresenter = new CreateTaskPresenter(
								diaBox, sprint.getSprintBacklog(), eventArgs
										.getPbis(), TaskBoardPresenter.this);
						//Show the Dialog
						diaBox.center();

						// Handler for finished Event of the CreateTaskPresenter
						tPresenter.getFinished().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(Object sender,
											EventArgs eventArgs) {

											diaBox.hide();
									
											TaskBoardPresenter.this.refreshTasks();
									}
								});
						
						// Handler for abort Event of the CreateTaskPresenter
						tPresenter.getAborted().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(final Object sender,
											final EventArgs eventArgs) {
										diaBox.hide();
									}
								});	};});

		// Handler for editTodoTaskEvent
		// Opens a dialog
		this.getView().addEditToDoTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(final Object sender, final TaskArgs eventArgs) {
				
				//Check if selected task is null
				if (eventArgs.getTask() != null) {

					// Creates a new Dialog
					final DialogBox diaBox = new DialogBox();
					
					//Creates a TodoTaskDetailPresenter
					ToDoTaskDetailPresenter tPresenter = new ToDoTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask(), TaskBoardPresenter.this.sprint);

					// Shows the Dialog
					diaBox.center();
					
					diaBox.setText(TextConstants.EDIT_TASK);
					
					// Handler for abort Event of the TodoTaskDetailPresenter
					tPresenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						diaBox.clear();	
						diaBox.hide();	
						}
					});
					
					// Handler for finished Event of the TodoTaskDetailPresenter
					tPresenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						
							refreshTasks();
							diaBox.clear();
							diaBox.hide();
						}
					});
					
				} else {
					//If no task selected --> Display error
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}}});

		// Handler for deleteTaskEvent
		this.getView().addDeleteTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(final Object sender, final TaskArgs eventArgs) {
				
				// Check if the selected task isn´t null
				if (eventArgs.getTask() != null) {
					
					//Delete task
					TaskBoardPresenter.this.sprint.getSprintBacklog().removeTask(eventArgs.getTask());
					TaskBoardPresenter.this.refreshTasks();

				} else {
					// Display error if the task is null
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});
		
		//Handler for editInProgressTaskEvent
		//Opens a Dialog
		this.getView().addEditInProgressTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {
			
				// Check if the selected task is null
				if(eventArgs.getTask() != null){
					
					// Creates a DialogBox
					final DialogBox diaBox = new DialogBox();
					diaBox.setText(TextConstants.EDIT_TASK);
					
					//Creates a InProgressTaskDetailPresenter
					InProgressTaskDetailPresenter presenter = new InProgressTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask(), sprint);
					
					//Shows the Dialog
					diaBox.center();
					
					//Handler for abort-Event of the InProgressTaskDetailPresenter
					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							diaBox.clear();
							diaBox.hide();
						}
					});
					
					//Handler for the finish-Event of the InProgressTaskDetailPresenter
					presenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							refreshTasks();
							diaBox.clear();
							diaBox.hide();
						}
					});
					
				} else {
					//Displays an error if the selectedTask is null
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
				
			}
			
		});
		
		// Handler for the DetailsFinishTaskEvent
		//Opens a Dialog
		this.getView().addDetailsFinishTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {
			
				// Check if the selected task is null
				if(eventArgs.getTask() != null){
					
					//Creates a dialogBox
					final DialogBox diaBox = new DialogBox();
					diaBox.setText(TextConstants.EDIT_TASK);
					
					// Creates a FinishTaskDetailPresenter
					FinishTaskDetailPresenter presenter = new FinishTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask());
					
					//Shows the dialog
					diaBox.center();
					
					//Handler for the abort-Event of FinishTaskDetailPresenter
					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						diaBox.hide();
							
						}
					});
					
				} else {
					//Displays an error if the selected task is null
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
				
			}
		});
		
		this.getView().addTaskboardHelpEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
			
			DialogBox helpBox =	GwtUtils.createDialog(TextConstants.HELP);
			helpBox.setWidget(new Label(TextConstants.TASKBOARD_HELP));
			helpBox.setAutoHideEnabled(true);
			helpBox.setAnimationEnabled(true);
			helpBox.center();
		
			}
		});
		
	}

	@Override
	protected ITaskboardView createView() {
		final ITaskboardView concreteView = new TaskboardView();
		return concreteView;
	}
/**
 * Refresh the PBIs shown in taskboard. Only PBIs of the selected sprints are shown.
 */
	private void refreshPBIs() {
		this.getView().refreshPBIs(this.sprint.getPBIs());
	}

	
	/**
	 * Refreshs the ToDo-, InProgress- and FinishTask in the View-Class. Only Tasks for the selected Sprint are shown.
	 */
	private void refreshTasks() {
		Iterator<ITask> taskIt = this.sprint.getSprintBacklog().taskIterator();
		Vector<ITask> toDoTasks = new Vector<ITask>();
		Vector<ITask> inProgressTasks = new Vector<ITask>();
		Vector<ITask> finishTasks = new Vector<ITask>();

		while (taskIt.hasNext()) {
			
			ITask ct = taskIt.next();
			
			if(ct.isFinished()){
				finishTasks.add(ct);
			} else if (ct.hasResponsiblePerson()) {
				inProgressTasks.add(ct);
			} else {
				toDoTasks.add(ct);
			}
		}

		this.getView().refreshTodoTasks(toDoTasks);
		this.getView().refreshInProgressTasks(inProgressTasks);
		this.getView().refreshDoneTasks(finishTasks);
	}
}