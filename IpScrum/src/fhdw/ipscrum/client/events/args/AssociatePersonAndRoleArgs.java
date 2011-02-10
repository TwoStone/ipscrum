package fhdw.ipscrum.client.events.args;

import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class AssociatePersonAndRoleArgs extends EventArgs {

	private IPerson person;
	private Set<IRole> roles;

	public AssociatePersonAndRoleArgs(IPerson person, Set<IRole> roles) {
		super();
		this.person = person;
		this.roles = roles;
	}

	public IPerson getPerson() {
		return this.person;
	}
	
	public Set<IRole> getRoles() {
		return this.roles;
	}
	
	public IRole getSingleRole() {
		return this.roles.iterator().next();
	}
}