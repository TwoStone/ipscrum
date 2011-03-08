package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import org.junit.*;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import static org.junit.Assert.*;
import com.googlecode.gchart.client.GChart;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * The class <code>SprintBurndownChartTest</code> contains tests for the class <code>{@link SprintBurndownChart}</code>.
 */
public class SprintBurndownChartTest extends SetUpTestData {
	/**
	 * Run the SprintBurndownChart(ISprint) constructor test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSprintBurndownChart_1()
		throws Exception {
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		SprintBurndownChart result = new SprintBurndownChart(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the SprintBurndownChart(ISprint,int,int) constructor test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSprintBurndownChart_2()
		throws Exception {
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));
		int width = 1;
		int height = 1;

		SprintBurndownChart result = new SprintBurndownChart(sprint, width, height);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the void createChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testCreateChart_1()
		throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
	 * Run the void populateChart() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testPopulateChart_1()
		throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
	public void testPopulateChart_2()
		throws Exception {
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
		SprintBurndownChart fixture = new SprintBurndownChart(new Sprint("", "", new Date(), new Date(), new Team("")));
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
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
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
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}
}