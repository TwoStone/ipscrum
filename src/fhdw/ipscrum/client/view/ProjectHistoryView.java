package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.viewinterfaces.IProjectHistoryView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;
import fhdw.ipscrum.shared.model.nonMeta.incidents.MultipleParticipantIncident;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;

/**
 * This view class is used to represent the project history.
 * 
 * @author Phase IV - Group Reporting II
 */
public class ProjectHistoryView extends MasterView implements IProjectHistoryView {

	// ********************* VIEW ELEMENTS ****************************************
	private CellTable<Incident> projectHistoryTable;
	private Button createIncidentbtn;
	private Button createTypebutton;
	private CellList<IncidentType> typeCellList;

	// ******************** VIEW ELEMENTS ENDE ************************************

	// ********************** EVENTS **********************************************
	private final Event<EventArgs> showIncidents = new Event<EventArgs>();
	private final Event<EventArgs> createIncident = new Event<EventArgs>();
	private final Event<EventArgs> changeTyp = new Event<EventArgs>();
	private final Event<EventArgs> createType = new Event<EventArgs>();

	// ********************* END EVENTS ******************************************

	/**
	 * constructor of the ProjectHistoryView.
	 */
	public ProjectHistoryView() {
		super();

		final AbsolutePanel concreteProjectHistoryPanel = new AbsolutePanel();
		this.add(concreteProjectHistoryPanel);
		concreteProjectHistoryPanel.setSize("775px", "508px");

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		concreteProjectHistoryPanel.add(horizontalPanel_1, 10, 24);
		horizontalPanel_1.setSize("741px", "516px");

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setHeight("501px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_2.add(scrollPanel);
		scrollPanel.setSize("735px", "251px");

		this.projectHistoryTable = new CellTable<Incident>();
		this.projectHistoryTable.setFocus(false);
		this.projectHistoryTable.setTabIndex(20);
		scrollPanel.setWidget(this.projectHistoryTable);
		this.projectHistoryTable.setTableLayoutFixed(false);
		this.projectHistoryTable.setSize("100%", "100%");

		final TextColumn<Incident> timeColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(final Incident incident) {
				final DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");
				if (incident.getStart().equals(incident.getEnd())) {
					return fmt.format(incident.getStart());
				} else {
					return fmt.format(incident.getStart()) + " - " + fmt.format(incident.getEnd());
				}
			}
		};

		this.projectHistoryTable.addColumn(timeColumn, TextConstants.INCIDENT_TIME_COLUMN);

		final TextColumn<Incident> typColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(final Incident incident) {
				if (incident.getIncidentType() == null) {
					return TextConstants.EMPTY_TEXT;
				} else {
					return incident.getIncidentType().getName();
				}
			}
		};
		this.projectHistoryTable.addColumn(typColumn, TextConstants.INCIDENT_TYPE);

		final TextColumn<Incident> descriptionColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(final Incident incident) {
				if (incident.getDescription().length() <= 80) {
					return incident.getDescription();
				} else {
					return incident.getDescription().substring(0, 80) + TextConstants.POINTS;
				}
			}
		};
		this.projectHistoryTable.addColumn(descriptionColumn, TextConstants.DESCRIPTION);

		final TextColumn<Incident> personColumn = new TextColumn<Incident>() {
			@Override
			public String getValue(final Incident incident) {
				if (incident instanceof MultipleParticipantIncident) {
					return ((MultipleParticipantIncident) incident).getParticipants().toString();
				} else {
					return ((OneParticipantIncident) incident).getParticipant().toString();
				}

			}
		};
		this.projectHistoryTable.addColumn(personColumn, TextConstants.PERSROLEMNGMT_PERSONTABLE_HEADER);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("createFeatureTable");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_2.add(horizontalPanel);
		horizontalPanel.setSize("406px", "132px");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("154px", "96px");

		this.createTypebutton = new Button(TextConstants.CREATE);
		verticalPanel_1.add(this.createTypebutton);
		this.createTypebutton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectHistoryView.this.createType.fire(ProjectHistoryView.this, null);

			}
		});
		this.createTypebutton.setText(TextConstants.CREATE_TYPE);
		this.createTypebutton.setSize("138px", "35");

		this.createIncidentbtn = new Button(TextConstants.CREATE);
		verticalPanel_1.add(this.createIncidentbtn);
		this.createIncidentbtn.setSize("138px", "35");
		this.createIncidentbtn.setText(TextConstants.CREATE_INCIDENT);
		this.createIncidentbtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectHistoryView.this.createIncident.fire(ProjectHistoryView.this, null);
			}
		});

		final VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		verticalPanel.setHeight("128px");

		// Label lblFilter = new Label(TextConstants.FILTER);
		// verticalPanel.add(lblFilter);
		// lblFilter.setStyleName("LabelElement");

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		verticalPanel.add(scrollPanel_1);
		scrollPanel_1.setSize("177px", "90px");

		this.typeCellList = new CellList<IncidentType>(new AbstractCell<IncidentType>() {
			@Override
			public void render(final Context context, final IncidentType value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		scrollPanel_1.setWidget(this.typeCellList);
		this.typeCellList.setSelectionModel(new MultiSelectionModel<IncidentType>());
		this.typeCellList.setSize("165px", "85px");

		// showBtn = new Button(TextConstants.SHOW);
		// verticalPanel.add(showBtn);
		// showBtn.setWidth("89px");
		// showBtn.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// showIncidents.fire(ProjectHistoryView.this, new EventArgs());
		// }
		// });

	}

	protected CellTable<Incident> getProjectHistoryTable() {
		return this.projectHistoryTable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#refreshProjectHistoryTable(java.util .Vector)
	 */
	@Override
	public void refreshProjectHistoryTable(final List<Incident> incidents) {
		this.getProjectHistoryTable().setRowData(incidents);

		// Tooltips erzeugen
		int counter = 0;
		for (final Incident Incident : incidents) {
			final Element current = this.getProjectHistoryTable().getRowElement(counter);
			current.setTitle(Incident.getDescription());
			counter++;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#addcreateIncidentHandler(fhdw.ipscrum
	 * .client.architecture.events.EventHandler)
	 */
	@Override
	public void addcreateIncidentHandler(final DefaultEventHandler args) {
		this.createIncident.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#addcreateTypeHandler(fhdw.ipscrum.
	 * client.architecture.events.EventHandler)
	 */
	@Override
	public void addcreateTypeHandler(final EventHandler<EventArgs> args) {
		this.createType.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#addchangeTypHandler(fhdw.ipscrum.client
	 * .architecture.events.EventHandler)
	 */
	@Override
	public void addchangeTypHandler(final EventHandler<EventArgs> args) {
		this.changeTyp.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#addShowIncidentsHandler(fhdw.ipscrum
	 * .client.architecture.events.EventHandler)
	 */
	@Override
	public void addShowIncidentsHandler(final EventHandler<EventArgs> args) {
		this.showIncidents.add(args);
	}

	protected Button getBtnAnlegen() {
		return this.createIncidentbtn;
	}

	/**
	 * getter of the create button.
	 * 
	 * @return the button
	 */
	public Button getCreateTypebutton() {
		return this.createTypebutton;
	}

	protected CellList<IncidentType> getTypeCellList() {
		return this.typeCellList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#refreshTypes(java.util.Vector)
	 */
	@Override
	public void refreshTypes(final List<IncidentType> types) {
		this.getTypeCellList().setRowData(types);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProjectHistoryView#getTypes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentType> getTypes() {
		return (List<IncidentType>) ((MultiSelectionModel<IncidentType>) this.getTypeCellList().getSelectionModel())
				.getSelectedSet();
	}

	@Override
	public void close() {
		this.changeTyp.removeAllHandler();
		this.createIncident.removeAllHandler();
		this.createType.removeAllHandler();
		this.showIncidents.removeAllHandler();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getCreateIncidentbtn().setEnabled(value);
		this.getCreateTypebutton().setEnabled(value);

	}

	protected Button getCreateIncidentbtn() {
		return this.createIncidentbtn;
	}
}
