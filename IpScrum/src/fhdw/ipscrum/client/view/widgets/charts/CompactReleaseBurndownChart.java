package fhdw.ipscrum.client.view.widgets.charts;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class CompactReleaseBurndownChart extends ReleaseBurndownChart {

	public CompactReleaseBurndownChart(IRelease release, int width, int height) {
		super(release);
		this.width = width;
		this.height = height;

		GChart rbdChart = this.createChart();
		initWidget(rbdChart);
	}
}
