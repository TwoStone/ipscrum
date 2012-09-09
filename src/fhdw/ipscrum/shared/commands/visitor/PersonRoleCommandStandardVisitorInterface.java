/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;

/**
 * standard visitor for person and role commands.
 */
public interface PersonRoleCommandStandardVisitorInterface extends PersonRoleCommandVisitor {
	/**
	 * Specifies standard behavior of the visitor.
	 * 
	 * @param command
	 *            the visited command.
	 */
	void standardHandling(ICommand command);
}
