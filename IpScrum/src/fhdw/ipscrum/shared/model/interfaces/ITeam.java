package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

/**
 * Interface for Teams in Scrum. Teams represent an amount of persons.
 */
public interface ITeam extends Serializable {
	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	public String getDescription();

	/**
	 * Method setDescription.
	 * 
	 * @param description String
	 * @throws NoValidValueException thrown, if description is empty.
	 */
	public void setDescription(String description) throws NoValidValueException;

	/**
	 * Method getMembers.
	 * 
	 * @return Vector<IPerson>
	 */
	public Vector<IPerson> getMembers();

	/**
	 * Method addMember.
	 * 
	 * @param member IPerson
	 * @throws ConsistencyException thrown, if this.member already contains member
	 */
	public void addMember(IPerson member) throws ConsistencyException;

	/**
	 * Method removeMember.
	 * 
	 * @param member IPerson
	 * @throws ConsistencyException thrown, if this.member does not contain member
	 */
	public void removeMember(IPerson member) throws ConsistencyException;

}
