package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.observer.Observable;

public class Task extends Observable implements ITask {
	//TODO: Konsistenzbedingungen für den Zustand von Tasks im System definieren und sicherstellen!
	
	private String name;
	private String description;
	private ITaskState state;
	private List<ProductBacklogItem> assignedPBIs;
	private Integer planEffort;
	
	
	public Task(String name, String description){
		super();
		this.name = name;
		this.description = description;
		this.assignedPBIs = new ArrayList<ProductBacklogItem>();
		this.state = new TaskUnassigned(this);
	}

	@Override
	public void setName(String name) throws ForbiddenStateException {
		this.state.setName(name);
		
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) throws ForbiddenStateException {
		this.state.setResponsibility(responsiblePerson);
		
	}

	@Override
	public void finish() throws ForbiddenStateException {
		this.state.finish();		
	}

	@Override
	public Integer getPlanEffort() {
		return null;
	}

	@Override
	public final String getName() {
		return this.name;
	}
	
	protected void setState(ITaskState state){
		this.state=state;
	}
	
	protected void doSetName(String name){
		this.name = name;
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
		IPerson responsiblePerson = this.getResponsiblePerson();
		this.setState(new TaskFinished(this, responsiblePerson));
	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasResponsiblePerson() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITaskState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerson getResponsiblePerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFinishDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
