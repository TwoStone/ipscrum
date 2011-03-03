package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class AllInOneTests {

	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Feature a = null;
	private static Feature b = null;
	private static Feature c = null;
	private static Feature d = null;
	private static Date cvCurrentDate = null;
	private static Date cvCurrentDate2 = null;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("test");
		pbltest = test.getBacklog();

		cvCurrentDate = new Date();
		cvCurrentDate2 = cvCurrentDate;
		cvCurrentDate2.setMonth(Calendar.MONTH + 1);

		a = new Feature("A", "testA", pbltest);
		b = new Feature("B", "testB", pbltest);
		c = new Feature("C", "testC", pbltest);
		d = new Feature("D", "testD", pbltest);

		// System.out.println(pbltest.getItems().toString());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// ************************************************************************
	// validity of the count() methods
	// ************************************************************************

	/**
	 * No item in PBL, when new Project is created
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCount1() throws Exception {
		final Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
	}

	/**
	 * Addition of several new elements into a new PBL to test count()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCount2() throws Exception {
		final Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
		new Feature("1", "", lvProject.getBacklog());
		new Feature("2", "", lvProject.getBacklog());
		new Feature("3", "", lvProject.getBacklog());
		new Feature("4", "", lvProject.getBacklog());

		assertEquals(4, lvProject.getBacklog().getItems().size());
	}

	/**
	 * simple equals on the same project
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProjectEquals() throws Exception {
		final Project lvProject = test;
		assertEquals(lvProject, test);
	}

	/**
	 * simple equals on the same PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPBLEquals() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		assertEquals(lvBacklog, pbltest);
	}

	// ************************************************************************
	// Konsinstenz vom Project ausgehend
	// ************************************************************************

	/**
	 * tests on reference between project and PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKonsistenzProject1() throws Exception {
		final Project lvProject = new Project("name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();
		// Test, dass sich Project und PBL gegenseitig referenzieren
		assertEquals(lvProject, lvBacklog.getProject());
		assertEquals(lvBacklog, lvProject.getBacklog());
	}

	/**
	 * tests on reference of project and release
	 * 
	 * @throws NoValidValueException
	 * @throws ConsistencyException
	 */
	@Test
	public void testKonsistenzProjectAndRelease() throws NoValidValueException,
			ConsistencyException {
		final Project lvProject = new Project("name1");
		Release lvRelease = null;
		try {
			lvRelease = new Release("0.0.2", cvCurrentDate, lvProject);
		} catch (final DoubleDefinitionException e) {
			fail("Da neues Project darf kein Fehler passieren!");
		}
		// Testen ob sie sich gegenseitig referenzieren
		assertEquals(lvProject, lvRelease.getProject());
		assertEquals(lvRelease, lvProject.getReleasePlan().get(0));

		// Test, dass ein Release nicht doppelt in der Liste ist
		assertEquals(1, lvProject.getReleasePlan().size());
		lvProject.getReleasePlan().add(lvRelease);
		assertEquals(1, lvProject.getReleasePlan().size());
	}

	/**
	 * tests connections of referencing sprints are dissolved, if a release is
	 * deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKonsistenzProjectAndSprint() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		final Team lvTeam = new Team("Konsistenz");
		lvRoot.addTeam(lvTeam);
		assertEquals(1, lvRoot.getTeams().size());

		final Release lvRelease = new Release("0.0.1", cvCurrentDate2,
				lvProject);
		final Sprint lvSprint = new Sprint("testen1", "test", cvCurrentDate,
				cvCurrentDate2, lvTeam);

		// Wird ein Release aus einem Projekt entfernt, so müssen alle
		// Sprints zu diesem Release von dem zu löschenden Release gelöst werden
		// sowie die Verbindung vom Release zum Projekt.
		lvProject.addSprint(lvSprint);
		lvRelease.addSprint(lvSprint);

		assertTrue(lvRelease.getSprints().contains(lvSprint));
		assertEquals(lvSprint.getRelease(), lvRelease);

		lvProject.removeRelease(lvRelease);

		assertTrue(!lvProject.getReleasePlan().contains(lvRelease));
		assertTrue(lvRelease.getProject() == null);
		assertTrue(lvSprint.getRelease() == null);
		assertTrue(!lvRelease.getSprints().contains(lvSprint));
	}

	// ************************************************************************
	// Konsistenz vom PBL ausgehend
	// ************************************************************************

	/**
	 * tests consitency Exception and connections between sprints and PBI's have
	 * to be made in both directions
	 * 
	 * @throws Exception
	 */
	@Test
	public void testKonsistenzPBLAndPBI() throws Exception {
		final Project lvProject = new Project("name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();

		final Project lvProject2 = new Project("name2");
		final ProductBacklog lvBacklog2 = lvProject2.getBacklog();

		// PBI nicht in 2 PBL's
		final ProductBacklogItem lvItem = new Feature("name", "test", lvBacklog);
		try {
			lvBacklog2.addItem(lvItem);
			fail("Fehler");
		} catch (final ConsistencyException e) {
			assertTrue(true);
		}

		final Root lvRoot = new Root();
		lvRoot.addProject(lvProject);
		final Team lvTeam = new Team("Konsistenz");
		lvRoot.addTeam(lvTeam);
		final Sprint lvSprint = new Sprint("testen1", "test", cvCurrentDate,
				cvCurrentDate2, lvTeam);
		lvProject.addSprint(lvSprint);

		// Wird dem PBI ein Sprint zugewiesen, so muss der Sprint auch auf das
		// PBI verweisen.
		assertTrue(!lvSprint.getPBIs().contains(lvItem));
		lvItem.setSprint(lvSprint);
		assertTrue(lvSprint.getPBIs().contains(lvItem));
		assertEquals(lvSprint, lvItem.getSprint());

		// Soll die Verbindung zwischen PBI und Sprint gelöst werden, so muss
		// dies im Sprint und im PBI erfolgen.
		lvItem.setSprint(null);
		assertTrue(!lvSprint.getPBIs().contains(lvItem));
		assertEquals(null, lvItem.getSprint());

		lvItem.setSprint(lvSprint);
		// löschen von PBI bedingt trennen der Verbindungen zu Sprint und PBL
		lvBacklog.removeItem(lvItem);
		if (lvItem.getBacklog() == lvBacklog) {
			fail("Verbindung nicht getrennt");
		}
		if (lvItem.getSprint() == lvSprint) {
			fail("Verbindung nicht getrennt");
		}
		if (!(lvItem.getBacklog() == null)) {
			fail("Verbindung nicht getrennt");
		}
		if (!(lvItem.getSprint() == null)) {
			fail("Verbindung nicht getrennt");
		}
		assertTrue(!lvSprint.getPBIs().contains(lvItem));
		assertTrue(!lvBacklog.getItems().contains(lvItem));
	}

	/**
	 * test connections between sprints and releases
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReleaseAndSprint() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		final Team lvTeam = new Team("Konsistenz");
		lvRoot.addTeam(lvTeam);

		final Release lvRelease = new Release("0.0.1", cvCurrentDate, lvProject);
		final Release lvRelease2 = new Release("0.0.2", cvCurrentDate2,
				lvProject);
		final Sprint lvSprint = new Sprint("testen1", "test", cvCurrentDate,
				cvCurrentDate2, lvTeam);
		lvProject.addSprint(lvSprint);

		lvRelease.addSprint(lvSprint);

		lvRelease.removeSprint(lvSprint);
		assertEquals(null, lvSprint.getRelease());
		assertTrue(!lvRelease.getSprints().contains(lvSprint));
	}

	// ************************************************************************
	// test for double definitions
	// ************************************************************************

	/**
	 * double definition on project creation
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoubleDefinedForProjectInRoot() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		try {
			lvRoot.addProject(lvProject);
			fail("Doppelte Definition von Projekten");
		} catch (final Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * double definition on release creation in one project
	 * 
	 * @throws Exception
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForReleaseInProject() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		new Release("0.0.1", cvCurrentDate, lvProject);
		new Release("0.0.1", cvCurrentDate, lvProject);
		fail();
	}

	/**
	 * double definition on sprint creation in one project
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoubleDefinedForSprintInProject() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		final Team lvTeam = new Team("DoubleDefined");
		lvRoot.addTeam(lvTeam);
		final Sprint lvSprint = new Sprint("name", "", cvCurrentDate,
				cvCurrentDate2, lvTeam);

		lvProject.addSprint(lvSprint);
		try {
			lvProject.addSprint(lvSprint);
			fail("Doppelte Definition von Sprints");
		} catch (final DoubleDefinitionException e) {
			assertTrue(true);
		}
	}

	/**
	 * double definition on PBI creation in one PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoubleDefinedForPBIinPBL() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		final ProductBacklog lvBacklog = lvProject.getBacklog();

		final ProductBacklogItem lvItem = new Feature("name", "", lvBacklog);

		try {
			new Feature("name", "", lvBacklog);
			fail("Doppelte Definition von PBI");
		} catch (final DoubleDefinitionException e) {
			assertTrue(true);
		}
	}

	@Test
	/**
	 * Testing Consistency between Release - Sprint and PBI 
	 */
	public void releaseSprintPbiConsistency() {
		try {
			final Project p = new Project("Test");
			final Feature f1 = new Feature("T1", "", p.getBacklog());
			final Feature f2 = new Feature("T2", "", p.getBacklog());
			final Feature f3 = new Feature("T3", "", p.getBacklog());

			p.getBacklog().addItem(f1);
			p.getBacklog().addItem(f2);
			p.getBacklog().addItem(f3);

			final ISprint sprint1 = new Sprint("123", "sd", new Date(),
					new Date(), new Team("Test"));
			final ISprint sprint2 = new Sprint("1234", "scb", new Date(),
					new Date(), new Team("Test2"));
			final ISprint sprint3 = new Sprint("12345", "33", new Date(),
					new Date(), new Team("Test3"));

			p.addSprint(sprint1);
			p.addSprint(sprint2);
			// Sprint3 wird bewusst nicht hinzugefügt

			// FIRST SPRINT<->PBI

			try {
				f1.setSprint(sprint3);
				fail();
			} catch (final Exception e) {
				assertTrue(f1.getSprint() == null);
				assertFalse(sprint1.getPBIs().contains(f1));
			}

			f1.setSprint(sprint1);

			assertEquals(sprint1, f1.getSprint());
			assertTrue(sprint1.getPBIs().contains(f1));

			f1.setSprint(sprint2);
			assertEquals(sprint2, f1.getSprint());
			assertFalse(sprint1.getPBIs().contains(f1));
			assertTrue(sprint2.getPBIs().contains(f1));

			// NOW RELEASE<->PBI
			final IRelease release1 = new Release("R1", new Date(), p);
			final IRelease release2 = new Release("R2", new Date(2011, 10, 11),
					p);
			IRelease release3 = null;

			// Doppelt
			try {
				release3 = new Release("R2", new Date(2011, 10, 11), p);
				fail();
			} catch (final Exception e1) {
				assertTrue(release3 == null);
				assertFalse(p.getReleasePlan().contains(release3));
			}

			assertTrue(p.getReleasePlan().contains(release1));
			assertTrue(p.getReleasePlan().contains(release2));
			assertEquals(p, release1.getProject());
			assertEquals(p, release2.getProject());

			try {
				release1.addSprint(sprint3);
				fail();
			} catch (final Exception e) {
				assertTrue(sprint3.getRelease() == null);
				assertFalse(release1.getSprints().contains(sprint3));
			}

			assertFalse(sprint1.equals(sprint2));
			assertFalse(sprint1.hashCode() == sprint2.hashCode());

			release1.addSprint(sprint1);
			release1.addSprint(sprint2);

			assertEquals(release1, sprint1.getRelease());
			assertEquals(release1, sprint2.getRelease());
			assertTrue(release1.getSprints().contains(sprint1));
			assertTrue(release1.getSprints().contains(sprint2));

			release1.removeSprint(sprint1);
			assertTrue(sprint1.getRelease() == null);
			assertFalse(release1.getSprints().contains(sprint1));
			assertTrue(release1.getSprints().contains(sprint2));

		} catch (final UserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	/**
	 * Testing Change Sprint for PBI
	 */
	public void changeSprintForPBI() {
		try {
			final Project p = new Project("Test");
			final Feature f1 = new Feature("T1", "", p.getBacklog());
			final Feature f2 = new Feature("T2", "", p.getBacklog());
			final ISprint sprint1 = new Sprint("123", "sd", new Date(),
					new Date(), new Team("Test"));
			final ISprint sprint2 = new Sprint("1234", "scb", new Date(),
					new Date(), new Team("Test2"));
			p.addSprint(sprint1);
			p.addSprint(sprint2);

			f1.setSprint(sprint1);
			f1.setSprint(sprint2);

			assertFalse(sprint1.getPBIs().contains(f1));
			assertTrue(sprint2.getPBIs().contains(f1));
			assertEquals(f1.getSprint(), sprint2);

		} catch (final UserException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Testing Change Release for Sprint
	 */
	public void changeReleaseForSprint() {
		try {
			final Project p = new Project("Test");
			final Feature f1 = new Feature("T1", "", p.getBacklog());
			final Feature f2 = new Feature("T2", "", p.getBacklog());
			final ISprint sprint1 = new Sprint("123", "sd", new Date(),
					new Date(), new Team("Test"));
			final ISprint sprint2 = new Sprint("1234", "scb", new Date(),
					new Date(), new Team("Test2"));

			final IRelease release = new Release("R1", new Date(), p);
			final IRelease release2 = new Release("R3", new Date(), p);

			release.addSprint(sprint1);

			assertTrue(release.getSprints().contains(sprint1));
			assertEquals(release, sprint1.getRelease());

			release2.addSprint(sprint1);

			assertTrue(release2.getSprints().contains(sprint1));
			assertEquals(release2, sprint1.getRelease());
			assertFalse(release.getSprints().contains(sprint1));

		} catch (final UserException e) {
			fail(e.getMessage());
		}
	}

	@Test
	/**
	 * Addition of a new element (here: feature)
	 */
	public void testAddPBI() throws Exception {
		final int entriesInList = pbltest.getItems().size();
		new Feature("E", "Test E", pbltest);
		// System.out.println(pbltest.getItems().get(entriesInList));
		assertEquals(entriesInList + 1, pbltest.getItems().size());
	}

	@Test
	/**
	 * Removal of a selected element in PBL
	 */
	public void testDeletePBI() throws Exception {
		final int entriesInList = pbltest.getItems().size();
		pbltest.removeItem(pbltest.getItems().lastElement());

		assertEquals(entriesInList - 1, pbltest.getItems().size());
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	/**
	 * a new Project is created
	 */
	public void testProjectEquals2() throws Exception {
		final Project lvProject = test;
		assertEquals(lvProject, test);
	}

	@Test
	/**
	 * a new PBL is created on creation of a Project
	 */
	public void testPBLEquals2() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		assertEquals(lvBacklog, pbltest);
	}
}
