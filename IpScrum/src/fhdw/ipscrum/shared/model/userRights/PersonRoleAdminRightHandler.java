/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand;
import fhdw.ipscrum.shared.model.Model;

/**
 * handler for person role rights.
 */
class PersonRoleAdminRightHandler extends RightHandler {

	/**
	 * creates a new person role admin right handler.
	 * 
	 * @param myRight
	 *            concrete right
	 * @param model
	 *            the model.
	 */
	PersonRoleAdminRightHandler(final PersonRoleAdminRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePersonAddRoleCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand)
	 */
	@Override
	public void handlePersonAddRoleCommand(
			final PersonAddRoleCommand personAddRoleCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePersonChangeNameCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration
	 * .PersonChangeNameCommand)
	 */
	@Override
	public void handlePersonChangeNameCommand(
			final PersonChangeNameCommand personChangeNameCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePersonCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand)
	 */
	@Override
	public void
			handlePersonCreateCommand(final PersonCreateCommand personCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePersonRemoveRoleCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration
	 * .PersonRemoveRoleCommand)
	 */
	@Override
	public void handlePersonRemoveRoleCommand(
			final PersonRemoveRoleCommand personRemoveRoleCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleRoleCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand)
	 */
	@Override
	public void handleRoleCreateCommand(final RoleCreateCommand roleCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleRoleDeleteCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand)
	 */
	@Override
	public void handleRoleDeleteCommand(final RoleDeleteCommand roleDeleteCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleRoleSetDescriptionCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration
	 * .RoleSetDescriptionCommand)
	 */
	@Override
	public void handleRoleSetDescriptionCommand(
			final RoleSetDescriptionCommand roleSetDescriptionCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleRoleAddRightCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand)
	 */
	@Override
	public void
			handleRoleAddRightCommand(final RoleAddRightCommand roleAddRightCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleRoleRemoveRightCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration
	 * .RoleRemoveRightCommand)
	 */
	@Override
	public void handleRoleRemoveRightCommand(
			final RoleRemoveRightCommand roleRemoveRightCommand) {
		this.allowed();
	}

}
