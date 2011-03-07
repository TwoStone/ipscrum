package fhdw.ipscrum.client.view;

import fhdw.ipscrum.client.view.interfaces.IInProgressTaskDeailView;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class InProgressTaskDetailView extends TaskDetailView implements
		IInProgressTaskDeailView {

	public InProgressTaskDetailView() {
		super();
	}

	@Override
	public void initSpecificTaskView(ITask task) {
		this.getBtnAddPBIs().setVisible(false);
		this.getBtnDeletePBI().setVisible(false);
		this.getTxtBoxName().setReadOnly(true);
	}

}
