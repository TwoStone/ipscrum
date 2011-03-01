package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.CreateTaskView;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class CreateTaskPresenter extends Presenter<ICreateTaskView> {

	private ProductBacklogItem pbi;
	private ICreateTaskView concreteView;
	
	public CreateTaskPresenter(Panel parent, ProductBacklogItem pbi) {
		super(parent);
		this.pbi = pbi;
		initzialize();
	}

	private void initzialize() {
		concreteView.refreshNameBox(pbi.getSprint().getTeam().getMembers());
	}

	@Override
	protected ICreateTaskView createView() {
		this.concreteView = new CreateTaskView();
		
		concreteView.addSaveNewTaskEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				
				// TODO: TASK zum pbi hinzufügen
				
			}
		});
		
		concreteView.addCancelNewTaskEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateTaskPresenter.this.abort();
			}
		});
		
		return concreteView;
	}

	
	
}
