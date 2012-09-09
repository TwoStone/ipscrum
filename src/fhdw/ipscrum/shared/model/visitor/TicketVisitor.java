package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * Ticket visitor for general differentiation.
 */
public interface TicketVisitor {
	/**
	 * 
	 * @param task
	 *            visited task.
	 */
	void handleTask(Task task);

	/**
	 * 
	 * @param pbi
	 *            visited product backlog item.
	 */
	void handlePBI(ProductBacklogItem pbi);
}
