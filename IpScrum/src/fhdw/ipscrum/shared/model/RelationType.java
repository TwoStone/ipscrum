package fhdw.ipscrum.shared.model;
/**
 * A relation type represents a customer-specified type of a relation between features.
 */
public class RelationType {
	private String description;
/* Start of constructor section*/
	public RelationType(){
	}
	public RelationType(String description){
		this.description = description;
	}
/* End of constructor section*/

	
/* Start of getter / setter section */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
/* End of getter / setter section */
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
