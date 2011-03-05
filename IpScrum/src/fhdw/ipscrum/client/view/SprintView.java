package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.client.view.widgets.SprintTableView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This view class is used to represent sprints.
 * 
 * @author Phase II / Gruppe I
 */
public class SprintView extends Composite implements ISprintView {

	public static IView createView() {
		return new SprintView();
	}

	// ########## Events #############
	private final Event<EventArgs> newSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> detailsSelectedSprintEvent = new Event<SprintArgs>();

	private final Event<SprintArgs> showChartEvent = new Event<SprintArgs>();
	// ###### Ende Events ###########
	private final Image imgNewSprint;
	private final Image imgDetailSprint;

	private final Image imgDeleteSprint;
	private final SprintTableView spTable;
	private final ScrollPanel scrollPanel;

	private final Image imgChart;

	public SprintView() {

		final AbsolutePanel absolutePanel = new AbsolutePanel();
		this.initWidget(absolutePanel);
		absolutePanel.setSize("600px", "300px");

		final Label lblSprintUebersicht = new Label(
				TextConstants.SPRINT_OVERWIEW);
		lblSprintUebersicht.setStyleName(TextConstants.LABELELEMENT);
		absolutePanel.add(lblSprintUebersicht, 10, 5);

		final FlowPanel flowPanel = new FlowPanel();
		absolutePanel.add(flowPanel, 10, 34);
		flowPanel.setSize("250px", "25px");

		this.imgNewSprint = new Image(TextConstants_FilePaths.NEW_FILE_PATH);
		this.imgNewSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.newSprintEvent.fire(SprintView.this,
						new EventArgs());
			}
		});

		flowPanel.add(this.imgNewSprint);

		this.imgDetailSprint = new Image(TextConstants_FilePaths.DETAILS_PATH);
		this.imgDetailSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.detailsSelectedSprintEvent.fire(
						SprintView.this,
						new SprintArgs(SprintView.this.spTable
								.getCurrentlySelected()));
			}
		});

		flowPanel.add(this.imgDetailSprint);

		this.imgDeleteSprint = new Image(TextConstants_FilePaths.DELETE_PATH);
		this.imgDeleteSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.deleteSelectedSprintEvent.fire(
						SprintView.this,
						new SprintArgs(SprintView.this.spTable
								.getCurrentlySelected()));
			}
		});
		flowPanel.add(this.imgDeleteSprint);

		this.imgChart = new Image(TextConstants_FilePaths.CHART_PATH);
		this.imgChart.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (SprintView.this.spTable.getCurrentlySelected() != null) {
					SprintView.this.showChartEvent.fire(
							SprintView.this,
							new SprintArgs(SprintView.this.spTable
									.getCurrentlySelected()));
				}
			}
		});
		flowPanel.add(this.imgChart);

		final AbsolutePanel masterSprintTablePanel = new AbsolutePanel();
		absolutePanel.add(masterSprintTablePanel, 10, 72);
		masterSprintTablePanel.setSize("575px", "215px");

		this.scrollPanel = new ScrollPanel();
		masterSprintTablePanel.add(this.scrollPanel);
		this.scrollPanel.setSize("575px", "215px");

		this.spTable = new SprintTableView();
		this.scrollPanel.setWidget(this.spTable);
		this.spTable.setSize("100%", "100%");

	}

	@Override
	public void addDeleteSprintEventHandler(EventHandler<SprintArgs> arg) {
		this.deleteSelectedSprintEvent.add(arg);
	}

	@Override
	public void addNewSprintEventHandler(EventHandler<EventArgs> arg) {
		this.newSprintEvent.add(arg);
	}

	@Override
	public void addShowChartEventHandler(EventHandler<SprintArgs> arg) {
		this.showChartEvent.add(arg);
	}

	@Override
	public void addSprintDetailsEventHandler(EventHandler<SprintArgs> arg) {
		this.detailsSelectedSprintEvent.add(arg);
	}

	@Override
	public void refreshSprints(List<ISprint> sprints) {
		this.spTable.getTableSprint().setRowData(sprints);
	}

}
