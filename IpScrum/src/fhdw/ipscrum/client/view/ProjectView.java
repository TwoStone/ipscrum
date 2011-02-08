package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.interfaces.IProjectView;
import fhdw.ipscrum.shared.model.Project;

public class ProjectView extends Composite implements IProjectView{
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
		absolutePanel.setSize("1000", "600");
		
		masterProductBackloglPanel = new VerticalPanel();
		absolutePanel.add(masterProductBackloglPanel, 500, 0);
		masterProductBackloglPanel.setSize("500", "600");
		
		VerticalPanel masterProductReleasePanel = new VerticalPanel();
		absolutePanel.add(masterProductReleasePanel);
		masterProductReleasePanel.setSize("500", "600");
		
		VerticalPanel concreteProjectPanel = new VerticalPanel();
		concreteProjectPanel.setStyleName("box");
		concreteProjectPanel.setBorderWidth(1);
		concreteProjectPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		masterProductReleasePanel.add(concreteProjectPanel);
		concreteProjectPanel.setSize("500", "275");
		
		FlowPanel projectMenuPanel = new FlowPanel();
		concreteProjectPanel.add(projectMenuPanel);
		projectMenuPanel.setSize("480", "25");
		
		imgNewProject = new Image("images/newfile.png");
		projectMenuPanel.add(imgNewProject);
		
		imgDeleteProject = new Image("images/delete.png");
		projectMenuPanel.add(imgDeleteProject);
		
		tableProject = new CellTable<Project>();
		
		TextColumn<Project> bezeichnung = new TextColumn<Project>() {
			@Override
			public String getValue(Project object) {
				return object.toString();
			}
		};
		bezeichnung.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		bezeichnung.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		tableProject.addColumn(bezeichnung, "Bezeichnung");
		concreteProjectPanel.add(tableProject);
		tableProject.setSize("480", "250px");
		
		masterReleasePanel = new VerticalPanel();
		masterReleasePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		masterReleasePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		masterProductReleasePanel.add(masterReleasePanel);
		masterProductReleasePanel.setCellVerticalAlignment(masterReleasePanel, HasVerticalAlignment.ALIGN_MIDDLE);
		masterProductReleasePanel.setCellHorizontalAlignment(masterReleasePanel, HasHorizontalAlignment.ALIGN_CENTER);
		masterReleasePanel.setSize("500", "300");
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
	public CellTable<Project> getSelectedProject(){
		return tableProject;
	}

	private CellTable<Project> getProjectTable(){
		return tableProject;
	}
	
	@Override
	public void refreshProjects(Vector<Project> projects) {
		this.getProjectTable().setRowData(projects);
	}
}
