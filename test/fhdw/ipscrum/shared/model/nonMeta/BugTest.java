package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.model.WrongReleaseException;
import fhdw.ipscrum.shared.exceptions.model.WrongSystemException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TypeManager;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * The class <code>BugTest</code> contains tests for the class <code>{@link Bug}</code>.
 * 
 */
public class BugTest {

	/**
	 * represents the model needed for the use of the IPScrum.
	 */
	private Model model;

	/**
	 * represents the server context needed for the use of the IPScrum.
	 */
	private ServerContext serverContext;

	/**
	 * represents the standard bug ticket type which is needed to create bugs.
	 */
	private BugTicketType btype;

	/**
	 * represents a relation type which is needed to create relations between pbis.
	 */
	private RelationType rtype;

	/**
	 * represents a relation which is needed to create relations betweem pbis.
	 */
	private Relation rela;

	/**
	 * represents a bug ticket type which is needed to create bugs.
	 */
	private BugTicketType bttype;
	/**
	 * represents the type manager which is needed to use the IPScrum.
	 */
	private TypeManager typeManager;

	/**
	 * represents the bug which should be tested.
	 */
	private Bug testbug;

	/**
	 * represents a project in the IPScrum which is needed to create a bug in.
	 */
	private Project iproject;

	/**
	 * represents a release in the IPScrum which is needed to create a bug in.
	 */
	private Release iversion;

	/**
	 * The set up before the start of the class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		this.serverContext = ServerContext.getInstance();
		this.model = this.serverContext.getPersistenceManager().getModelForTesting();
		this.model.setUuidManager(new IDGenerator());
		this.typeManager = this.model.getTypeManager();
		this.iproject = new Project(this.model, "Project");
		this.iversion = new Release(this.model, "Inital Release", new Date(), this.iproject);
		this.btype = new BugTicketType(this.model, "TestBug", "TestBugType");
		this.testbug = new Bug(this.model, this.btype, "Testbug", "Testbug", this.iproject.getBacklog(), this.iversion);
		this.rtype = new RelationType(this.model, "Relationstyp");
		this.rela = new Relation(this.model, this.rtype, this.testbug);
		this.bttype = new BugTicketType(this.model, "TestBug2", "TestBugTicketType2");

	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test. with a not valid value to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testBug1() throws Exception {
		final String name = "";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(this.model, this.btype, name, description, backlog, version);

	}

	/**
	 * Run the Bug(String,String,Release,ProductBacklog) constructor test. with a release not in the project to check if
	 * the exception is thrown
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = WrongReleaseException.class)
	public void testBug2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = null;
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(this.model, this.btype, name, description, backlog, version);
	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testBug3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		Assert.assertEquals("Bug", bug.getName());
		Assert.assertEquals("", bug.getDescription());
		Assert.assertEquals(backlog, bug.getBacklog());
		Assert.assertEquals(pro, bug.getBacklog().getProject());
		Assert.assertEquals(version, bug.getVersion());
		Assert.assertNotNull(this.bttype);
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(this.model, this.btype, name, description, backlog, version);

		final IProductBacklogItemVisitor visitor = new IProductBacklogItemVisitor() {

			@Override
			public void handleFeature(final Feature feature) {
				Assert.fail();
			}

			@Override
			public void handleBug(final Bug bug) {
				Assert.assertEquals(expected, bug);
			}
		};

		expected.accept(visitor);
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddSystem1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);
		pro.addSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		Assert.assertEquals(2, bug.getSystems().size());
		Assert.assertTrue(bug.getSystems().contains(sys1));
		Assert.assertTrue(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void addSystem(System) method test. with a system not in this project to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = WrongSystemException.class)
	public void testAddSystem2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the void addSystem(System) method test. with a system not in the related project to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = WrongSystemException.class)
	public void testAddSystem3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Project pro2 = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);

		pro2.addSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the void addSystem(System) method test. with the add of a system in a state this is forbidden to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testAddSystem4() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);
		pro.addSystem(sys2);

		bug.changeState(this.typeManager.getClosed());

		bug.addSystem(sys1);
		bug.addSystem(sys2);
	}

	/**
	 * Run the IRelease getVersion() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetVersion1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);

		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(this.model, this.btype, name, description, backlog, version);

		Assert.assertEquals(version, expected.getVersion());
	}

	/**
	 * Run the IBugState getState() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetCurrentState1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);

		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(this.model, this.btype, name, description, backlog, version);

		expected.changeState(this.typeManager.getClosed());

		Assert.assertTrue(expected.getCurrentState() == this.typeManager.getClosed());
	}

	/**
	 * Run the Collection<System> getSystems() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystems1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);
		pro.addSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		Assert.assertEquals(2, bug.getSystems().size());
		Assert.assertTrue(bug.getSystems().contains(sys1));
		Assert.assertTrue(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void removeSystem(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveSystem1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);
		pro.addSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		bug.removeSystem(sys2);

		Assert.assertEquals(1, bug.getSystems().size());
		Assert.assertTrue(bug.getSystems().contains(sys1));
		Assert.assertFalse(bug.getSystems().contains(sys2));

		bug.removeSystem(sys1);

		Assert.assertEquals(0, bug.getSystems().size());
		Assert.assertFalse(bug.getSystems().contains(sys1));
		Assert.assertFalse(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void removeSystem(System) method test. with the remove of a system in a state this is forbidden to check
	 * if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testRemoveSystem2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "S1", root);
		final System sys2 = new System(this.model, "S2", root);

		pro.addSystem(sys1);
		pro.addSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		bug.removeSystem(sys2);

		Assert.assertEquals(1, bug.getSystems().size());
		Assert.assertTrue(bug.getSystems().contains(sys1));
		Assert.assertFalse(bug.getSystems().contains(sys2));

		bug.changeState(this.typeManager.getClosed());

		bug.removeSystem(sys1);

		Assert.fail();
	}

	/**
	 * Run the void setVersion(Release) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetVersion1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final Release version2 = new Release(this.model, "R2", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setVersion(version2);

		Assert.assertEquals(version2, bug.getVersion());
	}

	/**
	 * Run the void setVersion(Release) method test. with the change of the version in a state this is forbidden to
	 * check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetVersion2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final Release version2 = new Release(this.model, "R2", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.setVersion(version2);
	}

	/**
	 * Run the void setVersion(IRelease) method test. with the set of a release related to another project to check if
	 * the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = WrongReleaseException.class)
	public void testSetVersion3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setVersion(null);

	}

	/**
	 * Run the void setDescription() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetDescription1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setDescription("Test");

		Assert.assertEquals("Test", bug.getDescription());
	}

	/**
	 * Run the void setDescription() method test. with the set in a state this is forbidden to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetDescription2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.setDescription("Test");

	}

	/**
	 * Run the void setLastEditor() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetLastEditor1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);
		final Person editor = new Person(this.model, "Test", "Test2");

		bug.setLastEditor(editor);

		Assert.assertEquals(editor, bug.getLastEditor());
	}

	/**
	 * Run the void setLastEditor() method test. with the set in a state this is forbidden to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetLastEditor2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.setLastEditor(new Person(this.model, "Test", "Test2"));

	}

	/**
	 * Run the void setManDayCosts() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetManDayCosts1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setManDayCosts(new Effort(4));

		Assert.assertEquals(Integer.valueOf(4), bug.getManDayCosts().getValue());
	}

	/**
	 * Run the void setManDayCosts() method test. with the set in a state this is forbidden to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetManDayCosts2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.setManDayCosts(new Effort(4));
	}

	/**
	 * Run the void setSprint() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetSprint1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Team team = new Team(this.model, "Team");
		team.addProject(pro);

		final Sprint sprint = new Sprint(this.model, "Sprint", "Test", new Date(), new Date(), team, pro);
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setSprint(sprint);

		Assert.assertEquals(sprint, bug.getSprint());
		Assert.assertTrue(sprint.getPBIs().contains(bug));

	}

	/**
	 * Run the void setSprint() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetSprint2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Team team = new Team(this.model, "Team");
		team.addProject(pro);

		final Sprint sprint = new Sprint(this.model, "Sprint", "Test", new Date(), new Date(), team, pro);
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.setSprint(sprint);
		bug.setSprint(null);

		Assert.assertTrue(bug.getSprint() == null);
		Assert.assertFalse(sprint.getPBIs().contains(bug));
	}

	/**
	 * Run the void setSprint() method test. with the set in a state this is forbidden to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testSetSprint3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro");
		final Team team = new Team(this.model, "Team");
		team.addProject(pro);

		final Sprint sprint = new Sprint(this.model, "Sprint", "Test", new Date(), new Date(), team, pro);
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.setSprint(sprint);
	}

	/**
	 * Tests the add of a acceptance criterion to the bug.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void addAcceptanceCriterion() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String acceptanceCriterion = "TestAcceptanceCriterion";
		Assert.assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion);
		Assert.assertTrue(bug.getAcceptanceCriteria().listIterator().hasNext());
		Assert.assertEquals(acceptanceCriterion, bug.getAcceptanceCriteria().listIterator().next());
	}

	/**
	 * Tests to add two identical acceptance criteria to the bug to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContentDiffenretObjects() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String acceptanceCriterion1 = "TestAcceptanceCriterion";
		final String acceptanceCriterion2 = "TestAcceptanceCriterion";
		Assert.assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion1);
		bug.addAcceptanceCriterion(acceptanceCriterion2);
	}

	/**
	 * Tests the addition of the same acceptance criterion twice to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContentDoubleAdd() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String acceptanceCriterion = "TestAcceptanceCriterion";
		Assert.assertFalse(bug.getAcceptanceCriteria().listIterator().hasNext());
		bug.addAcceptanceCriterion(acceptanceCriterion);
		bug.addAcceptanceCriterion(acceptanceCriterion);
	}

	/**
	 * Test the addition of an acceptance criterion to a bug which is in a state this is forbidden th check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addAcceptanceCriterionToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		final String acceptanceCriterion = "TestAcceptanceCriterion";

		bug.addAcceptanceCriterion(acceptanceCriterion);
	}

	/**
	 * Tets to add a hint to the bug.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void addHint() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String content = "TestHint";
		final String hint = content;
		Assert.assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint);
		Assert.assertTrue(bug.getHints().listIterator().hasNext());
		Assert.assertEquals(hint, bug.getHints().listIterator().next());
		Assert.assertEquals(content, bug.getHints().listIterator().next());
	}

	/**
	 * Tests to add the identical hint twice to a bug to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addHintDoubleContentDiffenretObjects() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String hint1 = "TestHint";
		final String hint2 = "TestHint";
		Assert.assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint1);
		bug.addHint(hint2);
	}

	/**
	 * Test to add the same hint twice to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addHintDoubleContentDoubleAdd() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		final String hint = "TestHint";
		Assert.assertFalse(bug.getHints().listIterator().hasNext());
		bug.addHint(hint);
		bug.addHint(hint);
	}

	/**
	 * Test to addition of a hint to a bug in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addHintToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		final String hint = "TestHint";

		bug.addHint(hint);
	}

	/**
	 * Test to add a relation to a bug in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addRelationToClosedFeature() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		bug.changeState(this.typeManager.getClosed());

		bug.addRelation(this.rela);
	}

	/**
	 * test to add a relation to the bug with a already existing relation type.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void addRelationToOtherFeatureWithoutNewRelationType() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);
		final Bug bug2 = new Bug(this.model, this.btype, name + "Test", description, backlog, version);

		final Relation relation = new Relation(this.model, this.rtype, bug2);

		Assert.assertFalse(bug.getRelations().iterator().hasNext());
		bug.addRelation(relation);
		Assert.assertTrue(bug.getRelations().iterator().hasNext());
		Assert.assertEquals(relation, bug.getRelations().iterator().next());
		Assert.assertEquals(this.rtype, bug.getRelations().iterator().next().getType());

	}

	/**
	 * Test to add a relation with a new relation type to a bug.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void addRelationToOwnFeatureWithNewRelationType() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project(this.model, "Pro2");
		final Release version = new Release(this.model, "R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(this.model, this.btype, name, description, backlog, version);

		Assert.assertFalse(bug.getRelations().iterator().hasNext());
		bug.addRelation(this.rela);
		Assert.assertTrue(bug.getRelations().iterator().hasNext());
		Assert.assertEquals(this.rela, bug.getRelations().iterator().next());
		Assert.assertEquals(this.rtype, bug.getRelations().iterator().next().getType());
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

}
