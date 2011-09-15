package fhdw.ipscrum.shared.model.metamodel.search;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * Test the Search Operator And.
 */
public class AndTest extends SetUpTestData {

	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.model = new Model(new Date());
		this.model.setUuidManager(new IDGenerator());
	}

	/**
	 * test the and operator if both sides are true.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchTrueTrue() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final And and = new And(this.model);
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());

		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertTrue(and.search(item));
	}

	/**
	 * test the operator while the first expression is true and the second false.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchTrueFalse() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final And and = new And(this.model);

		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIOpenCriterion(getModel());
		//
		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertFalse(and.search(item));
	}

	/**
	 * tests the operator while the first expression is false and the second is true.
	 * 
	 * @throws IPScrumGeneralException
	 *             is something fails
	 */
	@Test
	public void testSearchFalseTrue() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final And and = new And(this.model);
		// TODO
		// SearchExpression searchExpression1 = new PBIOpenCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());

		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertFalse(and.search(item));
	}

	/**
	 * test the operator if both expressions are false.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	@Test
	public void testSearchFalseFalse() throws IPScrumGeneralException {
		final ProductBacklogItem item = this.pro1rel1spr1fea1;

		final And and = new And(this.model);
		// TODO
		// SearchExpression searchExpression1 = new PBIOpenCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIOpenCriterion(getModel());
		//
		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertFalse(and.search(item));
	}

}
