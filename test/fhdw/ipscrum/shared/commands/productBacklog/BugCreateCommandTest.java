package fhdw.ipscrum.shared.commands.productBacklog;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * The class <code>BugCreateCommandTest</code> contains tests for the class <code>{@link BugCreateCommand}</code>.
 * 
 */
public class BugCreateCommandTest {
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
	 * represents a bug ticket type which is needed to create bugs.
	 */
	private BugTicketType bttype;

	/**
	 * represents a project in the IPScrum which is needed to create a bug in.
	 */
	private Project iproject;

	/**
	 * represents a release in the IPScrum which is needed to create a bug in.
	 */
	private Release iversion;

	/**
	 * Run the BugCreateCommand(String,String,BugTicketType,ProductBacklog,Release) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testBugCreateCommand1() throws Exception {
		final String name = "bug1";
		final String description = "bug1";
		final BugCreateCommand result =
				new BugCreateCommand(name, description, this.bttype, this.iproject.getBacklog(), this.iversion);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug2", "bug2", this.btype, this.iproject.getBacklog(), this.iversion);

		fixture.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

	/**
	 * Run the boolean dependsOnProject() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testDependsOnProject1() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug3", "bug3", this.bttype, this.iproject.getBacklog(), this.iversion);

		final boolean result = fixture.dependsOnProject();
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug4", "bug4", this.btype, this.iproject.getBacklog(), this.iversion);

		final Project result = fixture.getDependingProject(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject2() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug5", "bug5", this.btype, this.iproject.getBacklog(), this.iversion);

		final Project result = fixture.getDependingProject(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug6", "bug6", this.bttype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug7", "bug7", this.btype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute3() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug8", "bug8", this.bttype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute4() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug9", "bug9", this.btype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 * 
	 */
	@Test
	public void testOnExecute5() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("bug10", "bug10", this.btype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Bug onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 * 
	 */
	@Test(expected = NoValidValueException.class)
	public void testOnExecute6() throws Exception {
		final BugCreateCommand fixture =
				new BugCreateCommand("", "", this.btype, this.iproject.getBacklog(), this.iversion);

		final Bug result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		this.serverContext = ServerContext.getInstance();
		this.model = this.serverContext.getPersistenceManager().getModelForTesting();
		this.model.setUuidManager(new IDGenerator());
		this.iproject = new Project(this.model, "Project");
		this.iversion = new Release(this.model, "Inital Release", new Date(), this.iproject);
		this.btype = new BugTicketType(this.model, "TestBug", "TestBugType");
		this.bttype = new BugTicketType(this.model, "TestBug2", "TestBugTicketType2");

	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

}
