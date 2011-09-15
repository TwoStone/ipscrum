package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new bug ticket type.
 */
public class BugTicketTypeCreateCommand extends Command<BugTicketType>
		implements ITicketTypesCommand {

	/**
	 * represents the name of the bug ticket type.
	 */
	private String name;

	/**
	 * represents the description of the bug ticket type.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private BugTicketTypeCreateCommand() {
		super();
	}

	/**
	 * constructor of the BugTicketTypeCreateCommand.
	 * 
	 * @param name
	 *            of the bug ticket type
	 * @param description
	 *            of the bug ticket type
	 */
	public BugTicketTypeCreateCommand(final String name, final String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	protected BugTicketType onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Bug-Tickettyp '%s' erstellt.",
				this.name));
		final BugTicketType bugTicketType =
				new BugTicketType(model, this.name, this.description);
		return bugTicketType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleBugTicketTypeCreateCommand(this);
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
