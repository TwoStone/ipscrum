package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
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
				TaskBoardPresenter.this.concreteView.refreshPBIs(eventArgs
						.getSprint().getPBIs());
			}
		});

		concreteView.addNewTaskEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {

					final DialogBox diaBox = new DialogBox();
					diaBox.setAnimationEnabled(true);
					diaBox.setText(TextConstants.CREATE_TASK);

					CreateTaskPresenter tPresenter = new CreateTaskPresenter(
							diaBox, eventArgs.getPbi());

					diaBox.center();

					tPresenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
							diaBox.hide();
						}
					});
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}
			};
		});

		concreteView.addEditTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {
				if (eventArgs.getTask() != null) {

					// TODO: new EditTaskPresenter

				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});

		concreteView.addDeleteTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(Object sender, TaskArgs eventArgs) {

				if (eventArgs.getTask() != null) {
					// TODO: Delete TASk

				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});

		concreteView.addPrioTopEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach ganz oben
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		concreteView.addPrioUpEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach oben
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		concreteView.addPrioDownEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach unten
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		concreteView.addPrioBottomEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach ganz unten
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}
			}
		});
	}
}
