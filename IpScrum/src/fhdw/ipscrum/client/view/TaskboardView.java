package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.viewinterfaces.ITaskboardView;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * taskboard gui for inspecting and managing tasks of a sprint.
 */
public class TaskboardView extends Composite implements ITaskboardView {

	private final DefaultEvent newTaskEvent = new DefaultEvent();
	private final Event<TypedEventArg<Task>> detailsEvent =
			new Event<TypedEventArg<Task>>();
	private final SingleSelectionModel<Task> taskSelModel =
			new SingleSelectionModel<Task>();

	private CellTable<Task> cellTableOpen;
	private CellTable<Task> cellTableInProgress;
	private CellTable<Task> cellTableDone;
	private Button btnCreateNewTask;

	/**
	 * constructor of the TaskboardView.
	 */
	public TaskboardView() {

		final VerticalPanel pnlLayout = new VerticalPanel();
		this.initWidget(pnlLayout);
		pnlLayout.setSize("700px", "300px");

		final HorizontalPanel pnlButtons = new HorizontalPanel();
		pnlButtons.setSpacing(10);
		pnlLayout.add(pnlButtons);

		this.btnCreateNewTask = new Button("Neuen Task erstellen");
		this.btnCreateNewTask.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TaskboardView.this.newTaskEvent.fire(TaskboardView.this);
			}
		});
		pnlButtons.add(this.btnCreateNewTask);

		final Button btnDetails =
				new Button("Details des selektierten Tasks anzeigen/bearbeiten");
		btnDetails.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TaskboardView.this.detailsEvent
						.fire(TaskboardView.this, new TypedEventArg<Task>(
								TaskboardView.this.getSelectedElement()));
			}
		});
		pnlButtons.add(btnDetails);

		final HTML htmlSeparator = new HTML("<hr />", true);
		pnlLayout.add(htmlSeparator);

		final HorizontalPanel pnlMainContent = new HorizontalPanel();
		pnlMainContent.setSpacing(10);
		pnlLayout.add(pnlMainContent);
		pnlMainContent.setSize("100%", "100%");
		pnlLayout.setCellHeight(pnlMainContent, "100%");
		pnlLayout.setCellWidth(pnlMainContent, "100%");

		final VerticalPanel pnlOpenTasks = new VerticalPanel();
		pnlMainContent.add(pnlOpenTasks);

		final Label lblOpen = new Label("Unbearbeitet");
		lblOpen.setStyleName("bold");
		pnlOpenTasks.add(lblOpen);

		final ScrollPanel scrlpnlOpen = new ScrollPanel();
		pnlOpenTasks.add(scrlpnlOpen);
		scrlpnlOpen.setHeight("");

		this.cellTableOpen = new CellTable<Task>();
		this.cellTableOpen.setSelectionModel(this.taskSelModel);
		scrlpnlOpen.setWidget(this.cellTableOpen);
		this.cellTableOpen.setSize("100%", "100%");

		final Column<Task, String> colDescriptionOpen =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getName();
					}
				};
		this.cellTableOpen.addColumn(colDescriptionOpen, "Bezeichnung");

		final Column<Task, String> colStateOpen =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getCurrentState().getName();
					}
				};
		this.cellTableOpen.addColumn(colStateOpen, "Zustand");

		final VerticalPanel pnlInProgress = new VerticalPanel();
		pnlMainContent.add(pnlInProgress);

		final Label lblInProgress = new Label("In Arbeit");
		lblInProgress.setStyleName("bold");
		pnlInProgress.add(lblInProgress);

		final ScrollPanel scrlpnlInProgress = new ScrollPanel();
		pnlInProgress.add(scrlpnlInProgress);

		this.cellTableInProgress = new CellTable<Task>();
		this.cellTableInProgress.setSelectionModel(this.taskSelModel);
		scrlpnlInProgress.setWidget(this.cellTableInProgress);
		this.cellTableInProgress.setSize("100%", "100%");

		final Column<Task, String> colDescriptionInProgress =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getName();
					}

				};
		this.cellTableInProgress.addColumn(colDescriptionInProgress, "Bezeichnung");

		final Column<Task, String> colStateInProgress =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getCurrentState().getName();
					}
				};
		this.cellTableInProgress.addColumn(colStateInProgress, "Zustand");

		final VerticalPanel pnlDone = new VerticalPanel();
		pnlMainContent.add(pnlDone);

		final Label lblDone = new Label("Abgeschlossen");
		lblDone.setStyleName("bold");
		pnlDone.add(lblDone);

		final ScrollPanel scrlpnlDone = new ScrollPanel();
		pnlDone.add(scrlpnlDone);

		this.cellTableDone = new CellTable<Task>();
		this.cellTableDone.setSelectionModel(this.taskSelModel);
		scrlpnlDone.setWidget(this.cellTableDone);
		this.cellTableDone.setSize("100%", "100%");

		final Column<Task, String> colDescriptionDone =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getName();
					}
				};
		this.cellTableDone.addColumn(colDescriptionDone, "Bezeichnung");

		final Column<Task, String> colStateDone =
				new Column<Task, String>(new TextCell()) {
					@Override
					public String getValue(final Task object) {
						return object.getCurrentState().getName();
					}
				};
		this.cellTableDone.addColumn(colStateDone, "Zustand");

	}

	@Override
	public Task getSelectedElement() {
		return this.taskSelModel.getSelectedObject();
	}

	@Override
	public EventRegistration registerNewTaskEventHandler(
			final DefaultEventHandler handler) {
		return this.newTaskEvent.add(handler);
	}

	@Override
	public EventRegistration registerDetailsEventHandler(
			final EventHandler<TypedEventArg<Task>> handler) {
		return this.detailsEvent.add(handler);
	}

	@Override
	public void fillOpenTaskTable(final List<Task> tasklist) {
		this.cellTableOpen.setRowData(tasklist);
	}

	@Override
	public void fillInProgressTaskTable(final List<Task> tasklist) {
		this.cellTableInProgress.setRowData(tasklist);
	}

	@Override
	public void fillDoneTaskTable(final List<Task> tasklist) {
		this.cellTableDone.setRowData(tasklist);
	}

	@Override
	public void close() {
		this.newTaskEvent.removeAllHandler();
		this.detailsEvent.removeAllHandler();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnCreateNewTask().setEnabled(value);

	}

	protected Button getBtnCreateNewTask() {
		return this.btnCreateNewTask;
	}
}
