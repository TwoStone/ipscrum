package fhdw.ipscrum.shared.model;

import java.util.Date;

import org.junit.Test;

public class SprintBacklogTest extends SetUpTestData {

	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testGetEffortByDay() {
		int value = pro1rel1spr1.getSprintBacklog().getEffortByDay(new Date());

	}

	@Test
	public void testCalculateOverallTaskEffort() {
	}

}
