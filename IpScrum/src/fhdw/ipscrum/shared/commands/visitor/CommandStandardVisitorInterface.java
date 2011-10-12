/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

/**
 * standard visitor for all commands.
 */
public interface CommandStandardVisitorInterface
		extends CommandVisitor, TicketGeneralCommandStandardVisitorInterface, TaskboardCommandStandardVisitorInterface,
		ProductBacklogCommandStandardVisitorInterface, ProjectHistoryCommandStandardVisitorInterface,
		ProjectCommandStandardVisitorInterface {

}
