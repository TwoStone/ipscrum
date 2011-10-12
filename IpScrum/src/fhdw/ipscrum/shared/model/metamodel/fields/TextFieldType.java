package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;

/**
 * This fieldType defines fields with objects of {@link String} as content.
 */
public class TextFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -1351935676835963605L;

	/**
	 * Constructor of the TextFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a TextFieldType with the same parameters already exists
	 */
	public TextFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected TextFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleTextFieldType(this);
	}

	@Override
	protected SingleField<String> createSingleField() {
		return new SingleField<String>(this.getModel(), this);
	}

	@Override
	protected ListField<String> createListField() {
		return new ListField<String>(this.getModel(), this);
	}
}
