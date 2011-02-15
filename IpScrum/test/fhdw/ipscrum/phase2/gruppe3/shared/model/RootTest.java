package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationTypeManager;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * The class <code>RootTest</code> contains tests for the class
 * <code>{@link Root}</code>.
 */
public class RootTest {

	/**
	 * Run the void addPerson(IPerson) method test.
	 */
	@Test
	public void testAddPerson_1() throws Exception {
		Root fixture = new Root();
		IPerson person = new Person("firstname", "lastname");

		assertEquals(0, fixture.getPersons().size());
		fixture.addPerson(person);
		assertEquals(1, fixture.getPersons().size());
	}

	/**
	 * Run the void addPerson(IPerson) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testAddPerson_2() throws Exception {
		Root fixture = new Root();
		IPerson person = new Person("firstname", "lastname");

		assertEquals(0, fixture.getPersons().size());
		fixture.addPerson(person);
		fixture.addPerson(person);
		assertEquals(1, fixture.getPersons().size());
	}

	/**
	 * Run the void addPerson(IPerson) method test.
	 */
	@Test
	public void testAddPerson_3() throws Exception {
		Root fixture = new Root();
		IPerson person1 = new Person("firstname1", "lastname1");
		IPerson person2 = new Person("firstname2", "lastname2");

		assertEquals(0, fixture.getPersons().size());
		fixture.addPerson(person1);
		fixture.addPerson(person2);
		assertEquals(2, fixture.getPersons().size());
	}

	/**
	 * Run the void addProject(Project) method test.
	 */
	@Test
	public void testAddProject_1() throws Exception {
		Root fixture = new Root();
		Project project = new Project("project");

		fixture.addProject(project);
		fail(); // TODO
	}

	/**
	 * Run the void addRole(IRole) method test.
	 */
	@Test
	public void testAddRole_1() throws Exception {
		Root fixture = new Root();
		IRole role = new Role("role");

		fixture.addRole(role);
		assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void addRole(IRole) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testAddRole_2() throws Exception {
		Root fixture = new Root();
		IRole role = new Role("role");

		fixture.addRole(role);
		fixture.addRole(role);
		assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void addRole(IRole) method test.
	 */
	@Test
	public void testAddRole_3() throws Exception {
		Root fixture = new Root();
		IRole role1 = new Role("role1");
		IRole role2 = new Role("role2");
		fixture.addRole(role1);
		fixture.addRole(role2);
		assertEquals(2, fixture.getRoles().size());
	}

	/**
	 * Run the void addTeam(ITeam) method test.
	 */
	@Test
	public void testAddTeam_1() throws Exception {
		Root fixture = new Root();
		ITeam team = new Team("team");

		fixture.addTeam(team);
		assertEquals(1, fixture.getTeams().size());
	}

	/**
	 * Run the void addTeam(ITeam) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testAddTeam_2() throws Exception {
		Root fixture = new Root();
		ITeam team = new Team("team");

		fixture.addTeam(team);
		fixture.addTeam(team);
		assertEquals(1, fixture.getTeams().size());
	}

	/**
	 * Run the void addTeam(ITeam) method test.
	 */
	@Test
	public void testAddTeam_3() throws Exception {
		Root fixture = new Root();
		ITeam team1 = new Team("team1");
		ITeam team2 = new Team("team2");

		fixture.addTeam(team1);
		fixture.addTeam(team2);
		assertEquals(2, fixture.getTeams().size());
	}

	/**
	 * Run the Integer countPersons() method test.
	 */
	@Test
	public void testCountPersons_1() throws Exception {
		Root fixture = new Root();
		Integer result = fixture.countPersons();
		assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countPersons() method test.
	 */
	@Test
	public void testCountPersons_2() throws Exception {
		Root fixture = new Root();
		IPerson person1 = new Person("firstname1", "lastname1");
		IPerson person2 = new Person("firstname2", "lastname2");
		fixture.addPerson(person1);
		fixture.addPerson(person2);

		Integer result = fixture.countPersons();
		assertEquals(2, result.intValue());
	}

	/**
	 * Run the Integer countProjects() method test.
	 */
	@Test
	public void testCountProjects_1() throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countProjects();

		assertNotNull(result);
		assertEquals("0", result.toString());
		assertEquals((byte) 0, result.byteValue());
		assertEquals(0.0, result.doubleValue(), 1.0);
		assertEquals(0.0f, result.floatValue(), 1.0f);
		assertEquals(0, result.intValue());
		assertEquals(0L, result.longValue());
		assertEquals((short) 0, result.shortValue());
		fail(); // TODO
	}

	/**
	 * Run the Integer countRoles() method test.
	 */
	@Test
	public void testCountRoles_1() throws Exception {
		Root fixture = new Root();

		Integer result = fixture.countRoles();
		assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countRoles() method test.
	 */
	@Test
	public void testCountRoles_2() throws Exception {
		Root fixture = new Root();
		IRole role1 = new Role("role1");
		IRole role2 = new Role("role2");
		fixture.addRole(role1);
		fixture.addRole(role2);

		Integer result = fixture.countRoles();
		assertEquals(2, result.intValue());
	}

	/**
	 * Run the Integer countTeams() method test.
	 */
	@Test
	public void testCountTeams_1() throws Exception {
		Root fixture = new Root();
		Integer result = fixture.countTeams();

		assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countTeams() method test.
	 */
	@Test
	public void testCountTeams_2() throws Exception {
		Root fixture = new Root();
		ITeam team1 = new Team("team1");
		ITeam team2 = new Team("team2");
		fixture.addTeam(team1);
		fixture.addTeam(team2);

		Integer result = fixture.countTeams();
		assertEquals(2, result.intValue());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_1() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() throws Exception {
		Root fixture = new Root();
		Object obj = null;

		boolean result = fixture.equals(obj);
		assertEquals(false, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_3() throws Exception {
		Root fixture = new Root();
		Object obj = new Object();

		boolean result = fixture.equals(obj);
		assertEquals(false, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_4() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_5() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_6() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_7() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_8() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();
		fail(); // TODO

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_9() throws Exception {
		Root fixture = new Root();
		Object obj = new Root();

		boolean result = fixture.equals(obj);
		assertEquals(true, result);
		fail(); // TODO
	}

	/**
	 * Run the HashSet<IPerson> getPersons() method test.
	 */
	@Test
	public void testGetPersons_1() throws Exception {
		Root fixture = new Root();

		HashSet<IPerson> result = fixture.getPersons();
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<IPerson> getPersons() method test.
	 */
	@Test
	public void testGetPersons_2() throws Exception {
		Root fixture = new Root();
		IPerson person1 = new Person("firstname1", "lastname1");
		IPerson person2 = new Person("firstname2", "lastname2");
		fixture.addPerson(person1);
		fixture.addPerson(person2);

		HashSet<IPerson> result = fixture.getPersons();
		assertEquals(2, result.size());
	}

	/**
	 * Run the Vector<Project> getProjects() method test.
	 */
	@Test
	public void testGetProjects_1() throws Exception {
		Root fixture = new Root();

		Vector<Project> result = fixture.getProjects();

		assertNotNull(result);
		assertEquals(0, result.size());
		fail(); // TODO
	}

	/**
	 * Run the Vector<Project> getProjects() method test.
	 */
	@Test
	public void testGetProjects_2() throws Exception {
		Root fixture = new Root();

		Vector<Project> result = fixture.getProjects();

		assertNotNull(result);
		assertEquals(0, result.size());
		fail(); // TODO
	}

	/**
	 * Run the RelationTypeManager getRelationTypeManager() method test.
	 */
	@Test
	public void testGetRelationTypeManager_1() throws Exception {
		Root fixture = new Root();

		RelationTypeManager result = fixture.getRelationTypeManager();

		assertNotNull(result);
		fail(); // TODO
	}

	/**
	 * Run the RelationTypeManager getRelationTypeManager() method test.
	 */
	@Test
	public void testGetRelationTypeManager_2() throws Exception {
		Root fixture = new Root();

		RelationTypeManager result = fixture.getRelationTypeManager();

		assertNotNull(result);
		fail(); // TODO
	}

	/**
	 * Run the HashSet<IRole> getRoles() method test.
	 */
	@Test
	public void testGetRoles_1() throws Exception {
		Root fixture = new Root();

		HashSet<IRole> result = fixture.getRoles();
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<IRole> getRoles() method test.
	 */
	@Test
	public void testGetRoles_2() throws Exception {
		Root fixture = new Root();
		IRole role1 = new Role("role1");
		IRole role2 = new Role("role2");
		fixture.addRole(role1);
		fixture.addRole(role2);

		HashSet<IRole> result = fixture.getRoles();
		assertEquals(2, result.size());
	}

	/**
	 * Run the HashSet<ITeam> getTeams() method test.
	 */
	@Test
	public void testGetTeams_1() throws Exception {
		Root fixture = new Root();

		HashSet<ITeam> result = fixture.getTeams();
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<ITeam> getTeams() method test.
	 */
	@Test
	public void testGetTeams_2() throws Exception {
		Root fixture = new Root();
		ITeam team1 = new Team("team1");
		ITeam team2 = new Team("team2");
		fixture.addTeam(team1);
		fixture.addTeam(team2);

		HashSet<ITeam> result = fixture.getTeams();
		assertEquals(2, result.size());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_1() throws Exception {
		Root fixture = new Root();

		int result = fixture.hashCode();

		assertEquals(924482, result);
		fail(); // TODO
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_2() throws Exception {
		Root fixture = new Root();

		int result = fixture.hashCode();

		assertEquals(924482, result);
		fail(); // TODO
	}

	/**
	 * Run the void removeProject(Project) method test.
	 */
	@Test
	public void testRemoveProject_1() throws Exception {
		Root fixture = new Root();
		// Project project = new Project("");

		// fixture.removeProject(project);
		fail(); // TODO
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test
	public void testRemoveRole_1() throws Exception {
		Root fixture = new Root();
		IRole role = new Role("role");
		fixture.addRole(role);

		fixture.removeRole(role);
		assertEquals(0, fixture.getRoles().size());
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ConsistencyException.class)
	public void testRemoveRole_2() throws Exception {
		Root fixture = new Root();
		IRole role1 = new Role("role1");
		IRole role2 = new Role("role2");
		fixture.addRole(role1);

		assertEquals(1, fixture.getRoles().size());
		fixture.removeRole(role2);
		assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test
	public void testRemoveRole_3() throws Exception {
		Root fixture = new Root();
		IRole role1 = new Role("role1");
		IRole role2 = new Role("role2");
		fixture.addRole(role1);
		fixture.addRole(role2);

		assertEquals(2, fixture.getRoles().size());
		fixture.removeRole(role1);
		assertEquals(1, fixture.getRoles().size());
		assertTrue(fixture.getRoles().contains(role2));
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ConsistencyException.class)
	public void testRemoveRole_4() throws Exception {
		Root fixture = new Root();
		IRole role = new Role("role");
		fixture.addRole(role);
		IPerson person = new Person("firstname", "lastname");
		person.addRole(role);

		assertEquals(1, fixture.getRoles().size());
		fixture.removeRole(role);
		assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void save(String) method test.
	 */
	@Test
	public void testSave_1() throws Exception {
		Root fixture = new Root();
		String identifier = "";

		fixture.save(identifier);
		fail(); // TODO
	}

	/**
	 * Run the String toString() method test.
	 */
	@Test
	public void testToString_1() throws Exception {
		Root fixture = new Root();

		String result = fixture.toString();

		assertEquals("Root", result);
		fail(); // TODO
	}

	/**
	 * Perform pre-test initialization.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RootTest.class);
	}
}