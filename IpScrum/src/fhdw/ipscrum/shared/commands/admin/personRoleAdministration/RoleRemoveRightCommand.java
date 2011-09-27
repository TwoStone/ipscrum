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
public class RoleRemoveRightCommand extends Command<Void> implements IPersonRoleCommand {
	/**
	 * the right to remove.
	 */
	private String rightID;

	/**
	 * default constructor.
	 */
	private RoleRemoveRightCommand() {
		super();
	}

	/**
	 * creates a new RoleRemoveRightCommand.
	 * 
	 * @param receiver
	 *            the role.
	 * @param right
	 *            the right to remove.
	 */
	public RoleRemoveRightCommand(final Role receiver, final Right right) {
		super(receiver);
		this.rightID = right.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Role role = (Role) model.getObject(this.getReceiverGuid());
		final Right right = (Right) model.getObject(this.rightID);
		role.removeRight(right);
		this.setStringValue(StringUtils.format("Der Rolle %s wurde die Berechtigung %s entzogen. ",
				role.getDescription(), right.toString()));
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRoleRemoveRightCommand(this);

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
