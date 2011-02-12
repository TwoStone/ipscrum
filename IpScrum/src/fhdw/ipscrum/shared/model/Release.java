package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Release represents a version of a project. A release could have a number of
 * Sprints.
 * 
 * A Release belongs to explicit one project.
 */
public class Release extends Observable implements IRelease {

	private String version;
	private Date releaseDate;

	private final ToProjectAssoc projectAssoc;
	private final ToSprintAssoc sprintAssoc;
	

	
	@Override
	public ToSprintAssoc getSprintAssoc() {
		return this.sprintAssoc;
	}


	public ToProjectAssoc getProjectAssoc() {
		return projectAssoc;
	}

	public Release(String version, Date releaseDate, Project project) throws DoubleDefinitionException{
		this.version = version;
		this.releaseDate = releaseDate;
		// this.project = project;
		this.projectAssoc = new ToProjectAssoc(this);
		this.sprintAssoc = new ToSprintAssoc(this);
		project.isReleaseDoubleDefined(version, releaseDate);//can throw DoubleDefinitionException
		this.getProjectAssoc().set(project.getReleaseAssoc());
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		this.notifyObservers();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
		this.notifyObservers();
	}

	/**
	 * Return all Sprints which are added to the release. <br />
	 * <b>Attention</b><br />
	 * In fact of providing the consistency you have to use, for adding and
	 * removing a sprint to a release, the methods of the release.
	 */
	public Vector<ISprint> getSprints() {
		Vector<ISprint> ret = new Vector<ISprint>();
		//TODO getSprints!
		return ret;
	}

	/**
	 * Adds a Sprint to the release only if the Sprint was defined within the
	 * Project.
	 * 
	 * @throws NoSprintDefinedException
	 *             If the sprint wasn't defined within the project.
	 */
	public void addSprint(ISprint sprint) throws UserException {
		this.getProject().isSprintDefined(sprint);
		this.getSprintAssoc().add(sprint.getToReleaseAssoc());
	}

	/**
	 * Removes the given Sprint from the Release.
	 */
	public void removeSprint(ISprint sprint) {
		this.getSprintAssoc().remove(sprint.getToReleaseAssoc());
	}

	public Project getProject() throws ConsistencyException{
		if(this.getProjectAssoc().get()!=null){
			return this.getProjectAssoc().get().getElement();
		}else{
			throw new ConsistencyException("Dem Release wurde keine Projekt zugeordnet!");
		}
	}

	/**
	 * Returns the Number of all defined Sprints within the
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	@Override
	public String toString() {
		return "Release [releaseDate=" + releaseDate + ", version=" + version
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		try {
			result = prime * result + ((this.getProject() == null) ? 0 : this.getProject().hashCode());
		} catch (ConsistencyException e) {
			result = 0;
		}
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((this.getSprints() == null) ? 0 : this.getSprints().hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Release other = (Release) obj;
		try {
			if (this.getProject() == null) {
				if (other.getProject() != null)
					return false;
			} else if (!this.getProject().equals(other.getProject()))
				return false;
		} catch (ConsistencyException e) {
			return false;
		}
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (this.getSprints() == null) {
			if (other.getSprints() != null)
				return false;
		} else if (!this.getSprints().equals(other.getSprints()))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
