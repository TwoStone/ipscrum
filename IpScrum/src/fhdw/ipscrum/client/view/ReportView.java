package fhdw.ipscrum.client.view;

import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.interfaces.IReportView;
import fhdw.ipscrum.client.view.widgets.charts.RegularReleaseBurndownChart;
import fhdw.ipscrum.client.view.widgets.charts.SprintBurndownChart;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * view class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */

public class ReportView extends Composite implements IReportView {
	private SingleSelectionModel<IRelease> releaseSelectionModel;
	private SingleSelectionModel<ISprint> sprintSelectionModel;
	private final SimplePanel contentPanel;

	public ReportView() {
		this.initSelectionModels();

		HorizontalPanel horizontalPanelLayout = new HorizontalPanel();
		horizontalPanelLayout.setSpacing(5);
		initWidget(horizontalPanelLayout);
		horizontalPanelLayout.setSize("900px", "610px");

		ScrollPanel scrollPanel = new ScrollPanel();
		horizontalPanelLayout.add(scrollPanel);
		scrollPanel.setSize("225px", "610px");

		DecoratedStackPanel decoratedStackPanel = new DecoratedStackPanel();
		scrollPanel.setWidget(decoratedStackPanel);
		decoratedStackPanel.setSize("100%", "100%");

		CellTree cellTreeReleases = new CellTree(new ReleaseSelectionTreeViewModel(releaseSelectionModel), null);
		decoratedStackPanel.add(cellTreeReleases, TextConstants.CHART_RELEASESTACK_TITLE, false);
		cellTreeReleases.setSize("100%", "100%");
		cellTreeReleases.setAnimationEnabled(true);

		CellTree cellTreeSprints = new CellTree(new SprintSelectionTreeViewModel(sprintSelectionModel), null);
		cellTreeSprints.setAnimationEnabled(true);
		decoratedStackPanel.add(cellTreeSprints, TextConstants.CHART_SPRINTSTACK_TITLE, false);
		decoratedStackPanel.showStack(1);
		cellTreeSprints.setSize("100%", "100%");

		contentPanel = new SimplePanel();
		horizontalPanelLayout.add(contentPanel);
		horizontalPanelLayout.setCellHorizontalAlignment(contentPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		HTML htmlLabel = new HTML(TextConstants.CHART_USAGETIP, true);
		contentPanel.setWidget(htmlLabel);
		htmlLabel.setSize("100%", "100%");

	}

	private void initSelectionModels() {
		this.releaseSelectionModel = new SingleSelectionModel<IRelease>();
		this.releaseSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new RegularReleaseBurndownChart(releaseSelectionModel.getSelectedObject()));
			}
		});

		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new SprintBurndownChart(sprintSelectionModel.getSelectedObject()));
			}
		});
	}
}
