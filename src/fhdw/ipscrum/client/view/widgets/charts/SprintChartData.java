package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * This class represents a data container for Sprint Burndown-Charts. It also contains calculation-algorithms to
 * generate chart-data.
 */
public class SprintChartData {

	private final Sprint sprint;
	private final ArrayList<Date> daysInvolved;
	private final TreeMap<Date, SprintChartDataDetails> data;

	/**
	 * Constructor of the SprintChartData.
	 * 
	 * @param sprint
	 *            related to the chart
	 */
	public SprintChartData(final Sprint sprint) {
		this.sprint = sprint;
		this.data = new TreeMap<Date, SprintChartData.SprintChartDataDetails>();
		this.daysInvolved =
				CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());

		// this.calculateDemoData();
		this.calculateData();
	}

	/**
	 * This is the main chart-generation-algorithm.
	 */
	private void calculateData() {
		final int dayCount = this.daysInvolved.size();
		final Date today = new Date();
		final double taskCount = this.sprint.getSprintBacklog().calculateOverallTaskEffort();

		int counter = 0;
		for (final Date date : this.daysInvolved) {
			final double ideal = taskCount / (dayCount - 1) * (dayCount - 1 - counter);
			if (date.before(today)) {
				this.data
						.put(date,
								new SprintChartDataDetails(
										(double) this.sprint.getSprintBacklog().getEffortByDay(date), ideal));
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
		final int dayCount = this.daysInvolved.size();
		final Date today = new Date();
		final int taskCount = (int) (Math.random() * 100 + 50);

		int counter = 0;
		for (final Date date : this.daysInvolved) {
			final double ideal = taskCount / (dayCount - 1) * (dayCount - 1 - counter);
			final double deviation = Math.random() * 0.4 + 0.8;
			if (date.before(today)) {
				this.data.put(date, new SprintChartDataDetails(ideal * deviation, ideal));
			} else {
				this.data.put(date, new SprintChartDataDetails(ideal));
			}
			counter++;
		}
	}

	/**
	 * Getter of the Sprint related to the Data and the Chart.
	 * 
	 * @return the related sprint
	 */
	public Sprint getSprint() {
		return this.sprint;
	}

	/**
	 * Getter of the data related to every date of the sprint.
	 * 
	 * @return the data related to the day of the sprint
	 */
	public SortedMap<Date, SprintChartDataDetails> getData() {
		return this.data;
	}

	/**
	 * This class is used to hold the chart-values for one day of a sprint.
	 */
	protected static class SprintChartDataDetails {
		private final Double actualBurndownValue;
		private final Double idealBurndownValue;

		public SprintChartDataDetails(final Double idealBurndownValue) {
			this(null, idealBurndownValue);
		}

		public SprintChartDataDetails(final Double actualBurndownValue, final Double idealBurndownValue) {
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
	 * 
	 * @return a list of data-points.
	 */
	public List<Double> getTickData() {
		final ArrayList<Double> result = new ArrayList<Double>();
		for (final Date date : this.daysInvolved) {
			result.add((double) date.getTime());
		}
		return result;
	}
}
