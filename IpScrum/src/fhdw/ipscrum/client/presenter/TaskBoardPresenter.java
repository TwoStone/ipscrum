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

	public TaskBoardPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
	}

	private void addHandler() {

		this.concreteView
				.addSelectSprintHandler(new EventHandler<SprintArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final SprintArgs eventArgs) {
						TaskBoardPresenter.this.concreteView
								.refreshPBIs(eventArgs.getSprint().getPBIs());
					}
				});

		this.concreteView.addNewTaskEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {

					final DialogBox diaBox = new DialogBox();
					diaBox.setAnimationEnabled(true);
					diaBox.setText(TextConstants.CREATE_TASK);

					final CreateTaskPresenter tPresenter = new CreateTaskPresenter(
							diaBox, eventArgs.getPbi(), TaskBoardPresenter.this);

					diaBox.center();

					tPresenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							diaBox.hide();
						}
					});
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}
			};
		});

		this.concreteView.addEditTaskEventHandler(new EventHandler<TaskArgs>() {

			@Override
			public void onUpdate(final Object sender, final TaskArgs eventArgs) {
				if (eventArgs.getTask() != null) {

					// TODO: new EditTaskPresenter

				} else {
					GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
				}
			}
		});

		this.concreteView
				.addDeleteTaskEventHandler(new EventHandler<TaskArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final TaskArgs eventArgs) {

						if (eventArgs.getTask() != null) {
							// TODO: Delete TASk

						} else {
							GwtUtils.displayError(TextConstants.NO_TASK_SELECTED);
						}
					}
				});

		this.concreteView.addPrioTopEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach ganz oben
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		this.concreteView.addPrioUpEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach oben
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		this.concreteView.addPrioDownEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {

				if (eventArgs.getPbi() != null) {
					// TODO: PBI nach unten
				} else {
					GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
				}

			}
		});

		this.concreteView
				.addPrioBottomEventHandler(new EventHandler<PBIArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final PBIArgs eventArgs) {

						if (eventArgs.getPbi() != null) {
							// TODO: PBI nach ganz unten
						} else {
							GwtUtils.displayError(TextConstants.NO_PBI_SELECTED);
						}
					}
				});
	}

	@Override
	protected ITaskboardView createView() {
		this.concreteView = new TaskboardView();

		this.addHandler();

		return this.concreteView;
	}
}
