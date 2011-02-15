package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * The class <code>TeamTest</code> contains tests for the class
 * <code>{@link Team}</code>.
 * 
 * @generatedBy CodePro at 15.02.11 11:21
 */
public class TeamTest {
	/**
	 * Run the Team(String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTeam_1() throws Exception {
		String description = "";

		Team result = new Team(description);

		assertNotNull(result);
	}

	/**
	 * Run the Team(String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testTeam_2() throws Exception {
		String description = "";

		Team result = new Team(description);

		assertNotNull(result);
	}

	/**
	 * Run the void addMember(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testAddMember_1() throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.addMember(member);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
	}

	/**
	 * Run the void addMember(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testAddMember_2() throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.addMember(member);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_1() throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_2() throws Exception {
		Team fixture = new Team("");
		Object obj = null;

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_3() throws Exception {
		Team fixture = new Team("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_4() throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_5() throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the String getDescription() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		Team fixture = new Team("");

		String result = fixture.getDescription();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<IPerson> getMembers() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetMembers_1() throws Exception {
		Team fixture = new Team("");

		Vector<IPerson> result = fixture.getMembers();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testHashCode_1() throws Exception {
		Team fixture = new Team("");

		int result = fixture.hashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertEquals(0, result);
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testRemoveMember_1() throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.removeMember(member);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testRemoveMember_2() throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.removeMember(member);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		Team fixture = new Team("a");
		String description = "a";

		fixture.setDescription(description);

	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_2() throws Exception {
		Team fixture = new Team("");
		String description = null;

		fixture.setDescription(description);

	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_3() throws Exception {
		Team fixture = new Team("");
		String description = "";

		fixture.setDescription(description);

	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testToString_1() throws Exception {
		Team fixture = new Team("");

		String result = fixture.toString();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testToString_2() throws Exception {
		Team fixture = new Team("");

		String result = fixture.toString();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TeamTest.class);
	}
}