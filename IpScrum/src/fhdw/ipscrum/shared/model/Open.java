package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Open represents a state of a {@link Feature},
 * which is in process and may be changed
 * due to the actions executed by the process. 
 */
public class Open implements IFeatureState {
	private Feature myFeature;
	public Open(Feature myFeature){
		this.myFeature = myFeature;
	}
	@Override
	public void accept(IFeatureVisitor visitor) {
		visitor.handleOpen(this);
	}

	@Override
	public Feature getMyFeature() {
		return this.myFeature;
	}

	@Override
	public void close() throws ForbiddenStateException {
		this.myFeature.doClose();
		
	}

	@Override
	public void addAcceptanceCriterion(final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myFeature.doAddAcceptanceCriterion(acceptanceCriterion);
		
	}

	@Override
	public void addRelation(final Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myFeature.doAddRelation(relation);
		
	}

	@Override
	public void addHint(final Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		this.myFeature.doAddHint(hint);
		
	}
	
	@Override
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws ForbiddenStateException {
		this.getMyFeature().doRemoveAcceptanceCriterion(acceptanceCriterion);
		
	}
	@Override
	public void removeRelation(final Relation relation)
			throws ForbiddenStateException {
		this.getMyFeature().doRemoveRelation(relation);
	}
	@Override
	public void removeHint(final Hint hint) throws ForbiddenStateException {
		this.getMyFeature().doRemoveHint(hint);
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
		Open other = (Open) obj;
		if (myFeature == null) {
			if (other.myFeature != null)
				return false;
		} else if (!myFeature.equals(other.myFeature))
			return false;
		return true;
	}
}
