package fhdw.ipscrum.shared.model.metamodel.states;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;

/**
 * Represents the ActivationRule.
 */
public abstract class ActivationRule extends IdentifiableObject {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3488222056348298745L;

	/**
	 * Represents the affected state.
	 */
	private StateType forState;

	/**
	 * Represents the affected field.
	 */
	private FieldType forField;

	/**
	 * Constructor of the ActivationRule.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param forState
	 *            is the affected state
	 * @param forField
	 *            is the affected field
	 */
	public ActivationRule(final Model model, final StateType forState, final FieldType forField) {
		super(model);
		this.forField = forField;
		this.forState = forState;
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected ActivationRule() {
		super();
	}

	/**
	 * Getter of the affected state.
	 * 
	 * @return the affected state
	 */
	public final StateType getForState() {
		return this.forState;
	}

	/**
	 * Getter of the affected field.
	 * 
	 * @return the affected field
	 */
	public final FieldType getForField() {
		return this.forField;
	}

	/**
	 * Needed to use the ActivationRuleVisitor.
	 * 
	 * @param v
	 *            is the current visitor
	 */
	public abstract void accept(ActivationRuleVisitor v);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.forField == null ? 0 : this.forField.hashCode());
		result = prime * result + (this.forState == null ? 0 : this.forState.hashCode());
		return result;
	}

	@Override
	/*
	 * Prüft nur, ob forField und forState identisch sind!
	 */
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof ActivationRule) {

			final ActivationRule other = (ActivationRule) obj;
			if (this.forField == null) {
				if (other.forField != null) {
					return false;
				}
			} else if (!this.forField.equals(other.forField)) {
				return false;
			}
			if (this.forState == null) {
				if (other.forState != null) {
					return false;
				}
			} else if (!this.forState.equals(other.forState)) {
				return false;
			}
			return true;
		}
		return false;
	}

}
