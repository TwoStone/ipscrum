package fhdw.ipscrum.shared.commands.taskboard;

import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Sets the planned effort of a task.
 */
public class TaskSetPlanEffortCommand extends Command<Void> implements ITaskboardCommand {

	/**
	 * represents the plan effort of the task.
	 */
	private Effort effort;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskSetPlanEffortCommand() {
		super();
	}

	/**
	 * constructor of the TaskSetPlanEffortCommand.
	 * 
	 * @param task
	 *            attached
	 * @param effort
	 *            to set at the command
	 */
	public TaskSetPlanEffortCommand(final Task task, final Effort effort) {
		super(task);
		this.effort = effort;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Task task = (Task) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Geplanter Aufwand für Task '%s' auf %s gesetzt.", task.getName(),
				this.effort.getValue()));
		task.setPlanEffort(this.effort);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTaskSetPlanEffortCommand(this);
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
