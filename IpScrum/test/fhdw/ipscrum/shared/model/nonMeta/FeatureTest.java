package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TypeManager;

/**
 * This test class is used for testing the methods of the Features.
 */
public class FeatureTest {

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
	 * represents the type manager which is relevant to use the IPScrum.
	 */
	private TypeManager typeManager;

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
	 * Sets up the data for the test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		ServerContext.resetServerContext();
		this.serverContext = ServerContext.getInstance();
		this.model = this.serverContext.getPersistenceManager().getModelForTesting();
		this.model.setUuidManager(new IDGenerator());
		this.typeManager = this.model.getTypeManager();
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
	 * Needed for the tear down after the tests.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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
	 * tests to add an acceptance criterion.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void addAcceptanceCriterion() throws Exception {
		final String acceptanceCriterion = "TestAcceptanceCriterion";
		Assert.assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		Assert.assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		Assert.assertEquals(acceptanceCriterion, this.feature1.getAcceptanceCriteria().listIterator().next());
	}

	/**
	 * tests to add the same acceptance criterion twice to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContentDiffenretObjects() throws Exception {
		final String acceptanceCriterion1 = "TestAcceptanceCriterion";
		final String acceptanceCriterion2 = "TestAcceptanceCriterion";
		Assert.assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion1);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion2);
	}

	/**
	 * tests to ad the identical acceptance criterion twice to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContentDoubleAdd() throws Exception {
		final String acceptanceCriterion = "TestAcceptanceCriterion";
		Assert.assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
	}

	/**
	 * tests to add a acceptance criterion to a feature which is in a sets this is forbidden to check if the exception
	 * is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addAcceptanceCriterionToClosedFeature() throws Exception {
		this.feature1.changeState(this.typeManager.getClosed());

		final String acceptanceCriterion = "TestAcceptanceCriterion";

		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
	}

	/**
	 * tests to add a hint to a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void addHint() throws Exception {
		final String content = "TestHint";
		final String hint = content;
		Assert.assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		Assert.assertTrue(this.feature1.getHints().listIterator().hasNext());
		Assert.assertEquals(hint, this.feature1.getHints().listIterator().next());
		Assert.assertEquals(content, this.feature1.getHints().listIterator().next());
	}

	/**
	 * tests to add two identical hints to the feature to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addHintDoubleContentDiffenretObjects() throws Exception {
		final String hint1 = "TestHint";
		final String hint2 = "TestHint";
		Assert.assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint1);
		this.feature1.addHint(hint2);
	}

	/**
	 * tests to add the identical hint twice to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void addHintDoubleContentDoubleAdd() throws Exception {
		final String hint = "TestHint";
		Assert.assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		this.feature1.addHint(hint);
	}

	/**
	 * tests to add a hint to a feature which is in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addHintToClosedFeature() throws Exception {
		this.feature1.changeState(this.typeManager.getClosed());

		final String hint = "TestHint";

		this.feature1.addHint(hint);
	}

	/**
	 * tests to add a relation to a feature in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void addRelationToClosedFeature() throws Exception {
		this.feature1.changeState(this.typeManager.getClosed());

		final Relation relation = new Relation(this.model, this.rtype, this.feature2);

		Assert.assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
	}

	/**
	 * tests to add a relation to another feature which has a new relation type.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void addRelationToOtherFeatureWithNewRelationType() throws Exception {
		final RelationType newType = new RelationType(this.model, "Neuer Typ");
		final Relation relation = new Relation(this.model, newType, this.feature2);

		this.feature1.addRelation(relation);
		Assert.assertTrue(this.feature1.getRelations().iterator().hasNext());
		Assert.assertEquals(relation, this.feature1.getRelations().iterator().next());
	}

	/**
	 * tests to add a relation with a existing relation type to another feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void addRelationToOtherFeatureWithoutNewRelationType() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);

		Assert.assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		Assert.assertTrue(this.feature1.getRelations().iterator().hasNext());
		Assert.assertEquals(relation, this.feature1.getRelations().iterator().next());
		Assert.assertEquals(this.rtype, this.feature1.getRelations().iterator().next().getType());

	}

	/**
	 * tests to add a realtion to oneself which has a new relation type.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void addRelationToOwnFeatureWithNewRelationType() throws Exception {
		final RelationType relationType = new RelationType(this.model, "Neuer Typ");
		final Relation relation = new Relation(this.model, relationType, this.feature1);

		this.feature1.addRelation(relation);
		Assert.assertEquals(relationType, this.feature1.getRelations().iterator().next().getType());
	}

	/**
	 * tests to close a feature in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void closeAlreadyClosedFeature() throws Exception {
		this.feature1.changeState(this.typeManager.getClosed());
		this.feature1.changeState(this.typeManager.getClosed());
	}

	/**
	 * tests the close of a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void closeFeature() throws Exception {
		this.feature1.changeState(this.typeManager.getClosed());
		Assert.assertTrue(this.feature1.getCurrentState() == this.typeManager.getClosed());
	}

	/**
	 * checks if the construction of a feature works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void createFeature() throws Exception {
		Assert.assertEquals(this.featureName1, this.feature1.getName());
		Assert.assertEquals(this.featureDescription1, this.feature1.getDescription());
		Assert.assertEquals(this.productBacklog, this.feature1.getBacklog());
	}

	/**
	 * tests to create a feature which has the same name as another to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public void createFeatureDoubleFeatureInSameBacklog() throws Exception {
		new Feature(this.model, this.ftype, "TestName", "TestDescription", this.productBacklog);
		new Feature(this.model, this.ftype, "TestName", "TestDescription", this.productBacklog);

	}

	/**
	 * tests to remove an acceptance criterion from a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void removeAcceptanceCriterion() throws Exception {
		final String acceptanceCriterion = "TestAcceptanceCriterion";

		this.feature1.addAcceptanceCriterion(acceptanceCriterion);

		Assert.assertEquals(acceptanceCriterion, this.feature1.getAcceptanceCriteria().iterator().next());
		Assert.assertTrue(this.feature1.getAcceptanceCriteria().size() == 1);
		this.feature1.removeAcceptanceCriterion(acceptanceCriterion);
		java.lang.System.out.println(this.feature1.getAcceptanceCriteria().size());
		Assert.assertTrue(this.feature1.getAcceptanceCriteria().size() == 0);
	}

	/**
	 * tests to remove an acceotance criterion from a feature which is in a state this is forbidden to check if the
	 * exception is thrwon.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void removeAcceptanceCriterionToClosedFeature() throws Exception {
		final String acceptanceCriterion = "TestAcceptanceCriterion";

		this.feature1.addAcceptanceCriterion(acceptanceCriterion);

		this.feature1.changeState(this.typeManager.getClosed());
		Assert.assertTrue(this.feature1.getCurrentState() == this.typeManager.getClosed());

		this.feature1.removeAcceptanceCriterion(acceptanceCriterion);

	}

	/**
	 * tests to remove a hint from a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void removeHint() throws Exception {
		final String hint = "TestHint";
		Assert.assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		Assert.assertTrue(this.feature1.getHints().listIterator().hasNext());
		Assert.assertEquals(hint, this.feature1.getHints().listIterator().next());
		this.feature1.removeHint(hint);
		Assert.assertFalse(this.feature1.getHints().contains(hint));
	}

	/**
	 * tests to remove a hint from a feature which is in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void removeHintToClosedFeature() throws Exception {
		final String hint = "TestHint";

		this.feature1.addHint(hint);

		this.feature1.changeState(this.typeManager.getClosed());
		Assert.assertTrue(this.feature1.getCurrentState() == this.typeManager.getClosed());

		this.feature1.removeHint(hint);

	}

	/**
	 * tests to remove the relation from a feature which is in a state this is forbidden to check if the exceptionis
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void removeRelationToClosedFeature() throws Exception {

		final Relation relation = new Relation(this.model, this.rtype, this.feature2);

		this.feature1.addRelation(relation);

		this.feature1.changeState(this.typeManager.getClosed());
		Assert.assertTrue(this.feature1.getCurrentState() == this.typeManager.getClosed());

		this.feature1.removeRelation(relation);
	}

	/**
	 * Tests to remove a relation from a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void removeRelationToOtherFeatureWithoutNewRelationType() throws Exception {

		final Relation relation = new Relation(this.model, this.rtype, this.feature2);

		this.feature1.addRelation(relation);

		Assert.assertTrue(this.feature1.getRelations().contains(relation));
		Assert.assertEquals(this.rtype, this.feature1.getRelations().iterator().next().getType());
		this.feature1.removeRelation(relation);
		Assert.assertFalse(this.feature1.getRelations().contains(relation));

	}

	/**
	 * Tests to change the description of a feature which is in a state this is forbidden th check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void setDescriptionToClosedFeature() throws Exception {
		Assert.assertEquals(this.featureName1, this.feature1.getDescription());
		this.feature1.changeState(this.typeManager.getClosed());
		this.feature1.setDescription("TestNewDescription");
		this.feature1.toString();
		this.feature1.getProject();
	}

	/**
	 * Tests to change the description of a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void setDescriptionToOpenFeature() throws Exception {
		Assert.assertEquals(this.featureName1, this.feature1.getDescription());
		this.feature1.setDescription("TestNewDescription");
		Assert.assertEquals("TestNewDescription", this.feature1.getDescription());
	}

	/**
	 * Tests to change the last editor in a feature which is in a state this is forbidden to check if the excception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void setLastEditorToClosedFeature() throws Exception {
		final Person person = new Person(this.model, "TestFirstname", "TestNachname");
		this.feature1.changeState(this.typeManager.getClosed());

		this.feature1.setLastEditor(person);
	}

	/**
	 * Tests to change the last editor of a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void setLastEditorToOpenFeature() throws Exception {
		final Person person = new Person(this.model, "TestFirstname", "TestNachname");
		this.feature1.setLastEditor(person);
		Assert.assertEquals(person, this.feature1.getLastEditor());
	}

	/**
	 * Tests to set the effort of a feature which is in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void setManDayCostsToClosedFeature() throws Exception {
		final Integer manDayCosts = 5;
		this.feature1.changeState(this.typeManager.getClosed());
		this.feature1.setManDayCosts(new Effort(manDayCosts));
	}

	/**
	 * Tests to change the effort of a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void setManDayCostsToOpenFeature() throws Exception {
		final Integer manDayCosts = 5;
		this.feature1.setManDayCosts(new Effort(manDayCosts));
		Assert.assertEquals(manDayCosts, this.feature1.getManDayCosts().getValue());
	}

	/**
	 * Tests to add a sprint to a feature in a state this is forbidden to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 * 
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException.class)
	public void setSprintToClosedFeature() throws Exception {
		final Project tproject = new Project(this.model, "Testproject2");
		final Team tteam1 = new Team(this.model, "Testteam1");
		tteam1.addProject(tproject);
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);

		final Sprint sprint1 = new Sprint(this.model, "TestName1", "TestDescription1", begin, end, tteam1, tproject);
		this.project.addSprint(sprint1);
		this.feature1.changeState(this.typeManager.getClosed());
		this.feature1.setSprint(sprint1);
	}

	/**
	 * Test to set the sprint of a feature.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void setSprintToOpenFeature() throws Exception {
		final Project tproject2 = new Project(this.model, "Testproject2");
		final Team tteam2 = new Team(this.model, "Testteam1");
		tteam2.addProject(tproject2);
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);

		final Sprint sprint2 = new Sprint(this.model, "TestName2", "TestDescription2", begin, end, tteam2, tproject2);
		this.project.addSprint(sprint2);
		this.feature1.setSprint(sprint2);
		Assert.assertEquals(sprint2, this.feature1.getSprint());
	}
}
