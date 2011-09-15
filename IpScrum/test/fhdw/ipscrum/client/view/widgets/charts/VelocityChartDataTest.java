package fhdw.ipscrum.client.view.widgets.charts;

import org.junit.Assert;
import org.junit.Test;

import com.google.gwt.user.datepicker.client.CalendarUtil;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This test class is used for testing the methods of the VelocityChartData.
 */
public class VelocityChartDataTest extends SetUpTestData {

	/**
	 * represents the double "not a number", which is used to check if the results are
	 * really numbers.
	 */
	@SuppressWarnings({ "unused", "static-access" })
	private static Double nan = new Double(0).NaN;

	// ------------------ Test of the Constructor--------------------------//

	/**
	 * Tests if the constructor of the velocotyChartData works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testVelocityChartData1() throws Exception {
		final Team team = this.team1;

		final VelocityChartData result = new VelocityChartData(team);

		Assert.assertNotNull(result);
	}

	// ------------------ Tests of the method
	// calculateRelativeVelocity()--------------------------//

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity1() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel1spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity2() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel1spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity3() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel1spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity4() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel1spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity5() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel1spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity6() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel2spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity7() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel2spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity8() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel2spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity9() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel2spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity10() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro1rel2spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity11() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity12() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity13() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity14() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity15() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity16() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel2spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity17() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel2spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity18() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel2spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity19() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel2spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity20() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);
		final Sprint sprint = this.pro3rel1spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity21() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel1spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity22() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel1spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity23() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel1spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity24() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel1spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity25() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel1spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity26() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel2spr1;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity27() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel2spr2;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity28() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel2spr3;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity29() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel2spr4;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	/**
	 * Tests the calculateRelativeVelocity-method to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testCalculateRelativeVelocity30() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);
		final Sprint sprint = this.pro2rel2spr5;

		final double result = fixture.calculateRelativeVelocity(sprint);

		// calculation the expected value of the relative velocity
		final double sprintLength =
				CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		final double expected =
				sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/ sprintLength;

		Assert.assertEquals(expected, result, 0.1);
	}

	// ------------------ Tests of the method
	// getAbsAverageVelocity()--------------------------//

	/**
	 * Tests the method which gets the absolute velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetAbsAverageVelocity1() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);

		final Double result = fixture.getAbsAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(10, result.doubleValue(), 0.2);
	}

	/**
	 * Tests the method which gets the absolute velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetAbsAverageVelocity2() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team2);

		final Double result = fixture.getAbsAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(10, result.doubleValue(), 0.1);
	}

	/**
	 * Tests the method which gets the absolute velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetAbsAverageVelocity3() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team3);

		final Double result = fixture.getAbsAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(10, result.doubleValue(), 0.1);

	}

	/**
	 * Tests the method which gets the absolute velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetAbsAverageVelocity4() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);

		final Double result = fixture.getAbsAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(10, result.doubleValue(), 0.1);

	}

	// ------------------ Tests of the method
	// getRelAverageVelocity()--------------------------//

	/**
	 * Tests the method which gets the relative velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetRelAverageVelocity1() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);

		final Double result = fixture.getRelAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(0.37, result.doubleValue(), 0.01);
	}

	/**
	 * Tests the method which gets the relative velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetRelAverageVelocity2() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team2);

		final Double result = fixture.getRelAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(0.37, result.doubleValue(), 0.1);
	}

	/**
	 * Tests the method which gets the relative velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetRelAverageVelocity3() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team3);

		final Double result = fixture.getRelAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(0.37, result.doubleValue(), 0.1);
	}

	/**
	 * Tests the method which gets the relative velocity to check if the method works
	 * appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetRelAverageVelocity4() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team4);

		final Double result = fixture.getRelAverageVelocity();

		Assert.assertNotNull(result);
		Assert.assertEquals(0.37, result.doubleValue(), 0.01);
	}

	// ------------------ Test of the method
	// getTeam()--------------------------//
	/**
	 * Tests the method which gets the team of the velocity chart to check if the method
	 * works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testGetTeam1() throws Exception {
		final VelocityChartData fixture = new VelocityChartData(this.team1);

		final Team result = fixture.getTeam();

		Assert.assertNotNull(result);
		Assert.assertEquals(this.team1, result);
		Assert.assertNotSame(this.team2, result);
		Assert.assertNotSame(this.team3, result);
		Assert.assertNotSame(this.team4, result);
	}

}
