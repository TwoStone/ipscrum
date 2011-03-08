package fhdw.ipscrum.client.view.widgets.charts;

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
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		SprintChartData result = new SprintChartData(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
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
		SprintChartData fixture = new SprintChartData(new Sprint("", "", new Date(), new Date(), new Team("")));

		TreeMap<Date, SprintChartData.SprintChartDataDetails> result = fixture.getData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ISprint getSprint() method test.
	 */
	@Test
	public void testGetSprint_1()
		throws Exception {
		SprintChartData fixture = new SprintChartData(new Sprint("", "", new Date(), new Date(), new Team("")));

		ISprint result = fixture.getSprint();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
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
		SprintChartData fixture = new SprintChartData(new Sprint("", "", new Date(), new Date(), new Team("")));

		List<Double> result = fixture.getTickData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the List<Double> getTickData() method test.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetTickData_2()
		throws Exception {
		SprintChartData fixture = new SprintChartData(new Sprint("", "", new Date(), new Date(), new Team("")));

		List<Double> result = fixture.getTickData();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	
}