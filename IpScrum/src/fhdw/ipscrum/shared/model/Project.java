package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Project {

	private String name;
	private final ProductBacklog backlog;
	private Vector<Release> releasePlan;

	public Project(String name) {
		super();
		this.name = name;
		this.backlog = new ProductBacklog();
	}

	public Vector<Release> getReleasePlan() {
		if (this.releasePlan == null) {
			this.releasePlan = new Vector<Release>();
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

	public Vector<ISprint> getSprintsWithinProject(){
		Vector<ISprint> releaseSprints = new Vector<ISprint>();
		for(Release current : this.getReleasePlan()){
				releaseSprints.addAll(current.getSprints());
		}

		Vector<ISprint> pbiSprints = new Vector<ISprint>();
		for(ProductBacklogItem current : this.getBacklog().getItems()){
			if(current.getSprint()!=null){
				releaseSprints.add(current.getSprint());
			}
		}
		
		Vector<ISprint> ret = new Vector<ISprint>();
		ret.addAll(releaseSprints);
		ret.addAll(pbiSprints);
		
		return ret;
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
		result = prime
				* result
				+ ((this.getReleasePlan() == null) ? 0 : this.getReleasePlan()
						.hashCode());
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
		return true;
	}
}
