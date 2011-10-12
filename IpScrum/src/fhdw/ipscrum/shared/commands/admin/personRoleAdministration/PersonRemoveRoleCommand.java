package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.commands.interfaces.IPersonRoleCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Removes a role from a person.
 */
public class PersonRemoveRoleCommand extends Command<Void> implements IPersonRoleCommand {

	/**
	 * Represents the role which should be removed.
	 */
	private String roleId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PersonRemoveRoleCommand() {
		super();
	}

	/**
	 * Constructor of the PersonRemoveRoleCommand.
	 * 
	 * @param receiver
	 *            : person whose role should be removed
	 * @param role
	 *            which should be removed
	 */
	public PersonRemoveRoleCommand(final Person receiver, final Role role) {
		super(receiver);
		this.roleId = role.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Person person = (Person) model.getObject(this.getReceiverGuid());
		final Role role = (Role) model.getObject(this.roleId);

		this.setStringValue(StringUtils.format("%s %s wurde die Rolle %s entzogen.", person.getFirstname(),
				person.getLastname(), role.getDescription()));

		person.removeRole(role);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePersonRemoveRoleCommand(this);
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
