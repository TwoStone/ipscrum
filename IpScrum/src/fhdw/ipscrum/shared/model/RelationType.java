package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;

/**
 * A relation type represents a customer-specified type of a relation between
 * features (see {@link Feature}.
 */
public class RelationType {
	public static RelationType create(final String description)
			throws DoubleDefinitionException {
		final RelationType type = new RelationType(description);
		SessionManager.getInstance().getModel().getRelationTypeManager()
				.addRelationType(type);
		return type;
	}

	private final String description;

	private RelationType(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.description == null) ? 0 : this.description.hashCode());
		return result;
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
		final RelationType other = (RelationType) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		return true;
	}

}
