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
	
	//TODO: Tasks dem PBI bekannt machen!
	//TODO: Konsistenzbedingungen für den Zustand von Tasks im System definieren und sicherstellen!
	//TODO: Nutzung des bdA-Frameworks sinnvoll??
	
	private String name;
	private ITaskState state;
	private IPerson responsiblePerson;
	private List<ProductBacklogItem> assignedPBIs;
	
	public Task(String name){
		this.name = name;
		this.state = null;
		//TODO: Initialize Task state
		this.assignedPBIs = new ArrayList<ProductBacklogItem>();
		this.responsiblePerson = null; 
		//TODO: Handle null references
	}
	
	

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void changeResponsibility(IPerson responsiblePerson) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IPerson getResponsiblePerson() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ISprint getAssignedSprint() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addBacklogItem(ProductBacklogItem pbi) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void removeBacklogItem(ProductBacklogItem pbi) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<ProductBacklogItem> getAssignedPBIs() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean equals(Object obj) {
		return this==obj 
		&& this.name.equals(((Task)obj).name);
		//TODO: More necessary for equals??
	}

	
	
}
