package fhdw.ipscrum.shared.commands.productBacklog;

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
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * The class <code>FeatureCreateCommandTest</code> contains tests for the class
 * <code>{@link FeatureCreateCommand}</code>.
 */
public class FeatureCreateCommandTest {

	/**
	 * represents the model which is relevant to use the IPScrum.
	 */
	private Model model;
	/**
	 * represents the server context which is relevant to use the IPScrum.
	 */
	private ServerContext serverContext;
	/**
	 * represents the standard feature ticket type which is relevant to use the IPScrum.
	 */
	private FeatureTicketType ftype;

	/**
	 * represents the name of the project related to the feature.
	 */
	private String projectName;
	/**
	 * represents the project related to the feature.
	 */
	private Project project;
	/**
	 * represents the productBacklog related to the feature.
	 */
	private ProductBacklog productBacklog;

	/**
	 * Run the FeatureCreateCommand(String,String,FeatureTicketType,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testFeatureCreateCommand1() throws Exception {
		final String name = "";
		final String description = "";
		final FeatureCreateCommand result =
				new FeatureCreateCommand(name, description, this.ftype, this.productBacklog);
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
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f1", "f1", this.ftype, this.productBacklog);

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
		final FeatureCreateCommand fixture =
				new FeatureCreateCommand("f2", "f2", this.ftype, this.project.getBacklog());

		final boolean result = fixture.dependsOnProject();

		Assert.assertTrue(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f3", "f3", this.ftype, this.productBacklog);

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
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f4", "f4", this.ftype, this.productBacklog);

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final FeatureCreateCommand fixture =
				new FeatureCreateCommand("f5", "f5", this.ftype, this.project.getBacklog());

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f6", "f6", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute3() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f7", "f7", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute4() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f8", "f8", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute5() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f9", "f9", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute6() throws Exception {
		final FeatureCreateCommand fixture =
				new FeatureCreateCommand("f10", "f10", this.ftype, this.project.getBacklog());

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute7() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("f11", "f11", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Feature onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testOnExecute8() throws Exception {
		final FeatureCreateCommand fixture = new FeatureCreateCommand("", "", this.ftype, this.productBacklog);

		final Feature result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		ServerContext.resetServerContext();
		this.serverContext = ServerContext.getInstance();
		this.model = this.serverContext.getPersistenceManager().getModelForTesting();
		this.model.setUuidManager(new IDGenerator());
		this.ftype = new FeatureTicketType(this.model, "TestFeature", "TestFeatureType");

		this.projectName = "TestProject";

		this.project = new Project(this.model, this.projectName);
		this.productBacklog = this.project.getBacklog();

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
