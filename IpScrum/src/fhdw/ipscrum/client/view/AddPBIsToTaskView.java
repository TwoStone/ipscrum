package fhdw.ipscrum.client.view;

import java.util.Set;
import java.util.Vector;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.view.interfaces.IAddPBIsToTaskView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class AddPBIsToTaskView extends Composite implements IAddPBIsToTaskView{

	// ####### Events ##############
	private final Event<MultiplePBIArgs> addPBIsEvent = new Event<MultiplePBIArgs>();
	private final Event<EventArgs> closeEvent = new Event<EventArgs>();	
	// ##### Ende ##################
	
	private CellList<ProductBacklogItem> sprintPBIsCellList;
	private Button btnAddPBIs;
	private CellList<ProductBacklogItem> taskPBIsCellList;
	private Button btnClose;
	public AddPBIsToTaskView() {
		
		AbsolutePanel addPBIsToTaskPanel = new AbsolutePanel();
		initWidget(addPBIsToTaskPanel);
		addPBIsToTaskPanel.setSize("465px", "360px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		addPBIsToTaskPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "100%");
		
		VerticalPanel addSprintPBIsPanel = new VerticalPanel();
		horizontalPanel.add(addSprintPBIsPanel);
		addSprintPBIsPanel.setSpacing(5);
		addSprintPBIsPanel.setSize("215px", "345px");
		
		CaptionPanel cptSprintEntries = new CaptionPanel("Sprint Einträge");
		addSprintPBIsPanel.add(cptSprintEntries);
		cptSprintEntries.setCaptionHTML("Sprint Einträge");
		cptSprintEntries.setSize("200px", "300px");
		
		sprintPBIsCellList = new CellList<ProductBacklogItem>(new AbstractCell<ProductBacklogItem>(){
			@Override
			public void render(Context context, ProductBacklogItem value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		cptSprintEntries.setContentWidget(sprintPBIsCellList);
		sprintPBIsCellList.setSize("100%", "100%");
		
		btnAddPBIs = new Button("Hinzufügen");
		addSprintPBIsPanel.add(btnAddPBIs);
		
		VerticalPanel taskPanel = new VerticalPanel();
		taskPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.add(taskPanel);
		taskPanel.setSpacing(5);
		taskPanel.setSize("215px", "345px");
		
		CaptionPanel cptnTaskEntries = new CaptionPanel("Task Einträge");
		taskPanel.add(cptnTaskEntries);
		cptnTaskEntries.setCaptionHTML("Task Einträge");
		cptnTaskEntries.setSize("200px", "300px");
		
		taskPBIsCellList = new CellList<ProductBacklogItem>(new AbstractCell<ProductBacklogItem>(){
			@Override
			public void render(Context context, ProductBacklogItem value, SafeHtmlBuilder sb) {
			sb.appendEscaped(value.getName());
			}
		});
		cptnTaskEntries.setContentWidget(taskPBIsCellList);
		taskPBIsCellList.setSize("100%", "100%");
		
		btnClose = new Button("Schließen");
		taskPanel.add(btnClose);
		btnClose.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				closeEvent.fire(AddPBIsToTaskView.this, new EventArgs());
			}
		});
		btnAddPBIs.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
		addPBIsEvent.fire(AddPBIsToTaskView.this, new MultiplePBIArgs(getSelectedPBIs()));
			}
		});
	}

	protected CellList<ProductBacklogItem> getSprintPBIsCellList() {
		return sprintPBIsCellList;
	}
	protected Button getBtnAddPBIs() {
		return btnAddPBIs;
	}
	protected CellList<ProductBacklogItem> getTaskPBIsCellList() {
		return taskPBIsCellList;
	}
	protected Button getBtnClose() {
		return btnClose;
	}
	

	@Override
	public void refreshSprintPBIs(Vector<ProductBacklogItem> pbis){
		this.getSprintPBIsCellList().setRowData(pbis);
		this.getSprintPBIsCellList().setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());
	}

	
		@Override
		public void refreshTaskPBIs(Vector<ProductBacklogItem> pbis){
		this.getTaskPBIsCellList().setRowData(pbis);
	}
		

		@Override
		@SuppressWarnings("unchecked")
		public Set<ProductBacklogItem> getSelectedPBIs(){
			return ((MultiSelectionModel<ProductBacklogItem>)this.getSprintPBIsCellList().getSelectionModel()).getSelectedSet();
		}

		@Override
		public void addAddPBIsToTaskEventHandler(
				EventHandler<MultiplePBIArgs> handler) {
		this.addPBIsEvent.add(handler);	
		}

		@Override
		public void addCloseEventHandler(EventHandler<EventArgs> handler) {
			this.closeEvent.add(handler);
			
		}
}
