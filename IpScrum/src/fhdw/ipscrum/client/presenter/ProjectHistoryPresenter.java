package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.ProjectHistoryView;
import fhdw.ipscrum.shared.model.Project;

public class ProjectHistoryPresenter extends Presenter<ProjectHistoryView> {

	Project project;
	
	public ProjectHistoryPresenter(Panel parent, Presenter<?> parentPresenter, Project project) {
		super(parent, parentPresenter);
	this.project = project;
	this.initialize();
	}

	private void initialize() {
		//TODO Stefan fragen wegen Incidents!!!
//	this.getView().refreshProjectHistoryTable(this.getSessionManager().getModel().getIncidents());	
	}

	@Override
	protected ProjectHistoryView createView() {
		return new ProjectHistoryView();
		
	}

}
