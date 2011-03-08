package fhdw.ipscrum.client.view;

import com.google.gwt.i18n.client.DateTimeFormat;

import fhdw.ipscrum.client.view.interfaces.IFinishTaskDetailView;
import fhdw.ipscrum.shared.constants.TextConstants;
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
		DateTimeFormat fmt = DateTimeFormat.getFormat("EEEE, dd.MM.yyyy");
		
		this.getLblTaskFinished().setText(TextConstants.FINISHED_TASK + fmt.format(task.getFinishDate()));
	}
}
