package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class Role implements IRole {
	private String description;
	private final ToPersonAssoc toPersonAssoc;

	public Role(String description) throws NoValidValueException {
		super();
		setDescription(description);
		toPersonAssoc = new ToPersonAssoc(this);
	}

	@Override
	public ToPersonAssoc getToPersonAssoc() {
		return toPersonAssoc;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) throws NoValidValueException {
		if (description != null && !description.isEmpty()) {
			this.description = description;
		} else {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		}
	}

	@Override
	public Vector<IPerson> getPersons() {
		Vector<IPerson> ret = new Vector<IPerson>();
		for (IPerson.ToRoleAssoc personAssocs : toPersonAssoc.getAssociations()) {
			ret.add(personAssocs.getElement());
		}
		return ret;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = indirectHashCode();
		result = prime * result + ((toPersonAssoc == null) ? 0 : toPersonAssoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!indirectEquals(obj))
			return false;
		Role other = (Role) obj;
		if (toPersonAssoc == null) {
			if (other.toPersonAssoc != null)
				return false;
		} else if (!toPersonAssoc.equals(other.toPersonAssoc))
			return false;
		return true;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
}
