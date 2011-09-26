package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * The class <code>SprintChartDataTest</code> contains tests for the class
 * <code>{@link SprintChartData}</code>.
 */
public class SprintChartDataTest extends SetUpTestData {

	/**
	 * Run the SprintChartData(Sprint) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSprintChartData1() throws Exception {
		final Sprint sprint = this.getPro1rel1spr1();

		final SprintChartData result = new SprintChartData(sprint);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Date, SprintChartData.SprintChartDataDetails> getData() method
	 * test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */

	@Test
	public void testGetData1() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr2());

		final SortedMap<Date, SprintChartData.SprintChartDataDetails> result =
				fixture.getData();

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Sprint getSprint() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSprint1() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr3());

		final Sprint result = fixture.getSprint();

		Assert.assertNotNull(result);
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData1() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr1());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(28, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData2() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData3() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr3());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData4() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr4());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(59, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData5() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel1spr5());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData6() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel2spr1());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData7() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel2spr2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(59, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData8() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel2spr3());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData9() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel2spr4());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData10() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro1rel2spr5());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(30, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData11() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel1spr1());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(89, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData12() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel1spr2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData13() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel1spr3());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(61, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData14() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel1spr4());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData15() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel1spr5());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData16() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel2spr1());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(30, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData17() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel2spr2());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(59, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData18() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel2spr3());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData19() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel2spr4());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTickData20() throws Exception {
		final SprintChartData fixture = new SprintChartData(this.getPro2rel2spr5());

		final List<Double> result = fixture.getTickData();

		Assert.assertNotNull(result);
		Assert.assertEquals(59, result.size());
	}
}
