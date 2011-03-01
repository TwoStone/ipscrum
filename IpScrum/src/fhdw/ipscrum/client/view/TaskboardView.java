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
import com.google.gwt.user.client.ui.Image;
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
	private final Event<TaskArgs> deleteTaskEvent = new Event<TaskArgs>();
	private final Event<TaskArgs> editTaskEvent = new Event<TaskArgs>();
	private final Event<PBIArgs> prioTopEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> prioUpEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> prioDownEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> prioBottomEvent = new Event<PBIArgs>();
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
	private Button btnDeleteTodoTask;
	private Image imgPrioUp;
	private Image imgPrioDown;
	private Button btnDeleteInProgressTask;
	private Image imgPrioBottom;
	private Image imgPrioTop;
	private Button btnDeleteDoneTask;
	
	public TaskboardView() {
		
		this.initTreeSelectionModel();
		
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
		concreteTaskboardPanel.add(pbiCellList, 25, 50);
		pbiCellList.setSize("150px", "400px");
		pbiCellList.setSelectionModel(new SingleSelectionModel<ProductBacklogItem>());
		
		Label lblAnforderung = new Label("Anforderungen");
		lblAnforderung.setStyleName("bold");
		concreteTaskboardPanel.add(lblAnforderung, 25, 28);
		
		todoCellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
			sb.appendEscaped(value.getName());
			}
		});
		todoCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(todoCellList, 291, 50);
		todoCellList.setSize("150px", "400px");
		todoCellList.setSelectionModel(new SingleSelectionModel<Task>());
		
		Label lblZuErledigen = new Label("Zu erledigen");
		lblZuErledigen.setStyleName("bold");
		concreteTaskboardPanel.add(lblZuErledigen, 291, 28);
		
		inProgresscellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		inProgresscellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(inProgresscellList, 447, 50);
		inProgresscellList.setSize("150px", "400px");
		inProgresscellList.setSelectionModel(new SingleSelectionModel<Task>());
		
		DoneCellList = new CellList<Task>(new AbstractCell<Task>(){
			@Override
			public void render(Context context, Task value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
				}
		});
		DoneCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(DoneCellList, 603, 50);
		DoneCellList.setSize("150px", "400px");
		DoneCellList.setSelectionModel(new SingleSelectionModel<Task>());
		
		Label lblInArbeit = new Label("In Arbeit");
		lblInArbeit.setStyleName("bold");
		concreteTaskboardPanel.add(lblInArbeit, 447, 28);
		
		Label lblErledigt = new Label("Erledigt");
		lblErledigt.setStyleName("bold");
		concreteTaskboardPanel.add(lblErledigt, 603, 28);
		
		btnNewTask = new Button("New button");
		btnNewTask.setText("Neuer Task");
		concreteTaskboardPanel.add(btnNewTask, 25, 464);
		btnNewTask.setSize("150px", "28px");
		btnNewTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				TaskboardView.this.newTaskEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		btnEditTodoTask = new Button("Task bearbeiten");
		btnEditTodoTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditTodoTask, 291, 464);
		btnEditTodoTask.setSize("150px", "28px");
		btnEditTodoTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				editTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedTodoTask()));
			}
		});
		
		btnEditInProgressTask = new Button("Task bearbeiten");
		btnEditInProgressTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditInProgressTask, 447, 464);
		btnEditInProgressTask.setSize("150px", "28px");
		btnEditInProgressTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				editTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedInProgressTask()));
			}
		});
		
		btnEditDoneTask = new Button("Task bearbeiten");
		btnEditDoneTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditDoneTask, 603, 464);
		btnEditDoneTask.setSize("150px", "28px");
		btnEditDoneTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			editTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedDoneTask()));	
			}
		});
		
		btnDeleteTodoTask = new Button("Task löschen");
		concreteTaskboardPanel.add(btnDeleteTodoTask, 291, 498);
		btnDeleteTodoTask.setSize("150px", "28px");
		btnDeleteTodoTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			deleteTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedTodoTask()));	
			}
		});
		
		btnDeleteInProgressTask = new Button("Task löschen");
		concreteTaskboardPanel.add(btnDeleteInProgressTask, 447, 498);
		btnDeleteInProgressTask.setSize("150px", "28px");
		btnDeleteInProgressTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedInProgressTask()));
						}
		});
		
		btnDeleteDoneTask = new Button("Task löschen");
		concreteTaskboardPanel.add(btnDeleteDoneTask, 603, 498);
		btnDeleteDoneTask.setSize("150px", "28px");
		btnDeleteDoneTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			deleteTaskEvent.fire(TaskboardView.this, new TaskArgs(getSelectedDoneTask()));	
			}
		});
		
		imgPrioTop = new Image("images/.svn/text-base/toparrow.png.svn-base");
		concreteTaskboardPanel.add(imgPrioTop, 189, 50);
		imgPrioTop.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				prioTopEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		
		imgPrioUp = new Image("images/.svn/text-base/uparrow.png.svn-base");
		concreteTaskboardPanel.add(imgPrioUp, 189, 81);
		imgPrioUp.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				prioUpEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		imgPrioDown = new Image("images/.svn/text-base/downarrow.png.svn-base");
		concreteTaskboardPanel.add(imgPrioDown, 189, 112);
		imgPrioDown.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				prioDownEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		imgPrioBottom = new Image("images/.svn/text-base/bottomarrow.png.svn-base");
		concreteTaskboardPanel.add(imgPrioBottom, 189, 143);
		imgPrioBottom.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				prioBottomEvent.fire(TaskboardView.this, new PBIArgs(getSelectedPBI()));
			}
		});
		
		
		Label lblPrio = new Label("Priorität");
		lblPrio.setStyleName("bold");
		concreteTaskboardPanel.add(lblPrio, 190, 28);
	}
	
	private void initTreeSelectionModel() {
		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				TaskboardView.this.selectSprint.fire(TaskboardView.this, new SprintArgs(TaskboardView.this.sprintSelectionModel.getSelectedObject()));
			}
		});
	}
	
	// Methods for registrate EventHandler
	
	@Override
	public void addSelectSprintHandler(EventHandler<SprintArgs> arg) {
		selectSprint.add(arg);
	}
	
	@Override
	public void addNewTaskEventHandler(EventHandler<PBIArgs> arg) {
		newTaskEvent.add(arg);
	}
	
	@Override
	public void addDeleteTaskEventHandler(EventHandler<TaskArgs> arg) {
		deleteTaskEvent.add(arg);
	}
	
	@Override
	public void addEditTaskEventHandler(EventHandler<TaskArgs> arg) {
		editTaskEvent.add(arg);
	}
	
	@Override
	public void addPrioTopEventHandler(EventHandler<PBIArgs> arg) {
		prioTopEvent.add(arg);
	}
	
	@Override
	public void addPrioUpEventHandler(EventHandler<PBIArgs> arg) {
		prioUpEvent.add(arg);
	}
	
	@Override
	public void addPrioDownEventHandler(EventHandler<PBIArgs> arg) {
		prioDownEvent.add(arg);
	}
	
	@Override
	public void addPrioBottomEventHandler(EventHandler<PBIArgs> arg) {
		prioBottomEvent.add(arg);
	}

	
	
	// Methods for refreshin / filling the cell-Lists 
	
	@Override
	public void refreshPBIs(Vector<ProductBacklogItem> pbis){
		this.getPbiCellList().setRowData(pbis);
	}
	
	@Override
	public void refreshTodoTasks(Vector<Task> tasks){
		this.getTodoCellList().setRowData(tasks);
	}
	
	@Override
	public void refreshInProgressTasks(Vector<Task> tasks){
		this.getInProgresscellList().setRowData(tasks);
	}
	
	@Override
	public void refreshDoneTasks(Vector<Task> tasks){
		this.getDoneCellList().setRowData(tasks);
	}
	
	// Setter / Getter Methods
	// Private because only needed inside of the TaskboardView
	
	// Getter for selected Objects
	@Override
	public ProductBacklogItem getSelectedPBI() {
		SingleSelectionModel<ProductBacklogItem> selPBIModel = (SingleSelectionModel<ProductBacklogItem>) this.pbiCellList.getSelectionModel();
		ProductBacklogItem selectedPBI= (ProductBacklogItem) selPBIModel.getSelectedObject();
		return selectedPBI;
	}

	@Override
	public Task getSelectedTodoTask() {
		SingleSelectionModel<Task> selTaskModel = (SingleSelectionModel<Task>) this.todoCellList.getSelectionModel();
		Task selectedTask= (Task) selTaskModel.getSelectedObject();
		return selectedTask;
	}
	
	@Override
	public Task getSelectedInProgressTask() {
		SingleSelectionModel<Task> selTaskModel = (SingleSelectionModel<Task>) this.inProgresscellList.getSelectionModel();
		Task selectedTask= (Task) selTaskModel.getSelectedObject();
		return selectedTask;
	}
	
	@Override
	public Task getSelectedDoneTask() {
		SingleSelectionModel<Task> selTaskModel = (SingleSelectionModel<Task>) this.DoneCellList.getSelectionModel();
		Task selectedTask= (Task) selTaskModel.getSelectedObject();
		return selectedTask;
	}
	
	// Getter for the Widgets
	private Button getBtnEditInProgressTask() {
		return btnEditInProgressTask;
	}
	private CellList<Task> getTodoCellList() {
		return todoCellList;
	}
	private CellList<ProductBacklogItem> getPbiCellList() {
		return pbiCellList;
	}
	private Button getBtnNewTask() {
		return btnNewTask;
	}
	private Button getBtnEditDoneTask() {
		return btnEditDoneTask;
	}
	private Button getBtnEditTodoTask() {
		return btnEditTodoTask;
	}
	private CellList<Task> getDoneCellList() {
		return DoneCellList;
	}
	private CellList<Task> getInProgresscellList() {
		return inProgresscellList;
	}
	private Button getBtnDeleteTodoTask() {
		return btnDeleteTodoTask;
	}
	private Image getImgPrioUp() {
		return imgPrioUp;
	}
	private Image getImgPrioDown() {
		return imgPrioDown;
	}
	private Button getBtnDeleteInProgressTask() {
		return btnDeleteInProgressTask;
	}
	private Image getImgPrioBottom() {
		return imgPrioBottom;
	}
	private Image getImgPrioTop() {
		return imgPrioTop;
	}
	private Button getBtnDeleteDoneTask() {
		return btnDeleteDoneTask;
	}
}
