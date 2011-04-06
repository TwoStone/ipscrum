package fhdw.ipscrum.client.view.interfaces;

import java.util.Date;
import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface ICreateIncidentView extends IView {

	Set<IPerson> getPersons();

	Set<Project> getProjects();

	IncidentType getType();

	void refreshTypes(Vector<IncidentType> types);

	void refreshPersons(Vector<IPerson> persons);

	void refreshProjects(Vector<Project> projects);

	Date getEndDate();

	Date getStartDate();

	String getDescription();

	public void addCreateIncidentHandler(EventHandler<EventArgs> args);

	public void addCancelEventHandler(EventHandler<EventArgs> args);

}
