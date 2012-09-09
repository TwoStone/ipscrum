/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents the user right for creating incidents and incident types.
 */
public class ProjectHistoryRight extends Right {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8998230314871868594L;

	/**
	 * 
	 */
	protected ProjectHistoryRight() {
	}

	/**
	 * @param model
	 *            the model
	 */
	public ProjectHistoryRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new ProjectHistoryRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "Projekthistorie Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleProjectHistoryRight(this);
	}

}
