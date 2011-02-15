package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * The class <code>PersonTest</code> contains tests for the class
 * <code>{@link Person}</code>.
 * 
 * @generatedBy CodePro at 15.02.11 11:21
 */
public class PersonTest {
	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_1() throws Exception {
		String firstname = "";
		String lastname = "";

		Person result = new Person(firstname, lastname);

		assertNotNull(result);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_2() throws Exception {
		String firstname = "";
		String lastname = "a";

		Person result = new Person(firstname, lastname);

		assertNotNull(result);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_3() throws Exception {
		String firstname = "";
		String lastname = "";

		Person result = new Person(firstname, lastname);

		assertNotNull(result);
	}

	/**
	 * Run the void addRole(IRole) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testAddRole_1() throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.addRole(role);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
	}

	/**
	 * Run the void addRole(IRole) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testAddRole_2() throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.addRole(role);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
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
		Person fixture = new Person("", "");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
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
		Person fixture = new Person("", "");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the String getFirstname() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetFirstname_1() throws Exception {
		Person fixture = new Person("", "");

		String result = fixture.getFirstname();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the String getLastname() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetLastname_1() throws Exception {
		Person fixture = new Person("", "");

		String result = fixture.getLastname();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetRoles_1() throws Exception {
		Person fixture = new Person("", "");

		Vector<IRole> result = fixture.getRoles();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetRoles_2() throws Exception {
		Person fixture = new Person("", "");

		Vector<IRole> result = fixture.getRoles();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.IPerson.ToRoleAssoc
	 * getToRoleAssoc() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetToRoleAssoc_1() throws Exception {
		Person fixture = new Person("", "");

		fhdw.ipscrum.shared.model.interfaces.IPerson.ToRoleAssoc result = fixture.getToRoleAssoc();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
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
		Person fixture = new Person("", "");

		int result = fixture.hashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		Person fixture = new Person("", "");
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_3() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_4() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_5() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_6() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_7() throws Exception {
		Person fixture = new Person("", "");
		Object obj = new Person("", "");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		Person fixture = new Person("", "");

		int result = fixture.indirectHashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertEquals(0, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		Person fixture = new Person("", "");

		int result = fixture.indirectHashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
		assertEquals(0, result);
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testRemoveRole_1() throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.removeRole(role);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testRemoveRole_2() throws Exception {
		Person fixture = new Person("", "");
		IRole role = new Role("");

		fixture.removeRole(role);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
	}

	/**
	 * Run the void setFirstname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testSetFirstname_1() throws Exception {
		Person fixture = new Person("a", "a");
		String firstname = "a";

		fixture.setFirstname(firstname);

	}

	/**
	 * Run the void setFirstname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetFirstname_2() throws Exception {
		Person fixture = new Person("", "");
		String firstname = null;

		fixture.setFirstname(firstname);

	}

	/**
	 * Run the void setFirstname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetFirstname_3() throws Exception {
		Person fixture = new Person("", "");
		String firstname = "";

		fixture.setFirstname(firstname);

	}

	/**
	 * Run the void setLastname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testSetLastname_1() throws Exception {
		Person fixture = new Person("a", "a");
		String lastname = "a";

		fixture.setLastname(lastname);

	}

	/**
	 * Run the void setLastname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetLastname_2() throws Exception {
		Person fixture = new Person("", "");
		String lastname = null;

		fixture.setLastname(lastname);

	}

	/**
	 * Run the void setLastname(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetLastname_3() throws Exception {
		Person fixture = new Person("", "");
		String lastname = "";

		fixture.setLastname(lastname);

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
		Person fixture = new Person("", "");

		String result = fixture.toString();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// vollständiger Name angegeben werden.
		// at fhdw.ipscrum.shared.model.Person.setFirstname(Person.java:36)
		// at fhdw.ipscrum.shared.model.Person.<init>(Person.java:18)
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
		new org.junit.runner.JUnitCore().run(PersonTest.class);
	}
}