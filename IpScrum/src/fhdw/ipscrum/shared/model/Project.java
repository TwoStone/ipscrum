package fhdw.ipscrum.shared.model;

import java.util.HashSet;
import java.util.Iterator;

import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Project {

	private String name;
	private final ProductBacklog backlog;
	private HashSet<Release> releasePlan;
	private HashSet<ISprint> sprints;

	public Project(String name) {
		super();
		this.name = name;
		this.backlog = new ProductBacklog();
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

	public void setName(String name) {
		this.name = name;
	}

	public ProductBacklog getBacklog() {
		return backlog;
	}

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
