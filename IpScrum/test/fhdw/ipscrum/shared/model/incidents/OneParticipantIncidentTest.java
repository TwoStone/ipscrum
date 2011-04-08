package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import org.junit.*;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.SetUpTestData;
import static org.junit.Assert.*;

public class OneParticipantIncidentTest extends SetUpTestData {

	@Test
	public void testOneParticipantIncident_1()
		throws Exception {

		OneParticipantIncident result = new OneParticipantIncident();

		assertNotNull(result);
		assertEquals(null, result.getParticipant());
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
	public void testOneParticipantIncident_2()
		throws Exception {
		Date start = new Date(2011 - 1900, 3 - 1, 1);
		Date end = new Date(2011 - 1900, 3 - 1, 1);
		IPerson participant = this.pBjoern;

		OneParticipantIncident result = new OneParticipantIncident(start, end, participant);

		assertNotNull(result);
		assertEquals(start, result.getStart());
		assertEquals(end, result.getEnd());
		assertEquals(participant, result.getParticipant());
	}

	@Test
	public void testGetParticipant_1()
		throws Exception {
		OneParticipantIncident fixture = new OneParticipantIncident(new Date(), new Date(), this.pSarah);

		IPerson result = fixture.getParticipant();

		assertNotNull(result);
		assertEquals(this.pSarah, result);
	}
}