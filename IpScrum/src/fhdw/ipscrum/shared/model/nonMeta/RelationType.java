package fhdw.ipscrum.shared.model.nonMeta;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * A relation type represents a customer-specified type of a relation between features (see {@link Feature}.
 */
public class RelationType extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3978045743711269095L;

	/**
	 * Represents the description of the relationType.
	 */
	private String description;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private RelationType() {
	}

	/**
	 * Constructor of the RelationType.
	 * 
	 * @param model
	 *            the relationType is inserted into the model
	 * @param description
	 *            of the relationType
	 * @throws DoubleDefinitionException
	 *             if a realtionType with the same parameters already exists
	 */
	public RelationType(final Model model, final String description) throws DoubleDefinitionException {
		super(model);
		this.description = description;
		model.addRelationType(this);
	}

	/**
	 * Getter of the description.
	 * 
	 * @return the description of the relationType
	 */
	public String getDescription() {
		return this.description;
	}

}
