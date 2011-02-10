package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.TeamDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.client.view.interfaces.ITeamDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Team;


public class TeamDialogPresenter extends Presenter<ITeamDialogView> {

	private Team team;
	final ITeamDialogView view = new TeamDialogView();
	
	public TeamDialogPresenter(Panel parent) {
		super(parent);
	}
	
	public TeamDialogPresenter(Panel parent, Team selectedTeam) {
		super(parent);
		this.team = selectedTeam;
		initialize();
	}

	@Override
	protected ITeamDialogView createView() {
		view.addOkEventHandler(new EventHandler<OneStringArgs>() {

			@Override
			public void onUpdate(Object sender, OneStringArgs eventArgs) {
				if (TeamDialogPresenter.this.team == null) {
					SessionManager.getInstance().getModel().addTeam(new Team(eventArgs.getString()));
				} else {
					TeamDialogPresenter.this.team.setDescription(eventArgs.getString());					
				}
				
				finish();
			}
		});

		view.addCancelEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});
		return view;
	}
	
	/**
	 * 
	 */
	private void initialize() {
		if (this.team != null) {
			this.view.getTeamDescription().setText(this.team.getDescription());
		}
	}

}
