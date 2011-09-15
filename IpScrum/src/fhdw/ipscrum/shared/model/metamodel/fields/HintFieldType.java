package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Hint;

/**
 * This fieldType defines fields with objects of {@link Hint} as content.
 */
public class HintFieldType extends FieldType {
	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -6691051827874554146L;

	/**
	 * Constructor of the FieldType.
	 * 
	 * @param model
	 *            : the fieldTye is inserted in the model
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a fieldType with the same parameters already exists
	 */
	public HintFieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor of the FieldType without parameters.
	 */
	protected HintFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleHintFieldType(this);
	}

	@Override
	protected SingleField<Hint> createSingleField() {
		return new SingleField<Hint>(this.getModel(), this);
	}

	@Override
	protected ListField<Hint> createListField() {
		return new ListField<Hint>(this.getModel(), this);
	}

}
