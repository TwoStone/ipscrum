package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
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
	private Incident(){}
	
	@SuppressWarnings("rawtypes")
	protected Incident(Date start, Date end){
		this.setStart(start);
		this.setEnd(end);
		this.projectAssoc = new ManyToMany<ManyToMany, Incident>(this);
		this.isGlobal = false;
	}
	
	public abstract void accept(IncidentVisitor visitor);
	
	public static Incident createVacationIncident(IPerson person, Date start, Date end) throws NoValidValueException{
		//TODO:
		return null;
		
		/*if (isEndBeforeStart(start, end)){
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		}
		Incident i = new Incident(start, end);
		i.setType(new Vacation( TextConstants.INCIDENT_VACATION_NAME,
								person.getFirstname()
								+ TextConstants.SPACE 
								+ person.getLastname() 
								+ TextConstants.INCIDENT_VACATION_DESCR_SUFFIX,
							 	person));
		return i;*/
	}
	public static Incident createIllnessIncident(IPerson person, Date start, Date end) throws NoValidValueException{
		//TODO:
		return null;
		/*if (isEndBeforeStart(start, end)){
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		}
		Incident i = new Incident(start, end);
		i.setType(new Illness( TextConstants.INCIDENT_ILLNESS_NAME,
							   person.getFirstname() 
							   + TextConstants.SPACE 
							   + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX,	
							   person));
		return i;*/
	}
	public static Incident createTaskCompletionIncident(ITask task){
		//TODO:
		return null;
		/*Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_TASKCOMPLETION_DESCR_PREFIX 
					+ task.getName()
					+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_INFIX 
					+ task.getResponsiblePerson().getFirstname()
					+ TextConstants.SPACE 
					+ task.getResponsiblePerson().getLastname()
					+ TextConstants.INCIDENT_TASKCOMPLETION_DESCR_SUFFIX;
		
		Incident i = new Incident(d,d);
		
		i.setType(new TaskCompletion(TextConstants.INCIDENT_TASKCOMPLETION_NAME, description, task));
		return i;*/
	}
	public static Incident createPBICompletionIncident(ProductBacklogItem pbi){
		//TODO:
		return null;
		/*IncidentPBIVisitor v = new IncidentPBIVisitor();
		pbi.accept(v);
		Date d = new Date();
		Incident i = new Incident(d, d);
		i.setType(new PBICompletion(v.getResultName(), v.getResultDescription(), pbi));
		return i;*/
	}
	public static Incident createSprintCompletionIncident(ISprint sprint){
		//TODO:
		return null;
		/*Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_PREFIX
					  + sprint.getName() 
					  + TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_INFIX
					  + sprint.getTeam().getDescription()
					  + TextConstants.INCIDENT_SPRINTCOMPLETION_DESCR_SUFFIX;
		Incident i = new Incident(d,d);
		i.setType(new SprintCompletion(TextConstants.INCIDENT_SPRINTCOMPLETION_NAME, description,sprint));
		return i;*/
	}
	public static Incident createReleaseCompletionIncident(IRelease release){
		//TODO:
		return null;
		/*Date d = new Date();
		String description;
		description = TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_PREFIX
					+ release.getVersion()
					+ TextConstants.INCIDENT_RELEASECOMPLETION_DESCR_SUFFIX;
		Incident i = new Incident(d,d);
		i.setType(new ReleaseCompletion(TextConstants.INCIDENT_RELEASECOMPLETION_NAME, description,release));
		return i;*/
	}
	
	public static Incident createOtherIssueIncident(IncidentType type, String description, Date start, Date end) throws NoValidValueException{
		//TODO:
		if (isEndBeforeStart(start, end)){
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		}
		Incident i = new MultipleParticipantIncident(start, end);
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
	private void setType(final IncidentType incidentType){
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
	
	private static boolean isEndBeforeStart(Date start, Date end){
		return end.before(start);
	}
	

}
