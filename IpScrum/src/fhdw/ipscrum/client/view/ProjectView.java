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

public class ProjectView extends Composite implements IProjectView{
	
//####### Events ###############
	
	private final Event<EventArgs> newProjectEvent = new Event<EventArgs>();
	private final Event<ProjectEventArgs> deleteProjectEvent = new Event<ProjectEventArgs>();
	private final Event<ProjectEventArgs> projectSelectionEvent = new Event<ProjectEventArgs>();
//##### Ende ##################
//##### Tempor�re Daten ########
	private Project currentlySelected;
//#############################
	
	private Image imgNewProject;
	private Image imgDeleteProject;
	private FlowPanel masterSprintProductBackloglPanel;
	private FlowPanel masterReleasePanel;
	private CellTable<Project> tableProject;
	private FlowPanel masterSprintPanel;
	private FlowPanel masterProductBacklogPanel;
	private FlowPanel masterProjectPanel;
	
	public static IProjectView createView(){
		return new ProjectView();
	}
		
	public ProjectView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("1000px", "600px");
		
		masterSprintProductBackloglPanel = new FlowPanel();
		absolutePanel.add(masterSprintProductBackloglPanel, 400, 0);
		masterSprintProductBackloglPanel.setSize("600px", "600px");
		
		masterSprintPanel = new FlowPanel();
		masterSprintPanel.setStyleName("box");
		masterSprintPanel.setSize("600px", "300px");
		masterSprintProductBackloglPanel.add(masterSprintPanel);
		
		masterProductBacklogPanel = new FlowPanel();
		masterProductBacklogPanel.setStyleName("box");
		masterSprintProductBackloglPanel.add(masterProductBacklogPanel);
		masterProductBacklogPanel.setSize("600px", "300px");
		
		FlowPanel masterProductReleasePanel = new FlowPanel();
		absolutePanel.add(masterProductReleasePanel);
		masterProductReleasePanel.setSize("400px", "600px");
		
		masterProjectPanel = new FlowPanel();
		masterProjectPanel.setStyleName("box");
		masterProductReleasePanel.add(masterProjectPanel);
		masterProjectPanel.setSize("400px", "300px");
		
		AbsolutePanel concreteProjectPanel = new AbsolutePanel();
		masterProjectPanel.add(concreteProjectPanel);
		concreteProjectPanel.setSize("395px", "300px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		concreteProjectPanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("375px", "215px");
		
		tableProject = new CellTable<Project>();
		
		TextColumn textColumn = new TextColumn<Project>() {
			@Override
			public String getValue(Project project) {
				return project.getName();
			}
		};
		tableProject.addColumn(textColumn, TextConstants.PROJECT_NAME);
		scrollPanel.setWidget(tableProject);
		tableProject.setSelectionModel(new SingleSelectionModel<Project>());
		tableProject.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@SuppressWarnings("unchecked")
			public void onSelectionChange(SelectionChangeEvent event) {
				SingleSelectionModel<Project> model = (SingleSelectionModel<Project>)tableProject.getSelectionModel(); 
				Project selected = model.getSelectedObject();
					if (selected != null) {
						currentlySelected = selected;
						projectSelectionEvent.fire(ProjectView.this, new ProjectEventArgs(selected));
					}else{
						currentlySelected = null;
					}
			}
		});
		tableProject.setSize("100%", "100%");
		
		FlowPanel projectMenuPanel = new FlowPanel();
		concreteProjectPanel.add(projectMenuPanel, 10, 34);
		projectMenuPanel.setSize("350px", "25px");
		
		imgNewProject = new Image(TextConstants_FilePaths.NEW_FILE_PATH);
		imgNewProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				newProjectEvent.fire(ProjectView.this, new EventArgs());
			}
		});
		projectMenuPanel.add(imgNewProject);
		
		imgDeleteProject = new Image(TextConstants_FilePaths.DELETE_PATH);
		imgDeleteProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(currentlySelected!=null){
					deleteProjectEvent.fire(ProjectView.this, new ProjectEventArgs(currentlySelected));
				}
			}
		});
		projectMenuPanel.add(imgDeleteProject);
		
		Label lblProjekte = new Label(TextConstants.PROJECT_OVERVIEW);
		lblProjekte.setStyleName(TextConstants.LABELELEMENT);
		concreteProjectPanel.add(lblProjekte, 10, 5);
		
		masterReleasePanel = new FlowPanel();
		masterReleasePanel.setStyleName("box");
		masterProductReleasePanel.add(masterReleasePanel);
		masterReleasePanel.setSize("400px", "300px");
	}

	
	private CellTable<Project> getProjectTable(){
		return tableProject;
	}
	
	@Override
	public void addDeleteProjectEventHandler(EventHandler<ProjectEventArgs> arg) {
		deleteProjectEvent.add(arg);
	}
	
	@Override
	public void addNewProjectEventHandler(EventHandler<EventArgs> arg) {
		newProjectEvent.add(arg);
	}
	
	@Override
	public void addProjectSelectionHandler(EventHandler<ProjectEventArgs> arg) {
		projectSelectionEvent.add(arg);
	}
	
	@Override
	public void refreshProjects(Vector<Project> projects) {
		this.getProjectTable().setRowData(projects);
	}
	
	@Override
	public Panel getMasterSprintPanel() {
		return masterSprintPanel;
	}

	@Override
	public Panel getMasterSprintProductBackloglPanel() {
		return this.masterSprintProductBackloglPanel;
	}

	@Override
	public Panel getMasterProductBackloglPanel() {
		return masterProductBacklogPanel;
	}

	@Override
	public Panel getMasterReleasePanel() {
		return masterReleasePanel;
	}
}
