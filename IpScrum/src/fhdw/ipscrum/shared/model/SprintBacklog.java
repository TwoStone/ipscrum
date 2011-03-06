package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.bdas.OneToOne;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class SprintBacklog implements BDACompare, Serializable {

	private static final long serialVersionUID = 2775810634965110269L;
	@SuppressWarnings("rawtypes")
	/**
	 * 1:1 relation to the sprint.
	 */
	private OneToOne<OneToOne, SprintBacklog> sprintAssoc;
	@SuppressWarnings("rawtypes")
	/**
	 * 1:* relation to the tasks of the sprint
	 */
	private OneToMany<ManyToOne, SprintBacklog> taskAssoc;

	@SuppressWarnings("rawtypes")
	public SprintBacklog(ISprint sprint) {
		super();
		this.sprintAssoc = new OneToOne<OneToOne, SprintBacklog>(this);
		this.taskAssoc = new OneToMany<ManyToOne, SprintBacklog>(this);
	}
	/**
	 * for serialization
	 */
	@SuppressWarnings("unused")
	private SprintBacklog() {
	}
	

	@Override
	public int hashCode(){
		return this.indirectHashCode();
	}
	@Override
	public boolean equals(Object obj){
		return this.indirectEquals(obj);
	}

	@Override
	public int indirectHashCode() {
		// no base attributes
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		// no base attributes
		return obj == this;
	}
	
	/**
	 * This method provides access to all tasks contained in the sprint backlog
	 * by an iterator.
	 * 
	 * @return Iterator
	 */
	public Iterator<ITask> taskIterator() {
		Iterator<ITask> result = null;
		final Iterator<BDACompare> i = this.getTaskAssoc().getAssociations()
				.iterator();
		final Vector<ITask> taskVector = new Vector<ITask>();
		while (i.hasNext()) {
			taskVector.add((ITask) i.next());
		}
		result = taskVector.iterator();
		return result;
	}

	@SuppressWarnings("rawtypes")
	public OneToMany<ManyToOne, SprintBacklog> getTaskAssoc() {
		return this.taskAssoc;
	}
	
	public ISprint getSprint() {
		return (ISprint) this.getSprintAssoc().get();
	}
	
	@SuppressWarnings("rawtypes")
	public OneToOne<OneToOne, SprintBacklog> getSprintAssoc() {
		return this.sprintAssoc;
	}

	/**
	 * Checks a task by identity whether it is contained in the sprint backlog
	 * 
	 * @param task
	 * @return
	 */
	public boolean hasTask(final ITask task) {
		final Iterator<ITask> i = this.taskIterator();
		boolean result = false;
		while (i.hasNext()) {
			if (task == i.next()) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Adds a task to the sprint backlog
	 * 
	 * @param task
	 */
	public void addTask(final ITask task) {
		this.getTaskAssoc().add(task.getSprintBacklogAssoc());
	}

	/**
	 * removes a task from the sprint backlog
	 * 
	 * @param task
	 */
	public void removeTask(final ITask task) {
		this.getTaskAssoc().remove(task.getSprintBacklogAssoc());
	}
	
	/**
	 * Checks whether a task is associated with the pbi.
	 * @param pbi
	 * @return true, if pbi is element of task.assignedPBIs
	 */
	public boolean hasPBI(ProductBacklogItem pbi){
		boolean result = false;
		Iterator<ITask> taskIterator = this.taskIterator();
		while (taskIterator.hasNext()){
			ITask current = taskIterator.next();
			if (current.hasPBI(pbi)){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * This method deletes the PBI from all contained tasks, if the task is not finished.
	 * @param pbi ProductBacklogItem to be deleted
	 */
	public void removePBIFromTasks(ProductBacklogItem pbi) {
		Iterator<ITask> taskIterator = this.taskIterator();
		while (taskIterator.hasNext()){
			ITask current = taskIterator.next();
			if (current.hasPBI(pbi)){
				try {
					current.removePBI(pbi);
				} catch (ForbiddenStateException e) {
					// finished Tasks cannot be changed
					return;
				}
			}
		}
	}
	
}
