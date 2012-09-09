package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.PBITicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents the abstract Root Class for a ProductBacklogItem.
 */
public abstract class ProductBacklogItem extends Ticket implements PersistentObserver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket#accept(fhdw.ipscrum.
	 * shared.model.visitor.TicketVisitor)
	 */
	@Override
	public void accept(final TicketVisitor visitor) {
		visitor.handlePBI(this);
	}

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1599696800942615676L;

	/**
	 * Represents the relations related to the PBI.
	 */
	private List<Relation> relations;

	/**
	 * Default Constructor for GWT serialization.
	 */
	protected ProductBacklogItem() {
	}

	/**
	 * Constructor of the PBI.
	 * 
	 * @param model
	 *            : the PBI is inserted in the model
	 * @param type
	 *            of the PBI
	 * @param name
	 *            Name of the PBI.
	 * @param description
	 *            String
	 * @param backlog
	 *            Backlog of the PBI.
	 * @throws ForbiddenStateException
	 *             if the PBI is in a forbidden state
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws NoValidValueException
	 *             If the name for the PBI is not valid. Valid names are not null and have not only whitespace
	 *             characters.
	 * @throws DoubleDefinitionException
	 *             If the name of the PBI already exist within the product backlog
	 */
	public ProductBacklogItem(final Model model, final PBITicketType type, final String name, final String description,
			final ProductBacklog backlog)
			throws NoValidValueException, DoubleDefinitionException, ConsistencyException, ForbiddenStateException {
		super(model, type, name, description);
		this.relations = new ArrayList<Relation>();
		backlog.addItem(this);
		this.setName(name);
		this.setDescription(description);
	}

	/**
	 * Visitor pattern operation for type determination.
	 * 
	 * @param visitor
	 *            is the visitor needed for handling PBIs
	 */
	public abstract void accept(IProductBacklogItemVisitor visitor);

	/**
	 * Getter for the sprint of the PBI.
	 * 
	 * @return the sprint the PBI is related to
	 */
	public Sprint getSprint() {
		return this.getTicketType().getSprint(this);
	}

	/**
	 * Adds a acceptance criterion to the pbi.
	 * 
	 * @param acceptanceCriterion
	 *            that should be added to the pbi
	 * @throws DoubleDefinitionException
	 *             if a criterion is already added to the pbi
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state for which this method is foridden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void addAcceptanceCriterion(final String acceptanceCriterion) throws DoubleDefinitionException,
			ForbiddenStateException, ConsistencyException {
		final Iterator<String> iterator = this.getAcceptanceCriteria().iterator();
		while (iterator.hasNext()) {
			final String current = iterator.next();
			if (current.equals(acceptanceCriterion)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getTicketType().addAcceptanceCriterion(acceptanceCriterion, this);
		this.changed();
	}

	/**
	 * Adds a hint to the pbi.
	 * 
	 * @param hint
	 *            that should be added to the pbi
	 * @throws DoubleDefinitionException
	 *             if the hint is already added to the pbi
	 * @throws ConsistencyException
	 *             is the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state this method is forbidden
	 */
	public void addHint(final String hint) throws DoubleDefinitionException, ConsistencyException,
			ForbiddenStateException {
		final Iterator<String> iterator = this.getHints().iterator();
		while (iterator.hasNext()) {
			final String current = iterator.next();
			if (current.equals(hint)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getTicketType().addHint(hint, this);
		this.changed();
	}

	/**
	 * Adds a relation to the pbi.
	 * 
	 * @param relation
	 *            added to the pbi
	 * @throws DoubleDefinitionException
	 *             if the relation is already added to the pbi
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state this method is forbidden
	 */
	public void addRelation(final Relation relation) throws DoubleDefinitionException, ForbiddenStateException {
		final Iterator<Relation> iterator = this.relations.iterator();
		while (iterator.hasNext()) {
			final Relation current = iterator.next();
			if (current.equals(relation)) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		if (this.isClosed()) {
			throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
		}
		this.relations.add(relation);
		this.changed();
	}

	/**
	 * removes an acceptance criterion.
	 * 
	 * @param acceptanceCriterion
	 *            to remove
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 */
	public void removeAcceptanceCriterion(final String acceptanceCriterion) throws ConsistencyException,
			ForbiddenStateException {
		this.getTicketType().removeAcceptanceCriterion(acceptanceCriterion, this);
		this.changed();
	}

	/**
	 * removes a hint.
	 * 
	 * @param hint
	 *            to remove
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 */
	public void removeHint(final String hint) throws ConsistencyException, ForbiddenStateException {
		this.getTicketType().removeHint(hint, this);
		this.changed();
	}

	/**
	 * removes a relation.
	 * 
	 * @param relation
	 *            to remove
	 * @throws ForbiddenStateException
	 *             if the pib is in a stat the use of this method is forbidden
	 */
	public void removeRelation(final Relation relation) throws ForbiddenStateException {
		if (this.isClosed()) {
			throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
		}
		this.relations.remove(relation);
		this.changed();
	}

	@Override
	public void setDescription(final String description) throws ConsistencyException, ForbiddenStateException {
		this.getTicketType().setDescription(description, this);
		this.changed();
	}

	/**
	 * sets the last editor.
	 * 
	 * @param lastEditor
	 *            to set
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void setLastEditor(final Person lastEditor) throws ForbiddenStateException, ConsistencyException {
		this.getTicketType().setLastEditor(lastEditor, this);
		this.changed();
	}

	/**
	 * sets the man day costs.
	 * 
	 * @param manDayCosts
	 *            to set
	 * @throws NoValidValueException
	 *             if the value of the effort is nor valid
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 * @throws ConsistencyException
	 *             if the consitency is hurt
	 */
	public void setManDayCosts(final Effort manDayCosts) throws NoValidValueException, ForbiddenStateException,
			ConsistencyException {
		if (manDayCosts != null && manDayCosts.getValue() >= 0) {
			this.getTicketType().setManDayCosts(manDayCosts, this);
			this.changed();
		} else {
			throw new NoValidValueException(TextConstants.MANDAYS_ERROR);
		}
	}

	/**
	 * sets a sprint.
	 * 
	 * @param sprint
	 *            to set
	 * @throws NoSprintDefinedException
	 *             if the sprint doesn't exists in the project
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 */
	public void setSprint(final Sprint sprint) throws NoSprintDefinedException, ConsistencyException,
			ForbiddenStateException {
		if (sprint != null) {
			this.getBacklog().getProject().isSprintDefined(sprint);
			this.getTicketType().setSprint(sprint, this);
			this.changed();
		} else {
			this.getTicketType().setSprint(null, this);
		}
	}

	/**
	 * @return the acceptanceCriteria
	 */
	public List<String> getAcceptanceCriteria() {
		return Collections.unmodifiableList(this.getTicketType().getAcceptanceCriteria(this));
	}

	/**
	 * Returns the backlog of the pbi.
	 * 
	 * @return the related prodcut backlog
	 */
	public ProductBacklog getBacklog() {
		return this.getModel().getBacklogByPBI(this);
	}

	@Override
	public String getDescription() {
		return this.getTicketType().getDescription(this);
	}

	/**
	 * @return the hints
	 */
	public List<String> getHints() {
		return Collections.unmodifiableList(this.getTicketType().getHints(this));
	}

	/**
	 * Returns the last editor of the pbi.
	 * 
	 * @return the current last editor
	 */
	public Person getLastEditor() {
		return this.getTicketType().getLastEditor(this);
	}

	/**
	 * Returns the complexity of the pbi.
	 * 
	 * @return the current man day costs
	 */
	public Effort getManDayCosts() {
		return this.getTicketType().getManDayCosts(this);
	}

	/**
	 * Returns the name of the pbi.
	 * 
	 * @return the current name
	 */
	@Override
	public String getName() {
		return this.getTicketType().getName(this);
	}

	/**
	 * @return the relations
	 */
	public List<Relation> getRelations() {
		return Collections.unmodifiableList(this.relations);
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + this.getManDayCosts() + ", name=" + this.getName() + "]";
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}

	@Override
	public PBITicketType getTicketType() {
		return (PBITicketType) super.getTicketType();
	}

	@Override
	protected void checkNameValidity(final String name) throws NoValidValueException, DoubleDefinitionException,
			ConsistencyException {
		if (this.getBacklog() != null) {
			if (name != null && name.trim().length() > 0) {
				if (this.getBacklog() != null) {
					for (final ProductBacklogItem item : this.getBacklog().getItems()) {
						if (item != this && item.getName().equals(name)) {
							throw new DoubleDefinitionException(TextConstants.DOUBLE_DEFINITION_PBI);
						}
					}
				}
			} else {
				throw new NoValidValueException(TextConstants.MISSING_TEXT_ERROR);
			}
		} else {
			throw new ConsistencyException(TextConstants.PBL_PBI_ERROR);
		}

	}

	@Override
	protected void checkDescriptionValidity(final String description) throws NoValidValueException {
		// no check, all values allowed!

	}

	@Override
	public Project getProject() {
		return this.getBacklog().getProject();
	}

	/**
	 * checks if the pbi is closed.
	 * 
	 * @return true if the pbi is closed
	 */
	public boolean isClosed() {
		if (this.getTicketType().getStateProfile().getEndStates().contains(this.getCurrentState())) {
			return true;
		}

		return false;
	}

}
