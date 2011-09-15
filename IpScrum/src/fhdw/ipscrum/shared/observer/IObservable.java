package fhdw.ipscrum.shared.observer;

/**
 * Represents the observableInterface.
 */
public interface IObservable {

	/**
	 * Adds an observer to the set of observers for this object, provided that it is not
	 * the same as some observer already in the set.
	 * 
	 * @param observer
	 *            the current transientObserver to add
	 * 
	 */
	void addObserver(final TransientObserver observer);

	/**
	 * Adds an observer to the set of observers for this object, provided that it is not
	 * the same as some observer already in the set.
	 * 
	 * @param observer
	 *            is the persistenObserver to add
	 */
	void addObserver(final PersistentObserver observer);

	/**
	 * Returns the number of observers of this Observable object.
	 * 
	 * @return the number of all Observers
	 */
	int countObservers();

	/**
	 * Returns the number of observers of this Observable object.
	 * 
	 * @return the number of transientObservers
	 */
	int countTransientObservers();

	/**
	 * Returns the number of observers of this Observable object.
	 * 
	 * @return the number of persitentObservers
	 */
	int countPersistentObservers();

	/**
	 * Deletes an observer from the set of observers of this object.
	 * 
	 * @param observer
	 *            is the current transient observer to delete
	 */
	void deleteObserver(final TransientObserver observer);

	/**
	 * Deletes an observer from the set of observers of this object.
	 * 
	 * @param observer
	 *            is the current persistent observer to delete
	 */
	void deleteObserver(final PersistentObserver observer);

	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	void deleteObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable observable,
	 * Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this, null)
	 */
	void notifyObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable observable,
	 * Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this, argument)
	 * 
	 * @param argument
	 *            is the object notified
	 */
	void notifyObservers(final Object argument);

}
