package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

public interface IRole extends BDACompare {
	public String getDescription();

	public void setDescription(String description) throws NoValidValueException;

	public Vector<IPerson> getPersons();

	public ToPersonAssoc getToPersonAssoc();

	class ToPersonAssoc extends BDAManyToMany<IPerson.ToRoleAssoc, IRole> {
		public ToPersonAssoc(IRole element) {
			super(element);
		}
	}
}
