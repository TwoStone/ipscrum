package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * Class Role.
 */
public class Role implements IRole {
	private String description;
	private ToPersonAssoc toPersonAssoc;

	@SuppressWarnings("unused")
	private Role() {
	}

	/**
	 * Constructor for Role.
	 * 
	 * @param description String
	 * @throws NoValidValueException
	 */
	public Role(String description) throws NoValidValueException {
		super();
		setDescription(description);
		toPersonAssoc = new ToPersonAssoc(this);
	}

	/**
	 * Method getToPersonAssoc.
	 * 
	 * @return ToPersonAssoc
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#getToPersonAssoc()
	 */
	@Override
	public ToPersonAssoc getToPersonAssoc() {
		return toPersonAssoc;
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#setDescription(String)
	 */
	@Override
	public void setDescription(String description) throws NoValidValueException {
		if (description != null && !description.isEmpty()) {
			this.description = description;
		} else {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		}
	}

	/**
	 * Method getPersons.
	 * 
	 * @return Vector<IPerson>
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#getPersons()
	 */
	@Override
	public Vector<IPerson> getPersons() {
		Vector<IPerson> ret = new Vector<IPerson>();
		for (IPerson.ToRoleAssoc personAssocs : toPersonAssoc.getAssociations()) {
			ret.add(personAssocs.getElement());
		}
		return ret;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getDescription();
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return indirectHashCode();
	}

	/**
	 * Method equals.
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		return indirectEquals(obj);
	}

	/**
	 * Method indirectEquals.
	 * 
	 * @param obj Object
	 * @return boolean
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectEquals(Object)
	 */
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

	/**
	 * Method indirectHashCode.
	 * 
	 * @return int
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectHashCode()
	 */
	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
}
