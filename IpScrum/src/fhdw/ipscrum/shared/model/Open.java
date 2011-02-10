package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Open represents a ticket / feature which is in process and may be changed
 * due to the actions executed of the process.
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
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myFeature.doAddAcceptanceCriterion(acceptanceCriterion);
		
	}

	@Override
	public void addRelation(Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myFeature.doAddRelation(relation);
		
	}

	@Override
	public void addHint(Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		this.myFeature.doAddHint(hint);
		
	}

}
