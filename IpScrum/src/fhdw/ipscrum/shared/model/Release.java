package fhdw.ipscrum.shared.model;

import java.util.HashSet;

import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Release implements IRelease {

	private HashSet<ISprint> sprints;
	private final Project project;
	
	public Release(Project project) {
		super();
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
	
	public void addSprint(ISprint sprint) throws NoSprintDefinedException{
		if(this.project.isSprintDefined(sprint)){
			this.getSprints().add(sprint);
		}else{
			//TODO Textkonstante bauen
			throw new NoSprintDefinedException("Nur bereits erstelle Sprints können dem Release zugeordnet werden.");
		}
	}
	
	public void removeSprint(ISprint sprint){
		this.getSprints().remove(sprint);
	}
	
	public Project getProject() {
		return project;
	}
	
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
