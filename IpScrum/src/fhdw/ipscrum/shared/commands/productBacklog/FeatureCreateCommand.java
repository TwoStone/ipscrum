package fhdw.ipscrum.shared.commands.productBacklog;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new feature.
 */
public class FeatureCreateCommand extends Command<Feature>
		implements IProductBacklogCommand {

	/**
	 * represents the name of the feature.
	 */
	private String name;

	/**
	 * represents the description of the feature.
	 */
	private String description;

	/**
	 * represents the feature ticket type of the feature.
	 */
	private String featureTicketTypeId;

	/**
	 * represents the productBacklog the feature is related to.
	 */
	private String productBacklogId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private FeatureCreateCommand() {
		super();
	}

	/**
	 * constructor of the FeatureCreatCommand.
	 * 
	 * @param name
	 *            of the feature
	 * @param description
	 *            of the feature
	 * @param featureTicketType
	 *            of the feature
	 * @param productBacklog
	 *            related to the feature
	 */
	public FeatureCreateCommand(final String name, final String description,
			final FeatureTicketType featureTicketType,
			final ProductBacklog productBacklog) {
		super();
		this.name = name;
		this.description = description;
		this.featureTicketTypeId = featureTicketType.getId();
		this.productBacklogId = productBacklog.getId();
	}

	@Override
	protected Feature onExecute(final Model model) throws IPScrumGeneralException {
		final FeatureTicketType featureTicketType =
				(FeatureTicketType) model.getObject(this.featureTicketTypeId);
		final ProductBacklog productBacklog =
				(ProductBacklog) model.getObject(this.productBacklogId);
		this.setStringValue(StringUtils.format(
				"Neues Feature '%s' vom Typ %s erstellt.", this.name,
				featureTicketType.getTypeName()));

		final Feature feature =
				new Feature(model, featureTicketType, this.name, this.description,
						productBacklog);
		return feature;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleFeatureCreateCommand(this);
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
