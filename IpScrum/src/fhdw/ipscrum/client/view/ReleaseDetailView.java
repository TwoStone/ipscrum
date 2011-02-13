package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.IReleaseDetailView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class ReleaseDetailView extends Composite implements IReleaseDetailView{
	
	
	// ########## Events #############
	private final Event<EventArgs> addSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> selectSprintEvent = new Event<SprintArgs>();
	private final Event<EventArgs> cancelReleaseDetailViewEvent = new Event<EventArgs>();
	// ###### Ende Events ###########
	
	private Sprint currentlySelected;
	
	private ScrollPanel scrollPanel;
	private CellTable<ISprint> tableReleaseDetail;

	
	public static IView createView(){
		return new ReleaseDetailView();
	}
	
	public ReleaseDetailView() {
		
		AbsolutePanel flowPanel = new AbsolutePanel();
		initWidget(flowPanel);
		flowPanel.setSize("500px", "500px");
		
		scrollPanel = new ScrollPanel();
		flowPanel.add(scrollPanel, 50, 45);
		scrollPanel.setSize("400px", "400px");
		
		tableReleaseDetail = new CellTable<ISprint>();
		
		tableReleaseDetail.setSelectionModel(new SingleSelectionModel<ISprint>());

		tableReleaseDetail.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				@SuppressWarnings("unchecked")
				SingleSelectionModel<ISprint> model = (SingleSelectionModel<ISprint>) tableReleaseDetail.getSelectionModel();
				currentlySelected = (Sprint) model.getSelectedObject();
			}
		});
		
		
		TextColumn descriptionColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				return sprint.getDescription();
			}
		};
		tableReleaseDetail.addColumn(descriptionColumn, "Beschreibung");
		
		Column<ISprint, ?> startColumn = new Column<ISprint, Date>(new DateCell()) {
			@Override
			public Date getValue(ISprint sprint) {
				return sprint.getBegin();
			}
		};
		tableReleaseDetail.addColumn(startColumn, "Start");
		
		Column<ISprint, ?> endeColumn = new Column<ISprint, Date>(new DateCell()) {
			@Override
			public Date getValue(ISprint sprint) {
				return sprint.getEnd();
			}
		};
		tableReleaseDetail.addColumn(endeColumn, "Ende");
		
		TextColumn teamColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				return sprint.getTeam().getDescription();
			}
		};
		tableReleaseDetail.addColumn(teamColumn, "Team");
		scrollPanel.setWidget(tableReleaseDetail);
		tableReleaseDetail.setSize("100%", "100%");
		
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
			addSprintEvent.fire(ReleaseDetailView.this, new SprintArgs(currentlySelected));	
			}
		});
		
		btnAddSprint.setText("Sprint hinzufügen");
		flowPanel.add(btnAddSprint, 38, 462);
		btnAddSprint.setSize("150px", "28px");
		
		Button btnSprintDelete = new Button("New button");
	
		btnSprintDelete.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteSprintEvent.fire(ReleaseDetailView.this, new SprintArgs(currentlySelected));
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
	this.tableReleaseDetail.setRowData(sprints);
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