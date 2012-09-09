/**
 * 
 */
package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;

/**
 * 
 */
public class AddGlobalIncidentMessageTest extends ModelTestBase {

	/**
	 * Incident fot tests.
	 */
	private Incident incident;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Person participant = new Person(this.getModel(), "Jack", "O'Neil");
		this.incident =
				new OneParticipantIncident(this.getModel(), new Date(), new Date(new Date().getTime() + 50000),
						participant);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.AddGLobalIncidentMessage#AddGLobalIncidentMessage(fhdw.ipscrum.shared.model.nonMeta.incidents.Incident)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if any error occurs
	 */
	@Test
	public void testAddGLobalIncidentMessage() throws IPScrumGeneralException {

		new AddGLobalIncidentMessage(this.incident);
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.model.messages.AddGLobalIncidentMessage#getIncident()}.
	 * 
	 * @throws IPScrumGeneralException
	 *             if any error occurs
	 */
	@Test
	public void testGetIncident() throws IPScrumGeneralException {

		final AddGLobalIncidentMessage message = new AddGLobalIncidentMessage(this.incident);
		Assert.assertEquals(this.incident, message.getIncident());

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.AddGLobalIncidentMessage#accept(fhdw.ipscrum.shared.model.messages.MessageVisitor)}
	 * .
	 */
	@Test
	public void testAcceptMessageVisitor() {
		final AddGLobalIncidentMessage message = new AddGLobalIncidentMessage(this.incident);
		message.accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}
}
