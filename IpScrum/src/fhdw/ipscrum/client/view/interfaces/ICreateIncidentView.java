package fhdw.ipscrum.client.view.interfaces;

import java.util.Date;
import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * 
 * @author Phase IV - Group Reporting II 
 * 
 */
public interface ICreateIncidentView extends IView {

	/**
	 * Returns the persons 
	 * 
	 * @return Set<IPerson>
	 */
	Set<IPerson> getPersons();

	/**
	 * Returns the projects
	 * 
	 * @return Set<Project>
	 */
	Set<Project> getProjects();

	/**
	 * Returns the {@link IncidentType}
	 * 
	 * @return IncidentType
	 */
	IncidentType getType();

	/**
	 * Use this to refresh the types
	 */
	void refreshTypes(Vector<IncidentType> types);

	/**
	 * Use this to refresh the persons
	 */
	void refreshPersons(Vector<IPerson> persons);

	/**
	 * Use this to refresh the projects
	 */
	void refreshProjects(Vector<Project> projects);

	/**
	 * Returns the endDate
	 * 
	 * @return Date
	 */
	Date getEndDate();

	/**
	 * Returns the startDate
	 * 
	 * @return Date
	 */
	Date getStartDate();

	/**
	 * Returns the description
	 * 
	 * @return String
	 */
	String getDescription();

	/**
	 *
	 * Use this to register a handler for an event 
	 * which creates an {@link Incident)
	 * 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public void addCreateIncidentHandler(EventHandler<EventArgs> args);

	/**
	 *
	 * Use this to register a handler for an cancel event 
	 * 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public void addCancelEventHandler(EventHandler<EventArgs> args);

}
