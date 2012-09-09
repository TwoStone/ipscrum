package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the Search Criterion for the TicketName.
 */
public class TicketNameCriterion extends TextCriterion {

	/**
	 * Represents the serailVersionUID.
	 */
	private static final long serialVersionUID = -8960703187309223147L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private TicketNameCriterion() {
	}

	/**
	 * Constructor of the TicketNameCriterion.
	 * 
	 * @param model
	 *            is related to the ticketNameCriterion
	 * @param name
	 *            which is searched
	 */
	public TicketNameCriterion(final Model model, final String name) {
		super(model, name);
	}

	@Override
	public boolean search(final Ticket ticket) {
		return this.nonSensitiveContains(ticket.getName());
	}

	@Override
	public String toString() {
		return "Ticket Bezeichnung [" + this.getValue() + "]";
	}

}
