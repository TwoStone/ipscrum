package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new feature ticket type.
 */
public class FeatureTicketTypeCreateCommand extends Command<FeatureTicketType>
		implements ITicketTypesCommand {

	/**
	 * represents the name of the feature ticket type.
	 */
	private String name;

	/**
	 * represent the description of the feature ticket type.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private FeatureTicketTypeCreateCommand() {
		super();
	}

	/**
	 * constructor of the FeatureTicketTypeCreateCommand.
	 * 
	 * @param name
	 *            of the feature ticket type
	 * @param description
	 *            of the feature ticket type
	 */
	public FeatureTicketTypeCreateCommand(final String name, final String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	protected FeatureTicketType onExecute(final Model model)
			throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format(
				"Neuer Feature-Tickettyp '%s' erstellt.", this.name));
		final FeatureTicketType featureTicketType =
				new FeatureTicketType(model, this.name, this.description);
		return featureTicketType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleFeatureTicketTypeCreateCommand(this);
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
