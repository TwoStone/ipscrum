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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintView extends Composite implements ISprintView{
	
	// ########## Events #############
	private final Event<EventArgs> newSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> detailsSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> selectSprintEvent = new Event<SprintArgs>();
	// ###### Ende Events ###########
	
	private Sprint currentlySelected;
	
	private Image imgNewSprint;
	private Image imgDetailSprint;
	private Image imgDeleteSprint;
	private CellTable<ISprint> tableSprint;
	
	public static IView createView(){
		return new SprintView();
	}
	
	public SprintView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("600px", "300px");
		
		Label lblSprintUebersicht = new Label("Sprint\u00FCbersicht");
		lblSprintUebersicht.setStyleName("LabelElement");
		absolutePanel.add(lblSprintUebersicht, 10, 5);
		
		FlowPanel flowPanel = new FlowPanel();
		absolutePanel.add(flowPanel, 10, 34);
		flowPanel.setSize("250px", "25px");
		
		imgNewSprint = new Image("images/newfile.png");
		imgNewSprint.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				newSprintEvent.fire(SprintView.this, new EventArgs());
			}
		});
		
		flowPanel.add(imgNewSprint);
		
		imgDetailSprint = new Image("images/details.png");
		imgDetailSprint.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				detailsSelectedSprintEvent.fire(SprintView.this, new SprintArgs(currentlySelected));
			}
		});
		
		flowPanel.add(imgDetailSprint);
		
		imgDeleteSprint = new Image("images/delete.png");
		imgDeleteSprint.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteSelectedSprintEvent.fire(SprintView.this, new SprintArgs(currentlySelected));
			}
		});
		
		flowPanel.add(imgDeleteSprint);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("550px", "200px");
		
		tableSprint = new CellTable<ISprint>();
		
		tableSprint.setSelectionModel(new SingleSelectionModel<ISprint>());

		tableSprint.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				@SuppressWarnings("unchecked")
				SingleSelectionModel<ISprint> model = (SingleSelectionModel<ISprint>) tableSprint.getSelectionModel();
				currentlySelected = (Sprint) model.getSelectedObject();
			}
		});
		
		TextColumn<ISprint> beschreibungColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				return sprint.toString();
			}
		};
		tableSprint.addColumn(beschreibungColumn, "Beschreibung");
		scrollPanel.setWidget(tableSprint);
		tableSprint.setSize("100%", "100%");
		
	
	}

	@Override
	public void addSprintDetailsEventHandler(EventHandler<SprintArgs> arg) {
		detailsSelectedSprintEvent.add(arg);
	}

	@Override
	public void addDeleteReleaseEventHandler(EventHandler<SprintArgs> arg) {
		deleteSelectedSprintEvent.add(arg);
	}

	@Override
	public void addNewReleaseEventHandler(EventHandler<EventArgs> arg) {
	newSprintEvent.add(arg);
	}

	@Override
	public void refreshSprints(Vector<ISprint> sprints) {
		this.getTableSprint().setRowData(sprints);
	}
	
	private CellTable<ISprint> getTableSprint() {
		return tableSprint;
	}
}

