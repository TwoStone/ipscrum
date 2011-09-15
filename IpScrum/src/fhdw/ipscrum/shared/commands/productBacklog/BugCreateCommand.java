package fhdw.ipscrum.shared.commands.productBacklog;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new bug.
 */
public class BugCreateCommand extends Command<Bug> implements IProductBacklogCommand {

	/**
	 * represents the name of the bug.
	 */
	private String name;

	/**
	 * represents the description of the bug.
	 */
	private String description;

	/**
	 * represents the bug ticket type of the bug.
	 */
	private String bugTicketTypeId;

	/**
	 * represents the producktBacklog related to the bug.
	 */
	private String productBacklogId;

	/**
	 * represents the release related to the bug.
	 */
	private String releaseId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private BugCreateCommand() {
		super();
	}

	/**
	 * constructor of the BugCreateCommand.
	 * 
	 * @param name
	 *            of the bug
	 * @param description
	 *            of the bug
	 * @param bugTicketType
	 *            of the bug
	 * @param productBacklog
	 *            related to the bug
	 * @param release
	 *            related to the bug
	 */
	public BugCreateCommand(final String name, final String description,
			final BugTicketType bugTicketType, final ProductBacklog productBacklog,
			final Release release) {
		super();
		this.name = name;
		this.description = description;
		this.bugTicketTypeId = bugTicketType.getId();
		this.productBacklogId = productBacklog.getId();
		this.releaseId = release.getId();
	}

	@Override
	protected Bug onExecute(final Model model) throws IPScrumGeneralException {
		final BugTicketType bugTicketType =
				(BugTicketType) model.getObject(this.bugTicketTypeId);
		final ProductBacklog productBacklog =
				(ProductBacklog) model.getObject(this.productBacklogId);
		final Release release = (Release) model.getObject(this.releaseId);
		this.setStringValue(StringUtils.format("Neuer Bug '%s' vom Typ %s erstellt.",
				this.name, bugTicketType.getTypeName()));

		final Bug bug =
				new Bug(model, bugTicketType, this.name, this.description,
						productBacklog, release);
		return bug;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleBugCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return ((ProductBacklog) model.getObject(this.productBacklogId)).getProject();
	}
}
