package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.messages.MessageStandardVisitor;
import fhdw.ipscrum.shared.model.messages.TaskCompletionMessage;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents the SprintBacklog.
 */
public class SprintBacklog extends IdentifiableObject
		implements IsSerializable, PersistentObserver {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 2775810634965110269L;

	/**
	 * Represents the sprint the backlog is related to.
	 */
	private Sprint sprint;

	/**
	 * Represents the tasks related to the backlog.
	 */
	private List<Task> tasks;

	/**
	 * constructor of the backlog.
	 * 
	 * @param model
	 *            the backlog is related to
	 * @param sprint
	 *            the backlog is related to
	 */
	public SprintBacklog(final Model model, final Sprint sprint) {
		super(model);
		this.sprint = sprint;
		this.tasks = new ArrayList<Task>();
		this.addObserver(sprint);
		this.putToObjectStore();
	}

	/**
	 * for serialization.
	 */
	@SuppressWarnings("unused")
	private SprintBacklog() {
	}

	/**
	 * This method provides access to all tasks contained in the sprint backlog by an
	 * iterator.
	 * 
	 * @return Iterator
	 */
	public Iterator<Task> taskIterator() {
		return this.tasks.iterator();
	}

	/**
	 * Getter of the sprint.
	 * 
	 * @return the sprint related to the backlog
	 */
	public Sprint getSprint() {
		return this.sprint;
	}

	/**
	 * Checks a task by identity whether it is contained in the sprint backlog.
	 * 
	 * @param task
	 *            that should be tested to be in the backlog
	 * @return true, if the task is in the backlog
	 */
	public boolean hasTask(final Task task) {
		final Iterator<Task> i = this.taskIterator();
		boolean result = false;
		while (i.hasNext()) {
			if (task.equals(i.next())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Adds a task to the sprint backlog.
	 * 
	 * @param task
	 *            that should be added to the backlog
	 */
	public void addTask(final Task task) {
		if (!this.hasTask(task)) {
			this.tasks.add(task);
			task.addObserver(this);
			this.changed();
		}
	}

	/**
	 * removes a task from the sprint backlog.
	 * 
	 * @param task
	 *            that should be removed from the backlog
	 */
	public void removeTask(final Task task) {
		this.tasks.remove(task);
		this.changed();
	}

	/**
	 * Checks whether a task is associated with the pbi.
	 * 
	 * @param pbi
	 *            that should be checked if it is related to the task
	 * @return true, if pbi is element of task.assignedPBIs
	 */
	public boolean hasPBI(final ProductBacklogItem pbi) {
		boolean result = false;
		final Iterator<Task> taskIterator = this.taskIterator();
		while (taskIterator.hasNext()) {
			final Task current = taskIterator.next();
			if (current.hasPBI(pbi)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * This method deletes the PBI from all contained tasks, if the task is not finished.
	 * 
	 * @param pbi
	 *            ProductBacklogItem to be deleted
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the task is in a state this method is forbidden
	 */
	public void removePBIFromTasks(final ProductBacklogItem pbi)
			throws ForbiddenStateException, ConsistencyException {
		final Iterator<Task> taskIterator = this.taskIterator();
		while (taskIterator.hasNext()) {
			final Task current = taskIterator.next();
			if (current.hasPBI(pbi)) {
				current.enforceRemovePBI(pbi);
			}
		}
		this.changed();
	}

	/**
	 * This is used to calculate the individual data-points per day.
	 * 
	 * @param date
	 *            the day to calculate the data-point for
	 * @return the amount of effort that is left for this day.
	 */
	public int getEffortByDay(final Date date) {
		int result = this.calculateOverallTaskEffort();
		final Iterator<Task> i = this.taskIterator();
		while (i.hasNext()) {
			final Task current = i.next();
			final Date finishedDate = current.getFinishDate();

			if (current.isFinished() && finishedDate != null) {
				if (finishedDate.before(date) || finishedDate.equals(date)) {
					result -= current.getPlanEffort().getValue();
				}
			}
		}
		return result;
	}

	/**
	 * This is to obtain a sum of all efforts of tasks that are connected to the sprint.
	 * 
	 * @return sum of task-efforts.
	 */
	public int calculateOverallTaskEffort() {
		int result = 0;
		final Iterator<Task> i = this.taskIterator();
		while (i.hasNext()) {
			final Task current = i.next();
			if (current.getPlanEffort() != null) {
				result += current.getPlanEffort().getValue();
			}
		}
		return result;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		if (!(argument instanceof Message)) {
			return;
		}
		((Message) argument).accept(new MessageStandardVisitor() {
			@Override
			public void
					handleTaskCompletionMessage(final TaskCompletionMessage message) {
				SprintBacklog.this.taskUpdate(message);
			}

			@Override
			public void standardHandling() {
				// not interested in other messages
			}
		});

	}

	/**
	 * Getter of the task in the backlog.
	 * 
	 * @return the tasks of the backlog
	 */
	public List<Task> getTasks() {
		return this.tasks;
	}

	/**
	 * Needed for updating the projecthistory.
	 * 
	 * @param message
	 *            thrown in the projecthistory if the task is completed
	 */
	private void taskUpdate(final TaskCompletionMessage message) {
		this.notifyObservers(message); // delegate message to sprint
	}

}
