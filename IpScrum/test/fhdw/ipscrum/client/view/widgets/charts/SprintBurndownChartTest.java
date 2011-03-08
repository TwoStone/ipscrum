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