package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;

/**
 * standard visitor for team commands.
 */
public interface TeamCommandStandardVisitorInterface extends TeamCommandVisitor {
	/**
	 * Specifies standard behavior of the visitor.
	 * 
	 * @param command
	 *            the visited command.
	 */
	void standardHandling(ICommand command);
}
