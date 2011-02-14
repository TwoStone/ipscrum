package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;

public interface ITeam {
	public String getDescription();

	public void setDescription(String description);

	public Vector<IPerson> getMembers();

	public void addMember(IPerson member) throws ConsistencyException;

	public void removeMember(IPerson member) throws ConsistencyException;

}
