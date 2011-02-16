package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * Class Team
 */
public class Team implements ITeam {
	private String description;
	private Vector<IPerson> members;

	@SuppressWarnings("unused")
	private Team() {
	}

	/**
	 * Constructor for Team.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 */
	public Team(String description) throws NoValidValueException {
		super();
		setDescription(description);
		this.members = new Vector<IPerson>();
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.ITeam#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.ITeam#setDescription(String)
	 */
	@Override
	public void setDescription(String description) throws NoValidValueException {
		if (description == null || description.length() == 0) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		} else {
			this.description = description;
		}
	}

	/**
	 * Method getMembers.
	 * 
	 * @return Vector<IPerson>
	 * @see fhdw.ipscrum.shared.model.interfaces.ITeam#getMembers()
	 */
	@Override
	public Vector<IPerson> getMembers() {
		return this.members;
	}

	/**
	 * Method addMember.
	 * 
	 * @param member
	 *            IPerson
	 * @throws ConsistencyException
	 * @see fhdw.ipscrum.shared.model.interfaces.ITeam#addMember(IPerson)
	 */
	@Override
	public void addMember(IPerson member) throws ConsistencyException {
		if (members.contains(member)) {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.PERSON_ALREADY_ASSIGNED_ERROR);
		} else {
			this.getMembers().add(member);
		}
	}

	/**
	 * Method removeMember.
	 * 
	 * @param member
	 *            IPerson
	 * @throws ConsistencyException
	 * @see fhdw.ipscrum.shared.model.interfaces.ITeam#removeMember(IPerson)
	 */
	@Override
	public void removeMember(IPerson member) throws ConsistencyException {
		if (!members.contains(member)) {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.PERSON_NOT_FOUND_ERROR);
		} else {
			this.getMembers().remove(member);
		}
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String ret = "Team";
		if (!this.getDescription().isEmpty()) {
			ret += " '" + this.description + "'";
		}
		return ret;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.members == null) ? 0 : this.members.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
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
