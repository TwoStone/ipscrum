package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class RegularReleaseBurndownChart extends ReleaseBurndownChart {

	public RegularReleaseBurndownChart(IRelease release) {
		super(release);

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		GChart rbdChart = this.createChart();
		verticalPanel.add(rbdChart);

		SprintTableView sprintTable = new SprintTableView();
		sprintTable.refreshSprints(this.release.getSprints());
		verticalPanel.add(sprintTable);
	}
}
