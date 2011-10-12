/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Represents the user right for managing teams.
 */
public class TeamAdminRight extends AdminRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3215907149786511947L;

	/**
	 * default constructor for serialization.
	 */
	protected TeamAdminRight() {
	}

	/**
	 * Creates a new team admin right.
	 * 
	 * @param model
	 *            the model.
	 */
	public TeamAdminRight(final Model model) {
		super(model);
	}

	@Override
	protected RightHandler specifyHandler(final Model model) {
		return new TeamAdminRightHandler(this, model);
	}

	@Override
	public String toString() {
		return "Team Berechtigung";
	}

	@Override
	public void accept(final RightVisitor visitor) {
		visitor.handleTeamAdminRight(this);
	}

}
