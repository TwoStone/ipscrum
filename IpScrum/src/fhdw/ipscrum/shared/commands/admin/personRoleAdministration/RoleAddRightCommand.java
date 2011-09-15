/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.commands.interfaces.IPersonRoleCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.userRights.Right;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * 
 */
public class RoleAddRightCommand extends Command<Void> implements IPersonRoleCommand {
	/**
	 * ID of right to add.
	 */
	private String rigthId;

	/**
	 * default constructor.
	 */
	protected RoleAddRightCommand() {
		super();
	}

	/**
	 * creates a new RoleAddRightCOmmand.
	 * 
	 * @param receiver
	 *            role.
	 * @param right
	 *            the right to add.
	 */
	public RoleAddRightCommand(final Role receiver, final Right right) {
		super(receiver);
		this.rigthId = right.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Role role = (Role) model.getObject(this.getReceiverGuid());
		final Right right = (Right) model.getObject(this.rigthId);
		role.addRight(right);
		this.setStringValue(StringUtils.format(
				"Der Rolle %s wurde die Berechtigung %s hinzugefügt ",
				role.getDescription(), right.toString()));
		return null;

	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRoleAddRightCommand(this);

	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}
}
