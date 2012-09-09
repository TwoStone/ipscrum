/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents the user right for the task board.
 */
public class TaskboardRight extends Right {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7140867969726652501L;

	/**
	 * default constructor for serialization.
	 */
	protected TaskboardRight() {
	}

	/**
	 * @param model
	 *            the model.
	 */
	public TaskboardRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new TaskboardRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "Taskboard Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleTaskboardRight(this);
	}

}
