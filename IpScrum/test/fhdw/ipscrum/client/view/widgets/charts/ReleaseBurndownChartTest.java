package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import org.junit.*;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import static org.junit.Assert.*;
import com.googlecode.gchart.client.GChart;


public class ReleaseBurndownChartTest extends SetUpTestData{
	/**
	 * Run the ReleaseBurndownChart(IRelease) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testReleaseBurndownChart_1()
		throws Exception {
		IRelease release = new Release("", new Date(), new Project(""));

		ReleaseBurndownChart result = new ReleaseBurndownChart(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		assertNotNull(result);
	}

	/**
	 * Run the ReleaseBurndownChart(IRelease,int,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testReleaseBurndownChart_2()
		throws Exception {
		IRelease release = new Release("", new Date(), new Project(""));
		int width = 1;
		int height = 1;

		ReleaseBurndownChart result = new ReleaseBurndownChart(release, width, height);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
		assertNotNull(result);
	}

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testCreateChart_1()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.createChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
	}

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testCreateChart_2()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.createChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
	}

	/**
	 * Run the ReleaseChartData getData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testGetData_1()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		ReleaseChartData result = fixture.getData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
		assertNotNull(result);
	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testPopulateChart_1()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testPopulateChart_2()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
	}

	/**
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Test
	public void testPopulateChart_3()
		throws Exception {
		ReleaseBurndownChart fixture = new ReleaseBurndownChart(new Release("", new Date(), new Project("")));
		fixture.burndownCurve = null;
		fixture.idealCurve = null;
		fixture.trendCurve = null;

		fixture.populateChart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 08.03.11 08:52
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

}