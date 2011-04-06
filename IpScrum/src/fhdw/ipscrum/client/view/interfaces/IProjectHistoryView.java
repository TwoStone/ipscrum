package fhdw.ipscrum.client.view.interfaces;


import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;

public interface IProjectHistoryView extends IView {

	void addcreateIncidentHandler(EventHandler<EventArgs> args);

	Set<IncidentType> getTypes();
	
	void addchangeTypHandler(EventHandler<EventArgs> args);
	
	void refreshTypes(Vector<IncidentType> types);
	
	public void addcreateTypeHandler(EventHandler<EventArgs> args);


	void refreshProjectHistoryTable(Vector<Incident> incidents);

	void addShowIncidentsHandler(EventHandler<EventArgs> args);
	
	
}
