/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;

/**
 * Superclass for administrator rights.
 */
public abstract class AdminRight extends Right {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7465470256980815763L;

	/**
	 * default constructor for serialization.
	 */
	protected AdminRight() {
	}

	/**
	 * Creates a new administrator right.
	 * 
	 * @param model
	 *            the model.
	 */
	public AdminRight(final Model model) {
		super(model);
	}

}
