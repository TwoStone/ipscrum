package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import org.junit.*;
import fhdw.ipscrum.shared.model.Release;
import static org.junit.Assert.*;

/**
 * The class <code>ReleaseChartDataTest</code> contains tests for the class <code>{@link ReleaseChartData}</code>.
 */
public class ReleaseChartDataTest extends SetUpTestData{
	/**
	 * Run the ReleaseChartData(IRelease) constructor test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testReleaseChartData_1()
		throws Exception {
		IRelease release = new Release("", new Date(), new Project(""));

		ReleaseChartData result = new ReleaseChartData(release);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Date, ReleaseChartData.ReleaseChartDataDetails> getData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetData_1()
		throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(new Release("", new Date(), new Project("")));

		TreeMap<Date, ReleaseChartData.ReleaseChartDataDetails> result = fixture.getData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetRelease_1()
		throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(new Release("", new Date(), new Project("")));

		IRelease result = fixture.getRelease();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getOverallEfforts());
		assertEquals(new Integer(0), result.countSprints());
		assertEquals("", result.getVersion());
		assertEquals(-72928471, result.indirectHashCode());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_1()
		throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(new Release("", new Date(), new Project("")));

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_2()
		throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(new Release("", new Date(), new Project("")));

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_3()
		throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(new Release("", new Date(), new Project("")));

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
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
	 *
	 * @generatedBy CodePro at 08.03.11 09:07
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

}