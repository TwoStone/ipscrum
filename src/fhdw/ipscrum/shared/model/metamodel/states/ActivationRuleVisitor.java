package fhdw.ipscrum.shared.model.metamodel.states;

/**
 * Represents the Visitor to handle ActivationRules.
 */
public interface ActivationRuleVisitor {

	/**
	 * Needed for handling the rule active.
	 * 
	 * @param active
	 *            the current rule
	 */
	void handleActive(Active active);

	/**
	 * Needed for handling the rule nonActive.
	 * 
	 * @param nonActive
	 *            the current rule
	 */
	void handleNonActive(NonActive nonActive);
}
