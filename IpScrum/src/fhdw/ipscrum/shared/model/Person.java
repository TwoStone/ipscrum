package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;

/**
 * Class Person.
 */
public class Person implements IPerson {

	private static final long serialVersionUID = 7278345193465676081L;
	private String firstname;
	private String lastname;
	private ManyToMany<ManyToMany<?, ?>, IPerson> toRoleAssoc;

	@SuppressWarnings("unused")
	private Person() {
	}

	/**
	 * Constructor for Person.
	 * 
	 * @param firstname
	 *            String
	 * @param lastname
	 *            String
	 * @throws NoValidValueException
	 */
	public Person(final String firstname, final String lastname)
			throws NoValidValueException {
		super();
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.toRoleAssoc = new ManyToMany<ManyToMany<?, ?>, IPerson>(this);
	}

	/**
	 * Method getToRoleAssoc.
	 * 
	 * @return ToRoleAssoc
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#getToRoleAssoc()
	 */
	@Override
	public ManyToMany<ManyToMany<?, ?>, IPerson> getToRoleAssoc() {
		return this.toRoleAssoc;
	}

	/**
	 * Method getFirstname.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#getFirstname()
	 */
	@Override
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Method setFirstname.
	 * 
	 * @param firstname
	 *            String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#setFirstname(String)
	 */
	@Override
	public void setFirstname(final String firstname)
			throws NoValidValueException {
		if (firstname == null || firstname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {
			this.firstname = firstname;
		}
	}

	/**
	 * Method getLastname.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#getLastname()
	 */
	@Override
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * Method setLastname.
	 * 
	 * @param lastname
	 *            String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#setLastname(String)
	 */
	@Override
	public void setLastname(final String lastname) throws NoValidValueException {
		if (lastname == null || lastname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {

			this.lastname = lastname;
		}
	}

	/**
	 * Method getRoles.
	 * 
	 * @return Vector<IRole>
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#getRoles()
	 */
	@Override
	public Vector<IRole> getRoles() {
		final Vector<IRole> ret = new Vector<IRole>();
		for (final BDACompare roleAssocs : this.toRoleAssoc.getAssociations()) {
			ret.add((IRole) roleAssocs);
		}
		return ret;
	}

	/**
	 * Method addRole.
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#addRole(IRole)
	 */
	@Override
	public void addRole(final IRole role) throws ConsistencyException {
		this.getToRoleAssoc().add(role.getToPersonAssoc());
		// if (getRoles().contains(role)) {
		// throw new
		// ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_ALREADY_ASSIGNED_ERROR);
		// } else {
		// this.getToRoleAssoc().add(role.getToPersonAssoc());
		// }
	}

	/**
	 * Method removeRole.
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 * @see fhdw.ipscrum.shared.model.interfaces.IPerson#removeRole(IRole)
	 */
	@Override
	public void removeRole(final IRole role) throws ConsistencyException {
		if (!this.getRoles().contains(role)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		} else {
			this.getToRoleAssoc().remove(role.getToPersonAssoc());
		}
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname();
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
		final Person other = (Person) obj;
		if (this.firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!this.firstname.equals(other.firstname)) {
			return false;
		}
		if (this.lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!this.lastname.equals(other.lastname)) {
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
		int result = 1;
		final int prime = 31;
		result = prime * result
				+ ((this.firstname == null) ? 0 : this.firstname.hashCode());
		result = prime * result
				+ ((this.lastname == null) ? 0 : this.lastname.hashCode());
		return result;
	}

	@Override
	public void accept(ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handlePerson(this);
	}
}
