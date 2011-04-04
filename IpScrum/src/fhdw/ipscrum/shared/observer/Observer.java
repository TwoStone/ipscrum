package fhdw.ipscrum.shared.observer;

public interface Observer {

	/**
	 * This method is called whenever the observed object is changed.
	 */
	public void update(Observable observable, Object argument);

}