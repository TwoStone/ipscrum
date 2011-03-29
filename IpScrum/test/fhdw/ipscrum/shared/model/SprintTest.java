package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;


public class SprintTest extends SetUpTestData {

	@Test
	public void testGetCumulatedManDayCosts() {
		try {
			assertEquals(new Effort(19), this.pro1rel1spr1.getCumulatedManDayCosts());
			assertEquals(new Effort(36), this.pro1rel1spr2.getCumulatedManDayCosts());
			assertEquals(new Effort(77), this.pro1rel1spr3.getCumulatedManDayCosts());
			assertEquals(new Effort(31), this.pro1rel1spr4.getCumulatedManDayCosts());
			assertEquals(new Effort(63), this.pro1rel1spr5.getCumulatedManDayCosts());

			assertEquals(new Effort(112), this.pro1rel2spr1.getCumulatedManDayCosts());
			assertEquals(new Effort(71), this.pro1rel2spr2.getCumulatedManDayCosts());
			assertEquals(new Effort(206), this.pro1rel2spr3.getCumulatedManDayCosts());
			assertEquals(new Effort(142), this.pro1rel2spr4.getCumulatedManDayCosts());
			assertEquals(new Effort(39), this.pro1rel2spr5.getCumulatedManDayCosts());

			assertEquals(new Effort(19), this.pro2rel1spr1.getCumulatedManDayCosts());
			assertEquals(new Effort(19), this.pro2rel1spr2.getCumulatedManDayCosts());
			assertEquals(new Effort(19), this.pro2rel1spr3.getCumulatedManDayCosts());
			assertEquals(new Effort(19), this.pro2rel1spr4.getCumulatedManDayCosts());
			assertEquals(new Effort(19), this.pro2rel1spr5.getCumulatedManDayCosts());

			assertEquals(new Effort(169), this.pro2rel2spr1.getCumulatedManDayCosts());
			assertEquals(new Effort(47), this.pro2rel2spr2.getCumulatedManDayCosts());
			assertEquals(new Effort(60), this.pro2rel2spr3.getCumulatedManDayCosts());
			assertEquals(new Effort(45), this.pro2rel2spr4.getCumulatedManDayCosts());
			assertEquals(new Effort(25), this.pro2rel2spr5.getCumulatedManDayCosts());
		} catch (NoValidValueException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetCumulatedManDayCostsOfClosedPbis() {
		try {
			assertEquals(new Effort(10), this.pro1rel1spr1.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(20), this.pro1rel1spr2.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(50), this.pro1rel1spr3.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(0), this.pro1rel1spr4.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(63), this.pro1rel1spr5.getCumulatedManDayCostsOfClosedPbis());

			assertEquals(new Effort(92), this.pro1rel2spr1.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(41), this.pro1rel2spr2.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(103), this.pro1rel2spr3.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(116), this.pro1rel2spr4.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(22), this.pro1rel2spr5.getCumulatedManDayCostsOfClosedPbis());

			assertEquals(new Effort(16), this.pro2rel1spr1.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(12), this.pro2rel1spr2.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(7), this.pro2rel1spr3.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(3), this.pro2rel1spr4.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(0), this.pro2rel1spr5.getCumulatedManDayCostsOfClosedPbis());

			assertEquals(new Effort(71), this.pro2rel2spr1.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(31), this.pro2rel2spr2.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(43), this.pro2rel2spr3.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(24), this.pro2rel2spr4.getCumulatedManDayCostsOfClosedPbis());
			assertEquals(new Effort(12), this.pro2rel2spr5.getCumulatedManDayCostsOfClosedPbis());
		} catch (NoValidValueException e) {
			fail(e.getMessage());
		}
	}

}
