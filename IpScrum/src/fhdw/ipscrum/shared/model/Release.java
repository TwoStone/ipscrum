package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Release represents a version of a project.
 * A release could have a number of Sprints.
 * 
 * A Release belongs to explicit one project. 
 */
public class Release extends Observable implements IRelease {

	private HashSet<ISprint> sprints;
	private final Project project;
	private String version;
	private Date releaseDate;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Release(Project project) {
		super();
		project.addRelease(this);
		this.project = project;
	}
	
	/**
	 * Return all Sprints which are added to
	 * the release.
	 * <br />
	 * <b>Attention</b><br />
	 * In fact of providing the consistency you have
	 * to use, for adding and removing a sprint
	 * to a release, the methods of the release.
	 */
	public HashSet<ISprint> getSprints() {
		if(sprints==null){
			this.sprints = new HashSet<ISprint>();
		}
		return sprints;
	}
	
	/**
	 * Adds a Sprint to the release only if the Sprint
	 * was defined within the Project.
	 * @throws NoSprintDefinedException
	 * If the sprint wasn't defined within the project.
	 */
	public void addSprint(ISprint sprint) throws NoSprintDefinedException{
		if(this.project.isSprintDefined(sprint)){
			if(sprint!=null && !this.isSprintInList(sprint)){
				sprint.setRelease(this);
				this.getSprints().add(sprint);
				this.notifyObservers();
			}else{
				//TODO Textkonstante bauen
//				throw new ConsistencyException("");
			}
		}else{
			//TODO Textkonstante bauen
			throw new NoSprintDefinedException("Nur bereits erstelle Sprints können dem Release zugeordnet werden.");
		}
	}
	
	private boolean isSprintInList(ISprint sprint){
		Iterator<ISprint> i = this.getSprints().iterator();
		while(i.hasNext()){
			if(i.next().equals(sprint)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Removes the given Sprint from the Release.
	 */
	public void removeSprint(ISprint sprint){
		//TODO Reverse beachten
		this.getSprints().remove(sprint);
		this.notifyObservers();
	}
	
	public Project getProject() {
		return project;
	}
	
	/**
	 * Returns the Number of all defined Sprints within the
	 */
	public Integer countSprints(){
		return this.getSprints().size();
	}

	@Override
	public String toString() {
		return "Release [sprints=" + sprints + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((sprints == null) ? 0 : sprints.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Release other = (Release) obj;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (this.getSprints() == null) {
			if (other.getSprints() != null)
				return false;
		} else if (!this.getSprints().equals(other.getSprints()))
			return false;
		return true;
	}
}
