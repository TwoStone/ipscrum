package fhdw.ipscrum.client.view;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.viewinterfaces.IRevisionControlView;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * This view is intended as an editing history and provides the possibility to reset the
 * (local) model to a custom state of the past.
 */
public class RevisionControlView extends Composite implements IRevisionControlView {
	private final ListHandler<Revision> sortHandler = new ListHandler<Revision>(
			Collections.<Revision> emptyList());

	/**
	 * Inner class for event-argument transmission (MVC).
	 */
	public static class RevFilterArgs extends EventArgs {
		private final Date fromDate;
		private final Date toDate;
		private final Set<Person> editors;

		/**
		 * constructor of the RevFilterArgs.
		 * 
		 * @param fromDate
		 *            is the from date
		 * @param toDate
		 *            is the to date
		 * @param editors
		 *            are the editors
		 */
		public RevFilterArgs(final Date fromDate, final Date toDate,
				final Set<Person> editors) {
			super();
			this.fromDate = CalendarUtils.copy(fromDate);
			this.toDate = CalendarUtils.copy(toDate);
			this.editors = editors;
		}

		/**
		 * getter of the from date.
		 * 
		 * @return the date
		 */
		public Date getFromDate() {
			return CalendarUtils.copy(this.fromDate);
		}

		/**
		 * getter of the to date.
		 * 
		 * @return date
		 */
		public Date getToDate() {
			return CalendarUtils.copy(this.toDate);
		}

		/**
		 * getter of the persons.
		 * 
		 * @return all persons
		 */
		public Set<Person> getEditors() {
			return this.editors;
		}
	}

	private final DateTimeFormat format = DateTimeFormat
			.getFormat("dd.MM.yyyy, HH:mm:ss");

	private CellTable<Revision> revisionTable;
	private CellList<Person> editorList;
	private DateBox dateBoxFrom;
	private DateBox dateBoxTo;
	private Button btnFilterReset;

	private final SingleSelectionModel<Revision> revSelModel =
			new SingleSelectionModel<Revision>();
	private final MultiSelectionModel<Person> editorsSelModel =
			new MultiSelectionModel<Person>();

	private final Event<TypedEventArg<Revision>> rewindEvent =
			new Event<TypedEventArg<Revision>>();
	private final Event<RevisionControlView.RevFilterArgs> filterEvent =
			new Event<RevisionControlView.RevFilterArgs>();
	private final DefaultEvent removeFilterEvent = new DefaultEvent();

	private Model model;

	/**
	 * constructor of the RevisionControlView.
	 */
	public RevisionControlView() {

		final VerticalPanel mainPanel = new VerticalPanel();
		this.initWidget(mainPanel);
		mainPanel.setSize("800px", "500px");

		final HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(5);
		mainPanel.add(buttonPanel);

		final Button btnLoadSelected =
				new Button("Selektierte Revision zur Ansicht laden");
		btnLoadSelected.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final Revision selected =
						RevisionControlView.this.revSelModel.getSelectedObject();
				RevisionControlView.this.rewindEvent.fire(RevisionControlView.this,
						new TypedEventArg<Revision>(selected));
			}
		});
		buttonPanel.add(btnLoadSelected);

		final HTML separator = new HTML("<hr />", true);
		mainPanel.add(separator);

		final ScrollPanel RevisionScrollPanel = new ScrollPanel();
		mainPanel.add(RevisionScrollPanel);
		mainPanel.setCellHeight(RevisionScrollPanel, "100%");
		RevisionScrollPanel.setHeight("100%");

		this.revisionTable = new CellTable<Revision>();
		this.revisionTable.addColumnSortHandler(this.sortHandler);
		RevisionScrollPanel.setWidget(this.revisionTable);
		this.revisionTable.setSelectionModel(this.revSelModel);
		final Column<Revision, Date> columnTime =
				new Column<Revision, Date>(new DateCell(this.format)) {
					@Override
					public Date getValue(final Revision object) {
						return object.getRevisionDate();
					}
				};
		columnTime.setSortable(true);
		this.revisionTable.addColumn(columnTime, "Zeitpunkt");
		this.revisionTable.setColumnWidth(columnTime, "160px");

		final TextColumn<Revision> columnEditor = new TextColumn<Revision>() {
			@Override
			public String getValue(final Revision object) {
				Person editor;
				try {
					editor = object.getEditor(RevisionControlView.this.model);
				} catch (final IPScrumGeneralException e) {
					editor = null;
				}
				if (editor != null) {
					return editor.toString();
				} else {
					return "Kein Bearbeiter zugeordnet.";
				}
			}
		};
		this.revisionTable.addColumn(columnEditor, "Bearbeiter");
		this.revisionTable.setColumnWidth(columnEditor, "200px");

		final TextColumn<Revision> columnAction = new TextColumn<Revision>() {

			@Override
			public void render(final Context context, final Revision object,
					final SafeHtmlBuilder sb) {
				final String actions = object.toString();
				final String actionsHTML = actions.replaceAll("\\n", "<br />"); // Performance-Hog
				sb.appendHtmlConstant(actionsHTML);
			}

			@Override
			public String getValue(final Revision object) {
				return object.toString();
			}
		};
		this.revisionTable.addColumn(columnAction, "Aktion(en)");
		this.revisionTable.setSize("100%", "100%");

		final DisclosurePanel filterPanel = new DisclosurePanel("Filter");
		filterPanel.setAnimationEnabled(true);
		mainPanel.add(filterPanel);
		mainPanel.setCellWidth(filterPanel, "100%");
		filterPanel.setSize("100%", "");

		final HorizontalPanel filterLayoutPanel = new HorizontalPanel();
		filterLayoutPanel.setStyleName("lightBackground");
		filterLayoutPanel.setSpacing(5);
		filterPanel.setContent(filterLayoutPanel);
		filterLayoutPanel.setSize("100%", "");

		final VerticalPanel TimeFltrPanel = new VerticalPanel();
		filterLayoutPanel.add(TimeFltrPanel);

		final Label timeLabel = new Label("Zeitraum");
		timeLabel.setStyleName("bold");
		TimeFltrPanel.add(timeLabel);

		final Grid grid = new Grid(2, 2);
		TimeFltrPanel.add(grid);

		final Label lblFrom = new Label("von:");
		grid.setWidget(0, 0, lblFrom);

		this.dateBoxFrom = new DateBox();
		grid.setWidget(0, 1, this.dateBoxFrom);

		final Label lblTo = new Label("bis:");
		grid.setWidget(1, 0, lblTo);

		this.dateBoxTo = new DateBox();
		grid.setWidget(1, 1, this.dateBoxTo);

		final VerticalPanel EditorFltrPanel = new VerticalPanel();
		filterLayoutPanel.add(EditorFltrPanel);

		final Label editorLabel = new Label("Bearbeiter");
		editorLabel.setStyleName("bold");
		EditorFltrPanel.add(editorLabel);

		final ScrollPanel editorScrollPanel = new ScrollPanel();
		editorScrollPanel.setStyleName("whitebox");
		EditorFltrPanel.add(editorScrollPanel);
		editorScrollPanel.setSize("200px", "75px");

		this.editorList = new CellList<Person>(new AbstractCell<Person>() {
			@Override
			public void render(final Context context, final Person value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.toString());
			}
		});
		editorScrollPanel.setWidget(this.editorList);
		this.editorList.setSelectionModel(this.editorsSelModel);
		this.editorList.setSize("100%", "100%");

		final VerticalPanel FilterButtonFltrPanel = new VerticalPanel();
		filterLayoutPanel.add(FilterButtonFltrPanel);

		final Button btnFilter = new Button("Einträge filtern");
		btnFilter.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final Date fromDate = RevisionControlView.this.dateBoxFrom.getValue();
				final Date toDate = RevisionControlView.this.dateBoxTo.getValue();
				final Set<Person> editors =
						RevisionControlView.this.editorsSelModel.getSelectedSet();
				RevisionControlView.this.filterEvent.fire(RevisionControlView.this,
						new RevFilterArgs(fromDate, toDate, editors));
			}
		});
		FilterButtonFltrPanel.add(btnFilter);
		btnFilter.setWidth("100%");

		this.btnFilterReset = new Button("Filter zurücksetzen");
		this.btnFilterReset.setEnabled(false);
		this.btnFilterReset.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				RevisionControlView.this.removeFilterEvent
						.fire(RevisionControlView.this);
			}
		});
		FilterButtonFltrPanel.add(this.btnFilterReset);
	}

	@Override
	public void close() {
		this.filterEvent.removeAllHandler();
		this.rewindEvent.removeAllHandler();
	}

	@Override
	public void updateRevisionTable(final List<Revision> revList, final Model newModel) {
		this.model = newModel;
		this.revisionTable.setRowData(revList);
	}

	@Override
	public void updateEditorList(final List<Person> editors) {
		this.editorList.setRowData(editors);
	}

	@Override
	public void setFilterResetButtonStatus(final boolean enabled) {
		this.btnFilterReset.setEnabled(enabled);
	}

	@Override
	public EventRegistration registerFilterEventHandler(
			final EventHandler<RevisionControlView.RevFilterArgs> handler) {
		return this.filterEvent.add(handler);
	}

	@Override
	public EventRegistration registerRemoveFilterEventHandler(
			final DefaultEventHandler handler) {
		return this.removeFilterEvent.add(handler);
	}

	@Override
	public EventRegistration registerRewindEventHandler(
			final EventHandler<TypedEventArg<Revision>> handler) {
		return this.rewindEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide
	}

}
