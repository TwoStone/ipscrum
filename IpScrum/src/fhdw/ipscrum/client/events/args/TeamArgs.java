package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class TeamArgs extends EventArgs {

	private ITeam team;

	public TeamArgs(ITeam team) {
		super();
		this.team = team;
	}
	
	public ITeam getTeam() {
		return this.team;
	}
}
