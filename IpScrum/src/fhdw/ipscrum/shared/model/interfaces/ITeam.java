package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Person;

public interface ITeam {
	public String getDescription();
	public void setDescription(String description);
	
	public Vector<Person> getMembers();
	public void addMember(Person member);
	public void removeMember(Person member);
}
