package fhdw.ipscrum.shared.model.metamodel.states;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.server.persistence.IPersistenceManager;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TypeManager;

/**
 * test the StateType.
 */
public class StateTypeTest {
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
	 * sets up the data before the whole class.
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
		// Output Verzeichnis wird gelöscht
		TestUtils.deleteFolderContent(new File("output"));

		this.serverContext = ServerContext.getInstance();

		this.modelClient = this.serverContext.getPersistenceManager().getModelForTesting();
		this.modelClient.setUuidManager(new IDGenerator());
		this.modelClient = this.serverContext.getPersistenceManager().getModelForTesting();
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
	 * test to create a new state that already exists.
	 * 
	 * @throws DoubleDefinitionException
	 *             if the new state already exists
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void teststateOpenDoubleDefinition() throws DoubleDefinitionException {
		final StateType newState = new StateType(this.modelClient, "Offen", "");
		Assert.assertNotNull(this.persistenceManager);
		Assert.assertNotNull(this.typeManager);
		Assert.assertNotNull(newState);
	}

	/**
	 * tests to create a new state that already exists.
	 * 
	 * @throws DoubleDefinitionException
	 *             if the state already exists
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void teststateinProcessDoubleDefinition() throws DoubleDefinitionException {
		final StateType newState = new StateType(this.modelClient, "In Arbeit", "");
		Assert.assertNotNull(newState);
	}

	/**
	 * test to create a state which already exists.
	 * 
	 * @throws DoubleDefinitionException
	 *             if the state already exists
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void teststateClosedDoubleDefinition() throws DoubleDefinitionException {
		final StateType newState = new StateType(this.modelClient, "Abgeschlossen", "");
		Assert.assertNotNull(newState);
	}

}
