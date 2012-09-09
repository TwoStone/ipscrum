package fhdw.ipscrum.shared.commands.taskboard;

import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Deletes a task.
 */
public class TaskDeleteCommand extends Command<Void> implements ITaskboardCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskDeleteCommand() {
		super();
	}

	/**
	 * Constructor of the TaskDeleteCommand.
	 * 
	 * @param task
	 *            to delete
	 */
	public TaskDeleteCommand(final Task task) {
		super(task);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Task task = (Task) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Task '%s' entfernt.", task.getName()));
		task.getSprintBacklog().removeTask(task);
		model.removeObject(task);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTaskDeleteCommand(this);
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
