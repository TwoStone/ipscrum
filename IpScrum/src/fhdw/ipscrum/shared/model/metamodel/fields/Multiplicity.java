package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * Multiplicity of field types. The multiplicity of a field type defines, what kind of
 * field will be returned in the operation FieldType.createField. For example, if the
 * field type has the multiplicity {@link Many}, the fields of that type are objects of
 * {@ListField}
 */
@SuppressWarnings("serial")
public abstract class Multiplicity extends IdentifiableObject {

	/**
	 * Constructor of the Multiplicity.
	 * 
	 * @param model
	 *            is related to the multiplicity
	 */
	public Multiplicity(final Model model) {
		super(model);
	}

	/**
	 * Constructor without parameters. Needed for serilization.
	 */
	protected Multiplicity() {
		super();
	}

	/**
	 * Needed for using the MultiplicityVisitor.
	 * 
	 * @param v
	 *            : concrete used Visitor
	 */
	public abstract void accept(MultiplicityVisitor v);
}
