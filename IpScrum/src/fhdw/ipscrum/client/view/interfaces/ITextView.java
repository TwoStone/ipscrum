package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;

public interface ITextView extends IView {

	/**
	 * Returns the event fired when the workflow shell be aborted.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAborted();

	/**
	 * Return the currently entered content.
	 * 
	 * @return
	 */
	String getContent();

	/**
	 * Returns the event fired when the object shell be saved.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getSave();

	/**
	 * Displays the content.
	 * 
	 * @param content
	 */
	void setContent(String content);

}
