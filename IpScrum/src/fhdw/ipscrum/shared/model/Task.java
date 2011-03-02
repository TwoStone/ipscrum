package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.observer.Observable;

public class Task extends Observable implements ITask {
	//TODO: Konsistenzbedingungen für den Zustand von Tasks im System definieren und sicherstellen!
	
	private String name;
	private ITaskState state;
	private ProductBacklogItem assignedPBI;
	
	
	public Task(String name, ProductBacklogItem pbi){
		super();
		this.name = name;
		this.assignedPBI = pbi;
		this.state = new TaskUnassigned(this);
	}

	@Override
	public void setName(String name) {
		this.state.setName(name);
		
	}

	@Override
	public void setPBI(ProductBacklogItem pbi) {
		//TODO: setPBI
		
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		this.state.setResponsibility(responsiblePerson);
		
	}

	@Override
	public void finish() {
		this.state.finish();		
	}

	@Override
	public IPerson getResponsiblePerson() {
		return this.state.getResponsiblePerson();
	}

	@Override
	public Integer getPlanEffort() {
		return null;
	}

	@Override
	public Integer getActualEffort() {
		// TODO Auto-generated method stub
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

}
