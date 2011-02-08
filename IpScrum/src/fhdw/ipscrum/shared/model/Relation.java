package fhdw.ipscrum.shared.model;

/**
 * Objects of this class describe relations to one 
 * target object. The relation has one type, which can be customized by a
 * user of the ticket system.
 */
public class Relation {
	
	private RelationType type;
	private Feature target;

	public Relation(){
	}
/* Start of getter / setter section */
	public RelationType getType() {
		return type;
	}
	public void setType(RelationType type) {
		this.type = type;
	}
	public Feature getTarget() {
		return target;
	}
	public void setTarget(Feature target) {
		this.target = target;
	}
/* End of getter / setter section */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Relation other = (Relation) obj;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
