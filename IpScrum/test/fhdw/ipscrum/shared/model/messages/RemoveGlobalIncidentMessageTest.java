/**
 * 
 */
package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;

/**
 * 
 */
public class RemoveGlobalIncidentMessageTest extends ModelTestBase {

	/**
	 * Incident used for tests.
	 */
	private OneParticipantIncident incident;

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
	 * {@link fhdw.ipscrum.shared.model.messages.RemoveGlobalIncidentMessage#RemoveGlobalIncidentMessage(fhdw.ipscrum.shared.model.nonMeta.incidents.Incident)}
	 * .
	 */
	@Test
	public final void testRemoveGlobalIncidentMessage() {
		new RemoveGlobalIncidentMessage(this.incident);
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.model.messages.RemoveGlobalIncidentMessage#getIncident()} .
	 */
	@Test
	public final void testGetIncident() {
		final RemoveGlobalIncidentMessage message = new RemoveGlobalIncidentMessage(this.incident);
		Assert.assertEquals(this.incident, message.getIncident());

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.messages.RemoveGlobalIncidentMessage#accept(fhdw.ipscrum.shared.model.messages.MessageVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		new RemoveGlobalIncidentMessage(this.incident).accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}

}
