package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a transition rule for a ticket type.
 */
public class TransitionRuleCreateCommand extends Command<TransitionRule> implements ITicketTypesCommand {

	/**
	 * represents the related ticketType.
	 */
	private String ticketTypeId;

	/**
	 * represents the related from state.
	 */
	private String fromId;

	/**
	 * represents the related to state.
	 */
	private String toId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TransitionRuleCreateCommand() {
		super();
	}

	/**
	 * constructor of the TransitionRuleCreateCommand.
	 * 
	 * @param ticket
	 *            related to the command
	 * @param from
	 *            is the from state related to the command
	 * @param to
	 *            is the to state related to the command
	 */
	public TransitionRuleCreateCommand(final TicketType ticket, final StateType from, final StateType to) {
		super();
		this.ticketTypeId = ticket.getId();
		this.fromId = from.getId();
		this.toId = to.getId();
	}

	@Override
	protected TransitionRule onExecute(final Model model) throws IPScrumGeneralException {
		final TicketType tickettype = (TicketType) model.getObject(this.ticketTypeId);
		final StateType from = (StateType) model.getObject(this.fromId);
		final StateType to = (StateType) model.getObject(this.toId);

		final TransitionRule transitionRule = new TransitionRule(model, from, to);

		this.setStringValue(StringUtils.format(
				"Dem Tickettypen %s wurde der Zustandsübergang von %s nach %s hinzugefügt.", tickettype.getTypeName(),
				from.getName(), to.getName()));

		tickettype.addTransitionRule(transitionRule);
		return transitionRule;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTransitionRuleCreateCommand(this);
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
