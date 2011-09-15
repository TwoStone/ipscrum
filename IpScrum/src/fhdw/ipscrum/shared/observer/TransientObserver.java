package fhdw.ipscrum.shared.observer;

/**
 * <p>
 * A class can implement the Observer interface when it wants to be informed of changes in
 * observable objects.
 * </p>
 */
public interface TransientObserver extends Observer {

	/**
	 * This method is called whenever the observed object is changed.
	 * 
	 * @param observable
	 *            is the observable called
	 * 
	 * @param argument
	 *            is how the observable changed
	 */
	@Override
	void update(Observable observable, Object argument);
}
