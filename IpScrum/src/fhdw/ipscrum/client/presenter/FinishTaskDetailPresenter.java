package fhdw.ipscrum.client.presenter;

import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.FinishTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.IFinishTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class FinishTaskDetailPresenter extends TaskDetailPresenter {

	public FinishTaskDetailPresenter(Panel parent,
			Presenter<?> parentPresenter, ITask task) {
		super(parent, parentPresenter, task);
		Vector<IPerson> v = new Vector<IPerson>();
		v.add(task.getResponsiblePerson());
		this.getView().refreshPersons(v);
		this.getView().setPerson(task.getResponsiblePerson());
	}

	@Override
	protected void addSpecificHandler() {
		
	}

	@Override
	protected ITaskDetailView createView() {
		
		IFinishTaskDetailView view = new FinishTaskDetailView();
		
		return view;
	}

}
