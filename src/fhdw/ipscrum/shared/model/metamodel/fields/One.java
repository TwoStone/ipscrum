package fhdw.ipscrum.shared.model.metamodel.fields;

import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the multiplicity one.
 */
public class One extends Multiplicity {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -7078461272139562647L;

	/**
	 * Constructor of the multiplicity One.
	 * 
	 * @param model
	 *            related to the multiplicity one
	 */
	public One(final Model model) {
		super(model);
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serilization.
	 */
	protected One() {
		super();
	}

	@Override
	public void accept(final MultiplicityVisitor v) {
		v.handleOne(this);
	}

}
