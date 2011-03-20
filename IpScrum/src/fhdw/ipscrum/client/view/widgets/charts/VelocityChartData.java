package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class VelocityChartData implements ChartData {

	ITeam team;
	ArrayList<ISprint> sprints;
	Double absAverageVelocity;
	Double relAverageVelocity;

	public VelocityChartData(ITeam team) {
		this.team = team;
		this.sprints = createSprintList();
		this.calculateAverages(this.sprints);
	}


	private ArrayList<ISprint> createSprintList() {
		ArrayList<ISprint> tempSprintList = new ArrayList<ISprint>();
		tempSprintList.addAll(team.getSprints());
		Collections.sort(tempSprintList, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});
		return tempSprintList;
	}

	private void calculateAverages(List<ISprint> sprintList) {
		if (sprintList.size()<2) {
			this.absAverageVelocity = Double.NaN;
			this.relAverageVelocity = Double.NaN;
		}
		double resultAbs = 0d;
		double resultRel = 0d;
		for (ISprint sprint : sprintList) {
			resultAbs += sprint.getCumulatedManDayCostsOfClosedPbis();
			resultRel += VelocityChartData.calculateRelativeVelocity(sprint);
		}
		this.absAverageVelocity = resultAbs / sprintList.size();
		this.relAverageVelocity = resultRel / sprintList.size();
	}

	@Override
	public List<Double> getTickData() {
		ArrayList<Double> result = new ArrayList<Double>();
		for (ISprint sprint : this.sprints) {
			result.add((double) sprint.getEnd().getTime());
		}
		return result;
	}

	public ITeam getTeam() {
		return team;
	}

	public ArrayList<ISprint> getSprints() {
		return sprints;
	}

	public Double getAbsAverageVelocity() {
		return absAverageVelocity;
	}

	public Double getRelAverageVelocity() {
		return relAverageVelocity;
	}


	/**
	 * This is used to obtain the relative velocity (efforts/sprintlength) of a sprint/team.
	 * @param sprint the sprint to be processed
	 * @return a chart-value (double)
	 */
	public static double calculateRelativeVelocity(ISprint sprint) {
		double effort = sprint.getCumulatedManDayCostsOfClosedPbis();
		double sprintLength = CalendarUtils.getDaysBetween(sprint.getBegin(), sprint.getEnd());
		return effort/sprintLength; // TODO check possible zero-division problem
	}

}
