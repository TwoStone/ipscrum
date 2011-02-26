package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

/**
 * This interface defines a set of states, which may be associated with a
 * feature. Furthermore it provides state relevant operations delegated by a
 * feature. Operations of a feature that are state-relevant, are authorized by
 * the state. Authorization means here, that an operation may be executed or
 * not. Non-authorized calls will return a {@link ForbiddenStateException}
 */
public interface IProductBacklogItemState {

	public void accept(IPBIStateVisitor visitor);

	/**
	 * See the documentation of addAcceptanceCriterion() in class
	 * {@link Feature}
	 */
	public void addAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException;

	/**
	 * See the documentation of addHint() in class {@link Feature}
	 */
	public void addHint(final Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException;

	/**
	 * See the documentation of addRelation() in class {@link Feature}
	 */
	public void addRelation(final Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException;

	/**
	 * See the documentation of close() in class {@link Feature}
	 */
	public void close() throws ForbiddenStateException;

	/**
	 * See the documentation of removeAcceptanceCriterion() in class
	 * {@link Feature}
	 */
	public void removeAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws ForbiddenStateException;

	/**
	 * See the documentation of removeHint() in class {@link Feature}
	 */
	public void removeHint(Hint hint) throws ForbiddenStateException;

	/**
	 * See the documentation of removeRelation() in class {@link Feature}
	 */
	public void removeRelation(final Relation relation)
			throws ForbiddenStateException;

	/**
	 * See the documentation of setDescription() in class {@link Feature}
	 * 
	 * @throws ForbiddenStateException
	 */
	public void setDescription(String description)
			throws ForbiddenStateException;

	public void setLastEditor(IPerson lastEditor)
			throws ForbiddenStateException;

	/**
	 * See the documentation of setManDayCosts() in class
	 * {@link ProductBacklogItem}
	 */
	public void setManDayCosts(Integer manDayCosts)
			throws ForbiddenStateException, NoValidValueException;

	/**
	 * See the documentation of setName() in class {@link ProductBacklogItem}
	 */
	public void setName(String name) throws ForbiddenStateException,
			NoValidValueException, DoubleDefinitionException,
			ConsistencyException;

	/**
	 * See the documentation of setSprint() in class {@link ProductBacklogItem}
	 */
	public void setSprint(ISprint sprint) throws ForbiddenStateException,
			NoSprintDefinedException, ConsistencyException;
}
