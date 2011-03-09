package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

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
		System.out.println(this.pro1rel1);

		ReleaseChartData fixture = new ReleaseChartData(this.pro1rel1);

		TreeMap<Date, ReleaseChartData.ReleaseChartDataDetails> result = fixture.getData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(3, result.size());
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
		ReleaseChartData fixture = new ReleaseChartData(this.pro1rel2);

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_3()
	throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(this.pro2rel1);

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_4()
	throws Exception {
		ReleaseChartData fixture = new ReleaseChartData(this.pro2rel2);

		List<Double> result = fixture.getTickData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(3, result.size());
	}

}