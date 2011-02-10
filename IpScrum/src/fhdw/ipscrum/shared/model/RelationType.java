package fhdw.ipscrum.shared.model;
/**
 * A relation type represents a customer-specified type of a relation
 * between features (see {@link Feature}.
 */
public class RelationType {
	private String description;

	public RelationType(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
		RelationType other = (RelationType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	
}
