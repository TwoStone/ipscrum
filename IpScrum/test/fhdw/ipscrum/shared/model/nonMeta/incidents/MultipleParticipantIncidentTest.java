package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * tests the class MultipleParticipantIncident.
 */
public class MultipleParticipantIncidentTest extends SetUpTestData {

	/**
	 * tests creating a new incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMultipleParticipantIncident1() throws Exception {

		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getParticipants());
		Assert.assertNotNull(result.getStart());
		Assert.assertNotNull(result.isGlobal());
		Assert.assertNotNull(result.getEnd());
		Assert.assertNull(result.getIncidentType());
		Assert.assertNotNull(result.getProjects());
		Assert.assertNull(result.getDescription());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * test to create an incident an get the data of it.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMultipleParticipantIncident2() throws Exception {
		final Date start = new Date();
		final Date end = new Date();

		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.getModel(), start, end);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.isGlobal());
		Assert.assertEquals(null, result.getIncidentType());
		Assert.assertEquals(null, result.getDescription());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * test to add persons to an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddParticipant1() throws Exception {
		final MultipleParticipantIncident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.pBjoern);
		persons.add(this.pChris);
		persons.add(this.pChristin);
		persons.add(this.pSarah);
		persons.add(this.pWilken);
		fixture.addPartipants(persons);
		Assert.assertTrue(fixture.getParticipants().size() == 5);

	}

	/**
	 * test to add an get persons from an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddParticipants1() throws Exception {
		final MultipleParticipantIncident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		fixture.addParticipant(this.pWilken);
		final Person person = this.pSarah;

		fixture.addParticipant(person);
		Assert.assertTrue(fixture.getParticipants().size() == 2);
		Assert.assertEquals(person, fixture.getParticipants().get(1));
		Assert.assertEquals(this.pWilken, fixture.getParticipants().get(0));

	}

	/**
	 * tests to add an get persons from an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddParticipant2() throws Exception {
		final MultipleParticipantIncident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		fixture.addParticipant(this.pBjoern);
		final Person person = this.pChris;

		fixture.addParticipant(person);
		Assert.assertTrue(fixture.getParticipants().size() == 2);
		Assert.assertEquals(person, fixture.getParticipants().get(1));
		Assert.assertEquals(this.pBjoern, fixture.getParticipants().get(0));
	}

	/**
	 * tests to get and add persons from/to an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddParticipant3() throws Exception {
		final MultipleParticipantIncident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		fixture.addParticipant(this.pWilken);
		final Person person = this.pSarah;

		fixture.addParticipant(person);
		fixture.addParticipant(person);
		Assert.assertTrue(fixture.getParticipants().size() == 2);
		Assert.assertEquals(person, fixture.getParticipants().get(1));
		Assert.assertEquals(this.pWilken, fixture.getParticipants().get(0));
	}

	/**
	 * tests to add an get persons from an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetParticipants1() throws Exception {
		final MultipleParticipantIncident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		fixture.addParticipant(this.pBjoern);

		final Vector<Person> result = fixture.getParticipants();

		Assert.assertNotNull(result);
		Assert.assertEquals(this.pBjoern, result.get(0));
		Assert.assertEquals(this.pBjoern, result.iterator().next());
	}
}
