package fhdw.ipscrum.shared.model;

public class Project {

	private String name;
	private ProductBacklog backlog;
	private Release releasePlan;

	public Project(String name) {
		super();
		this.name = name;
	}
	
	public Project(String name, ProductBacklog backlog) {
		this(name);
		this.backlog = backlog;
	}

	public Project(String name, ProductBacklog backlog, Release releasePlan) {
		this(name, backlog);
		this.releasePlan = releasePlan;
	}

	public void setReleasePlan(Release releasePlan) {
		this.releasePlan = releasePlan;
	}
	
	public Release getReleasePlan() {
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
				+ ((releasePlan == null) ? 0 : releasePlan.hashCode());
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
		if (releasePlan == null) {
			if (other.releasePlan != null)
				return false;
		} else if (!releasePlan.equals(other.releasePlan))
			return false;
		return true;
	}
}
