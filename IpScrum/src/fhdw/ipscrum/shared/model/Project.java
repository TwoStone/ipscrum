package fhdw.ipscrum.shared.model;

import java.util.HashSet;
import java.util.Iterator;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents a Scrum Project.
 */
public class Project extends Observable{

	private String name;
	private final ProductBacklog backlog;
	private HashSet<Release> releasePlan;
	private HashSet<ISprint> sprints;

	/**
	 * @param name
	 * Name of the Project
	 * @throws NoValidValueException
	 * If the name for the Project is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public Project(String name) throws NoValidValueException{
		super();
		this.setName(name);
		this.backlog = new ProductBacklog(this);
	}

	public HashSet<Release> getReleasePlan() {
		if (this.releasePlan == null) {
			this.releasePlan = new HashSet<Release>();
		}
		return releasePlan;
	}

	public String getName() {
		return name;
	}

	/**
	 * Set a new Project name!
	 * @param name
	 * Name of the Project
	 * @throws NoValidValueException
	 * If the name for the Project is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public void setName(String name) throws NoValidValueException {
		if(name!=null && name.trim().length()>0){
			this.name = name;
			this.notifyObservers();
		}else{
			//TODO Textkonstante bauen
			throw new NoValidValueException("Es muss ein Projektname angegeben werden!");
		}
	}

	public ProductBacklog getBacklog() {
		return backlog;
	}

	/**
	 * Returns true if the given sprint is currently
	 * defined within the project else false will be
	 * returned.
	 * @param sprint
	 * Sprint for check!
	 */
	public boolean isSprintDefined(ISprint sprint){
		Iterator<ISprint> i = this.getSprints().iterator();
		while(i.hasNext()){
			if(i.equals(sprint)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the defined Sprints for this project.
	 * <br />
	 * <b>Attention</b><br />
	 * For adding and removing a sprint use the functionalities
	 * of the Project, else we cannot guarantee the consistency!
	 */
	public HashSet<ISprint> getSprints() {
		if(this.sprints==null){
			this.sprints = new HashSet<ISprint>();
		}
		return sprints;
	}
	
	/**
	 * TODO Kommentar
	 * @param sprint
	 */
	public void addSprint(ISprint sprint){
		this.getSprints().add(sprint);
		this.notifyObservers();
	}
	
	/**
	 * TODO Kommentar
	 * @param sprint
	 */
	public void removeSprint(ISprint sprint){
		//TODO Konsistenzerhaltung
		this.getSprints().remove(sprint);
		this.notifyObservers();
	}
	
	/**
	 * Returns the number of defined Sprints within the
	 * project!
	 */
	public Integer countSprints(){
		return this.getSprints().size();
	}
	
	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((releasePlan == null) ? 0 : releasePlan.hashCode());
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
		Project other = (Project) obj;
		if (backlog == null) {
			if (other.backlog != null)
				return false;
		} else if (!backlog.equals(other.backlog))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (this.getReleasePlan() == null) {
			if (other.getReleasePlan() != null)
				return false;
		} else if (!this.getReleasePlan().equals(other.getReleasePlan()))
			return false;
		if (this.getSprints() == null) {
			if (other.getSprints() != null)
				return false;
		} else if (!this.getSprints().equals(other.getSprints()))
			return false;
		return true;
	}
}
