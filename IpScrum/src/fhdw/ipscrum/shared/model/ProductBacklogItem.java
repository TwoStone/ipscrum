package fhdw.ipscrum.shared.model;

public abstract class ProductBacklogItem {

	private String name;
	private Integer aufwand;
	
	public ProductBacklogItem(String name, Integer aufwand) {
		super();
		this.name = name;
		this.aufwand = aufwand;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Integer getAufwand() {
		return aufwand;
	}

	public final void setAufwand(Integer aufwand) {
		this.aufwand = aufwand;
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + aufwand + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aufwand == null) ? 0 : aufwand.hashCode());
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
		if (aufwand == null) {
			if (other.aufwand != null)
				return false;
		} else if (!aufwand.equals(other.aufwand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
