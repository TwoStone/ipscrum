package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Iterator;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.observer.Observable;
/**
 * An Incident represents events occurring in one ore more scrum projects.
 * Incidents which are well recorded, are a good tool for analyzing the velocity 
 * and the progress of the projects. They represent the project history and 
 * provide a basis for planning activities.
 */
public class Incident extends Observable {
	private static final long serialVersionUID = 3849328996818037099L;
	
	/**
	 * the name of the incident
	 */
	private String name;
	/**
	 * further detail description
	 */
	private String description;
	/**
	 * start date of the incident. If the incident lasts one Day,
	 * start and end date are the same.
	 */
	private Date start;
	/**
	 * end date of the incident. If the incident lasts one Day,
	 * start and end date are the same.
	 */
	private Date end;
	/**
	 * Specific type of the incident;
	 */
	private IncidentType incidentType;
	/* private constructor for serialization */
	private Incident(){}
	
	private Incident(String name, String description, Date start, Date end){
		this.setName(name);
		this.setDescription(description);
		this.setStart(start);
		//TODO: Plausibilität prüfen!
		this.setEnd(end);
		//TODO: Type festlegen
	}
	public static Incident createVacationIncident(IPerson person){
		//TODO: Factory Methoden implementieren
		return null;
	}
	public static Incident createIllnessIncident(IPerson person){
		//TODO: Factory Methoden implementieren
		return null;
	}
	public static Incident createTaskCompletionIncident(ITask task){
		//TODO: Factory Methoden implementieren
		return null;
	}
	public static Incident createPBICompletionIncident(ProductBacklogItem pbi){
		//TODO: Factory Methoden implementieren
		return null;
	}
	public static Incident createSprintCompletionIncident(ISprint sprint){
		//TODO: Factory Methoden implementieren
		return null;
	}
	public static Incident createReleaseCompletionIncident(IRelease release){
		//TODO: Factory Methoden implementieren
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	private void setType(IncidentType incidentType){
		this.incidentType = incidentType;
	}
	public final IncidentType getIncidentType(){
		return this.incidentType;
	}

	public Iterator<IPerson> getParticipants(){
		//TODO: getParticipants implementieren
		return null;
	}

}
