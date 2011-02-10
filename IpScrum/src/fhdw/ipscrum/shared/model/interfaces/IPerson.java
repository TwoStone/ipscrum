package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Role;

public interface IPerson {
	
	public String getFirstname();
	public void setFirstname(String firstname);
	
	public String getLastname();
	public void setLastname(String lastname);
	
	public Vector<IRole> getRoles();
	public void addRole(IRole role);
	public void removeRole(IRole role);
}
