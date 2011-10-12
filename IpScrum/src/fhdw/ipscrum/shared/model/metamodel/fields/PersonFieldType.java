package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * This fieldType defines fields with objects of {@link Person} as content.
 */
public class PersonFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -52249314247107084L;

	/**
	 * Constructor of the PersonFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if the PersonFieldType with the same parameters already exists
	 */
	public PersonFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected PersonFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handlePersonFieldType(this);
	}

	@Override
	protected SingleField<Person> createSingleField() {
		return new SingleField<Person>(this.getModel(), this);
	}

	@Override
	protected ListField<Person> createListField() {
		return new ListField<Person>(this.getModel(), this);
	}
}
