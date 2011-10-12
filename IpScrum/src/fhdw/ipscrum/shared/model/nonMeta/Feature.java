package fhdw.ipscrum.shared.model.nonMeta;

import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * A feature is a {@link ProductBacklogItem}, which represents a user story. A feature may contain relationships to
 * other features. Furthermore, acceptance criteria and hints can be associated. A feature can be editable in the state
 * "open" and is read-only in the state "closed".
 */
public class Feature extends ProductBacklogItem {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 5167167800573928995L;

	/**
	 * Constructor without parameters. Needed for serialization .
	 */
	@SuppressWarnings("unused")
	private Feature() {
	}

	/**
	 * Constructor of the Feature.
	 * 
	 * @param model
	 *            : the feature is inserted in the model
	 * @param type
	 *            of the feature
	 * @param name
	 *            of the feature
	 * @param description
	 *            of the feature
	 * @param backlog
	 *            the feature is related to
	 * @throws NoValidValueException
	 *             if one value is not valid
	 * @throws DoubleDefinitionException
	 *             if a feature with the same parameters already exists
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the feature has a state that is forbidden
	 */
	public Feature(final Model model, final FeatureTicketType type, final String name, final String description,
			final ProductBacklog backlog)
			throws NoValidValueException, DoubleDefinitionException, ConsistencyException, ForbiddenStateException {
		super(model, type, name, description, backlog);
	}

	@Override
	public FeatureTicketType getTicketType() {
		return (FeatureTicketType) super.getTicketType();
	}

	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleFeature(this);
	}

}
