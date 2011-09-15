package fhdw.ipscrum.shared.model.metamodel.fields;

import java.util.Iterator;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * This class represents the abstract superclass of all field types. A field type
 * determines the content of fields, which have a type reference to field types. Field
 * types are able to create concrete fields according to the multiplicity of the field
 * type, which can be one or many. For example, a field type with the multiplicity ONE,
 * the createField-Operation must return an object of SingleField. Every ticketType
 * contains a set of field types
 */
public abstract class FieldType extends IdentifiableObject {
	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4797441006985671116L;

	/**
	 * unique name of the field type.
	 */
	private String name;

	/**
	 * Decides whether field instances reference one value or a list of values.
	 */
	private Multiplicity multiplicity;

	/**
	 * result of a createField method call.
	 */
	private Field<?> result;

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
	 *             if a fieldTyp with the same parameters already exists
	 */
	public FieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model);
		this.name = name;
		this.checkFieldTypeDoublets(name);
		this.multiplicity = multiplicity;
		this.putToObjectStore();
	}

	/**
	 * default constructor for serialization.
	 */
	protected FieldType() {
		super();
	}

	/**
	 * This method checks if a field type is double defined and gets called in the public
	 * constructor of {@link FieldType}. A field type is double defined, if the model
	 * already contains a field type with the same name.
	 * 
	 * @param nameToBeChecked
	 *            the name that must be unique
	 * @throws DoubleDefinitionException
	 *             if the field type is double defined
	 */
	private void checkFieldTypeDoublets(final String nameToBeChecked)
			throws DoubleDefinitionException {
		final Iterator<FieldType> fieldTypesIterator =
				this.getModel().getTypeManager().getFieldTypes().iterator();
		while (fieldTypesIterator.hasNext()) {
			final FieldType current = fieldTypesIterator.next();
			if (current.getName().equals(nameToBeChecked)) {
				throw new DoubleDefinitionException(
						"Fehler: ein Feldtyp mit diesem Namen existiert bereits!");
			}
		}
	}

	/**
	 * Returns the unique name of the field type.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * returns the concrete multiplicity object. You can use a {@link MultiplicityVisitor}
	 * to get the right type.
	 * 
	 * @return {@link Multiplicity}
	 */
	public Multiplicity getMultiplicity() {
		return this.multiplicity;
	}

	/**
	 * Needed for using the FieldVisitor.
	 * 
	 * @param v
	 *            is the visitor for the fields
	 */
	public abstract void accept(FieldTypeVisitor v);

	/**
	 * Creates a field with type parameter specified by the specific field type. Every
	 * Class inheriting from FieldType must specifiy, which field content must be
	 * returned!
	 * 
	 * @return {@link Field}
	 */
	public Field<?> createField() {
		this.result = null;
		this.getMultiplicity().accept(new MultiplicityVisitor() {

			@Override
			public void handleOne(final One one) {
				final SingleField<?> res = FieldType.this.createSingleField();
				FieldType.this.setResult(res);
			}

			@Override
			public void handleMany(final Many many) {
				final ListField<?> res = FieldType.this.createListField();
				FieldType.this.setResult(res);
			}
		});
		return this.result;
	}

	/**
	 * creates a single field with specific type parameter.
	 * 
	 * @return a field with the multiplicity one
	 */
	protected abstract SingleField<?> createSingleField();

	/**
	 * creates a list field with specific type parameter.
	 * 
	 * @return a field with the multiplicity many
	 */
	protected abstract ListField<?> createListField();

	/**
	 * 
	 * @param res
	 *            Result of the createFieldType method call
	 */
	private void setResult(final Field<?> res) {
		this.result = res;
	}

}
