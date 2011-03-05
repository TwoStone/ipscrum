package fhdw.ipscrum.client.view.widgets.charts;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * This represents a compact version of the RBD-Chart without the sprint-table.
 */
public class CompactReleaseBurndownChart extends ReleaseBurndownChart {

	public CompactReleaseBurndownChart(IRelease release, int width, int height) {
		super(release, width, height);

		GChart rbdChart = this.createChart();
		initWidget(rbdChart);
	}
}
