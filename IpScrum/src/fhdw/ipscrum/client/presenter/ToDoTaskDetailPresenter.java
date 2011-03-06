package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.TodoTaskDetailVIew;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.client.view.interfaces.ITodoTaskDetailView;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.TaskUnassigned;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for {@link Task} with the state {@link TaskUnassigned} 
 * @author Phase III / Group I
 * This Class is a specialization of {@link TaskDetailPresenter}
 */
public class ToDoTaskDetailPresenter extends TaskDetailPresenter {

	// Variable to save the selected Sprint
	ISprint sprint;

	/**
	 * Creates a new instance of {@link ToDoTaskDetailPresenter}
	 * 
	 * Gives the team-members of the sprint to the view-class
	 * 
	 * @param parent
	 * @param parentPresenter
	 * @param task
	 * @param sprint
	 */
	public ToDoTaskDetailPresenter(Panel parent, Presenter<?> parentPresenter,
			ITask task, ISprint sprint) {
		super(parent, parentPresenter, task);
		this.sprint = sprint;
		this.getView().refreshPersons(sprint.getTeam().getMembers());
	}

	//adding specific handlers
	@Override
	protected void addSpecificHandler() {

		//Handler for the okayEvent
		//Refreshs the Task with the given informations from the view-class
		this.getView().addOkayEventHandler(
				new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
					
						try {
							// Sets the attributes of the task
							//Name
							ToDoTaskDetailPresenter.this.task.setName(getView()
									.getName());
							//Description
							ToDoTaskDetailPresenter.this.task
									.setDescription(getView().getDescription());
							//Effort
							ToDoTaskDetailPresenter.this.task.setPlanEffort(getView().getEffort());
							//Check if selected Person is null
							if (getView().getPerson() != null) {
								//Add a responsible person for the task
								ToDoTaskDetailPresenter.this.task
										.setResponsibility(getView()
												.getPerson());

							}
							
						} catch (ForbiddenStateException e) {
							// Displays an error if action not allowed cause of the state
							GwtUtils.displayError(e.getMessage());
						} catch (NoValidValueException e) {
							// Displays an error if the given informations from the view-class are not valid
							GwtUtils.displayError(e.getMessage());
						} catch (SprintAssociationException e) {
							// consistency error: displays an error if the person is not in the team of the sprint
							GwtUtils.displayError(e.getMessage());
						}
						// fire finish event for this presenter
						ToDoTaskDetailPresenter.this.finish();
					}
				});
	}

	@Override
	protected ITaskDetailView createView() {

		ITodoTaskDetailView view = new TodoTaskDetailVIew();
		return view;
	}

}
