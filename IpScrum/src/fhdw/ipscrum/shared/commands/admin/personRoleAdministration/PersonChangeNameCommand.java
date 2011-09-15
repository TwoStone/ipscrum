package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.commands.interfaces.IPersonRoleCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Changes the name of a person.
 */
public class PersonChangeNameCommand extends Command<Void>
		implements IPersonRoleCommand {

	/**
	 * Represents the first name of the person.
	 */
	private String firstname;

	/**
	 * Represents the last name of the person.
	 */
	private String lastname;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PersonChangeNameCommand() {
		super();
	}

	/**
	 * Constructor of the PersonChangeNameCommand.
	 * 
	 * @param receiver
	 *            : the person whose name should be changed
	 * @param firstname
	 *            of the person
	 * @param lastname
	 *            of the person
	 */
	public PersonChangeNameCommand(final Person receiver, final String firstname,
			final String lastname) {
		super(receiver);
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Person person = (Person) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("%s %s wurde umbenannt in %s %s.",
				person.getFirstname(), person.getLastname(), this.firstname,
				this.lastname));

		person.setFirstname(this.firstname);
		person.setLastname(this.lastname);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePersonChangeNameCommand(this);
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
