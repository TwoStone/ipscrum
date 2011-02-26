package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

/**
 * An instance of Open represents a state of a {@link ProductBacklogItem}, which
 * is in process and may be changed due to the actions executed by the process.
 */
public class PBIOpenState implements IProductBacklogItemState {
	private final ProductBacklogItem myPBI;

	public PBIOpenState(final ProductBacklogItem myFeature) {
		this.myPBI = myFeature;
	}

	@Override
	public void accept(final IPBIStateVisitor visitor) {
		visitor.handleOpen(this);
	}

	@Override
	public void addAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myPBI.doAddAcceptanceCriterion(acceptanceCriterion);

	}

	@Override
	public void addHint(final Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		this.myPBI.doAddHint(hint);

	}

	@Override
	public void addRelation(final Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.myPBI.doAddRelation(relation);

	}

	@Override
	public void close() throws ForbiddenStateException {
		this.myPBI.doClose();

	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final PBIOpenState other = (PBIOpenState) obj;
		if (this.myPBI == null) {
			if (other.myPBI != null) {
				return false;
			}
		} else if (!this.myPBI.equals(other.myPBI)) {
			return false;
		}
		return true;
	}

	private ProductBacklogItem getPBI() {
		return this.myPBI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.myPBI == null) ? 0 : this.myPBI.hashCode());
		return result;
	}

	@Override
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws ForbiddenStateException {
		this.getPBI().doRemoveAcceptanceCriterion(acceptanceCriterion);

	}

	@Override
	public void removeHint(final Hint hint) throws ForbiddenStateException {
		this.getPBI().doRemoveHint(hint);
	}

	@Override
	public void removeRelation(final Relation relation)
			throws ForbiddenStateException {
		this.getPBI().doRemoveRelation(relation);
	}

	@Override
	public void setDescription(final String description) {
		this.getPBI().doSetDescription(description);
	}

	@Override
	public void setLastEditor(final IPerson lastEditor)
			throws ForbiddenStateException {
		this.getPBI().doSetLastEditor(lastEditor);
	}

	@Override
	public void setManDayCosts(final Integer manDayCosts)
			throws ForbiddenStateException, NoValidValueException {
		this.getPBI().doSetManDayCosts(manDayCosts);
	}

	@Override
	public void setName(final String name) throws ForbiddenStateException,
			NoValidValueException, DoubleDefinitionException,
			ConsistencyException {
		this.getPBI().doSetName(name);
	}

	@Override
	public void setSprint(final ISprint sprint) throws ForbiddenStateException,
			NoSprintDefinedException, ConsistencyException {
		this.getPBI().doSetSprint(sprint);
	}

}
