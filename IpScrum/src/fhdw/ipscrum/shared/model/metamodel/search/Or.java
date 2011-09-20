package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the logical operator Or! All search expression arguments will be combined
 * with Or. For Example: arg1 or arg2 or arg3 ...
 */
public class Or extends MultiLogicSearchOperator {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -5965140304562056266L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Or() {
	}

	/**
	 * Constructor of the Or.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 */
	public Or(final Model model) {
		super(model);
	}

	@Override
	public boolean search(final Ticket ticket) {
		boolean result = false;
		if (this.getArgs().size() == 0) {
			result = true;
		}
		for (final ISearchExpression current : this.getArgs()) {
			if (current.search(ticket)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "ODER";
	}

}
