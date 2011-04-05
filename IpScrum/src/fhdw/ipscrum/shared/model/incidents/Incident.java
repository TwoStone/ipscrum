package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Root;
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
public abstract class Incident extends Observable implements BDACompare {
	private static final long serialVersionUID = 3849328996818037099L;
	
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
	 * logical value which defines if an incident has global validity
	 */
	private boolean isGlobal;
	/**
	 * further detail description of the incident
	 */
	private String description;
	/**
	 * Specific type of the incident;
	 */
	private IncidentType incidentType;
	
	/**
	 * Project association
	 */
	@SuppressWarnings("rawtypes")
	private ManyToMany<ManyToMany, Incident> projectAssoc;
	/* private constructor for serialization */
	@SuppressWarnings("unused")
	private Incident(){}
	
	@SuppressWarnings("rawtypes")
	protected Incident(Date start, Date end){
		this.setStart(start);
		this.setEnd(end);
		this.projectAssoc = new ManyToMany<ManyToMany, Incident>(this);
		this.isGlobal = false;
	}
	
	public abstract void accept(IncidentVisitor visitor);
	
	public static OneParticipantIncident createVacationIncident(IPerson person, Date start, Date end) throws NoValidValueException{
		if (isEndBeforeStart(start, end))
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentType type = root.getIncidentTypeByName(TextConstants.INCIDENT_VACATION_NAME);
		String description = person.getFirstname()
							+ TextConstants.SPACE 
							+ person.getLastname() 
							+ TextConstants.INCIDENT_VACATION_DESCR_SUFFIX;
		OneParticipantIncident i = new OneParticipantIncident(start, end, person);
		i.setType(type);
		i.setDescription(description);
		i.setGlobal(true);
		return i;
	}
	public static OneParticipantIncident createIllnessIncident(IPerson person, Date start, Date end) throws NoValidValueException{
		if (isEndBeforeStart(start, end))
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentType type = root.getIncidentTypeByName(TextConstants.INCIDENT_ILLNESS_NAME);
		String description = person.getFirstname() 
		   					+ TextConstants.SPACE 
		   					+ TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;
		OneParticipantIncident i = new OneParticipantIncident(start, end, person);
		i.setType(type);
		i.setDescription(description);
		i.setGlobal(true);
		return i;
	}
	public static OneParticipantIncident createTaskCompletionIncident(ITask task){
		Date d = new Date();
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentType type = root.getIncidentTypeByName(TextConstants.INCIDENT_TASKCOMPLETION_NAME);
		String description = TextConstants.INCIDENT_TASKCOMPLETION_DESCR_PREFIX 
							+ task.getName()
							+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_INFIX 
							+ task.getResponsiblePerson().getFirstname()
							+ TextConstants.SPACE 
							+ task.getResponsiblePerson().getLastname()
							+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_SUFFIX;
		OneParticipantIncident i = new OneParticipantIncident( d, d, task.getResponsiblePerson());
		i.setType(type);
		i.setDescription(description);		
		return i;
	}
	public static OneParticipantIncident createPBICompletionIncident(ProductBacklogItem pbi){
		Date d = new Date();
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentPBIVisitor v = new IncidentPBIVisitor();
		// check concrete subclass of ProductBacklogItem
		pbi.accept(v);
		IncidentType type = root.getIncidentTypeByName(v.getResultName());
		String description = v.getResultDescription();
		OneParticipantIncident i = new OneParticipantIncident(d, d, pbi.getLastEditor());
		i.setType(type);
		i.setDescription(description);
		return i;
	}
	public static MultipleParticipantIncident createSprintCompletionIncident(ISprint sprint){
		Date d = new Date();
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentType type = root.getIncidentTypeByName(TextConstants.INCIDENT_SPRINTCOMPLETION_NAME);
		String description = TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_PREFIX
							+ sprint.getName() 
							+ TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_INFIX
							+ sprint.getTeam().getDescription()
							+ TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_SUFFIX;
		MultipleParticipantIncident i = new MultipleParticipantIncident(d, d);
		i.setType(type);
		i.setDescription(description);
		return i;
	}
	public static MultipleParticipantIncident createReleaseCompletionIncident(IRelease release){
		Date d = new Date();
		Root root = SessionManager.getInstance().getModel(); //TODO: geht das auch besser?
		IncidentType type = root.getIncidentTypeByName(TextConstants.INCIDENT_RELEASECOMPLETION_NAME);
		String description = TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_PREFIX
							+ release.getVersion()
							+ TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_SUFFIX;
		MultipleParticipantIncident i = new MultipleParticipantIncident(d, d);
		i.setType(type);
		i.setDescription(description);
		return i;
	}
	
	public static MultipleParticipantIncident createOtherIssueIncident(IncidentType type, String description, Date start, Date end) throws NoValidValueException{
		if (isEndBeforeStart(start, end)){
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		}
		MultipleParticipantIncident i = new MultipleParticipantIncident(start, end);
		i.setType(type);
		i.setDescription(description);
		return i;
		
	}

	public final String getName() {
		return this.getIncidentType().getName();
	}

	public final String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public final Date getStart() {
		return this.start;
	}

	public void setStart(final Date start) {
		this.start = start;
	}

	public final Date getEnd() {
		return end;
	}

	public void setEnd(final Date end) {
		this.end = end;
	}
	protected void setType(final IncidentType incidentType){
		this.incidentType = incidentType;
	}
	public final IncidentType getIncidentType(){
		return this.incidentType;
	}
	
	@SuppressWarnings("rawtypes")
	public ManyToMany<ManyToMany, Incident> getProjectAssoc(){
		return this.projectAssoc;
	}
	
	public void addProject(Project project) {
		if (project != null){
			this.getProjectAssoc().add(project.getIncidentAssoc());
		}
	}
	
	public boolean isGlobal(){
		return this.isGlobal;
	}
	
	public void setGlobal(boolean isGlobal){
		this.isGlobal = isGlobal;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result
				+ ((incidentType == null) ? 0 : incidentType.hashCode());
		result = prime * result + (isGlobal ? 1231 : 1237);
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incident other = (Incident) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (incidentType == null) {
			if (other.incidentType != null)
				return false;
		} else if (!incidentType.equals(other.incidentType))
			return false;
		if (isGlobal != other.isGlobal)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	
	private static boolean isEndBeforeStart(Date start, Date end){
		return end.before(start);
	}

	@Override
	public int hashCode() {
		return this.indirectHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.indirectEquals(obj);
	}
	
	

}
