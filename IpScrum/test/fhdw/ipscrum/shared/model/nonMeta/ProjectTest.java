package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.exceptions.model.NoSprintDefinedException;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>ProjectTest</code> contains tests for the class <code>{@link Project}</code>.
 * 
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ProjectTest {

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
	 * Run the void addPossibleSystem(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPossibleSystem1() throws Exception {
		final Project fixture = new Project(this.model, "Test");

		final Rootsystem root = new Rootsystem(this.model);
		final System system = new System(this.model, "S1", root);
		final System system2 = new System(this.model, "S2", root);
		final System system3 = new System(this.model, "S3", system2);
		final System system4 = new System(this.model, "S4", root);
		final System system5 = new System(this.model, "S5", system4);
		final System system6 = new System(this.model, "S6", root);
		final System system7 = new System(this.model, "S7", root);
		final System system8 = new System(this.model, "S8", system7);

		// Alle werden doppelt hinzugefügt, dürfen aber nur 1 mal enthalten sein
		fixture.addSystem(system);
		fixture.addSystem(system);
		fixture.addSystem(system2);
		fixture.addSystem(system2);
		fixture.addSystem(system3);
		fixture.addSystem(system3);
		fixture.addSystem(system4);
		fixture.addSystem(system4);
		fixture.addSystem(system5);
		fixture.addSystem(system5);
		fixture.addSystem(system6);
		fixture.addSystem(system6);

		final List<System> result = fixture.getSystems();

		Assert.assertEquals(4, result.size());
		Assert.assertTrue(result.contains(system));
		Assert.assertTrue(result.contains(system2));
		Assert.assertFalse(result.contains(system3));
		Assert.assertTrue(result.contains(system4));
		Assert.assertFalse(result.contains(system5));
		Assert.assertTrue(result.contains(system6));

		fixture.addSystem(system8);
		fixture.addSystem(system7);
	}

	/**
	 * Run the List<System> getPossibleSystems() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetPossibleSystems1() throws Exception {
		final Project fixture = new Project(this.model, "Test");

		final Rootsystem root = new Rootsystem(this.model);
		final System system = new System(this.model, "S1", root);
		final System system2 = new System(this.model, "S2", root);
		final System system3 = new System(this.model, "S3", system2);

		fixture.addSystem(system);
		fixture.addSystem(system2);
		fixture.addSystem(system3);

		final List<System> result = fixture.getSystems();

		Assert.assertEquals(2, result.size());
		Assert.assertTrue(result.contains(system));
		Assert.assertTrue(result.contains(system2));
		Assert.assertFalse(result.contains(system3));
	}

	/**
	 * Run the Boolean isPossibleSystem(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsPossibleSystem1() throws Exception {
		final Project fixture = new Project(this.model, "Test");

		final Rootsystem root = new Rootsystem(this.model);
		final System system = new System(this.model, "S1", root);

		fixture.addSystem(system);
		Assert.assertTrue(fixture.isPossibleSystem(system));
	}

	/**
	 * Run the Boolean isPossibleSystem(System) method test. Complex!
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsPossibleSystem2() throws Exception {
		final Project fixture = new Project(this.model, "Test");
		final Project fixture2 = new Project(this.model, "Test2");

		final Rootsystem root = new Rootsystem(this.model);
		final System system = new System(this.model, "S1", root);
		final System system2 = new System(this.model, "S2", root);
		final System system3 = new System(this.model, "S3", system2);

		fixture.addSystem(system);
		fixture.addSystem(system2);

		fixture2.addSystem(system3);

		Assert.assertTrue(fixture.isPossibleSystem(system));
		Assert.assertTrue(fixture.isPossibleSystem(system2));
		Assert.assertTrue(fixture.isPossibleSystem(system3));
		Assert.assertFalse(fixture2.isPossibleSystem(system2));
	}

	/**
	 * Test getProductBacklog().
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testgetProductBacklog() throws Exception {
		final Project fixture = new Project(this.model, "Project");

		final ProductBacklog backlog = fixture.getBacklog();

		Assert.assertNotNull(backlog);
	}

	/**
	 * Testing the the methods to count the sprints of the project and if a sprint is defined in one.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountSprintsAndIsSprintDefined() throws Exception {
		final Project p = new Project(this.model, "name");
		final Team team1 = new Team(this.model, "Team1");
		team1.addProject(p);
		final Team team2 = new Team(this.model, "Team2");
		team2.addProject(p);
		final Team team3 = new Team(this.model, "Team3");
		team3.addProject(p);
		final Team team4 = new Team(this.model, "Team4");
		team4.addProject(p);
		final Team team5 = new Team(this.model, "Team5");
		team5.addProject(p);
		final Team team6 = new Team(this.model, "Team6");
		team6.addProject(p);
		Assert.assertEquals(Integer.valueOf(0), p.countSprints());

		final Sprint s1 = new Sprint(this.model, "name1", "beschreibung", new Date(), new Date(), team1, p);
		new Sprint(this.model, "name2", "beschreibung", new Date(), new Date(), team2, p);
		new Sprint(this.model, "name3", "beschreibung", new Date(), new Date(), team3, p);
		new Sprint(this.model, "name4", "beschreibung", new Date(), new Date(), team4, p);
		new Sprint(this.model, "name5", "beschreibung", new Date(), new Date(), team5, p);
		new Sprint(this.model, "name6", "beschreibung", new Date(), new Date(), team6, p);
		Assert.assertEquals(Integer.valueOf(6), p.countSprints());
		p.isSprintDefined(s1);
	}

	/**
	 * Tests if the NoSprintDefinedException is thrown if a sprint not defined is searched.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoSprintDefinedException.class)
	public void testIsSprintDefined() throws Exception {
		final Project p = new Project(this.model, "name");
		final Team team = new Team(this.model, "Team");
		team.addProject(p);
		final Project q = new Project(this.model, "q");
		final Sprint s = new Sprint(this.model, "name", "beschreibung", new Date(), new Date(), team, p);
		q.isSprintDefined(s);
	}

	/**
	 * Tests if the name of a project could be set.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetName() throws Exception {
		final Project p = new Project(this.model, "name");
		p.setName("neuer Name");
		Assert.assertEquals("neuer Name", p.getName());
	}

	/**
	 * tests if the toString-method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToString() throws Exception {
		final Project p = new Project(this.model, "name");
		Assert.assertEquals("Project [name=" + p.getName() + "]", p.toString());
	}

	/**
	 * tests if a removed system of the project is really removed.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveSystem() throws Exception {
		final Project p = new Project(this.model, "name");
		final Rootsystem root = new Rootsystem(this.model);
		final System system = new System(this.model, "S1", root);
		p.addSystem(system);
		Assert.assertEquals(true, p.getSystems().contains(system));
		p.removeSystem(system);
		Assert.assertEquals(false, p.getSystems().contains(system));
	}

	/**
	 * tests if the method to check the deadlines works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCheckDeadlines() throws Exception {
		final Project p = new Project(this.model, "name");
		final Team team = new Team(this.model, "Team");
		team.addProject(p);
		new Sprint(this.model, "name1", "beschreibung", new Date(), new Date(), team, p);
		new Release(this.model, "TestVersion", new Date(), p);
		p.checkDeadlines();
	}

}
