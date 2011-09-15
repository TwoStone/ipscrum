package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.SprintAssociationException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * This class represents the knowledge layer of task-tickets. objects of this class
 * determine the behaviour of tasks.
 */
public class TaskTicketType extends TicketType {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4601567713978145010L;

	/**
	 * represents the field for the plan effort.
	 */
	private EffortFieldType planEffortType;

	/**
	 * represents the field for the responsible person.
	 */
	private PersonFieldType responsiblePersonType;

	/**
	 * represents the field of the assigned PBIs.
	 */
	private PBIFieldType assignedPBIsType;

	/**
	 * represents the field for the finished date.
	 */
	private DateFieldType finishDateType;

	/**
	 * constructor of the taskTicketType.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param name
	 *            of the taskTicketType
	 * @param description
	 *            of the taskTicketType
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public TaskTicketType(final Model model, final String name, final String description)
			throws IPScrumGeneralException {
		super(model, name, description);
	}

	/**
	 * constructor without parameters. needed for serialization.
	 */
	protected TaskTicketType() {
		super();
	}

	/**
	 * constructor of the TaskTicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the TaskTicketType
	 * @param description
	 *            of the TaskTicketType
	 * @param typeManager
	 *            : it is inserted in the typeManager
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected TaskTicketType(final Model model, final String name,
			final String description, final TypeManager typeManager)
			throws IPScrumGeneralException {
		super(model, name, description, typeManager);
	}

	@Override
	public void accept(final TicketTypeVisitor v) {
		v.handleTaskTicketType(this);
	}

	/**
	 * adds a PBI.
	 * 
	 * @param pbi
	 *            to ass
	 * @param task
	 *            attached
	 * @throws ForbiddenStateException
	 *             if the taskTicket is in the wrong state to use this method
	 * @throws SprintAssociationException
	 *             if the pbi is in the wrong sprint
	 * @throws DoubleDefinitionException
	 *             if the pbi is already added to the task
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void addPBI(final ProductBacklogItem pbi, final Task task)
			throws ForbiddenStateException, SprintAssociationException,
			DoubleDefinitionException, ConsistencyException {
		task.checkAddPBIConsistency(pbi);
		@SuppressWarnings("unchecked")
		final ListField<ProductBacklogItem> target =
				(ListField<ProductBacklogItem>) this.getField(
						this.getAssignedPBIsType(), task);
		target.addValue(pbi, task);
	}

	/**
	 * getter of all PBIs assigned to the task.
	 * 
	 * @param task
	 *            attached
	 * @return all PBIs
	 */
	@SuppressWarnings("unchecked")
	public List<ProductBacklogItem> getAssignedPBIs(final Task task) {
		return ((ListField<ProductBacklogItem>) this.getField(
				this.getAssignedPBIsType(), task)).getValues();
	}

	/**
	 * getter of the field for the assigned PBI.
	 * 
	 * @return the assigned PBI field
	 */
	public PBIFieldType getAssignedPBIsType() {
		return this.assignedPBIsType;
	}

	/**
	 * getter of the finished date.
	 * 
	 * @param task
	 *            attached
	 * @return the finished date
	 */
	@SuppressWarnings("unchecked")
	public Date getFinishDate(final Task task) {
		return ((SingleField<Date>) this.getField(this.finishDateType, task))
				.getValue();
	}

	/**
	 * getter of the field type of the finished date.
	 * 
	 * @return the finished date field
	 */
	public DateFieldType getFinishDateType() {
		return this.finishDateType;
	}

	/**
	 * getter of the plan effort.
	 * 
	 * @param task
	 *            attached
	 * @return the plan effort of the attached task
	 */
	@SuppressWarnings("unchecked")
	public Effort getPlanEffort(final Task task) {
		return ((SingleField<Effort>) this.getField(this.planEffortType, task))
				.getValue();
	}

	/**
	 * Getter of the field for the plan effort.
	 * 
	 * @return the plan effort field
	 */
	public EffortFieldType getPlanEffortType() {
		return this.planEffortType;
	}

	/**
	 * Getter for the responsible person.
	 * 
	 * @param task
	 *            attached
	 * @return the responsible person
	 */
	@SuppressWarnings("unchecked")
	public Person getResponsiblePerson(final Task task) {
		return ((SingleField<Person>) this.getField(this.responsiblePersonType, task))
				.getValue();
	}

	/**
	 * Getter of the field for the responsible person.
	 * 
	 * @return the current field for the responsible person
	 */
	public PersonFieldType getResponsiblePersonType() {
		return this.responsiblePersonType;
	}

	/**
	 * checks if the task has got a responsible person.
	 * 
	 * @param task
	 *            attached
	 * @return true, if the task has a responsible person
	 */
	public boolean hasResponsiblePerson(final Task task) {
		boolean result = false;
		@SuppressWarnings("unchecked")
		final SingleField<Person> target =
				(SingleField<Person>) this.getField(this.responsiblePersonType, task);
		if (target.getValue() != null) {
			result = true;
		}
		return result;
	}

	/**
	 * removes pbi.
	 * 
	 * @param pbi
	 *            to remove
	 * @param task
	 *            attached
	 * @throws ForbiddenStateException
	 *             if the task is in a state the use of this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void removePBI(final ProductBacklogItem pbi, final Task task)
			throws ForbiddenStateException, ConsistencyException {
		@SuppressWarnings("unchecked")
		final ListField<ProductBacklogItem> target =
				(ListField<ProductBacklogItem>) this.getField(this.assignedPBIsType,
						task);

		target.removeValue(pbi, task);
		this.changed();
		this.notifyObservers();
	}

	/**
	 * sets the field for the assigned pbi.
	 * 
	 * @param assignedPBIsType
	 *            : new assigned pbi field of the tsl
	 */
	public void setAssignedPBIsType(final PBIFieldType assignedPBIsType) {
		if (!(this.assignedPBIsType == null)) {
			return;
		}
		this.assignedPBIsType = assignedPBIsType;
		this.doAddFieldType(assignedPBIsType);
	}

	/**
	 * sets the finished date.
	 * 
	 * @param date
	 *            the task was finished
	 * @param task
	 *            attached
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the task is in a wrong state to use this method
	 */
	@SuppressWarnings("unchecked")
	public void setFinishDate(final Date date, final Task task)
			throws ConsistencyException, ForbiddenStateException {
		((SingleField<Date>) this.getField(this.getFinishDateType(), task)).setValue(
				date, task);
	}

	/**
	 * Sets the field for the finished date.
	 * 
	 * @param finishDateType
	 *            : new finished date field
	 */
	public void setFinishDateType(final DateFieldType finishDateType) {
		if (!(this.finishDateType == null)) {
			return;
		}
		this.finishDateType = finishDateType;
		this.doAddFieldType(finishDateType);
	}

	/**
	 * Setter of the plan effort.
	 * 
	 * @param planEffort
	 *            of the taskTicketType
	 * @param task
	 *            attached
	 * @throws ForbiddenStateException
	 *             if the method is forbidden in the state of the task
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void setPlanEffort(final Effort planEffort, final Task task)
			throws ForbiddenStateException, ConsistencyException {
		@SuppressWarnings("unchecked")
		final SingleField<Effort> target =
				(SingleField<Effort>) this.getField(this.getPlanEffortType(), task);
		target.setValue(planEffort, task);
	}

	/**
	 * sets the field for the plan effort.
	 * 
	 * @param planEffortType
	 *            : new field for the plan effort
	 */
	public void setPlanEffortType(final EffortFieldType planEffortType) {
		if (!(this.planEffortType == null)) {
			return;
		}
		this.planEffortType = planEffortType;
		this.doAddFieldType(planEffortType);
	}

	/**
	 * Setter of the responsibility for the task.
	 * 
	 * @param person
	 *            that is responsible
	 * @param task
	 *            attached
	 * @throws ForbiddenStateException
	 *             if the taskTicketType is in a state when this is forbidden
	 * @throws SprintAssociationException
	 *             if the person is in the wrong sprint
	 * @throws ConsistencyException
	 *             if the consitency is hurt
	 */
	public void setResponsibility(final Person person, final Task task)
			throws ForbiddenStateException, SprintAssociationException,
			ConsistencyException {
		if (!this.isPersonValid(person, task)) {
			throw new SprintAssociationException(
					ExceptionConstants.PERSON_NOT_IN_SPRINT_TEAM_ERROR);
		}
		@SuppressWarnings("unchecked")
		final SingleField<Person> target =
				(SingleField<Person>) this.getField(this.responsiblePersonType, task);
		target.setValue(person, task);
		this.changed();
		this.notifyObservers();
	}

	/**
	 * Setter of the field for the responsible Person.
	 * 
	 * @param responsiblePersonType
	 *            is the field to set
	 */
	public void setResponsiblePersonType(final PersonFieldType responsiblePersonType) {
		if (!(this.responsiblePersonType == null)) {
			return;
		}
		this.responsiblePersonType = responsiblePersonType;
		this.doAddFieldType(responsiblePersonType);
	}

	@Override
	protected void doInitializeStandard(final TypeManager typeManager)
			throws IPScrumGeneralException {
		this.setNameType(typeManager.getNameType());
		this.setDescriptionType(typeManager.getDescriptionType());
		this.setFinishDateType(typeManager.getFinishDateType());
		this.setAssignedPBIsType(typeManager.getAssignedPBIsType());
		this.setResponsiblePersonType(typeManager.getResponsiblePersonType());
		this.setPlanEffortType(typeManager.getPlanEffortType());
		// determine Active Fields
		this.doSetActive(typeManager.getOpen(), typeManager.getNameType());
		this.doSetActive(typeManager.getOpen(), typeManager.getDescriptionType());
		this.doSetActive(typeManager.getInProcess(), typeManager.getDescriptionType());
		this.doSetActive(typeManager.getOpen(), typeManager.getAssignedPBIsType());
		this.doSetActive(typeManager.getOpen(), typeManager.getPlanEffortType());
		this.doSetActive(typeManager.getInProcess(), typeManager.getPlanEffortType());
		this.doSetActive(typeManager.getInProcess(), typeManager.getFinishDateType());
		this.doSetActive(typeManager.getInProcess(),
				typeManager.getResponsiblePersonType());

	}

	@Override
	protected void doInitializeStateProfile(final TypeManager typeManager)
			throws IPScrumGeneralException {

		this.getStateProfile();
		this.doAddPossibleState(typeManager.getOpen());
		this.doAddPossibleState(typeManager.getInProcess());
		this.doAddPossibleState(typeManager.getClosed());
		this.doSetStartState(typeManager.getOpen());
		this.doAddEndState(typeManager.getClosed());

		final TransitionRule openInProcess =
				new TransitionRule(this.getModel(), typeManager.getOpen(),
						typeManager.getInProcess());
		final TransitionRule inProcessClosed =
				new TransitionRule(this.getModel(), typeManager.getInProcess(),
						typeManager.getClosed());

		this.doAddTransitionRule(openInProcess);
		this.doAddTransitionRule(inProcessClosed);

	}

	/**
	 * Checks if a person may obtain responsibility for a task.
	 * 
	 * @param person
	 *            Person to check
	 * @param attachedTask
	 *            the attached Task
	 * @return - true, if the person is a member of the sprint team. - false, if the
	 *         person is not a member of the sprint team or if the person isn't in a team
	 *         at all
	 */
	private boolean isPersonValid(final Person person, final Task attachedTask) {
		final Vector<Person> sprintTeamMembers =
				attachedTask.getSprintBacklog().getSprint().getTeam().getMembers();
		if (sprintTeamMembers == null) {
			return false;
		}
		final Iterator<Person> memberIterator = sprintTeamMembers.iterator();
		boolean isPersonValid = false;
		while (memberIterator.hasNext()) {
			final Person current = memberIterator.next();
			if (current.equals(person)) {
				isPersonValid = true;
				break;
			}
		}
		return isPersonValid;
	}

}
