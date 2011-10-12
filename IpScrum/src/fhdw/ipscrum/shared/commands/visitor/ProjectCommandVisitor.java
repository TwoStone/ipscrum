package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand;
import fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand;
import fhdw.ipscrum.shared.commands.project.SprintChangeCommand;
import fhdw.ipscrum.shared.commands.project.SprintCreateCommand;

/**
 * Visitor for project-related commands.
 */
public interface ProjectCommandVisitor {

	/**
	 * specific visitor action.
	 * 
	 * @param projectAddSystemCommand
	 *            concrete command.
	 */
	void handleProjectAddSystemCommand(ProjectAddSystemCommand projectAddSystemCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param projectChangeNameCommand
	 *            concrete command.
	 */
	void handleProjectChangeNameCommand(ProjectChangeNameCommand projectChangeNameCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param projectCreateCommand
	 *            concrete command.
	 */
	void handleProjectCreateCommand(ProjectCreateCommand projectCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param projectDeleteCommand
	 *            concrete command.
	 */
	void handleProjectDeleteCommand(ProjectDeleteCommand projectDeleteCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param projectRemoveSystemCommand
	 *            concrete command.
	 */
	void handleProjectRemoveSystemCommand(ProjectRemoveSystemCommand projectRemoveSystemCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseAddSprintCommand
	 *            concrete command.
	 */
	void handleReleaseAddSprintCommand(ReleaseAddSprintCommand releaseAddSprintCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseCreateCommand
	 *            concrete command.
	 */
	void handleReleaseCreateCommand(ReleaseCreateCommand releaseCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseDeleteCommand
	 *            concrete command.
	 */
	void handleReleaseDeleteCommand(ReleaseDeleteCommand releaseDeleteCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseRemoveSprintCommand
	 *            concrete command.
	 */
	void handleReleaseRemoveSprintCommand(ReleaseRemoveSprintCommand releaseRemoveSprintCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param sprintChangeCommand
	 *            concrete command.
	 */
	void handleSprintChangeCommand(SprintChangeCommand sprintChangeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param sprintCreateCommand
	 *            concrete command.
	 */
	void handleSprintCreateCommand(SprintCreateCommand sprintCreateCommand);

}
