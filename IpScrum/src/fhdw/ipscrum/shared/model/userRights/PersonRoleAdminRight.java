/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Right for creating persons, roles and rights.
 */
public class PersonRoleAdminRight extends AdminRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3226898169877901222L;

	/**
	 * 
	 */
	protected PersonRoleAdminRight() {
	}

	/**
	 * @param model
	 *            the model.
	 */
	public PersonRoleAdminRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new PersonRoleAdminRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "Personen / Rollen Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handlePersonRoleAdminRight(this);
	}

}
