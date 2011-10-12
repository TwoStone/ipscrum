package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;

/**
 * This fieldType defines fields with objects of {@link Long} as content.
 */
public class NumberFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 5580582434556637597L;

	/**
	 * Constructor of the NumberFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a NumberFieldType with the same parameters already exists
	 */
	public NumberFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected NumberFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleNumberFieldType(this);
	}

	@Override
	protected SingleField<Long> createSingleField() {
		return new SingleField<Long>(this.getModel(), this);
	}

	@Override
	protected ListField<Long> createListField() {
		return new ListField<Long>(this.getModel(), this);
	}

}
