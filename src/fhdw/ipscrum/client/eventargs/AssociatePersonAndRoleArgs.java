package fhdw.ipscrum.client.eventargs;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * represents an event argument which knows also a person and some roles.
 */
public class AssociatePersonAndRoleArgs extends EventArgs {

	/**
	 * represents the person related to the event argument.
	 */
	private final Person person;
	/**
	 * represents the roles related to the event argument.
	 */
	private final List<Role> roles;

	/**
	 * Constructor for AssociatePersonAndRoleArgs.
	 * 
	 * @param person
	 *            Person
	 * @param roles
	 *            Set<IRole>
	 */
	public AssociatePersonAndRoleArgs(final Person person, final List<Role> roles) {
		super();
		this.person = person;
		this.roles = roles;
	}

	/**
	 * Method getPerson.
	 * 
	 * @return Person
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Method getRoles.
	 * 
	 * @return Set<IRole>
	 */
	public List<Role> getRoles() {
		return this.roles;
	}

	/**
	 * Method getSingleRole.
	 * 
	 * @return IRole
	 */
	public Role getSingleRole() {
		return this.roles.iterator().next();
	}
}
