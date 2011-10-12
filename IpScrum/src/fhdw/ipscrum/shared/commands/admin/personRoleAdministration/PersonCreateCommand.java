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
 * Creates a new person.
 */
public class PersonCreateCommand extends Command<Person> implements IPersonRoleCommand {

	/**
	 * Represents the last name of the person.
	 */
	private String lastname;

	/**
	 * Represents the first name of the person.
	 */
	private String firstname;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PersonCreateCommand() {
		super();
	}

	/**
	 * Constructor of the PersonCreateCommand.
	 * 
	 * @param lastname
	 *            of the person
	 * @param firstname
	 *            of the person
	 */
	public PersonCreateCommand(final String lastname, final String firstname) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
	}

	@Override
	protected Person onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neue Person '%s %s' erstellt.", this.firstname, this.lastname));

		final Person person = new Person(model, this.firstname, this.lastname);
		return person;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePersonCreateCommand(this);
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
