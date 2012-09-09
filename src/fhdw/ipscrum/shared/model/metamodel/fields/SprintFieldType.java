package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This fieldType defines fields with objects of {@link Sprint} as content.
 */
public class SprintFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -7912707205500366155L;

	/**
	 * Constructor of the SprintFieldType.
	 * 
	 * @param model
	 *            is related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if a SprintFieldType with the same parameters already exists
	 */
	public SprintFieldType(final Model model, final String name, final Multiplicity multiplicity)
			throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected SprintFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handleSprintFieldType(this);
	}

	@Override
	protected SingleField<Sprint> createSingleField() {
		return new SingleField<Sprint>(this.getModel(), this);
	}

	@Override
	protected ListField<Sprint> createListField() {
		return new ListField<Sprint>(this.getModel(), this);
	}

}
