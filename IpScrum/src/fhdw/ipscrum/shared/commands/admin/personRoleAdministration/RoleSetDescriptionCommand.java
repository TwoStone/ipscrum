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
 * Renames a role.
 */
public class RoleSetDescriptionCommand extends Command<Void> implements IPersonRoleCommand {

	/**
	 * Represents the new description of the role.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private RoleSetDescriptionCommand() {
		super();
	}

	/**
	 * Constructor of the RoleSetDescriptionCommand.
	 * 
	 * @param receiver
	 *            : role which description should be changed
	 * @param description
	 *            of the role after the change
	 */
	public RoleSetDescriptionCommand(final Role receiver, final String description) {
		super(receiver);
		this.description = description;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Role role = (Role) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Rolle '%s' umbenannt in '%s'.", role.getDescription(), this.description));
		role.setDescription(this.description);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRoleSetDescriptionCommand(this);
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
