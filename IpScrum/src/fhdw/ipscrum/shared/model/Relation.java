package fhdw.ipscrum.shared.model;

/**
 * Objects of this class describe relations to one target {@link Feature}. The
 * relation has one type (see {@link RelationType}), which can be customized by
 * a user of the ticket system.
 */
public class Relation {

	private final RelationType type;
	private final ProductBacklogItem target;

	public Relation(final RelationType type, final ProductBacklogItem target) {
		this.type = type;
		this.target = target;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Relation other = (Relation) obj;
		if (this.target == null) {
			if (other.target != null) {
				return false;
			}
		} else if (!this.target.equals(other.target)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	public ProductBacklogItem getTarget() {
		return this.target;
	}

	public RelationType getType() {
		return this.type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.target == null) ? 0 : this.target.hashCode());
		result = prime * result
				+ ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

}
