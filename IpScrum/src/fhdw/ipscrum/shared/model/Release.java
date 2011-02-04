package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Release {

	private Vector<ISprint> sprints;
	
	public Release() {
		super();
	}
	
	public Vector<ISprint> getSprints() {
		if(sprints==null){
			this.sprints = new Vector<ISprint>();
		}
		return sprints;
	}
	
	public void addSprint(ISprint sprint){
		this.getSprints().add(sprint);
	}
	
	public void removeSprint(ISprint sprint){
		this.getSprints().remove(sprint);
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
		if (sprints == null) {
			if (other.sprints != null)
				return false;
		} else if (!sprints.equals(other.sprints))
			return false;
		return true;
	}
}
