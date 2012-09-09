package fhdw.ipscrum.shared.model.metamodel.states;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;

/**
 * Represents the State active of the activationrule for fields.
 */
public class Active extends ActivationRule {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4817853669802446241L;

	/**
	 * Constructor of Active.
	 * 
	 * @param model
	 *            is inserted into the model
	 * @param forState
	 *            the state in which the field is active
	 * @param forField
	 *            which is in this state active
	 */
	public Active(final Model model, final StateType forState, final FieldType forField) {
		super(model, forState, forField);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected Active() {
		super();
	}

	@Override
	public void accept(final ActivationRuleVisitor v) {
		v.handleActive(this);
	}

}
