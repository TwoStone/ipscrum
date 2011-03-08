package fhdw.ipscrum.client.view.widgets.charts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.lang.System;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * The class <code>SprintChartDataTest</code> contains tests for the class <code>{@link SprintChartData}</code>.

 */
public class SprintChartDataTest extends SetUpTestData{
	
	
	/**
	 * Run the SprintChartData(ISprint) constructor test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSprintChartData_1()
		throws Exception {
		ISprint sprint = this.pro1rel1spr1;

		SprintChartData result = new SprintChartData(sprint);
		assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Date, SprintChartData.SprintChartDataDetails> getData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetData_1()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr2);

		TreeMap<Date, SprintChartData.SprintChartDataDetails> result = fixture.getData();

		assertNotNull(result);
	}

	/**
	 * Run the ISprint getSprint() method test.
	 */
	@Test
	public void testGetSprint_1()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr3);

		ISprint result = fixture.getSprint();

		assertNotNull(result);
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_1()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr1);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(28, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_2()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr2);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_3()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr3);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_4()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr4);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(59, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_5()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel1spr5);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_6()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel2spr1);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_7()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel2spr2);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(59, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_8()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel2spr3);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_9()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel2spr4);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_10()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro1rel2spr5);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(30, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_11()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel1spr1);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(89, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_12()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel1spr2);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_13()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel1spr3);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(61, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_14()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel1spr4);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_15()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel1spr5);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_16()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel2spr1);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(30, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_17()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel2spr2);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(59, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_18()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel2spr3);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_19()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel2spr4);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(31, result.size());
	}
	
	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_20()
		throws Exception {
		SprintChartData fixture = new SprintChartData(this.pro2rel2spr5);

		List<Double> result = fixture.getTickData();

		assertNotNull(result);
		assertEquals(59, result.size());
	}
}
