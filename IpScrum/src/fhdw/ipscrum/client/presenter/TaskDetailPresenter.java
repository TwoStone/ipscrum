package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public abstract class TaskDetailPresenter extends Presenter<ITaskDetailView> {

	ITask task;
	
	public TaskDetailPresenter(Panel parent, Presenter<?> parentPresenter, ITask task) {
		super(parent, parentPresenter);
		this.task = task;
		this.getView().initTaskView(this.task);
		this.addHandler();
	}

	protected void addHandler(){
		
		this.getView().addCancelEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				TaskDetailPresenter.this.abort();
			}
		});
		
		this.addSpecificHandler();
	}
	
	protected abstract void addSpecificHandler();
}
