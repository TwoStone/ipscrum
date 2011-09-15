/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;

/**
 * standard visitor for incident commands.
 */
public interface ProjectHistoryCommandStandardVisitorInterface
		extends ProjectHistoryCommandVisitor {
	/**
	 * Specifies standard behavior of the visitor.
	 * 
	 * @param command
	 *            the visited command.
	 */
	void standardHandling(ICommand command);
}
