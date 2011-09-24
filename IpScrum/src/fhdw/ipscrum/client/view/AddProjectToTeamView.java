package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.viewinterfaces.IAddProjectToTeamView;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * represents the view in which a project could be added to a team.
 */
public class AddProjectToTeamView extends MasterView implements IAddProjectToTeamView {
	private final CellList<Project> projectsToAdd;
	private final CellList<Project> addedProjects;
	private final Event<TypedEventArg<Project>> addProject = new Event<TypedEventArg<Project>>();
	private final SingleSelectionModel<Project> selModel = new SingleSelectionModel<Project>();

	/**
	 * constructor of the AddProjectToteamView.
	 */
	public AddProjectToTeamView() {
		super();

		final VerticalPanel horizontalPanel = new VerticalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setSpacing(5);
		this.add(horizontalPanel);
		horizontalPanel.setSize("500px", "300px");

		final Label lblHeader = new Label("Projekte zuordnen");
		lblHeader.setStyleName("LabelElement");
		horizontalPanel.add(lblHeader);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("400px", "250px");

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.add(verticalPanel);
		verticalPanel.setSize("200px", "250px");

		final Label lblNewLabel = new Label("Zugeordnete Projekte");
		verticalPanel.add(lblNewLabel);
		lblNewLabel.setHeight("20px");

		this.addedProjects = new CellList<Project>(new AbstractCell<Project>() {
			@Override
			public void render(final Context context, final Project value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		this.addedProjects.setStyleName("tableBorder");
		verticalPanel.add(this.addedProjects);
		this.addedProjects.setSize("200px", "230px");

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_2.setSize("90%", "90%");

		final Button btnAdd = new Button("<-");
		verticalPanel_2.add(btnAdd);
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				AddProjectToTeamView.this.addProject.fire(AddProjectToTeamView.this, new TypedEventArg<Project>(
						AddProjectToTeamView.this.selModel.getSelectedObject()));

			}
		});

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.add(verticalPanel_1);
		verticalPanel_1.setSize("200px", "250px");

		final Label lblNewLabel_1 = new Label("Verfügbare Projekte");
		verticalPanel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHeight("20px");

		this.projectsToAdd = new CellList<Project>(new AbstractCell<Project>() {
			@Override
			public void render(final Context context, final Project value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		this.projectsToAdd.setStyleName("tableBorder");
		verticalPanel_1.add(this.projectsToAdd);
		this.projectsToAdd.setSize("200px", "230px");
		this.projectsToAdd.setSelectionModel(this.selModel);
	}

	private CellList<Project> getProjectsToAdd() {
		return this.projectsToAdd;
	}

	private CellList<Project> getAddedProjects() {
		return this.addedProjects;
	}

	@Override
	public void close() {
		this.addProject.removeAllHandler();

	}

	@Override
	public void setAddedProjects(final List<Project> projects) {
		if (projects != null) {
			this.getAddedProjects().setRowData(projects);
		}
	}

	@Override
	public void setProjectsToAdd(final List<Project> projects) {
		if (projects != null) {
			this.getProjectsToAdd().setRowData(projects);
		}
	}

	@Override
	public void registerDeleteProject(final EventHandler<TypedEventArg<Project>> handler) {
		this.addProject.add(handler);

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
