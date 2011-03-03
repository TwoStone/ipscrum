package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;

/**
 * A relation type represents a customer-specified type of a relation between
 * features (see {@link Feature}.
 */
public class RelationType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3978045743711269095L;

	public static RelationType create(final String description)
			throws DoubleDefinitionException {
		final RelationType type = new RelationType(description);
		SessionManager.getInstance().getModel().getRelationTypeManager()
				.addRelationType(type);
		return type;
	}

	private String description;

	private RelationType() {
	}

	private RelationType(final String description) {
		this.description = description;
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

}
