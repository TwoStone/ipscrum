package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class Person implements IPerson {

	private String firstname;
	private String lastname;
	private final ToRoleAssoc toRoleAssoc;

	public Person(String firstname, String lastname)
			throws NoValidValueException {
		super();
		setFirstname(firstname);
		setLastname(lastname);
		this.toRoleAssoc = new ToRoleAssoc(this);
	}

	@Override
	public ToRoleAssoc getToRoleAssoc() {
		return this.toRoleAssoc;
	}

	@Override
	public String getFirstname() {
		return this.firstname;
	}

	@Override
	public void setFirstname(String firstname) throws NoValidValueException {
		if (firstname == null || firstname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {
			this.firstname = firstname;
		}
	}

	@Override
	public String getLastname() {
		return this.lastname;
	}

	@Override
	public void setLastname(String lastname) throws NoValidValueException {
		if (lastname == null || lastname.length() == 0) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_NAME_ERROR);
		} else {

			this.lastname = lastname;
		}
	}

	@Override
	public Vector<IRole> getRoles() {
		Vector<IRole> ret = new Vector<IRole>();
		for (IRole.ToPersonAssoc roleAssocs : this.toRoleAssoc
				.getAssociations()) {
			ret.add(roleAssocs.getElement());
		}
		return ret;
	}

	@Override
	public void addRole(IRole role) throws ConsistencyException {
		if (getRoles().contains(role)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_ALREADY_ASSIGNED_ERROR);
		} else {
			this.getToRoleAssoc().add(role.getToPersonAssoc());
		}
	}

	@Override
	public void removeRole(IRole role) throws ConsistencyException {
		if (!getRoles().contains(role)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		} else {
			this.getToRoleAssoc().remove(role.getToPersonAssoc());
		}
	}

	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname();
	}

	@Override
	public int hashCode() {
		int result = this.indirectHashCode();
		final int prime = 31;
		result = prime
				* result
				+ ((this.toRoleAssoc == null) ? 0 : this.toRoleAssoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!indirectEquals(obj))
			return false;
		Person other = (Person) obj;
		if (this.toRoleAssoc == null) {
			if (other.toRoleAssoc != null)
				return false;
		} else if (!this.toRoleAssoc.equals(other.toRoleAssoc))
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
		Person other = (Person) obj;
		if (this.firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!this.firstname.equals(other.firstname))
			return false;
		if (this.lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!this.lastname.equals(other.lastname))
			return false;
		return true;

	}

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
}
