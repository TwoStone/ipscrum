package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.NumberLabel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.ProjectDisplayPresenter.IProjectDisplayView;
import fhdw.ipscrum.client.view.widgets.EditLabel;
import fhdw.ipscrum.client.view.widgets.ProductBacklogTable;
import fhdw.ipscrum.client.view.widgets.ReleaseTable;
import fhdw.ipscrum.client.view.widgets.SprintTable;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * represents the view to disply projects.
 */
public class ProjectDisplayView extends MasterView implements IProjectDisplayView {
	/**
	 * constructor of the ProjectDisplayView.
	 */
	public ProjectDisplayView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		this.add(verticalPanel);
		verticalPanel.setSize("600px", "441px");

		final HorizontalPanel upper = new HorizontalPanel();
		upper.setSpacing(5);
		verticalPanel.add(upper);
		upper.setWidth("100%");
		verticalPanel.setCellWidth(upper, "100%");

		final VerticalPanel upperLeft = new VerticalPanel();
		upper.add(upperLeft);

		this.nameLabel = new EditLabel();
		upperLeft.add(this.nameLabel);
		this.nameLabel.setStyleName("nameField");
		this.nameLabel.setText("name");

		final Grid grid = new Grid(2, 2);
		upperLeft.add(grid);
		grid.setCellPadding(5);

		final Label lblTickets = new Label("Tickets");
		grid.setWidget(0, 0, lblTickets);

		this.ticketCountLabel = new NumberLabel<Integer>();
		grid.setWidget(0, 1, this.ticketCountLabel);

		final Label lblSprints = new Label("Sprints");
		grid.setWidget(1, 0, lblSprints);

		this.sprintCountLabel = new NumberLabel<Integer>();
		grid.setWidget(1, 1, this.sprintCountLabel);
		this.nameLabel.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(final ValueChangeEvent<String> event) {
				ProjectDisplayView.this.changeNameEvent.fire(ProjectDisplayView.this,
						new TypedEventArg<String>(event.getValue()));
			}
		});

		final VerticalPanel upperRight = new VerticalPanel();
		upperRight.setSpacing(5);
		upperRight.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		upper.add(upperRight);
		upper.setCellHorizontalAlignment(upperRight, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button editSystemsButton = new Button("Systeme bearbeiten");
		editSystemsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.gotoSystemsEvent.fire(ProjectDisplayView.this);
			}
		});
		upperRight.add(editSystemsButton);

		final Button showHistoryButton = new Button("Projekthistorie");
		showHistoryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.gotoHistoryEvent.fire(ProjectDisplayView.this);
			}
		});
		upperRight.add(showHistoryButton);

		final HTML seperator = new HTML("<hr/>", true);
		verticalPanel.add(seperator);
		seperator.setHeight("10px");

		final DisclosurePanel backlogPanel = new DisclosurePanel("Product Backlog");
		verticalPanel.add(backlogPanel);
		backlogPanel.setWidth("100%");

		final VerticalPanel insideBacklogPanel = new VerticalPanel();
		backlogPanel.add(insideBacklogPanel);

		this.productBacklogTableAktive = new ProductBacklogTable();
		insideBacklogPanel.add(this.productBacklogTableAktive);
		this.productBacklogTableAktive.setWidth("564px");

		final Button btnEditBacklog = new Button("Backlog Bearbeiten");
		insideBacklogPanel.add(btnEditBacklog);
		btnEditBacklog.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.gotoProductBacklogEvent.fire(ProjectDisplayView.this);
			}
		});

		final DisclosurePanel sprintsPanel = new DisclosurePanel("Sprints");
		verticalPanel.add(sprintsPanel);
		sprintsPanel.setWidth("100%");

		final VerticalPanel insideSprintPanel = new VerticalPanel();
		sprintsPanel.add(insideSprintPanel);

		this.sprintTable = new SprintTable();

		// sprintDataProvider.addDataDisplay(sprintTable);

		insideSprintPanel.add(this.sprintTable);
		this.sprintTable.setWidth("564px");

		this.selModelSprintTable = new SingleSelectionModel<Sprint>();
		this.sprintTable.setSelectionModel(this.selModelSprintTable);

		final HorizontalPanel buttonPanel = new HorizontalPanel();
		insideSprintPanel.add(buttonPanel);

		this.bntNewSprint = new Button("Sprint erstellen");
		buttonPanel.add(this.bntNewSprint);
		this.bntNewSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.createSprint.fire(ProjectDisplayView.this);
			}
		});

		this.bntEditSprint = new Button("Sprint bearbeiten");
		buttonPanel.add(this.bntEditSprint);
		this.bntEditSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.editSprint.fire(ProjectDisplayView.this);

			}
		});

		this.bntRemoveSprint = new Button(TextConstants.DELETE_SPRINT);
		buttonPanel.add(this.bntRemoveSprint);
		this.bntRemoveSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.removeSprint.fire(ProjectDisplayView.this);
			}
		});

		final DisclosurePanel releasesPanel = new DisclosurePanel("Releases");
		verticalPanel.add(releasesPanel);
		releasesPanel.setWidth("100%");

		final VerticalPanel insideReleasePanel = new VerticalPanel();
		releasesPanel.add(insideReleasePanel);

		this.releaseTable = new ReleaseTable();
		insideReleasePanel.add(this.releaseTable);
		this.selModelReleaseTable = new SingleSelectionModel<Release>();
		this.releaseTable.setSelectionModel(this.selModelReleaseTable);

		final HorizontalPanel buttonPanelRelease = new HorizontalPanel();
		insideReleasePanel.add(buttonPanelRelease);

		this.bntNewRelease = new Button(TextConstants.CREATE_RELEASE);
		buttonPanelRelease.add(this.bntNewRelease);
		this.bntNewRelease.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.createRelease.fire(ProjectDisplayView.this);
			}
		});

		this.bntEditRelease = new Button("Release bearbeiten");
		buttonPanelRelease.add(this.bntEditRelease);
		this.bntEditRelease.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.editRelease.fire(ProjectDisplayView.this);
			}
		});

		this.bntRemoveRelease = new Button("Release entfernen");
		buttonPanelRelease.add(this.bntRemoveRelease);

		final Button btnRelBurndownchart = new Button("Burndown-Chart");
		btnRelBurndownchart.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.releaseBurndownChartEvent.fire(ProjectDisplayView.this,
						new TypedEventArg<Release>(ProjectDisplayView.this.getSelectedRelease()));
			}
		});
		buttonPanelRelease.add(btnRelBurndownchart);

		final Button btnSprintBurndownchart = new Button("Burndown-Chart");
		btnSprintBurndownchart.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.sprintBurndownChartEvent.fire(ProjectDisplayView.this,
						new TypedEventArg<Sprint>(ProjectDisplayView.this.getSelectedSprint()));
			}
		});
		buttonPanel.add(btnSprintBurndownchart);

		final Button btnTaskboard = new Button("Taskboard anzeigen");
		buttonPanel.add(btnTaskboard);
		btnTaskboard.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.gotoTaskboardEvent.fire(ProjectDisplayView.this, new TypedEventArg<Sprint>(
						ProjectDisplayView.this.getSelectedSprint()));
			}
		});
		this.bntRemoveRelease.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectDisplayView.this.removeRelease.fire(ProjectDisplayView.this);
			}
		});

	}

	private final Event<TypedEventArg<String>> changeNameEvent = new Event<TypedEventArg<String>>();
	private final DefaultEvent gotoSystemsEvent = new DefaultEvent();
	private final Event<TypedEventArg<Sprint>> gotoTaskboardEvent = new Event<TypedEventArg<Sprint>>();
	private final Event<TypedEventArg<Sprint>> sprintBurndownChartEvent = new Event<TypedEventArg<Sprint>>();
	private final Event<TypedEventArg<Release>> releaseBurndownChartEvent = new Event<TypedEventArg<Release>>();
	private final DefaultEvent gotoHistoryEvent = new DefaultEvent();
	private final DefaultEvent createSprint = new DefaultEvent();
	private final DefaultEvent createRelease = new DefaultEvent();
	private final DefaultEvent editSprint = new DefaultEvent();
	private final DefaultEvent editRelease = new DefaultEvent();
	private final DefaultEvent gotoProductBacklogEvent = new DefaultEvent();
	private final EditLabel nameLabel;
	private final NumberLabel<Integer> ticketCountLabel;
	private final NumberLabel<Integer> sprintCountLabel;
	private final DefaultEvent removeSprint = new DefaultEvent();
	private final DefaultEvent removeRelease = new DefaultEvent();

	private final SingleSelectionModel<Sprint> selModelSprintTable;

	private final ProductBacklogTable productBacklogTableAktive;
	private final SingleSelectionModel<Release> selModelReleaseTable;

	private final SprintTable sprintTable;
	private final ReleaseTable releaseTable;
	private final Button bntEditSprint;
	private final Button bntNewRelease;
	private final Button bntRemoveRelease;
	private final Button bntEditRelease;
	private final Button bntNewSprint;
	private final Button bntRemoveSprint;

	@Override
	public void close() {
		this.changeNameEvent.removeAllHandler();
		this.gotoSystemsEvent.removeAllHandler();
		this.gotoProductBacklogEvent.removeAllHandler();
		this.createSprint.removeAllHandler();
	}

	@Override
	public void setProject(final Project project) {
		this.nameLabel.setText(project.getName());
		this.ticketCountLabel.setValue(project.getBacklog().countItems());
		this.sprintCountLabel.setValue(project.countSprints());
		this.getProductBacklogTableAktive().setProductBacklog(project.getBacklog());
	}

	@Override
	public EventRegistration registerChangeNameHandler(final EventHandler<TypedEventArg<String>> handler) {
		return this.changeNameEvent.add(handler);
	}

	@Override
	public EventRegistration registerGotoSystems(final DefaultEventHandler handler) {
		return this.gotoSystemsEvent.add(handler);
	}

	@Override
	public EventRegistration registerGotoTaskboard(final EventHandler<TypedEventArg<Sprint>> handler) {
		return this.gotoTaskboardEvent.add(handler);
	}

	@Override
	public EventRegistration registerGotoHistory(final DefaultEventHandler handler) {
		return this.gotoHistoryEvent.add(handler);
	}

	@Override
	public EventRegistration removeSprint(final DefaultEventHandler handler) {
		return this.removeSprint.add(handler);
	}

	@Override
	public EventRegistration removeRelease(final DefaultEventHandler handler) {
		return this.removeRelease.add(handler);
	}

	@Override
	public EventRegistration registerGotoProdcutBacklog(final DefaultEventHandler handler) {
		return this.gotoProductBacklogEvent.add(handler);
	}

	@Override
	public EventRegistration registerCreateSprint(final DefaultEventHandler handler) {
		return this.createSprint.add(handler);
	}

	@Override
	public EventRegistration registerEditSprint(final DefaultEventHandler handler) {
		return this.editSprint.add(handler);
	}

	@Override
	public EventRegistration registerSprintBurndownChartEvent(final EventHandler<TypedEventArg<Sprint>> handler) {
		return this.sprintBurndownChartEvent.add(handler);
	}

	@Override
	public EventRegistration registerReleaseBurndownChartEvent(final EventHandler<TypedEventArg<Release>> handler) {
		return this.releaseBurndownChartEvent.add(handler);
	}

	@Override
	public EventRegistration registerEditRelease(final DefaultEventHandler handler) {
		return this.editRelease.add(handler);
	}

	@Override
	public EventRegistration registerCreateRelease(final DefaultEventHandler handler) {
		return this.createRelease.add(handler);
	}

	@Override
	public Sprint getSelectedSprint() {
		return this.selModelSprintTable.getSelectedObject();
	}

	@Override
	public Release getSelectedRelease() {
		return this.selModelReleaseTable.getSelectedObject();
	}

	@Override
	public void updateSprintTable(final List<Sprint> sprintList) {
		this.sprintTable.setRowData(sprintList);

	}

	@Override
	public void updateReleaseTable(final List<Release> releaseList) {
		this.releaseTable.setRowData(releaseList);
	}

	protected ProductBacklogTable getProductBacklogTableAktive() {
		return this.productBacklogTableAktive;
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBntEditRelease().setEnabled(value);
		this.getBntNewRelease().setEnabled(value);
		this.getBntRemoveRelease().setEnabled(value);
		this.getBntNewSprint().setEnabled(value);
		this.getBntEditSprint().setEnabled(value);
		this.getBntRemoveSprint().setEnabled(value);

	}

	protected Button getBntEditSprint() {
		return this.bntEditSprint;
	}

	protected Button getBntNewRelease() {
		return this.bntNewRelease;
	}

	protected Button getBntRemoveRelease() {
		return this.bntRemoveRelease;
	}

	protected Button getBntEditRelease() {
		return this.bntEditRelease;
	}

	protected Button getBntNewSprint() {
		return this.bntNewSprint;
	}

	protected Button getBntRemoveSprint() {
		return this.bntRemoveSprint;
	}
}
