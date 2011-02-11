package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.client.view.interfaces.IReleaseView;
import fhdw.ipscrum.shared.model.Release;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.cellview.client.Column;
import java.util.Date;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;



public class ReleaseView extends Composite implements IReleaseView{

	// ########## Events #############
	private final Event<EventArgs> newReleaseEvent = new Event<EventArgs>();
	private final Event<ReleaseArgs> deleteSelectedReleaseEvent = new Event<ReleaseArgs>();
	private final Event<ReleaseArgs> detailsSelectedReleaseEvent = new Event<ReleaseArgs>();
	// ###### Ende Events ###########
	
	private Release currentlySelected;
	
	private Image imgNewFile;
	private Image imgDetails;
	private Image imgDelete;
	private CellTable<Release> tableRelease;
	private ScrollPanel scrollPanel;
	private Column date;
	private Label lblReleaseuebersicht;
	
	public static IReleaseView createView(){
		return new ReleaseView();
	}
	
	public ReleaseView() {
		
		AbsolutePanel concreteReleasePanel = new AbsolutePanel();
		initWidget(concreteReleasePanel);
		concreteReleasePanel.setSize("500", "300");
		
		lblReleaseuebersicht = new Label("Release\u00FCbersicht");
		lblReleaseuebersicht.setStyleName("LabelElement");
		concreteReleasePanel.add(lblReleaseuebersicht, 10, 5);
		lblReleaseuebersicht.setSize("126px", "19px");
		
		FlowPanel ReleaseMenuPanel = new FlowPanel();
		concreteReleasePanel.add(ReleaseMenuPanel, 10, 34);
		ReleaseMenuPanel.setSize("256px", "25px");
		
		imgNewFile = new Image("images/newfile.png");
		
		imgNewFile.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			newReleaseEvent.fire(ReleaseView.this, new ReleaseArgs(currentlySelected));	
			}
		});
		ReleaseMenuPanel.add(imgNewFile);
		
		imgDetails = new Image("images/details.png");
		imgDetails.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			detailsSelectedReleaseEvent.fire(ReleaseView.this, new ReleaseArgs(currentlySelected));
			}
		});
		ReleaseMenuPanel.add(imgDetails);
		
		imgDelete = new Image("images/delete.png");
		imgDelete.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteSelectedReleaseEvent.fire(ReleaseView.this, new ReleaseArgs(currentlySelected));
							}
		});
		ReleaseMenuPanel.add(imgDelete);
		
		scrollPanel = new ScrollPanel();
		concreteReleasePanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("450px", "200px");
		
		tableRelease = new CellTable<Release>();
		
		TextColumn<Release> version = new TextColumn<Release>() {
			@Override
			public String getValue(Release release) {
				return release.getVersion();
			}
		};
		tableRelease.addColumn(version, "Version");
		
		date = new Column<Release, Date>(new DateCell()) {
			@Override
			public Date getValue(Release release) {
				return release.getReleaseDate();
			}
		};
		tableRelease.addColumn(date, "Releasedatum");
		scrollPanel.setWidget(tableRelease);
		tableRelease.setSize("100%", "100%");
	}

	@Override
	public void addReleaseDetailsEventHandler(EventHandler<ReleaseArgs> arg) {
		detailsSelectedReleaseEvent.add(arg);
		
	}

	@Override
	public void addDeleteReleaseEventHandler(EventHandler<ReleaseArgs> arg) {
		deleteSelectedReleaseEvent.add(arg);
		
	}


		private CellTable<Release> getTableRelease() {
			return this.tableRelease;
		}

		@Override
		public void addNewReleaseEventHandler(EventHandler<EventArgs> arg) {
			newReleaseEvent.add(arg);
		}

		@Override
		public void refreshReleases(HashSet<Release> release) {
		this.getTableRelease().setRowData(new ArrayList<Release>(release));
			
		}

}
