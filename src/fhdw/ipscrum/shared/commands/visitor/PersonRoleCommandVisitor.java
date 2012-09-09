package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand;

/**
 * visitor for person and role commands.
 */
public interface PersonRoleCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param personAddRoleCommand
	 *            specific command.
	 */
	void handlePersonAddRoleCommand(PersonAddRoleCommand personAddRoleCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param personChangeNameCommand
	 *            specific command.
	 */
	void handlePersonChangeNameCommand(PersonChangeNameCommand personChangeNameCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param personCreateCommand
	 *            specific command.
	 */
	void handlePersonCreateCommand(PersonCreateCommand personCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param personRemoveRoleCommand
	 *            specific command.
	 */
	void handlePersonRemoveRoleCommand(PersonRemoveRoleCommand personRemoveRoleCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param roleCreateCommand
	 *            specific command.
	 */
	void handleRoleCreateCommand(RoleCreateCommand roleCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param roleDeleteCommand
	 *            specific command.
	 */
	void handleRoleDeleteCommand(RoleDeleteCommand roleDeleteCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param roleSetDescriptionCommand
	 *            specific command.
	 */
	void handleRoleSetDescriptionCommand(RoleSetDescriptionCommand roleSetDescriptionCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param roleAddRightCommand
	 *            specific command.
	 */
	void handleRoleAddRightCommand(RoleAddRightCommand roleAddRightCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param roleRemoveRightCommand
	 *            specific command.
	 */
	void handleRoleRemoveRightCommand(RoleRemoveRightCommand roleRemoveRightCommand);

}
