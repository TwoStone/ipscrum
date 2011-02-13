package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;

public interface IPerson extends BDACompare {

	public String getFirstname();

	public void setFirstname(String firstname);

	public String getLastname();

	public void setLastname(String lastname);

	public Vector<IRole> getRoles();

	public void addRole(IRole role) throws ConsistencyException;

	public void removeRole(IRole role) throws ConsistencyException;

	public ToRoleAssoc getToRoleAssoc();

	class ToRoleAssoc extends BDAManyToMany<IRole.ToPersonAssoc, IPerson> {
		public ToRoleAssoc(IPerson element) {
			super(element);
		}
	}
}
