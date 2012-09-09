package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * This fieldType defines fields with objects of {@link Release} as content.
 */
public class ReleaseFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 4011874110459138502L;

	/**
	 * Constructor of the ReleaseFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a ReleaseFieldType with the same parameters already exists.
	 */
	public ReleaseFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected ReleaseFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleReleaseFieldType(this);
	}

	@Override
	protected SingleField<Release> createSingleField() {
		return new SingleField<Release>(this.getModel(), this);
	}

	@Override
	protected ListField<Release> createListField() {
		return new ListField<Release>(this.getModel(), this);
	}

}
