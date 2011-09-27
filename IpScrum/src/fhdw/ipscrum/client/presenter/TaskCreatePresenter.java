package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.view.TaskCreateView;
import fhdw.ipscrum.client.view.TaskCreateView.TaskCreateArgs;
import fhdw.ipscrum.client.viewinterfaces.ITaskCreateView;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * this is to create a new task.
 */
public class TaskCreatePresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ITaskCreateView view;
	/**
	 * represents a flag to check if the question asking if the view should been left without saving should be asked.
	 */
	private boolean saved = false;

	/**
	 * represents an eventArg which is needed for creating tasks.
	 */
	private TaskCreateArgs taskCreateArgs;
	/**
	 * represents the sprint related to this presenter. It is needed to make clear for which sprint this task should be
	 * created.
	 */
	private final Sprint sprint;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TaskCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param sprint
	 *            is the related sprint in which the task should be created
	 */
	public TaskCreatePresenter(final ClientContext context, final Sprint sprint) {
		super(context);
		this.sprint = sprint;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Neuen Task erstellen";
	}

	@Override
	public ITaskCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTaskCreateView();

			this.view.registerSaveEvent(new EventHandler<TaskCreateView.TaskCreateArgs>() {

				@Override
				public void onUpdate(final Object sender, final TaskCreateArgs eventArgs) {
					TaskCreatePresenter.this.taskCreateArgs = eventArgs;
					TaskCreatePresenter.this.save();
					TaskCreatePresenter.this.close();
				}
			});

			this.view.registerCancelEvent(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TaskCreatePresenter.this.close();
				}
			});

		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			final TaskTicketType ticketType =
					(TaskTicketType) this.getContext().getModel().getTypeManager()
							.getActiveTicketTypeByUniqueName(this.taskCreateArgs.getSelectedTaskTicketType());
			this.doCommand(new TaskCreateCommand(this.taskCreateArgs.getName(), this.taskCreateArgs.getDescription(),
					ticketType, this.sprint.getSprintBacklog()));
			this.commitTransaction();
			this.saved = true;
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			return false;
		}
	}

	@Override
	protected void onClose(final CloseCallback callback) {
		if (!this.saved) {
			this.showQuestion("Möchten Sie die Eingaben verwerfen?", new Answer("Ja") {

				@Override
				public void onAction(final QuestionDialog widget) {
					widget.hide();
					callback.closed();
				}
			}, new Answer("Nein") {

				@Override
				public void onAction(final QuestionDialog widget) {
					widget.hide();
					callback.closeAborted();
				}
			});
		} else {
			callback.closed();
		}
	}

	@Override
	public void updateView() {
		final List<TaskTicketType> list = this.getContext().getModel().getAllTaskTicketTypes();
		this.view.fillComboBoxTypes(list);
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
