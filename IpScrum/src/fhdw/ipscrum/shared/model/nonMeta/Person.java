package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;

/**
 * Class Person.
 */
public class Person extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 7278345193465676081L;

	/**
	 * Represents the first name of the person.
	 */
	private String firstname;

	/**
	 * Represents the last name of the person.
	 */
	private String lastname;

	/**
	 * Represents the roles related to the person.
	 */
	private Vector<Role> roles;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Person() {
	}

	/**
	 * Constructor for Person.
	 * 
	 * @param model
	 *            : the person is inserted in the model
	 * @param firstname
	 *            of the person
	 * @param lastname
	 *            of the person
	 * 
	 * @throws NoValidValueException
	 *             if one of the values is not valid
	 * @throws DoubleDefinitionException
	 *             if a person with the same parameters already exists
	 */
	public Person(final Model model, final String firstname, final String lastname)
			throws NoValidValueException, DoubleDefinitionException {
		super(model);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.roles = new Vector<Role>();
		model.addPerson(this);
	}

	/**
	 * Method getFirstname.
	 * 
	 * @return String
	 */

	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Method setFirstname.
	 * 
	 * @param firstname
	 *            of the person
	 * @throws NoValidValueException
	 *             if the value is net valid
	 */

	public void setFirstname(final String firstname) throws NoValidValueException {
		if (firstname == null || firstname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {
			this.firstname = firstname;
			this.changed();
		}
	}

	/**
	 * Method getLastname.
	 * 
	 * @return the last name of the person
	 */

	public String getLastname() {
		return this.lastname;
	}

	/**
	 * Method setLastname.
	 * 
	 * @param lastname
	 *            of the person
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */

	public void setLastname(final String lastname) throws NoValidValueException {
		if (lastname == null || lastname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {

			this.lastname = lastname;
			this.changed();
		}
	}

	/**
	 * Method getRoles.
	 * 
	 * @return Vector<Role>
	 */

	public Vector<Role> getRoles() {
		return this.roles;
	}

	/**
	 * Method addRole.
	 * 
	 * @param role
	 *            is the role to add
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */

	public void addRole(final Role role) throws ConsistencyException {
		if (this.getRoles().contains(role)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_ALREADY_ASSIGNED_ERROR);
		} else {
			this.roles.add(role);
			this.changed();
		}
	}

	/**
	 * Method removeRole.
	 * 
	 * @param role
	 *            to be removed
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */

	public void removeRole(final Role role) throws ConsistencyException {
		if (!this.getRoles().contains(role)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		} else {
			this.roles.remove(role);
			this.changed();
		}
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getFirstname() + TextConstants.SPACE + this.getLastname();
	}

	/**
	 * Needed for using the Visitor.
	 * 
	 * @param treeVisitor
	 *            is the used visitor
	 */
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handlePerson(this);
	}
}
