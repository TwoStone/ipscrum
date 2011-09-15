package fhdw.ipscrum.client.view.widgets.charts;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * This represents the regular version of the RBD-Chart with the sprint-table.
 */
public class RegularReleaseBurndownChart extends Composite {

	private final ReleaseBurndownChart chart;

	public RegularReleaseBurndownChart(final Release release) {
		this.chart = new ReleaseBurndownChart(release);

		final VerticalPanel verticalPanel = new VerticalPanel();
		this.initWidget(verticalPanel);

		verticalPanel.add(this.chart);
	}

}
