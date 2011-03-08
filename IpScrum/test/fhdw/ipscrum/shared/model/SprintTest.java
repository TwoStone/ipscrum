package fhdw.ipscrum.shared.model;

import org.junit.Test;
import java.lang.System;
import static org.junit.Assert.*;


public class SprintTest extends SetUpTestData {

	@Test
	public void testGetCumulatedManDayCosts() {		
		assertEquals(19, this.pro1rel1spr1.getCumulatedManDayCosts());
		assertEquals(36, this.pro1rel1spr2.getCumulatedManDayCosts());
		assertEquals(77, this.pro1rel1spr3.getCumulatedManDayCosts());
		assertEquals(31, this.pro1rel1spr4.getCumulatedManDayCosts());
		assertEquals(63, this.pro1rel1spr5.getCumulatedManDayCosts());
		
		assertEquals(112, this.pro1rel2spr1.getCumulatedManDayCosts());
		assertEquals(71, this.pro1rel2spr2.getCumulatedManDayCosts());
		assertEquals(206, this.pro1rel2spr3.getCumulatedManDayCosts());
		assertEquals(142, this.pro1rel2spr4.getCumulatedManDayCosts());
		assertEquals(39, this.pro1rel2spr5.getCumulatedManDayCosts());
		
		assertEquals(19, this.pro2rel1spr1.getCumulatedManDayCosts());
		assertEquals(19, this.pro2rel1spr2.getCumulatedManDayCosts());
		assertEquals(19, this.pro2rel1spr3.getCumulatedManDayCosts());
		assertEquals(19, this.pro2rel1spr4.getCumulatedManDayCosts());
		assertEquals(19, this.pro2rel1spr5.getCumulatedManDayCosts());
		
		assertEquals(169, this.pro2rel2spr1.getCumulatedManDayCosts());
		assertEquals(47, this.pro2rel2spr2.getCumulatedManDayCosts());
		assertEquals(60, this.pro2rel2spr3.getCumulatedManDayCosts());
		assertEquals(45, this.pro2rel2spr4.getCumulatedManDayCosts());
		assertEquals(25, this.pro2rel2spr5.getCumulatedManDayCosts());
		
	}

	@Test
	public void testGetCumulatedManDayCostsOfClosedPbis() {
		assertEquals(10, this.pro1rel1spr1.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(20, this.pro1rel1spr2.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(50, this.pro1rel1spr3.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(0, this.pro1rel1spr4.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(63, this.pro1rel1spr5.getCumulatedManDayCostsOfClosedPbis());
		
		assertEquals(92, this.pro1rel2spr1.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(41, this.pro1rel2spr2.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(103, this.pro1rel2spr3.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(116, this.pro1rel2spr4.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(22, this.pro1rel2spr5.getCumulatedManDayCostsOfClosedPbis());
		
		assertEquals(16, this.pro2rel1spr1.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(12, this.pro2rel1spr2.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(7, this.pro2rel1spr3.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(3, this.pro2rel1spr4.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(0, this.pro2rel1spr5.getCumulatedManDayCostsOfClosedPbis());
		
		assertEquals(71, this.pro2rel2spr1.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(31, this.pro2rel2spr2.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(43, this.pro2rel2spr3.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(24, this.pro2rel2spr4.getCumulatedManDayCostsOfClosedPbis());
		assertEquals(12, this.pro2rel2spr5.getCumulatedManDayCostsOfClosedPbis());
	}

}
