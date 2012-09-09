package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.TaskCreateView.TaskCreateArgs;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.TaskCreateView).
 */
public interface ITaskCreateView extends IView {

	/**
	 * displays the list of ticketTypes.
	 * 
	 * @param list
	 *            are all existing TaskTicketTypes
	 */
	void fillComboBoxTypes(List<TaskTicketType> list);

	/**
	 * Represents the Event to handle the save.
	 * 
	 * @param handler
	 *            needed to handle the event, which also knows the task
	 * @return the event which handles the save
	 */
	EventRegistration registerSaveEvent(final EventHandler<TaskCreateArgs> handler);

	/**
	 * Represents the Event to handle the abort.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the abort
	 */
	EventRegistration registerCancelEvent(DefaultEventHandler handler);

}
