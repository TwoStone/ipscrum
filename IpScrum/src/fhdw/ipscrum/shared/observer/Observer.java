package fhdw.ipscrum.shared.observer;

import fhdw.ipscrum.shared.model.messages.Message;

/**
 * <p>A class can implement the Observer interface when 
 * it wants to be informed of changes in observable objects.</p>
 */
public interface Observer {

	/**
	 * This method is called whenever the observed object is changed.
	 */
	public void update(Observable observable, Object argument);
	//TODO: change signature to update(Message message)!!
}
