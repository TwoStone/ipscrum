package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import java.util.SortedMap;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import org.junit.*;
import static org.junit.Assert.*;


public class VelocityChartDataTest extends SetUpTestData {
	private static Double nan = new Double(0).NaN;
	
	
//------------------ Test of the Constructor--------------------------//
	@Test
	public void testVelocityChartData_1()
		throws Exception {
		ITeam team = this.team1;

		VelocityChartData result = new VelocityChartData(team);

		assertNotNull(result);
	}


//------------------ Tests of the method calculateRelativeVelocity()--------------------------//
	@Test
	public void testCalculateRelativeVelocity_1()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel1spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}
	
	@Test
	public void testCalculateRelativeVelocity_2()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel1spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}
	
	@Test
	public void testCalculateRelativeVelocity_3()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel1spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}
	
	@Test
	public void testCalculateRelativeVelocity_4()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel1spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_5()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel1spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_6()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel2spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_7()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel2spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_8()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel2spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_9()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel2spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_10()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro1rel2spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;
		

		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_11()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_12()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_13()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_14()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_15()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_16()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel2spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_17()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel2spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_18()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel2spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_19()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel2spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_20()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);
		ISprint sprint = this.pro3rel1spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_21()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel1spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_22()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel1spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_23()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel1spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_24()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel1spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_25()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel1spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_26()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel2spr1;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_27()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel2spr2;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_28()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel2spr3;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_29()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel2spr4;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

	@Test
	public void testCalculateRelativeVelocity_30()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);
		ISprint sprint = this.pro2rel2spr5;

		double result = fixture.calculateRelativeVelocity(sprint);
		
		// calculation the expected value of the relative velocity
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());		
		double expected = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue()
						/sprintLength;

		
		assertEquals(expected, result, 0.1);
	}

//------------------ Tests of the method getAbsAverageVelocity()--------------------------//
	@Test
	public void testGetAbsAverageVelocity_1()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);

		Double result = fixture.getAbsAverageVelocity();

		assertNotNull(result);
		assertEquals(36.8, result.doubleValue(),0.1);
	}

	@Test
	public void testGetAbsAverageVelocity_2()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team2);

		Double result = fixture.getAbsAverageVelocity();
		
		assertNotNull(result);
		assertEquals(this.nan.doubleValue(), result.doubleValue(),0.1);
	}

	@Test
	public void testGetAbsAverageVelocity_3()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team3);

		Double result = fixture.getAbsAverageVelocity();
		
		assertNotNull(result);
		assertEquals(this.nan.doubleValue(), result.doubleValue(),0.1);

	}

	@Test
	public void testGetAbsAverageVelocity_4()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);

		Double result = fixture.getAbsAverageVelocity();


		assertNotNull(result);
		assertEquals(22.4, result.doubleValue(),0.1);

	}

//------------------ Tests of the method getRelAverageVelocity()--------------------------//
	@Test
	public void testGetRelAverageVelocity_1()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);

		Double result = fixture.getRelAverageVelocity();


		assertNotNull(result);
		assertEquals(1.142868048299083, result.doubleValue(), 0.1);
	}

	@Test
	public void testGetRelAverageVelocity_2()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team2);

		Double result = fixture.getRelAverageVelocity();

		assertNotNull(result);
		assertEquals(this.nan.doubleValue(), result.doubleValue(), 0.1);
	}

	@Test
	public void testGetRelAverageVelocity_3()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team3);

		Double result = fixture.getRelAverageVelocity();

		assertNotNull(result);
		assertEquals(this.nan.doubleValue(), result.doubleValue(), 0.1);
	}

	@Test
	public void testGetRelAverageVelocity_4()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team4);

		Double result = fixture.getRelAverageVelocity();


		assertNotNull(result);
		assertEquals(0.6929374201787996, result.doubleValue(), 0.1);
	}

//------------------ Test of the method getTeam()--------------------------//
	@Test
	public void testGetTeam_1()
		throws Exception {
		VelocityChartData fixture = new VelocityChartData(this.team1);

		ITeam result = fixture.getTeam();

		assertNotNull(result);
		assertEquals(this.team1,result);
		assertNotSame(this.team2, result);
		assertNotSame(this.team3, result);
		assertNotSame(this.team4, result);
	}

}