package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.CreateTaskView;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class CreateTaskPresenter extends Presenter<ICreateTaskView> {

	private ProductBacklogItem pbi;
	
	public CreateTaskPresenter(Panel parent, ProductBacklogItem pbi) {
		super(parent);
	this.pbi = pbi;
	}

	@Override
	protected ICreateTaskView createView() {
		final ICreateTaskView concreteView = new CreateTaskView();
		
		concreteView.refreshNameBox(pbi.getSprint().getTeam().getMembers());
		
		concreteView.addSaveNewTaskEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				
				// TODO: TASK zum pbi hinzufügen
				
			}
		});
		
		this.finish();
		
		concreteView.addCancelNewTaskEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateTaskPresenter.this.abort();
			}
		});
		
		return concreteView;
	}

	
	
}
