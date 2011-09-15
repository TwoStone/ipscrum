/**
 * 
 */
package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;

/**
 * standard visitor for field types commands.
 */
public interface FieldTypesCommandStandardVisitorInterface extends FieldTypesCommandVisitor {

	/**
	 * Specifies standard behavior of the visitor.
	 * 
	 * @param command
	 *            the visited command.
	 */
	void standardHandling(ICommand command);
}
