package fhdw.ipscrum.shared.commands.taskboard;

import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new task.
 */
public class TaskCreateCommand extends Command<Task> implements ITaskboardCommand {

	/**
	 * represents the name of the task.
	 */
	private String name;

	/**
	 * represents the description of the task.
	 */
	private String description;

	/**
	 * represents the task ticket type of the task.
	 */
	private String taskTicketTypeId;

	/**
	 * represents the sprintBacklog related to the task.
	 */
	private String sprintBacklogId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskCreateCommand() {
		super();
	}

	/**
	 * constructor of the TaskCreateCommand.
	 * 
	 * @param name
	 *            of the new task
	 * @param description
	 *            of the new task
	 * @param taskTicketType
	 *            of the new task
	 * @param sprintBacklog
	 *            related to the new task
	 */
	public TaskCreateCommand(final String name, final String description, final TaskTicketType taskTicketType,
			final SprintBacklog sprintBacklog) {
		super();
		this.name = name;
		this.description = description;
		this.taskTicketTypeId = taskTicketType.getId();
		this.sprintBacklogId = sprintBacklog.getId();
	}

	@Override
	protected Task onExecute(final Model model) throws IPScrumGeneralException {
		final TaskTicketType taskTicketType = (TaskTicketType) model.getObject(this.taskTicketTypeId);
		final SprintBacklog sprintBacklog = (SprintBacklog) model.getObject(this.sprintBacklogId);
		this.setStringValue(StringUtils.format("Neuer Task '%s' vom Typ %s erstellt.", this.name,
				taskTicketType.getTypeName()));

		final Task task = new Task(model, taskTicketType, this.name, this.description, sprintBacklog);
		return task;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTaskCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		final SprintBacklog sbl = (SprintBacklog) model.getObject(this.sprintBacklogId);
		return sbl.getSprint().getProject();
	}

}
