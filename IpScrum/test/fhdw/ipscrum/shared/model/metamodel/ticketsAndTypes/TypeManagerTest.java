package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.server.persistence.IPersistenceManager;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * test the TypeManager.
 */
public class TypeManagerTest {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model modelClient;
	/**
	 * represents the serverContext needed to use the IPScrum.
	 */
	private ServerContext serverContext;
	/**
	 * represents the persistenceManager needed to use the IPScrum.
	 */
	private IPersistenceManager persistenceManager;
	/**
	 * represents the typeManager needed to use the IPScrum.
	 */
	private TypeManager typeManager;

	/**
	 * sets up the date before the whole class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * tears down the data after the whole class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * sets up the data before every test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));

		this.serverContext = ServerContext.getInstance();

		this.modelClient =
				this.serverContext.getPersistenceManager().getModelForTesting();
		this.modelClient.setUuidManager(new IDGenerator());
		this.modelClient =
				this.serverContext.getPersistenceManager().getModelForTesting();
		this.modelClient.setUuidManager(new IDGenerator());
		this.persistenceManager = this.serverContext.getPersistenceManager();
		this.typeManager = this.modelClient.getTypeManager();
	}

	/**
	 * tears down the data after every test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The initial type manager should have the three standard ticket types bug, feature
	 * and task!
	 */
	@Test
	public void testgetActiveTicketTypesinitial() {
		Assert.assertTrue(!this.typeManager.getActiveTicketTypes().isEmpty());
		Assert.assertEquals(3, this.typeManager.getActiveTicketTypes().size());
		Assert.assertNotNull(this.persistenceManager);
	}

	/**
	 * tests the ticket type access methods of the type manager after 1 ticket type was
	 * created!
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testcreateTicketType() throws IPScrumGeneralException {
		final BugTicketType anyTicketType =
				new BugTicketType(this.modelClient, "ExtendedBug", "");
		Assert.assertTrue(this.typeManager.getActiveTicketTypes().contains(
				anyTicketType));
		Assert.assertTrue(this.typeManager.fetchUserTicketTypes().contains(
				anyTicketType));
		Assert.assertTrue(!this.typeManager.fetchStandardTicketTypes().contains(
				anyTicketType));
	}

	/**
	 * testes the state type access methods of the type manager after a state type was
	 * created!
	 * 
	 * @throws DoubleDefinitionException
	 *             if one state type is already defined
	 */
	@Test
	public void testcreateStateType() throws DoubleDefinitionException {
		final StateType newState = new StateType(this.modelClient, "new State", "");
		Assert.assertTrue(this.typeManager.getStateTypes().contains(newState));
		Assert.assertTrue(this.typeManager.fetchUserStateTypes().contains(newState));
		Assert.assertTrue(!this.typeManager.fetchStandardStateTypes()
				.contains(newState));
	}

	/**
	 * testes the field type access methods of the type manager after a field type was
	 * created!
	 * 
	 * @throws DoubleDefinitionException
	 *             if one fieldType is already created
	 */
	@Test
	public void testcreateFieldType() throws DoubleDefinitionException {
		final FieldType newFieldType =
				new TextFieldType(this.modelClient, "Kommentarliste",
						this.typeManager.getMany());
		Assert.assertTrue(this.typeManager.getFieldTypes().contains(newFieldType));
		Assert.assertTrue(this.typeManager.fetchUserFieldTypes().contains(newFieldType));
		Assert.assertTrue(!this.typeManager.fetchStandardFieldTypes().contains(
				newFieldType));
	}

	/**
	 * checks, if all standard types are initialized!
	 */
	@Test
	public void testgetStandardTypes() {
		Assert.assertTrue(this.modelClient.getTypeManager().getAcceptanceCriteriaType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getActiveTicketTypes() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getAssignedPBIsType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getClosed() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getDescriptionType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getFinishDateType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getHintsType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getInProcess() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getLastEditorType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getNameType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getOpen() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getPlanEffortType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getResponsiblePersonType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getSprintType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getStandardBugType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getStandardFeatureType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getStandardTaskType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getSystemsType() != null);
		Assert.assertTrue(this.modelClient.getTypeManager().getVersionType() != null);
	}

	/**
	 * tests the method to fetch all three standard ticketTypes.
	 */
	@Test
	public void testfetchStandardTicketTypes() {
		Assert.assertTrue(!this.typeManager.fetchStandardTicketTypes().isEmpty());
		Assert.assertEquals(3, this.typeManager.fetchStandardTicketTypes().size());
	}

}
