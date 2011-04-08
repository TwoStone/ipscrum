package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateIncidentView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * This class is used to create the {@link CreateIncidentView}.
 * 
 * @author Phase IV - Group Reporting II
 */
public class CreateIncidentView extends Composite implements
		ICreateIncidentView {

	// Events
	private final Event<EventArgs> createIncident = new Event<EventArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	// Events Ende

	private TextArea descriptionArea;
	private DateBox endDateBox;
	private Button createBtn;
	private DateBox startDateBox;
	private CellList<IncidentType> typeCellList;
	private CellList<IPerson> personCellList;
	private CellList<Project> projectsCellList;

	public CreateIncidentView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("createFeatureTable");
		horizontalPanel.setSpacing(3);
		initWidget(horizontalPanel);
		horizontalPanel.setSize("644px", "234px");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(2);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("180px", "223px");

		Label lblNeuesEreignisAnlegen = new Label(TextConstants.CREATE_NEW_INCIDENT);
		lblNeuesEreignisAnlegen.setStyleName("bold");
		verticalPanel.add(lblNeuesEreignisAnlegen);
		lblNeuesEreignisAnlegen.setSize("185px", "28px");

		createBtn = new Button(TextConstants.CREATE);
		createBtn.setText(TextConstants.CREATE_INCIDENT);
		createBtn.setStyleName("taskboardButton");
		createBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				createIncident.fire(CreateIncidentView.this, new EventArgs());
			}
		});

		Label label_5 = new Label(TextConstants.INCIDENT_START_DATE);
		verticalPanel.add(label_5);
		label_5.setStyleName("TreeItem-leaf");

		startDateBox = new DateBox();
		verticalPanel.add(startDateBox);
		startDateBox.setWidth("155");

		Label label_6 = new Label(TextConstants.INCIDENT_END_DATE);
		verticalPanel.add(label_6);
		label_6.setStyleName("TreeItem-leaf");

		endDateBox = new DateBox();
		verticalPanel.add(endDateBox);
		endDateBox.setWidth("155");
		verticalPanel.add(createBtn);
		createBtn.setWidth("137px");

		Button cancelBtn = new Button(TextConstants.ABORT);
		cancelBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				CreateIncidentView.this.cancelEvent.fire(
						CreateIncidentView.this, new EventArgs());
			}
		});
		cancelBtn.setStyleName("taskboardButton");
		verticalPanel.add(cancelBtn);
		cancelBtn.setWidth("137px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setHeight("223px");

		Label label_1 = new Label(TextConstants.TYPE);
		verticalPanel_1.add(label_1);
		label_1.setStyleName("TreeItem-leaf");
		label_1.setSize("95%", "22px");

		ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_1.add(scrollPanel);
		scrollPanel.setStyleName("smallborderWithWhiteBG");
		scrollPanel.setSize("183px", "70px");

		typeCellList = new CellList<IncidentType>(
				new AbstractCell<IncidentType>() {
					@Override
					public void render(Context context, IncidentType value,
							SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getName());
					}
				});
		scrollPanel.setWidget(typeCellList);
		typeCellList.setSize("161px", "60px");
		typeCellList
				.setSelectionModel(new SingleSelectionModel<IncidentType>());

		Label label_2 = new Label(TextConstants.SPRINTDIALOG_DESCRIPTION);
		verticalPanel_1.add(label_2);
		label_2.setStyleName("TreeItem-leaf");
		label_2.setSize("95%", "22px");

		descriptionArea = new TextArea();
		verticalPanel_1.add(descriptionArea);
		descriptionArea.setSize("183px", "70px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setSpacing(2);
		horizontalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("205px", "223px");

		Label label_4 = new Label(TextConstants.INCIDENT_PERSONS);
		label_4.setStyleName("TreeItem-leaf");
		verticalPanel_2.add(label_4);
		label_4.setSize("95%", "22px");

		ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setStyleName("smallborderWithWhiteBG");
		verticalPanel_2.add(scrollPanel_2);
		scrollPanel_2.setSize("183px", "70px");

		personCellList = new CellList<IPerson>(new AbstractCell<IPerson>() {
			@Override
			public void render(Context context, IPerson value,
					SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getFirstname() + TextConstants.SPACE
						+ value.getLastname());
			}
		});
		scrollPanel_2.setWidget(personCellList);
		personCellList.setSize("161px", "60px");
		personCellList.setSelectionModel(new MultiSelectionModel<IPerson>());

		Label label_3 = new Label(TextConstants.PROJECTS);
		verticalPanel_2.add(label_3);
		label_3.setStyleName("TreeItem-leaf");

		ScrollPanel scrollPanel_1 = new ScrollPanel();
		verticalPanel_2.add(scrollPanel_1);
		scrollPanel_1.setStyleName("smallborderWithWhiteBG");
		scrollPanel_1.setSize("183px", "70px");

		projectsCellList = new CellList<Project>(new AbstractCell<Project>() {
			@Override
			public void render(Context context, Project value,
					SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		scrollPanel_1.setWidget(projectsCellList);
		projectsCellList.setSize("161px", "60px");
		projectsCellList.setSelectionModel(new MultiSelectionModel<Project>());
	}

	protected TextArea getDescriptionArea() {
		return descriptionArea;
	}

	protected DateBox getEndDateBox() {
		return endDateBox;
	}

	protected Button getCreateBtn() {
		return createBtn;
	}

	protected DateBox getStartDateBox() {
		return startDateBox;
	}

	protected CellList<IncidentType> getTypeCellList() {
		return typeCellList;
	}

	protected CellList<IPerson> getPersonCellList() {
		return personCellList;
	}

	protected CellList<Project> getProjectsCellList() {
		return projectsCellList;
	}

	@Override
	public void refreshTypes(Vector<IncidentType> types) {
		this.getTypeCellList().setRowData(types);
	}

	@Override
	public void refreshPersons(Vector<IPerson> persons) {
		this.getPersonCellList().setRowData(persons);
	}

	@Override
	public void refreshProjects(Vector<Project> projects) {
		this.getProjectsCellList().setRowData(projects);
	}

	@Override
	public Date getEndDate() {
		return this.getEndDateBox().getValue();
	}

	@Override
	public Date getStartDate() {
		return this.getStartDateBox().getValue();
	}

	@Override
	public String getDescription() {
		return this.getDescriptionArea().getValue();
	}

	@Override
	public void addCreateIncidentHandler(EventHandler<EventArgs> args) {
		this.createIncident.add(args);

	}

	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<IPerson> getPersons() {
		return ((MultiSelectionModel<IPerson>) this.getPersonCellList()
				.getSelectionModel()).getSelectedSet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Project> getProjects() {
		return ((MultiSelectionModel<Project>) this.getProjectsCellList()
				.getSelectionModel()).getSelectedSet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IncidentType getType() {
		return ((SingleSelectionModel<IncidentType>) this.typeCellList
				.getSelectionModel()).getSelectedObject();
	}
}
