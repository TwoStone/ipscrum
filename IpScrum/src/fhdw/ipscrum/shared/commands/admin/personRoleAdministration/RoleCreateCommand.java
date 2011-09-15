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
 * Creates a new role.
 */
public class RoleCreateCommand extends Command<Role> implements IPersonRoleCommand {

	/**
	 * Represents the name/description of the new role.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private RoleCreateCommand() {
		super();
	}

	/**
	 * Constructor of the RoleCreateCommand.
	 * 
	 * @param description
	 *            of the new role.
	 */
	public RoleCreateCommand(final String description) {
		super();
		this.description = description;
	}

	@Override
	protected Role onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neue Rolle '%s' erstellt.",
				this.description));

		final Role role = new Role(model, this.description);
		return role;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRoleCreateCommand(this);
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
