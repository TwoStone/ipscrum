package fhdw.ipscrum.client.viewinterfaces;

import java.io.Serializable;
import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.metamodel.controller.FieldTypeController;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * The view interface for required by the {@link fhdw.ipscrum.client.presenter.GenericTicketPresenter}.
 */
public interface IGenericTicketView extends IView {

	/**
	 * Registers the handler for the event that the current state should be saved.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registerSaveHandler(DefaultEventHandler handler);

	/**
	 * Registers the handler for the event that the operation should be aborted.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registerAbortHandler(DefaultEventHandler handler);

	/**
	 * Registers the handler for the event that the name of the ticket should be changed.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registerNameChangedHandler(EventHandler<TypedEventArg<String>> handler);

	/**
	 * Registers the handler for the event that the description of the ticket should be changed.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registerDescriptionChangeHandler(EventHandler<TypedEventArg<String>> handler);

	/**
	 * Registers the handler for the event that the current state of the ticket should be changed.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration regsiterChangeStateHandler(EventHandler<TypedEventArg<StateType>> handler);

	/**
	 * Sets the name of the ticket in the view.
	 * 
	 * @param name
	 *            name of the ticket
	 */
	void setName(String name);

	/**
	 * Sets the description of the ticket in the view.
	 * 
	 * @param description
	 *            description of the ticket
	 */
	void setDescription(String description);

	/**
	 * Sets the list of possible stated for the ticket in the view.
	 * 
	 * @param stateTypes
	 *            list of possible states for the ticket
	 */
	void setPossibleStates(List<StateType> stateTypes);

	/**
	 * Sets the current state of the ticket in the view.
	 * 
	 * @param stateType
	 *            current state of the ticket
	 */
	void setCurrentState(StateType stateType);

	/**
	 * Adds a {@link FieldTypeController} and its depending widget for the view.
	 * 
	 * @param controller
	 *            that controls the widget in the view.
	 * @param <T>
	 *            The generic type of the controller
	 */
	<T extends Serializable> void add(FieldTypeController<T> controller);

}
