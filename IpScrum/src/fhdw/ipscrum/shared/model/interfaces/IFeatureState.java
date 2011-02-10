package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * This interface defines a set of states which may be associated with a feature.
 */
public interface IFeatureState {
	
	void accept(IFeatureVisitor visitor);
	Feature getMyFeature();
	
	void close() throws ForbiddenStateException;
	void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion)
					throws DoubleDefinitionException, ForbiddenStateException;
	void addRelation(Relation relation)
					throws DoubleDefinitionException, ForbiddenStateException;
	void addHint(Hint hint)
					throws DoubleDefinitionException, ForbiddenStateException;
}
