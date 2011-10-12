/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

/**
 * standard visitor for administrator commands.
 */
public interface AdminCommandStandardVisitorInterface
		extends AdminCommandVisitor, PersonRoleCommandStandardVisitorInterface, TeamCommandStandardVisitorInterface,
		TicketTypesCommandStandardVisitorInterface, FieldTypesCommandStandardVisitorInterface {

}
