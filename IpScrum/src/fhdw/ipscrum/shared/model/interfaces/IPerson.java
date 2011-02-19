package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

/**
 * Interface for Persons in Scrum.
 */
public interface IPerson extends BDACompare, Serializable {

	/**
	 * Method getFirstname.
	 * 
	 * @return String
	 */
	public String getFirstname();

	/**
	 * Method setFirstname.
	 * 
	 * @param firstname
	 *            String
	 * @throws NoValidValueException
	 *             thrown, if firstname is empty.
	 */
	public void setFirstname(String firstname) throws NoValidValueException;

	/**
	 * Method getLastname.
	 * 
	 * @return String
	 */
	public String getLastname();

	/**
	 * Method setLastname.
	 * 
	 * @param lastname
	 *            String
	 * @throws NoValidValueException
	 *             : thrown, if lastname is empty.
	 */
	public void setLastname(String lastname) throws NoValidValueException;

	/**
	 * Method getRoles.
	 * 
	 * @return Vector<IRole>
	 */
	public Vector<IRole> getRoles();

	/**
	 * Method addRole.
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 *             thrown, if role is already assigned.
	 */
	public void addRole(IRole role) throws ConsistencyException;

	/**
	 * Method removeRole.
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 */
	public void removeRole(IRole role) throws ConsistencyException;

	/**
	 * Method getToRoleAssoc.
	 * 
	 * @return ToRoleAssoc
	 */
	public ManyToMany<ManyToMany, IPerson> getToRoleAssoc();

}
