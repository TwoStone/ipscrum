package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.userRights.ProductBacklogRight;
import fhdw.ipscrum.shared.model.userRights.ProjectHistoryRight;
import fhdw.ipscrum.shared.model.userRights.Right;
import fhdw.ipscrum.shared.model.userRights.TeamAdminRight;

/**
 * The class <code>RoleTest</code> contains tests for the class <code>{@link Role}</code>.
 */
public class RoleTest {
	/**
	 * represents the model, which is relevant to use the IPScrum, because is represents
	 * the base of the program.
	 */
	private final Model model = new Model(new Date());

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the setUp fails
	 */
	@Before
	public void setUp() throws Exception {

		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * Run the Role(String) constructor test. Tests if a role could be constructed.
	 * 
	 * @throws Exception
	 *             if the construction of the role fails
	 */
	public void testRole1() throws Exception {
		final String description = "Rolle";
		final Role result = new Role(this.model, description);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Role(String) constructor test. Tests if a NoValidValueException is thrown
	 * by using the empty word as the role description, which is not valid.
	 * 
	 * @throws Exception
	 *             if the construction of the role fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testRole2() throws Exception {
		final String description = "";
		final Role result = new Role(this.model, description);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the String getDescription() method test. Tests if the getter, gets the right
	 * current description.
	 * 
	 * @throws Exception
	 *             if the get of the role description fails
	 */
	@Test
	public void testGetDescription1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final String result = fixture.getDescription();
		Assert.assertEquals("Rolle", result);
	}

	/**
	 * Run the Vector<Person> getPersons() method test. Tests if the got persons are the
	 * right current ones.
	 * 
	 * @throws Exception
	 *             if the persons of the role couldn't be got.
	 */
	@Test
	public void testGetPersons1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final Vector<Person> result = fixture.getPersons();
		Assert.assertEquals(new Vector<Person>(), result);
	}

	/**
	 * Run the Vector<Person> getPersons() method test. Tests if the method getPersons
	 * delivers all current persons from the role.
	 * 
	 * @throws Exception
	 *             if persons could not been added to the role or the persons could not
	 *             been get from the role
	 */
	@Test
	public void testGetPersons2() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final Person person = new Person(this.model, "firstname", "lastname");
		person.addRole(fixture);

		final Vector<Person> expected = new Vector<Person>();
		expected.add(person);
		final Vector<Person> result = fixture.getPersons();

		Assert.assertEquals(expected, result);
	}

	/**
	 * Run the Vector<Person> getPersons() method test. Tests if the persons got from the
	 * role are the ones added to it before.
	 * 
	 * @throws Exception
	 *             if persons could not been added to the role or the persons could not
	 *             been get from the role
	 */
	@Test
	public void testGetPersons3() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final Person person = new Person(this.model, "firstname", "lastname");
		person.addRole(fixture);
		final Person person2 = new Person(this.model, "firstname2", "lastname2");
		person2.addRole(fixture);

		final Vector<Person> expected = new Vector<Person>();
		expected.add(person);
		expected.add(person2);
		final Vector<Person> result = fixture.getPersons();

		Assert.assertTrue(result.contains(person));
		Assert.assertTrue(result.contains(person2));
	}

	/**
	 * Run the void setDescription(String) method test. Tests if the NoValidValueException
	 * is thrown if the new description to set is a value which is not valid, like null or
	 * "".
	 * 
	 * @throws Exception
	 *             if the description could not been set
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetDescription1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final String description = null;
		fixture.setDescription(description);
	}

	/**
	 * Run the void setDescription(String) method test.Tests if the NoValidValueException
	 * is thrown if the new description to set is a value which is not valid, like null or
	 * "".
	 * 
	 * @throws Exception
	 *             if the description could not been set
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetDescription2() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final String description = "";
		fixture.setDescription(description);
	}

	/**
	 * Run the void setDescription(String) method test. Tests if the description could
	 * been set if the value is a valid one.
	 * 
	 * @throws Exception
	 *             if the description could not been set
	 */
	@Test
	public void testSetDescription3() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final String description = "andereRolle";
		fixture.setDescription(description);
		Assert.assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the String toString() method test. Tests if the toString-method delivers the
	 * expected string, which should be the description.
	 * 
	 * @throws Exception
	 *             if the toString-Method fails
	 */
	@Test
	public void testToString1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final String result = fixture.toString();
		Assert.assertEquals("Rolle", result);
	}

	/**
	 * Run the addRight method test. Tests, if a right is added to a Role Test with one
	 * right added
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testaddRight1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		fixture.addRight(pbr);
		Assert.assertTrue(fixture.getRights().contains(pbr));
	}

	/**
	 * Run the addRight method test. Tests, if a right is added to a Role Test with
	 * multiple rights added
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testaddRight2() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		final ProjectHistoryRight phr = new ProjectHistoryRight(this.model);
		final TeamAdminRight tar = new TeamAdminRight(this.model);
		fixture.addRight(pbr);
		fixture.addRight(phr);
		fixture.addRight(tar);
		Assert.assertTrue(fixture.getRights().contains(pbr));
		Assert.assertTrue(fixture.getRights().contains(phr));
		Assert.assertTrue(fixture.getRights().contains(tar));
	}

	/**
	 * Run the addRight method test. Tests, if an Exception is thrown upon adding the same
	 * right again
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException.class)
	public
			void testaddRight3() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		fixture.addRight(pbr);
		fixture.addRight(pbr);

	}

	/**
	 * Run the removeRight method test. Tests, if a right is removed from a Role Test with
	 * one right
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testremoveRight1() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		fixture.addRight(pbr);
		Assert.assertTrue(fixture.getRights().contains(pbr));
		fixture.removeRight(pbr);
		Assert.assertFalse(fixture.getRights().contains(pbr));
	}

	/**
	 * Run the removeRight method test. Tests, if a right is removed from a Role Test with
	 * multiple rights
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testremoveRight2() throws Exception {
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		final ProjectHistoryRight phr = new ProjectHistoryRight(this.model);
		final TeamAdminRight tar = new TeamAdminRight(this.model);
		fixture.addRight(pbr);
		fixture.addRight(phr);
		fixture.addRight(tar);
		Assert.assertTrue(fixture.getRights().contains(pbr));
		Assert.assertTrue(fixture.getRights().contains(phr));
		Assert.assertTrue(fixture.getRights().contains(tar));
		fixture.removeRight(pbr);
		Assert.assertFalse(fixture.getRights().contains(pbr));
		Assert.assertTrue(fixture.getRights().contains(phr));
		Assert.assertTrue(fixture.getRights().contains(tar));
	}

	/**
	 * Run the getRights method test. One right
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testgetRights1() throws Exception {
		final List<Right> liste = new ArrayList<Right>();
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		fixture.addRight(pbr);
		liste.add(pbr);

		Assert.assertEquals(liste, fixture.getRights());
	}

	/**
	 * Run the getRights method test. Multiple rights
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testgetRights2() throws Exception {
		final List<Right> liste = new ArrayList<Right>();
		final Role fixture = new Role(this.model, "Rolle");
		final ProductBacklogRight pbr = new ProductBacklogRight(this.model);
		final ProjectHistoryRight phr = new ProjectHistoryRight(this.model);
		final TeamAdminRight tar = new TeamAdminRight(this.model);
		fixture.addRight(pbr);
		liste.add(pbr);
		fixture.addRight(phr);
		liste.add(phr);
		fixture.addRight(tar);
		liste.add(tar);

		Assert.assertEquals(liste, fixture.getRights());
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the tear down fails
	 */
	@After
	public void tearDown() throws Exception {
	}

}
