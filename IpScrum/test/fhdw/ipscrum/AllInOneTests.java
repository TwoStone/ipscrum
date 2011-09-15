package fhdw.ipscrum;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * Tests all tests.
 */
@SuppressWarnings("deprecation")
public class AllInOneTests {

	private Model model;
	private Project project = null;
	private ProductBacklog pbltest = null;
	private Feature a = null;
	private Feature b = null;
	private Feature c = null;
	private Feature d = null;
	private Feature t = null;
	private Date cvCurrentDate = null;
	private Date cvCurrentDate2 = null;
	private Sprint sprint = null;
	private SprintBacklog sprintbl = null;
	private Task t1 = null;
	private Team team1 = null;
	private Person per1 = null;
	private Boolean pl1 = null;
	private Iterator<ProductBacklogItem> pbiIt = null;
	private ProductBacklogItem pbix = null;

	/**
	 * Initializes the test class.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	private void init() throws IPScrumGeneralException {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());

		this.project = new Project(this.model, "test");
		this.pbltest = this.project.getBacklog();

		this.cvCurrentDate = new Date();
		this.cvCurrentDate2 = this.cvCurrentDate;
		this.cvCurrentDate2.setMonth(Calendar.MONTH + 1);

		this.a =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "A", "testA", this.pbltest);
		this.b =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "B", "testB", this.pbltest);
		this.c =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "C", "testC", this.pbltest);
		this.d =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "D", "testD", this.pbltest);
		this.t =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "Task", "test Task", this.pbltest);

		this.team1 = new Team(this.model, "Team");
		this.team1.addProject(this.project);
		this.per1 = new Person(this.model, "Max", "Mustermann");
		this.team1.addMember(this.per1);
		this.sprint =
				new Sprint(this.model, "Sprint", "Beschreibung", new Date(),
						new Date(), this.team1, this.project);
		this.t1 =
				new Task(this.model, this.model.getTypeManager().getStandardTaskType(),
						"Task 1", "Removing of a PBI in PBL",
						this.sprint.getSprintBacklog());
		this.sprintbl = this.sprint.getSprintBacklog();
		this.t.setSprint(this.sprint);
		this.t1.addPBI(this.t);
		this.pl1 = true;
	}

	/**
	 * Needed for the set up before every test.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws IPScrumGeneralException {
		this.init();
	}

	// ************************************************************************
	// validity of the count() methods
	// ************************************************************************

	/**
	 * No item in PBL, when new Project is created.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCount1() throws Exception {
		final Project lvProject = new Project(this.model, "wayne");
		Assert.assertEquals(0, lvProject.getBacklog().getItems().size());
		Assert.assertNotNull(this.a);
		Assert.assertNotNull(this.t);
		Assert.assertNotNull(this.c);
		Assert.assertNotNull(this.b);
		Assert.assertNotNull(this.d);
		Assert.assertNotNull(this.sprintbl);
	}

	/**
	 * Addition of several new elements into a new PBL to test count().
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCount2() throws Exception {
		final Project lvProject = new Project(this.model, "wayne");
		Assert.assertEquals(0, lvProject.getBacklog().getItems().size());
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"1", "", lvProject.getBacklog());
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"2", "", lvProject.getBacklog());
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"3", "", lvProject.getBacklog());
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"4", "", lvProject.getBacklog());

		Assert.assertEquals(4, lvProject.getBacklog().getItems().size());
	}

	/**
	 * simple equals on the same project.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testProjectEquals() throws Exception {
		final Project lvProject = this.project;
		Assert.assertEquals(lvProject, this.project);
	}

	/**
	 * simple equals on the same PBL.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testPBLEquals() throws Exception {
		final ProductBacklog lvBacklog = this.pbltest;
		Assert.assertEquals(lvBacklog, this.pbltest);
	}

	// ************************************************************************
	// Konsinstenz vom Project ausgehend
	// ************************************************************************

	/**
	 * tests on reference between project and PBL.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testKonsistenzProject1() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();
		// Test, dass sich Project und PBL gegenseitig referenzieren
		Assert.assertEquals(lvProject, lvBacklog.getProject());
		Assert.assertEquals(lvBacklog, lvProject.getBacklog());
	}

	/**
	 * tests on reference of project and release.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testKonsistenzProjectAndRelease() throws IPScrumGeneralException {
		final Project lvProject = new Project(this.model, "name1");
		Release lvRelease = null;
		try {
			lvRelease = new Release(this.model, "0.0.2", this.cvCurrentDate, lvProject);
		} catch (final DoubleDefinitionException e) {
			Assert.fail("Da neues Project darf kein Fehler passieren!");
		}
		// Testen ob sie sich gegenseitig referenzieren
		Assert.assertEquals(lvProject, lvRelease.getProject());
		Assert.assertEquals(lvRelease, lvProject.getReleasePlan().get(0));

		// Test, dass ein Release nicht doppelt in der Liste ist
		Assert.assertEquals(1, lvProject.getReleasePlan().size());
		lvProject.getReleasePlan().add(lvRelease);
		Assert.assertEquals(1, lvProject.getReleasePlan().size());
	}

	/**
	 * tests connections of referencing sprints are dissolved, if a release is deleted.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testKonsistenzProjectAndSprint() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final Team lvTeam = new Team(this.model, "Konsistenz");
		lvTeam.addProject(lvProject);
		Assert.assertEquals(3, this.model.getAllTeams().size());

		final Release lvRelease =
				new Release(this.model, "0.0.1", this.cvCurrentDate2, lvProject);
		final Sprint lvSprint =
				new Sprint(this.model, "testen1", "test", this.cvCurrentDate,
						this.cvCurrentDate2, lvTeam, lvProject);

		// Wird ein Release aus einem Projekt entfernt, so müssen alle
		// Sprints zu diesem Release von dem zu löschenden Release gelöst werden
		// sowie die Verbindung vom Release zum Projekt.
		lvRelease.addSprint(lvSprint);

		Assert.assertTrue(lvRelease.getSprints().contains(lvSprint));
		Assert.assertEquals(lvSprint.getRelease(), lvRelease);

		lvProject.removeRelease(lvRelease);

		Assert.assertTrue(!lvProject.getReleasePlan().contains(lvRelease));
		Assert.assertTrue(lvRelease.getProject() == null);
		Assert.assertTrue(lvSprint.getRelease() == null);
		Assert.assertTrue(!lvRelease.getSprints().contains(lvSprint));
	}

	// ************************************************************************
	// Konsistenz vom PBL ausgehend
	// ************************************************************************

	/**
	 * tests consitency Exception and connections between sprints and PBI's have to be
	 * made in both directions.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testKonsistenzPBLAndPBI() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();

		final Project lvProject2 = new Project(this.model, "name2");
		final ProductBacklog lvBacklog2 = lvProject2.getBacklog();

		// PBI nicht in 2 PBL's
		final ProductBacklogItem lvItem =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "name", "test", lvBacklog);
		try {
			lvBacklog2.addItem(lvItem);
			Assert.fail("Fehler");
		} catch (final ConsistencyException e) {
			Assert.assertTrue(true);
		}

		final Team lvTeam = new Team(this.model, "Konsistenz");
		lvTeam.addProject(lvProject);
		lvTeam.addProject(lvProject2);
		final Sprint lvSprint =
				new Sprint(this.model, "testen1", "test", this.cvCurrentDate,
						this.cvCurrentDate2, lvTeam, lvProject);

		// Wird dem PBI ein Sprint zugewiesen, so muss der Sprint auch auf das
		// PBI verweisen.
		Assert.assertTrue(!lvSprint.getPBIs().contains(lvItem));
		lvItem.setSprint(lvSprint);
		Assert.assertTrue(lvSprint.getPBIs().contains(lvItem));
		Assert.assertEquals(lvSprint, lvItem.getSprint());

		// Soll die Verbindung zwischen PBI und Sprint gelöst werden, so muss
		// dies im Sprint und im PBI erfolgen.
		lvItem.setSprint(null);
		Assert.assertTrue(!lvSprint.getPBIs().contains(lvItem));
		Assert.assertEquals(null, lvItem.getSprint());

		lvItem.setSprint(lvSprint);
		// löschen von PBI bedingt trennen der Verbindungen zu Sprint und PBL
		lvBacklog.removeItem(lvItem);
		if (lvItem.getBacklog() == lvBacklog) {
			Assert.fail("Verbindung nicht getrennt");
		}
		if (lvItem.getSprint() == lvSprint) {
			Assert.fail("Verbindung nicht getrennt");
		}
		if (!(lvItem.getBacklog() == null)) {
			Assert.fail("Verbindung nicht getrennt");
		}
		if (!(lvItem.getSprint() == null)) {
			Assert.fail("Verbindung nicht getrennt");
		}
		Assert.assertTrue(!lvSprint.getPBIs().contains(lvItem));
		Assert.assertTrue(!lvBacklog.getItems().contains(lvItem));
	}

	/**
	 * test connections between sprints and releases.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testReleaseAndSprint() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final Team lvTeam = new Team(this.model, "Konsistenz");
		lvTeam.addProject(lvProject);
		final Release lvRelease =
				new Release(this.model, "0.0.1", this.cvCurrentDate, lvProject);
		final Release lvRelease2 =
				new Release(this.model, "0.0.2", this.cvCurrentDate2, lvProject);
		final Sprint lvSprint =
				new Sprint(this.model, "testen1", "test", this.cvCurrentDate,
						this.cvCurrentDate2, lvTeam, lvProject);

		lvRelease.addSprint(lvSprint);

		lvRelease.removeSprint(lvSprint);
		Assert.assertNotNull(lvRelease2);
		Assert.assertEquals(null, lvSprint.getRelease());
		Assert.assertTrue(!lvRelease.getSprints().contains(lvSprint));
	}

	// ************************************************************************
	// test for double definitions
	// ************************************************************************

	/**
	 * double definition on project creation.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForProjectInRoot() throws Exception {
		new Project(this.model, "name");
		new Project(this.model, "name");
	}

	/**
	 * double definition on release creation in one project.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForReleaseInProject() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		new Release(this.model, "0.0.1", this.cvCurrentDate, lvProject);
		new Release(this.model, "0.0.1", this.cvCurrentDate, lvProject);
	}

	/**
	 * double definition on sprint creation in one project.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForSprintInProject() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final Team lvTeam = new Team(this.model, "DoubleDefined");
		lvTeam.addProject(lvProject);
		new Sprint(this.model, "name", "", this.cvCurrentDate, this.cvCurrentDate2,
				lvTeam, lvProject);
		new Sprint(this.model, "name", "", this.cvCurrentDate, this.cvCurrentDate2,
				lvTeam, lvProject);

	}

	/**
	 * double definition on PBI creation in one PBL.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForPBIinPBL() throws Exception {
		final Project lvProject = new Project(this.model, "name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();

		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"name", "", lvBacklog);
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"name", "", lvBacklog);
	}

	/**
	 * Testing Consistency between Release - Sprint and PBI.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void releaseSprintPbiConsistency() throws IPScrumGeneralException {
		final Project p = new Project(this.model, "Test");
		final Feature f1 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "T1", "", p.getBacklog());
		final Feature f2 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "T2", "", p.getBacklog());
		final Feature f3 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "T3", "", p.getBacklog());

		final Team testTeam1 = new Team(this.model, "Test");
		testTeam1.addProject(p);
		final Sprint sprint1 =
				new Sprint(this.model, "123", "sd", new Date(), new Date(), testTeam1, p);
		final Team team2 = new Team(this.model, "Test2");
		team2.addProject(p);
		final Sprint sprint2 =
				new Sprint(this.model, "1234", "scb", new Date(), new Date(), team2, p);
		final Team team3 = new Team(this.model, "Test3");
		team3.addProject(p);
		final Sprint sprint3 =
				new Sprint(this.model, "12345", "33", new Date(), new Date(), team3, p);

		// FIRST SPRINT<->PBI
		Assert.assertNotNull(f2);
		Assert.assertNotNull(f3);

		f1.setSprint(sprint3);

		f1.setSprint(sprint1);

		Assert.assertEquals(sprint1, f1.getSprint());
		Assert.assertTrue(sprint1.getPBIs().contains(f1));

		f1.setSprint(sprint2);
		Assert.assertEquals(sprint2, f1.getSprint());
		Assert.assertFalse(sprint1.getPBIs().contains(f1));
		Assert.assertTrue(sprint2.getPBIs().contains(f1));

		// NOW RELEASE<->PBI
		final Release release1 = new Release(this.model, "R1", new Date(), p);
		final Release release2 =
				new Release(this.model, "R2", new Date(2011, 10, 11), p);
		Release release3 = null;

		// Doppelt
		try {
			release3 = new Release(this.model, "R2", new Date(2011, 10, 11), p);
			Assert.fail();
		} catch (final Exception e1) {
			Assert.assertTrue(release3 == null);
			Assert.assertFalse(p.getReleasePlan().contains(release3));
		}

		Assert.assertTrue(p.getReleasePlan().contains(release1));
		Assert.assertTrue(p.getReleasePlan().contains(release2));
		Assert.assertEquals(p, release1.getProject());
		Assert.assertEquals(p, release2.getProject());

		release1.addSprint(sprint3);

		Assert.assertFalse(sprint1.equals(sprint2));
		Assert.assertFalse(sprint1.hashCode() == sprint2.hashCode());

		release1.addSprint(sprint1);
		release1.addSprint(sprint2);

		Assert.assertEquals(release1, sprint1.getRelease());
		Assert.assertEquals(release1, sprint2.getRelease());
		Assert.assertTrue(release1.getSprints().contains(sprint1));
		Assert.assertTrue(release1.getSprints().contains(sprint2));

		release1.removeSprint(sprint1);
		Assert.assertTrue(sprint1.getRelease() == null);
		Assert.assertFalse(release1.getSprints().contains(sprint1));
		Assert.assertTrue(release1.getSprints().contains(sprint2));
	}

	/**
	 * Testing Change Sprint for PBI.
	 */
	@Test
	public void changeSprintForPBI() {
		try {
			final Project p = new Project(this.model, "Test");
			final Feature f1 =
					new Feature(this.model, this.model.getTypeManager()
							.getStandardFeatureType(), "T1", "", p.getBacklog());
			final Feature f2 =
					new Feature(this.model, this.model.getTypeManager()
							.getStandardFeatureType(), "T2", "", p.getBacklog());
			final Team team = new Team(this.model, "Test");
			team.addProject(p);
			final Sprint sprint1 =
					new Sprint(this.model, "123", "sd", new Date(), new Date(), team, p);
			final Sprint sprint2 =
					new Sprint(this.model, "1234", "scb", new Date(), new Date(), team,
							p);

			f1.setSprint(sprint1);
			f1.setSprint(sprint2);

			Assert.assertNotNull(f2);
			Assert.assertFalse(sprint1.getPBIs().contains(f1));
			Assert.assertTrue(sprint2.getPBIs().contains(f1));
			Assert.assertEquals(f1.getSprint(), sprint2);

		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Testing Change Release for Sprint.
	 * 
	 */
	public void changeReleaseForSprint() {
		try {
			final Project p = new Project(this.model, "Test");
			final Feature f1 =
					new Feature(this.model, this.model.getTypeManager()
							.getStandardFeatureType(), "T1", "", p.getBacklog());
			final Feature f2 =
					new Feature(this.model, this.model.getTypeManager()
							.getStandardFeatureType(), "T2", "", p.getBacklog());
			final Sprint sprint1 =
					new Sprint(this.model, "123", "sd", new Date(), new Date(),
							new Team(this.model, "Test"), p);
			final Sprint sprint2 =
					new Sprint(this.model, "1234", "scb", new Date(), new Date(),
							new Team(this.model, "Test2"), p);

			final Release release = new Release(this.model, "R1", new Date(), p);
			final Release release2 = new Release(this.model, "R3", new Date(), p);

			release.addSprint(sprint1);

			Assert.assertNotNull(f2);
			Assert.assertNotNull(f1);
			Assert.assertNotNull(sprint2);
			Assert.assertTrue(release.getSprints().contains(sprint1));
			Assert.assertEquals(release, sprint1.getRelease());

			release2.addSprint(sprint1);

			Assert.assertTrue(release2.getSprints().contains(sprint1));
			Assert.assertEquals(release2, sprint1.getRelease());
			Assert.assertFalse(release.getSprints().contains(sprint1));

		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Addition of a new element (here: feature).
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPBI() throws Exception {
		final int entriesInList = this.pbltest.getItems().size();
		new Feature(this.model, this.model.getTypeManager().getStandardFeatureType(),
				"E", "Test E", this.pbltest);
		// System.out.println(pbltest.getItems().get(entriesInList));
		Assert.assertEquals(entriesInList + 1, this.pbltest.getItems().size());
	}

	/**
	 * Removal of a PBI in PBL, which is connected with a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemovePBI1() throws Exception {
		final int entriesInList = this.pbltest.getItems().size();
		this.pbltest.removeItem(this.t);

		// Has e been removed from PBL?
		Assert.assertEquals(entriesInList - 1, this.pbltest.getItems().size());

		// Has task t1 been removed? (unassigned task)
		this.pbiIt = this.t1.getAssignedPBIs().iterator();
		this.pl1 = true;
		while (this.pbiIt.hasNext()) {
			this.pbix = this.pbiIt.next();
			if (this.pbix == this.t) {
				this.pl1 = false;
			}
		}
		Assert.assertEquals(true, this.pl1);

	}

	/**
	 * Removal of a PBI in PBL, which is connected with an assigned task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemovePBI2() throws Exception {
		this.pbltest.addItem(this.t);
		final int entriesInList = this.pbltest.getItems().size();
		this.pbltest.removeItem(this.t);
		this.t1.changeState(this.model.getTypeManager().getInProcess());
		this.t1.setResponsibility(this.per1);

		// Has e been removed from PBL?
		Assert.assertEquals(entriesInList - 1, this.pbltest.getItems().size());
		// Removal of PBI from task t1 is enforced.
		this.pbiIt = this.t1.getAssignedPBIs().iterator();
		this.pl1 = true;
		while (this.pbiIt.hasNext()) {
			this.pbix = this.pbiIt.next();
			if (this.pbix == this.t) {
				this.pl1 = false;
			}
		}
		Assert.assertEquals(true, this.pl1);

	}

	/**
	 * Removal of a PBI in PBL, which is connected with an assigned task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testRemovePBI3() throws Exception {
		this.pbltest.addItem(this.t);
		final int entriesInList = this.pbltest.getItems().size();
		this.t1.changeState(this.model.getTypeManager().getClosed());
		this.pbltest.removeItem(this.t);

		// Has e been removed from PBL?
		Assert.assertEquals(entriesInList - 1, this.pbltest.getItems().size());
		// Removal of PBI from task t1 is not allowed.

	}

	// ************************************************************************
	// ************************************************************************

	/**
	 * a new Project is created.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testProjectEquals2() throws Exception {
		final Project lvProject = this.project;
		Assert.assertEquals(lvProject, this.project);
	}

	/**
	 * a new PBL is created on creation of a Project.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testPBLEquals2() throws Exception {
		final ProductBacklog lvBacklog = this.pbltest;
		Assert.assertEquals(lvBacklog, this.pbltest);
	}

}
