package fhdw.ipscrum.shared.model.metamodel.fields;

import java.util.Date;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;

/**
 * This fieldType defines fields with objects of {@link java.util.Date} as content.
 */
public class DateFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -6355079770414696298L;

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
	public DateFieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor of the FieldType without parameters.
	 */
	protected DateFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleDateFieldType(this);
	}

	@Override
	protected SingleField<Date> createSingleField() {
		return new SingleField<Date>(this.getModel(), this);
	}

	@Override
	protected ListField<Date> createListField() {
		return new ListField<Date>(this.getModel(), this);
	}

}
