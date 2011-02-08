package fhdw.ipscrum.shared.model.interfaces;

import java.sql.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.model.Role;

public interface IPerson {
	
	public String getFirstname();
	public void setFirstname(String firstname);
	
	public String getLastname();
	public void setLastname(String lastname);
	
	public Date getDateOfBirth();
	public void setDateOfBirth(Date dateOfBirth);
	
	public Vector<Role> getRoles();
	public void addRole(Role role);
	public void removeRole(Role role);
}
