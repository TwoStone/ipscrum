package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Comparator;
import java.util.Vector;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.view.widgets.SprintTableView;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class RegularReleaseBurndownChart extends ReleaseBurndownChart {

	public RegularReleaseBurndownChart(IRelease release) {
		super(release);

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		GChart rbdChart = this.createChart();
		verticalPanel.add(rbdChart);

		SprintTableView sprintTable = new SprintTableView();
		sprintTable.refreshSprints(this.getSortedSprintList());
		verticalPanel.add(sprintTable);
	}

	private Vector<ISprint> getSortedSprintList() {
		Vector<ISprint> sortedSprints = new Vector<ISprint>();
		sortedSprints.addAll(this.getData().getRelease().getSprints());
		java.util.Collections.sort(sortedSprints, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});
		return sortedSprints;
	}
}
