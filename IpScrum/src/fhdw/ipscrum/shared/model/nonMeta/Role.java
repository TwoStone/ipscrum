package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * Class Role.
 */
public class Role extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 4751308921900403733L;

	/**
	 * Represents the description of the role.
	 */
	private String description;

	/**
	 * Assigned userRights.
	 */
	private List<Right> rights;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Role() {
	}

	/**
	 * Constructor for Role.
	 * 
	 * @param model
	 *            the role is inserted in the model
	 * @param description
	 *            of the role
	 * 
	 * @throws NoValidValueException
	 *             if the value of description is not valid
	 * @throws DoubleDefinitionException
	 *             if a role with the same parameters already exists
	 */
	public Role(final Model model, final String description) throws NoValidValueException, DoubleDefinitionException {
		super(model);
		this.setDescription(description);
		this.rights = new ArrayList<Right>();
		model.addRole(this);
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.IRole#getDescription()
	 */

	public String getDescription() {
		return this.description;
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            of the role
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */

	public void setDescription(final String description) throws NoValidValueException {
		if (description != null && !description.isEmpty()) {
			this.description = description;
			this.changed();
		} else {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		}
	}

	/**
	 * Method getPersons.
	 * 
	 * @return Vector<Person>
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.IRole#getPersons()
	 */

	public Vector<Person> getPersons() {
		return this.getModel().getPersonsByRole(this);
	}

	/**
	 * @return the rights
	 */
	public List<Right> getRights() {
		return this.rights;
	}

	/**
	 * Adds a right to the role.
	 * 
	 * @param right
	 *            the right to add.
	 * @throws DoubleDefinitionException
	 *             if a right is double defined.
	 */
	public void addRight(final Right right) throws DoubleDefinitionException {
		if (this.getRights().contains(right)) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		}
		this.rights.add(right);
		this.changed();
	}

	/**
	 * Removes the right from the role.
	 * 
	 * @param right
	 *            the right to remove.
	 */
	public void removeRight(final Right right) {
		this.rights.remove(right);
		this.changed();
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

}
