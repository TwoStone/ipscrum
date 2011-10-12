/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;

/**
 * Handler for taskboard right.
 */
class TaskboardRightHandler extends RightHandler {

	/**
	 * creates a new taskboard right handler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	TaskboardRightHandler(final TaskboardRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleTaskAddPBICommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand)
	 */
	@Override
	public void handleTaskAddPBICommand(final TaskAddPBICommand taskAddPBICommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleTaskCreateCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand)
	 */
	@Override
	public void handleTaskCreateCommand(final TaskCreateCommand taskCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleTaskDeleteCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand)
	 */
	@Override
	public void handleTaskDeleteCommand(final TaskDeleteCommand taskDeleteCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleTaskRemovePBICommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand)
	 */
	@Override
	public void handleTaskRemovePBICommand(final TaskRemovePBICommand taskRemovePBICommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleTaskSetPlanEffortCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand)
	 */
	@Override
	public void handleTaskSetPlanEffortCommand(final TaskSetPlanEffortCommand taskSetPlanEffortCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleTaskSetResponsibilityCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand)
	 */
	@Override
	public void handleTaskSetResponsibilityCommand(final TaskSetResponsibilityCommand taskSetResponsibilityCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleListFieldAddValueCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldAddValueCommand(final ListFieldAddValueCommand listFieldAddValueCommand)
			throws NoObjectFindException {

		this.handleTicket(listFieldAddValueCommand.getTicket(this.getModel()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleListFieldRemoveValueCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldRemoveValueCommand(final ListFieldRemoveValueCommand listFieldRemoveValueCommand)
			throws NoObjectFindException {
		this.handleTicket(listFieldRemoveValueCommand.getTicket(this.getModel()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleSingleFieldChangeCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleSingleFieldChangeCommand(final SingleFieldChangeCommand singleFieldChangeCommand)
			throws NoObjectFindException {

		this.handleTicket(singleFieldChangeCommand.getTicket(this.getModel()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor# handleTicketChangeStateCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand)
	 */
	@Override
	public void handleTicketChangeStateCommand(final TicketChangeStateCommand ticketChangeStateCommand)
			throws NoObjectFindException {

		this.handleTicket(ticketChangeStateCommand.getReceiverTicket(this.getModel()));

	}

	/**
	 * allows actions on product backlog items and forbids actions on tasks.
	 * 
	 * @param ticket
	 *            the ticket to check.
	 */
	protected void handleTicket(final Ticket ticket) {
		ticket.accept(new TicketVisitor() {

			@Override
			public void handleTask(final Task task) {
				TaskboardRightHandler.this.allowed();

			}

			@Override
			public void handlePBI(final ProductBacklogItem pbi) {
				TaskboardRightHandler.this.notAllowed();
			}
		});
	}

}
