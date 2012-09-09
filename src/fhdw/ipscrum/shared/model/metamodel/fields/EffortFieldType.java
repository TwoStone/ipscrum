package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Effort;

/**
 * This fieldType defines fields with objects of {@link Effort} as content.
 */
public class EffortFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 7691476995889886032L;

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
	 *             if the fieldType with the same parameters already exists
	 */
	public EffortFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor of the FieldType without parameters.
	 */
	protected EffortFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleEffortFieldType(this);
	}

	@Override
	protected SingleField<Effort> createSingleField() {
		final SingleField<Effort> field = new SingleField<Effort>(this.getModel(), this);
		field.setValue(Effort.NULL);
		return field;
	}

	@Override
	protected ListField<Effort> createListField() {
		return new ListField<Effort>(this.getModel(), this);
	}
}
