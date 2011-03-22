package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import java.util.Iterator;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
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
public class Incident extends Observable implements BDACompare {
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
	
	/**
	 * Project association
	 */
	private ManyToMany<ManyToMany, Incident> projectAssoc;
	/* private constructor for serialization */
	private Incident(){}
	
	private Incident(String name, String description, Date start, Date end){
		this.setName(name);
		this.setDescription(description);
		this.setStart(start);
		//TODO: Plausibilität prüfen!
		this.setEnd(end);
		this.projectAssoc = new ManyToMany<ManyToMany, Incident>(this);
	}
	public static Incident createVacationIncident(IPerson person, Date start, Date end){
		Incident i = new Incident(TextConstants.INCIDENT_VACATION_NAME,
								  person.getFirstname() + TextConstants.SPACE + person.getLastname() + TextConstants.INCIDENT_VACATION_DESCR_SUFFIX,
								  start,
								  end);
		i.setType(new Vacation(person));
		return i;
	}
	public static Incident createIllnessIncident(IPerson person, Date start, Date end){
		Incident i = new Incident(TextConstants.INCIDENT_ILLNESS_NAME,
								  person.getFirstname() + TextConstants.SPACE + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX,
								  start,
								  end);
		i.setType(new Illness(person));
		return i;
	}
	public static Incident createTaskCompletionIncident(ITask task){
		Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_TASKCOMPLETION_DESCR_PREFIX 
					+ task.getName()
					+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_INFIX 
					+ task.getResponsiblePerson().getFirstname()
					+ TextConstants.SPACE 
					+ task.getResponsiblePerson().getLastname()
					+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_SUFFIX;
		
		Incident i = new Incident(TextConstants.INCIDENT_TASKCOMPLETION_NAME, 
								  description, 
								  d, 
								  d);
		
		i.setType(new TaskCompletion(task));
		return i;
	}
	public static Incident createPBICompletionIncident(ProductBacklogItem pbi){
		IncidentPBIVisitor v = new IncidentPBIVisitor();
		pbi.accept(v);
		Date d = new Date();
		Incident i = new Incident(v.getResultName(), v.getResultDescription(), d, d);
		i.setType(new PBICompletion(pbi));
		return i;
	}
	public static Incident createSprintCompletionIncident(ISprint sprint){
		Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_PREFIX
					  + sprint.getName() 
					  + TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_INFIX
					  + sprint.getTeam().getDescription()
					  + TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_SUFFIX;
		Incident i = new Incident(TextConstants.INCIDENT_SPRINTCOMPLETION_NAME, 
								  description, 
								  d, 
								  d);
		i.setType(new SprintCompletion(sprint));
		return i;
	}
	public static Incident createReleaseCompletionIncident(IRelease release){
		Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_PREFIX
					+ release.getVersion()
					+ TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_SUFFIX;
		Incident i = new Incident(TextConstants.INCIDENT_RELEASECOMPLETION_NAME, 
								  description, 
								  d, 
								  d);
		i.setType(new ReleaseCompletion(release));
		return i;
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
		return this.incidentType.getParticipants();
	}
	
	public ManyToMany<ManyToMany, Incident> getProjectAssoc(){
		return this.projectAssoc;
	}
	
	public void addProject(Project project) {
		if (project != null){
			this.getProjectAssoc().add(project.getIncidentAssoc());
		}
	}

	@Override
	public int indirectHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
