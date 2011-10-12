package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.viewinterfaces.ITaskboardView;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * This is to manage tasks of a sprint.
 */
public class TaskboardPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private ITaskboardView view;
	/**
	 * represents the project related to this presenter. It is needed to make clear for which project this taskboard is
	 * related to.
	 */
	@SuppressWarnings("unused")
	private final Project project;
	/**
	 * represents the sprint related to this view. It is needed to make clear for which sprint this taskboard is related
	 * to.
	 */
	private final Sprint sprint;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TaskboardPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param project
	 *            is the related project to which the taskboard is related
	 * @param sprint
	 *            is the sprint to which the taskboard is related
	 */
	public TaskboardPresenter(final ClientContext context, final Project project, final Sprint sprint) {
		super(context);
		this.project = project;
		this.sprint = sprint;
	}

	@Override
	public String getName() {
		return "Taskboard";
	}

	@Override
	public ITaskboardView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTaskboardView();

			this.view.registerNewTaskEventHandler(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TaskboardPresenter.this.startPresenter(new TaskCreatePresenter(
							TaskboardPresenter.this.getContext(), TaskboardPresenter.this.sprint));
				}
			});

			this.view.registerDetailsEventHandler(new EventHandler<TypedEventArg<Task>>() {
				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Task> eventArgs) {
					TaskboardPresenter.this.startPresenter(new GenericTicketPresenter(eventArgs.getObject(),
							TaskboardPresenter.this.getContext()));
				}
			});

		}

		return this.view;
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager().getTaskboardRight());
		this.fillTaskTables();
	}

	/**
	 * This method is needed to fill the tables of the taskboard.
	 */
	private void fillTaskTables() {
		final List<Task> allTasks = this.sprint.getSprintBacklog().getTasks();
		Collections.sort(allTasks, new Comparator<Task>() {
			@Override
			public int compare(final Task o1, final Task o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		this.fillOpenTaskTable(allTasks);
		this.fillInProgressTaskTable(allTasks);
		this.fillDoneTaskTable(allTasks);
	}

	/**
	 * this method is needed to fill the list of the still open tasks.
	 * 
	 * @param allTasks
	 *            of the sprint
	 */
	private void fillOpenTaskTable(final List<Task> allTasks) {
		final List<Task> filteredList = new ArrayList<Task>();
		for (final Task task : allTasks) {
			final StateType startState = task.getTicketType().getStateProfile().getStartState();
			if (task.getCurrentState().equals(startState)) {
				filteredList.add(task);
			}
		}
		this.view.fillOpenTaskTable(filteredList);
	}

	/**
	 * this method is needed to fill the list of the in progress tasks.
	 * 
	 * @param allTasks
	 *            of the sprint
	 */
	private void fillInProgressTaskTable(final List<Task> allTasks) {
		final List<Task> filteredList = new ArrayList<Task>();
		for (final Task task : allTasks) {
			final StateType startState = task.getTicketType().getStateProfile().getStartState();
			final List<StateType> endStates = task.getTicketType().getStateProfile().getEndStates();
			if (!task.getCurrentState().equals(startState) && !endStates.contains(task.getCurrentState())) {
				filteredList.add(task);
			}
		}
		this.view.fillInProgressTaskTable(filteredList);
	}

	/**
	 * this method is needed to fill the list of the finished tasks.
	 * 
	 * @param allTasks
	 *            of the sprint
	 */
	private void fillDoneTaskTable(final List<Task> allTasks) {
		final List<Task> filteredList = new ArrayList<Task>();
		for (final Task task : allTasks) {
			final List<StateType> endStates = task.getTicketType().getStateProfile().getEndStates();
			if (endStates.contains(task.getCurrentState())) {
				filteredList.add(task);
			}
		}
		this.view.fillDoneTaskTable(filteredList);
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
