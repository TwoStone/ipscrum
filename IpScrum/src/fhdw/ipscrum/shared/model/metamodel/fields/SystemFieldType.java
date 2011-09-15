package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;

/**
 * This fieldType defines fields with objects of {@link System} as content.
 */
public class SystemFieldType extends FieldType {

	/**
	 * Represents the serialVersionUId.
	 */
	private static final long serialVersionUID = -1465876422700506044L;

	/**
	 * Constructor of the SystemFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a SystemFieldType with the same parameters already exists
	 */
	public SystemFieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected SystemFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleSystemFieldType(this);

	}

	@Override
	protected SingleField<fhdw.ipscrum.shared.model.nonMeta.System> createSingleField() {
		return new SingleField<fhdw.ipscrum.shared.model.nonMeta.System>(
				this.getModel(), this);
	}

	@Override
	protected ListField<fhdw.ipscrum.shared.model.nonMeta.System> createListField() {
		return new ListField<fhdw.ipscrum.shared.model.nonMeta.System>(this.getModel(),
				this);
	}

}
