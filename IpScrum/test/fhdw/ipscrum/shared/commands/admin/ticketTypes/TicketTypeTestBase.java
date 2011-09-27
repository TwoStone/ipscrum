/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * 
 */
public class TicketTypeTestBase extends ModelTestBase {

	/**
	 * ticket type for tests.
	 */
	private TicketType ticketType;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.ticketType = new FeatureTicketType(this.getModel(), "TestFeatureType", "This is the test feature type");
	}

	/**
	 * 
	 * @return ticket type for tests
	 */
	public TicketType getTicketType() {
		return this.ticketType;
	}
}
