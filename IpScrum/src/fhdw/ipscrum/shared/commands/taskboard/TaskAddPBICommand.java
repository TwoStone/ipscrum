package fhdw.ipscrum.shared.commands.taskboard;

import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Adds a product backlog item to a task.
 */
public class TaskAddPBICommand extends Command<Void> implements ITaskboardCommand {

	/**
	 * represents the pbi to add.
	 */
	private String pbiId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskAddPBICommand() {
		super();
	}

	/**
	 * constructor of the TaskAddPBICommand.
	 * 
	 * @param task
	 *            attached
	 * @param pbi
	 *            to add
	 */
	public TaskAddPBICommand(final Task task, final ProductBacklogItem pbi) {
		super(task);
		this.pbiId = pbi.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Task task = (Task) model.getObject(this.getReceiverGuid());
		final ProductBacklogItem pbi = (ProductBacklogItem) model.getObject(this.pbiId);
		this.setStringValue(StringUtils.format(
				"Task '%s' wurde das PBI %s hinzugefügt.", task.getName(),
				pbi.getName()));
		task.addPBI(pbi);
		return null;
	}

	@Override
	public void accept(final CommandVisitor visitor) {
		visitor.handleTaskAddPBICommand(this);
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
