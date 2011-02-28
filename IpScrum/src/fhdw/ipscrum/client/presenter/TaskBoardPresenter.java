package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.TaskboardView;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;

public class TaskBoardPresenter extends Presenter<ITaskboardView> {

	private ITaskboardView concreteView;
	
	public TaskBoardPresenter(Panel parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ITaskboardView createView() {
		this.concreteView = new TaskboardView();
		return this.concreteView;
	}

}
