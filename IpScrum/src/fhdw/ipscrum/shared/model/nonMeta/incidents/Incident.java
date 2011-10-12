package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * An Incident represents events occurring in one ore more scrum projects. Incidents which are well recorded, are a good
 * tool for analyzing the velocity and the progress of the projects. They represent the project history and provide a
 * basis for planning activities. Incidents are in the operations layer. the knowledge layer contains the
 * {@link IncidentType} instances.
 */
public abstract class Incident extends IdentifiableObject implements IsSerializable {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3849328996818037099L;

	/**
	 * start date of the incident. If the incident lasts one Day, start and end date are the same.
	 */
	private Date start;
	/**
	 * end date of the incident. If the incident lasts one Day, start and end date are the same.
	 */
	private Date end;

	/**
	 * logical value which defines if an incident has global validity.
	 */
	private boolean isGlobal;

	/**
	 * further detail description of the incident.
	 */
	private String description;

	/**
	 * Specific type of the incident.
	 */
	private IncidentType incidentType;

	/**
	 * Project association.
	 */
	private List<Project> project;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected Incident() {
	}

	/**
	 * constructor of the Incident.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param start
	 *            start date of the incident
	 * @param end
	 *            end date of the incident
	 * @throws IPScrumGeneralException
	 *             if somthing fails
	 */
	protected Incident(final Model model, final Date start, final Date end) throws IPScrumGeneralException {
		super(model);

		model.getConsistencyManager().checkForValidDateRange(start, end);

		this.setStart(start);
		this.setEnd(end);
		this.project = new ArrayList<Project>();
		this.isGlobal = false;
		this.putToObjectStore();
	}

	/**
	 * Needed to use a visitor.
	 * 
	 * @param visitor
	 *            is the used visitor
	 */
	public abstract void accept(IncidentVisitor visitor);

	/**
	 * getter of the incident type name.
	 * 
	 * @return the name of the incident
	 */
	public final String getName() {
		return this.getIncidentType().getName();
	}

	/**
	 * getter of the description of the incident.
	 * 
	 * @return the incident description
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * sets the description of the incident.
	 * 
	 * @param description
	 *            is the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
		this.changed();
	}

	/**
	 * getter of the start date of the incident.
	 * 
	 * @return the incidents start date
	 */
	public final Date getStart() {

		return CalendarUtils.copy(this.start);

	}

	/**
	 * sets the start date of the incident.
	 * 
	 * @param start
	 *            date to set in the incident
	 */
	public void setStart(final Date start) {

		this.start = CalendarUtils.copy(start);
		this.changed();
	}

	/**
	 * getter of the end date of the incident.
	 * 
	 * @return the incidents end date
	 */
	public final Date getEnd() {
		return CalendarUtils.copy(this.end);
	}

	/**
	 * sets the end date of the incident.
	 * 
	 * @param end
	 *            is the date to set in the incident
	 */
	public void setEnd(final Date end) {
		this.end = CalendarUtils.copy(end);
		this.changed();
	}

	/**
	 * sets the type of the incident.
	 * 
	 * @param incidentTypeToSet
	 *            is the type to set
	 */
	public void setType(final IncidentType incidentTypeToSet) {
		this.incidentType = incidentTypeToSet;
		this.changed();
	}

	/**
	 * getter of the incident type.
	 * 
	 * @return the type-instance of the Incident
	 */
	public final IncidentType getIncidentType() {
		return this.incidentType;
	}

	/**
	 * getter of the projects related to the incident.
	 * 
	 * @return all related projects
	 */
	public List<Project> getProjects() {
		return this.project;
	}

	/**
	 * Adds a new project to the incident's scope.
	 * 
	 * @param projectToAdd
	 *            to add
	 */
	public void addProject(final Project projectToAdd) {
		if (projectToAdd != null) {
			if (!this.getProjects().contains(projectToAdd)) {
				this.getProjects().add(projectToAdd);
				this.changed();
			}
		}
	}

	/**
	 * Adds a list of projects to the incident's scope.
	 * 
	 * @param listOfProjects
	 *            list of projects to add
	 */
	public void addProjects(final List<Project> listOfProjects) {
		for (final Project projectOfTheList : listOfProjects) {
			this.addProject(projectOfTheList);
			this.changed();
		}
	}

	/**
	 * @return True, if the incident has global validity
	 */
	public boolean isGlobal() {
		return this.isGlobal;
	}

	/**
	 * Changes validity to the value of isGlobal.
	 * 
	 * @param isGlobalIncident
	 *            if true, declares the incident as global
	 */
	public void setGlobal(final boolean isGlobalIncident) {
		this.isGlobal = isGlobalIncident;
		this.changed();
	}

}
