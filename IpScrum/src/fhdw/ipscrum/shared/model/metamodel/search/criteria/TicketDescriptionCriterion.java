package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the Search Criterion for TicketDescriptions.
 */
public class TicketDescriptionCriterion extends TextCriterion {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1888756291989585658L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private TicketDescriptionCriterion() {
		super();
	}

	/**
	 * Constructor of the TicketDescription.
	 * 
	 * @param model
	 *            is related to the searchCriterion
	 * @param value
	 *            of the searched criterion
	 */
	public TicketDescriptionCriterion(final Model model, final String value) {
		super(model, value);
	}

	@Override
	public boolean search(final Ticket ticket) {
		if (ticket.getDescription() != null) {
			return this.nonSensitiveContains(ticket.getDescription());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Ticket Beschreibung [" + this.getValue() + "]";
	}

}
