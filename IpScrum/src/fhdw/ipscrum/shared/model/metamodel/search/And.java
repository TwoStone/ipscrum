package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the logical operator And! All search expression arguments will be combined
 * with And. For Example: arg1 and arg2 and arg3 ...
 */
public class And extends MultiLogicSearchOperator {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 817231203138838566L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private And() {
	}

	/**
	 * Constructor of And.
	 * 
	 * @param model
	 *            is related to And
	 */
	public And(final Model model) {
		super(model);
	}

	@Override
	public boolean search(final Ticket ticket) {
		for (final ISearchExpression current : this.getArgs()) {
			if (!current.search(ticket)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "UND";
	}
}
