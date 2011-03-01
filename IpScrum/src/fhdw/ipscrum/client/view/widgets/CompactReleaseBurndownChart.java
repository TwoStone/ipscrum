package fhdw.ipscrum.client.view.widgets;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class CompactReleaseBurndownChart extends ReleaseBurndownChart {

	public CompactReleaseBurndownChart(IRelease release, int width, int height) {
		super(release);
		this.width = width;
		this.height = height;
		this.createChart();
	}
}
