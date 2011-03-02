package fhdw.ipscrum.phase3.gruppe3;

import java.util.HashSet;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import java.util.Vector;
import org.junit.*;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.RelationTypeManager;
import fhdw.ipscrum.shared.model.Root;
import static org.junit.Assert.*;

/**
 * The class <code>RootTest</code> contains tests for the class <code>{@link Root}</code>.
 *
 * @generatedBy CodePro at 02.03.11 20:35
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RootTest {
	/**
	 * Run the void addPerson(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddPerson_1()
		throws Exception {
		Root fixture = new Root();
		IPerson person = new Person("", "");

		fixture.addPerson(person);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:78)
		//       at fhdw.ipscrum.shared.model.Person.<init>(Person.java:39)
	}

	/**
	 * Run the void addPerson(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddPerson_2()
		throws Exception {
		Root fixture = new Root();
		IPerson person = new Person("", "");

		fixture.addPerson(person);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein vollständiger Name angegeben werden.
		//       at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:78)
		//       at fhdw.ipscrum.shared.model.Person.<init>(Person.java:39)
	}

	/**
	 * Run the void addProject(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddProject_1()
		throws Exception {
		Root fixture = new Root();
		Project project = new Project("");

		fixture.addProject(project);

		// add additional test code here
	}

	/**
	 * Run the void addProject(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddProject_2()
		throws Exception {
		Root fixture = new Root();
		Project project = new Project("");

		fixture.addProject(project);

		// add additional test code here
	}

	/**
	 * Run the void addRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddRole_1()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.addRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void addRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddRole_2()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.addRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void addTeam(ITeam) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddTeam_1()
		throws Exception {
		Root fixture = new Root();
		ITeam team = new Team("");

		fixture.addTeam(team);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:55)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:30)
	}

	/**
	 * Run the void addTeam(ITeam) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddTeam_2()
		throws Exception {
		Root fixture = new Root();
		ITeam team = new Team("");

		fixture.addTeam(team);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:55)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:30)
	}

	/**
	 * Run the Integer countPersons() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testCountPersons_1()
		throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countPersons();

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
	 * Run the Integer countProjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testCountProjects_1()
		throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countProjects();

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
	 * Run the Integer countRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testCountRoles_1()
		throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countRoles();

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
	 * Run the Integer countTeams() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testCountTeams_1()
		throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countTeams();

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
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Root fixture = new Root();
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Root fixture = new Root();
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
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_9()
		throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the void existsProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testExistsProjectName_1()
		throws Exception {
		Root fixture = new Root();
		String name = "";

		fixture.existsProjectName(name);

		// add additional test code here
	}

	/**
	 * Run the void existsProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testExistsProjectName_2()
		throws Exception {
		Root fixture = new Root();
		String name = "";

		fixture.existsProjectName(name);

		// add additional test code here
	}

	/**
	 * Run the void existsProjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testExistsProjectName_3()
		throws Exception {
		Root fixture = new Root();
		String name = "";

		fixture.existsProjectName(name);

		// add additional test code here
	}

	/**
	 * Run the HashSet<IPerson> getPersons() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetPersons_1()
		throws Exception {
		Root fixture = new Root();

		HashSet<IPerson> result = fixture.getPersons();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<IPerson> getPersons() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetPersons_2()
		throws Exception {
		Root fixture = new Root();

		HashSet<IPerson> result = fixture.getPersons();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<Project> getProjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetProjects_1()
		throws Exception {
		Root fixture = new Root();

		Vector<Project> result = fixture.getProjects();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<Project> getProjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetProjects_2()
		throws Exception {
		Root fixture = new Root();

		Vector<Project> result = fixture.getProjects();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the RelationTypeManager getRelationTypeManager() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetRelationTypeManager_1()
		throws Exception {
		Root fixture = new Root();

		RelationTypeManager result = fixture.getRelationTypeManager();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the RelationTypeManager getRelationTypeManager() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetRelationTypeManager_2()
		throws Exception {
		Root fixture = new Root();

		RelationTypeManager result = fixture.getRelationTypeManager();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the HashSet<IRole> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		Root fixture = new Root();

		HashSet<IRole> result = fixture.getRoles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<IRole> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetRoles_2()
		throws Exception {
		Root fixture = new Root();

		HashSet<IRole> result = fixture.getRoles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<ITeam> getTeams() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetTeams_1()
		throws Exception {
		Root fixture = new Root();

		HashSet<ITeam> result = fixture.getTeams();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<ITeam> getTeams() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetTeams_2()
		throws Exception {
		Root fixture = new Root();

		HashSet<ITeam> result = fixture.getTeams();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Root fixture = new Root();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(924482, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Root fixture = new Root();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(924482, result);
	}

	/**
	 * Run the void removeProject(Project) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveProject_1()
		throws Exception {
		Root fixture = new Root();
		Project project = new Project("");

		fixture.removeProject(project);

		// add additional test code here
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveRole_1()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.removeRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveRole_2()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.removeRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveRole_3()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.removeRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveRole_4()
		throws Exception {
		Root fixture = new Root();
		IRole role = new Role("");

		fixture.removeRole(role);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:72)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:32)
	}

	/**
	 * Run the void save(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSave_1()
		throws Exception {
		Root fixture = new Root();
		String identifier = "";

		fixture.save(identifier);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Root fixture = new Root();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Root", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
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
	 * @generatedBy CodePro at 02.03.11 20:35
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
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RootTest.class);
	}
}