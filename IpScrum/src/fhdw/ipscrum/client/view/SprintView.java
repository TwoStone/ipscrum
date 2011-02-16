package fhdw.ipscrum.client.view;

import java.util.Vector;

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
 *  This view is used to represent sprints.
 * 
 * @author Phase II / Gruppe I
 */
public class SprintView extends Composite implements ISprintView{

	// ########## Events #############
	private final Event<EventArgs> newSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> detailsSelectedSprintEvent = new Event<SprintArgs>();
	// ###### Ende Events ###########

	private Image imgNewSprint;
	private Image imgDetailSprint;
	private Image imgDeleteSprint;
	
	private SprintTableView spTable;
	private ScrollPanel scrollPanel;

	public static IView createView(){
		return new SprintView();
	}

	public SprintView() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("600px", "300px");

		Label lblSprintUebersicht = new Label(TextConstants.SPRINT_OVERWIEW);
		lblSprintUebersicht.setStyleName(TextConstants.LABELELEMENT);
		absolutePanel.add(lblSprintUebersicht, 10, 5);

		FlowPanel flowPanel = new FlowPanel();
		absolutePanel.add(flowPanel, 10, 34);
		flowPanel.setSize("250px", "25px");

		this.imgNewSprint = new Image(TextConstants_FilePaths.NEW_FILE_PATH);
		this.imgNewSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.newSprintEvent.fire(SprintView.this, new EventArgs());
			}
		});

		flowPanel.add(this.imgNewSprint);

		this.imgDetailSprint = new Image(TextConstants_FilePaths.DETAILS_PATH);
		this.imgDetailSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.detailsSelectedSprintEvent.fire(SprintView.this, new SprintArgs(SprintView.this.spTable.getCurrentlySelected()));
			}
		});

		flowPanel.add(this.imgDetailSprint);

		this.imgDeleteSprint = new Image(TextConstants_FilePaths.DELETE_PATH);
		this.imgDeleteSprint.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SprintView.this.deleteSelectedSprintEvent.fire(SprintView.this, new SprintArgs(SprintView.this.spTable.getCurrentlySelected()));
			}
		});

		flowPanel.add(this.imgDeleteSprint);

		AbsolutePanel masterSprintTablePanel = new AbsolutePanel();
		absolutePanel.add(masterSprintTablePanel, 10, 72);
		masterSprintTablePanel.setSize("575px", "215px");
		
		scrollPanel = new ScrollPanel();
		masterSprintTablePanel.add(scrollPanel);
		
		this.spTable = new SprintTableView();
		scrollPanel.setWidget(spTable);
		spTable.setSize("100%", "100%");

	}

	@Override
	public void addSprintDetailsEventHandler(EventHandler<SprintArgs> arg) {
		this.detailsSelectedSprintEvent.add(arg);
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
	public void refreshSprints(Vector<ISprint> sprints) {
		this.spTable.getTableSprint().setRowData(sprints);
	}

}

