/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents the right for editing projects.
 */
public class ProjectRight extends Right {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015716319906752329L;

	/**
	 * default constructor for serialization.
	 */
	protected ProjectRight() {
	}

	/**
	 * @param model
	 *            the model.
	 */
	public ProjectRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler() {
		return new ProjectRightHandler(this, this.getModel());
	}

	@Override
	public String toString() {
		return "Projekt Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleProjectRight(this);
	}
}
