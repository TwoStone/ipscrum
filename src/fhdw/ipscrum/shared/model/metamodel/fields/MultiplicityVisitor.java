package fhdw.ipscrum.shared.model.metamodel.fields;

/**
 * Represents the Visitor needed for handling multiplicity.
 */
public interface MultiplicityVisitor {

	/**
	 * Needed for handling the multiplicity one.
	 * 
	 * @param one
	 *            is the concrete multiplicity to handle
	 */
	void handleOne(One one);

	/**
	 * Needed for handling the multiplicity many.
	 * 
	 * @param many
	 *            is the concrete multiplicity to handle
	 */
	void handleMany(Many many);

}
