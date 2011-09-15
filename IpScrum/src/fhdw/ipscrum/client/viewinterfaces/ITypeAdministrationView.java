package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.TicketTypeArgs;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.TypeAdministrationView).
 */
public interface ITypeAdministrationView extends IView {

	/**
	 * displays the list of all types.
	 * 
	 * @param types
	 *            are all existing ticket types
	 */
	void refreshTypes(List<TicketType> types);

	/**
	 * displays the list of all main types.
	 * 
	 * @param types
	 *            are all existing main types
	 */
	void refreshMainTypes(List<TicketType> types);

	/**
	 * Represents the Event to handle the addition of a new ticket type.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerAddType(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the delete.
	 * 
	 * @param handler
	 *            needed to handle the event which also knows the ticket to delete
	 */
	void registerDeleteType(EventHandler<TicketTypeArgs> handler);

	/**
	 * getter of the name.
	 * 
	 * @return the current name
	 */
	String getTypeName();

	/**
	 * getter of the description.
	 * 
	 * @return the current description
	 */
	String getDescription();

	/**
	 * getter of the ticket type.
	 * 
	 * @return the currently selected ticketType
	 */
	TicketType getType();

}
