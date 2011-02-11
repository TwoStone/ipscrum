package fhdw.ipscrum.shared.model.interfaces;

import java.util.Date;
import java.util.HashSet;

import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.model.Project;

public interface IRelease {

	public abstract HashSet<ISprint> getSprints();

	public abstract void addSprint(ISprint sprint) throws NoSprintDefinedException;

	public abstract void removeSprint(ISprint sprint);

	public abstract Project getProject();

	public abstract Integer countSprints();
	
	public abstract String getVersion();
	
	public abstract void setVersion(String version);
	
	public abstract Date getReleaseDate();
	
	public abstract void setReleaseDate(Date releaseDate);
	

}