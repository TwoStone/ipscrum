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
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.observer.Observable;

public class Task extends Observable implements ITask {
	private static final long serialVersionUID = -7493025129803401507L;
	private String name;
	private String description;
	private ITaskState state;
	private List<ProductBacklogItem> assignedPBIs;
	private Integer planEffort;
	private ManyToOne<OneToMany, ITask> sprintBacklogAssoc;

	@SuppressWarnings("unused")
	private Task() {
		super();
	}

	public Task(String name, String description) throws NoValidValueException {
		super();
		this.state = new TaskUnassigned(this);
		this.sprintBacklogAssoc = new ManyToOne<OneToMany, ITask>(this);
		try {
			this.setName(name);
			this.description = description;
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
		this.planEffort = 0;
	}
	@Override
	public ManyToOne<OneToMany, ITask> getSprintBacklogAssoc(){
		return this.sprintBacklogAssoc;
	}
	@Override 
	public SprintBacklog getSprintBacklog(){
		return (SprintBacklog)this.getSprintBacklogAssoc().get();
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		this.state.addPBI(pbi);
	}

	protected void doAddPBI(ProductBacklogItem pbi) {
		if (pbi.getSprint()==null){
			// Inkonsistent
			//TODO: Exception
		} 
		if (!pbi.getSprint().getSprintBacklog().hasTask(this)){
			// Inkonsistent
			//TODO: Exception
		}
		
		this.assignedPBIs.add(pbi);
	}

	protected void doRemovePBI(ProductBacklogItem pbi) {
		this.assignedPBIs.remove(pbi);
	}

	protected void doSetDescription(String description)
			throws NoValidValueException {
		if (description.equals(TextConstants.EMPTY_TEXT)) {
			throw new NoValidValueException(
					ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		} else {
			this.description = description;
		}
	}

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
	 */
	protected void doSetTaskFinished() throws ForbiddenStateException {
		this.setPlanEffort(0);
		final TaskFinished newState = new TaskFinished(this,
				this.getResponsiblePerson());
		this.setState(newState);

	}

	@Override
	public void finish() throws ForbiddenStateException {
		this.state.finish();
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
			throws ForbiddenStateException {
		this.state.setResponsibility(responsiblePerson);
		this.notifyObservers();

	}

	protected void setState(ITaskState state) {
		this.state = state;
	}

	/**
	 * changes state to TaskAssigned and passes responsiblePerson
	 * 
	 * @param responsiblePerson
	 */
	protected void setTaskAssigned(IPerson responsiblePerson) {
		Vector<IPerson> sprintTeamMembers = this.getSprintBacklog().getSprint().getTeam().getMembers();
		if (sprintTeamMembers==null){
			//Inkonsistent
			//TODO: Exception
		}
		Iterator<IPerson> memberIterator = sprintTeamMembers.iterator();
		boolean isPersonValid = false;
		while (memberIterator.hasNext()){
			IPerson current = memberIterator.next();
			if (current.equals(responsiblePerson)){
				isPersonValid = true; break;
			}
		}
		if (!isPersonValid){
			//Inkonsistent
			//TODO: Exception;
		}
		
		this.state = new TaskInProgress(this, responsiblePerson);
	}

	@Override
	public void setPlanEffort(Integer planEffort)
			throws ForbiddenStateException {
		this.state.setPlanEffort(planEffort);
		this.notifyObservers();
		
	}

	protected void doSetPlanEffort(Integer planEffort) {
		this.planEffort = planEffort;
	}

	@Override
	public int indirectHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
