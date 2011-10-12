package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.datepicker.client.CalendarUtil;

import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This class represents a data container for Velocity-Charts. It also contains calculation-algorithms to generate
 * chart-data.
 */
public class VelocityChartData {

	private final Team team;
	private final TreeMap<Sprint, VelocityChartDataDetails> data;
	private Double absAverageVelocity;
	private Double relAverageVelocity;

	/**
	 * Constructor of the VelocityChartData.
	 * 
	 * @param team
	 *            to show the velocity of
	 */
	public VelocityChartData(final Team team) {
		this.team = team;
		this.data = new TreeMap<Sprint, VelocityChartData.VelocityChartDataDetails>(new Comparator<Sprint>() {
			@Override
			public int compare(final Sprint o1, final Sprint o2) {
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
		final Vector<Sprint> tempList = this.team.getSprints();

		for (final Sprint sprint : tempList) {
			double currentAbsoluteValue = 0;
			double currentRelativeValue = 0;
			try {
				currentRelativeValue = this.calculateRelativeVelocity(sprint);
				currentAbsoluteValue = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
			} catch (final NoValidValueException e) {
				Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
			}
			this.data.put(sprint, new VelocityChartDataDetails(currentAbsoluteValue, currentRelativeValue));
		}
	}

	/**
	 * This method is used to set the average values for the chart.
	 */
	private void calculateAverages() {
		final Vector<Sprint> sprintList = this.team.getSprints();
		if (sprintList.size() < 2) {
			this.absAverageVelocity = Double.NaN;
			this.relAverageVelocity = Double.NaN;
		}
		double resultAbs = 0d;
		double resultRel = 0d;
		for (final Sprint sprint : sprintList) {
			try {
				resultAbs += sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
				resultRel += this.calculateRelativeVelocity(sprint);
			} catch (final NoValidValueException e) {
				Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
			}
		}
		this.absAverageVelocity = resultAbs / sprintList.size();
		this.relAverageVelocity = resultRel / sprintList.size();
	}

	/**
	 * Getter of the team of the chart.
	 * 
	 * @return the related team
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * Getter of the data of the team attached to a sprint, sorted by the sprints.
	 * 
	 * @return the data
	 */
	public SortedMap<Sprint, VelocityChartDataDetails> getData() {
		return this.data;
	}

	/**
	 * Getter of the average of the absolute velocity.
	 * 
	 * @return the average of the absolute velocity
	 */
	public Double getAbsAverageVelocity() {
		return this.absAverageVelocity;
	}

	/**
	 * Getter of the average of the relative velocity.
	 * 
	 * @return the average of the relative velocity
	 */
	public Double getRelAverageVelocity() {
		return this.relAverageVelocity;
	}

	/**
	 * This is used to obtain the relative velocity (efforts/sprintlength) of a sprint/team.
	 * 
	 * @param sprint
	 *            the sprint to be processed
	 * @return a chart-value (double)
	 */
	double calculateRelativeVelocity(final Sprint sprint) {
		double effort = 0;
		final double tempVar = CalendarUtil.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		try {
			effort = sprint.getCumulatedManDayCostsOfClosedFeatures().getValue();
		} catch (final NoValidValueException e) {
			Logger.getLogger("ErrorLogger").log(Level.WARNING, e.getMessage());
		}
		final double sprintLength = tempVar < 1 ? 1 : tempVar;
		return effort / sprintLength;
	}

	/**
	 * This class is used to hold the chart-values for one sprint-entry.
	 */
	public static class VelocityChartDataDetails {

		private final Double absoluteVelocity;
		private final Double relativeVelocity;

		/**
		 * Constructor of the VelocityChartDataDetails.
		 * 
		 * @param absVelocity
		 *            is the absolute velocity of the team
		 * @param relVelocity
		 *            is the relative velocity of the team
		 */
		public VelocityChartDataDetails(final Double absVelocity, final Double relVelocity) {
			this.absoluteVelocity = absVelocity;
			this.relativeVelocity = relVelocity;
		}

		/**
		 * Getter of the absolute velocity.
		 * 
		 * @return the absolute velocity
		 */
		public Double getAbsoluteVelocity() {
			return this.absoluteVelocity;
		}

		/**
		 * Getter of the relative velocity.
		 * 
		 * @return the relative velocity
		 */
		public Double getRelativeVelocity() {
			return this.relativeVelocity;
		}
	}
}
