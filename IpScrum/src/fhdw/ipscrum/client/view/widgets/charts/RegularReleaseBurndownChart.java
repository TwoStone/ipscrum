package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Comparator;
import java.util.Vector;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.widgets.SprintTableView;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This represents the regular version of the RBD-Chart with the sprint-table.
 */
public class RegularReleaseBurndownChart extends Composite {

	private final ReleaseBurndownChart chart;

	public RegularReleaseBurndownChart(IRelease release) {
		this.chart = new ReleaseBurndownChart(release);

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		verticalPanel.add(this.chart);

		SprintTableView sprintTable = new SprintTableView();
		sprintTable.refreshSprints(this.getSortedSprintList());
		verticalPanel.add(sprintTable);
	}

	/**
	 * This is too obtain a sorted list of sprints.
	 * @return a sorted list of sprints
	 */
	private Vector<ISprint> getSortedSprintList() {
		Vector<ISprint> sortedSprints = new Vector<ISprint>();
		sortedSprints.addAll(this.chart.getData().getRelease().getSprints());
		java.util.Collections.sort(sortedSprints, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});
		return sortedSprints;
	}
}
