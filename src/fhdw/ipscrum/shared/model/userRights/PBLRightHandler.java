/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand;
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
 * Handler (concrete visitor) for product backlog rights.
 */
class PBLRightHandler extends RightHandler {
	/**
	 * Creates a new PBLRightHandler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	public PBLRightHandler(final ProductBacklogRight myRight, final Model model) {
		super(myRight, model);
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

	@Override
	public void handleBugCreateCommand(final BugCreateCommand bugCreateCommand) {
		this.allowed();
	}

	@Override
	public void handleFeatureCreateCommand(final FeatureCreateCommand featureCreateCommand) {
		this.allowed();
	}

	@Override
	public void handlePBIAddRelationCommand(final PBIAddRelationCommand pBIAddRelationCommand) {
		this.allowed();
	}

	@Override
	public void handlePBIPriorityDecreaseCommand(final PBIPriorityDecreaseCommand pBIPriorityDecreaseCommand) {
		this.allowed();
	}

	@Override
	public void handlePBIPriorityIncreaseCommand(final PBIPriorityIncreaseCommand pBIPriorityIncreaseCommand) {
		this.allowed();
	}

	@Override
	public void handlePBIRemoveRelationCommand(final PBIRemoveRelationCommand pBIRemoveRelationCommand) {
		this.allowed();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldAddValueCommand(final ListFieldAddValueCommand listFieldAddValueCommand)
			throws NoObjectFindException {
		this.handleTicket(listFieldAddValueCommand.getTicket(this.getModel()));

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldRemoveValueCommand(final ListFieldRemoveValueCommand listFieldRemoveValueCommand)
			throws NoObjectFindException {
		this.handleTicket(listFieldRemoveValueCommand.getTicket(this.getModel()));

	}

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
				PBLRightHandler.this.notAllowed();

			}

			@Override
			public void handlePBI(final ProductBacklogItem pbi) {
				PBLRightHandler.this.allowed();
			}
		});
	}

}
