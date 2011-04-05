//package fhdw.ipscrum.client.view;
//
//import java.util.Date;
//import java.util.Set;
//import java.util.Vector;
//import com.google.gwt.cell.client.AbstractCell;
//import com.google.gwt.cell.client.DateCell;
//import com.google.gwt.dom.client.Element;
//import com.google.gwt.event.dom.client.ChangeEvent;
//import com.google.gwt.event.dom.client.ChangeHandler;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.i18n.client.DateTimeFormat;
//import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
//import com.google.gwt.user.cellview.client.CellList;
//import com.google.gwt.user.cellview.client.CellTable;
//import com.google.gwt.user.cellview.client.Column;
//import com.google.gwt.user.cellview.client.TextColumn;
//import com.google.gwt.user.client.ui.AbsolutePanel;
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.HasVerticalAlignment;
//import com.google.gwt.user.client.ui.HorizontalPanel;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.ListBox;
//import com.google.gwt.user.client.ui.ScrollPanel;
//import com.google.gwt.user.client.ui.TextArea;
//import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.VerticalPanel;
//import com.google.gwt.user.datepicker.client.DateBox;
//import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
//import com.google.gwt.view.client.MultiSelectionModel;
//import com.google.gwt.view.client.SingleSelectionModel;
//import fhdw.ipscrum.client.events.Event;
//import fhdw.ipscrum.client.events.EventArgs;
//import fhdw.ipscrum.client.events.EventHandler;
//import fhdw.ipscrum.client.view.interfaces.IProjectHistoryView;
//import fhdw.ipscrum.shared.constants.TextConstants;
//import fhdw.ipscrum.shared.model.incidents.Incident;
//import fhdw.ipscrum.shared.model.interfaces.IPerson;
//
//public class ProjectHistoryView extends Composite implements
//		IProjectHistoryView {
//
//	// ********************* VIEW ELEMENTS ****************************************
//	private CellTable<Incident> projectHistoryTable;
//	private CellList<IPerson> personCellList;
//	private Button btnAnlegen;
//	private ListBox typListBox;
//	private DateBox startdateBox;
//	private DateBox enddateBox;
//	private TextArea descriptionTextArea;
//	private Label lblName;
//	private TextBox nameTextBox;
//	private Label lblBeschreibung;
//	private Label lblPersonen;
//	private ScrollPanel scrollPanel_1;
//	// ******************** VIEW ELEMENTS ENDE ************************************
//
//	// ********************** EVENTS **********************************************
//	private final Event<EventArgs> createIncident = new Event<EventArgs>();
//	private final Event<EventArgs> changeTyp = new Event<EventArgs>();
//	// ********************* END EVENTS ******************************************
//
//	public ProjectHistoryView() {
//
//		AbsolutePanel concreteProjectHistoryPanel = new AbsolutePanel();
//		initWidget(concreteProjectHistoryPanel);
//		concreteProjectHistoryPanel.setSize("775px", "600px");
//
//		HorizontalPanel horizontalPanel = new HorizontalPanel();
//		horizontalPanel.setStyleName("createFeatureTable");
//		horizontalPanel.setSpacing(3);
//		concreteProjectHistoryPanel.add(horizontalPanel, 73, 394);
//		horizontalPanel.setSize("605px", "194px");
//
//		VerticalPanel verticalPanel = new VerticalPanel();
//		verticalPanel.setSpacing(2);
//		horizontalPanel.add(verticalPanel);
//		verticalPanel.setSize("170px", "188px");
//
//		Label lblTyp = new Label("Typ:");
//		lblTyp.setStyleName("LabelElement");
//		verticalPanel.add(lblTyp);
//		lblTyp.setSize("95%", "22px");
//
//		typListBox = new ListBox();
//		typListBox.addChangeHandler(new ChangeHandler() {
//			public void onChange(ChangeEvent event) {
//				ProjectHistoryView.this.changeTyp.fire(ProjectHistoryView.this,
//						null);
//			}
//		});
//		typListBox.addItem(TextConstants.INCIDENT_VACATION_NAME);
//		typListBox.addItem(TextConstants.INCIDENT_ILLNESS_NAME);
//		typListBox.addItem(TextConstants.INCIDENT_OTHER_ISSUE);
//		typListBox.setDirectionEstimator(false);
//		verticalPanel.add(typListBox);
//		typListBox.setSize("146px", "22px");
//		typListBox.setVisibleItemCount(1);
//
//		Label lblStartdatum = new Label(TextConstants.INCIDENT_START_DATE);
//		lblStartdatum.setStyleName("LabelElement");
//		verticalPanel.add(lblStartdatum);
//
//		startdateBox = new DateBox();
//		startdateBox.setFormat(new DefaultFormat(DateTimeFormat
//				.getFormat("dd-MM-yyyy")));
//		verticalPanel.add(startdateBox);
//
//		Label lblEndedatum = new Label(TextConstants.INCIDENT_END_DATE);
//		lblEndedatum.setStyleName("LabelElement");
//		verticalPanel.add(lblEndedatum);
//
//		enddateBox = new DateBox();
//		enddateBox.setFormat(new DefaultFormat(DateTimeFormat
//				.getFormat("dd-MM-yyyy")));
//		verticalPanel.add(enddateBox);
//
//		btnAnlegen = new Button(TextConstants.CREATE);
//		verticalPanel.add(btnAnlegen);
//		btnAnlegen.setStyleName("taskboardButton");
//		this.btnAnlegen.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				ProjectHistoryView.this.createIncident.fire(
//						ProjectHistoryView.this, null);
//			}
//		});
//
//		VerticalPanel verticalPanel_1 = new VerticalPanel();
//		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//		verticalPanel_1.setSpacing(2);
//		horizontalPanel.add(verticalPanel_1);
//		verticalPanel_1.setSize("185px", "188px");
//
//		lblPersonen = new Label(TextConstants.INCIDENT_PERSONS);
//		verticalPanel_1.add(lblPersonen);
//		lblPersonen.setStyleName("LabelElement");
//		lblPersonen.setSize("95%", "22px");
//
//		scrollPanel_1 = new ScrollPanel();
//		verticalPanel_1.add(scrollPanel_1);
//		scrollPanel_1.setStyleName("smallborder");
//		scrollPanel_1.setSize("190px", "100px");
//
//		personCellList = new CellList<IPerson>(new AbstractCell<IPerson>() {
//			@Override
//			public void render(Context context, IPerson value,
//					SafeHtmlBuilder sb) {
//				sb.appendEscaped(value.getFirstname() + TextConstants.SPACE
//						+ value.getLastname());
//			}
//		});
//		scrollPanel_1.setWidget(personCellList);
//		personCellList.setSize("172px", "95%");
//
//		VerticalPanel verticalPanel_2 = new VerticalPanel();
//		verticalPanel_2.setSpacing(2);
//		horizontalPanel.add(verticalPanel_2);
//		verticalPanel_2.setSize("185px", "188px");
//
//		lblName = new Label(TextConstants.NAME);
//		verticalPanel_2.add(lblName);
//		lblName.setStyleName("LabelElement");
//		lblName.setSize("95%", "22px");
//
//		nameTextBox = new TextBox();
//		verticalPanel_2.add(nameTextBox);
//
//		lblBeschreibung = new Label(TextConstants.SPRINTDIALOG_DESCRIPTION);
//		verticalPanel_2.add(lblBeschreibung);
//		lblBeschreibung.setStyleName("LabelElement");
//		lblBeschreibung.setSize("95%", "22px");
//
//		descriptionTextArea = new TextArea();
//		verticalPanel_2.add(descriptionTextArea);
//		descriptionTextArea.setSize("178px", "70px");
//		descriptionTextArea.setVisible(false);
//		lblBeschreibung.setVisible(false);
//		nameTextBox.setVisible(false);
//		lblName.setVisible(false);
//
//		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
//		horizontalPanel_1.setSpacing(5);
//		concreteProjectHistoryPanel.add(horizontalPanel_1, 10, 24);
//		horizontalPanel_1.setSize("760px", "364px");
//
//		ScrollPanel scrollPanel = new ScrollPanel();
//		horizontalPanel_1.add(scrollPanel);
//		scrollPanel.setSize("735px", "344px");
//
//		projectHistoryTable = new CellTable<Incident>();
//		projectHistoryTable.setFocus(false);
//		projectHistoryTable.setTabIndex(20);
//		scrollPanel.setWidget(projectHistoryTable);
//		projectHistoryTable.setTableLayoutFixed(false);
//		projectHistoryTable.setSize("100%", "100%");
//
//		Column<Incident, Date> startDateColumn = new Column<Incident, Date>(
//				new DateCell()) {
//			@Override
//			public Date getValue(Incident incident) {
//				return incident.getStart();
//			}
//		};
//		startDateColumn.setSortable(true);
//		projectHistoryTable.addColumn(startDateColumn, TextConstants.INCIDENT_START_DATE_COLUMN);
//
//		Column<Incident, Date> endDateColumn = new Column<Incident, Date>(
//				new DateCell()) {
//			@Override
//			public Date getValue(Incident incident) {
//				return incident.getEnd();
//			}
//		};
//		endDateColumn.setSortable(true);
//		projectHistoryTable.addColumn(endDateColumn, TextConstants.INCIDENT_END_DATE_COLUMN);
//
//		TextColumn<Incident> typColumn = new TextColumn<Incident>() {
//			@Override
//			public String getValue(Incident incident) {
//				return incident.getName();
//			}
//		};
//		projectHistoryTable.addColumn(typColumn, TextConstants.INCIDENT_TYPE);
//
//		TextColumn<Incident> descriptionColumn = new TextColumn<Incident>() {
//			@Override
//			public String getValue(Incident incident) {
//				if (incident.getDescription().length() <= 60) {
//					return incident.getDescription();
//				} else {
//					return incident.getDescription().substring(0, 60) + TextConstants.POINTS;
//				}
//			}
//		};
//		projectHistoryTable.addColumn(descriptionColumn, TextConstants.DESCRIPTION);
//
//		TextColumn<Incident> personColumn = new TextColumn<Incident>() {
//			@Override
//			public String getValue(Incident incident) {
//				return incident.getParticipants().toString();
//			}
//		};
//		projectHistoryTable.addColumn(personColumn, TextConstants.PERSROLEMNGMT_PERSONTABLE_HEADER);
//
//	}
//
//	protected CellTable<Incident> getProjectHistoryTable() {
//		return projectHistoryTable;
//	}
//
//	@Override
//	public void refreshProjectHistoryTable(Vector<Incident> incidents) {
//		this.getProjectHistoryTable().setRowData(incidents);
//		
//		//Tooltips erzeugen
//		int counter = 0;
//		for (Incident Incident : incidents) {
//			Element current = this.getProjectHistoryTable().getRowElement(
//					counter);
//			current.setTitle(Incident.getDescription());
//			counter++;
//		}
//
//	}
//
//	@Override
//	public void refreshPersons(Vector<IPerson> persons) {
//		this.getPersonCellList().setRowData(persons);
//		this.getPersonCellList().setSelectionModel(
//				new SingleSelectionModel<IPerson>());
//	}
//
//	@Override
//	public void addcreateIncidentHandler(EventHandler<EventArgs> args) {
//		this.createIncident.add(args);
//	}
//
//	@Override
//	public void addchangeTypHandler(EventHandler<EventArgs> args) {
//		this.changeTyp.add(args);
//	}
//
//	public CellList<IPerson> getPersonCellList() {
//		return personCellList;
//	}
//
//	protected Button getBtnAnlegen() {
//		return btnAnlegen;
//	}
//
//	protected ListBox getTypListBox() {
//		return typListBox;
//	}
//
//	protected DateBox getStartdateBox() {
//		return startdateBox;
//	}
//
//	protected DateBox getEnddateBox() {
//		return enddateBox;
//	}
//
//	protected TextArea getDescriptionTextArea() {
//		return descriptionTextArea;
//	}
//
//	@Override
//	public Date getStartDate() {
//		return this.getStartdateBox().getValue();
//	}
//
//	@Override
//	public Date getEndDate() {
//		return this.getEnddateBox().getValue();
//	}
//
//	@Override
//	public String getDescriptionText() {
//		return this.getDescriptionTextArea().getValue();
//	}
//
//	@Override
//	public String getName() {
//		return this.getNameTextBox().getValue();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public IPerson getPerson() {
//		return ((SingleSelectionModel<IPerson>) this.getPersonCellList()
//				.getSelectionModel()).getSelectedObject();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public Set<IPerson> getPersons() {
//		return ((MultiSelectionModel<IPerson>) this.getPersonCellList()
//				.getSelectionModel()).getSelectedSet();
//	}
//
//	protected Label getLblName() {
//		return lblName;
//	}
//
//	protected TextBox getNameTextBox() {
//		return nameTextBox;
//	}
//
//	protected Label getLblBeschreibung() {
//		return lblBeschreibung;
//	}
//
//	protected Label getLblPersonen() {
//		return lblPersonen;
//	}
//
//	protected ScrollPanel getScrollPanel_1() {
//		return scrollPanel_1;
//	}
//
//	@Override
//	public void getOtherIssueView() {
//		getDescriptionTextArea().setText(TextConstants.EMPTY_TEXT);
//		getDescriptionTextArea().setVisible(true);
//		getLblBeschreibung().setVisible(true);
//		getLblName().setVisible(true);
//		getNameTextBox().setText(TextConstants.EMPTY_TEXT);
//		getNameTextBox().setVisible(true);
//		getEnddateBox().setValue(null);
//		getStartdateBox().setValue(null);
//		this.getPersonCellList().setSelectionModel(
//				new MultiSelectionModel<IPerson>());
//	}
//
//	@Override
//	public void getNormalView() {
//		getDescriptionTextArea().setVisible(false);
//		getLblBeschreibung().setVisible(false);
//		getLblName().setVisible(false);
//		getNameTextBox().setVisible(false);
//		getEnddateBox().setValue(null);
//		getStartdateBox().setValue(null);
//		this.getPersonCellList().setSelectionModel(
//				new SingleSelectionModel<IPerson>());
//	}
//	@Override
//	public void initializeView() {
//		getTypListBox().setItemSelected(0, true);
//	}
//    @Override
//	public String getType() {
//		return getTypListBox().getItemText(getTypListBox().getSelectedIndex());
//	}
//}