package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
import fhdw.ipscrum.shared.exceptions.WrongSystemException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * The class <code>BugTest</code> contains tests for the class
 * <code>{@link Bug}</code>.
 * 
 */
public class BugTest {
	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testBug_1() throws Exception {
		final String name = "";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(name, description, version, backlog);
	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = WrongReleaseException.class)
	public void testBug_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = null;
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(name, description, version, backlog);
	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBug_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		assertEquals("Bug", bug.getName());
		assertEquals("", bug.getDescription());
		assertEquals(backlog, bug.getBacklog());
		assertEquals(pro, bug.getBacklog().getProject());
		assertEquals(version, bug.getVersion());
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccept_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(name, description, version, backlog);

		final IProductBacklogItemVisitor visitor = new IProductBacklogItemVisitor() {

			@Override
			public void handleFeature(final Feature feature) {
				fail();
			}

			@Override
			public void handleBug(final Bug bug) {
				assertEquals(expected, bug);
			}
		};

		expected.accept(visitor);
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddSystem_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		assertEquals(2, bug.getSystems().size());
		assertTrue(bug.getSystems().contains(sys1));
		assertTrue(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = WrongSystemException.class)
	public void testAddSystem_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = WrongSystemException.class)
	public void testAddSystem_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final Project pro2 = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);

		pro2.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testAddSystem_4() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.close();

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the IRelease getVersion() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetVersion_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);

		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(name, description, version, backlog);

		assertEquals(version, expected.getVersion());
	}

	/**
	 * Run the IBugState getState() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetState_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);

		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(name, description, version, backlog);

		final IPBIStateVisitor visitor = new IPBIStateVisitor() {

			@Override
			public void handleOpen(final PBIOpenState open) {
				assertTrue(true);
			}

			@Override
			public void handleClosed(final PBIClosedState closed) {
				fail();
			}
		};

		expected.getState().accept(visitor);
	}

	/**
	 * Run the IBugState getState() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetState_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);

		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(name, description, version, backlog);

		expected.close();

		final IPBIStateVisitor visitor = new IPBIStateVisitor() {

			@Override
			public void handleOpen(final PBIOpenState open) {
				fail();
			}

			@Override
			public void handleClosed(final PBIClosedState closed) {
				assertTrue(true);
			}
		};

		expected.getState().accept(visitor);
	}

	/**
	 * Run the Collection<System> getSystems() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		assertEquals(2, bug.getSystems().size());
		assertTrue(bug.getSystems().contains(sys1));
		assertTrue(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void removeSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRemoveSystem_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		bug.removeSystem(sys2);

		assertEquals(1, bug.getSystems().size());
		assertTrue(bug.getSystems().contains(sys1));
		assertFalse(bug.getSystems().contains(sys2));

		bug.removeSystem(sys1);

		assertEquals(0, bug.getSystems().size());
		assertFalse(bug.getSystems().contains(sys1));
		assertFalse(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void removeSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testRemoveSystem_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		bug.removeSystem(sys2);

		assertEquals(1, bug.getSystems().size());
		assertTrue(bug.getSystems().contains(sys1));
		assertFalse(bug.getSystems().contains(sys2));

		bug.close();

		bug.removeSystem(sys1);

		fail();
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetVersion_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final IRelease version2 = new Release("R2", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setVersion(version2);

		assertEquals(version2, bug.getVersion());
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetVersion_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final IRelease version2 = new Release("R2", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setVersion(version2);

		fail();
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test(expected = WrongReleaseException.class)
	public void testSetVersion_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setVersion(null);
		fail();
	}

	/**
	 * Run the void setName() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetName_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setName("Hallo Welt Bug");

		assertEquals("Hallo Welt Bug", bug.getName());
	}

	/**
	 * Run the void setName() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetName_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setName("Hallo Welt Bug");
	}

	/**
	 * Run the void setName() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testSetName_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setName("  		");

		fail();
	}

	/**
	 * Run the void setDescription() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setDescription("Test");

		assertEquals("Test", bug.getDescription());
	}

	/**
	 * Run the void setDescription() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetDescription_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setDescription("Test");

		fail();
	}

	/**
	 * Run the void setLastEditor() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetLastEditor_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setLastEditor(new Person("Test", "Test2"));

		assertEquals(new Person("Test", "Test2"), bug.getLastEditor());
	}

	/**
	 * Run the void setLastEditor() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetLastEditor_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setLastEditor(new Person("Test", "Test2"));

		fail();
	}

	/**
	 * Run the void setManDayCosts() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetManDayCosts_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setManDayCosts(4);

		assertEquals(new Integer(4), bug.getManDayCosts());
	}

	/**
	 * Run the void setManDayCosts() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetManDayCosts_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setManDayCosts(4);
	}

	/**
	 * Run the void setSprint() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetSprint_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final Sprint sprint = new Sprint("Sprint", "Test", new Date(),
				new Date(), new Team("Testteam"));
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();
		pro.addSprint(sprint);

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setSprint(sprint);

		assertEquals(sprint, bug.getSprint());
		assertTrue(sprint.getPBIs().contains(bug));
	}

	/**
	 * Run the void setSprint() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetSprint_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final Sprint sprint = new Sprint("Sprint", "Test", new Date(),
				new Date(), new Team("Testteam"));
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();
		pro.addSprint(sprint);

		final Bug bug = new Bug(name, description, version, backlog);

		bug.setSprint(sprint);
		bug.setSprint(null);

		assertTrue(bug.getSprint() == null);
		assertFalse(sprint.getPBIs().contains(bug));
	}

	/**
	 * Run the void setSprint() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetSprint_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro");
		final Sprint sprint = new Sprint("Sprint", "Test", new Date(),
				new Date(), new Team("Testteam"));
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();
		pro.addSprint(sprint);

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		bug.setSprint(sprint);
	}

	/*
	 * ein Akzeptanzkriterium zu einem Bug hinzufügen
	 */
	@Test
	public void addAcceptanceCriterion() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"TestAcceptanceCriterion");
		assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion);
		assertTrue(bug.getAcceptanceCriteria().listIterator().hasNext());
		assertEquals(acceptanceCriterion, bug.getAcceptanceCriteria()
				.listIterator().next());
	}

	/*
	 * zwei gleiche Akzeptanzkriterien zu einem Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DiffenretObjects()
			throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final AcceptanceCriterion acceptanceCriterion1 = new AcceptanceCriterion(
				"TestAcceptanceCriterion");
		final AcceptanceCriterion acceptanceCriterion2 = new AcceptanceCriterion(
				"TestAcceptanceCriterion");
		assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion1);
		bug.addAcceptanceCriterion(acceptanceCriterion2);
	}

	/*
	 * das selbe Akzeptanzkriterium 2x zu einem Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DoubleAdd()
			throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"TestAcceptanceCriterion");
		assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion);
		bug.addAcceptanceCriterion(acceptanceCriterion);
	}

	/*
	 * ein Akzeptanzkriterium zu einem geschlossenen Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addAcceptanceCriterionToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		assertTrue(bug.getState() instanceof PBIClosedState);

		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"TestAcceptanceCriterion");

		bug.addAcceptanceCriterion(acceptanceCriterion);
	}

	/*
	 * einen Hinweis zu einem Bug hinzufügen
	 */
	@Test
	public void addHint() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final String content = "TestHint";
		final Hint hint = new Hint(content);
		assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint);
		assertTrue(bug.getHints().listIterator().hasNext());
		assertEquals(hint, bug.getHints().listIterator().next());
		assertEquals(content, bug.getHints().listIterator().next().getContent());
	}

	/*
	 * zwei gleiche Hinweise zu einem Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DiffenretObjects() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Hint hint1 = new Hint("TestHint");
		final Hint hint2 = new Hint("TestHint");
		assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint1);
		bug.addHint(hint2);
	}

	/*
	 * den selben Hinweis 2x zu einem Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DoubleAdd() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Hint hint = new Hint("TestHint");
		assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint);
		bug.addHint(hint);
	}

	/*
	 * einen Hinweis zu einem geschlossenen Bug hinzufgüen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addHintToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();

		assertTrue(bug.getState() instanceof PBIClosedState);

		final Hint hint = new Hint("TestHint");

		bug.addHint(hint);
	}

	/*
	 * eine Relation zu einem geschlossenen Bug hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addRelationToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		bug.close();
		assertTrue(bug.getState() instanceof PBIClosedState);

		if (SessionManager.getInstance().getModel().getRelationTypeManager()
				.getRelationTypes().iterator().hasNext() == false) {
			RelationType.create("TestRelationType");
		}

		final RelationType relationType = SessionManager.getInstance()
				.getModel().getRelationTypeManager().getRelationTypes()
				.iterator().next();
		final Relation relation = new Relation(relationType, bug);

		assertFalse(bug.getRelations().iterator().hasNext());
		bug.addRelation(relation);
	}

	/*
	 * eine Relation zu einem anderen Bug hinzufügen und dabei einen vorhandenen
	 * Relations-Typ auswählen
	 */
	@Test
	public void addRelationToOtherFeatureWithoutNewRelationType()
			throws Exception {
		if (SessionManager.getInstance().getModel().getRelationTypeManager()
				.getRelationTypes().iterator().hasNext() == false) {
			RelationType.create("TestRelationType");
		}

		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);
		final Bug bug2 = new Bug(name + "Test", description, version, backlog);

		final RelationType relationType = SessionManager.getInstance()
				.getModel().getRelationTypeManager().getRelationTypes()
				.iterator().next();
		final Relation relation = new Relation(relationType, bug2);

		assertFalse(bug.getRelations().iterator().hasNext());
		bug.addRelation(relation);
		assertTrue(bug.getRelations().iterator().hasNext());
		assertEquals(relation, bug.getRelations().iterator().next());
		assertEquals(relationType, bug.getRelations().iterator().next()
				.getType());

	}

	/*
	 * eine Relation auf den eigenen Bug hinzufügen und dabei einen neuen
	 * Relations-Typ angeben
	 */
	@Test
	public void addRelationToOwnFeatureWithNewRelationType() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final RelationType relationType = RelationType
				.create("TestRelationType2");
		final Relation relation = new Relation(relationType, bug);

		assertFalse(bug.getRelations().iterator().hasNext());
		bug.addRelation(relation);
		assertTrue(bug.getRelations().iterator().hasNext());
		assertEquals(relation, bug.getRelations().iterator().next());
		assertEquals(relationType, bug.getRelations().iterator().next()
				.getType());
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(BugTest.class);
	}
}