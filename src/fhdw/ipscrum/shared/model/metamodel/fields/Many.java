package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the multiplicity many.
 * 
 */
public class Many extends Multiplicity {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1746785294365628112L;

	/**
	 * Constructor of the multiplicity many.
	 * 
	 * @param model
	 *            : the multiplicity is inserted in the model
	 */
	public Many(final Model model) {
		super(model);
		this.putToObjectStore();
	}

	/**
	 * Constructor of the multiplicity many without parameters.
	 */
	protected Many() {
		super();
	}

	@Override
	public void accept(final MultiplicityVisitor v) {
		v.handleMany(this);
	}

}
