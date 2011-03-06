package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This class represents a data container for Sprint Burndown-Charts.
 */
public class SprintChartData {

	private final ISprint sprint;
	private final TreeMap<Date,SprintChartDataDetails> data;


	public SprintChartData(ISprint sprint) {
		this.sprint = sprint;
		this.data = new TreeMap<Date, SprintChartData.SprintChartDataDetails>();
		this.calculateDemoData();
	}

	private void calculateDemoData() {
		ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());
		int dayCount = daysInvolved.size();
		Date today = new Date();
		int taskCount = (int) (Math.random() * 100 + 50);

		int counter = 0;
		for (Date date : daysInvolved) {
			int ideal = taskCount / (dayCount-1) * (dayCount-1 - counter);
			double deviation = Math.random() * 0.4 + 0.8;
			if (date.before(today)) {
				this.data.put(date, new SprintChartDataDetails(ideal*deviation, ideal));
			} else {
				this.data.put(date, new SprintChartDataDetails(Double.NaN, ideal));
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

	class SprintChartDataDetails {
		private double actualBurndownValue;
		private double idealBurndownValue;

		public SprintChartDataDetails(double actualBurndownValue, double idealBurndownValue) {
			this.actualBurndownValue = actualBurndownValue;
			this.idealBurndownValue = idealBurndownValue;
		}

		public double getActualBurndownValue() {
			return this.actualBurndownValue;
		}

		public void setActualBurndownValue(double actualBurndownValue) {
			this.actualBurndownValue = actualBurndownValue;
		}

		public double getIdealBurndownValue() {
			return this.idealBurndownValue;
		}

		public void setIdealBurndownValue(double idealBurndownValue) {
			this.idealBurndownValue = idealBurndownValue;
		}
	}
}
