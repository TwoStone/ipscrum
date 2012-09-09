package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * represents an event argument which knows a PBI.
 */
public class ShowTicketEventArgs extends EventArgs {
	/**
	 * represents the PBI attached to the event argument.
	 */
	private final ProductBacklogItem ticket;

	/**
	 * constructor of the ShowTicketEventArgs.
	 * 
	 * @param ticket
	 *            related to the argument
	 */
	public ShowTicketEventArgs(final ProductBacklogItem ticket) {
		super();
		this.ticket = ticket;
	}

	/**
	 * getter of the related ticket.
	 * 
	 * @return the ticket
	 */
	public ProductBacklogItem getTicket() {
		return this.ticket;
	}

}
