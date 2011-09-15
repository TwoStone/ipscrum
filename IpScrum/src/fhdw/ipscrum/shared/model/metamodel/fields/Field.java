package fhdw.ipscrum.shared.model.metamodel.fields;

import java.io.Serializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * A Field represents a standard or additional attribute of a ticket. Nearly all
 * attributes of tickets are modeled as fields. a field can be single- or multi-valued.
 * Fields may not be instantiated externally, because that must be done by the field-type,
 * which determines the type-specific content of the field. fields are referenced by
 * instances of {@link Ticket}. Furthermore, tickets are wrappers for values type T.
 * 
 * @param <T>
 *            determines the type of the value, which is wrapped by the field.
 */
@SuppressWarnings("serial")
public abstract class Field<T extends Serializable> extends IdentifiableObject {

	/**
	 * represents the type of a field. A Field never changes its type.
	 */
	private FieldType type;

	/**
	 * Constructor of the Field without parameters.
	 */
	protected Field() {
		super();
	}

	/**
	 * Constructor of the Field.
	 * 
	 * @param model
	 *            : the Field is inserted in the model
	 * @param type
	 *            of the field
	 */
	public Field(final Model model, final FieldType type) {
		super(model);
		this.type = type;
	}

	/**
	 * Needed for using the FieldVisitor.
	 * 
	 * @param v
	 *            is the visitor for the fields
	 */
	public abstract void accept(FieldVisitor v);

	/**
	 * returns the field type.
	 * 
	 * @return the type of the field
	 */
	public FieldType getType() {
		return this.type;
	}
}
