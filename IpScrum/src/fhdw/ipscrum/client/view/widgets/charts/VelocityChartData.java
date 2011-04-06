package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


/**
 * This class represents a data container for Velocity-Charts.
 * It also contains calculation-algorithms to generate chart-data.
 */
public class VelocityChartData implements ChartData {


	private final ITeam team;
	private final TreeMap<ISprint, VelocityChartDataDetails> data;
	private Double absAverageVelocity;
	private Double relAverageVelocity;

	public VelocityChartData(ITeam team) {
		this.team = team;
		this.data = new TreeMap<ISprint, VelocityChartData.VelocityChartDataDetails>(new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});

		this.initChartData();
		this.calculateAverages();
	}

	/**
	 * This method is called once to set up the main chart-data.
	 */
	private void initChartData() {
		Vector<ISprint> tempList = this.team.getSprints();

		for (ISprint sprint : tempList) {
			double currentAbsoluteValue = 0;
			double currentRelativeValue = 0;
			try {
				currentRelativeValue = calculateRelativeVelocity(sprint);
				currentAbsoluteValue = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
			} catch (NoValidValueException e) {
				Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
			}
			this.data.put(sprint, new VelocityChartDataDetails(currentAbsoluteValue, currentRelativeValue));
		}
	}

	/**
	 * This method is used to set the average values for the chart.
	 */
	 private void calculateAverages() {
		Vector<ISprint> sprintList = this.team.getSprints();
		if (sprintList.size()<2) {
			this.absAverageVelocity = Double.NaN;
			this.relAverageVelocity = Double.NaN;
		}
		double resultAbs = 0d;
		double resultRel = 0d;
		for (ISprint sprint : sprintList) {
			try {
				resultAbs += sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
				resultRel += this.calculateRelativeVelocity(sprint);
			} catch (NoValidValueException e) {
				Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
			}
		}
		this.absAverageVelocity = resultAbs / sprintList.size();
		this.relAverageVelocity = resultRel / sprintList.size();
	}

	public ITeam getTeam() {
		return this.team;
	}

	public SortedMap<ISprint, VelocityChartDataDetails> getData() {
		return this.data;
	}

	public Double getAbsAverageVelocity() {
		return this.absAverageVelocity;
	}

	public Double getRelAverageVelocity() {
		return this.relAverageVelocity;
	}


	/**
	 * This is used to obtain the relative velocity (efforts/sprintlength) of a sprint/team.
	 * @param sprint the sprint to be processed
	 * @return a chart-value (double)
	 */
	 double calculateRelativeVelocity(ISprint sprint) {
		double effort = 0;
		double tempVar = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		try {
			effort = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
		} catch (NoValidValueException e) {
			Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
		}
		double sprintLength = (tempVar < 1) ? 1 : tempVar;
		return effort/sprintLength;
	}

	/**
	 *	This class is used to hold the chart-values for one sprint-entry.
	 */
	public class VelocityChartDataDetails {

		private final Double absoluteVelocity;
		private final Double relativeVelocity;

		public VelocityChartDataDetails(Double absVelocity, Double relVelocity) {
			this.absoluteVelocity = absVelocity;
			this.relativeVelocity = relVelocity;
		}

		public Double getAbsoluteVelocity() {
			return this.absoluteVelocity;
		}

		public Double getRelativeVelocity() {
			return this.relativeVelocity;
		}
	}
}
