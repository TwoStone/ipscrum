package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.Vector;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.view.client.SingleSelectionModel;
import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.IncidentDetailArgs;
import fhdw.ipscrum.client.view.interfaces.IProjectHistoryView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.TextBox;

public class ProjectHistoryView extends Composite implements IProjectHistoryView{
	private CellTable<Incident> projectHistoryTable;
	private CellList<IPerson> personCellList;
	private Button btnAnlegen;
	private ListBox typListBox;
	private DateBox startdateBox;
	private DateBox enddateBox;
	private TextArea descriptionTextArea;
	
	private final Event<IncidentDetailArgs> createIncident = new Event<IncidentDetailArgs>();
	private final Event<IncidentDetailArgs> changeTyp = new Event<IncidentDetailArgs>();
	private Label lblName;
	private TextBox nameTextBox;
	private Label lblBeschreibung;
	private Label lblPersonen;
	private ScrollPanel scrollPanel_1;
	
	public ProjectHistoryView() {
		
		AbsolutePanel concreteProjectHistoryPanel = new AbsolutePanel();
		initWidget(concreteProjectHistoryPanel);
		concreteProjectHistoryPanel.setSize("775px", "600px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("createFeatureTable");
		horizontalPanel.setSpacing(3);
		concreteProjectHistoryPanel.add(horizontalPanel, 73, 394);
		horizontalPanel.setSize("562px", "194px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(2);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("170px", "188px");
		
		Label lblTyp = new Label("Typ:");
		lblTyp.setStyleName("LabelElement");
		verticalPanel.add(lblTyp);
		lblTyp.setSize("95%", "22px");
		
		typListBox = new ListBox();
		typListBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				IncidentDetailArgs incidentDetails = new IncidentDetailArgs(ProjectHistoryView.this.typListBox.getItemText(ProjectHistoryView.this.typListBox.getSelectedIndex()));
				ProjectHistoryView.this.changeTyp.fire(ProjectHistoryView.this, incidentDetails);
			}
		});
		typListBox.addItem(TextConstants.INCIDENT_VACATION_NAME);
		typListBox.addItem(TextConstants.INCIDENT_ILLNESS_NAME);
		typListBox.addItem("Sonstiges Ereignis");
		typListBox.setDirectionEstimator(false);
		verticalPanel.add(typListBox);
		typListBox.setSize("146px", "22px");
		typListBox.setVisibleItemCount(1);
		
		Label lblStartdatum = new Label("Start-Datum:");
		lblStartdatum.setStyleName("LabelElement");
		verticalPanel.add(lblStartdatum);
		
		startdateBox = new DateBox();
		startdateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		verticalPanel.add(startdateBox);
		
		Label lblEndedatum = new Label("Ende-Datum:");
		lblEndedatum.setStyleName("LabelElement");
		verticalPanel.add(lblEndedatum);
		
		enddateBox = new DateBox();
		enddateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		verticalPanel.add(enddateBox);
		
		
		
		btnAnlegen = new Button("Anlegen");
		verticalPanel.add(btnAnlegen);
		btnAnlegen.setStyleName("taskboardButton");
		this.btnAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				IncidentDetailArgs incidentDetails = new IncidentDetailArgs(ProjectHistoryView.this.typListBox.getItemText(ProjectHistoryView.this.typListBox.getSelectedIndex()));
				ProjectHistoryView.this.createIncident.fire(ProjectHistoryView.this, incidentDetails);
			}
		});
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setSpacing(2);
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("193px", "185px");
		
		lblPersonen = new Label("Personen:");
		verticalPanel_1.add(lblPersonen);
		lblPersonen.setStyleName("LabelElement");
		lblPersonen.setSize("95%", "22px");
		
		scrollPanel_1 = new ScrollPanel();
		verticalPanel_1.add(scrollPanel_1);
		scrollPanel_1.setStyleName("smallborder");
		scrollPanel_1.setSize("187px", "100px");
		
		personCellList = new CellList<IPerson>(new AbstractCell<IPerson>(){
			@Override
			public void render(Context context, IPerson value, SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getFirstname() + " " + value.getLastname());
			}
		});
		scrollPanel_1.setWidget(personCellList);
		personCellList.setSize("172px", "95%");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setSpacing(2);
		horizontalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("185px", "185px");
		
		lblName = new Label("Name:");
		verticalPanel_2.add(lblName);
		lblName.setStyleName("LabelElement");
		lblName.setSize("95%", "22px");
		
		nameTextBox = new TextBox();
		verticalPanel_2.add(nameTextBox);
		
		lblBeschreibung = new Label("Beschreibung:");
		verticalPanel_2.add(lblBeschreibung);
		lblBeschreibung.setStyleName("LabelElement");
		lblBeschreibung.setSize("95%", "22px");
		
		descriptionTextArea = new TextArea();
		verticalPanel_2.add(descriptionTextArea);
		descriptionTextArea.setSize("178px", "70px");
		descriptionTextArea.setVisible(false);
		lblBeschreibung.setVisible(false);
		nameTextBox.setVisible(false);
		lblName.setVisible(false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		concreteProjectHistoryPanel.add(horizontalPanel_1, 10, 24);
		horizontalPanel_1.setSize("760px", "364px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		horizontalPanel_1.add(scrollPanel);
		scrollPanel.setSize("735px", "344px");
		
		projectHistoryTable = new CellTable<Incident>();
		projectHistoryTable.setFocus(false);
		projectHistoryTable.setTabIndex(20);
		scrollPanel.setWidget(projectHistoryTable);
		projectHistoryTable.setTableLayoutFixed(false);
		projectHistoryTable.setSize("100%", "100%");
		
		Column<Incident, Date> startDateColumn = new Column<Incident, Date>(new DateCell()) {
			@Override
			public Date getValue(Incident incident) {
				return incident.getStart();
			}
		};
		projectHistoryTable.addColumn(startDateColumn, "Start-Datum");
		
		Column<Incident, Date> endDateColumn = new Column<Incident, Date>(new DateCell()) {
			@Override
			public Date getValue(Incident incident) {
				return incident.getEnd();
			}
		};
		projectHistoryTable.addColumn(endDateColumn, "Ende-Datum");
		
		TextColumn<Incident> typColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				return incident.getName();
			}
		};
		projectHistoryTable.addColumn(typColumn, "Typ");
		
		TextColumn<Incident> descriptionColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				return incident.getDescription();
			}
		};
		projectHistoryTable.addColumn(descriptionColumn, "Beschreibung");
		
		TextColumn<Incident> personColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				return incident.getParticipants().toString();
			}
		};
		projectHistoryTable.addColumn(personColumn, "Personen");

	}
	protected CellTable<Incident> getProjectHistoryTable() {
		return projectHistoryTable;
	}
	@Override
	public void refreshProjectHistoryTable(Vector<Incident> incidents) {
		this.getProjectHistoryTable().setRowData(incidents);
	}
	
	@Override
	public void refreshPersons(Vector<IPerson> persons){
		this.getPersonCellList().setRowData(persons);
		this.getPersonCellList().setSelectionModel(new SingleSelectionModel<IPerson>());
	}
	
	@Override
	public void addcreateIncidentHandler(EventHandler<IncidentDetailArgs> args) {
		this.createIncident.add(args);
	}
	
	@Override
	public void addchangeTypHandler(EventHandler<IncidentDetailArgs> args) {
		this.changeTyp.add(args);
	}
	
	
	public CellList<IPerson> getPersonCellList() {
		return personCellList;
	}
	protected Button getBtnAnlegen() {
		return btnAnlegen;
	}
	protected ListBox getTypListBox() {
		return typListBox;
	}
	protected DateBox getStartdateBox() {
		return startdateBox;
	}
	protected DateBox getEnddateBox() {
		return enddateBox;
	}
	protected TextArea getDescriptionTextArea() {
		return descriptionTextArea;
	}

	@Override
	public Date getStartDate() {
		return this.getStartdateBox().getValue();
	}
	@Override
	public Date getEndDate() {
		return this.getEnddateBox().getValue();
	}
	@Override
	public String getDescriptionText() {
		return this.getDescriptionTextArea().getValue();
	}
	@Override
	public String getName() {
		return this.getNameTextBox().getValue();
	}



	@SuppressWarnings("unchecked")
	@Override
	public IPerson getPerson() {
		return ((SingleSelectionModel<IPerson>)this.getPersonCellList().getSelectionModel()).getSelectedObject();
	}
	protected Label getLblName() {
		return lblName;
	}
	protected TextBox getNameTextBox() {
		return nameTextBox;
	}
	protected Label getLblBeschreibung() {
		return lblBeschreibung;
	}
	protected Label getLblPersonen() {
		return lblPersonen;
	}
	protected ScrollPanel getScrollPanel_1() {
		return scrollPanel_1;
	}
	
	@Override
	public void getOtherIssueView(){
	getDescriptionTextArea().setVisible(true);
	getLblBeschreibung().setVisible(true);
	getLblName().setVisible(true);
	getNameTextBox().setVisible(true);
	getLblPersonen().setVisible(false);
	getPersonCellList().setVisible(false);
	getScrollPanel_1().setVisible(false);
}
	@Override
	public void getNormalView(){
		getDescriptionTextArea().setVisible(false);
		getLblBeschreibung().setVisible(false);
		getLblName().setVisible(false);
		getNameTextBox().setVisible(false);
		getLblPersonen().setVisible(true);
		getPersonCellList().setVisible(true);
		getScrollPanel_1().setVisible(true);
}
}