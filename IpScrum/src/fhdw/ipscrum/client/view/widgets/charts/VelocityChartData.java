package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class VelocityChartData implements ChartData {

	ITeam team;
	ArrayList<ISprint> sprints;
	Double averageVelocity;
	Double worstAverageVelocity;


	public Double getWorstAverageVelocity() {
		return worstAverageVelocity;
	}

	public VelocityChartData(ITeam team) {
		this.team = team;
		this.sprints = createSprintList();
		this.averageVelocity = this.calculateAverageVelocity(this.sprints);
		this.worstAverageVelocity = this.calculateWorstAverageVelocity();
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

	private Double calculateAverageVelocity(List<ISprint> sprintList) {
		if (sprintList.size()<2) {
			return Double.NaN;
		}
		double result = 0d;
		for (ISprint sprint : sprintList) {
			result += sprint.getCumulatedManDayCostsOfClosedPbis();
		}
		return result / sprintList.size();
	}

	private Double calculateWorstAverageVelocity() {
		if (this.sprints.size()<4) {
			return Double.NaN;
		}
		ArrayList<ISprint> tempSprintList = new ArrayList<ISprint>();
		tempSprintList.addAll(this.sprints);
		Collections.sort(tempSprintList, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				Integer val1 = o1.getCumulatedManDayCostsOfClosedPbis();
				Integer val2 = o2.getCumulatedManDayCostsOfClosedPbis();
				return val1.compareTo(val2);
			}
		});

		return this.calculateAverageVelocity(tempSprintList.subList(0, 3));
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

	public Double getAverageVelocity() {
		return averageVelocity;
	}

}
