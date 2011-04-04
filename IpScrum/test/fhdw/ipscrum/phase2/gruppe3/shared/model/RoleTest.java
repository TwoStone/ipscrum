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
 * The class <code>RoleTest</code> contains tests for the class
 * <code>{@link Role}</code>.
 */
public class RoleTest {
	/**
	 * Run the Role(String) constructor test.
	 */
	public void testRole_1() throws Exception {
		final String description = "Rolle";
		final Role result = new Role(description);
		assertNotNull(result);
	}

	/**
	 * Run the Role(String) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testRole_2() throws Exception {
		final String description = "";
		final Role result = new Role(description);
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final Object obj = new Role("Rolle");
		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Role fixture = new Role("Rolle1");
		final Object obj = new Role("Rolle2");
		final boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_6() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_7() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		final boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the String getDescription() method test.
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final String result = fixture.getDescription();
		assertEquals("Rolle", result);
	}

	/**
	 * Run the Vector<IPerson> getPersons() method test.
	 */
	@Test
	public void testGetPersons_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final Vector<IPerson> result = fixture.getPersons();
		assertEquals(new Vector<IPerson>(), result);
	}

	/**
	 * Run the Vector<IPerson> getPersons() method test.
	 */
	@Test
	public void testGetPersons_2() throws Exception {
		final Role fixture = new Role("Rolle");
		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);

		final Vector<IPerson> expected = new Vector<IPerson>();
		expected.add(person);
		final Vector<IPerson> result = fixture.getPersons();

		assertEquals(expected, result);
	}

	/**
	 * Run the Vector<IPerson> getPersons() method test.
	 */
	@Test
	public void testGetPersons_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person2 = new Person("firstname2", "lastname2");
		person2.addRole(fixture);

		final Vector<IPerson> expected = new Vector<IPerson>();
		expected.add(person);
		expected.add(person2);
		final Vector<IPerson> result = fixture.getPersons();

		assertEquals(expected, result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.IRole.ToPersonAssoc
	 * getToPersonAssoc() method test.
	 */
	@Test
	public void testGetToPersonAssoc_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final ManyToMany<ManyToMany<?, ?>, IRole> result = fixture
				.getToPersonAssoc();
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final Object obj = new Role("Rolle");
		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final Role fixture = new Role("Rolle1");
		final Object obj = new Role("Rolle2");
		assertFalse(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_4() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);

		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_5() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_6() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_7() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		assertTrue(fixture.hashCode() == obj.hashCode());
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final Object obj = new Role("Rolle");
		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		final Role fixture = new Role("Rolle1");
		final Object obj = new Role("Rolle2");
		final boolean result = fixture.indirectEquals(obj);
		assertFalse(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_4() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_5() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_6() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_7() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		final boolean result = fixture.indirectEquals(obj);
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");
		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		final Role fixture = new Role("Rolle1");
		final Role obj = new Role("Rolle2");
		assertFalse(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_4() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);

		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_5() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person1 = new Person("firstname", "lastname");
		person1.addRole(fixture);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_6() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);

		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_7() throws Exception {
		final Role fixture = new Role("Rolle");
		final Role obj = new Role("Rolle");

		final Person person = new Person("firstname", "lastname");
		person.addRole(fixture);
		final Person person3 = new Person("firstname2", "lastname2");
		person3.addRole(fixture);
		final Person person4 = new Person("firstname2", "lastname2");
		person4.addRole(obj);
		final Person person2 = new Person("firstname", "lastname");
		person2.addRole(obj);

		assertTrue(fixture.indirectHashCode() == obj.indirectHashCode());
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final String description = null;
		fixture.setDescription(description);
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetDescription_2() throws Exception {
		final Role fixture = new Role("Rolle");
		final String description = "";
		fixture.setDescription(description);
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test
	public void testSetDescription_3() throws Exception {
		final Role fixture = new Role("Rolle");
		final String description = "andereRolle";
		fixture.setDescription(description);
		assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the String toString() method test.
	 */
	@Test
	public void testToString_1() throws Exception {
		final Role fixture = new Role("Rolle");
		final String result = fixture.toString();
		assertEquals("Rolle", result);
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
		new org.junit.runner.JUnitCore().run(RoleTest.class);
	}
}