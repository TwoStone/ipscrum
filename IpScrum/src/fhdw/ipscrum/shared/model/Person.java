package fhdw.ipscrum.shared.model;

import java.sql.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class Person implements IPerson {

	private String firstname;
	private String lastname;
	private final Vector<Role> roles;

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = new Vector<Role>();
		// TODO: Add default role "Ticketsystem-Benutzer";
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
	public Vector<Role> getRoles() {
		return roles;
	}

	@Override
	public void addRole(Role role) {
		this.getRoles().add(role);
	}

	@Override
	public void removeRole(Role role) {
		this.getRoles().remove(role);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
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
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname();
	}
}
