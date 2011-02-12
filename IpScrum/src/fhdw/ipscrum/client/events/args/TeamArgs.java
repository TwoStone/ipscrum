package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 */
public class TeamArgs extends EventArgs {

	private ITeam team;

	/**
	 * Constructor for TeamArgs.
	 * @param team ITeam
	 */
	public TeamArgs(ITeam team) {
		super();
		this.team = team;
	}
	
	/**
	 * Method getTeam.
	
	 * @return ITeam */
	public ITeam getTeam() {
		return this.team;
	}
}
