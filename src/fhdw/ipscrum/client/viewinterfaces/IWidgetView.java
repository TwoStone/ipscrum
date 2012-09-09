package fhdw.ipscrum.client.viewinterfaces;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.IView;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.WidgetView).
 */
public interface IWidgetView extends IView {

	/**
	 * Represents the Event to handle the close.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the close
	 */
	EventRegistration registerCloseEventHandler(DefaultEventHandler handler);

}
