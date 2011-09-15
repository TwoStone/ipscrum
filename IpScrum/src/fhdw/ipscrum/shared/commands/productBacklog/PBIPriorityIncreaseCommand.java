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
 * Increase the priority of a product backlog item.
 */
public class PBIPriorityIncreaseCommand extends Command<Void>
		implements IProductBacklogCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PBIPriorityIncreaseCommand() {
		super();
	}

	/**
	 * constructor of the PBIProrityIncreaseCommand.
	 * 
	 * @param receiver
	 *            is the attached pbi
	 */
	public PBIPriorityIncreaseCommand(final ProductBacklogItem receiver) {
		super(receiver);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final ProductBacklogItem productBacklogItem =
				(ProductBacklogItem) model.getObject(this.getReceiverGuid());

		this.setStringValue(StringUtils.format(
				"Die Priorität des ProductBacklogItems %s wurde erhöht.",
				productBacklogItem.getName()));

		productBacklogItem.getBacklog().moveUp(productBacklogItem);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePBIPriorityIncreaseCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return model.getBacklogByPBI(
				(ProductBacklogItem) model.getObject(this.getReceiverGuid()))
				.getProject();
	}

}
