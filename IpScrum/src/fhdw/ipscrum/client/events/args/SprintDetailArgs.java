package fhdw.ipscrum.client.events.args;

import java.util.Date;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class SprintDetailArgs extends EventArgs{

	private final String name;
	private final Date beginDate;
	private final Date endDate;
	private final ITeam team;
	private final String description;

	public SprintDetailArgs(String name, Date beginDate, Date endDate, ITeam team, String description) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.team = team;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public ITeam getTeam() {
		return this.team;
	}

	public String getDescription() {
		return this.description;
	}

}
