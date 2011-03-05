package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.TodoTaskDetailVIew;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.client.view.interfaces.ITodoTaskDetailView;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class ToDoTaskDetailPresenter extends TaskDetailPresenter {

	ISprint sprint;

	public ToDoTaskDetailPresenter(Panel parent, Presenter<?> parentPresenter,
			ITask task, ISprint sprint) {
		super(parent, parentPresenter, task);
		this.sprint = sprint;
		this.getView().refreshPersons(sprint.getTeam().getMembers());
	}

	@Override
	protected void addSpecificHandler() {

		this.getView().addOkayEventHandler(
				new fhdw.ipscrum.client.events.EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						try {
							ToDoTaskDetailPresenter.this.task.setName(getView()
									.getName());
							ToDoTaskDetailPresenter.this.task
									.setDescription(getView().getDescription());

							ToDoTaskDetailPresenter.this.task.setPlanEffort(getView().getEffort());

							if (getView().getPerson() != null) {

								ToDoTaskDetailPresenter.this.task
										.setResponsibility(getView()
												.getPerson());

							}

						} catch (ForbiddenStateException e) {

							GwtUtils.displayError(e.getMessage());
						} catch (NoValidValueException e) {
							GwtUtils.displayError(e.getMessage());
						}
						ToDoTaskDetailPresenter.this.finish();
					}
				});
	}

	@Override
	protected ITaskDetailView createView() {

		ITodoTaskDetailView view = new TodoTaskDetailVIew();
		return view;
	}

}
