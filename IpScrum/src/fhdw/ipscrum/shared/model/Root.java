package fhdw.ipscrum.shared.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.HasRelationTypeManager;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.messages.AddGLobalIncidentMessage;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.messages.MessageStandardVisitor;
import fhdw.ipscrum.shared.model.messages.RemoveGlobalIncidentMessage;
import fhdw.ipscrum.shared.model.search.SearchManager;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.TransientObserver;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

/**
 * This class represent the root point for the whole model. This class is
 * additionally used for storing project independent data like teams, persons
 * and roles.
 */

public class Root extends Observable implements SerializationRoot,
		HasRelationTypeManager, TransientObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6666063945302893637L;

	private Vector<Project> projects;
	private HashSet<IPerson> persons;
	private HashSet<ITeam> teams;
	private HashSet<IRole> roles;
	private RelationTypeManager relationTypeManager;
	private SystemManager sysManager;
	private Vector<Incident> globalIncidents;
	private Map<String, IncidentType> incidentTypes;
	private SearchManager searchManager;

	/**
	 * Method save.
	 * 
	 * @param identifier
	 *            String
	 * @throws PersistenceException
	 * @see fhdw.ipscrum.shared.persistence.SerializationRoot#save(String)
	 */
	@Override
	public void save(final String identifier) throws PersistenceException {
		// No Implementation Needed
	}

	/**
	 * Method getPersons.
	 * 
	 * @return HashSet<IPerson>
	 */
	public HashSet<IPerson> getPersons() {
		if (this.persons == null) {
			this.persons = new HashSet<IPerson>();
		}
		return this.persons;
	}

	/**
	 * Method getProjects.
	 * 
	 * @return Vector<Project>
	 */
	public Vector<Project> getProjects() {
		if (this.projects == null) {
			this.projects = new Vector<Project>();
		}
		return this.projects;
	}

	public SearchManager getSearchManager() {
		if (this.searchManager == null) {
			this.searchManager = new SearchManager();
		}
		return this.searchManager;
	}

	/**
	 * Method getTeams.
	 * 
	 * @return HashSet<ITeam>
	 */
	public HashSet<ITeam> getTeams() {
		if (this.teams == null) {
			this.teams = new HashSet<ITeam>();
		}
		return this.teams;
	}

	/**
	 * Method getRoles.
	 * 
	 * @return HashSet<IRole>
	 */
	public HashSet<IRole> getRoles() {
		if (this.roles == null) {
			this.roles = new HashSet<IRole>();
		}
		return this.roles;
	}

	/**
	 * Method getRelationTypeManager.
	 * 
	 * @return RelationTypeManager
	 * @see fhdw.ipscrum.shared.model.interfaces.HasRelationTypeManager#getRelationTypeManager()
	 */
	@Override
	public RelationTypeManager getRelationTypeManager() {
		if (this.relationTypeManager == null) {
			this.relationTypeManager = new RelationTypeManager();
		}
		return this.relationTypeManager;
	}

	/**
	 * Removes the given project with all depending data from the model.
	 * 
	 * @param project
	 *            Project for Deletion!
	 */
	public void removeProject(final Project project) {
		this.getProjects().remove(project);
		this.notifyObservers();
	}

	/**
	 * Add a new Project to the model.
	 * 
	 * @param project
	 * @throws DoubleDefinitionException
	 */
	public void addProject(final Project project)
			throws DoubleDefinitionException {
		this.existsProjectName(project.getName());
		this.getProjects().add(project);
		project.addObserver(this);
		this.notifyObservers();
	}

	/**
	 * Helper method to ensure that no double project names will exist.
	 * 
	 * @param name
	 *            Name of the Project.
	 * 
	 * @throws DoubleDefinitionException
	 */
	public void existsProjectName(final String name)
			throws DoubleDefinitionException {
		for (final Project current : this.getProjects()) {
			if (current.getName().equals(name)) {
				throw new DoubleDefinitionException(TextConstants.PROJECT_ERROR);
			}
		}
	}

	/**
	 * Returns the number of Projects within the model!
	 * 
	 * @return Integer
	 */
	public Integer countProjects() {
		return this.getProjects().size();
	}

	/**
	 * Adds a new person to the model!
	 * 
	 * 
	 * @param person
	 *            IPerson
	 * @throws DoubleDefinitionException
	 */
	public void addPerson(final IPerson person)
			throws DoubleDefinitionException {
		if (this.getPersons().contains(person)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getPersons().add(person);
			this.notifyObservers();
		}
	}

	/**
	 * Returns the number of all persons within the Model.
	 * 
	 * @return Integer
	 */
	public Integer countPersons() {
		return this.getPersons().size();
	}

	/**
	 * Adds a new Team to the model.
	 * 
	 * 
	 * @param team
	 *            ITeam
	 * @throws DoubleDefinitionException
	 */
	public void addTeam(final ITeam team) throws DoubleDefinitionException {
		if (this.getTeams().contains(team)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getTeams().add(team);
			this.notifyObservers();
		}
	}

	/**
	 * Returns the number of all defined teams.
	 * 
	 * @return Integer
	 */
	public Integer countTeams() {
		return this.getTeams().size();
	}

	/**
	 * Removes the given role. TODO Check Consistency
	 * 
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 */
	public void removeRole(final IRole role) throws ConsistencyException {
		if (this.getRoles().contains(role)) {
			final Vector<IPerson> p = role.getPersons();
			if (p == null || p.isEmpty()) {
				this.getRoles().remove(role);
				this.notifyObservers();
			} else {
				throw new ConsistencyException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_STILL_IN_USE_ERROR);
			}
		} else {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		}

	}

	/**
	 * Adds a new Role to the model.
	 * 
	 * 
	 * @param role
	 *            IRole
	 * @throws DoubleDefinitionException
	 * @throws ConsistencyException
	 */
	public void addRole(final IRole role) throws DoubleDefinitionException {
		if (this.getRoles().contains(role)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getRoles().add(role);
			this.notifyObservers();
		}
	}

	/**
	 * Returns the number of all Roles.
	 * 
	 * @return Integer
	 */
	public Integer countRoles() {
		return this.getRoles().size();
	}

	/**
	 * Method getSysManager
	 * 
	 * @return {@link SystemManager}
	 */
	public SystemManager getSysManager() {
		if (this.sysManager == null) {
			this.sysManager = new SystemManager();
		}
		return this.sysManager;
	}
	
	/**
	 * Adds a new global incident.  
	 * @param incident for all incidents i.isGlobal() has to be true (consistency condition)
	 * @throws DoubleDefinitionException 
	 */
	public void addIncident(Incident incident) throws DoubleDefinitionException {
		if (incident == null)
			return;
		if (!this.globalIncidents.contains(incident)) {
			this.globalIncidents.add(incident);
		} else {
			throw new DoubleDefinitionException(
					ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		}
		this.notifyObservers();
	}
	
	/**
	 * Removes an incident.
	 * Warning: Only for use in unit tests!
	 * @deprecated
	 */
	public void removeIncident(Incident incident) {
		if (incident != null && this.globalIncidents.contains(incident)) {
			this.globalIncidents.remove(incident);
		}
		this.notifyObservers();
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return TextConstants.ROOT;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.getPersons() == null) ? 0 : this.getPersons()
						.hashCode());
		result = prime
				* result
				+ ((this.getProjects() == null) ? 0 : this.getProjects()
						.hashCode());
		result = prime * result
				+ ((this.getRoles() == null) ? 0 : this.getRoles().hashCode());
		result = prime * result
				+ ((this.getTeams() == null) ? 0 : this.getTeams().hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Root other = (Root) obj;
		if (this.getPersons() == null) {
			if (other.getPersons() != null) {
				return false;
			}
		} else if (!this.getPersons().equals(other.getPersons())) {
			return false;
		}
		if (this.getProjects() == null) {
			if (other.getProjects() != null) {
				return false;
			}
		} else if (!this.getProjects().equals(other.getProjects())) {
			return false;
		}
		if (this.getRoles() == null) {
			if (other.getRoles() != null) {
				return false;
			}
		} else if (!this.getRoles().equals(other.getRoles())) {
			return false;
		}
		if (this.getTeams() == null) {
			if (other.getTeams() != null) {
				return false;
			}
		} else if (!this.getTeams().equals(other.getTeams())) {
			return false;
		}
		return true;
	}

	@Override
	public void update(Observable observable, Object argument) {
		if (!(argument instanceof Message)) {
			return;
		}
		((Message) argument).accept(new MessageStandardVisitor() {

			@Override
			public void handleAddGlobalIncidentMessage(
					AddGLobalIncidentMessage message) {
				try {
					Root.this.addIncident(message.getIncident());
				} catch (DoubleDefinitionException e) {
					// do not add
				}
			}
			
			

			@Override
			public void handleRemoveGlobalIncidentMessage(
					RemoveGlobalIncidentMessage message) {
				Root.this.removeIncident(message.getIncident());
			}



			@Override
			public void standardHandling() {
				// not interested in other messages

			}
		});
	}
	/**
	 * This method returns all global incidents. global means, the incidents are valid for
	 * the entire application.
	 */
	public Vector<Incident> getGlobalIncidents(){
		if (this.globalIncidents == null){ 
			this.globalIncidents = new Vector<Incident>();
		} 
		return this.globalIncidents;
	}
	/**
	 * This method returns an iterator for all global incidents. 
	 * @see getGlobalIncidents
	 */
	public final Iterator<Incident> getGlobalIncidentsIterator(){
		return this.getGlobalIncidents().iterator();
	}

	public Collection<ProductBacklogItem> getAllTickets() {
		Collection<ProductBacklogItem> result = new Vector<ProductBacklogItem>();
		for (Project project : this.projects) {
			result.addAll(project.getBacklog().getItems());
		}
		return result;
	}
	
	/**
	 * Adds a new unique incident type identified by a unique name
	 * @param name name of the incident type
	 * @param incidentType new concrete incident type
	 * @throws DoubleDefinitionException if a type with the name already exists
	 */
	public void addIncidentType(String name, IncidentType incidentType) throws DoubleDefinitionException{
		if (!(this.getIncidentTypeMap().get(name)==null)){
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else{
			this.getIncidentTypeMap().put(name, incidentType);
		}
	}
	
	private Map<String, IncidentType> getIncidentTypeMap(){
		if (this.incidentTypes == null){
			this.incidentTypes = new HashMap<String, IncidentType>();
		}
		return this.incidentTypes;
	}
	/**
	 * Returns the unique incident by a specified name
	 * @param name
	 * @return
	 */
	public IncidentType getIncidentTypeByName(String name) {
		IncidentType result = this.getIncidentTypeMap().get(name);
		if (result == null){
			return null;
			//TODO: NoSuchValueException
		} else{
			return result;
		}
	}
	
	/**
	 * returns all incident types which are defined in the application's context.
	 * @return
	 */
	public Collection<IncidentType> getIncidentTypes(){
		return this.getIncidentTypeMap().values();
	}

}
