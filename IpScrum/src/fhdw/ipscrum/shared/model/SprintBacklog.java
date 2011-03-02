package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class SprintBacklog{
	private List<ITask> tasks;
	
	public SprintBacklog(){
		super();
		this.tasks = new ArrayList<ITask>();
	}
	/**
	 * This method provides access to all tasks contained in the sprint backlog
	 * by an iterator.
	 * 
	 * @return Iterator
	 */
	public Iterator<ITask> iterator(){
		return this.tasks.iterator();
	}
	/**
	 * Adds a task to the sprint backlog
	 * @param task
	 */
	public void addTask(ITask task){
		this.tasks.add(task);
	}
	/**
	 * removes a task from the sprint backlog
	 * @param task
	 */
	public void removeTask(ITask task){
		this.tasks.remove(task);
	}
	
	public Integer aggregatePlanEffort(){
		Iterator<ITask> i = this.iterator();
		Integer result = 0;
		while (i.hasNext()){
			ITask current = i.next();
			result = result + current.getPlanEffort();
		}
		return result;
	}
	public Integer aggregateActualEffort(){
		Iterator<ITask> i = this.iterator();
		Integer result = 0;
		while (i.hasNext()){
			ITask current = i.next();
			result = result + current.getActualEffort();
		}
		return result;
	}

}
