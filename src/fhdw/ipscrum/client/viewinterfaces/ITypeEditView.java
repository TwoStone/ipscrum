package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.FieldTableData;
import fhdw.ipscrum.client.view.StateTableData;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.TypeEditView).
 */
public interface ITypeEditView extends IView {

	/**
	 * Represents the Event to handle the deletion of a state.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerDeleteState(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the addition of a state.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerAddState(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the deletion of a field.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerDeleteField(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the addition of a field.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerAddField(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the registered state.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerStateSelect(DefaultEventHandler handler);

	/**
	 * displays the list of states.
	 * 
	 * @param states
	 *            are all state types related to the ticket type
	 */
	void refreshStates(List<StateTableData> states);

	/**
	 * displays the list of fields.
	 * 
	 * @param fields
	 *            are all field types related to the ticket type
	 */
	void refreshFields(List<FieldTableData> fields);

	/**
	 * getter of the selected state in the list of the states.
	 * 
	 * @return the currently selected state
	 */
	StateTableData getSelectedState();

	/**
	 * getter of the selected field in the list of the fields.
	 * 
	 * @return the currently selected field
	 */
	FieldType getSelectedField();

	/**
	 * sets the ticket type.
	 * 
	 * @param type
	 *            currently set
	 */
	void setTheType(TicketType type);

}
