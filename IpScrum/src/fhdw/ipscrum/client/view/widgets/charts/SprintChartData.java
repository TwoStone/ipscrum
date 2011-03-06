package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;


/**
 * This class represents a data container for Sprint Burndown-Charts.
 * It also contains calculation-algorithms to generate chart-data.
 */
public class SprintChartData {

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
		double taskCount = this.calculateOverallTaskEffort();

		int counter = 0;
		for (Date date : daysInvolved) {
			double ideal = taskCount / (dayCount-1) * (dayCount-1 - counter);
			if (date.before(today)) {
				this.data.put(date, new SprintChartDataDetails((double) this.getEffortByDay(date), ideal));
			} else {
				this.data.put(date, new SprintChartDataDetails(ideal));
			}
			counter++;
		}

	}

	/**
	 * This is used to calculate the individual data-points per day.
	 * @param date the day to calculate the data-point for
	 * @return the amount of effort that is left for this day.
	 */
	private int getEffortByDay(Date date) {
		int result = this.calculateOverallTaskEffort();
		Iterator<ITask> i = this.sprint.getSprintBacklog().taskIterator();
		while (i.hasNext()) {
			ITask current = i.next();
			if (current.isFinished() && (current.getFinishDate().before(date) || current.getFinishDate().equals(date))) {
				result -= current.getPlanEffort();
			}
		}
		return result;
	}

	/**
	 * This is to obtain a sum of all efforts of tasks that are connected to the sprint.
	 * @return sum of task-efforts.
	 */
	private int calculateOverallTaskEffort() {
		int result = 0;
		Iterator<ITask> i = this.sprint.getSprintBacklog().taskIterator();
		while (i.hasNext()) {
			ITask current = i.next();
			result += current.getPlanEffort();
		}
		return result;
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

	public TreeMap<Date, SprintChartDataDetails> getData() {
		return this.data;
	}

	/**
	 *	This class is used to hold the chart-values for one day of a sprint.
	 */
	class SprintChartDataDetails {
		private Double actualBurndownValue;
		private Double idealBurndownValue;

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

		public void setActualBurndownValue(Double actualBurndownValue) {
			this.actualBurndownValue = actualBurndownValue;
		}

		public Double getIdealBurndownValue() {
			return this.idealBurndownValue;
		}

		public void setIdealBurndownValue(Double idealBurndownValue) {
			this.idealBurndownValue = idealBurndownValue;
		}
	}

	/**
	 * This is to obtain a list of data-points for the trend-calculation.
	 * @return a list of data-points.
	 */
	public List<Double> getConsiderableDatapoints() {
		ArrayList<Double> result = new ArrayList<Double>();
		for (Date date : daysInvolved) {
			result.add((double) date.getTime());
		}
		return result;
	}
}
