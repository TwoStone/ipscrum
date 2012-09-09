package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;

/**
 * Tets the HintFieldCriterion.
 */
public class HintFieldCriterionTest extends SetUpTestDataForCriterion {

	/**
	 * test to create a HintFieldCriterion.
	 * 
	 * @throws NoValidValueException
	 *             if one value is nor valid
	 */
	@Test
	public void test01() throws NoValidValueException {
		final HintFieldCriterion c = new HintFieldCriterion("Kleinschreibung");
		Assert.assertTrue(c.search(this.getPbi1()));
	}

	/**
	 * tests to create a HintFieldCriterion.
	 * 
	 * @throws NoValidValueException
	 *             if one value is not valid
	 */
	@Test
	public void test02() throws NoValidValueException {
		final HintFieldCriterion c = new HintFieldCriterion("Kleinschreibung");
		Assert.assertFalse(c.search(this.getPbi2()));
	}
}
