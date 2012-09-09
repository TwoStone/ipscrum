package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.viewinterfaces.ICreateIncidentView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;

/**
 * This class is used to create the {@link CreateIncidentView}.
 * 
 * @author Phase IV - Group Reporting II
 */
public class CreateIncidentView extends MasterView implements ICreateIncidentView {

	// Events
	private final DefaultEvent createIncident = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	// Events Ende

	private final TextArea descriptionArea;
	private final DateBox endDateBox;
	private final Button createBtn;
	private final DateBox startDateBox;
	private final CellList<IncidentType> typeCellList;
	private final CellList<Person> personCellList;
	private final CellList<Project> projectsCellList;
	private final MultiSelectionModel<Person> selModelPersons;
	private final MultiSelectionModel<Project> selModelProjects;

	/**
	 * constructor of the CreateIncidentView.
	 */
	public CreateIncidentView() {
		super();

		this.selModelPersons = new MultiSelectionModel<Person>();
		this.selModelProjects = new MultiSelectionModel<Project>();

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(3);
		this.add(horizontalPanel);
		horizontalPanel.setSize("644px", "234px");

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(2);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("180px", "223px");

		final HTML header = new HTML("<h3>Neues Ereignis erstellen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		this.createBtn = new Button(TextConstants.CREATE);
		this.createBtn.setText(TextConstants.CREATE_INCIDENT);
		this.createBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				CreateIncidentView.this.createIncident.fire(CreateIncidentView.this);
			}
		});

		final Label label_5 = new Label(TextConstants.INCIDENT_START_DATE);
		verticalPanel.add(label_5);

		this.startDateBox = new DateBox();
		verticalPanel.add(this.startDateBox);
		this.startDateBox.setWidth("155");

		final Label label_6 = new Label(TextConstants.INCIDENT_END_DATE);
		verticalPanel.add(label_6);

		this.endDateBox = new DateBox();
		verticalPanel.add(this.endDateBox);
		this.endDateBox.setWidth("155");
		verticalPanel.add(this.createBtn);
		this.createBtn.setWidth("137px");

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				CreateIncidentView.this.abortEvent.fire(CreateIncidentView.this);
			}
		});

		verticalPanel.add(abortButton);
		abortButton.setWidth("137px");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setHeight("223px");

		final Label label_1 = new Label(TextConstants.TYPE);
		verticalPanel_1.add(label_1);
		label_1.setSize("95%", "22px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_1.add(scrollPanel);
		scrollPanel.setSize("183px", "70px");
		scrollPanel.setStyleName("smallborderWithWhiteBG");

		this.typeCellList = new CellList<IncidentType>(new AbstractCell<IncidentType>() {
			@Override
			public void render(final Context context, final IncidentType value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		scrollPanel.setWidget(this.typeCellList);
		this.typeCellList.setSize("161px", "60px");
		this.typeCellList.setSelectionModel(new SingleSelectionModel<IncidentType>());

		final Label label_2 = new Label(TextConstants.SPRINTDIALOG_DESCRIPTION);
		verticalPanel_1.add(label_2);
		label_2.setSize("95%", "22px");

		this.descriptionArea = new TextArea();
		verticalPanel_1.add(this.descriptionArea);
		this.descriptionArea.setSize("183px", "70px");

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setSpacing(2);
		horizontalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("205px", "223px");

		final Label label_4 = new Label(TextConstants.INCIDENT_PERSONS);
		verticalPanel_2.add(label_4);
		label_4.setSize("95%", "22px");

		final ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setStyleName("smallborderWithWhiteBG");
		verticalPanel_2.add(scrollPanel_2);
		scrollPanel_2.setSize("183px", "70px");

		this.personCellList = new CellList<Person>(new AbstractCell<Person>() {
			@Override
			public void render(final Context context, final Person value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getFirstname() + TextConstants.SPACE + value.getLastname());
			}
		});
		scrollPanel_2.setWidget(this.personCellList);
		this.personCellList.setSize("161px", "60px");
		this.personCellList.setSelectionModel(this.selModelPersons);

		final Label label_3 = new Label(TextConstants.PROJECTS);
		verticalPanel_2.add(label_3);

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setStyleName("smallborderWithWhiteBG");
		verticalPanel_2.add(scrollPanel_1);
		scrollPanel_1.setSize("183px", "70px");

		this.projectsCellList = new CellList<Project>(new AbstractCell<Project>() {
			@Override
			public void render(final Context context, final Project value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		scrollPanel_1.setWidget(this.projectsCellList);
		this.projectsCellList.setSize("161px", "60px");
		this.projectsCellList.setSelectionModel(this.selModelProjects);
	}

	protected TextArea getDescriptionArea() {
		return this.descriptionArea;
	}

	protected DateBox getEndDateBox() {
		return this.endDateBox;
	}

	protected Button getCreateBtn() {
		return this.createBtn;
	}

	protected DateBox getStartDateBox() {
		return this.startDateBox;
	}

	protected CellList<IncidentType> getTypeCellList() {
		return this.typeCellList;
	}

	protected CellList<Person> getPersonCellList() {
		return this.personCellList;
	}

	protected CellList<Project> getProjectsCellList() {
		return this.projectsCellList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#refreshTypes(java.util.List)
	 */
	@Override
	public void refreshTypes(final List<IncidentType> types) {
		this.getTypeCellList().setRowData(types);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#refreshPersons(java.util.List)
	 */
	@Override
	public void refreshPersons(final List<Person> persons) {
		this.getPersonCellList().setRowData(persons);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#refreshProjects(java.util.List)
	 */
	@Override
	public void refreshProjects(final List<Project> projects) {
		this.getProjectsCellList().setRowData(projects);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		return this.getEndDateBox().getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		return this.getStartDateBox().getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.getDescriptionArea().getValue();
	}

	@Override
	public EventRegistration registerSave(final DefaultEventHandler handler) {
		return this.createIncident.add(handler);
	}

	@Override
	public EventRegistration registetAbort(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getPersons()
	 */
	@Override
	public List<Person> getPersons() {
		final List<Person> personList = new ArrayList<Person>();
		personList.addAll(this.selModelPersons.getSelectedSet());
		return personList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getProjects()
	 */
	@Override
	public List<Project> getProjects() {
		final List<Project> projectList = new ArrayList<Project>();
		projectList.addAll(this.selModelProjects.getSelectedSet());
		return projectList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#getType()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public IncidentType getType() {
		return ((SingleSelectionModel<IncidentType>) this.typeCellList.getSelectionModel()).getSelectedObject();
	}

	@Override
	public void close() {
		this.abortEvent.removeAllHandler();
		this.createIncident.removeAllHandler();

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
