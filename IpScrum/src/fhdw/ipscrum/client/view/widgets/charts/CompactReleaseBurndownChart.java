package fhdw.ipscrum.client.view.widgets.charts;

import com.google.gwt.user.client.ui.Composite;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * This represents a compact version of the RBD-Chart without the sprint-table.
 */
public class CompactReleaseBurndownChart extends Composite {

	private final ReleaseBurndownChart chart;

	public CompactReleaseBurndownChart(IRelease release, int width, int height) {
		this.chart = new ReleaseBurndownChart(release, width, height);
		initWidget(this.chart);
	}
}
