package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.Project;

/**
 * This view class is used to represent projects.
 * 
 * @author Phase II / Gruppe I
 */
public class ProjectView extends Composite implements IProjectView {

	// ####### Events ###############

	private final Event<EventArgs> newProjectEvent = new Event<EventArgs>();
	private final Event<ProjectEventArgs> deleteProjectEvent = new Event<ProjectEventArgs>();
	private final Event<ProjectEventArgs> projectSelectionEvent = new Event<ProjectEventArgs>();
	private final Event<ProjectEventArgs> editProjectEvent = new Event<ProjectEventArgs>();
	// ##### Ende ##################

	// ##### Temporäre Daten ########
	private Project currentlySelected;
	// #############################

	private Image imgNewProject;
	private Image imgDeleteProject;
	private FlowPanel masterSprintProductBackloglPanel;
	private FlowPanel masterReleasePanel;
	private CellTable<Project> tableProject;
	private FlowPanel masterSprintPanel;
	private FlowPanel masterProductBacklogPanel;
	private FlowPanel masterProjectPanel;

	public static IProjectView createView() {
		return new ProjectView();
	}

	public ProjectView() {

		final AbsolutePanel absolutePanel = new AbsolutePanel();
		this.initWidget(absolutePanel);
		absolutePanel.setSize("1000px", "600px");

		this.masterSprintProductBackloglPanel = new FlowPanel();
		absolutePanel.add(this.masterSprintProductBackloglPanel, 400, 0);
		this.masterSprintProductBackloglPanel.setSize("600px", "600px");

		this.masterSprintPanel = new FlowPanel();
		this.masterSprintPanel.setStyleName("box");
		this.masterSprintPanel.setSize("600px", "300px");
		this.masterSprintProductBackloglPanel.add(this.masterSprintPanel);

		this.masterProductBacklogPanel = new FlowPanel();
		this.masterProductBacklogPanel.setStyleName("box");
		this.masterSprintProductBackloglPanel
				.add(this.masterProductBacklogPanel);
		this.masterProductBacklogPanel.setSize("600px", "300px");

		final FlowPanel masterProductReleasePanel = new FlowPanel();
		absolutePanel.add(masterProductReleasePanel);
		masterProductReleasePanel.setSize("400px", "600px");

		this.masterProjectPanel = new FlowPanel();
		this.masterProjectPanel.setStyleName("box");
		masterProductReleasePanel.add(this.masterProjectPanel);
		this.masterProjectPanel.setSize("400px", "300px");

		final AbsolutePanel concreteProjectPanel = new AbsolutePanel();
		this.masterProjectPanel.add(concreteProjectPanel);
		concreteProjectPanel.setSize("395px", "300px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		concreteProjectPanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("375px", "215px");

		this.tableProject = new CellTable<Project>();

		final TextColumn<Project> textColumn = new TextColumn<Project>() {
			@Override
			public String getValue(Project project) {
				return project.getName();
			}
		};
		this.tableProject.addColumn(textColumn, TextConstants.PROJECT_NAME);
		scrollPanel.setWidget(this.tableProject);
		this.tableProject
				.setSelectionModel(new SingleSelectionModel<Project>());
		this.tableProject.getSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					@Override
					@SuppressWarnings("unchecked")
					public void onSelectionChange(SelectionChangeEvent event) {
						final SingleSelectionModel<Project> model = (SingleSelectionModel<Project>) ProjectView.this.tableProject
								.getSelectionModel();
						final Project selected = model.getSelectedObject();
						if (selected != null) {
							ProjectView.this.currentlySelected = selected;
							ProjectView.this.projectSelectionEvent.fire(
									ProjectView.this, new ProjectEventArgs(
											selected));
						} else {
							ProjectView.this.currentlySelected = null;
						}
					}
				});
		this.tableProject.setSize("100%", "100%");

		final FlowPanel projectMenuPanel = new FlowPanel();
		concreteProjectPanel.add(projectMenuPanel, 10, 34);
		projectMenuPanel.setSize("350px", "25px");

		this.imgNewProject = new Image(TextConstants_FilePaths.NEW_FILE_PATH);
		this.imgNewProject.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ProjectView.this.newProjectEvent.fire(ProjectView.this,
						new EventArgs());
			}
		});
		projectMenuPanel.add(this.imgNewProject);

		final Image imgDetails = new Image(TextConstants_FilePaths.DETAILS_PATH);
		imgDetails.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (ProjectView.this.currentlySelected != null) {
					ProjectView.this.editProjectEvent.fire(ProjectView.this,
							new ProjectEventArgs(
									ProjectView.this.currentlySelected));
				}
			}
		});
		projectMenuPanel.add(imgDetails);

		this.imgDeleteProject = new Image(TextConstants_FilePaths.DELETE_PATH);
		this.imgDeleteProject.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (ProjectView.this.currentlySelected != null) {
					ProjectView.this.deleteProjectEvent.fire(ProjectView.this,
							new ProjectEventArgs(
									ProjectView.this.currentlySelected));
				}
			}
		});
		projectMenuPanel.add(this.imgDeleteProject);

		final Label lblProjekte = new Label(TextConstants.PROJECT_OVERVIEW);
		lblProjekte.setStyleName(TextConstants.LABELELEMENT);
		concreteProjectPanel.add(lblProjekte, 10, 5);

		this.masterReleasePanel = new FlowPanel();
		this.masterReleasePanel.setStyleName("box");
		masterProductReleasePanel.add(this.masterReleasePanel);
		this.masterReleasePanel.setSize("400px", "300px");
	}

	private CellTable<Project> getProjectTable() {
		return this.tableProject;
	}

	@Override
	public void addDeleteProjectEventHandler(EventHandler<ProjectEventArgs> arg) {
		this.deleteProjectEvent.add(arg);
	}

	@Override
	public void addNewProjectEventHandler(EventHandler<EventArgs> arg) {
		this.newProjectEvent.add(arg);
	}

	@Override
	public void addProjectSelectionHandler(EventHandler<ProjectEventArgs> arg) {
		this.projectSelectionEvent.add(arg);
	}

	@Override
	public void refreshProjects(Vector<Project> projects) {
		this.getProjectTable().setRowData(projects);
	}

	@Override
	public Panel getMasterSprintPanel() {
		return this.masterSprintPanel;
	}

	@Override
	public Panel getMasterSprintProductBackloglPanel() {
		return this.masterSprintProductBackloglPanel;
	}

	@Override
	public Panel getMasterProductBackloglPanel() {
		return this.masterProductBacklogPanel;
	}

	@Override
	public Panel getMasterReleasePanel() {
		return this.masterReleasePanel;
	}

	@Override
	public void addEditProjectEvent(EventHandler<ProjectEventArgs> handler) {
		this.editProjectEvent.add(handler);
	}
}
