package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

public interface ITeam {
	public String getDescription();

	public void setDescription(String description);

	public Vector<IPerson> getMembers();

	public void addMember(IPerson member);

	public void removeMember(IPerson member);

}
