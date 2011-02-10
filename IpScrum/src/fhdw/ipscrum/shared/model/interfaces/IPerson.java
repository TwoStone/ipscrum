package fhdw.ipscrum.shared.model.interfaces;

import java.util.HashSet;

public interface IPerson {
	
	public String getFirstname();
	public void setFirstname(String firstname);
	
	public String getLastname();
	public void setLastname(String lastname);
	
	public HashSet<IRole> getRoles();
	public void addRole(IRole role);
	public void removeRole(IRole role);
}
