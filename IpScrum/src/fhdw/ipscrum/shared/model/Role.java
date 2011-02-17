package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * Class Role.
 */
public class Role implements IRole {
	private static final long serialVersionUID = 4751308921900403733L;
	private String description;
	private ToPersonAssoc toPersonAssoc;

	@SuppressWarnings("unused")
	private Role() {
	}

	/**
	 * Constructor for Role.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 */
	public Role(final String description) throws NoValidValueException {
		super();
		this.setDescription(description);
		this.toPersonAssoc = new ToPersonAssoc(this);
	}

	/**
	 * Method getToPersonAssoc.
	 * 
	 * @return ToPersonAssoc
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#getToPersonAssoc()
	 */
	@Override
	public ToPersonAssoc getToPersonAssoc() {
		return this.toPersonAssoc;
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.IRole#setDescription(String)
	 */
	@Override
	public void setDescription(final String description)
			throws NoValidValueException {
		if (description != null && !description.isEmpty()) {
			this.description = description;
		} else {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
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
		final Vector<IPerson> ret = new Vector<IPerson>();
		for (final BDACompare personAssocs : this.toPersonAssoc
				.getAssociations()) {
			ret.add((IPerson) personAssocs);
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
		return this.indirectHashCode();
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object obj) {
		return this.indirectEquals(obj);
	}

	/**
	 * Method indirectEquals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectEquals(Object)
	 */
	@Override
	public boolean indirectEquals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Role other = (Role) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
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
		result = prime
				* result
				+ ((this.description == null) ? 0 : this.description.hashCode());
		return result;
	}
}
