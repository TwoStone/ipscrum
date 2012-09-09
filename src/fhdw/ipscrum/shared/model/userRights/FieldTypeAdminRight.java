/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Right for creating field types.
 */
public class FieldTypeAdminRight extends AdminRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7990403762345944051L;

	/**
	 * default constructor for serialization.
	 */
	protected FieldTypeAdminRight() {
	}

	/**
	 * @param model
	 *            the model.
	 */
	public FieldTypeAdminRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new FieldTypeAdminRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "Feldtypen Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleFieldTypeAdminRight(this);
	}

}
