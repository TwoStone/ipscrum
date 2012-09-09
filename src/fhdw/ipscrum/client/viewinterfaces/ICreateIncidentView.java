package fhdw.ipscrum.client.viewinterfaces;

import java.util.Date;
import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;

/**
 * View interface required by {@link fhdw.ipscrum.client.presenter.CreateIncidentPresenter} for creating new incidents.
 */
public interface ICreateIncidentView extends IView {

	/**
	 * Displays the list of {@link IncidentType}s.
	 * 
	 * @param types
	 *            list of {@link IncidentType}s
	 */
	void refreshTypes(List<IncidentType> types);

	/**
	 * Displays the list of possible persons for an incident.
	 * 
	 * @param persons
	 *            possible persons for an incident.
	 */
	void refreshPersons(List<Person> persons);

	/**
	 * Displays the list of possible projects for an incident.
	 * 
	 * @param projects
	 *            possible projects for an incident
	 */
	void refreshProjects(List<Project> projects);

	/**
	 * Returns the selected end date.
	 * 
	 * @return end date
	 */
	Date getEndDate();

	/**
	 * Returns the selected start date.
	 * 
	 * @return start date
	 */
	Date getStartDate();

	/**
	 * Returns the entered description for the incident.
	 * 
	 * @return description
	 */
	String getDescription();

	/**
	 * Returns the list of selected persons for the incident.
	 * 
	 * @return list of selected persons
	 */
	List<Person> getPersons();

	/**
	 * Returns the list of selected projects for the incident.
	 * 
	 * @return list of selected projects
	 */
	List<Project> getProjects();

	/**
	 * Returns the selected type of the incident.
	 * 
	 * @return type of the incident
	 */
	IncidentType getType();

	/**
	 * Registers the handler for the event that the current state should be saved.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registerSave(DefaultEventHandler handler);

	/**
	 * Registers the handler for the event that the operation should be aborted.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 * @return The EventRegistration for the handler and the event.
	 */
	EventRegistration registetAbort(DefaultEventHandler handler);

}
