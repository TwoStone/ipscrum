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
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * The class <code>PBIRemoveRelationCommandTest</code> contains tests for the class
 * <code>{@link PBIRemoveRelationCommand}</code>.
 */
public class PBIRemoveRelationCommandTest {
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
	 * represents the relation type of a relation.
	 */
	private RelationType rtype;
	/**
	 * represents the name of one of the features to test.
	 */
	private String featureName1;

	/**
	 * represents the name of one of the features to test.
	 */
	private String featureName2;

	/**
	 * represents the description of a feature which is needed to set a feature.
	 */
	private String featureDescription1;

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
	 * represents one feature to test.
	 */
	private Feature feature1;

	/**
	 * represents one feature to test.
	 */
	private Feature feature2;

	/**
	 * Run the PBIRemoveRelationCommand(ProductBacklogItem,Relation) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testPBIRemoveRelationCommand1() throws Exception {
		final ProductBacklogItem pbi = this.feature2;
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);

		final PBIRemoveRelationCommand result = new PBIRemoveRelationCommand(pbi, relation);

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
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature1, relation);

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
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature2, relation);

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
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature2, relation);

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
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature1, relation);

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature1, relation);

		final Void result = fixture.onExecute(this.model);

		Assert.assertNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature2, relation);

		final Void result = fixture.onExecute(this.model);

		Assert.assertNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute3() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature1, relation);

		final Void result = fixture.onExecute(this.model);

		Assert.assertNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = IPScrumGeneralException.class)
	public void testOnExecute4() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIRemoveRelationCommand fixture = new PBIRemoveRelationCommand(this.feature1, relation);
		final Model model1 = new Model(new Date());

		final Void result = fixture.onExecute(model1);

		Assert.assertNull(result);
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
		this.rtype = new RelationType(this.model, "Relationstyp");

		this.featureName1 = "TestFeature1";
		this.featureName2 = "TestFeature2";
		this.featureDescription1 = "TestFeature1";
		this.projectName = "TestProject";

		this.project = new Project(this.model, this.projectName);
		this.productBacklog = this.project.getBacklog();

		this.feature1 =
				new Feature(this.model, this.ftype, this.featureName1, this.featureDescription1, this.productBacklog);
		this.feature2 =
				new Feature(this.model, this.ftype, this.featureName2, this.featureDescription1, this.productBacklog);
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
