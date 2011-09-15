package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * represents an event argument which knows a team.
 */
public class TeamArgs extends EventArgs {

	/**
	 * represents the team attached to the event argument.
	 */
	private final Team team;

	/**
	 * Constructor for TeamArgs.
	 * 
	 * @param team
	 *            Team
	 */
	public TeamArgs(final Team team) {
		super();
		this.team = team;
	}

	/**
	 * Method getTeam.
	 * 
	 * @return ITeam
	 */
	public Team getTeam() {
		return this.team;
	}
}
