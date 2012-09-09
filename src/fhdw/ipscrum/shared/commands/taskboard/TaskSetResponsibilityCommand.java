package fhdw.ipscrum.shared.commands.taskboard;

import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Associates a person to a task.
 */
public class TaskSetResponsibilityCommand extends Command<Void> implements ITaskboardCommand {

	/**
	 * represents the person responsible for the task.
	 */
	private String personId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskSetResponsibilityCommand() {
		super();
	}

	/**
	 * constructor of the TaskSetResponsibilityCommand.
	 * 
	 * @param task
	 *            to set the responsibility of
	 * @param person
	 *            to set responsible
	 */
	public TaskSetResponsibilityCommand(final Task task, final Person person) {
		super(task);
		this.personId = person.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Task task = (Task) model.getObject(this.getReceiverGuid());
		final Person person = (Person) model.getObject(this.personId);
		this.setStringValue(StringUtils.format("%s wurde dem Task '%s' zugeordnet.", person.toString(), task.getName()));
		task.setResponsibility(person);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTaskSetResponsibilityCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return ((Task) model.getObject(this.getReceiverGuid())).getProject();
	}
}
