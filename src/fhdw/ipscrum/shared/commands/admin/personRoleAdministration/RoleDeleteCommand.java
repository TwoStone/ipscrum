package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.commands.interfaces.IPersonRoleCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Deletes a role.
 */
public class RoleDeleteCommand extends Command<Void> implements IPersonRoleCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private RoleDeleteCommand() {
		super();
	}

	/**
	 * Constructor of the RoleDeleteCommand.
	 * 
	 * @param role
	 *            that should be deleted
	 */
	public RoleDeleteCommand(final Role role) {
		super(role);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Role role = (Role) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Rolle '%s' entfernt.", role.getDescription()));
		model.removeRole(role);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRoleDeleteCommand(this);
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
