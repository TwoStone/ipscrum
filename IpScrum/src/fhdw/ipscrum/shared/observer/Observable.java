package fhdw.ipscrum.shared.observer;

import java.io.Serializable;
import java.util.Vector;

/**
 * <p>
 * This class represents an observable object, or "data" in the model-view
 * paradigm. It can be subclassed to represent an object that the application
 * wants to have observed.
 * </p>
 * <p>
 * An observable object can have one or more observers. An observer may be any
 * object that implements interface Observer. After an observable instance
 * changes, an application calling the Observable's notifyObservers method
 * causes all of its observers to be notified of the change by a call to their
 * update method.
 * </p>
 * <p>
 * The order in which notifications will be delivered is unspecified. The
 * default implementation provided in the Observable class will notify Observers
 * in the order in which they registered interest, but subclasses may change
 * this order, use no guaranteed order, deliver notifications on separate
 * threads, or may guarantee that their subclass follows this order, as they
 * choose.
 * </p>
 * <p>
 * Note that this notification mechanism is has nothing to do with threads and
 * is completely separate from the wait and notify mechanism of class Object.
 * </p>
 * <p>
 * When an observable object is newly created, its set of observers is empty.
 * Two observers are considered the same if and only if the equals method
 * returns true for them.
 * </p>
 * <p>
 * <b>Attention</b> The functioning of this class is nearly the same as
 * java.util.Observable! <br/>
 * Differences are:
 * <ul>
 * <li>No use of the <i>changed</i> attribute</li>
 * <li>list of observers is a vector and it is transient. Because of the
 * transient modifier the observer list will not be serialized by
 * XStream-library</li>
 * </ul>
 * </p>
 */
public abstract class Observable implements Serializable {

	/**
	 * Each Observer is only one time in the list.
	 */
	private transient Vector<Observer> observers;

	/**
	 * Construct an Observable with zero Observers.
	 */
	public Observable() {
		this.observers = new Vector<Observer>();
	}

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set.
	 */
	public void addObserver(final Observer observer) {
		this.getObservers().add(observer);
	}

	/**
	 * Returns the number of observers of this Observable object.
	 */
	public int countObservers() {
		return this.getObservers().size();
	}

	/**
	 * Deletes an observer from the set of observers of this object.
	 */
	public void deleteObserver(final Observer observer) {
		this.getObservers().remove(observer);
	}

	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	public void deleteObservers() {
		this.getObservers().removeAllElements();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Observable other = (Observable) obj;
		if (this.getObservers() == null) {
			if (other.getObservers() != null) {
				return false;
			}
		} else if (!this.getObservers().equals(other.getObservers())) {
			return false;
		}
		return true;
	}

	private Vector<Observer> getObservers() {
		if (this.observers == null) {
			this.observers = new Vector<Observer>();
		}
		return this.observers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.observers == null) ? 0 : this.observers.hashCode());
		return result;
	}

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this, null)
	 */
	public void notifyObservers() {
		this.notifyObservers(null);
	}

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this,
	 * argument)
	 */
	public void notifyObservers(final Object argument) {
		for (final Observer current : this.getObservers()) {
			current.update(this, argument);
		}
	}

	@Override
	public String toString() {
		return "Observable [observers=" + this.getObservers() + "]";
	}
}
