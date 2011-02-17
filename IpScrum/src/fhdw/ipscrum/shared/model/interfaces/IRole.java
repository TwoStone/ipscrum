package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

/**
 * Interface for Roles in Scrum.
 */
public interface IRole extends BDACompare, Serializable {
	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	public String getDescription();

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 *             thrown, if description is empty.
	 */
	public void setDescription(String description) throws NoValidValueException;

	/**
	 * Method getPersons.
	 * 
	 * @return Vector<IPerson>
	 */
	public Vector<IPerson> getPersons();

	/**
	 * Method getToPersonAssoc.
	 * 
	 * @return ToPersonAssoc
	 */
	public ToPersonAssoc getToPersonAssoc();

	/**
	 */
	class ToPersonAssoc extends ManyToMany<IPerson.ToRoleAssoc, IRole> {
		/**
		 * Constructor for ToPersonAssoc.
		 * 
		 * @param element
		 *            IRole
		 */
		public ToPersonAssoc(final IRole element) {
			super(element);
		}
	}
}
