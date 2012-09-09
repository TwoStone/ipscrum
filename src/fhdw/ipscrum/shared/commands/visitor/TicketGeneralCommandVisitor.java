package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;

/**
 * visitor for general ticket commands.
 */
public interface TicketGeneralCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param listFieldAddValueCommand
	 *            visited command.
	 * @throws NoObjectFindException
	 *             if the needed object isn't found
	 */
	@SuppressWarnings("rawtypes")
	void handleListFieldAddValueCommand(ListFieldAddValueCommand listFieldAddValueCommand) throws NoObjectFindException;

	/**
	 * specific visitor action.
	 * 
	 * @param listFieldRemoveValueCommand
	 *            visited command.
	 * @throws NoObjectFindException
	 *             if the needed object isn't found
	 */
	@SuppressWarnings("rawtypes")
	void handleListFieldRemoveValueCommand(ListFieldRemoveValueCommand listFieldRemoveValueCommand)
			throws NoObjectFindException;

	/**
	 * specific visitor action.
	 * 
	 * @param singleFieldChangeCommand
	 *            visited command.
	 * @throws NoObjectFindException
	 *             if the needed object isn't found
	 */
	@SuppressWarnings("rawtypes")
	void handleSingleFieldChangeCommand(SingleFieldChangeCommand singleFieldChangeCommand) throws NoObjectFindException;

	/**
	 * specific visitor action.
	 * 
	 * @param ticketChangeStateCommand
	 *            specific command.
	 * @throws NoObjectFindException
	 *             if the needed object isn't found
	 */
	void handleTicketChangeStateCommand(TicketChangeStateCommand ticketChangeStateCommand) throws NoObjectFindException;
}
