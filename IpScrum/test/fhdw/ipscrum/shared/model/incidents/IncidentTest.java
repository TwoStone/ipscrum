package fhdw.ipscrum.shared.model.incidents;

import java.text.DateFormat;
import java.util.Date;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.Project;
import org.junit.*;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Person;
import static org.junit.Assert.*;

public class IncidentTest extends SetUpTestData{

	@Test
	public void testAddProject_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Project project = this.projekt1;

		fixture.addProject(project);

	}

	@Test
	public void testAddProject_2()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Project project = null;

		fixture.addProject(project);

	}

	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testCreateIllnessIncident_1()
		throws Exception {
		IPerson person = this.pBjoern;
		Date start = new Date();
		Date end = new Date(2011 - 1900, 3 - 1, 1);

		OneParticipantIncident result = Incident.createIllnessIncident(person, start, end);

		assertNotNull(result);
		assertEquals(person, result.getParticipant());
		assertEquals(start, result.getStart());
		assertEquals(end, result.getEnd());
		
	}

	@Test
	public void testCreateIllnessIncident_2()
		throws Exception {
		IPerson person = this.pChris;
		Date start = new Date(2011 - 1900, 3 - 1, 1);
		Date end = new Date(2011 - 1900, 4 - 1, 1);

		OneParticipantIncident result = Incident.createIllnessIncident(person, start, end);

		assertNotNull(result);
		assertEquals(person, result.getParticipant());
		assertEquals(start, result.getStart());
		assertEquals(end, result.getEnd());
	}

	@Test
	public void testCreateOtherIssueIncident_1()
		throws Exception {
		IncidentType type = new IncidentType("Probe");
		String description = "Theaterprobe";
		Date start = new Date();
		Date end = new Date();

		MultipleParticipantIncident result = Incident.createOtherIssueIncident(type, description, start, end);

		
		assertNotNull(result);
		assertEquals(false, result.isGlobal());
		assertEquals("Probe", result.getName());
		assertEquals("Theaterprobe", result.getDescription());
		assertEquals(0, result.countObservers());
		assertEquals(0, result.countTransientObservers());
		assertEquals(0, result.countPersistentObservers());
		assertEquals("Observable [observers=[]]", result.toString());
	}

	@Test
	public void testCreateOtherIssueIncident_2()
		throws Exception {
		IncidentType type = new IncidentType("Hindernis");
		String description = "Stromausfall";
		Date start = new Date();
		Date end = new Date();

		MultipleParticipantIncident result = Incident.createOtherIssueIncident(type, description, start, end);

		
		assertNotNull(result);
		assertEquals(false, result.isGlobal());
		assertEquals("Hindernis", result.getName());
		assertEquals("Stromausfall", result.getDescription());
		assertEquals(0, result.countObservers());
		assertEquals(0, result.countTransientObservers());
		assertEquals(0, result.countPersistentObservers());
		assertEquals("Observable [observers=[]]", result.toString());
	}

	@Test
	public void testCreatePBICompletionIncident_1()
		throws Exception {
		ProductBacklogItem pbi = this.pro3rel1spr2fea3;
		OneParticipantIncident result = Incident.createPBICompletionIncident(pbi);

		assertNotNull(result);
	}

	@Test
	public void testCreateReleaseCompletionIncident_1()
		throws Exception {
		IRelease release = this.pro1rel1;

		MultipleParticipantIncident result = Incident.createReleaseCompletionIncident(release);

		assertNotNull(result);
		assertEquals(false, result.isGlobal());
		assertEquals(null, result.getIncidentType());
		assertEquals(0, result.countObservers());
		assertEquals(0, result.countTransientObservers());
		assertEquals(0, result.countPersistentObservers());
		assertEquals("Observable [observers=[]]", result.toString());
	}


	@Test
	public void testCreateSprintCompletionIncident_1()
		throws Exception {
		ISprint sprint = this.pro1rel1spr1;
		
		Project projekt = this.projekt1;
		MultipleParticipantIncident result = Incident.createSprintCompletionIncident(sprint);
		
		Integer newLength = projekt.getProjectIncidents().size();
		
		System.out.println(newLength);

		assertNotNull(result);

		
	}


	@Test
	public void testCreateTaskCompletionIncident_1()
		throws Exception {
		ITask task = this.pro1rel1spr1tas1;

		OneParticipantIncident result = Incident.createTaskCompletionIncident(task);

		assertNotNull(result);
	}

	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testCreateVacationIncident_1()
		throws Exception {
		IPerson person = this.pChris;
		Date start = new Date();
		Date end = new Date(2011 - 1900, 3 - 1, 1);;

		OneParticipantIncident result = Incident.createVacationIncident(person, start, end);

		assertNotNull(result);
	}

	@Test
	public void testCreateVacationIncident_2()
		throws Exception {
		IPerson person = this.pChristin;
		Date start = new Date();
		Date end = new Date();

		OneParticipantIncident result = Incident.createVacationIncident(person, start, end);

		assertNotNull(result);
	}

	@Test
	public void testEquals_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_2()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testGetDescription_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());

		String result = fixture.getDescription();

		assertEquals(null, result);
	}

	@Test
	public void testGetEnd_1()
		throws Exception {
		Date end = new Date();
		Incident fixture = new MultipleParticipantIncident(new Date(), end);

		Date result = fixture.getEnd();

		assertNotNull(result);
		assertEquals(end, result);
	}

	@Test
	public void testGetIncidentType_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());

		IncidentType result = fixture.getIncidentType();

		assertEquals(null, result);
	}


	@Test
	public void testGetName_1()
		throws Exception {
		IPerson person = this.pWilken;
		Date start = new Date(2011 - 1900, 3 - 1, 1);;
		Date end = new Date(2011 - 1900, 5 - 1, 1);
		IncidentType incidentType = new IncidentType("Hindernis");
		Incident fixture = new MultipleParticipantIncident(start, end);
		fixture.setType(incidentType);

		
		String result = fixture.getName();
		
		assertEquals("Hindernis", result);
	}

	@Test
	public void testGetProjectAssoc_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());

		ManyToMany<ManyToMany, Incident> result = fixture.getProjectAssoc();

		assertNotNull(result);
	}

	@Test
	public void testGetStart_1()
		throws Exception {
		Date start = new Date();
		Incident fixture = new MultipleParticipantIncident(start, new Date());

		Date result = fixture.getStart();

		assertNotNull(result);
		assertEquals(start, result);
	}

	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);


		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_7()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_8()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_9()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIndirectEquals_10()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Object obj = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	@Test
	public void testIsGlobal_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.isGlobal();

		assertEquals(false, result);
	}

	@Test
	public void testIsGlobal_2()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());

		boolean result = fixture.isGlobal();

		assertEquals(false, result);
	}

	@Test
	public void testSetDescription_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		String description = "Name";

		fixture.setDescription(description);
		assertEquals(description, fixture.getDescription());

	}

	@Test
	public void testSetEnd_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Date end = new Date();

		fixture.setEnd(end);
		assertEquals(end, fixture.getEnd());
	}

	@Test
	public void testSetGlobal_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		boolean isGlobal = true;

		fixture.setGlobal(isGlobal);
		
		assertTrue(fixture.isGlobal());

	}

	@Test
	public void testSetStart_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		Date start = new Date();

		fixture.setStart(start);

		assertEquals(start, fixture.getStart());
	}

	@Test
	public void testSetType_1()
		throws Exception {
		Incident fixture = new MultipleParticipantIncident(new Date(), new Date());
		IncidentType incidentType = new IncidentType("");

		fixture.setType(incidentType);
		
		assertEquals(incidentType, fixture.getIncidentType());	

	}
}

