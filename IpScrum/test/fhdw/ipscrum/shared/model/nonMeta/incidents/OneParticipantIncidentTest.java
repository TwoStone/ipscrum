package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * tests the class OneParticipantIncident.
 */
public class OneParticipantIncidentTest extends SetUpTestData {

	/**
	 * tests creating a new incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testOneParticipantIncident1() throws Exception {

		final OneParticipantIncident result = new OneParticipantIncident();

		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getParticipant());
		Assert.assertEquals(null, result.getStart());
		Assert.assertEquals(false, result.isGlobal());
		Assert.assertEquals(null, result.getEnd());
		Assert.assertEquals(null, result.getIncidentType());
		Assert.assertEquals(null, result.getProjects());
		Assert.assertEquals(null, result.getDescription());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * tests to create a incident and get the data of it.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testOneParticipantIncident2() throws Exception {
		@SuppressWarnings("deprecation")
		final Date start = new Date(2011 - 1900, 3 - 1, 1);
		@SuppressWarnings("deprecation")
		final Date end = new Date(2011 - 1900, 3 - 1, 1);
		final Person participant = this.getpBjoern();

		final OneParticipantIncident result =
				new OneParticipantIncident(this.getModel(), start, end, participant);

		Assert.assertNotNull(result);
		Assert.assertEquals(start, result.getStart());
		Assert.assertEquals(end, result.getEnd());
		Assert.assertEquals(participant, result.getParticipant());
	}

	/**
	 * Test to get the participant of a incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetParticipant1() throws Exception {
		final OneParticipantIncident fixture =
				new OneParticipantIncident(this.getModel(), new Date(), new Date(),
						this.getpSarah());

		final Person result = fixture.getParticipant();

		Assert.assertNotNull(result);
		Assert.assertEquals(this.getpSarah(), result);
	}
}
