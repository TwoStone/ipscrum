package fhdw.ipscrum.client.architecture.view;

import com.google.gwt.user.client.ui.IsWidget;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;

/**
 * represents all views in the IPScrum.
 */
public interface IView extends IsWidget {

	/**
	 * is needed for close a view.
	 */
	void close();

	/**
	 * Sets a views visibility attached to a right and controlled by the given value.
	 * 
	 * @param value
	 *            to say in which way the visibility should be set
	 */
	void setRightVisibility(Boolean value);

	/**
	 * To define an event handler for help events.
	 * 
	 * @param handler
	 *            event handler
	 * @return EventRegistration
	 */
	EventRegistration registerHelpHandler(final DefaultEventHandler handler);
}
