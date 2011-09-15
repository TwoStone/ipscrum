package fhdw.ipscrum.shared.commands.productBacklog;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Adds a relation to a product backlog item.
 */
public class PBIAddRelationCommand extends Command<Void>
		implements IProductBacklogCommand {

	/**
	 * represents the relation to add.
	 */
	private String relationId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private PBIAddRelationCommand() {
		super();
	}

	/**
	 * constructor of the PBIAddRelationCommand.
	 * 
	 * @param pbi
	 *            attached
	 * @param relation
	 *            to add
	 */
	public PBIAddRelationCommand(final ProductBacklogItem pbi, final Relation relation) {
		super(pbi);
		this.relationId = relation.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final ProductBacklogItem pbi =
				(ProductBacklogItem) model.getObject(this.getReceiverGuid());
		final Relation relation = (Relation) model.getObject(this.relationId);
		this.setStringValue(StringUtils.format(
				"PBI '%s' wurde eine Abhängigkeit hinzugefügt.", pbi.getName()));
		pbi.addRelation(relation);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePBIAddRelationCommand(this);
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
