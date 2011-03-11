package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
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
 * An instance of Closed represents the state of a completed Process of a
 * {@link Feature} and must not be changed. That means, any method call to a
 * feature will result in a {@link ForbiddenStateException}, under the condition
 * that the Feature instance delegates the equal-named method to the state.
 */
public abstract class PBIClosedState implements IProductBacklogItemState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398450398352004980L;

	protected PBIClosedState() {
	}

	@Override
	public void accept(final IPBIStateVisitor visitor) {
		visitor.handleClosed(this);
	}

	@Override
	public void addAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
	throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void addHint(final Hint hint) throws DoubleDefinitionException,
	ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void addRelation(final Relation relation)
	throws DoubleDefinitionException, ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void close() throws ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void removeHint(final Hint hint) throws ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void removeRelation(final Relation relation)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				fhdw.ipscrum.shared.constants.ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setDescription(final String description)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setLastEditor(final IPerson lastEditor)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setManDayCosts(final Effort manDayCosts)
	throws ForbiddenStateException, NoValidValueException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setName(final String name) throws ForbiddenStateException,
	NoValidValueException, DoubleDefinitionException,
	ConsistencyException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setSprint(final ISprint sprint) throws ForbiddenStateException,
	NoSprintDefinedException, ConsistencyException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}
}
