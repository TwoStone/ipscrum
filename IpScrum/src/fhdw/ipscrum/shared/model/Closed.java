package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Closed represents a completed Process of a ticket / feature 
 * and must not be changed.
 */
public class Closed implements IFeatureState {
	private Feature myFeature;
	public Closed(Feature myFeature){
		this.myFeature = myFeature;
	}
	@Override
	public void accept(IFeatureVisitor visitor) {
		visitor.handleClosed(this);
	}

	@Override
	public Feature getMyFeature() {
		return this.myFeature;
	}

	@Override
	public void close() throws ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void addRelation(Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void addHint(Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((myFeature == null) ? 0 : myFeature.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Closed other = (Closed) obj;
		if (myFeature == null) {
			if (other.myFeature != null)
				return false;
		} else if (!myFeature.equals(other.myFeature))
			return false;
		return true;
	}

}
