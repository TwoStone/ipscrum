package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.dom.client.Element;
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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.IProjectHistoryView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.incidents.MultipleParticipantIncident;
import fhdw.ipscrum.shared.model.incidents.OneParticipantIncident;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class ProjectHistoryView extends Composite implements
		IProjectHistoryView {

	// ********************* VIEW ELEMENTS ****************************************
	private CellTable<Incident> projectHistoryTable;
	private Button createIncidentbtn;
	private Button createTypebutton;
	private CellList<IncidentType> typeCellList;
	private Button showBtn;
	// ******************** VIEW ELEMENTS ENDE ************************************

	// ********************** EVENTS **********************************************
	private final Event<EventArgs> showIncidents = new Event<EventArgs>();
	private final Event<EventArgs> createIncident = new Event<EventArgs>();
	private final Event<EventArgs> changeTyp = new Event<EventArgs>();
	private final Event<EventArgs> createType = new Event<EventArgs>();
	// ********************* END EVENTS ******************************************

	public ProjectHistoryView() {

		AbsolutePanel concreteProjectHistoryPanel = new AbsolutePanel();
		initWidget(concreteProjectHistoryPanel);
		concreteProjectHistoryPanel.setSize("775px", "600px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		concreteProjectHistoryPanel.add(horizontalPanel_1, 10, 24);
		horizontalPanel_1.setSize("760px", "566px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setHeight("553px");

		ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_2.add(scrollPanel);
		scrollPanel.setSize("735px", "392px");

		projectHistoryTable = new CellTable<Incident>();
		projectHistoryTable.setFocus(false);
		projectHistoryTable.setTabIndex(20);
		scrollPanel.setWidget(projectHistoryTable);
		projectHistoryTable.setTableLayoutFixed(false);
		projectHistoryTable.setSize("100%", "100%");

		TextColumn<Incident> startDateColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
				return fmt.format(incident.getStart());
			}
		};
		startDateColumn.setSortable(true);

		projectHistoryTable.addColumn(startDateColumn, "Start-Datum");

		TextColumn<Incident> endDateColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
				return fmt.format(incident.getEnd());
			}
		};
		endDateColumn.setSortable(true);
		projectHistoryTable.addColumn(endDateColumn,
				TextConstants.INCIDENT_END_DATE_COLUMN);

		TextColumn<Incident> typColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				if (incident.getIncidentType() == null) { 
					return TextConstants.EMPTY_TEXT; 
					} else { 
						return incident.getIncidentType().getName();
					} 
			}
		};
		projectHistoryTable.addColumn(typColumn, TextConstants.INCIDENT_TYPE);

		TextColumn<Incident> descriptionColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				 if (incident.getDescription().length() <= 80) {
				 return incident.getDescription();
				 } else {
				 return incident.getDescription().substring(0, 80) + TextConstants.POINTS;
				 }
			}
		};
		projectHistoryTable.addColumn(descriptionColumn,
				TextConstants.DESCRIPTION);

		TextColumn<Incident> personColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(Incident incident) {
				if (incident instanceof MultipleParticipantIncident) {
					return ((MultipleParticipantIncident) incident)
							.getParticipants().toString();
				} else {
					return ((OneParticipantIncident) incident).getParticipant()
							.toString();
				}

			}
		};
		projectHistoryTable.addColumn(personColumn,
				TextConstants.PERSROLEMNGMT_PERSONTABLE_HEADER);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("createFeatureTable");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_2.add(horizontalPanel);
		horizontalPanel.setSize("406px", "117px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("154px", "96px");
		
				createTypebutton = new Button("Anlegen");
				verticalPanel_1.add(createTypebutton);
				createTypebutton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						ProjectHistoryView.this.createType.fire(
								ProjectHistoryView.this, null);

					}
				});
				createTypebutton.setText("Typ Anlegen");
				createTypebutton.setStyleName("taskboardButton");
				createTypebutton.setSize("138px", "35");

		createIncidentbtn = new Button(TextConstants.CREATE);
		verticalPanel_1.add(createIncidentbtn);
		createIncidentbtn.setSize("138px", "35");
		createIncidentbtn.setText("Ereignis Anlegen");
		createIncidentbtn.setStyleName("taskboardButton");
		this.createIncidentbtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ProjectHistoryView.this.createIncident.fire(
						ProjectHistoryView.this, null);
			}
		});

		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		verticalPanel.setHeight("157px");

		Label lblFilter = new Label("Filter:");
		verticalPanel.add(lblFilter);
		lblFilter.setStyleName("LabelElement");

		ScrollPanel scrollPanel_1 = new ScrollPanel();
		verticalPanel.add(scrollPanel_1);
		scrollPanel_1.setStyleName("smallborderWithWhiteBG");
		scrollPanel_1.setSize("177px", "90px");

		typeCellList = new CellList<IncidentType>(
				new AbstractCell<IncidentType>() {
					@Override
					public void render(Context context, IncidentType value,
							SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getName());
					}
				});
		scrollPanel_1.setWidget(typeCellList);
		typeCellList.setSelectionModel(new MultiSelectionModel<IncidentType>());
		typeCellList.setSize("165px", "85px");

		showBtn = new Button("Anzeigen");
		showBtn.setStyleName("taskboardButton");
		verticalPanel.add(showBtn);
		showBtn.setWidth("89px");
		showBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				showIncidents.fire(ProjectHistoryView.this, new EventArgs());
			}
		});

	}

	protected CellTable<Incident> getProjectHistoryTable() {
		return projectHistoryTable;
	}

	@Override
	public void refreshProjectHistoryTable(Vector<Incident> incidents) {
		this.getProjectHistoryTable().setRowData(incidents);

		 //Tooltips erzeugen
		 int counter = 0;
		 for (Incident Incident : incidents) {
		 Element current = this.getProjectHistoryTable().getRowElement(
		 counter);
		 current.setTitle(Incident.getDescription());
		 counter++;
		 }

	}

	@Override
	public void addcreateIncidentHandler(EventHandler<EventArgs> args) {
		this.createIncident.add(args);
	}

	@Override
	public void addcreateTypeHandler(EventHandler<EventArgs> args) {
		this.createType.add(args);
	}

	@Override
	public void addchangeTypHandler(EventHandler<EventArgs> args) {
		this.changeTyp.add(args);
	}

	@Override
	public void addShowIncidentsHandler(EventHandler<EventArgs> args) {
		this.showIncidents.add(args);
	}

	protected Button getBtnAnlegen() {
		return createIncidentbtn;
	}

	public Button getCreateTypebutton() {
		return createTypebutton;
	}

	protected CellList<IncidentType> getTypeCellList() {
		return typeCellList;
	}

	@Override
	public void refreshTypes(Vector<IncidentType> types) {
		this.getTypeCellList().setRowData(types);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<IncidentType> getTypes() {
		return ((MultiSelectionModel<IncidentType>) this.getTypeCellList()
				.getSelectionModel()).getSelectedSet();
	}

	public Button getShowBtn() {
		return showBtn;
	}
}