package fhdw.ipscrum.shared.model.metamodel.search;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * tests the operator or.
 */
public class OrTest extends SetUpTestData {

	/**
	 * test the operator with both operations true.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchTrueTrue() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final Or or = new Or(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());

		// or.add(searchExpression1);
		// or.add(searchExpression2);
		Assert.assertTrue(or.search(item));
	}

	/**
	 * test the operator with the first expression true and the second false.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchTrueFalse() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final Or or = new Or(this.getModel());
		// // TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIOpenCriterion(getModel());
		//
		// or.add(searchExpression1);
		// or.add(searchExpression2);
		Assert.assertTrue(or.search(item));
	}

	/**
	 * test the operator with the first expression false and the second true.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchFalseTrue() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final Or or = new Or(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIOpenCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());
		//
		// or.add(searchExpression1);
		// or.add(searchExpression2);
		Assert.assertTrue(or.search(item));
	}

	/**
	 * test the operator with both expressions false.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchFalseFalse() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final Or or = new Or(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIOpenCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIOpenCriterion(getModel());
		//
		// or.add(searchExpression1);
		// or.add(searchExpression2);
		Assert.assertFalse(or.search(item));
	}

}
