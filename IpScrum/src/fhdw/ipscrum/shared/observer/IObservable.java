package fhdw.ipscrum.shared.observer;

public interface IObservable {

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set.
	 */
	public void addObserver(final Observer observer);

	/**
	 * Returns the number of observers of this Observable object.
	 */
	public int countObservers();

	/**
	 * Deletes an observer from the set of observers of this object.
	 */
	public void deleteObserver(final Observer observer);

	/**
	 * Clears the observer list so that this object no longer has any observers.
	 */
	public void deleteObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this, null)
	 */
	public void notifyObservers();

	/**
	 * Notifies all registered observers and calls the update(Observable
	 * observable, Object argument) method.
	 * 
	 * The Update Method will be called in the following way: update(this,
	 * argument)
	 */
	public void notifyObservers(final Object argument);

}