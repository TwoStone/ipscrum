package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Removes a transition rule from a ticket type.
 */
public class TransitionRuleDeleteCommand extends Command<Void>
		implements ITicketTypesCommand {

	/**
	 * represents the ticketType.
	 */
	private String ticketTypeId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TransitionRuleDeleteCommand() {
		super();
	}

	/**
	 * constructor of the TransitionRuleDeleteCommand.
	 * 
	 * @param receiver
	 *            related to the command
	 * @param ticketType
	 *            related to the command
	 */
	public TransitionRuleDeleteCommand(final TransitionRule receiver,
			final TicketType ticketType) {
		super(receiver);
		this.ticketTypeId = ticketType.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {

		final TransitionRule transitionRule =
				(TransitionRule) model.getObject(this.getReceiverGuid());
		final TicketType tickettype = (TicketType) model.getObject(this.ticketTypeId);

		this.setStringValue(StringUtils
				.format("Dem Tickettypen %s wurde der Zustandsübergang von %s nach %s entfernt.",
						tickettype.getTypeName(), transitionRule.getFrom().getName(),
						transitionRule.getTo().getName()));

		tickettype.removeTransitionRule(transitionRule);
		model.removeObject(transitionRule);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTransitionRuleDeleteCommand(this);
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
