package fhdw.ipscrum.phase2.gruppe3.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TeamTest</code> contains tests for the class <code>{@link Team}</code>.
 *
 * @generatedBy CodePro at 13.02.11 19:02
 * @author Dinaa
 * @version $Revision: 1.0 $
 */
public class TeamTest {
	/**
	 * Run the Team(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testTeam_1()
		throws Exception {
		String description = "";

		Team result = new Team(description);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Team", result.toString());
		assertEquals("", result.getDescription());
	}

	/**
	 * Run the void addMember(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testAddMember_1()
		throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.addMember(member);

		// add additional test code here
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Team fixture = new Team("");
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Team fixture = new Team("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Team fixture = new Team("");
		Object obj = new Team("");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		Team fixture = new Team("");

		String result = fixture.getDescription();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Vector<IPerson> getMembers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testGetMembers_1()
		throws Exception {
		Team fixture = new Team("");

		Vector<IPerson> result = fixture.getMembers();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Team fixture = new Team("");

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(962, result);
	}

	/**
	 * Run the void removeMember(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testRemoveMember_1()
		throws Exception {
		Team fixture = new Team("");
		IPerson member = new Person("", "");

		fixture.removeMember(member);

		// add additional test code here
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testSetDescription_1()
		throws Exception {
		Team fixture = new Team("");
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Team fixture = new Team("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Team", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Test
	public void testToString_2()
		throws Exception {
		Team fixture = new Team("");

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Team", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 13.02.11 19:02
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TeamTest.class);
	}
}