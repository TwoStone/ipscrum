package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This class represents a data container for Release Burndown-Charts. It also contains
 * calculation-algorithms to generate chart-data.
 */
public class ReleaseChartData {

	private final Release release;
	private final TreeMap<Date, ReleaseChartDataDetails> data;

	/**
	 * Constructor of the ReleaseChartData.
	 * 
	 * @param release
	 *            related to the chart
	 */
	public ReleaseChartData(final Release release) {
		this.release = release;
		this.data = new TreeMap<Date, ReleaseChartDataDetails>();
		this.calculateData();
	}

	/**
	 * Getter of the release related to the chart.
	 * 
	 * @return the related release
	 */
	public Release getRelease() {
		return this.release;
	}

	/**
	 * Getter of the data of every sprint end date in related to this release.
	 * 
	 * @return the data
	 */
	public SortedMap<Date, ReleaseChartDataDetails> getData() {
		return this.data;
	}

	/**
	 * This is the main chart-generation-algorithm.
	 */
	private void calculateData() {
		// obtain a sorted list of sprints associated with the release
		final ArrayList<Sprint> sortedSprints =
				new ArrayList<Sprint>(this.getRelease().getSprints());
		Collections.sort(sortedSprints, new Comparator<Sprint>() {
			@Override
			public int compare(final Sprint o1, final Sprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});

		// calculate actual burndown-data
		final int overallEfforts = this.getRelease().getOverallEfforts();
		Double runningBDValue = (double) overallEfforts;
		final Date today = new Date();

		for (final Sprint sprint : sortedSprints) {

			try {
				runningBDValue -=
						sprint.getCumulatedManDayCostsOfClosedPbis().getValue();
			} catch (final NoValidValueException e) {
				Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
			}

			if (this.data.containsKey(sprint.getEnd())) {
				final ReleaseChartDataDetails details = this.data.get(sprint.getEnd());
				details.getSprints().add(sprint);
				details.setActualBurndownValue(sprint.getEnd().before(today) ? runningBDValue
						: null);
				this.data.put(sprint.getEnd(), details);
			} else {
				final ReleaseChartDataDetails details =
						new ReleaseChartDataDetails(new ArrayList<Sprint>(), sprint
								.getEnd().before(today) ? runningBDValue : null);
				details.getSprints().add(sprint);
				this.data.put(sprint.getEnd(), details);
			}
		}

		// calculate ideal values
		final double idealBurndown = overallEfforts / (double) this.getData().size();
		double runningIdealValue = overallEfforts;
		for (final Date endDate : this.getData().keySet()) {
			final ReleaseChartDataDetails currentData = this.getData().get(endDate);
			runningIdealValue -= idealBurndown;
			currentData.setIdealBurndownValue(runningIdealValue);
		}
	}

	/**
	 * This class is used to hold the chart-values for one sprint-endDate.
	 */
	protected static class ReleaseChartDataDetails {
		private final ArrayList<Sprint> sprints;

		private Double actualBurndownValue;
		private Double idealBurndownValue;

		public ReleaseChartDataDetails(final ArrayList<Sprint> sprints,
				final Double actualBurndownValue) {
			this.sprints = sprints;
			this.actualBurndownValue = actualBurndownValue;
		}

		public ArrayList<Sprint> getSprints() {
			return this.sprints;
		}

		public Double getActualBurndownValue() {
			return this.actualBurndownValue;
		}

		void setActualBurndownValue(final Double value) {
			this.actualBurndownValue = value;
		}

		public Double getIdealBurndownValue() {
			return this.idealBurndownValue;
		}

		public void setIdealBurndownValue(final Double idealBurndownValue) {
			this.idealBurndownValue = idealBurndownValue;
		}
	}

	/**
	 * This is to obtain a list of data-points for the trend-calculation.
	 * 
	 * @return a list of data-points.
	 */
	public List<Double> getTickData() {
		final ArrayList<Double> result = new ArrayList<Double>();
		for (double i = 0; i < this.data.keySet().size(); i++) {
			result.add(i);
		}
		return result;
	}
}
