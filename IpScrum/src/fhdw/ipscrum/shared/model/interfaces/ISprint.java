package fhdw.ipscrum.shared.model.interfaces;

import java.sql.Date;

import fhdw.ipscrum.shared.model.Team;

public interface ISprint {

	public Date getBegin();
	public void setBegin(Date begin);
	
	public Date getEnd();
	public void setEnd(Date end);
	
	public Team getTeam();
	public void setTeam(Team team);
}
