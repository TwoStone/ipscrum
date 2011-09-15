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

public class RightManagerTest {
	private static ServerContext serverContext;
	private static Model model;
	private static RightManager rm;
	private static PersonRoleAdminRight prar;
	private static ProductBacklogRight pbr;
	private static ProjectRight pr;
	private static TaskboardRight tr;
	private static TeamAdminRight tar;
	private static FieldTypeAdminRight ftar;
	private static ProjectHistoryRight phr;
	private static TicketTypeAdminRight ttar;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RightManagerTest.serverContext = ServerContext.getInstance();
		RightManagerTest.model =
				RightManagerTest.serverContext.getPersistenceManager()
						.getModelForTesting();
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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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

	@Test
	public void testGetFieldTypeAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getFieldTypeAdminRight());
	}

	@Test
	public void testGetPblRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getPblRight());
	}

	@Test
	public void testGetPersonRoleAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getPersonRoleAdminRight());
	}

	@Test
	public void testGetProjectHistoryRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getProjectHistoryRight());
	}

	@Test
	public void testGetProjectRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getProjectRight());
	}

	@Test
	public void testGetTaskboardRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTaskboardRight());
	}

	@Test
	public void testGetTeamAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTeamAdminRight());
	}

	@Test
	public void testGetTicketTypeAdminRight1() {
		Assert.assertEquals(null, RightManagerTest.rm.getTicketTypeAdminRight());
	}

	@Test
	public void testSetFieldTypeAdminRight() {
		RightManagerTest.rm.setFieldTypeAdminRight(RightManagerTest.ftar);
		Assert.assertEquals(RightManagerTest.ftar,
				RightManagerTest.rm.getFieldTypeAdminRight());
	}

	@Test
	public void testSetPblRight() {
		RightManagerTest.rm.setPblRight(RightManagerTest.pbr);
		Assert.assertEquals(RightManagerTest.pbr, RightManagerTest.rm.getPblRight());
	}

	@Test
	public void testSetPersonRoleAdminRight() {
		RightManagerTest.rm.setPersonRoleAdminRight(RightManagerTest.prar);
		Assert.assertEquals(RightManagerTest.prar,
				RightManagerTest.rm.getPersonRoleAdminRight());
	}

	@Test
	public void testSetProjectHistoryRight() {
		RightManagerTest.rm.setProjectHistoryRight(RightManagerTest.phr);
		Assert.assertEquals(RightManagerTest.phr,
				RightManagerTest.rm.getProjectHistoryRight());
	}

	@Test
	public void testSetProjectRight() {
		RightManagerTest.rm.setProjectRight(RightManagerTest.pr);
		Assert.assertEquals(RightManagerTest.pr, RightManagerTest.rm.getProjectRight());
	}

	@Test
	public void testSetTaskboardRight() {
		RightManagerTest.rm.setTaskboardRight(RightManagerTest.tr);
		Assert.assertEquals(RightManagerTest.tr,
				RightManagerTest.rm.getTaskboardRight());
	}

	@Test
	public void testSetTeamAdminRight() {
		RightManagerTest.rm.setTeamAdminRight(RightManagerTest.tar);
		Assert.assertEquals(RightManagerTest.tar,
				RightManagerTest.rm.getTeamAdminRight());
	}

	@Test
	public void testSetTicketTypeAdminRight() {
		RightManagerTest.rm.setTicketTypeAdminRight(RightManagerTest.ttar);
		Assert.assertEquals(RightManagerTest.ttar,
				RightManagerTest.rm.getTicketTypeAdminRight());
	}

	@Test
	public void testGetMasterRole() {
		Assert.assertEquals(null, RightManagerTest.rm.getMasterRole());
	}

	@Test
	public void testSetMasterRole() {
		RightManagerTest.rm.setMasterRole(RightManagerTest.role);
		Assert.assertEquals(RightManagerTest.role, RightManagerTest.rm.getMasterRole());
	}

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
