/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

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
import fhdw.ipscrum.shared.model.Model;

/**
 * Handler for ticket type administration right.
 */
class TicketTypeAdminRightHandler extends RightHandler {

	/**
	 * creates a new ticket type administration right handler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	TicketTypeAdminRightHandler(final TicketTypeAdminRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleBugTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand)
	 */
	@Override
	public void handleBugTicketTypeCreateCommand(
			final BugTicketTypeCreateCommand bugTicketTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleFeatureTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand)
	 */
	@Override
	public void handleFeatureTicketTypeCreateCommand(
			final FeatureTicketTypeCreateCommand featureTicketTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTaskTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand)
	 */
	@Override
	public void handleTaskTicketTypeCreateCommand(
			final TaskTicketTypeCreateCommand taskTicketTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleStateTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand)
	 */
	@Override
	public void handleStateTypeCreateCommand(
			final StateTypeCreateCommand stateTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeAddFieldTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand)
	 */
	@Override
	public void handleTicketTypeAddFieldTypeCommand(
			final TicketTypeAddFieldTypeCommand ticketTypeAddFieldTypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeAddStatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand)
	 */
	@Override
	public void handleTicketTypeAddStatetypeCommand(
			final TicketTypeAddStatetypeCommand ticketTypeAddStatetypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeRemoveFieldTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand)
	 */
	@Override
	public void handleTicketTypeRemoveFieldTypeCommand(
			final TicketTypeRemoveFieldTypeCommand ticketTypeRemoveFieldTypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeRemoveStateTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand)
	 */
	@Override
	public void handleTicketTypeRemoveStateTypeCommand(
			final TicketTypeRemoveStateTypeCommand ticketTypeRemoveStateTypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeSetFieldTypeActivityCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes
	 * .TicketTypeSetFieldTypeActivityCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetFieldTypeActivityCommand(
					final TicketTypeSetFieldTypeActivityCommand ticketTypeSetFieldTypeActivityCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeSetStatetypeAsEndstatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin
	 * .ticketTypes.TicketTypeSetStatetypeAsEndstatetypeCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetStatetypeAsEndstatetypeCommand(
					final TicketTypeSetStatetypeAsEndstatetypeCommand ticketTypeSetStatetypeAsEndstatetypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTicketTypeSetStatetypeAsStartstatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin
	 * .ticketTypes.TicketTypeSetStatetypeAsStartstatetypeCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetStatetypeAsStartstatetypeCommand(
					final TicketTypeSetStatetypeAsStartstatetypeCommand ticketTypeSetStatetypeAsStartstatetypeCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTransitionRuleCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand)
	 */
	@Override
	public void handleTransitionRuleCreateCommand(
			final TransitionRuleCreateCommand transitionRuleCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandStandardVisitor#
	 * handleTransitionRuleDeleteCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand)
	 */
	@Override
	public void handleTransitionRuleDeleteCommand(
			final TransitionRuleDeleteCommand transitionRuleDeleteCommand) {
		this.allowed();
	}

}
