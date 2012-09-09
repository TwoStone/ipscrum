package fhdw.ipscrum.shared.observer;

/**
 * Represents the Observer.
 */
public interface Observer {

	/**
	 * This method is called whenever the observed object is changed.
	 * 
	 * @param observable
	 *            is the observable called
	 * 
	 * @param argument
	 *            is how the observable changed
	 */
	void update(Observable observable, Object argument);

}
