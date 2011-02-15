package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;
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
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

public class Test_THoch {

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

	@Test
	public void testMoveUp1() throws Exception {
		final ProductBacklogItem item = pbltest.getItems().get(1);
		final int positionOfItemNo2 = pbltest.getItemPositionInList(item);
		pbltest.moveUp(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo2 - 1));
	}

	/**
	 * Move Up auf erstes Element der Liste
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveUp2() throws Exception {
		final ProductBacklogItem holder = pbltest.getItems().get(0);
		pbltest.moveUp(holder);
		assertEquals(holder, pbltest.getItems().get(0));
	}

	@Test
	public void testMoveDown1() throws Exception {
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final int positionOfItemNo1 = pbltest.getItemPositionInList(item);
		pbltest.moveDown(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo1 + 1));
	}

	/**
	 * Move Down auf letztes Element der Liste
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveDown2() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem holder = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	public void testMoveTop1() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveTop(item);
		assertEquals(item, pbltest.getItems().get(0));
	}

	@Test
	public void testMoveTop2() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(lvBacklog, pbltest);
	}

	@Test
	public void testMoveTop3() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		final ProductBacklogItem item2 = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(item2, pbltest.getItems().get(1));
	}

	@Test
	public void testMoveBottom1() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveBottom(item);
		assertEquals(item, pbltest.getItems().get(lastPositionInList));
	}

	@Test
	public void testMoveBottom2() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(lvBacklog, pbltest);
	}

	@Test
	public void testMoveBottom3() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final ProductBacklogItem item2 = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(item2, pbltest.getItems().get(lastPositionInList - 1));
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	public void testAddPBI() throws Exception {
		final int entriesInList = pbltest.countItems();
		new Feature("E", "Test E", pbltest);
		// System.out.println(pbltest.getItems().get(entriesInList));
		assertEquals(entriesInList + 1, pbltest.getItems().size());
	}

	@Test
	public void testDeletePBI() throws Exception {
		final int entriesInList = pbltest.countItems();
		pbltest.removeItem(pbltest.getItems().lastElement());

		assertEquals(entriesInList - 1, pbltest.getItems().size());
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	public void testCount1() throws Exception {
		final Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
	}

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

	// ************************************************************************
	// ************************************************************************

	@Test
	public void testAddRelease() throws Exception {
		final int holder = test.getReleasePlan().size();
		new Release("0.0.1", cvCurrentDate, test);

		assertEquals(holder + 1, test.getReleasePlan().size());
	}

	@Test
	public void testAddRelease2() {
		final int holder = test.getReleasePlan().size();
		try {
			new Release("0.0.1", cvCurrentDate, test);

			fail("keine Fehlermeldung gekommen");
		} catch (final DoubleDefinitionException e) {
			assertEquals(holder, test.getReleasePlan().size());
		}
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	public void testProjectEquals() throws Exception {
		final Project lvProject = test;
		assertEquals(lvProject, test);
	}

	@Test
	public void testPBLEquals() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		assertEquals(lvBacklog, pbltest);
	}

	// ************************************************************************
	// Konsinstenz
	// ************************************************************************

	@Test
	public void testKonsistenzProject1() throws Exception {
		final Project lvProject = new Project("name");
		final ProductBacklog lvBacklog = lvProject.getBacklog();
		// Test, dass sich Project und PBL gegenseitig referenzieren
		assertEquals(lvProject, lvBacklog.getProject());
		assertEquals(lvBacklog, lvProject.getBacklog());
	}

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
		lvProject.getReleasePlan().add(lvRelease);
		assertEquals(1, lvProject.getReleasePlan().size());

		final Project lvProject2 = new Project("name2");
		// lvProject2.addRelease(lvRelease);
		// Test, Release kann nicht mehreren Projekten zugeordnet werden.

		// System.out.println(lvRelease.getProject().toString());
		// System.out.println(lvProject2.getReleasePlan().get(0).getProject().toString());
		assertTrue(!lvProject2.getReleasePlan().contains(lvRelease));
		// TODO Projekte verweisen aufs selbe Release, Release weiterhin auf
		// Projekt 1 **/

		// assertEquals(lvRelease, lvProject2.getReleasePlan().get(0));
	}

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

		// TODO Verbindungen zwischen Release und Project trennen
		assertTrue(!lvProject.getReleasePlan().contains(lvRelease));
		assertTrue(lvRelease.getProject() == null);
		assertTrue(lvSprint.getRelease() == null);
		assertTrue(!lvRelease.getSprints().contains(lvSprint));
	}

	// ************************************************************************
	// ************************************************************************

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
	// ************************************************************************

	@Test
	public void testDoubleDefinedForProjectInRoot() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		try {
			lvRoot.addProject(lvProject);
			fail("Doppelte Definition von Projekten");
			// TODO: Doppelte Definition von Projekten
		} catch (final Exception e) {
			assertTrue(true);
		}
	}

	@Test(expected = DoubleDefinitionException.class)
	public void testDoubleDefinedForReleaseInProject() throws Exception {
		final Root lvRoot = new Root();
		final Project lvProject = new Project("name");
		lvRoot.addProject(lvProject);
		new Release("0.0.1", cvCurrentDate, lvProject);
		new Release("0.0.1", cvCurrentDate, lvProject);
		fail();
	}

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

}
