/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents user rights for managing ticket types.
 */
public class TicketTypeAdminRight extends AdminRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1354534818052669663L;

	/**
	 * 
	 */
	protected TicketTypeAdminRight() {
	}

	/**
	 * creates a new ticket type admin right.
	 * 
	 * @param model
	 *            the model.
	 */
	public TicketTypeAdminRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler() {
		return new TicketTypeAdminRightHandler(this, this.getModel());
	}

	@Override
	public String toString() {
		return "Tickettypen Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleTicketTypeAdminRight(this);
	}

}
