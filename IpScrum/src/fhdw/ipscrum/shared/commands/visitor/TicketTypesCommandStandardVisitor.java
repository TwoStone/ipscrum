/**
 * 
 */
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
 * 
 */
public abstract class TicketTypesCommandStandardVisitor
		implements TicketTypesCommandStandardVisitorInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleBugTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand)
	 */
	@Override
	public void handleBugTicketTypeCreateCommand(
			final BugTicketTypeCreateCommand bugTicketTypeCreateCommand) {
		this.standardHandling(bugTicketTypeCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleFeatureTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand)
	 */
	@Override
	public void handleFeatureTicketTypeCreateCommand(
			final FeatureTicketTypeCreateCommand featureTicketTypeCreateCommand) {
		this.standardHandling(featureTicketTypeCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTaskTicketTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand)
	 */
	@Override
	public void handleTaskTicketTypeCreateCommand(
			final TaskTicketTypeCreateCommand taskTicketTypeCreateCommand) {
		this.standardHandling(taskTicketTypeCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleStateTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand)
	 */
	@Override
	public void handleStateTypeCreateCommand(
			final StateTypeCreateCommand stateTypeCreateCommand) {
		this.standardHandling(stateTypeCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeAddFieldTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand)
	 */
	@Override
	public void handleTicketTypeAddFieldTypeCommand(
			final TicketTypeAddFieldTypeCommand ticketTypeAddFieldTypeCommand) {
		this.standardHandling(ticketTypeAddFieldTypeCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeAddStatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand)
	 */
	@Override
	public void handleTicketTypeAddStatetypeCommand(
			final TicketTypeAddStatetypeCommand ticketTypeAddStatetypeCommand) {
		this.standardHandling(ticketTypeAddStatetypeCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeRemoveFieldTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand)
	 */
	@Override
	public void handleTicketTypeRemoveFieldTypeCommand(
			final TicketTypeRemoveFieldTypeCommand ticketTypeRemoveFieldTypeCommand) {
		this.standardHandling(ticketTypeRemoveFieldTypeCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeRemoveStateTypeCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand)
	 */
	@Override
	public void handleTicketTypeRemoveStateTypeCommand(
			final TicketTypeRemoveStateTypeCommand ticketTypeRemoveStateTypeCommand) {
		this.standardHandling(ticketTypeRemoveStateTypeCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeSetFieldTypeActivityCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes
	 * .TicketTypeSetFieldTypeActivityCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetFieldTypeActivityCommand(
					final TicketTypeSetFieldTypeActivityCommand ticketTypeSetFieldTypeActivityCommand) {
		this.standardHandling(ticketTypeSetFieldTypeActivityCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeSetStatetypeAsEndstatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin
	 * .ticketTypes.TicketTypeSetStatetypeAsEndstatetypeCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetStatetypeAsEndstatetypeCommand(
					final TicketTypeSetStatetypeAsEndstatetypeCommand ticketTypeSetStatetypeAsEndstatetypeCommand) {
		this.standardHandling(ticketTypeSetStatetypeAsEndstatetypeCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTicketTypeSetStatetypeAsStartstatetypeCommand
	 * (fhdw.ipscrum.shared.commands.admin
	 * .ticketTypes.TicketTypeSetStatetypeAsStartstatetypeCommand)
	 */
	@Override
	public
			void
			handleTicketTypeSetStatetypeAsStartstatetypeCommand(
					final TicketTypeSetStatetypeAsStartstatetypeCommand ticketTypeSetStatetypeAsStartstatetypeCommand) {
		this.standardHandling(ticketTypeSetStatetypeAsStartstatetypeCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTransitionRuleCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand)
	 */
	@Override
	public void handleTransitionRuleCreateCommand(
			final TransitionRuleCreateCommand transitionRuleCreateCommand) {
		this.standardHandling(transitionRuleCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketTypesCommandVisitor#
	 * handleTransitionRuleDeleteCommand
	 * (fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand)
	 */
	@Override
	public void handleTransitionRuleDeleteCommand(
			final TransitionRuleDeleteCommand transitionRuleDeleteCommand) {
		this.standardHandling(transitionRuleDeleteCommand);
	}

}
