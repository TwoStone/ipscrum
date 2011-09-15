package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>PersonTest</code> contains tests for the class
 * <code>{@link Person}</code>.
 */
public class PersonTest {

	/**
	 * represents the model needed for using the IPScrum.
	 */
	private final Model model = new Model(new Date());

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {

		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testPerson1() throws Exception {
		final String firstname = "";
		final String lastname = "";

		new Person(this.model, firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testPerson2() throws Exception {
		final String firstname = "firstname";
		final String lastname = "";

		new Person(this.model, firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testPerson3() throws Exception {
		final String firstname = "";
		final String lastname = "lastname";

		new Person(this.model, firstname, lastname);
	}

	/**
	 * Run the Person(String,String) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testPerson4() throws Exception {
		final String firstname = "firstname";
		final String lastname = "lastname";
		final Person result = new Person(this.model, firstname, lastname);

		Assert.assertNotNull(result);
		Assert.assertEquals("firstname", result.getFirstname());
		Assert.assertEquals("lastname", result.getLastname());
		Assert.assertEquals(0, result.getRoles().size());
		// TODO: letztes assert wirft Fehler Nullpointer Stand 16.8.
	}

	/**
	 * Run the void addRole(IRole) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddRole1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role = new Role(this.model, "role");

		fixture.addRole(role);

		Assert.assertNotNull(fixture);
		Assert.assertEquals("firstname", fixture.getFirstname());
		Assert.assertEquals("lastname", fixture.getLastname());
		Assert.assertEquals(1, fixture.getRoles().size());
	}

	/**
	 * Run the void addRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddRole2() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role1 = new Role(this.model, "role1");
		final Role role2 = new Role(this.model, "role2");
		final Role role3 = new Role(this.model, "role3");

		fixture.addRole(role1);
		fixture.addRole(role2);
		fixture.addRole(role3);

		Assert.assertNotNull(fixture);
		Assert.assertEquals("firstname", fixture.getFirstname());
		Assert.assertEquals("lastname", fixture.getLastname());
		Assert.assertEquals(3, fixture.getRoles().size());

	}

	/**
	 * Run the void addRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ConsistencyException.class)
	public void testAddRole3() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role1 = new Role(this.model, "role1");
		fixture.addRole(role1);
		fixture.addRole(role1);
	}

	/**
	 * Run the String getFirstname() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetFirstname1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");

		final String result = fixture.getFirstname();
		Assert.assertEquals("firstname", result);
	}

	/**
	 * Run the String getLastname() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetLastname1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");

		final String result = fixture.getLastname();
		Assert.assertEquals("lastname", result);
	}

	/**
	 * Run the Vector<Role> getRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoles1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");

		final Vector<Role> result = fixture.getRoles();
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<Role> getRoles() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoles2() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role = new Role(this.model, "role");
		fixture.addRole(role);

		final Vector<Role> result = fixture.getRoles();
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(role, result.get(0));
	}

	/**
	 * Run the void removeRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testRemoveRole1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role = new Role(this.model, "role");

		fixture.removeRole(role);
	}

	/**
	 * Run the void removeRole(Role) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveRole2() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final Role role = new Role(this.model, "role");
		fixture.addRole(role);

		fixture.removeRole(role);
		Assert.assertEquals(0, fixture.getRoles().size());
	}

	/**
	 * Run the void setFirstname(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetFirstname1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final String firstname = "a";

		fixture.setFirstname(firstname);
		Assert.assertEquals(firstname, fixture.getFirstname());
	}

	/**
	 * Run the void setFirstname(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetFirstname2() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final String firstname = null;

		fixture.setFirstname(firstname);
	}

	/**
	 * Run the void setLastname(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetLastname1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final String lastname = "a";

		fixture.setLastname(lastname);
		Assert.assertEquals(lastname, fixture.getLastname());
	}

	/**
	 * Run the void setLastname(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetLastname2() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");
		final String lastname = null;

		fixture.setLastname(lastname);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToString1() throws Exception {
		final Person fixture = new Person(this.model, "firstname", "lastname");

		Assert.assertEquals("firstname lastname", fixture.toString());
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

}
