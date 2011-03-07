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
		int runningBDValue = overallEfforts;
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


	class ReleaseChartDataDetails {
		private final ArrayList<ISprint> sprints;

		private Integer actualBurndownValue;
		private double idealBurndownValue;

		public ReleaseChartDataDetails(ArrayList<ISprint> sprints, Integer actualBurndownValue) {
			this.sprints = sprints;
			this.actualBurndownValue = actualBurndownValue;
		}

		public ArrayList<ISprint> getSprints() {
			return this.sprints;
		}

		public Integer getActualBurndownValue() {
			return this.actualBurndownValue;
		}

		void setActualBurndownValue(Integer value) {
			this.actualBurndownValue = value;
		}

		public double getIdealBurndownValue() {
			return this.idealBurndownValue;
		}

		public void setIdealBurndownValue(double idealBurndownValue) {
			this.idealBurndownValue = idealBurndownValue;
		}
	}


	@Override
	public List<Double> getConsiderableDatapoints() {
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
