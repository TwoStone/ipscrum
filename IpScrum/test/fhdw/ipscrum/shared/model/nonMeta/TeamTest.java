package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>TeamTest</code> contains tests for the class <code>{@link Team}</code>.
 */
public class TeamTest {
	/**
	 * represents the model needed for using the IPScrum.
	 */
	private final Model model = new Model(new Date());

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {

		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the Team(String) constructor test. with a not valid value to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testTeam1() throws Exception {
		final String description = "";

		final Team result = new Team(this.model, description);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Team(String) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testTeam2() throws Exception {
		final String description = "team";

		final Team result = new Team(this.model, description);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the void addMember(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddMember1() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member = new Person(this.model, "firstname", "lastname");

		fixture.addMember(member);
	}

	/**
	 * Run the void addMember(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddMember2() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member = new Person(this.model, "firstname", "lastname");

		fixture.addMember(member);
	}

	/**
	 * Run the void addMember(Person) method test. with the add of a already added member
	 * to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testAddMember3() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member = new Person(this.model, "firstname", "lastname");

		fixture.addMember(member);
		fixture.addMember(member);
	}

	/**
	 * Run the String getDescription() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetDescription1() throws Exception {
		final Team fixture = new Team(this.model, "team");

		Assert.assertEquals("team", fixture.getDescription());
	}

	/**
	 * Run the Vector<Person> getMembers() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetMembers1() throws Exception {
		final Team fixture = new Team(this.model, "team");

		Assert.assertEquals(0, fixture.getMembers().size());
	}

	/**
	 * Run the void removeMember(Person) method test. with the remove of the member of a
	 * team who isn't really a member to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testRemoveMember1() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member = new Person(this.model, "firstname", "lastname");

		fixture.removeMember(member);
	}

	/**
	 * Run the void removeMember(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveMember2() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member = new Person(this.model, "firstname", "lastname");
		fixture.addMember(member);

		fixture.removeMember(member);
		Assert.assertEquals(0, fixture.getMembers().size());
	}

	/**
	 * Run the void removeMember(Person) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveMember3() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final Person member1 = new Person(this.model, "firstname", "lastname");
		final Person member2 = new Person(this.model, "fname", "lname");
		fixture.addMember(member1);
		fixture.addMember(member2);

		fixture.removeMember(member1);
		Assert.assertEquals(1, fixture.getMembers().size());
		Assert.assertEquals(member2, fixture.getMembers().get(0));
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetDescription1() throws Exception {
		final Team fixture = new Team(this.model, "a");
		final String description = "newDesc";
		fixture.setDescription(description);

		Assert.assertEquals("newDesc", fixture.getDescription());
	}

	/**
	 * Run the void setDescription(String) method test. Tests if the NoValidValueException
	 * is thrown if the value for description is the not valid value "";
	 * 
	 * @throws Exception
	 *             if the set of the description fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetDescription2() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final String description = "";
		fixture.setDescription(description);
		Assert.assertEquals("team", fixture.getDescription());

	}

	/**
	 * Run the void setDescription(String) method test. Tests if the NoValidValueException
	 * is thrown if the value for description is the not valid value null;
	 * 
	 * @throws Exception
	 *             if the set of the description fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetDescription3() throws Exception {
		final Team fixture = new Team(this.model, "team");
		final String description = null;
		fixture.setDescription(description);
		Assert.assertEquals("team", fixture.getDescription());

	}

	/**
	 * Run the String toString() method test. Tests if the toString-method delivers the
	 * excepted string "Team 'team description'".
	 * 
	 * @throws Exception
	 *             if the toString method fails
	 */
	@Test
	public void testToString1() throws Exception {
		final Team fixture = new Team(this.model, "team");

		Assert.assertEquals("Team 'team'", fixture.toString());
	}

	/**
	 * Run the addProject() method test. Tests, if a project is added to a team.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */

	@Test
	public void testAddProject1() throws Exception {
		final Team test = new Team(this.model, "test");
		final Project project = new Project(this.model, "Test");
		test.addProject(project);

		Assert.assertTrue(test.getProjects().contains(project));
	}

	/**
	 * Run the addProject() method test. Tests, if a project is added to a team.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */

	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public
			void testAddProject2() throws Exception {
		final Team test = new Team(this.model, "test");
		final Project project = new Project(this.model, "Test");
		test.addProject(project);
		test.addProject(project);

	}

	/**
	 * Run the GetProjects() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */

	@Test
	public void testGetProjects1() throws Exception {
		final Team test = new Team(this.model, "test");
		final Project project = new Project(this.model, "Test");
		test.addProject(project);

		Assert.assertTrue(test.getProjects().contains(project));
	}

	/**
	 * Run the GetProjects() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */

	@Test
	public void testGetProjects2() throws Exception {
		final Team test = new Team(this.model, "test");
		final Project project1 = new Project(this.model, "Test");
		final Project project2 = new Project(this.model, "Test1");
		test.addProject(project1);
		test.addProject(project2);

		Assert.assertTrue(test.getProjects().contains(project1));
		Assert.assertTrue(test.getProjects().contains(project2));
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the tear down fails
	 */

	@After
	public void tearDown() throws Exception {
	}

}
