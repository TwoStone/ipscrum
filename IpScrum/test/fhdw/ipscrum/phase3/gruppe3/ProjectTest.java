package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import java.util.Vector;
import org.junit.*;
import fhdw.ipscrum.shared.model.ConcreteSystem;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;

/**
 * The class <code>ProjectTest</code> contains tests for the class <code>{@link Project}</code>.
 *
 * @generatedBy CodePro at 05.03.11 11:25
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ProjectTest {
	/**
	 * Run the Project(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testProject_1()
		throws Exception {
		String name = "";

		Project result = new Project(name);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Project [name=]", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Integer(0), result.countSprints());
		assertEquals(992, result.indirectHashCode());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void accept(ITreeConstructionVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		ITreeConstructionVisitor treeVisitor = null;

		fixture.accept(treeVisitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.Project.accept(Project.java:80)
	}

	/**
	 * Run the void addPossibleSystem(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddPossibleSystem_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		System system = new ConcreteSystem("", new Rootsystem());

		fixture.addPossibleSystem(system);

		// add additional test code here
	}

	/**
	 * Run the void addPossibleSystem(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddPossibleSystem_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		System system = new ConcreteSystem("", new Rootsystem());

		fixture.addPossibleSystem(system);

		// add additional test code here
	}

	/**
	 * Run the void addSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddSprint_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.addSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void addSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAddSprint_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.addSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the Integer countSprints() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testCountSprints_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		Integer result = fixture.countSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals("0", result.toString());
		assertEquals((byte) 0, result.byteValue());
		assertEquals(0.0, result.doubleValue(), 1.0);
		assertEquals(0.0f, result.floatValue(), 1.0f);
		assertEquals(0, result.intValue());
		assertEquals(0L, result.longValue());
		assertEquals((short) 0, result.shortValue());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the ProductBacklog getBacklog() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetBacklog_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		ProductBacklog result = fixture.getBacklog();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ProductBacklog", result.toString());
		assertEquals(new Integer(0), result.countItems());
		assertEquals(992, result.indirectHashCode());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<System> getPossibleSystems() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetPossibleSystems_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		List<System> result = fixture.getPossibleSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the Vector<IRelease> getReleasePlan() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetReleasePlan_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		Vector<IRelease> result = fixture.getReleasePlan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<IRelease> getReleasePlan() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetReleasePlan_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		Vector<IRelease> result = fixture.getReleasePlan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<ISprint> getSprints() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetSprints_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		Vector<ISprint> result = fixture.getSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<ISprint> getSprints() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetSprints_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		Vector<ISprint> result = fixture.getSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Project fixture = new Project((String) null);
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(29614176, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(29614176, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Project obj = new Project("");
		obj.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project("");

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Project fixture = new Project((String) null);
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		Object obj = new Project((String) null);

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectHashCode_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(992, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectHashCode_2()
		throws Exception {
		Project fixture = new Project((String) null);
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(992, result);
	}

	/**
	 * Run the void isReleaseDoubleDefined(String,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsReleaseDoubleDefined_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		String version = "";
		Date releaseDate = new Date();

		fixture.isReleaseDoubleDefined(version, releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void isReleaseDoubleDefined(String,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsReleaseDoubleDefined_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		String version = "";
		Date releaseDate = new Date();

		fixture.isReleaseDoubleDefined(version, releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void isReleaseDoubleDefined(String,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsReleaseDoubleDefined_3()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		String version = "";
		Date releaseDate = new Date();

		fixture.isReleaseDoubleDefined(version, releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void isReleaseDoubleDefined(String,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsReleaseDoubleDefined_4()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		String version = "";
		Date releaseDate = new Date();

		fixture.isReleaseDoubleDefined(version, releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void isSprintDefined(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsSprintDefined_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.isSprintDefined(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void isSprintDefined(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIsSprintDefined_2()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.isSprintDefined(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void removeRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testRemoveRelease_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.removeRelease(release);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Project fixture = new Project("");
		fixture.addPossibleSystem(new ConcreteSystem("", new Rootsystem()));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Project [name=]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProjectTest.class);
	}
}