package fhdw.ipscrum.shared.commands.ticketsGeneral;

import fhdw.ipscrum.shared.commands.interfaces.ITicketGeneralCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Changes the State of a ticket.
 */
public class TicketChangeStateCommand extends Command<Void> implements ITicketGeneralCommand {

	/**
	 * represents the related ticket.
	 */
	private String ticketId;

	/**
	 * represents the related state type.
	 */
	private String stateTypeId;

	/**
	 * Constructor of the Command without parameters.
	 */
	private TicketChangeStateCommand() {
		super();
	}

	/**
	 * constructor of the TicketChanfeStateCommand.
	 * 
	 * @param ticket
	 *            related to the command
	 * @param stateType
	 *            related to the command
	 */
	public TicketChangeStateCommand(final Ticket ticket, final StateType stateType) {
		this();
		this.ticketId = ticket.getId();
		this.stateTypeId = stateType.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Ticket ticket = (Ticket) model.getObject(this.ticketId);
		final StateType stateType = (StateType) model.getObject(this.stateTypeId);
		ticket.changeState(stateType);
		this.setStringValue(StringUtils.format("Status von Ticket %s auf %s geändert.", ticket.getName(),
				stateType.getName()));
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) throws NoObjectFindException {
		v.handleTicketChangeStateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

	/**
	 * Returns the ticket that belongs to the field-change-command.
	 * 
	 * @param model
	 *            the model.
	 * @return {@link Ticket}
	 * @throws NoObjectFindException
	 *             if no ticket can be found.
	 */
	public Ticket getReceiverTicket(final Model model) throws NoObjectFindException {
		return (Ticket) model.getObject(this.ticketId);

	}

}
