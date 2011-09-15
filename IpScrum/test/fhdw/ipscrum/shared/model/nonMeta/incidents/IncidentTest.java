package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Test the class Incident.
 */
public class IncidentTest extends SetUpTestData {
	/**
	 * represents the end date of the incident.
	 */
	private final Date end = new Date();

	/**
	 * represents the start date of the incident.
	 */
	@SuppressWarnings("deprecation")
	private final Date start = new Date(2011 - 1900, 3 - 1, 1);

	/**
	 * test to add a project to an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddProjects1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.projekt1);
		projects.add(this.projekt2);
		projects.add(this.projekt3);
		fixture.addProjects(projects);
	}

	/**
	 * tests to add projects to an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddProject1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Project project = this.projekt1;
		fixture.addProject(project);

	}

	/**
	 * test to add projects to an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddProject2() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Project project = null;

		fixture.addProject(project);

	}

	/**
	 * Tests a incident with a wrong startdate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateIllnessIncident1() throws Exception {
		final Person person = this.pBjoern;
		final OneParticipantIncident result =
				new OneParticipantIncident(this.model, this.start, this.end, person);

		Assert.assertNotNull(result);
		Assert.assertEquals(person, result.getParticipant());
		Assert.assertEquals(this.start, result.getStart());
		Assert.assertEquals(this.end, result.getEnd());
	}

	/**
	 * Tests a incident for one ill Person.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateIllnessIncident2() throws Exception {
		final Person person = this.pChris;
		final Date startDate = new Date(2011 - 1900, 3 - 1, 1);
		final Date endDate = new Date(2011 - 1900, 4 - 1, 1);
		final OneParticipantIncident result =
				new OneParticipantIncident(this.getModel(), startDate, endDate, person);

		Assert.assertNotNull(result);
		Assert.assertEquals(person, result.getParticipant());
		Assert.assertEquals(startDate, result.getStart());
		Assert.assertEquals(endDate, result.getEnd());
	}

	/**
	 * Test a incident with a usergenerated Type.
	 * 
	 * @throws Exception
	 *             if the use one of the methods fails
	 */
	@Test
	public void testCreateOtherIssueIncident1() throws Exception {
		final IncidentType type = new IncidentType(this.getModel(), "Probe");
		final String description = "Theaterprobe";
		final Date startDate = new Date();
		final Date endDate = new Date();

		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.getModel(), startDate, endDate);
		result.setType(type);
		result.setDescription(description);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.isGlobal());
		Assert.assertEquals("Probe", result.getName());
		Assert.assertEquals("Theaterprobe", result.getDescription());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * tests to create an other issue incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateOtherIssueIncident2() throws Exception {
		final IncidentType type = new IncidentType(this.getModel(), "Hindernis");
		final String description = "Stromausfall";
		final Date startDate = new Date();
		final Date endDate = new Date();

		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.getModel(), startDate, endDate);
		result.setType(type);
		result.setDescription(description);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.isGlobal());
		Assert.assertEquals("Hindernis", result.getName());
		Assert.assertEquals("Stromausfall", result.getDescription());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * tests to create a PBI completion incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreatePBICompletionIncident1() throws Exception {
		final OneParticipantIncident result =
				new OneParticipantIncident(this.model, this.start, this.end,
						this.pBjoern);

		Assert.assertNotNull(result);
	}

	/**
	 * test to create a release completion incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateReleaseCompletionIncident1() throws Exception {
		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.model, this.start, this.end);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.isGlobal());
		Assert.assertEquals(null, result.getIncidentType());
		Assert.assertEquals(0, result.countObservers());
		Assert.assertEquals(0, result.countTransientObservers());
		Assert.assertEquals(0, result.countPersistentObservers());
		Assert.assertEquals("Observable [observers=[]]", result.toString());
	}

	/**
	 * tests to create a sprint completion incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateSprintCompletionIncident1() throws Exception {
		final MultipleParticipantIncident result =
				new MultipleParticipantIncident(this.model, this.start, this.end);
		Assert.assertNotNull(result);
	}

	/**
	 * test to create a task completion incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateTaskCompletionIncident1() throws Exception {
		final OneParticipantIncident result =
				new OneParticipantIncident(this.model, this.start, this.end,
						this.pBjoern);
		Assert.assertNotNull(result);
	}

	/**
	 * tests to create a vacation incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateVacationIncident1() throws Exception {
		final OneParticipantIncident result =
				new OneParticipantIncident(this.model, this.start, this.end,
						this.pBjoern);
		Assert.assertNotNull(result);
	}

	/**
	 * test to create an vacation incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCreateVacationIncident2() throws Exception {
		final OneParticipantIncident result =
				new OneParticipantIncident(this.model, this.start, this.end,
						this.pBjoern);
		Assert.assertNotNull(result);
	}

	/**
	 * tests the equality.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * tests the equality.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testEquals2() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * tests to get the description.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetDescription1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		final String result = fixture.getDescription();

		Assert.assertEquals(null, result);
	}

	/**
	 * tests to get the end date.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetEnd1() throws Exception {
		final Date endDate = new Date();
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), endDate);

		final Date result = fixture.getEnd();

		Assert.assertNotNull(result);
		Assert.assertEquals(endDate, result);
	}

	/**
	 * tests to get the type of the incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetIncidentType1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		final IncidentType result = fixture.getIncidentType();

		Assert.assertEquals(null, result);
	}

	/**
	 * tests to get the current name.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetName1() throws Exception {
		final IncidentType incidentType =
				new IncidentType(this.getModel(), "Hindernis");
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), this.start, this.end);
		fixture.setType(incidentType);
		final String result = fixture.getName();
		Assert.assertEquals("Hindernis", result);
	}

	/**
	 * tests to get the associated projects.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetProjectAssoc1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		final List<Project> result = fixture.getProjects();

		Assert.assertNotNull(result);
	}

	/**
	 * test to get the current start date.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetStart1() throws Exception {
		final Date startDate = new Date();
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), startDate, new Date());

		final Date result = fixture.getStart();

		Assert.assertNotNull(result);
		Assert.assertEquals(startDate, result);
	}

	/**
	 * tests to set an incident as global.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsGlobal1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		final boolean result = fixture.isGlobal();

		Assert.assertEquals(false, result);
	}

	/**
	 * test to set an incident as global.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsGlobal2() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());

		final boolean result = fixture.isGlobal();

		Assert.assertEquals(false, result);
	}

	/**
	 * tests to set the description of an incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetDescription1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final String description = "Name";

		fixture.setDescription(description);
		Assert.assertEquals(description, fixture.getDescription());

	}

	/**
	 * tests to set the end date of the incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetEnd1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Date endDate = new Date();

		fixture.setEnd(endDate);
		Assert.assertEquals(endDate, fixture.getEnd());
	}

	/**
	 * test to set the incident as a global incident.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetGlobal1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final boolean isGlobal = true;

		fixture.setGlobal(isGlobal);

		Assert.assertTrue(fixture.isGlobal());

	}

	/**
	 * test the set of the start date.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetStart1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final Date startDate = new Date();

		fixture.setStart(startDate);

		Assert.assertEquals(startDate, fixture.getStart());
	}

	/**
	 * test the set of the incident type.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetType1() throws Exception {
		final Incident fixture =
				new MultipleParticipantIncident(this.getModel(), new Date(), new Date());
		final IncidentType incidentType = new IncidentType(this.getModel(), "");

		fixture.setType(incidentType);

		Assert.assertEquals(incidentType, fixture.getIncidentType());

	}

	/**
	 * testing bidirectional association many to many.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsIncidentInProject1() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);

		final Iterator<Incident> incidentIterator =
				this.projekt1.getProjectIncidents().iterator();
		final Incident current = incidentIterator.next();
		if (current != null) {
			Assert.assertEquals(incident, current);
		} else {
			Assert.fail();
		}
	}

	/**
	 * testing bidirectional association many to many.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsIncidentInProject2() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);
		final Iterator<Incident> incidentIterator =
				this.projekt1.getProjectIncidents().iterator();
		final Incident current = incidentIterator.next();
		if (current != null) {
			Assert.assertEquals(incident, current);
		} else {
			Assert.fail();
		}
	}

	/**
	 * testing bidirectional association many to many.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsProjectInIncident1() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);
		final Iterator<Project> projectIterator = incident.getProjects().iterator();
		final Project current = projectIterator.next();
		if (current != null) {
			Assert.assertEquals(this.projekt1, current);
		} else {
			Assert.fail();
		}
	}

	/**
	 * testing bidirectional association many to many.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails.
	 */
	@Test
	public void testIsProjectInIncident2() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);
		final Iterator<Project> projectIterator = incident.getProjects().iterator();
		final Project current = projectIterator.next();
		if (current != null) {
			Assert.assertEquals(this.projekt1, current);
		} else {
			Assert.fail();
		}
	}

	/**
	 * testing doublets: add projekt1 to the same incident1 twice.
	 * 
	 * @throws IPScrumGeneralException
	 *             if one of the methods fails
	 */
	@Test
	public void testDoubleDefinition1() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);
		incident.addProject(this.projekt1);
		final int iAct = incident.getProjects().size();
		final int iExp = 1;
		Assert.assertEquals(iExp, iAct);
	}

	/**
	 * testing doublets: add incident to projekt1 twice.
	 * 
	 * @throws IPScrumGeneralException
	 *             if one of the methods fails
	 */
	@Test
	public void testDoubleDefinition2() throws IPScrumGeneralException {
		final String description =
				this.pChristin.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		final OneParticipantIncident incident =
				new OneParticipantIncident(this.getModel(), this.start, this.end,
						this.pChristin);
		incident.setDescription(description);
		incident.setGlobal(true);
		incident.addProject(this.projekt1);
		incident.addProject(this.projekt1);
		final int iAct = this.projekt1.getProjectIncidents().size();
		final int iExp = 1;
		Assert.assertEquals(iExp, iAct);
	}
}
