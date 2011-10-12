package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.SystemCreateCommand;

/**
 * Visitor for all administrator commands.
 */
public interface AdminCommandVisitor
		extends TicketTypesCommandVisitor, FieldTypesCommandVisitor, PersonRoleCommandVisitor, TeamCommandVisitor {

	/**
	 * specific visitor action.
	 * 
	 * @param systemCreateCommand
	 *            specific command.
	 */
	void handleSystemCreateCommand(SystemCreateCommand systemCreateCommand);
}
