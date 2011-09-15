package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new task ticket type.
 */
public class TaskTicketTypeCreateCommand extends Command<TaskTicketType>
		implements ITicketTypesCommand {

	/**
	 * represents the name of the task ticket type.
	 */
	private String name;

	/**
	 * represents the description of the task ticket type.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TaskTicketTypeCreateCommand() {
		super();
	}

	/**
	 * constructor of the TaskTicketTypeCreateCommand.
	 * 
	 * @param name
	 *            of the new task ticket type
	 * @param description
	 *            of the nwe task ticket type
	 */
	public TaskTicketTypeCreateCommand(final String name, final String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	protected TaskTicketType onExecute(final Model model)
			throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Task-Tickettyp '%s' erstellt.",
				this.name));
		final TaskTicketType taskTicketType =
				new TaskTicketType(model, this.name, this.description);
		return taskTicketType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTaskTicketTypeCreateCommand(this);
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
