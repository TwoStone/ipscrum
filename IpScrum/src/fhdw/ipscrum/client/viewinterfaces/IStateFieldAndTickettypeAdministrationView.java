package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link}
 * fhdw.ipscrum.client.view.StateFieldAndTickettypeAdministrationView).
 */
public interface IStateFieldAndTickettypeAdministrationView extends IView {

	/**
	 * Represents the Event to handle the create of a new state type.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewStateTypeEvent(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the create of a new field type.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewFieldTypeEvent(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the create of a new ticket type.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewTickettypeEvent(DefaultEventHandler handler);

	/**
	 * displays the list of state types.
	 * 
	 * @param stateTypeSet
	 *            are all currently existing stateTypes
	 */
	void updateStateTypeTableData(List<StateType> stateTypeSet);

	/**
	 * displays the list of field types.
	 * 
	 * @param fieldTypeSet
	 *            are all currently existing fieldTypes
	 */
	void updateFieldTypeTableData(List<FieldType> fieldTypeSet);

	/**
	 * displays the list of ticket types.
	 * 
	 * @param ticketTypeSet
	 *            are all currently existing ticketTypes
	 */
	void updateTicketTypeTableData(List<TicketType> ticketTypeSet);

}
