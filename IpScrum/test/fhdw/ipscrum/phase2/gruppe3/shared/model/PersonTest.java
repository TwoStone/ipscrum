package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * The class <code>PersonTest</code> contains tests for the class
 * <code>{@link Person}</code>.
 */
public class PersonTest {
	/**
	 * Run the Person(String,String) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_1() throws Exception {
		final String firstname = "";
		final String lastname = "";

		new Person(firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_2() throws Exception {
		final String firstname = "firstname";
		final String lastname = "";

		new Person(firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testPerson_3() throws Exception {
		final String firstname = "";
		final String lastname = "lastname";

		new Person(firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 */
	@Test
	public void testPerson_4() throws Exception {
		final String firstname = "firstname";
		final String lastname = "lastname";
		final Person result = new Person(firstname, lastname);

		assertNotNull(result);
		assertEquals("firstname", result.getFirstname());
		assertEquals("lastname", result.getLastname());
		assertEquals(0, result.getRoles().size());
	}

	/**
	 * Run the void addRole(IRole) method test.
	 */
	@Test
	public void testAddRole_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final IRole role = new Role("role");

		fixture.addRole(role);

		assertNotNull(fixture);
		assertEquals("firstname", fixture.getFirstname());
		assertEquals("lastname", fixture.getLastname());
		assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void addRole(IRole) method test.
	 */
	@Test
	public void testAddRole_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final IRole role1 = new Role("role1");
		final IRole role2 = new Role("role2");
		final IRole role3 = new Role("role3");

		fixture.addRole(role1);
		fixture.addRole(role2);
		fixture.addRole(role3);

		assertNotNull(fixture);
		assertEquals("firstname", fixture.getFirstname());
		assertEquals("lastname", fixture.getLastname());
		assertEquals(3, fixture.getRoles().size());

	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");

		fixture.addRole(role);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");

		obj.addRole(role);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("first", "lastname");

		final boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Person fixture = new Person("firstname", "last");
		final Person obj = new Person("firstname", "lastname");

		final boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the String getFirstname() method test.
	 */
	@Test
	public void testGetFirstname_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");

		final String result = fixture.getFirstname();
		assertEquals("firstname", result);
	}

	/**
	 * Run the String getLastname() method test.
	 */
	@Test
	public void testGetLastname_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");

		final String result = fixture.getLastname();
		assertEquals("lastname", result);
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 */
	@Test
	public void testGetRoles_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");

		final Vector<IRole> result = fixture.getRoles();
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<IRole> getRoles() method test.
	 */
	@Test
	public void testGetRoles_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		fixture.addRole(role);

		final Vector<IRole> result = fixture.getRoles();
		assertEquals(1, result.size());
		assertEquals(role, result.get(0));
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.IPerson.ToRoleAssoc
	 * getToRoleAssoc() method test.
	 */
	@Test
	public void testGetToRoleAssoc_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");

		final ManyToMany<ManyToMany<?, ?>, IPerson> result = fixture
				.getToRoleAssoc();
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");

		assertEquals(obj.hashCode(), fixture.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		fixture.addRole(role);

		assertEquals(obj.hashCode(), fixture.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_3() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		obj.addRole(role);

		assertEquals(obj.hashCode(), fixture.hashCode());
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Object obj = null;

		final boolean result = fixture.indirectEquals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_3() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		fixture.addRole(role);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_4() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		obj.addRole(role);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");

		assertEquals(obj.indirectHashCode(), fixture.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final Person obj = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		obj.addRole(role);

		assertEquals(obj.indirectHashCode(), fixture.indirectHashCode());
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.ConsistencyException.class)
	public void testRemoveRole_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final IRole role = new Role("role");

		fixture.removeRole(role);
	}

	/**
	 * Run the void removeRole(IRole) method test.
	 */
	@Test
	public void testRemoveRole_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final IRole role = new Role("role");
		fixture.addRole(role);

		fixture.removeRole(role);
		assertEquals(0, fixture.getRoles().size());
	}

	/**
	 * Run the void setFirstname(String) method test.
	 */
	@Test
	public void testSetFirstname_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final String firstname = "a";

		fixture.setFirstname(firstname);
		assertEquals(firstname, fixture.getFirstname());
	}

	/**
	 * Run the void setFirstname(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetFirstname_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final String firstname = null;

		fixture.setFirstname(firstname);
	}

	/**
	 * Run the void setLastname(String) method test.
	 */
	@Test
	public void testSetLastname_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final String lastname = "a";

		fixture.setLastname(lastname);
		assertEquals(lastname, fixture.getLastname());
	}

	/**
	 * Run the void setLastname(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetLastname_2() throws Exception {
		final Person fixture = new Person("firstname", "lastname");
		final String lastname = null;

		fixture.setLastname(lastname);
	}

	/**
	 * Run the String toString() method test.
	 */
	@Test
	public void testToString_1() throws Exception {
		final Person fixture = new Person("firstname", "lastname");

		assertEquals("firstname lastname", fixture.toString());
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
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(PersonTest.class);
	}
}