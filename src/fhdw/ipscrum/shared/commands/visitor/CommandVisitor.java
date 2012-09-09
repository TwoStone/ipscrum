package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;

/**
 * visitor for all commands.
 */
public interface CommandVisitor
		extends ProductBacklogCommandVisitor, TaskboardCommandVisitor, AdminCommandVisitor, ProjectCommandVisitor,
		ProjectHistoryCommandVisitor, TicketGeneralCommandVisitor {

	/**
	 * specific visitor action.
	 * 
	 * @param searchCreateCommand
	 *            specific command.
	 */
	void handleSearchCreateCommand(SearchCreateCommand searchCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param searchDeleteCommand
	 *            specific command.
	 */
	void handleSearchDeleteCommand(SearchDeleteCommand searchDeleteCommand);

}
