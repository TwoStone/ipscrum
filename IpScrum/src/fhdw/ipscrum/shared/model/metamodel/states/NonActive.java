package fhdw.ipscrum.shared.model.metamodel.states;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;

/**
 * Represents the State NonActive for the ActivationRules.
 */
public class NonActive extends ActivationRule {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -1095216090175334414L;

	/**
	 * Constructor of NonActive.
	 * 
	 * @param model
	 *            is inserted into the model
	 * @param forState
	 *            in this state is the field nonActive
	 * @param forField
	 *            the field that is nonActive in the chosen state
	 */
	public NonActive(final Model model, final StateType forState,
			final FieldType forField) {
		super(model, forState, forField);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected NonActive() {
		super();
	}

	@Override
	public void accept(final ActivationRuleVisitor v) {
		v.handleNonActive(this);
	}

}
