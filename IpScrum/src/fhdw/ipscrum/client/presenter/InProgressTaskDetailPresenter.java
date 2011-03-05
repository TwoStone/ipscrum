package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.InProgressTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.IInProgressTaskDeailView;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class InProgressTaskDetailPresenter extends TaskDetailPresenter {

	ISprint sprint;
	
	public InProgressTaskDetailPresenter(Panel parent,
			Presenter<?> parentPresenter, ITask task, ISprint sprint) {
		super(parent, parentPresenter, task);
		this.sprint = sprint;
		this.getView().refreshPersons(sprint.getTeam().getMembers());
		this.getView().setPerson(this.task.getResponsiblePerson());
	}

	@Override
	protected void addSpecificHandler() {
		
		this.getView().addOkayEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
			
				
				try {
					InProgressTaskDetailPresenter.this.task.setResponsibility(getView().getPerson());
					InProgressTaskDetailPresenter.this.task.setPlanEffort(getView().getEffort());
						
					if(getView().isFinished()){
						InProgressTaskDetailPresenter.this.task.finish();
					}
				
				} catch (ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
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
