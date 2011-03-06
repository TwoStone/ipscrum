package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.InProgressTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.IInProgressTaskDeailView;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.TaskAssigned;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for {@link Task} with the state {@link TaskAssigned} 
 * @author Phase III / Group I
 * This Class is a specialization of {@link TaskDetailPresenter}
 */
public class InProgressTaskDetailPresenter extends TaskDetailPresenter {
	
	//Variable for the selected sprint
	ISprint sprint;
	
	/**
	 * Creates a new instance of {@link InProgressTaskDetailPresenter}
	 * 
	 * Gives the team-members of the sprint to the view-class and select the responsible person
	 * 
	 * @param parent
	 * @param parentPresenter
	 * @param task
	 * @param sprint
	 */
	public InProgressTaskDetailPresenter(Panel parent,
			Presenter<?> parentPresenter, ITask task, ISprint sprint) {
		super(parent, parentPresenter, task);
		this.sprint = sprint;
		this.getView().refreshPersons(sprint.getTeam().getMembers());
		this.getView().setPerson(this.task.getResponsiblePerson());
	}

	//Add specifc handlers
	@Override
	protected void addSpecificHandler() {
		
		// Handler for the OkayEvent
		// Refresh the task with the given informations from the view class
		this.getView().addOkayEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
			
				
				try {
					//set reponsible person
					InProgressTaskDetailPresenter.this.task.setResponsibility(getView().getPerson());
					
					// set effort
					InProgressTaskDetailPresenter.this.task.setPlanEffort(getView().getEffort());
						
					// check if the task is finished
					if(getView().isFinished()){
						// set the task to finish
						InProgressTaskDetailPresenter.this.task.finish();
					}
				
				} catch (ForbiddenStateException e) {
					// Displays an error if the action is not allowed cause of the Task-State
					GwtUtils.displayError(e.getMessage());
				}
				//Finishs the presenter
				InProgressTaskDetailPresenter.this.finish();
			}
		});
	}

	@Override
	protected ITaskDetailView createView() {
		IInProgressTaskDeailView view = new InProgressTaskDetailView();
		
		return view;
	}

}