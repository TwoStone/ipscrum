package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * The class <code>TeamTest</code> contains tests for the class
 * <code>{@link Team}</code>.
 */
public class TeamTest {
	/**
	 * Run the Team(String) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTeam_1() throws Exception {
		String description = "";

		Team result = new Team(description);

		assertNotNull(result);
	}

	/**
	 * Run the Team(String) constructor test.
	 */
	@Test
	public void testTeam_2() throws Exception {
		String description = "team";

		Team result = new Team(description);

		assertNotNull(result);
	}

	/**
	 * Run the void addMember(IPerson) method test.
	 */
	@Test
	public void testAddMember_1() throws Exception {
		Team fixture = new Team("team");
		IPerson member = new Person("firstname", "lastname");

		fixture.addMember(member);
	}

	/**
	 * Run the void addMember(IPerson) method test.
	 */
	@Test
	public void testAddMember_2() throws Exception {
		Team fixture = new Team("team");
		IPerson member = new Person("firstname", "lastname");

		fixture.addMember(member);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_1() throws Exception {
		Team fixture = new Team("team");
		Object obj = new Team("team");

		boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() throws Exception {
		Team fixture = new Team("team");
		Object obj = null;

		boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_3() throws Exception {
		Team fixture = new Team("team");
		Object obj = new Object();

		boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_4() throws Exception {
		Team fixture = new Team("team");
		Team obj = new Team("team");
		IPerson member = new Person("firstname", "lastname");
		obj.addMember(member);

		boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_5() throws Exception {
		Team fixture = new Team("team");
		Team obj = new Team("team");
		IPerson member = new Person("firstname", "lastname");
		fixture.addMember(member);

		boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the String getDescription() method test.
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		Team fixture = new Team("team");

		assertEquals("team", fixture.getDescription());
	}

	/**
	 * Run the Vector<IPerson> getMembers() method test.
	 */
	@Test
	public void testGetMembers_1() throws Exception {
		Team fixture = new Team("team");

		assertEquals(0, fixture.getMembers().size());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_1() throws Exception {
		Team fixture = new Team("team");
		Team obj = new Team("team");

		assertEquals(obj.hashCode(), fixture.hashCode());
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ConsistencyException.class)
	public void testRemoveMember_1() throws Exception {
		Team fixture = new Team("team");
		IPerson member = new Person("firstname", "lastname");

		fixture.removeMember(member);
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 */
	@Test
	public void testRemoveMember_2() throws Exception {
		Team fixture = new Team("team");
		IPerson member = new Person("firstname", "lastname");
		fixture.addMember(member);

		fixture.removeMember(member);
		assertEquals(0, fixture.getMembers().size());
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 */
	@Test
	public void testRemoveMember_3() throws Exception {
		Team fixture = new Team("team");
		IPerson member1 = new Person("firstname", "lastname");
		IPerson member2 = new Person("fname", "lname");
		fixture.addMember(member1);
		fixture.addMember(member2);

		fixture.removeMember(member1);
		assertEquals(1, fixture.getMembers().size());
		assertEquals(member2, fixture.getMembers().get(0));
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		Team fixture = new Team("a");
		String description = "newDesc";
		fixture.setDescription(description);

		assertEquals("newDesc", fixture.getDescription());
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_2() throws Exception {
		Team fixture = new Team("team");
		String description = "";
		fixture.setDescription(description);
		assertEquals("team", fixture.getDescription());

	}

	/**
	 * Run the String toString() method test.
	 */
	@Test
	public void testToString_1() throws Exception {
		Team fixture = new Team("team");

		assertEquals("Team 'team'", fixture.toString());
	}

	/**
	 * Perform pre-test initialization.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TeamTest.class);
	}
}