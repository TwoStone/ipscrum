package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionModel.AbstractSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.client.view.interfaces.IView;

public class SprintView extends Composite implements ISprintView{
	
	// ########## Events #############
	private final Event<EventArgs> newSprintEvent = new Event<EventArgs>();
	private final Event<SprintArgs> deleteSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> detailsSelectedSprintEvent = new Event<SprintArgs>();
	private final Event<SprintArgs> selectSprintEvent = new Event<SprintArgs>();
	// ###### Ende Events ###########
	
	private Image imgNewSprint;
	private Image imgDetailSprint;
	private Image imgDeleteSprint;
	
	public static IView createView(){
		return new SprintView();
	}
	
	public SprintView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("500px", "300px");
		
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
				detailsSelectedSprintEvent.fire(SprintView.this, new SprintArgs());
			}
		});
		
		flowPanel.add(imgDetailSprint);
		
		imgDeleteSprint = new Image("images/delete.png");
		imgDeleteSprint.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteSelectedSprintEvent.fire(SprintView.this, new SprintArgs());
			}
		});
		
		flowPanel.add(imgDeleteSprint);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("450px", "200px");
		
		CellTree cellTree = new CellTree(
			new TreeViewModel() {
				final AbstractDataProvider<String> dataProvider = new ListDataProvider<String>();
				final AbstractSelectionModel<String> selectionModel = new NoSelectionModel<String>();
				@Override
				public <T> NodeInfo<?> getNodeInfo(T value) {
					return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
				}
				@Override
				public boolean isLeaf(Object value) {
					return true;
				}
			}, null);
		scrollPanel.setWidget(cellTree);
		cellTree.setSize("100%", "100%");
		
	
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
}

