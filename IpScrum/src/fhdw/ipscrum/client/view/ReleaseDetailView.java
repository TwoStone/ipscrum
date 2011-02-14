package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.IReleaseDetailView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class ReleaseDetailView extends Composite implements IReleaseDetailView{
	
	
	// ########## Events #############
	private final Event<EventArgs> addSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSprintEvent = new Event<SprintArgs>();
	private final Event<EventArgs> cancelReleaseDetailViewEvent = new Event<EventArgs>();
	// ###### Ende Events ###########
	
	private SprintTableView spTable;
	private ScrollPanel scrollPanel;

	
	public static IView createView(){
		return new ReleaseDetailView();
	}
	
	public ReleaseDetailView() {
		
		AbsolutePanel flowPanel = new AbsolutePanel();
		initWidget(flowPanel);
		flowPanel.setSize("600px", "500px");
		
		scrollPanel = new ScrollPanel();
		flowPanel.add(scrollPanel, 10, 45);
		scrollPanel.setSize("580px", "400px");
		
		this.spTable = new SprintTableView();
		
		scrollPanel.add(this.spTable);
		
		Button btnAbort = new Button("New button");
		
		btnAbort.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				cancelReleaseDetailViewEvent.fire(ReleaseDetailView.this, new EventArgs());
			}
			
		});
		
		btnAbort.setText("Abbruch");
		flowPanel.add(btnAbort, 350, 462);
		btnAbort.setSize("100px", "28px");
		
		Button btnAddSprint = new Button("New button");
		
		btnAddSprint.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			addSprintEvent.fire(ReleaseDetailView.this, new SprintArgs(ReleaseDetailView.this.spTable.getCurrentlySelected()));	
			}
		});
		
		btnAddSprint.setText("Sprint hinzufügen");
		flowPanel.add(btnAddSprint, 38, 462);
		btnAddSprint.setSize("150px", "28px");
		
		Button btnSprintDelete = new Button("New button");
	
		btnSprintDelete.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteSprintEvent.fire(ReleaseDetailView.this, new SprintArgs(ReleaseDetailView.this.spTable.getCurrentlySelected()));
			}
		});
		
		btnSprintDelete.setText("Sprint entfernen");
		flowPanel.add(btnSprintDelete, 194, 462);
		btnSprintDelete.setSize("150px", "28px");
	}

	
	@Override
	public void addAddSprintEventHandler(EventHandler<EventArgs> arg) {
	addSprintEvent.add(arg);	
	
	}
	@Override
	public void refreshSprints(Vector<ISprint> sprints) {
	this.spTable.getTableSprint().setRowData(sprints);
	}
	
	@Override
	public void addDeleteSprintEventHandler(EventHandler<SprintArgs> arg) {
		deleteSprintEvent.add(arg);
	}

	@Override
	public void addCancelReleaseDetailViewHandler(EventHandler<EventArgs> arg) {
		cancelReleaseDetailViewEvent.add(arg);
	}

	}