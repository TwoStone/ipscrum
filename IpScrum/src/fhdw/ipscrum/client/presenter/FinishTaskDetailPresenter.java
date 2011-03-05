package fhdw.ipscrum.client.presenter;

import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.FinishTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.IFinishTaskDetailView;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.TaskFinished;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for {@link Task} with the state {@link TaskFinished} 
 * @author Phase III / Group I
 * This Class is a specialization of {@link TaskDetailPresenter}
 */
public class FinishTaskDetailPresenter extends TaskDetailPresenter {

	/**
	 * Creates a new instance of {@link FinishTaskDetailPresenter}
	 * 
	 * Gives the responsible person of the task for the view class
	 * 
	 * @param parent
	 * @param parentPresenter
	 * @param task
	 */
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
		// there are no specific handlers are the moment for FinishTaskDetailView
	}

	@Override
	protected ITaskDetailView createView() {
		
		IFinishTaskDetailView view = new FinishTaskDetailView();
		
		return view;
	}

}
