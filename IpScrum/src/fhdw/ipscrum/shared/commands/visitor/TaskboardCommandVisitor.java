package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;

/**
 * Visitor for Task board commands.
 */
public interface TaskboardCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param taskAddPBICommand
	 *            concrete command.
	 */
	void handleTaskAddPBICommand(TaskAddPBICommand taskAddPBICommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskCreateCommand
	 *            concrete command.
	 */
	void handleTaskCreateCommand(TaskCreateCommand taskCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskDeleteCommand
	 *            concrete command.
	 */
	void handleTaskDeleteCommand(TaskDeleteCommand taskDeleteCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskRemovePBICommand
	 *            concrete command.
	 */
	void handleTaskRemovePBICommand(TaskRemovePBICommand taskRemovePBICommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskSetPlanEffortCommand
	 *            concrete command.
	 */
	void handleTaskSetPlanEffortCommand(
			TaskSetPlanEffortCommand taskSetPlanEffortCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskSetResponsibilityCommand
	 *            concrete command.
	 */
	void handleTaskSetResponsibilityCommand(
			TaskSetResponsibilityCommand taskSetResponsibilityCommand);
}
