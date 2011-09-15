package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * represents the event argument which know a ticketType.
 */
public class TicketTypeArgs extends EventArgs {

	/**
	 * represents the ticketType attached to the event argument.
	 */
	private final TicketType type;

	/**
	 * constructor of the TicketTypeArgs.
	 * 
	 * @param type
	 *            related to the event argument
	 */
	public TicketTypeArgs(final TicketType type) {
		super();
		this.type = type;
	}

	/**
	 * getter of the ticketType.
	 * 
	 * @return the ticketType
	 */
	public TicketType getType() {
		return this.type;
	}
}
