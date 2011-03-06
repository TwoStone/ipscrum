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
	/**
	 * 
	 */
	private static final long serialVersionUID = 2775810634965110269L;
	private OneToOne<OneToOne, SprintBacklog> sprintAssoc;
	private OneToMany<ManyToOne, SprintBacklog> taskAssoc;

	public SprintBacklog(ISprint sprint) {
		super();
		this.sprintAssoc = new OneToOne<OneToOne, SprintBacklog>(this);
		this.taskAssoc = new OneToMany<ManyToOne, SprintBacklog>(this);
	}

	private SprintBacklog() {

	}

	public OneToMany<ManyToOne, SprintBacklog> getTaskAssoc() {
		return this.taskAssoc;
	}

	public OneToOne<OneToOne, SprintBacklog> getSprintAssoc() {
		return this.sprintAssoc;
	}

	public ISprint getSprint() {
		return (ISprint) this.getSprintAssoc().get();
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
