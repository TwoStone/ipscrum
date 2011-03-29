package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This class represents a data container for Sprint Burndown-Charts.
 * It also contains calculation-algorithms to generate chart-data.
 */
public class SprintChartData implements ChartData {

	private final ISprint sprint;
	private final ArrayList<Date> daysInvolved;
	private final TreeMap<Date,SprintChartDataDetails> data;

	public SprintChartData(ISprint sprint) {
		this.sprint = sprint;
		this.data = new TreeMap<Date, SprintChartData.SprintChartDataDetails>();
		daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());

		//		this.calculateDemoData();
		this.calculateData();
	}

	/**
	 * This is the main chart-generation-algorithm.
	 */
	private void calculateData() {
		int dayCount = daysInvolved.size();
		Date today = new Date();
		double taskCount = this.sprint.getSprintBacklog().calculateOverallTaskEffort();

		int counter = 0;
		for (Date date : daysInvolved) {
			double ideal = taskCount / (dayCount-1) * (dayCount-1 - counter);
			if (date.before(today)) {
				this.data.put(date, new SprintChartDataDetails((double) this.sprint.getSprintBacklog().getEffortByDay(date), ideal));
			} else {
				this.data.put(date, new SprintChartDataDetails(ideal));
			}
			counter++;
		}

	}

	/**
	 * This is to generate demo-data.
	 */
	@SuppressWarnings("unused")
	private void calculateDemoData() {
		int dayCount = daysInvolved.size();
		Date today = new Date();
		int taskCount = (int) (Math.random() * 100 + 50);

		int counter = 0;
		for (Date date : daysInvolved) {
			double ideal = taskCount / (dayCount-1) * (dayCount-1 - counter);
			double deviation = Math.random() * 0.4 + 0.8;
			if (date.before(today)) {
				this.data.put(date, new SprintChartDataDetails(ideal*deviation, ideal));
			} else {
				this.data.put(date, new SprintChartDataDetails(ideal));
			}
			counter++;
		}
	}

	public ISprint getSprint() {
		return this.sprint;
	}

	public SortedMap<Date, SprintChartDataDetails> getData() {
		return this.data;
	}

	/**
	 *	This class is used to hold the chart-values for one day of a sprint.
	 */
	class SprintChartDataDetails {
		private final Double actualBurndownValue;
		private final Double idealBurndownValue;

		public SprintChartDataDetails(Double idealBurndownValue) {
			this(null,idealBurndownValue);
		}

		public SprintChartDataDetails(Double actualBurndownValue, Double idealBurndownValue) {
			this.actualBurndownValue = actualBurndownValue;
			this.idealBurndownValue = idealBurndownValue;
		}

		public Double getActualBurndownValue() {
			return this.actualBurndownValue;
		}

		public Double getIdealBurndownValue() {
			return this.idealBurndownValue;
		}
	}

	/**
	 * This is to obtain a list of data-points for the trend-calculation.
	 * @return a list of data-points.
	 */
	public List<Double> getTickData() {
		ArrayList<Double> result = new ArrayList<Double>();
		for (Date date : daysInvolved) {
			result.add((double) date.getTime());
		}
		return result;
	}
}
