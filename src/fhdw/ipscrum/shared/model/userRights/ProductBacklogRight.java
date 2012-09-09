/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents the user right for editing the product backlog.
 */
public class ProductBacklogRight extends Right {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6705554562961641810L;

	/**
	 * default constructor for serialization.
	 */
	protected ProductBacklogRight() {
	}

	/**
	 * @param model
	 *            the model.
	 */
	public ProductBacklogRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new PBLRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "ProductBacklog Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleProductBacklogRight(this);
	}
}
