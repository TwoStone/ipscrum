package fhdw.ipscrum.shared.model;

public abstract class ProductBacklogItem {

	private String name;
	private Integer manDayCosts;
	private final ProductBacklog backlog;
	
	public ProductBacklogItem(String name, Integer manDayCosts, ProductBacklog backlog) {
		super();
		this.name = name;
		this.manDayCosts = manDayCosts;
		this.backlog = backlog;
	}

	public ProductBacklog getBacklog() {
		return backlog;
	}
	
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Integer getManDayCosts() {
		return manDayCosts;
	}

	public final void setManDayCosts(Integer manDayCosts) {
		this.manDayCosts = manDayCosts;
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + manDayCosts + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result
				+ ((manDayCosts == null) ? 0 : manDayCosts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProductBacklogItem other = (ProductBacklogItem) obj;
		if (backlog == null) {
			if (other.backlog != null)
				return false;
		} else if (!backlog.equals(other.backlog))
			return false;
		if (manDayCosts == null) {
			if (other.manDayCosts != null)
				return false;
		} else if (!manDayCosts.equals(other.manDayCosts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}