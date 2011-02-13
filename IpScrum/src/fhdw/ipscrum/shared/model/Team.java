package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class Team implements ITeam {
	private String description;
	private final Vector<IPerson> members; // TODO Christin: Warum nun doch Vector? Wenn das so bleiben soll, muss die addMember()-Methode angepasst werden!

	public Team(String description) {
		super();
		this.description = description;
		this.members = new Vector<IPerson>();
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Vector<IPerson> getMembers() {
		return this.members;
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
			ret += " '" + this.description + "'";
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.members == null) ? 0 : this.members.hashCode());
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
		if (this.description == null) {
			if (other.description != null)
				return false;
		} else if (!this.description.equals(other.description))
			return false;
		if (this.members == null) {
			if (other.members != null)
				return false;
		} else if (!this.members.equals(other.members))
			return false;
		return true;
	}
}
