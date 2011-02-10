package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * This interface defines a set of states, 
 * which may be associated with a feature. Operations of a feature that are
 * state-relevant, are authorized by the state.
 * Authorization means here, that an operation may be executed or not. Non-authorized
 * calls will return a {@link ForbiddenStateException}
 */
public interface IFeatureState {
	
	public void accept(IFeatureVisitor visitor);
	/**
	 * @return the {@link Feature}, which is the owner of this state
	 */
	public Feature getMyFeature();
	/**
	 *  See the documentation of close() in class {@link Feature}
	 */
	public void close() throws ForbiddenStateException;
	/**
	 *  See the documentation of addAcceptanceCriterion() in class {@link Feature}
	 */
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion)
					throws DoubleDefinitionException, ForbiddenStateException;
	/**
	 *  See the documentation of addRelation() in class {@link Feature}
	 */
	public void addRelation(Relation relation)
					throws DoubleDefinitionException, ForbiddenStateException;
	/**
	 *  See the documentation of addHint() in class {@link Feature}
	 */
	public void addHint(Hint hint)
					throws DoubleDefinitionException, ForbiddenStateException;
}
