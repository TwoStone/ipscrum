package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.TaskboardView;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.constants.TextConstants;

public class TaskBoardPresenter extends Presenter<ITaskboardView> {

	private ITaskboardView concreteView;
	
	public TaskBoardPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected ITaskboardView createView() {
		this.concreteView = new TaskboardView();
	
		this.addHandler();
		
		return this.concreteView;
	}

	private void addHandler() {
		
		concreteView.addSelectSprintHandler(new EventHandler<SprintArgs>() {
			
			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				TaskBoardPresenter.this.concreteView.refreshPBIs(eventArgs.getSprint().getPBIs());	
			}
		});
		
		concreteView.addNewTaskEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				
				DialogBox diaBox = new DialogBox();
				diaBox.setAnimationEnabled(true);
				diaBox.setTitle(TextConstants.CREATE_TASK);
				
				new CreateTaskPresenter(diaBox, eventArgs.getPbi());
			}
		});
	}
}
