package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the logical operator Not. For Example: Not(arg) -> arg=true=>false | arg=false=>true
 * 
 */
public class Not extends SingleLogicSearchOperator {

	/**
	 * Represents the seraislVersionUID.
	 */
	private static final long serialVersionUID = 5747320984085365276L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Not() {
	}

	/**
	 * Constructor of the Not.
	 * 
	 * @param model
	 *            is related to the Not
	 * @param arg
	 *            is the expression related to the Not
	 * @throws CycleException
	 *             if a this method would create a cycle
	 */
	public Not(final Model model, final SearchExpression arg) throws CycleException {
		super(model, arg);
	}

	@Override
	public boolean search(final Ticket ticket) {
		if (this.getArg() == null) {
			return true;
		} else {
			return !this.getArg().search(ticket);
		}
	}

	@Override
	public String toString() {
		return "NICHT";
	}

}
