package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class TaskboardView extends Composite implements ITaskboardView {
	
	//####### Events ###############
	private final Event<SprintArgs> selectSprint = new Event<SprintArgs>();
	private final Event<PBIArgs> newTaskEvent = new Event<PBIArgs>();
	private final Event<TaskArgs> editTaskEvent = new Event<TaskArgs>();
	//##### Ende ##################
	
	private SingleSelectionModel<ISprint> sprintSelectionModel;
	private HorizontalPanel contentPanel;
	private Button btnEditInProgressTask;
	private CellList<Task> todoCellList;
	private CellList<ProductBacklogItem> pbiCellList;
	private Button btnNewTask;
	private Button btnEditDoneTask;
	private Button btnEditTodoTask;
	private CellList<Task> DoneCellList;
	private CellList<Task> inProgresscellList;
	
	public TaskboardView() {
		
		this.initSelectionModel();
		
		contentPanel = new HorizontalPanel();
		initWidget(contentPanel);
		contentPanel.setSize("1000px", "600px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		contentPanel.add(scrollPanel);
		scrollPanel.setSize("225px", "600px");
		
		StackPanel stackPanel = new StackPanel();
		scrollPanel.setWidget(stackPanel);
		stackPanel.setSize("100%", "100%");
		
		CellTree projectCellTree = new CellTree(new SprintSelectionTreeViewModel(sprintSelectionModel), null);
		projectCellTree.setAnimationEnabled(true);
		
		stackPanel.add(projectCellTree, "Sprintauswahl", false);
		projectCellTree.setSize("100%", "100%");
		
		AbsolutePanel concreteTaskboardPanel = new AbsolutePanel();
		contentPanel.add(concreteTaskboardPanel);
		concreteTaskboardPanel.setSize("775px", "600px");
		
		pbiCellList = new CellList<ProductBacklogItem>(new AbstractCell<ProductBacklogItem>(){
			@Override
			public void render(Context context, ProductBacklogItem value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		pbiCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(pbiCellList, 70, 50);
		pbiCellList.setSize("150px", "500px");
		pbiCellList.setSelectionModel(new SingleSelectionModel<ProductBacklogItem>());
		
		Label lblAnforderung = new Label("Anforderungen");
		concreteTaskboardPanel.add(lblAnforderung, 70, 28);
		
		todoCellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
				// TODO
			}
		});
		todoCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(todoCellList, 291, 50);
		todoCellList.setSize("150px", "500px");
		
		Label lblZuErledigen = new Label("Zu erledigen");
		concreteTaskboardPanel.add(lblZuErledigen, 291, 28);
		
		inProgresscellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
				// TODO
			}
		});
		inProgresscellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(inProgresscellList, 447, 50);
		inProgresscellList.setSize("150px", "500px");
		
		DoneCellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
				// TODO
			}
		});
		DoneCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(DoneCellList, 603, 50);
		DoneCellList.setSize("150px", "500px");
		
		Label lblInArbeit = new Label("In Arbeit");
		concreteTaskboardPanel.add(lblInArbeit, 447, 28);
		
		Label lblErledigt = new Label("Erledigt");
		concreteTaskboardPanel.add(lblErledigt, 603, 28);
		
		btnNewTask = new Button("New button");
		btnNewTask.setText("Neuer Task");
		concreteTaskboardPanel.add(btnNewTask, 70, 562);
		btnNewTask.setSize("150px", "28px");
		btnNewTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				TaskboardView.this.newTaskEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		btnEditTodoTask = new Button("Task bearbeiten");
		btnEditTodoTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditTodoTask, 291, 562);
		btnEditTodoTask.setSize("150px", "28px");
		
		btnEditInProgressTask = new Button("Task bearbeiten");
		btnEditInProgressTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditInProgressTask, 447, 562);
		btnEditInProgressTask.setSize("150px", "28px");
		
		btnEditDoneTask = new Button("Task bearbeiten");
		btnEditDoneTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditDoneTask, 603, 562);
		btnEditDoneTask.setSize("150px", "28px");
	}
	
	private void initSelectionModel() {
		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				TaskboardView.this.selectSprint.fire(TaskboardView.this, new SprintArgs(TaskboardView.this.sprintSelectionModel.getSelectedObject()));
			}
		});
	}
	
	@Override
	public void addSelectSprintHandler(EventHandler<SprintArgs> arg) {
		selectSprint.add(arg);
	}
	
	@Override
	public void addNewTaskEventHandler(EventHandler<PBIArgs> arg) {
		newTaskEvent.add(arg);
	}
	
	public Button getBtnEditInProgressTask() {
		return btnEditInProgressTask;
	}
	public CellList<Task> getTodoCellList() {
		return todoCellList;
	}
	public CellList<ProductBacklogItem> getPbiCellList() {
		return pbiCellList;
	}
	public Button getBtnNewTask() {
		return btnNewTask;
	}
	public Button getBtnEditDoneTask() {
		return btnEditDoneTask;
	}
	public Button getBtnEditTodoTask() {
		return btnEditTodoTask;
	}
	public CellList<Task> getDoneCellList() {
		return DoneCellList;
	}
	public CellList<Task> getInProgresscellList() {
		return inProgresscellList;
	}
	
	@Override
	public void refreshPBIs(Vector<ProductBacklogItem> pbis){
		this.getPbiCellList().setRowData(pbis);
	}
	
	@Override
	public ProductBacklogItem getSelectedPBI() {
		SingleSelectionModel<ProductBacklogItem> selPBIModel = (SingleSelectionModel<ProductBacklogItem>) this.pbiCellList.getSelectionModel();
		ProductBacklogItem selectedPBI= (ProductBacklogItem) selPBIModel.getSelectedObject();
		return selectedPBI;
	}
}
