package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.model.interfaces.ITask;

public class SprintBacklog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2775810634965110269L;
	private final List<ITask> tasks;

	public SprintBacklog() {
		super();
		this.tasks = new ArrayList<ITask>();
	}

	/**
	 * Adds a task to the sprint backlog
	 * 
	 * @param task
	 */
	public void addTask(final ITask task) {
		// TODO: Dublettenprüfung?
		this.tasks.add(task);
	}

	/**
	 * removes a task from the sprint backlog
	 * 
	 * @param task
	 */
	public void removeTask(final ITask task) {
		this.tasks.remove(task);
	}

	/**
	 * This method provides access to all tasks contained in the sprint backlog
	 * by an iterator.
	 * 
	 * @return Iterator
	 */
	public Iterator<ITask> taskIterator() {
		return this.tasks.iterator();
	}
}
