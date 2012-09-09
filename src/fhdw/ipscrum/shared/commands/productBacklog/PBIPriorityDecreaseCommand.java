package fhdw.ipscrum.shared.commands.productBacklog;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Decrease the priority of a product backlog item.
 */
public class PBIPriorityDecreaseCommand extends Command<Void> implements IProductBacklogCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PBIPriorityDecreaseCommand() {
		super();
	}

	/**
	 * constructor of the PBIPriorityDecreaseCommand.
	 * 
	 * @param receiver
	 *            is the attached pbi
	 */
	public PBIPriorityDecreaseCommand(final ProductBacklogItem receiver) {
		super(receiver);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final ProductBacklogItem productBacklogItem = (ProductBacklogItem) model.getObject(this.getReceiverGuid());

		this.setStringValue(StringUtils.format("Die Priorität des ProductBacklogItems %s wurde verringert.",
				productBacklogItem.getName()));

		productBacklogItem.getBacklog().moveDown(productBacklogItem);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePBIPriorityDecreaseCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return model.getBacklogByPBI((ProductBacklogItem) model.getObject(this.getReceiverGuid())).getProject();
	}

}
