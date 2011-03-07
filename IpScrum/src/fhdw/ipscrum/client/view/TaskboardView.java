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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.constants.TextConstants;
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
	 * Constructor for {@link TaskboardView}. Creates all View-Elements for the
	 * taskboard and calls the initTreeSelectionModel().
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

		stackPanel.add(projectCellTree, TextConstants.CHART_SPRINTSTACK_TITLE, false);
		projectCellTree.setSize("100%", "100%");

		concreteTaskboardPanel = new AbsolutePanel();
		contentPanel.add(concreteTaskboardPanel);
		concreteTaskboardPanel.setSize("775px", "600px");

		VerticalPanel newTasklPanel = new VerticalPanel();
		newTasklPanel.setSpacing(3);
		concreteTaskboardPanel.add(newTasklPanel, 25, 25);
		newTasklPanel.setSize("170px", "300px");

		Label lblPBI = new Label(TextConstants.PBIS);
		newTasklPanel.add(lblPBI);
		lblPBI.setWidth("100%");
		lblPBI.setStyleName("bold");

		pbiCellList = new CellList<ProductBacklogItem>(
				new AbstractCell<ProductBacklogItem>() {
					@Override
					public void render(Context context,
							ProductBacklogItem value, SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getName());
					}
				});
		pbiCellList.setStyleName("smallborder");
		newTasklPanel.add(pbiCellList);
		pbiCellList.setSize("130px", "250px");
		pbiCellList
				.setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());

		btnNewTask = new Button(TextConstants.NEW_BUTTON);
		newTasklPanel.add(btnNewTask);
		btnNewTask.setText(TextConstants.NEW_TASK);
		btnNewTask.setSize("140px", "28px");

		VerticalPanel toDoTaskPanel = new VerticalPanel();
		toDoTaskPanel.setSpacing(3);
		concreteTaskboardPanel.add(toDoTaskPanel, 242, 25);
		toDoTaskPanel.setSize("140px", "300px");

		Label lblZuErledigen = new Label(TextConstants.TO_FINISH);
		toDoTaskPanel.add(lblZuErledigen);
		lblZuErledigen.setStyleName("bold");

		this.todoCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		toDoTaskPanel.add(todoCellList);
		todoCellList.setStyleName("smallborder");
		todoCellList.setSize("130px", "250px");

		btnEditTodoTask = new Button(TextConstants.TASK_EDIT);
		toDoTaskPanel.add(btnEditTodoTask);
		btnEditTodoTask.setText(TextConstants.TASK_EDIT);
		btnEditTodoTask.setSize("100%", "28px");

		btnDeleteTodoTask = new Button(TextConstants.DELETE_TASK);
		toDoTaskPanel.add(btnDeleteTodoTask);
		btnDeleteTodoTask.setSize("100%", "28px");

		VerticalPanel inProgressTaskPanel = new VerticalPanel();
		inProgressTaskPanel.setSpacing(3);
		concreteTaskboardPanel.add(inProgressTaskPanel, 408, 25);
		inProgressTaskPanel.setSize("140px", "300px");

		Label lblInArbeit = new Label(TextConstants.IN_PROGRESS);
		inProgressTaskPanel.add(lblInArbeit);
		lblInArbeit.setStyleName("bold");

		inProgressCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		inProgressTaskPanel.add(inProgressCellList);
		inProgressCellList.setStyleName("smallborder");
		inProgressCellList.setSize("130px", "250px");

		btnEditInProgressTask = new Button(TextConstants.TASK_EDIT);
		inProgressTaskPanel.add(btnEditInProgressTask);
		btnEditInProgressTask.setText("Task bearbeiten");
		btnEditInProgressTask.setSize("100%", "28px");
		btnEditInProgressTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				editInProgressTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedInProgressTask()));
			}
		});

		VerticalPanel finishTaskPanel = new VerticalPanel();
		finishTaskPanel.setSpacing(3);
		concreteTaskboardPanel.add(finishTaskPanel, 574, 25);
		finishTaskPanel.setSize("140px", "300px");

		Label lblErledigt = new Label(TextConstants.COMPLETED);
		finishTaskPanel.add(lblErledigt);
		lblErledigt.setStyleName("bold");

		doneCellList = new CellList<ITask>(new AbstractCell<ITask>() {
			@Override
			public void render(Context context, ITask value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		finishTaskPanel.add(doneCellList);
		doneCellList.setStyleName("smallborder");
		doneCellList.setSize("130px", "250px");

		btnEditDoneTask = new Button(TextConstants.DETAILS);
		finishTaskPanel.add(btnEditDoneTask);
		btnEditDoneTask.setSize("100%", "28px");
		btnEditDoneTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				detailsFinishTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedDoneTask()));
			}
		});
		btnDeleteTodoTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				deleteTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedTodoTask()));
			}
		});
		btnEditTodoTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				editToDoTaskEvent.fire(TaskboardView.this, new TaskArgs(
						getSelectedTodoTask()));
			}
		});
		btnNewTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskboardView.this.newTaskEvent.fire(TaskboardView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
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
					}
				});
	}

	// Methods to register EventHandler

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

	// Methods for refreshing / filling the cell-Lists

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
