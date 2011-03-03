package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.observer.Observable;

public class Task extends Observable implements ITask {
	//TODO: Define Consistency conditions / class invariants
	private static final long serialVersionUID = -7493025129803401507L;
	private String name;
	private String description;
	private ITaskState state;
	private List<ProductBacklogItem> assignedPBIs;
	private Integer planEffort;
	
	
	public Task(String name, String description) throws NoValidValueException{
		super();
		this.state = new TaskUnassigned(this);
		try {
			this.setName(name);
			this.description = description;
		} catch (ForbiddenStateException e) {
			/*
			 * INTERNAL ERROR 
			 * should never happen, make sure that the initial State is <TaskUnassigned>
			 * exception should not be passed to passed to the UI because it's an internal error
			 * and only relevant for debugging
			 */
			System.out.print(ExceptionConstants.TASK_INITIAL_STATE_ERROR);
		}
		this.assignedPBIs = new ArrayList<ProductBacklogItem>();
		this.planEffort = 0;
	}
	@SuppressWarnings("unused")
	private Task(){
		super();
	}

	@Override
	public void setName(String name) throws ForbiddenStateException, NoValidValueException {
		this.state.setName(name);
		
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) throws ForbiddenStateException {
		this.state.setResponsibility(responsiblePerson);
		this.notifyObservers();
		
	}

	@Override
	public void finish() throws ForbiddenStateException {
		this.state.finish();
		this.notifyObservers();
	}

	@Override
	public Integer getPlanEffort() {
		return this.planEffort;
	}

	@Override
	public final String getName() {
		return this.name;
	}
	
	protected void setState(ITaskState state){
		this.state=state;
	}
	
	protected void doSetName(String name) throws NoValidValueException{
		if (name.equals(TextConstants.EMPTY_TEXT)){
			throw new NoValidValueException(ExceptionConstants.EMPTY_NAME_ERROR);
		} else {
			this.name = name;
		}
	}
	/**
	 * changes state to TaskAssigned and passes responsiblePerson
	 * @param responsiblePerson
	 */
	protected void setTaskAssigned(IPerson responsiblePerson){
		this.state = new TaskInProgress(this, responsiblePerson);
	}
	/**
	 * changes state to TaskFinished and passes actual responsiblePerson
	 */
	protected void doSetTaskFinished(){
		TaskFinished newState = new TaskFinished(this, this.getResponsiblePerson());
		this.setState(newState);
		
	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException, NoValidValueException {
		this.state.setDescription(description);
		
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		this.state.addPBI(pbi);	
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException {
		this.state.removePBI(pbi);
		
	}

	@Override
	public boolean hasResponsiblePerson() {
		return this.state.hasResponsiblePerson();
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public final ITaskState getState() {
		return this.state;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return this.state.getResponsiblePerson();
	}

	@Override
	public Date getFinishDate() {
		return this.state.getFinishDate();
	}

	@Override
	public boolean isFinished() {
		return this.state.isFinished();
	}

	protected void doSetDescription(String description) throws NoValidValueException {
		if (description.equals(TextConstants.EMPTY_TEXT)){
			throw new NoValidValueException(ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		}else{
			this.description = description;	
		}
	}

	protected void doRemovePBI(ProductBacklogItem pbi) {
		this.assignedPBIs.remove(pbi);
	}

	protected void doAddPBI(ProductBacklogItem pbi) {
		//TODO: Priorisierung klären
		this.assignedPBIs.add(pbi);
	}

	@Override
	public Iterator<ProductBacklogItem> getPBIIterator() {
		return this.assignedPBIs.iterator();
	}

}
