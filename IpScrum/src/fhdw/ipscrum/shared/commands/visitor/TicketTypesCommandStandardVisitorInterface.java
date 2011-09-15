/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;

/**
 * standard visitor for ticket type commands.
 */
public interface TicketTypesCommandStandardVisitorInterface extends TicketTypesCommandVisitor {
	/**
	 * Specifies standard behavior of the visitor.
	 * 
	 * @param command
	 *            the visited command.
	 */
	void standardHandling(ICommand command);
}
