package fhdw.ipscrum.shared.observer;

public interface IObservable {

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set.
	 */
	void addObserver(final TransientObserver observer);

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set.
	 */
	void addObserver(final PersistentObserver observer);

	/**
	 * Returns the number of observers of this Observable object.
	 */
	int countObservers();

	/**
	 * Returns the number of observers of this Observable object.
	 */
	int countTransientObservers();

	/**
	 * Returns the number of observers of this Observable object.
	 */
	int countPersistentObservers();

	/**
	 * Deletes an observer from the set of observers of this object.
	 */
	void deleteObserver(final TransientObserver observer);

	/**
	 * Deletes an observer from the set of observers of this object.
	 */
	void deleteObserver(final PersistentObserver observer);

	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	void deleteObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this, null)
	 */
	void notifyObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this,
	 * argument)
	 */
	void notifyObservers(final Object argument);

}