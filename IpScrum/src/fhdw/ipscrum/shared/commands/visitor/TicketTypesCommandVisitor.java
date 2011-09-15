package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsEndstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsStartstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand;

/**
 * visitor for ticket type commands.
 */
public interface TicketTypesCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param bugTicketTypeCreateCommand
	 *            specific command.
	 */
	void handleBugTicketTypeCreateCommand(
			BugTicketTypeCreateCommand bugTicketTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param featureTicketTypeCreateCommand
	 *            specific command.
	 */
	void handleFeatureTicketTypeCreateCommand(
			FeatureTicketTypeCreateCommand featureTicketTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param taskTicketTypeCreateCommand
	 *            specific command.
	 */
	void handleTaskTicketTypeCreateCommand(
			TaskTicketTypeCreateCommand taskTicketTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param stateTypeCreateCommand
	 *            specific command.
	 */
	void handleStateTypeCreateCommand(StateTypeCreateCommand stateTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeAddFieldTypeCommand
	 *            specific command.
	 */
	void handleTicketTypeAddFieldTypeCommand(
			TicketTypeAddFieldTypeCommand ticketTypeAddFieldTypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeAddStatetypeCommand
	 *            specific command.
	 */
	void handleTicketTypeAddStatetypeCommand(
			TicketTypeAddStatetypeCommand ticketTypeAddStatetypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeRemoveFieldTypeCommand
	 *            specific command.
	 */
	void handleTicketTypeRemoveFieldTypeCommand(
			TicketTypeRemoveFieldTypeCommand ticketTypeRemoveFieldTypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeRemoveStateTypeCommand
	 *            specific command.
	 */
	void handleTicketTypeRemoveStateTypeCommand(
			TicketTypeRemoveStateTypeCommand ticketTypeRemoveStateTypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeSetFieldTypeActivityCommand
	 *            specific command.
	 */
			void
			handleTicketTypeSetFieldTypeActivityCommand(
					TicketTypeSetFieldTypeActivityCommand ticketTypeSetFieldTypeActivityCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeSetStatetypeAsEndstatetypeCommand
	 *            specific command.
	 */
			void
			handleTicketTypeSetStatetypeAsEndstatetypeCommand(
					TicketTypeSetStatetypeAsEndstatetypeCommand ticketTypeSetStatetypeAsEndstatetypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param ticketTypeSetStatetypeAsStartstatetypeCommand
	 *            specific command.
	 */
			void
			handleTicketTypeSetStatetypeAsStartstatetypeCommand(
					TicketTypeSetStatetypeAsStartstatetypeCommand ticketTypeSetStatetypeAsStartstatetypeCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param transitionRuleCreateCommand
	 *            specific command.
	 */
	void handleTransitionRuleCreateCommand(
			TransitionRuleCreateCommand transitionRuleCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param transitionRuleDeleteCommand
	 *            specific command.
	 */
	void handleTransitionRuleDeleteCommand(
			TransitionRuleDeleteCommand transitionRuleDeleteCommand);

}
