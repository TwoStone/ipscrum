package fhdw.ipscrum.shared.model;

import java.util.Vector;

public class Project {

	private String name;
	private ProductBacklog backlog;
	private Vector<Release> releasePlan;

	public Project(String name, ProductBacklog backlog) {
		super();
		this.name = name;
		this.backlog = backlog;
	}
	
	public Vector<Release> getReleasePlan() {
		if(this.releasePlan==null){
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
	
	public void setBacklog(ProductBacklog backlog) {
		this.backlog = backlog;
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
				+ ((this.getReleasePlan() == null) ? 0 : this.getReleasePlan().hashCode());
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
