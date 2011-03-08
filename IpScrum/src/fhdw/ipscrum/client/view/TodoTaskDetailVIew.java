package fhdw.ipscrum.client.view;

import fhdw.ipscrum.client.view.interfaces.ITodoTaskDetailView;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class TodoTaskDetailVIew extends TaskDetailView implements ITodoTaskDetailView {
	
	public TodoTaskDetailVIew() {
		super();
	}

	@Override
	public void initSpecificTaskView(ITask task) {

		if(task.getResponsiblePerson() != null){
			this.setPerson(task.getResponsiblePerson());
		}
		
		if(task.getPlanEffort() != null){
			this.setEffort(task.getPlanEffort());
		}
		
		this.getBtnCancel().setVisible(false);
		this.getLblTaskAbgeschlossen().setVisible(false);
		this.getSimpleCheckBox().setVisible(false);
	}





}
