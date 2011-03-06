package fhdw.ipscrum.client.view;

import java.util.Set;
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
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * This class is used to represent taskboards.
 * 
 * @author Phase III / Group I
 * 
 */
public class TaskboardView extends Composite implements ITaskboardView {

	// ####### Events ###############
	private final Event<SprintArgs> selectSprint = new Event<SprintArgs>();
	private final Event<MultiplePBIArgs> newTaskEvent = new Event<MultiplePBIArgs>();
	private final Event<TaskArgs> deleteTaskEvent = new Event<TaskArgs>();
	private final Event<TaskArgs> editToDoTaskEvent = new Event<TaskArgs>();
	private final Event<TaskArgs> editInProgressTaskEvent = new Event<TaskArgs>();
	private final Event<TaskArgs> detailsFinishTaskEvent = new Event<TaskArgs>();
	// ##### Ende ##################

	// ####### View Elements ###############
	private SingleSelectionModel<ISprint> sprintSelectionModel;
	private HorizontalPanel contentPanel;
	private Button btnEditInProgressTask;
	private CellList<ProductBacklogItem> pbiCellList;
	private Button btnNewTask;
	private Button btnEditDoneTask;
	private Button btnEditTodoTask;
	private CellList<ITask> todoCellList;
	private CellList<ITask> doneCellList;
	private CellList<ITask> inProgressCellList;
	private Button btnDeleteTodoTask;
	private AbsolutePanel concreteTaskboardPanel;

	// ####### Ende View Elements ###############

	/**
	 * Constructor for {@link TaskboardView}. Creates all View-Elements for the taskboard and calls the initTreeSelectionModel().
	 */
	public TaskboardView() {

		this.initTreeSelectionModel();

		contentPanel = new HorizontalPanel();
		contentPanel.setSpacing(5);
		initWidget(contentPanel);
		contentPanel.setSize("1000px", "600px");

		ScrollPanel scrollPanel = new ScrollPanel();
		contentPanel.add(scrollPanel);
		scrollPanel.setSize("225px", "600px");

		DecoratedStackPanel stackPanel = new DecoratedStackPanel();
		scrollPanel.setWidget(stackPanel);
		stackPanel.setSize("100%", "100%");

		CellTree projectCellTree = new CellTree(
				new SprintSelectionTreeViewModel(sprintSelectionModel), null);
		projectCellTree.setAnimationEnabled(true);

		stackPanel.add(projectCellTree, "Sprintauswahl", false);
		projectCellTree.setSize("100%", "100%");

		concreteTaskboardPanel = new AbsolutePanel();
		contentPanel.add(concreteTaskboardPanel);
		concreteTaskboardPanel.setSize("775px", "600px");

		pbiCellList = new CellList<ProductBacklogItem>(
				new AbstractCell<ProductBacklogItem>() {
					@Override
					public void render(Context context,
							ProductBacklogItem value, SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getName());
					}
				});
		pbiCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(pbiCellList, 25, 50);
		pbiCellList.setSize("150px", "400px");
		pbiCellList
				.setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());

		Label lblPBI = new Label("ProductBacklog Eintrag");
		lblPBI.setStyleName("bold");
		concreteTaskboardPanel.add(lblPBI, 25, 28);

		Label lblZuErledigen = new Label("Zu erledigen");
		lblZuErledigen.setStyleName("bold");
		concreteTaskboardPanel.add(lblZuErledigen, 291, 28);

		this.todoCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		todoCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(todoCellList, 291, 50);
		todoCellList.setSize("150px", "400px");

		inProgressCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		inProgressCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(inProgressCellList, 447, 50);
		inProgressCellList.setSize("150px", "400px");

		doneCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		doneCellList.setStyleName("tableBorder");
		concreteTaskboardPanel.add(doneCellList, 603, 50);
		doneCellList.setSize("150px", "400px");

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
				TaskboardView.this.newTaskEvent.fire(TaskboardView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
			}
		});

		btnEditTodoTask = new Button("Task bearbeiten");
		btnEditTodoTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditTodoTask, 291, 464);
		btnEditTodoTask.setSize("150px", "28px");
		btnEditTodoTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				editToDoTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedTodoTask()));
			}
		});

		btnEditInProgressTask = new Button("Task bearbeiten");
		btnEditInProgressTask.setText("Task bearbeiten");
		concreteTaskboardPanel.add(btnEditInProgressTask, 447, 464);
		btnEditInProgressTask.setSize("150px", "28px");
		btnEditInProgressTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				editInProgressTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedInProgressTask()));
			}
		});

		btnEditDoneTask = new Button("Details");
		concreteTaskboardPanel.add(btnEditDoneTask, 603, 464);
		btnEditDoneTask.setSize("150px", "28px");
		btnEditDoneTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				detailsFinishTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedDoneTask()));
			}
		});

		btnDeleteTodoTask = new Button("Task löschen");
		concreteTaskboardPanel.add(btnDeleteTodoTask, 291, 498);
		btnDeleteTodoTask.setSize("150px", "28px");
		btnDeleteTodoTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				deleteTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedTodoTask()));
			}
		});

		concreteTaskboardPanel.setVisible(false);
	}

	/**
	 * This methode initializes the sprint-tree-selection-modell- Fires the
	 * selectSprint-Event if an sprint get selected.
	 */
	private void initTreeSelectionModel() {
		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						TaskboardView.this.selectSprint.fire(
								TaskboardView.this,
								new SprintArgs(
										TaskboardView.this.sprintSelectionModel
												.getSelectedObject()));
					}});}

	// Methods for registrate EventHandler

	@Override
	public void addSelectSprintEventHandler(EventHandler<SprintArgs> arg) {
		selectSprint.add(arg);
	}

	@Override
	public void addNewTaskEventHandler(EventHandler<MultiplePBIArgs> arg) {
		newTaskEvent.add(arg);
	}

	@Override
	public void addDeleteTaskEventHandler(EventHandler<TaskArgs> arg) {
		deleteTaskEvent.add(arg);
	}

	@Override
	public void addEditToDoTaskEventHandler(EventHandler<TaskArgs> arg) {
		editToDoTaskEvent.add(arg);
	}

	@Override
	public void addEditInProgressTaskEventHandler(EventHandler<TaskArgs> arg) {
		editInProgressTaskEvent.add(arg);
	}

	@Override
	public void addDetailsFinishTaskEventHandler(EventHandler<TaskArgs> arg) {
		detailsFinishTaskEvent.add(arg);
	}

	// Methods for refreshin / filling the cell-Lists

	@Override
	public void refreshPBIs(Vector<ProductBacklogItem> pbis) {
		this.getPbiCellList().setRowData(pbis);
	}

	@Override
	public void refreshTodoTasks(Vector<ITask> tasks) {
		this.getTodoCellList().setRowData(tasks);
		this.getTodoCellList().setSelectionModel(
				new SingleSelectionModel<ITask>());
	}

	@Override
	public void refreshInProgressTasks(Vector<ITask> tasks) {
		this.getInProgresscellList().setRowData(tasks);
		this.getInProgresscellList().setSelectionModel(
				new SingleSelectionModel<ITask>());
	}

	@Override
	public void refreshDoneTasks(Vector<ITask> tasks) {
		this.getDoneCellList().setRowData(tasks);
		this.getDoneCellList().setSelectionModel(
				new SingleSelectionModel<ITask>());
	}

	// Setter / Getter Methods
	// Private because only needed inside of the TaskboardView

	// Getter for selected Objects

	private AbsolutePanel getConcreteTaskboardPanel() {
		return concreteTaskboardPanel;
	}

	private Set<ProductBacklogItem> getSelectedPBIs() {
		@SuppressWarnings("unchecked")
		MultiSelectionModel<ProductBacklogItem> selPBIModel = (MultiSelectionModel<ProductBacklogItem>) this
				.getPbiCellList().getSelectionModel();
		Set<ProductBacklogItem> selectedPBIs = selPBIModel.getSelectedSet();
		return selectedPBIs;
	}

	@SuppressWarnings("unchecked")
	private ITask getSelectedTodoTask() {
		return ((SingleSelectionModel<ITask>) this.getTodoCellList()
				.getSelectionModel()).getSelectedObject();
	}

	@SuppressWarnings("unchecked")
	private ITask getSelectedInProgressTask() {
		return ((SingleSelectionModel<ITask>) this.getInProgresscellList()
				.getSelectionModel()).getSelectedObject();
	}

	@SuppressWarnings("unchecked")
	private ITask getSelectedDoneTask() {
		return ((SingleSelectionModel<ITask>) this.getDoneCellList()
				.getSelectionModel()).getSelectedObject();

	}

	// Getter for the Widgets
	private CellList<ITask> getTodoCellList() {
		return todoCellList;
	}

	private CellList<ProductBacklogItem> getPbiCellList() {
		return pbiCellList;
	}

	private CellList<ITask> getDoneCellList() {
		return doneCellList;
	}

	private CellList<ITask> getInProgresscellList() {
		return inProgressCellList;
	}

	// Makes the taskboard visible or not

	@Override
	public void setTaskboardVisibility(Boolean visible) {
		this.getConcreteTaskboardPanel().setVisible(visible);
	}
}
