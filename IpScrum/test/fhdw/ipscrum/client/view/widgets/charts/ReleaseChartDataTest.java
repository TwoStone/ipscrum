package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * The class <code>ReleaseChartDataTest</code> contains tests for the class
 * <code>{@link ReleaseChartData}</code>.
 */
public class ReleaseChartDataTest extends SetUpTestData {
	/**
	 * Run the ReleaseChartData(IRelease) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testReleaseChartData1() throws Exception {
		final Release release =
				new Release(this.getModel(), "", new Date(), new Project(this.getModel(), "blaa"));

		final ReleaseChartData result = new ReleaseChartData(release);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Date, ReleaseChartData.ReleaseChartDataDetails> getData() method
	 * test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetData1() throws Exception {
		System.out.println(this.getPro1rel1());

		final ReleaseChartData fixture = new ReleaseChartData(this.getPro1rel1());

		final SortedMap<Date, ReleaseChartData.ReleaseChartDataDetails> result =
				fixture.getData();

		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData1() throws Exception {
		final ReleaseChartData fixture =
				new ReleaseChartData(new Release(this.getModel(), "", new Date(),
						new Project(this.getModel(), "blaa")));

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails.
	 */
	@Test
	public void testGetTickData2() throws Exception {
		final ReleaseChartData fixture = new ReleaseChartData(this.getPro1rel2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData3() throws Exception {
		final ReleaseChartData fixture = new ReleaseChartData(this.getPro2rel1());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData4() throws Exception {
		final ReleaseChartData fixture = new ReleaseChartData(this.getPro2rel2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
	}
}
