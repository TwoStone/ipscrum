package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class Person implements IPerson {

	private String firstname;
	private String lastname;
	private final ToRoleAssoc toRoleAssoc;

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		toRoleAssoc = new ToRoleAssoc(this);
	}

	@Override
	public ToRoleAssoc getToRoleAssoc() {
		return toRoleAssoc;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public Vector<IRole> getRoles() {
		Vector<IRole> ret = new Vector<IRole>();
		for (IRole.ToPersonAssoc roleAssocs : toRoleAssoc.getAssociations()) {
			ret.add(roleAssocs.getElement());
		}
		return ret;
	}

	@Override
	public void addRole(IRole role) throws ConsistencyException {
		if (getRoles().contains(role)) {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_ALREADY_ASSIGNED_ERROR);
		} else {
			this.getToRoleAssoc().add(role.getToPersonAssoc());
		}
	}

	@Override
	public void removeRole(IRole role) throws ConsistencyException {
		if (!getRoles().contains(role)) {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
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
		result = prime * result + ((toRoleAssoc == null) ? 0 : toRoleAssoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!indirectEquals(obj))
			return false;
		Person other = (Person) obj;
		if (toRoleAssoc == null) {
			if (other.toRoleAssoc != null)
				return false;
		} else if (!toRoleAssoc.equals(other.toRoleAssoc))
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;

	}

	@Override
	public int indirectHashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
}
