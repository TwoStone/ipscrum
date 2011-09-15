package fhdw.ipscrum.shared.model.metamodel.fields;

/**
 * Represents a Visitor for handling SingleFields and ListFields.
 */
public interface FieldVisitor {

	/**
	 * Needed for handling fields with multiplicity one.
	 * 
	 * @param singleField
	 *            is the current field
	 */
	void handleSingleField(SingleField<?> singleField);

	/**
	 * Needed for handling fields with multiplicity many.
	 * 
	 * @param listField
	 *            is the current field
	 */
	void handleListField(ListField<?> listField);
}
