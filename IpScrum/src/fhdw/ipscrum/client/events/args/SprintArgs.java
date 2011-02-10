package fhdw.ipscrum.client.events.args;

import java.util.Date;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Team;

public class SprintArgs extends EventArgs {

	private String description;
	private Date start;
	private Date end;
	private Team team;

	
	public SprintArgs(Date start, Date end, String description, Team team) {
		super();
		this.start = start;
		this.end = end;
		this.description = description;
		this.team = team;
	}
	
	public String getDescription() {
		return this.description;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public Team getTeam() {
		return team;
	}
	
	
	
}
