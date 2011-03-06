package fhdw.ipscrum.client.view;

import fhdw.ipscrum.client.view.interfaces.IFinishTaskDetailView;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class FinishTaskDetailView extends TaskDetailView implements
		IFinishTaskDetailView {

	
	public FinishTaskDetailView() {
		super();
	}
	
	@Override
	public void initSpecificTaskView(ITask task) {
		this.getBtnAddPBIs().setVisible(false);
		this.getBtnDeletePBI().setVisible(false);
		this.getTxtBoxName().setReadOnly(true);
		this.getTxtAreaDescription().setReadOnly(true);
		this.getIBoxEffort().setReadOnly(true);
		this.getLblTaskAbgeschlossen().setVisible(false);
		this.getSimpleCheckBox().setVisible(false);
		this.getBtnOkay().setVisible(false);
		this.getLblTaskFinished().setVisible(true);
	}
}
