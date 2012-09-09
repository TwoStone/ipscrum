package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Adds a state type from a TicketType to the list of end state types.
 */
public class TicketTypeSetStatetypeAsEndstatetypeCommand extends Command<Void> implements ITicketTypesCommand {

	/**
	 * represents the related state type.
	 */
	private String statetypeId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TicketTypeSetStatetypeAsEndstatetypeCommand() {
		super();
	}

	/**
	 * constructor of the TicketSetStatetypeAsEndstatetypeCommand.
	 * 
	 * @param receiver
	 *            related to the command
	 * @param statetype
	 *            related to the command
	 */
	public TicketTypeSetStatetypeAsEndstatetypeCommand(final TicketType receiver, final StateType statetype) {
		super(receiver);
		this.statetypeId = statetype.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final TicketType tickettype = (TicketType) model.getObject(this.getReceiverGuid());
		final StateType statetype = (StateType) model.getObject(this.statetypeId);

		this.setStringValue(StringUtils.format("Dem Tickettypen %s wurde der Zustand %s als Endzustand zugeordnet.",
				tickettype.getTypeName(), statetype.getName()));

		tickettype.addEndState(statetype);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTicketTypeSetStatetypeAsEndstatetypeCommand(this);
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
