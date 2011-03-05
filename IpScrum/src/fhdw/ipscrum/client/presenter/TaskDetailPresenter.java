package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.TaskDetailView;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for details of {@link Task}
 * @author Phase III / Group I
 * 
 * This is an abstract class who adds general event-Handler for a {@link TaskDetailView}.
 * Independent by the state of the task.
 * The Template-Method pattern is used to add specific handlers.
 */

public abstract class TaskDetailPresenter extends Presenter<ITaskDetailView> {

	// Variable for the selected task
	ITask task;
	
	/**
	 * Creates a new instance of {@link TaskDetailPresenter}
	 * Initializes the view and adds calls the method addHandler();
	 * @param parent
	 * @param parentPresenter
	 * @param task
	 */
	public TaskDetailPresenter(Panel parent, Presenter<?> parentPresenter, ITask task) {
		super(parent, parentPresenter);
		this.task = task;
		this.getView().initTaskView(this.task);
		this.addHandler();
	}

	/**
	 * This method creates general handlers for the {@link TaskDetailView} independent by the task-state
	 * Calls also the method addSpecificHanler() which creates specific handlers.
	 */
	protected void addHandler(){
		
		this.getView().addCancelEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				TaskDetailPresenter.this.abort();
			}
		});
		
		this.addSpecificHandler();
	}
	
	/**
	 * This method creates specific handlers for {@link TaskDetailView} regarding to the task-state
	 * Every concrete specialization of {@link TaskDetailPresenter} have to implement this method 
	 */
	protected abstract void addSpecificHandler();
}
