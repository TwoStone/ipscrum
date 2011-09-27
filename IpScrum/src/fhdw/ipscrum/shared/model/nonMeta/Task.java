package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.model.SprintAssociationException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;

/**
 * Represents the Task.
 */
public class Task extends Ticket {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -7493025129803401507L;

	/**
	 * Ordinary Constructor for Tasks.
	 * 
	 * @param model
	 *            : the task is inserted in the model
	 * @param ticketType
	 *            of the task
	 * 
	 * @param name
	 *            pass a short name to the task
	 * @param description
	 *            pass a more detailed description
	 * @param sprintBacklog
	 *            the task is related to
	 * @throws NoValidValueException
	 *             is thrown if name or description is empty.
	 * @throws DoubleDefinitionException
	 *             if a task with the same parameters already exists
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public Task(final Model model, final TaskTicketType ticketType, final String name, final String description,
			final SprintBacklog sprintBacklog)
			throws NoValidValueException, ConsistencyException, ForbiddenStateException, DoubleDefinitionException {
		super(model, ticketType, name, description);
		this.setName(name);
		this.setDescription(description);
		sprintBacklog.addTask(this);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected Task() {
		super();
	}

	@Override
	public TaskTicketType getTicketType() {
		return (TaskTicketType) super.getTicketType();
	}

	/**
	 * Getter of the sprintBacklog.
	 * 
	 * @return the sprintBacklog the task is related to
	 */
	public SprintBacklog getSprintBacklog() {
		return this.getModel().getSprintBacklogByTask(this);
	}

	/**
	 * Adds a pbi to the task.
	 * 
	 * @param pbi
	 *            that is added to the task
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 * @throws SprintAssociationException
	 *             if the pbi is in the wrong sprint
	 * @throws DoubleDefinitionException
	 *             if the pbi is already related to the task
	 * @throws ConsistencyException
	 *             is the consitency is hurt
	 */
	public void addPBI(final ProductBacklogItem pbi) throws ForbiddenStateException, SprintAssociationException,
			DoubleDefinitionException, ConsistencyException {
		this.getTicketType().addPBI(pbi, this);
		this.changed();
	}

	/**
	 * Checks the consistency by adding a pbi to a task.
	 * 
	 * @param pbi
	 *            that should be added
	 * @throws SprintAssociationException
	 *             if the pbi is in the wrong sprint
	 * @throws DoubleDefinitionException
	 *             if the pbi is already related to the task
	 */
	public void checkAddPBIConsistency(final ProductBacklogItem pbi) throws SprintAssociationException,
			DoubleDefinitionException {
		final Iterator<ProductBacklogItem> i = this.getAssignedPBIs().iterator();
		while (i.hasNext()) {
			final ProductBacklogItem current = i.next();
			if (current.equals(pbi)) {
				throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		if (pbi.getSprint() == null) {
			throw new SprintAssociationException(ExceptionConstants.PBI_NOT_IN_SPRINT_ERROR);
		}
		if (!pbi.getSprint().getSprintBacklog().hasTask(this)) {
			throw new SprintAssociationException(ExceptionConstants.PBI_NOT_IN_SPRINT_ERROR);
		}
	}

	/**
	 * Getter of the finishDate.
	 * 
	 * @return the date the task was finished
	 */
	public Date getFinishDate() {
		return this.getTicketType().getFinishDate(this);
	}

	/**
	 * Getter of the planEffort.
	 * 
	 * @return the planEffort of the task
	 */
	public Effort getPlanEffort() {
		return this.getTicketType().getPlanEffort(this);
	}

	/**
	 * Getter of the responsiblePerson.
	 * 
	 * @return the person responsible for the task
	 */
	public Person getResponsiblePerson() {
		return this.getTicketType().getResponsiblePerson(this);
	}

	/**
	 * checks if the task has got a reponsible person.
	 * 
	 * @return true if there is a responsibl person or false if not
	 */
	public boolean hasResponsiblePerson() {
		return this.getTicketType().hasResponsiblePerson(this);
	}

	/**
	 * removes a pbi from the task.
	 * 
	 * @param pbi
	 *            that should be removed from the task
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void removePBI(final ProductBacklogItem pbi) throws ForbiddenStateException, ConsistencyException {
		this.getTicketType().removePBI(pbi, this);
		this.changed();
	}

	/**
	 * Sets the responsible person of the task.
	 * 
	 * @param person
	 *            that is responsible for the task
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 * @throws SprintAssociationException
	 *             if the associated sprint is wrong
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void setResponsibility(final Person person) throws ForbiddenStateException, SprintAssociationException,
			ConsistencyException {
		this.getTicketType().setResponsibility(person, this);
		this.changed();
	}

	/**
	 * Setter of the planEffort.
	 * 
	 * @param planEffort
	 *            of the task
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void setPlanEffort(final Effort planEffort) throws ForbiddenStateException, ConsistencyException {
		this.getTicketType().setPlanEffort(planEffort, this);
		this.changed();
	}

	/**
	 * Getter of the assigned pbis.
	 * 
	 * @return all assigned pbis
	 */
	public List<ProductBacklogItem> getAssignedPBIs() {
		return this.getTicketType().getAssignedPBIs(this);
	}

	/**
	 * checks if the task is related to the pbis.
	 * 
	 * @param pbi
	 *            that is checked if it is related to the task
	 * @return true if the task is related to the pbi and false if not
	 */
	public boolean hasPBI(final ProductBacklogItem pbi) {
		boolean result = false;
		final Iterator<ProductBacklogItem> pbiIterator = this.getAssignedPBIs().iterator();
		while (pbiIterator.hasNext()) {
			final ProductBacklogItem current = pbiIterator.next();
			if (current.equals(pbi)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * This operation enforces a PBI to be removed, even if it is in the state InProgress. To keep revision safety, it
	 * won't be removed from a finished Task
	 * 
	 * @param pbi
	 *            the pbi that should be removed
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 */
	public void enforceRemovePBI(final ProductBacklogItem pbi) throws ForbiddenStateException, ConsistencyException {
		this.getTicketType().removePBI(pbi, this);
	}

	/**
	 * Checks if the task is finished.
	 * 
	 * @return true if the task is finished and false if not
	 */
	public boolean isFinished() {
		boolean result = false;
		if (this.getTicketType().getStateProfile().getEndStates().contains(this.getCurrentState())) {
			result = true;
		}
		return result;
	}

	/**
	 * Sets the Date the task was finished.
	 * 
	 * @param date
	 *            of the day the task was finished
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 */
	public void setFinishDate(final Date date) throws ConsistencyException, ForbiddenStateException {
		this.getTicketType().setFinishDate(date, this);
		this.changed();
	}

	@Override
	protected void checkNameValidity(final String name) throws NoValidValueException, DoubleDefinitionException {
		if (name.equals(TextConstants.EMPTY_TEXT)) {
			throw new NoValidValueException(ExceptionConstants.EMPTY_NAME_ERROR);
		}
	}

	@Override
	protected void checkDescriptionValidity(final String description) throws NoValidValueException {
		if (description.equals(TextConstants.EMPTY_TEXT)) {
			throw new NoValidValueException(ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		}
	}

	@Override
	public Project getProject() {
		return this.getSprintBacklog().getSprint().getProject();
	}

	@Override
	public void accept(final TicketVisitor visitor) {
		visitor.handleTask(this);
	}

}
