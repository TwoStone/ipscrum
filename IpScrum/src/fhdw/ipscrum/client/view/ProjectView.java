package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.model.Project;

public class ProjectView extends Composite implements IProjectView{
	
//####### Events ###############
	
	private final Event<EventArgs> newProjectEvent = new Event<EventArgs>();
	private final Event<ProjectEventArgs> deleteProjectEvent = new Event<ProjectEventArgs>();
	private final Event<ProjectEventArgs> projectSelectionEvent = new Event<ProjectEventArgs>();
//##### Ende ##################
//##### Tempräre Daten ########
	private Project currentlySelected;
//#############################
	
	private Image imgNewProject;
	private Image imgDeleteProject;
	private VerticalPanel masterProductBackloglPanel;
	private VerticalPanel masterReleasePanel;
	private CellTable<Project> tableProject;
	
	public static IProjectView createView(){
		return new ProjectView();
	}
		
	public ProjectView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("1000px", "600px");
		
		masterProductBackloglPanel = new VerticalPanel();
		masterProductBackloglPanel.setStyleName("box");
		absolutePanel.add(masterProductBackloglPanel, 500, 0);
		masterProductBackloglPanel.setSize("495px", "594px");
		
		VerticalPanel masterProductReleasePanel = new VerticalPanel();
		absolutePanel.add(masterProductReleasePanel);
		masterProductReleasePanel.setSize("495px", "600px");
		
		AbsolutePanel concreteProjectPanel = new AbsolutePanel();
		concreteProjectPanel.setStyleName("box");
		masterProductReleasePanel.add(concreteProjectPanel);
		concreteProjectPanel.setSize("495px", "275px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		concreteProjectPanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("450px", "200px");
		
		tableProject = new CellTable<Project>();
		
		TextColumn textColumn = new TextColumn<Project>() {
			@Override
			public String getValue(Project object) {
				return object.toString();
			}
		};
		tableProject.addColumn(textColumn, "Projektbezeichnung");
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
		projectMenuPanel.setSize("450px", "25px");
		
		imgNewProject = new Image("images/newfile.png");
		imgNewProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				newProjectEvent.fire(ProjectView.this, new EventArgs());
			}
		});
		projectMenuPanel.add(imgNewProject);
		
		imgDeleteProject = new Image("images/delete.png");
		imgDeleteProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(currentlySelected!=null){
					deleteProjectEvent.fire(ProjectView.this, new ProjectEventArgs(currentlySelected));
				}
			}
		});
		projectMenuPanel.add(imgDeleteProject);
		
		Label lblProjekte = new Label("Projekte\u00FCbersicht");
		lblProjekte.setStyleName("LabelElement");
		concreteProjectPanel.add(lblProjekte, 10, 5);
		
		masterReleasePanel = new VerticalPanel();
		masterReleasePanel.setStyleName("box");
		masterReleasePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		masterReleasePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		masterProductReleasePanel.add(masterReleasePanel);
		masterProductReleasePanel.setCellVerticalAlignment(masterReleasePanel, HasVerticalAlignment.ALIGN_MIDDLE);
		masterProductReleasePanel.setCellHorizontalAlignment(masterReleasePanel, HasHorizontalAlignment.ALIGN_CENTER);
		masterReleasePanel.setSize("495px", "300px");
	}
	public HasClickHandlers getImgNewProject() {
		return imgNewProject;
	}
	public HasClickHandlers getImgDeleteProject() {
		return imgDeleteProject;
	}
	public Panel getMasterProductBackloglPanel() {
		return masterProductBackloglPanel;
	}
	public Panel getMasterReleasePanel() {
		return masterReleasePanel;
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
}
