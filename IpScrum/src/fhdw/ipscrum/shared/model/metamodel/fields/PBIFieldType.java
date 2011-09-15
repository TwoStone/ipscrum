package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * This fieldType defines fields with objects of {@link ProductBacklogItem} as content.
 */
public class PBIFieldType extends FieldType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -2387852342370056613L;

	/**
	 * Constructor of the PBIFieldType.
	 * 
	 * @param model
	 *            related to the fieldType
	 * @param name
	 *            of the fieldType
	 * @param multiplicity
	 *            of the fieldType
	 * @throws DoubleDefinitionException
	 *             if the PBIFieldType already exist with the same parameters
	 */
	public PBIFieldType(final Model model, final String name,
			final Multiplicity multiplicity) throws DoubleDefinitionException {
		super(model, name, multiplicity);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected PBIFieldType() {
		super();
	}

	@Override
	public void accept(final FieldTypeVisitor v) {
		v.handlePBIFieldType(this);
	}

	@Override
	protected SingleField<ProductBacklogItem> createSingleField() {
		return new SingleField<ProductBacklogItem>(this.getModel(), this);
	}

	@Override
	protected ListField<ProductBacklogItem> createListField() {
		return new ListField<ProductBacklogItem>(this.getModel(), this);
	}

}
