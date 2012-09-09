package fhdw.ipscrum.shared.model.metamodel.states;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * A transition rule determines a state transition in the knowledge layer. state transitions allow ticket system users
 * to change a state of a ticket from this.from to this.to
 */
public class TransitionRule extends IdentifiableObject {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 7005564325360924332L;

	/**
	 * Represents the state from that the transition starts.
	 */
	private StateType from;

	/**
	 * Represents the state in that the transition ends.
	 */
	private StateType to;

	/**
	 * Constructor of the TransitionRule.
	 * 
	 * @param model
	 *            it is inserted into the model
	 * @param from
	 *            is the state the transition starts
	 * @param to
	 *            is the state the transition ends
	 */
	public TransitionRule(final Model model, final StateType from, final StateType to) {
		super(model);
		this.from = from;
		this.to = to;
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected TransitionRule() {
		super();
	}

	/**
	 * Getter of the start of the transition.
	 * 
	 * @return the state the transition starts in
	 */
	public StateType getFrom() {
		return this.from;
	}

	/**
	 * Getter of the end of the transition.
	 * 
	 * @return the state the transition ends in
	 */
	public StateType getTo() {
		return this.to;
	}
}
