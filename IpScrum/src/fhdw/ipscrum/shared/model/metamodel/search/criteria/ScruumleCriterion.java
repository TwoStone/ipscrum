package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.search.Or;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the Search Criterion for the ScruumleSearch.
 */
public class ScruumleCriterion extends TextCriterion {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4292151762764306185L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private ScruumleCriterion() {
		super();
	}

	/**
	 * Constructor of the ScruumleCriterion.
	 * 
	 * @param model
	 *            is related to the criterion
	 * @param value
	 *            of the search criterion
	 */
	public ScruumleCriterion(final Model model, final String value) {
		super(model, value);
	}

	@Override
	public boolean search(final Ticket ticket) {
		final Or or = new Or(this.getModel());

		try {

			or.add(new TicketNameCriterion(this.getModel(), this.getValue()));
			or.add(new TicketDescriptionCriterion(this.getModel(), this.getValue()));

		} catch (final CycleException e) {
			return false;
		}

		return or.search(ticket);
	}

	@Override
	public String toString() {
		return "Scruumle Textsuche [ " + this.getValue() + " ]";
	}
}
