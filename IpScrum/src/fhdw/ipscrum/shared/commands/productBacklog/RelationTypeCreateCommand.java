package fhdw.ipscrum.shared.commands.productBacklog;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new relation type.
 */
public class RelationTypeCreateCommand extends Command<RelationType> implements IProductBacklogCommand {

	/**
	 * Represents the title of the RelationType.
	 */
	private String title;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private RelationTypeCreateCommand() {
		super();
	}

	/**
	 * Constructor of the RelationTypeCreateCommand.
	 * 
	 * @param title
	 *            of the new RelationType
	 */
	public RelationTypeCreateCommand(final String title) {
		super();
		this.title = title;
	}

	@Override
	protected RelationType onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Beziehungstyp '%s' erstellt.", this.title));

		final RelationType relationType = new RelationType(model, this.title);
		return relationType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleRelationTypeCreateCommand(this);
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
