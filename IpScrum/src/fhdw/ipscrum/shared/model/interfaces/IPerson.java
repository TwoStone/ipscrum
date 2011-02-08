package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Role;

public interface IPerson {
	
	public String getFirstname();
	public void setFirstname(String firstname);
	
	public String getLastname();
	public void setLastname(String lastname);
	
	public Vector<Role> getRoles();
	public void addRole(Role role);
	public void removeRole(Role role);
}
