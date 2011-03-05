package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
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

public class TaskBoardPresenter extends Presenter<ITaskboardView> {

	private ISprint sprint;

	public TaskBoardPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.addHandler();
	}

	private void addHandler() {

		this.getView().addSelectSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(final Object sender, final SprintArgs eventArgs) {
				TaskBoardPresenter.this.sprint = eventArgs.getSprint();
				TaskBoardPresenter.this.getView().setTaskboardVisibility(true);
				TaskBoardPresenter.this.refreshPBIs();
				TaskBoardPresenter.this.refreshTasks();
			}
		});

		this.getView().addNewTaskEventHandler(
				new EventHandler<MultiplePBIArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final MultiplePBIArgs eventArgs) {

						final DialogBox diaBox = new DialogBox();
						diaBox.setAnimationEnabled(true);
						diaBox.setText(TextConstants.CREATE_TASK);

						final CreateTaskPresenter tPresenter = new CreateTaskPresenter(
								diaBox, sprint.getSprintBacklog(), eventArgs
										.getPbis(), TaskBoardPresenter.this);

						diaBox.center();

						tPresenter.getFinished().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(Object sender,
											EventArgs eventArgs) {

											diaBox.hide();
									
											TaskBoardPresenter.this.refreshTasks();
									}
								});

						tPresenter.getAborted().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(final Object sender,
											final EventArgs eventArgs) {
										diaBox.hide();
									}
								});
					};
				});

		this.getView().addEditToDoTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(final Object sender, final TaskArgs eventArgs) {
				if (eventArgs.getTask() != null) {

					final DialogBox diaBox = new DialogBox();
					
					ToDoTaskDetailPresenter tPresenter = new ToDoTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask(), TaskBoardPresenter.this.sprint);

					diaBox.center();
					
					diaBox.setText(TextConstants.EDIT_TASK);
					
					tPresenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						diaBox.clear();	
						diaBox.hide();	
						}
					});
					
					
					tPresenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						
							refreshTasks();
						
							diaBox.clear();
							diaBox.hide();
						}
					});
					
				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});

		this.getView().addDeleteTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(final Object sender, final TaskArgs eventArgs) {

				if (eventArgs.getTask() != null) {
					
					TaskBoardPresenter.this.sprint.getSprintBacklog().removeTask(eventArgs.getTask());
					TaskBoardPresenter.this.refreshTasks();

				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});
		
		this.getView().addEditInProgressTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {
				if(eventArgs.getTask() != null){
					
					final DialogBox diaBox = new DialogBox();
					diaBox.setText(TextConstants.EDIT_TASK);
					
					InProgressTaskDetailPresenter presenter = new InProgressTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask(), sprint);
					
					diaBox.center();
					
					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							diaBox.clear();
							diaBox.hide();
						}
					});
					
					presenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							refreshTasks();
							diaBox.clear();
							diaBox.hide();
						}
					});
					
				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
				
			}
			
		});
		
		this.getView().addDetailsFinishEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {
			
				if(eventArgs.getTask() != null){
					
					final DialogBox diaBox = new DialogBox();
					diaBox.setText(TextConstants.EDIT_TASK);
					
					FinishTaskDetailPresenter presenter = new FinishTaskDetailPresenter(diaBox, TaskBoardPresenter.this, eventArgs.getTask());
					
					diaBox.center();
					
					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						diaBox.hide();
							
						}
					});
					
				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
				
			}
		});
		
	}

	@Override
	protected ITaskboardView createView() {
		final ITaskboardView concreteView = new TaskboardView();
		return concreteView;
	}

	private void refreshPBIs() {
		this.getView().refreshPBIs(this.sprint.getPBIs());
	}

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