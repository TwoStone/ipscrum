package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.observer.Observable;

public class Task extends Observable implements ITask {
	private static final long serialVersionUID = -7493025129803401507L;
	/**
	 * a short name for the task.
	 */
	private String name;
	/**
	 * the description describes the task in more detail.
	 */
	private String description;
	/**
	 * the state of a task describes allowed actions and the workflow context.
	 */
	private ITaskState state;
	/**
	 * this task shall realize the matters of the assigned product backlog items
	 */
	private List<ProductBacklogItem> assignedPBIs;
	/**
	 * the plan effort is the estimated effort for executing the task.
	 * the plan effort may be changed during the lifecycle of a task.
	 * at the end of the lifecycle, the planEffort is 0.
	 * You can also call it "estimated rest effort".
	 */
	private Integer planEffort;
	/**
	 * 1:1 relation to the sprint backlog
	 */
	@SuppressWarnings("rawtypes")
	private ManyToOne<OneToMany, Task> sprintBacklogAssoc;
	
	/**
	 * Creates a Task instance with initial state >>unassigned<<.
	 *  
	 * @param name pass a short name to the task
	 * @param description pass a more detailed description
	 * @throws NoValidValueException is thrown if name or description is empty.
	 */
	@SuppressWarnings("rawtypes")
	public Task(String name, String description) throws NoValidValueException {
		super();
		this.state = new TaskUnassigned(this);
		this.sprintBacklogAssoc = new ManyToOne<OneToMany, Task>(this);
		try {
			this.setName(name);
			this.setDescription(description);
			this.setPlanEffort(0);
		} catch (final ForbiddenStateException e) {
			/*
			 * INTERNAL ERROR should never happen, make sure that the initial
			 * State is <TaskUnassigned> exception should not be passed to
			 * passed to the UI because it's an internal error and only relevant
			 * for debugging
			 */
			java.lang.System.out
					.print(ExceptionConstants.TASK_INITIAL_STATE_ERROR);
		}
		this.assignedPBIs = new ArrayList<ProductBacklogItem>();
		
	}
	/**
	 * for serialization
	 */
	@SuppressWarnings("unused")
	private Task() {
		super();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ManyToOne<OneToMany, Task> getSprintBacklogAssoc(){
		return this.sprintBacklogAssoc;
	}
	@Override 
	public SprintBacklog getSprintBacklog(){
		return (SprintBacklog)this.getSprintBacklogAssoc().get();
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException, SprintAssociationException {
		if (pbi.getSprint()==null){
			throw new SprintAssociationException(ExceptionConstants.PBI_NOT_IN_SPRINT_ERROR);
		} 
		if (!pbi.getSprint().getSprintBacklog().hasTask(this)){
			throw new SprintAssociationException(ExceptionConstants.PBI_NOT_IN_SPRINT_ERROR);
		}
		this.state.addPBI(pbi);
	}
	
	
	@Override
	public void finish() throws ForbiddenStateException {
		this.state.finish();
		this.notifyObservers();
	}

	@Override
	public void finish(Date finishDate) throws ForbiddenStateException {
		this.state.finish(finishDate);
		this.notifyObservers();
		
	}
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Date getFinishDate() {
		return this.state.getFinishDate();
	}

	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public Iterator<ProductBacklogItem> getPBIIterator() {
		return this.assignedPBIs.iterator();
	}

	@Override
	public Integer getPlanEffort() {
		return this.planEffort;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return this.state.getResponsiblePerson();
	}

	@Override
	public final ITaskState getState() {
		return this.state;
	}

	@Override
	public boolean hasResponsiblePerson() {
		return this.state.hasResponsiblePerson();
	}

	@Override
	public boolean isFinished() {
		return this.state.isFinished();
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException {
		this.state.removePBI(pbi);

	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException, NoValidValueException {
		this.state.setDescription(description);

	}

	@Override
	public void setName(String name) throws ForbiddenStateException,
			NoValidValueException {
		this.state.setName(name);

	}

	@Override
	public void setResponsibility(IPerson responsiblePerson)
			throws ForbiddenStateException, SprintAssociationException {
		if (this.isPersonValid(responsiblePerson)){
			this.state.setResponsibility(responsiblePerson);
			this.notifyObservers();
		} else {
			throw new SprintAssociationException(ExceptionConstants.PERSON_NOT_IN_SPRINT_TEAM_ERROR);
		}
	}


	@Override
	public void setPlanEffort(Integer planEffort)
			throws ForbiddenStateException {
		this.state.setPlanEffort(planEffort);
		this.notifyObservers();
		
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((assignedPBIs == null) ? 0 : assignedPBIs.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((planEffort == null) ? 0 : planEffort.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task other = (Task) obj;
		if (assignedPBIs == null) {
			if (other.assignedPBIs != null) {
				return false;
			}
		} else if (!assignedPBIs.equals(other.assignedPBIs)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (planEffort == null) {
			if (other.planEffort != null) {
				return false;
			}
		} else if (!planEffort.equals(other.planEffort)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.shared.observer.Observable#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.indirectEquals(obj);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.shared.observer.Observable#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.indirectHashCode();
	}

	@Override
	public boolean hasPBI(ProductBacklogItem pbi) {
		boolean result = false;
		Iterator<ProductBacklogItem> pbiIterator = this.getPBIIterator();
		while (pbiIterator.hasNext()){
			ProductBacklogItem current = pbiIterator.next();
			if (current.equals(pbi)){
				result = true; break;
			}
		}
		return result;
	}
	/**
	 * adds a new ProductBacklogItem to the task.
	 * PRECONDITION: consistency has been checked.
	 * That means: pbi.sprint.sprintbacklog contains this task
	 * @param pbi 
	 */
	protected void doAddPBI(ProductBacklogItem pbi) {
		this.assignedPBIs.add(pbi);
	}

	protected void doRemovePBI(ProductBacklogItem pbi) {
		this.assignedPBIs.remove(pbi);
	}
	/**
	 * Replaces the actual description with the new one.
	 * @param description new description
	 * @throws NoValidValueException will be raised if the description is empty.
	 */
	protected void doSetDescription(String description)
			throws NoValidValueException {
		if (description.equals(TextConstants.EMPTY_TEXT)) {
			throw new NoValidValueException(
					ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		} else {
			this.description = description;
		}
	}
	
	/**
	 * replaces the actual name with the new one.
	 * @param name new name
	 * @throws NoValidValueException will be raised if the name is empty
	 */
	protected void doSetName(String name) throws NoValidValueException {
		if (name.equals(TextConstants.EMPTY_TEXT)) {
			throw new NoValidValueException(ExceptionConstants.EMPTY_NAME_ERROR);
		} else {
			this.name = name;
		}
	}

	/**
	 * changes state to TaskFinished and passes actual responsiblePerson
	 * @throws ForbiddenStateException 
	 * @throws SprintAssociationException 
	 */
	protected void doSetTaskFinished() throws ForbiddenStateException {
		//this.setPlanEffort(0);
		final TaskFinished newState = new TaskFinished(this,
				this.getResponsiblePerson());
		this.setState(newState);
	}
	
	protected void doSetTaskFinished(Date finishDate) throws ForbiddenStateException {
		//this.setPlanEffort(0);
		TaskFinished newState = new TaskFinished(this, this.getResponsiblePerson(), finishDate);
		this.setState(newState);
	}
	
	/**
	 * sets a new state to the task. this operation shall be called only by the owner of the state.
	 * @param state
	 */
	protected void setState(ITaskState state) {
		this.state = state;
	}

	/**
	 * changes state to TaskAssigned and passes responsiblePerson
	 * 
	 * @param responsiblePerson
	 * @throws SprintAssociationException 
	 */
	protected void setTaskAssigned(IPerson responsiblePerson) throws SprintAssociationException {
		this.state = new TaskInProgress(this, responsiblePerson);
	}
	/**
	 * replaces the actual planEffort with the new.
	 * @param planEffort
	 */
	protected void doSetPlanEffort(Integer planEffort) {
		this.planEffort = planEffort;
	}
	
	/**
	 * Checks if a person may obtain responsibility for a task.
	 * 
	 * @param responsiblePerson Person to check
	 * @return
	 * - true, if the person is a member of the sprint team. 
	 * - false, if the person is not a member of the sprint team or
	 *          if the person isn't in a team at all
	 */
	protected boolean isPersonValid(IPerson responsiblePerson){
		Vector<IPerson> sprintTeamMembers = this.getSprintBacklog().getSprint().getTeam().getMembers();
		if (sprintTeamMembers==null){
			return false;
		}
		Iterator<IPerson> memberIterator = sprintTeamMembers.iterator();
		boolean isPersonValid = false;
		while (memberIterator.hasNext()){
			IPerson current = memberIterator.next();
			if (current.equals(responsiblePerson)){
				isPersonValid = true; break;
			}
		}
		return isPersonValid;
	}


	
	

}
