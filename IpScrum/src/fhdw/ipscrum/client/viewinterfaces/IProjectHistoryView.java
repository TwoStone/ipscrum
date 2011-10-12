package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.ProjectHistoryView).
 */
public interface IProjectHistoryView extends IView {

	/**
	 * displays the list of incidents in the project history.
	 * 
	 * @param incidents
	 *            are all incidents related to this history
	 */
	void refreshProjectHistoryTable(List<Incident> incidents);

	/**
	 * Represents the Event to create a new incident.
	 * 
	 * @param args
	 *            needed to handle the event
	 */
	void addcreateIncidentHandler(DefaultEventHandler args);

	/**
	 * Represents the Event to create a new incident type.
	 * 
	 * @param args
	 *            needed to handle the event
	 */
	void addcreateTypeHandler(EventHandler<EventArgs> args);

	/**
	 * Represents the Event to change the type of the incident.
	 * 
	 * @param args
	 *            needed to handle the event
	 */
	void addchangeTypHandler(EventHandler<EventArgs> args);

	/**
	 * Represents the Event to show only filtred incidents.
	 * 
	 * @param args
	 *            needed to handle the event
	 */
	void addShowIncidentsHandler(EventHandler<EventArgs> args);

	/**
	 * displays the list of incident types.
	 * 
	 * @param types
	 *            are all existing incident types
	 */
	void refreshTypes(List<IncidentType> types);

	/**
	 * getter of all incident types.
	 * 
	 * @return all current incident types
	 */
	List<IncidentType> getTypes();

}
