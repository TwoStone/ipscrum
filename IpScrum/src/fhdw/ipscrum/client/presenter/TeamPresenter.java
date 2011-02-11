package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.TeamView;
import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class TeamPresenter extends Presenter<ITeamView> {

	private ITeamView concreteView;
	
	public TeamPresenter(Panel parent) {
		super(parent);
	}


	@Override
	protected ITeamView createView() {
		this.concreteView = new TeamView();
		this.updateGuiData();
		return concreteView;
	}


	private void updateGuiData() {
		HashSet<IPerson> personSet = SessionManager.getInstance().getModel().getPersons();
	    this.concreteView.updatePersonTableData(new ArrayList<IPerson>(personSet));
	    
	    HashSet<ITeam> teamSet = SessionManager.getInstance().getModel().getTeams();
	    this.concreteView.updateTeamTreeData(teamSet);
	    
	}

}
