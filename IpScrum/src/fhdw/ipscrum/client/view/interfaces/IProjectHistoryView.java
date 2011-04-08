package fhdw.ipscrum.client.view.interfaces;


import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;

/**
 * 
 * @author Phase IV - Group Reporting II 
 * 
 */
public interface IProjectHistoryView extends IView {

	/**
	 * Use this to register a handler for an
	 * event which creates a new dialog to create a new {@link Incident}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	void addcreateIncidentHandler(EventHandler<EventArgs> args);

	/**
	 * Returns the IncidentType
	 * event which opens a new dialog to create a new {@link Project}
	 * 
	 * @return Set<IncidentType>
	 */
	Set<IncidentType> getTypes();
	
	/**
	 * Use this to register a handler for an
	 * event which changes the type
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	void addchangeTypHandler(EventHandler<EventArgs> args);
	
	/**
	 * Use this to refresh the types 
	 */
	void refreshTypes(Vector<IncidentType> types);
	
	/**
	 * Use this to register a handler for an
	 * event which creates a new {@link IncidentType}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	public void addcreateTypeHandler(EventHandler<EventArgs> args);


	/**
	 * Use this to refresh the ProjectHistoryTable
	 * 
	 * @param incidents
	 */
	void refreshProjectHistoryTable(Vector<Incident> incidents);

	/**
	 * Use this to register a handler for an
	 * event which shows the incidents
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	void addShowIncidentsHandler(EventHandler<EventArgs> args);
	
	
}
