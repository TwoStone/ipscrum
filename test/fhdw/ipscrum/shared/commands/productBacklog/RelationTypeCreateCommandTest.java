package fhdw.ipscrum.shared.commands.productBacklog;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * The class <code>RelationTypeCreateCommandTest</code> contains tests for the class
 * <code>{@link RelationTypeCreateCommand}</code>.
 */
public class RelationTypeCreateCommandTest {

	/**
	 * represents the model which is relevant to use the IPScrum.
	 */
	private Model model;
	/**
	 * represents the server context which is relevant to use the IPScrum.
	 */
	private ServerContext serverContext;
	/**
	 * represents the relation type of a relation.
	 */
	private RelationType rtype;

	/**
	 * Run the RelationTypeCreateCommand(String) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testRelationTypeCreateCommand1() throws Exception {
		final String title = "rt";

		final RelationTypeCreateCommand result = new RelationTypeCreateCommand(title);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.dependsOnProject());
		Assert.assertEquals("", result.toString());
		Assert.assertEquals(null, result.getResult());
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("");

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
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("blaa");

		final boolean result = fixture.dependsOnProject();

		Assert.assertEquals(false, result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("blupp");

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertEquals(null, result);
	}

	/**
	 * Run the RelationType onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("type");

		final RelationType result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the RelationType onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("blaa");

		final RelationType result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the RelationType onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testOnExecute3() throws Exception {
		final RelationTypeCreateCommand fixture = new RelationTypeCreateCommand("Relationstyp");

		final RelationType result = fixture.onExecute(this.model);
		Assert.assertNotNull(this.rtype);
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
		this.rtype = new RelationType(this.model, "Relationstyp");
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
