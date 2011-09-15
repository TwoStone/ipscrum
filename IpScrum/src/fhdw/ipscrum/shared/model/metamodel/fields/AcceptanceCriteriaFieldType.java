package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;

/**
 * This fieldType defines fields with objects of {@link AcceptanceCriterion} as content.
 */
public class AcceptanceCriteriaFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -5087190971420551385L;

	/**
	 * Constructor of the FieldType.
	 * 
	 * @param model
	 *            : the fieldType is inserted in the model
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a fieldType with the same parameters already exists
	 */
	public AcceptanceCriteriaFieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters.
	 */
	protected AcceptanceCriteriaFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleAcceptanceCriterionFieldType(this);
	}

	@Override
	protected SingleField<AcceptanceCriterion> createSingleField() {
		return new SingleField<AcceptanceCriterion>(this.getModel(), this);
	}

	@Override
	protected ListField<AcceptanceCriterion> createListField() {
		return new ListField<AcceptanceCriterion>(this.getModel(), this);
	}

}
