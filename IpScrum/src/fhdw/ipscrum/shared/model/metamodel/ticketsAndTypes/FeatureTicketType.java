package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.PBITicketTypeVisitor;

/**
 * this class represents the knowledge layer of features. objects of this class determine the behaviour of features.
 */
public class FeatureTicketType extends PBITicketType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1072139846420139244L;

	/**
	 * Constructor of the FeatureTicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the featureTicketType
	 * @param description
	 *            of the featureTicketType
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public FeatureTicketType(final Model model, final String name, final String description)
			throws IPScrumGeneralException {
		super(model, name, description);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected FeatureTicketType() {
		super();
	}

	/**
	 * Constructor of the FeatureTicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the featureTicketType
	 * @param description
	 *            of the featureTicketType
	 * @param typeManager
	 *            : it is inserted into it
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected FeatureTicketType(final Model model, final String name, final String description,
			final TypeManager typeManager) throws IPScrumGeneralException {
		super(model, name, description, typeManager);
	}

	@Override
	public void accept(final PBITicketTypeVisitor visitor) {
		visitor.handleFeatureTicketType(this);
	}

	@Override
	public void accept(final TicketTypeVisitor v) {
		v.handleFeatureTicketType(this);
	}

}
