package fhdw.ipscrum.client.view.widgets.charts;

import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * The class <code>SprintBurndownChartTest</code> contains tests for the class <code>{@link SprintBurndownChart}</code>.
 */
public class SprintBurndownChartTest extends SetUpTestData {

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testCreateChart_1()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro2rel1spr1);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.createChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testCreateChart_2()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro2rel1spr2);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.createChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testCreateChart_3()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro2rel1spr3);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.createChart();

		assertNotNull(fixture.burndownCurve);
		assertNotNull(fixture.idealCurve);
		assertNotNull(fixture.trendCurve);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testPopulateChart_1()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro1rel1spr1);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();
		System.out.println(fixture.burndownCurve.getXShift());


	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testPopulateChart_2()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro1rel1spr2);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testPopulateChart_3()
	throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(this.pro1rel1spr3);
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}
}