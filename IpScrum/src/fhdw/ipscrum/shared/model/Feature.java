package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * A feature is a {@link ProductBacklogItem}, which represents a user story. A
 * feature may contain relationships to other features. Furthermore, acceptance
 * criteria and hints can be associated. A feature can be editable in the state
 * "open" and is read-only in the state "closed".
 */
public class Feature extends /* implements */ProductBacklogItem /* IProductBacklogItem */{

	private IFeatureState state;
	private final List<Relation> relations;
	private final List<Hint> hints;
	private final List<AcceptanceCriterion> acceptanceCriteria;
	private IPerson editor;
	private String description;

	public Feature(final String name, final String description,
			final ProductBacklog backlog) throws UserException {
		super(name, backlog);
		this.state = new Open(this);
		this.setDescription(description);
		this.relations = new ArrayList<Relation>();
		this.acceptanceCriteria = new ArrayList<AcceptanceCriterion>();
		this.hints = new ArrayList<Hint>();
	}

	/**
	 * adds a new {@link AcceptanceCriterion} to a feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException
	 *             will be thrown if the acceptanceCriterion already exists
	 */
	public void addAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.state.addAcceptanceCriterion(acceptanceCriterion);
		this.notifyObservers();
	}

	/**
	 * adds a new {@link Hint} to a feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException
	 *             will be thrown if the hint already exists
	 * 
	 */
	public void addHint(final Hint hint) throws DoubleDefinitionException,
			ForbiddenStateException {
		this.state.addHint(hint);
		this.notifyObservers();
	}

	/**
	 * adds a new {@link Relation} to a feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException
	 *             will be thrown if the relation already exists
	 */
	public void addRelation(final Relation relation)
			throws DoubleDefinitionException, ForbiddenStateException {
		this.state.addRelation(relation);
		this.notifyObservers();
	}

	/**
	 * removes an {@link AcceptanceCriterion} from this feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 */
	public void removeAcceptanceCriterion(final AcceptanceCriterion criterion)
			throws ForbiddenStateException {
		this.state.removeAcceptanceCriterion(criterion);
		this.notifyObservers();

	}

	/**
	 * removes a {@link Hint} from this feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 */
	public void removeHint(final Hint hint) throws ForbiddenStateException {
		this.state.removeHint(hint);
		this.notifyObservers();
	}

	/**
	 * removes a {@link Relation} from this feature.
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the state does not allow this action
	 */
	public void removeRelation(final Relation relation)
			throws ForbiddenStateException {
		this.state.removeRelation(relation);
		this.notifyObservers();
	}

	/**
	 * Sets the state of the feature to "closed".
	 * 
	 * @throws ForbiddenStateException
	 *             will be thrown if the feature is already closed
	 */
	public void close() throws ForbiddenStateException {
		this.state.close();
		this.notifyObservers();
	}

	protected void doAddAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion)
			throws DoubleDefinitionException {
		final Iterator<AcceptanceCriterion> iterator = this.acceptanceCriteria
				.iterator();
		while (iterator.hasNext()) {
			final AcceptanceCriterion current = iterator.next();
			if (current.equals(acceptanceCriterion)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.acceptanceCriteria.add(acceptanceCriterion);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doAddHint(final Hint hint) throws DoubleDefinitionException {
		final Iterator<Hint> iterator = this.hints.iterator();
		while (iterator.hasNext()) {
			final Hint current = iterator.next();
			if (current.equals(hint)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.hints.add(hint);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doRemoveAcceptanceCriterion(
			final AcceptanceCriterion acceptanceCriterion) {
		this.acceptanceCriteria.remove(acceptanceCriterion);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doRemoveRelation(final Relation relation) {
		this.relations.remove(relation);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doRemoveHint(final Hint hint) {
		this.hints.remove(hint);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doAddRelation(final Relation relation)
			throws DoubleDefinitionException {
		final Iterator<Relation> iterator = this.relations.iterator();
		while (iterator.hasNext()) {
			final Relation current = iterator.next();
			if (current.equals(relation)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.relations.add(relation);
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	protected void doClose() {
		this.setState(new Closed(this));
	}

	/**
	 * Sets the description of the feature object.
	 * 
	 * @param description
	 * @throws ForbiddenStateException
	 */
	public void setDescription(final String description)
			throws ForbiddenStateException {
		this.getState().setDescription(description);
	}

	public List<AcceptanceCriterion> getAcceptanceCriteria() {
		return this.acceptanceCriteria;
	}

	public String getDescription() {
		return this.description;
	}

	public List<Hint> getHints() {
		return this.hints;
	}

	public List<Relation> getRelations() {
		return this.relations;
	}

	public IFeatureState getState() {
		return this.state;
	}

	protected void setState(final IFeatureState state) {
		this.state = state;
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Feature other = (Feature) obj;
		if (this.acceptanceCriteria == null) {
			if (other.acceptanceCriteria != null) {
				return false;
			}
		} else if (!this.acceptanceCriteria.equals(other.acceptanceCriteria)) {
			return false;
		}
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.editor == null) {
			if (other.editor != null) {
				return false;
			}
		} else if (!this.editor.equals(other.editor)) {
			return false;
		}
		if (this.hints == null) {
			if (other.hints != null) {
				return false;
			}
		} else if (!this.hints.equals(other.hints)) {
			return false;
		}
		if (this.relations == null) {
			if (other.relations != null) {
				return false;
			}
		} else if (!this.relations.equals(other.relations)) {
			return false;
		}
		if (this.state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!this.state.equals(other.state)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((this.acceptanceCriteria == null) ? 0
						: this.acceptanceCriteria.hashCode());
		result = prime
				* result
				+ ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result
				+ ((this.editor == null) ? 0 : this.editor.hashCode());
		result = prime * result
				+ ((this.hints == null) ? 0 : this.hints.hashCode());
		result = prime * result
				+ ((this.relations == null) ? 0 : this.relations.hashCode());
		result = prime * result
				+ ((this.state == null) ? 0 : this.state.hashCode());
		return result;
	}

	protected void doSetDescription(final String description) {
		this.description = description;
		this.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleFeature(this);
	}

}
