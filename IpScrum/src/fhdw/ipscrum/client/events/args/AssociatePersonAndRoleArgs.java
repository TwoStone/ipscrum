package fhdw.ipscrum.client.events.args;

import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 */
public class AssociatePersonAndRoleArgs extends EventArgs {

	private IPerson person;
	private Set<IRole> roles;

	/**
	 * Constructor for AssociatePersonAndRoleArgs.
	 * @param person IPerson
	 * @param roles Set<IRole>
	 */
	public AssociatePersonAndRoleArgs(IPerson person, Set<IRole> roles) {
		super();
		this.person = person;
		this.roles = roles;
	}

	/**
	 * Method getPerson.
	 * @return IPerson
	 */
	public IPerson getPerson() {
		return this.person;
	}
	
	/**
	 * Method getRoles.
	 * @return Set<IRole>
	 */
	public Set<IRole> getRoles() {
		return this.roles;
	}
	
	/**
	 * Method getSingleRole.
	 * @return IRole
	 */
	public IRole getSingleRole() {
		return this.roles.iterator().next();
	}
}