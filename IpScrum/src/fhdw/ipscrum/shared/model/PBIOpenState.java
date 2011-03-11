package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * An instance of Open represents a state of a {@link ProductBacklogItem}, which
 * is in process and may be changed due to the actions executed by the process.
 */
public abstract class PBIOpenState implements IProductBacklogItemState {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758899732152472013L;

	protected PBIOpenState() {

	}

	@Override
	public void addAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
	throws DoubleDefinitionException, ForbiddenStateException {
		this.getOwner().doAddAcceptanceCriterion(acceptanceCriterion);

	}

	@Override
	public void addHint(final Hint hint) throws DoubleDefinitionException,
	ForbiddenStateException {
		this.getOwner().doAddHint(hint);

	}

	@Override
	public void addRelation(final Relation relation)
	throws DoubleDefinitionException, ForbiddenStateException {
		this.getOwner().doAddRelation(relation);

	}

	@Override
	public void close() throws ForbiddenStateException {
		this.getOwner().doClose();

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
		if (this.getOwner() == null) {
			if (other.getOwner() != null) {
				return false;
			}
		} else if (!this.getOwner().equals(other.getOwner())) {
			return false;
		}
		return true;
	}

	protected abstract ProductBacklogItem getOwner();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		+ ((this.getOwner() == null) ? 0 : this.getOwner().hashCode());
		return result;
	}

	@Override
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
	throws ForbiddenStateException {
		this.getOwner().doRemoveAcceptanceCriterion(acceptanceCriterion);

	}

	@Override
	public void removeHint(final Hint hint) throws ForbiddenStateException {
		this.getOwner().doRemoveHint(hint);
	}

	@Override
	public void removeRelation(final Relation relation)
	throws ForbiddenStateException {
		this.getOwner().doRemoveRelation(relation);
	}

	@Override
	public void setDescription(final String description) {
		this.getOwner().doSetDescription(description);
	}

	@Override
	public void setLastEditor(final IPerson lastEditor)
	throws ForbiddenStateException {
		this.getOwner().doSetLastEditor(lastEditor);
	}

	@Override
	public void setManDayCosts(final Effort manDayCosts)
	throws ForbiddenStateException, NoValidValueException {
		this.getOwner().doSetManDayCosts(manDayCosts);
	}

	@Override
	public void setName(final String name) throws ForbiddenStateException,
	NoValidValueException, DoubleDefinitionException,
	ConsistencyException {
		this.getOwner().doSetName(name);
	}

	@Override
	public void setSprint(final ISprint sprint) throws ForbiddenStateException,
	NoSprintDefinedException, ConsistencyException {
		this.getOwner().doSetSprint(sprint);
	}

}
