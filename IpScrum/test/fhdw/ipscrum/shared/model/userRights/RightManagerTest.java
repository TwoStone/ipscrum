package fhdw.ipscrum.shared.model.userRights;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * Represents the class which tests the right manager.
 */
public class RightManagerTest {
	/**
	 * Represents the serverContext needed to use the IPScrum.
	 */
	private static ServerContext serverContext;
	/**
	 * Represents the model needed to use the IPScrum.
	 */
	private static Model model;
	/**
	 * Represents the RightManager needed to use the IPScrum.
	 */
	private static RightManager rm;
	/**
	 * Represents the PersonRoleAdminRight needed to use the IPScrum.
	 */
	private static PersonRoleAdminRight prar;
	/**
	 * Represents the ProductBacklogRight needed to use the IPScrum.
	 */
	private static ProductBacklogRight pbr;
	/**
	 * Represents the ProjectRight needed to use the IPScrum.
	 */
	private static ProjectRight pr;
	/**
	 * Represents the TaskboardRight needed to use the IPScrum.
	 */
	private static TaskboardRight tr;
	/**
	 * Represents the TeamAdminRight needed to use the IPScrum.
	 */
	private static TeamAdminRight tar;
	/**
	 * Represents the FieldTypeAdminRight needed to use the IPScrum.
	 */
	private static FieldTypeAdminRight ftar;
	/**
	 * Represents the ProjectHistoryRight needed to use the IPScrum.
	 */
	private static ProjectHistoryRight phr;
	/**
	 * Represents the TicketTypeAdminRight needed to use the IPScrum.
	 */
	private static TicketTypeAdminRight ttar;
	/**
	 * Represents the role needed to use the IPScrum.
	 */
	private static Role role;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Sets up the data before the whole class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RightManagerTest.serverContext = ServerContext.getInstance();
		RightManagerTest.model = RightManagerTest.serverContext.getPersistenceManager().getModelForTesting();
		RightManagerTest.model.setUuidManager(new IDGenerator());
		RightManagerTest.role = new Role(RightManagerTest.model, "Testrole");

		RightManagerTest.rm = new RightManager();
		RightManagerTest.prar = new PersonRoleAdminRight(RightManagerTest.model);
		RightManagerTest.pbr = new ProductBacklogRight(RightManagerTest.model);
		RightManagerTest.pr = new ProjectRight(RightManagerTest.model);
		RightManagerTest.tr = new TaskboardRight(RightManagerTest.model);
		RightManagerTest.tar = new TeamAdminRight(RightManagerTest.model);
		RightManagerTest.ftar = new FieldTypeAdminRight(RightManagerTest.model);
		RightManagerTest.phr = new ProjectHistoryRight(RightManagerTest.model);
		RightManagerTest.ttar = new TicketTypeAdminRight(RightManagerTest.model);

	}

	/**
	 * Tears down the data after the whole class.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Tears Down the data after every test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the method to get all Rights.
	 */
	@Test
	public void testGetAllRights1() {
		final List<Right> liste = new ArrayList<Right>();
		liste.add(null);
		liste.add(null);
		liste.add(null);
		liste.add(null);
		liste.add(null);
		liste.add(null);
		liste.add(null);
		liste.add(null);
		Assert.assertEquals(liste, RightManagerTest.rm.getAllRights());
	}

	/**
	 * Tests the method to get the FieldTypeAdminRight.
	 */
	@Test
	public void testGetFieldTypeAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getFieldTypeAdminRight());
	}

	/**
	 * Tests the method to get the PBIRight.
	 */
	@Test
	public void testGetPblRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getPblRight());
	}

	/**
	 * Tests the method to get the PersonRoleAdminRight.
	 */
	@Test
	public void testGetPersonRoleAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getPersonRoleAdminRight());
	}

	/**
	 * Tests the method to get the ProjectHistoryRight.
	 */
	@Test
	public void testGetProjectHistoryRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getProjectHistoryRight());
	}

	/**
	 * Tests the method to get the ProjectRight.
	 */
	@Test
	public void testGetProjectRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getProjectRight());
	}

	/**
	 * Tests the method to get the TaskboardRight.
	 */
	@Test
	public void testGetTaskboardRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTaskboardRight());
	}

	/**
	 * Tests the method to get the TeamAdminRight.
	 */
	@Test
	public void testGetTeamAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTeamAdminRight());
	}

	/**
	 * Test the method to get the TicketTypeAdminRight.
	 */
	@Test
	public void testGetTicketTypeAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTicketTypeAdminRight());
	}

	/**
	 * Tests the method to set the FieldTypeAdminRight.
	 */
	@Test
	public void testSetFieldTypeAdminRight() {
		RightManagerTest.rm.setFieldTypeAdminRight(RightManagerTest.ftar);
		Assert.assertEquals(RightManagerTest.ftar, RightManagerTest.rm.getFieldTypeAdminRight());
	}

	/**
	 * Tests the method to set the PBIRight.
	 */
	@Test
	public void testSetPblRight() {
		RightManagerTest.rm.setPblRight(RightManagerTest.pbr);
		Assert.assertEquals(RightManagerTest.pbr, RightManagerTest.rm.getPblRight());
	}

	/**
	 * Tests the method to set the PersonRoleAdminRight.
	 */
	@Test
	public void testSetPersonRoleAdminRight() {
		RightManagerTest.rm.setPersonRoleAdminRight(RightManagerTest.prar);
		Assert.assertEquals(RightManagerTest.prar, RightManagerTest.rm.getPersonRoleAdminRight());
	}

	/**
	 * Tests the method to set the ProjectHistoryRight.
	 */
	@Test
	public void testSetProjectHistoryRight() {
		RightManagerTest.rm.setProjectHistoryRight(RightManagerTest.phr);
		Assert.assertEquals(RightManagerTest.phr, RightManagerTest.rm.getProjectHistoryRight());
	}

	/**
	 * Tests the method to set the ProjectRight.
	 */
	@Test
	public void testSetProjectRight() {
		RightManagerTest.rm.setProjectRight(RightManagerTest.pr);
		Assert.assertEquals(RightManagerTest.pr, RightManagerTest.rm.getProjectRight());
	}

	/**
	 * Tests the method to set the TaskboardRight.
	 */
	@Test
	public void testSetTaskboardRight() {
		RightManagerTest.rm.setTaskboardRight(RightManagerTest.tr);
		Assert.assertEquals(RightManagerTest.tr, RightManagerTest.rm.getTaskboardRight());
	}

	/**
	 * Tests the method to set the TeamAdminRight.
	 */
	@Test
	public void testSetTeamAdminRight() {
		RightManagerTest.rm.setTeamAdminRight(RightManagerTest.tar);
		Assert.assertEquals(RightManagerTest.tar, RightManagerTest.rm.getTeamAdminRight());
	}

	/**
	 * Tests the method to set the ticketTypeAdminRight.
	 */
	@Test
	public void testSetTicketTypeAdminRight() {
		RightManagerTest.rm.setTicketTypeAdminRight(RightManagerTest.ttar);
		Assert.assertEquals(RightManagerTest.ttar, RightManagerTest.rm.getTicketTypeAdminRight());
	}

	/**
	 * Tests the method to get the master role.
	 */
	@Test
	public void testGetMasterRole() {
		Assert.assertEquals(null, RightManagerTest.rm.getMasterRole());
	}

	/**
	 * Tests the method which sets the master role.
	 */
	@Test
	public void testSetMasterRole() {
		RightManagerTest.rm.setMasterRole(RightManagerTest.role);
		Assert.assertEquals(RightManagerTest.role, RightManagerTest.rm.getMasterRole());
	}

	/**
	 * Tests the method which is needed to get all rights.
	 */
	@Test
	public void testGetAllRights2() {
		final List<Right> liste = new ArrayList<Right>();
		liste.add(RightManagerTest.ftar);
		liste.add(RightManagerTest.ttar);
		liste.add(RightManagerTest.tar);
		liste.add(RightManagerTest.prar);
		liste.add(RightManagerTest.pbr);
		liste.add(RightManagerTest.pr);
		liste.add(RightManagerTest.phr);
		liste.add(RightManagerTest.tr);

		Assert.assertEquals(liste, RightManagerTest.rm.getAllRights());
	}

}
