package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.model.metamodel.search.And;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;
import fhdw.ipscrum.shared.model.userRights.RightManager;

/**
 * The class <code>ModelRootTest</code> contains tests for the class <code>{@link Model}</code>. Earlier this was class
 * Root!
 */
public class ModelRootTest {

	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model;

	/**
	 * Run the void addPerson(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPerson1() throws Exception {
		new Person(this.model, "firstname", "lastname");

		Assert.assertEquals(1, this.model.getAllPersons().size());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals() throws Exception {
		Assert.assertEquals(true, this.model.equals(this.model));
		Assert.assertEquals(true, this.model.equals(new Model(this.model.getRevisionDate())));
		Assert.assertEquals(false, this.model.equals(null));
		Assert.assertEquals(false, this.model.equals(new Object()));
		Assert.assertEquals(false, this.model.equals(new Model(null)));
		new Person(this.model, "asd", "asdsas");
		Assert.assertEquals(false, this.model.equals(new Model(new Date())));
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHashCode() throws Exception {
		Assert.assertEquals(this.model.hashCode(), this.model.hashCode());
		Assert.assertEquals(this.model.hashCode(), new Model(this.model.getRevisionDate()).hashCode());
		Assert.assertEquals(false, this.model.hashCode() == new Object().hashCode());
		Assert.assertEquals(false, this.model.hashCode() == new Model(null).hashCode());
		new Person(this.model, "asd", "asdsas");
		Assert.assertEquals(false, this.model.hashCode() == new Model(new Date()).hashCode());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testViewOnlyFlag() throws Exception {
		Assert.assertEquals(false, this.model.getViewOnlyFlag());
		this.model.setViewOnlyFlag(true);
		Assert.assertEquals(true, this.model.getViewOnlyFlag());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSearchManager() throws Exception {
		Assert.assertEquals(this.model.getSearchManager(), this.model.getSearchManager());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTypeManager() throws Exception {
		this.model.setTypeManager(null);
		Assert.assertEquals(this.model.getSearchManager(), this.model.getSearchManager());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetRighteManager() throws Exception {
		final RightManager rm = new RightManager();
		this.model.setRightManager(rm);
		Assert.assertEquals(rm, this.model.getRightManager());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAuthorityManager() throws Exception {
		this.model.setAuthorityChecker(null);
		Assert.assertEquals(this.model.getAuthorityChecker(), this.model.getAuthorityChecker());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSprintsByTeam() throws Exception {
		Assert.assertEquals(0, this.model.getSprintsByTeam(new Team(this.model, "asda")).size());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveProjectAndCountProjects() throws Exception {
		final Project project = new Project(this.model, "name");
		Assert.assertEquals(1, this.model.getProjects().size());
		Assert.assertEquals(Integer.valueOf(1), this.model.countProjects());
		this.model.removeProject(project);
		Assert.assertEquals(0, this.model.getProjects().size());
		Assert.assertEquals(Integer.valueOf(0), this.model.countProjects());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystems() throws Exception {
		Assert.assertEquals(this.model.getSystems(), this.model.getSystems());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAllSearchings() throws Exception {
		final Search s = new Search(this.model, "", new And(this.model));
		Assert.assertEquals(false, new Model(new Date()).getAllSearchings().contains(s));
		Assert.assertEquals(false, new Model(new Date()).getSearching().contains(s));
		this.model.removeSearch(s);
		Assert.assertEquals(new Integer(0), this.model.countSearchings());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddIncidents() throws Exception {
		this.model.addIncident(new OneParticipantIncident(this.model, new Date(), new Date(), new Person(this.model,
				"asdadad", "ddddd")));
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAllPBITicketTypes() throws Exception {
		Assert.assertEquals(0, this.model.getAllPBITicketTypes().size());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAllBugTicketTypes() throws Exception {
		Assert.assertEquals(0, this.model.getAllBugTicketTypes().size());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAllIncidentTypes() throws Exception {
		Assert.assertEquals(0, this.model.getAllIncidentTypes().size());
	}

	/**
	 * Run the method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetAllTasks() throws Exception {
		Assert.assertEquals(0, this.model.getAllTasks().size());
	}

	/**
	 * Run the void addPerson(Person) method test. with a person already added to check if the exception is thrown
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void testAddPerson2() throws Exception {
		new Person(this.model, "firstname", "lastname");
		new Person(this.model, "firstname", "lastname");

		Assert.assertEquals(1, this.model.getAllPersons().size());
	}

	/**
	 * Run the void addPerson(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPerson3() throws Exception {
		Assert.assertEquals(0, this.model.getAllPersons().size());
		new Person(this.model, "firstname1", "lastname1");
		new Person(this.model, "firstname2", "lastname2");

		Assert.assertEquals(2, this.model.getAllPersons().size());
	}

	/**
	 * Run the void addRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddRole1() throws Exception {
		new Role(this.model, "role");

		Assert.assertEquals(1, this.model.getAllRoles().size());
	}

	/**
	 * Run the void addRole(Role) method test. with r role already added to check if the exception is thrown
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void testAddRole2() throws Exception {
		new Role(this.model, "role");
		new Role(this.model, "role");
		Assert.fail();
	}

	/**
	 * Run the void addRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddRole3() throws Exception {
		new Role(this.model, "role1");
		new Role(this.model, "role2");
		Assert.assertEquals(2, this.model.getAllRoles().size());
	}

	/**
	 * Run the void addTeam(Team) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddTeam1() throws Exception {
		new Team(this.model, "team");

		Assert.assertEquals(1, this.model.getAllTeams().size());
	}

	/**
	 * Run the void addTeam(Team) method test. With a model already added to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void testAddTeam2() throws Exception {
		new Team(this.model, "team");
		new Team(this.model, "team");

		Assert.fail();
	}

	/**
	 * Run the void addTeam(Team) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddTeam3() throws Exception {
		new Team(this.model, "team1");
		new Team(this.model, "team2");

		Assert.assertEquals(2, this.model.getAllTeams().size());
	}

	/**
	 * Run the Integer countPersons() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountPersons1() throws Exception {
		final Integer result = this.model.countPersons();
		Assert.assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countPersons() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountPersons2() throws Exception {
		new Person(this.model, "firstname1", "lastname1");
		new Person(this.model, "firstname2", "lastname2");

		final Integer result = this.model.countPersons();
		Assert.assertEquals(2, result.intValue());
	}

	/**
	 * Run the Integer countRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountRoles1() throws Exception {

		final Integer result = this.model.countRoles();
		Assert.assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountRoles2() throws Exception {
		new Role(this.model, "role1");
		new Role(this.model, "role2");

		final Integer result = this.model.countRoles();
		Assert.assertEquals(2, result.intValue());
	}

	/**
	 * Run the Integer countTeams() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountTeams1() throws Exception {
		final Integer result = this.model.countTeams();

		Assert.assertEquals(0, result.intValue());
	}

	/**
	 * Run the Integer countTeams() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountTeams2() throws Exception {
		new Team(this.model, "team1");
		new Team(this.model, "team2");

		final Integer result = this.model.countTeams();
		Assert.assertEquals(2, result.intValue());
	}

	/**
	 * Run the HashSet<Person> getPersons() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetPersons1() throws Exception {

		final List<Person> result = this.model.getAllPersons();
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<Person> getPersons() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetPersons2() throws Exception {
		new Person(this.model, "firstname1", "lastname1");
		new Person(this.model, "firstname2", "lastname2");

		final List<Person> result = this.model.getAllPersons();
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the HashSet<Role> getRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoles1() throws Exception {

		final List<Role> result = this.model.getAllRoles();
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<Role> getRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoles2() throws Exception {
		new Role(this.model, "role1");
		new Role(this.model, "role2");

		final List<Role> result = this.model.getAllRoles();
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the HashSet<Team> getTeams() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTeams1() throws Exception {

		final List<Team> result = this.model.getAllTeams();
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<Team> getTeams() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTeams2() throws Exception {
		new Team(this.model, "team1");
		new Team(this.model, "team2");

		final List<Team> result = this.model.getAllTeams();
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the void removeRole(Role) method test. With data so that the consistency is hurt to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testRemoveRole1() throws Exception {
		final Role role = new Role(this.model, "role");
		final Person p = new Person(this.model, "test", "test");
		p.addRole(role);

		this.model.removeRole(role);
		Assert.assertEquals(0, this.model.getAllRoles().size());
	}

	/**
	 * Run the void removeRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveRole2() throws Exception {
		new Role(this.model, "role1");
		final Role role2 = new Role(this.model, "role2");

		Assert.assertEquals(2, this.model.getAllRoles().size());
		this.model.removeRole(role2);
		Assert.assertEquals(1, this.model.getAllRoles().size());
	}

	/**
	 * Run the void removeRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveRole3() throws Exception {
		final Role role1 = new Role(this.model, "role1");
		final Role role2 = new Role(this.model, "role2");

		Assert.assertEquals(2, this.model.getAllRoles().size());
		this.model.removeRole(role1);
		Assert.assertEquals(1, this.model.getAllRoles().size());
		Assert.assertTrue(this.model.getAllRoles().contains(role2));
	}

	/**
	 * Run the void removeRole(Role) method test. with data so that the consistency is hurt to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testRemoveRole4() throws Exception {
		final Role role = new Role(this.model, "role");
		final Person person = new Person(this.model, "firstname", "lastname");
		person.addRole(role);

		Assert.assertEquals(1, this.model.getAllRoles().size());
		this.model.removeRole(role);
		Assert.fail();
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model(new Date());
		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

}
