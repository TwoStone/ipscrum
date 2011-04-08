package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import java.util.Vector;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.SetUpTestData;

import org.junit.*;
import static org.junit.Assert.*;

public class MultipleParticipantIncidentTest extends SetUpTestData {

	@Test
	public void testMultipleParticipantIncident_1()
		throws Exception {

		MultipleParticipantIncident result = new MultipleParticipantIncident();

		assertNotNull(result);
		assertEquals(null, result.getParticipants());
		assertEquals(null, result.getStart());
		assertEquals(false, result.isGlobal());
		assertEquals(null, result.getEnd());
		assertEquals(null, result.getIncidentType());
		assertEquals(null, result.getProjectAssoc());
		assertEquals(null, result.getDescription());
		assertEquals(0, result.countObservers());
		assertEquals(0, result.countTransientObservers());
		assertEquals(0, result.countPersistentObservers());
		assertEquals("Observable [observers=[]]", result.toString());
	}

	@Test
	public void testMultipleParticipantIncident_2()
		throws Exception {
		Date start = new Date();
		Date end = new Date();

		MultipleParticipantIncident result = new MultipleParticipantIncident(start, end);

		assertNotNull(result);
		assertEquals(false, result.isGlobal());
		assertEquals(null, result.getIncidentType());
		assertEquals(null, result.getDescription());
		assertEquals(0, result.countObservers());
		assertEquals(0, result.countTransientObservers());
		assertEquals(0, result.countPersistentObservers());
		assertEquals("Observable [observers=[]]", result.toString());
	}


	@Test
	public void testAddParticipant_1()
		throws Exception {
		MultipleParticipantIncident fixture = new MultipleParticipantIncident(new Date(), new Date());
		fixture.addParticipant(this.pWilken);
		IPerson person = this.pSarah;

		fixture.addParticipant(person);
		assertTrue(fixture.getParticipants().size() == 2);
		assertEquals(person, fixture.getParticipants().get(1));
		assertEquals(this.pWilken, fixture.getParticipants().get(0));		

	}

	@Test
	public void testAddParticipant_2()
		throws Exception {
		MultipleParticipantIncident fixture = new MultipleParticipantIncident(new Date(), new Date());
		fixture.addParticipant(this.pBjoern);
		IPerson person = this.pChris;

		fixture.addParticipant(person);
		assertTrue(fixture.getParticipants().size() == 2);
		assertEquals(person, fixture.getParticipants().get(1));
		assertEquals(this.pBjoern, fixture.getParticipants().get(0));

	}

	@Test
	public void testGetParticipants_1()
		throws Exception {
		MultipleParticipantIncident fixture = new MultipleParticipantIncident(new Date(), new Date());
		fixture.addParticipant(this.pBjoern);

		Vector<IPerson> result = fixture.getParticipants();

		assertNotNull(result);
		assertEquals(this.pBjoern, result.get(0));
		assertEquals(this.pBjoern, result.iterator().next());
	}
}