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
import fhdw.ipscrum.client.view.widgets.charts.VelocityChart;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


/**
 * view class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */

public class ReportView extends Composite implements IReportView {
	private SingleSelectionModel<Project> projectSelectionModel;
	private SingleSelectionModel<IRelease> releaseSelectionModel;
	private SingleSelectionModel<ISprint> sprintSelectionModel;
	private SingleSelectionModel<ITeam> teamSelectionModel;
	private final SimplePanel contentPanel;

	/**
	 * Constructor of the class.
	 */
	public ReportView() { // TODO replace celltrees with cellists for projects and teams
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

		CellTree cellTreeProjects = new CellTree(new ProjectSelectionTreeViewModel(projectSelectionModel), null);
		decoratedStackPanel.add(cellTreeProjects, TextConstants.CHART_PROJECTSTACK_TITLE, false);
		cellTreeProjects.setAnimationEnabled(true);
		cellTreeProjects.setSize("100%", "100%");

		CellTree cellTreeReleases = new CellTree(new ReleaseSelectionTreeViewModel(releaseSelectionModel), null);
		decoratedStackPanel.add(cellTreeReleases, TextConstants.CHART_RELEASESTACK_TITLE, false);
		cellTreeReleases.setAnimationEnabled(true);
		cellTreeReleases.setSize("100%", "100%");

		CellTree cellTreeSprints = new CellTree(new SprintSelectionTreeViewModel(sprintSelectionModel), null);
		decoratedStackPanel.add(cellTreeSprints, TextConstants.CHART_SPRINTSTACK_TITLE, false);
		cellTreeSprints.setAnimationEnabled(true);
		cellTreeSprints.setSize("100%", "100%");

		CellTree cellTreeTeams = new CellTree(new TeamSelectionTreeViewModel(teamSelectionModel), null);
		decoratedStackPanel.add(cellTreeTeams, TextConstants.CHART_TEAMSTACK_TITLE, false);
		decoratedStackPanel.showStack(3);
		cellTreeTeams.setAnimationEnabled(true);
		cellTreeTeams.setSize("100%", "100%");

		contentPanel = new SimplePanel();
		horizontalPanelLayout.add(contentPanel);
		horizontalPanelLayout.setCellHorizontalAlignment(contentPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		HTML htmlLabel = new HTML(TextConstants.CHART_USAGETIP, true);
		contentPanel.setWidget(htmlLabel);
		htmlLabel.setSize("100%", "100%");

	}

	/**
	 * this is to initialize the selection-models.
	 * it defines what happens when the user changes the selection of the cell-trees.
	 */
	private void initSelectionModels() {
		// Projects
		this.projectSelectionModel = new SingleSelectionModel<Project>();
		this.projectSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new HTML("<h1>Projekthistorie zu " + projectSelectionModel.getSelectedObject().getName() + "<br />(noch) nicht verfügbar.</h1>"));
			}
		});

		// Releases
		this.releaseSelectionModel = new SingleSelectionModel<IRelease>();
		this.releaseSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new RegularReleaseBurndownChart(releaseSelectionModel.getSelectedObject()));
			}
		});

		// Sprints
		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new SprintBurndownChart(sprintSelectionModel.getSelectedObject()));
			}
		});

		// Teams
		this.teamSelectionModel = new SingleSelectionModel<ITeam>();
		this.teamSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.contentPanel.clear();
				ReportView.this.contentPanel.setWidget(new VelocityChart(teamSelectionModel.getSelectedObject()));
			}
		});
	}
}
