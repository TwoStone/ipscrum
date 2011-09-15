package fhdw.ipscrum.shared.model.nonMeta.incidents;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * This test class is used for testing the methods of the class IncidentType.
 */
public class IncidentTypeTest extends SetUpTestData {

	/**
	 * Tests if the construction of an incident type is successful and the name of the
	 * type also is the given one.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIncidentType1() throws Exception {
		final String name = "Hindernis";

		final IncidentType result = new IncidentType(this.getModel(), name);

		Assert.assertNotNull(result);
		Assert.assertEquals("Hindernis", result.getName());
	}

	/**
	 * Tests if two incident types with slightly different names are asserted not equal.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals1() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Hindernis");
		final Object obj = new IncidentType(this.getModel(), "Hinderns");

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Tests if the DoubleDefinitionException is thrown if a incident type should be
	 * created which already exists.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testEquals1V2() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Hindernis");
		final Object obj = new IncidentType(this.getModel(), "Hindernis");

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(true, result);
	}

	/**
	 * Tests if equals works appropriate by comparing an incident type and null.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals2() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Hindernis");
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Tests if equals works appropriate by comparing an incident type and an simple
	 * object.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals3() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Hindernis");
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Tests if the DoubleDefintionException is thrown if a incident type should be
	 * created that already exists.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testEquals4() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "oper");
		final Object obj = new IncidentType(this.getModel(), "oper");

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(true, result);
	}

	/**
	 * Tests if equals works appropriate by comparing an incident type with the name "Tag"
	 * and an one with the name "Nacht".
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals5() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Tag");
		final Object obj = new IncidentType(this.getModel(), "Nacht");

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Tests if equals works appropriate by comparing an incident type with the name
	 * "Nettigkeit" and an one with the name "Netigkeit".
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals6() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Nettigkeit");
		final Object obj = new IncidentType(this.getModel(), "Netigkeit");

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Tests if the getName-method works appropriate and returns the current name of the
	 * incident type.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetName1() throws Exception {
		final IncidentType fixture = new IncidentType(this.getModel(), "Hindernis");

		final String result = fixture.getName();

		Assert.assertEquals("Hindernis", result);
	}

}
