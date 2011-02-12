package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Closed represents the state of a completed Process of a  {@link Feature} 
 * and must not be changed. That means, any method call to a feature will 
 * result in a {@link ForbiddenStateException}, under the condition that the Feature
 * instance delegates the equal-named method to the state.
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
	public void addAcceptanceCriterion(final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void addRelation(final Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void addHint(final Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}
	
	@Override
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void removeRelation(final Relation relation)
			throws ForbiddenStateException {
		throw new ForbiddenStateException(fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void removeHint(final Hint hint) throws ForbiddenStateException {
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
