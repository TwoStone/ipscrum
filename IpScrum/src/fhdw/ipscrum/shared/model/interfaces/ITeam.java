package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

public interface ITeam {
	public String getDescription();

	public void setDescription(String description) throws NoValidValueException;

	public Vector<IPerson> getMembers();

	public void addMember(IPerson member) throws ConsistencyException;

	public void removeMember(IPerson member) throws ConsistencyException;

}
