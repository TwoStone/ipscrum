package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.nonMeta.Effort;

/**
 * This class represents the test for the EffortFieldCriterion.
 */
public class EffortFieldCriterionTest extends SetUpTestDataForCriterion {

	/**
	 * tests to create a new effortFieldCriterion.
	 * 
	 * @throws NoValidValueException
	 *             if one value is net valid
	 */
	@Test
	public void test01() throws NoValidValueException {
		Assert.assertEquals(new Effort(10), this.getPbi1().getManDayCosts());
		final EffortFieldCriterion c = new EffortFieldCriterion(new Effort(10));
		Assert.assertTrue(c.search(this.getPbi1()));
	}

	/**
	 * tests to create a new effortFieldCriterion.
	 * 
	 * @throws NoValidValueException
	 *             if one value is net valid
	 */
	@Test
	public void test02() throws NoValidValueException {
		Assert.assertEquals(new Effort(10), this.getPbi1().getManDayCosts());
		final EffortFieldCriterion c = new EffortFieldCriterion(new Effort(5));
		Assert.assertFalse(c.search(this.getPbi1()));
	}
}
