package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;

/**
 * Interface for Teams in Scrum. Teams represent an amount of persons.
 */
public interface ITeam extends BDACompare, Serializable, ITreeVisitorRelevantElement {
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

	public Vector<ISprint> getSprints();
	@SuppressWarnings("rawtypes")
	public OneToMany<ManyToOne, ITeam> getToSprintAssoc();

}
