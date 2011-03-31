package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class ShowTicketEventArgs extends EventArgs {
	private final ProductBacklogItem ticket;

	public ShowTicketEventArgs(ProductBacklogItem ticket) {
		super();
		this.ticket = ticket;
	}

	public ProductBacklogItem getTicket() {
		return ticket;
	}
	
	
	
}
