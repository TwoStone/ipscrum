package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This class represents a data container for Release Burndown-Charts.
 * It also contains calculation-algorithms to generate chart-data.
 */
public class ReleaseChartData implements ChartData {

	private final IRelease release;
	private final TreeMap<Date,ReleaseChartDataDetails> data;

	public ReleaseChartData(IRelease release) {
		this.release = release;
		this.data = new TreeMap<Date,ReleaseChartDataDetails>();
		this.calculateData();
	}

	public IRelease getRelease() {
		return this.release;
	}

	public TreeMap<Date, ReleaseChartDataDetails> getData() {
		return this.data;
	}

	/**
	 * This is the main chart-generation-algorithm.
	 */
	private void calculateData() {
		// obtain a sorted list of sprints associated with the release
		ArrayList<ISprint> sortedSprints = new ArrayList<ISprint>(this.getRelease().getSprints());
		Collections.sort(sortedSprints, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});


		// calculate actual burndown-data
		int overallEfforts = this.getRelease().getOverallEfforts();
		Double runningBDValue = (double) overallEfforts;
		Date today = new Date();

		for (ISprint sprint : sortedSprints) {

			runningBDValue -= sprint.getCumulatedManDayCostsOfClosedPbis();

			if (this.data.containsKey(sprint.getEnd())) {
				ReleaseChartDataDetails details = this.data.get(sprint.getEnd());
				details.getSprints().add(sprint);
				details.setActualBurndownValue((sprint.getEnd().before(today)) ? runningBDValue: null);
				this.data.put(sprint.getEnd(), details);
			} else {
				ReleaseChartDataDetails details = new ReleaseChartDataDetails(new ArrayList<ISprint>(), (sprint.getEnd().before(today)) ? runningBDValue: null);
				details.getSprints().add(sprint);
				this.data.put(sprint.getEnd(), details);
			}
		}

		// calculate ideal values
		double idealBurndown = (double) overallEfforts / (double) this.getData().size();
		double runningIdealValue = overallEfforts;
		for (Date endDate : this.getData().keySet()) {
			ReleaseChartDataDetails currentData = getData().get(endDate);
			runningIdealValue -= idealBurndown;
			currentData.setIdealBurndownValue(runningIdealValue);
		}
	}

	/**
	 *	This class is used to hold the chart-values for one sprint-endDate.
	 */
	class ReleaseChartDataDetails {
		private final ArrayList<ISprint> sprints;

		private Double actualBurndownValue;
		private Double idealBurndownValue;

		public ReleaseChartDataDetails(ArrayList<ISprint> sprints, Double actualBurndownValue) {
			this.sprints = sprints;
			this.actualBurndownValue = actualBurndownValue;
		}

		public ArrayList<ISprint> getSprints() {
			return this.sprints;
		}

		public Double getActualBurndownValue() {
			return this.actualBurndownValue;
		}

		void setActualBurndownValue(Double value) {
			this.actualBurndownValue = value;
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
	@Override
	public List<Double> getTickData() {
		ArrayList<Double> result = new ArrayList<Double>();
		double counter = 0;
		for (Date date : this.data.keySet()) {
			if (date.before(new Date())) {
				result.add(counter);
			}
			counter++;
		}
		return result;
	}
}
