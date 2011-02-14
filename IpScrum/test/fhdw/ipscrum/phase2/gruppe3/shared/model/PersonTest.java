package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * The class <code>PersonTest</code> contains tests for the class <code>{@link Person}</code>.
 *
 * @generatedBy CodePro at 13.02.11 20:00
 */
public class PersonTest {
	/**
	 * Run the Person(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testPerson_1()
		throws Exception {
		String firstname = "";
		String lastname = "";

		Person result = new Person(firstname, lastname);

		assertNotNull(result);
		assertEquals(" ", result.toString());
		assertEquals(961, result.indirectHashCode());
		assertEquals("", result.getFirstname());
		assertEquals("", result.getLastname());
	}

	/**
	 * Run the void addRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testAddRole_1()
		throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.addRole(role);

		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Rollenname angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:34)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:15)
	}

	/**
	 * Run the void addRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testAddRole_2()
		throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.addRole(role);

		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Rollenname angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:34)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:15)
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the String getFirstname() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetFirstname_1()
		throws Exception {
		Person fixture = new Person("", "");

		String result = fixture.getFirstname();

		assertEquals("", result);
	}

	/**
	 * Run the String getLastname() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetLastname_1()
		throws Exception {
		Person fixture = new Person("", "");

		String result = fixture.getLastname();

		assertEquals("", result);
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		Person fixture = new Person("", "");

		Vector<IRole> result = fixture.getRoles();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetRoles_2()
		throws Exception {
		Person fixture = new Person("", "");

		Vector<IRole> result = fixture.getRoles();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.IPerson.ToRoleAssoc getToRoleAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetToRoleAssoc_1()
		throws Exception {
		Person fixture = new Person("", "");

		fhdw.ipscrum.shared.model.interfaces.IPerson.ToRoleAssoc result = fixture.getToRoleAssoc();

		assertNotNull(result);
		assertEquals(null, result.get());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Person fixture = new Person("", "");

		int result = fixture.hashCode();

		assertEquals(29822, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_7()
		throws Exception {
		Person fixture = new Person("", (String) null);
		Object obj = new Person("", (String) null);

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectHashCode_1()
		throws Exception {
		Person fixture = new Person((String) null, "");

		int result = fixture.indirectHashCode();

		assertEquals(961, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectHashCode_2()
		throws Exception {
		Person fixture = new Person("", (String) null);

		int result = fixture.indirectHashCode();

		assertEquals(961, result);
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testRemoveRole_1()
		throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.removeRole(role);

		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Rollenname angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:34)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:15)
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testRemoveRole_2()
		throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.removeRole(role);

		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Rollenname angegeben werden.
		//       at fhdw.ipscrum.shared.model.Role.setDescription(Role.java:34)
		//       at fhdw.ipscrum.shared.model.Role.<init>(Role.java:15)
	}

	/**
	 * Run the void setFirstname(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetFirstname_1()
		throws Exception {
		Person fixture = new Person("", "");
		String firstname = "";

		fixture.setFirstname(firstname);

	}

	/**
	 * Run the void setLastname(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetLastname_1()
		throws Exception {
		Person fixture = new Person("", "");
		String lastname = "";

		fixture.setLastname(lastname);

	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Person fixture = new Person("", "");

		String result = fixture.toString();

		assertEquals(" ", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Before
	public void setUp()
		throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PersonTest.class);
	}
}