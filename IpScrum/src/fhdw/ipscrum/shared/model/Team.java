package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class Team implements ITeam {
	private String description;
	private final Vector<IPerson> members;

	public Team(String description) {
		super();
		this.description = description;
		this.members = new Vector<IPerson>();
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Vector<IPerson> getMembers() {
		return members;
	}

	@Override
	public void addMember(IPerson member) {
		this.getMembers().add(member);
	}

	@Override
	public void removeMember(IPerson member) {
		this.getMembers().remove(member);
	}

	@Override
	public String toString() {
		String ret = "Team";
		if (!this.getDescription().isEmpty()) {
			ret += " '" + description + "'";
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
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
		Team other = (Team) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	}
}
