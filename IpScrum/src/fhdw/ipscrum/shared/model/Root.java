package fhdw.ipscrum.shared.model;

import java.util.HashSet;
import java.util.Vector;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.model.interfaces.HasRelationTypeManager;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

/**
 * This class represent the root point for the whole model. This class is additionally used for storing project independent data like teams, persons and roles.
 */
public class Root extends Observable implements SerializationRoot, HasRelationTypeManager {

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

	/**
	 * Method save.
	 * 
	 * @param identifier String
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
	 * @param project Project for Deletion!
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
	public void addProject(final Project project) throws DoubleDefinitionException {
		this.existsProjectName(project.getName());
		this.getProjects().add(project);
		this.notifyObservers();
	}

	/**
	 * Helper method to ensure that no double project names will exist.
	 * 
	 * @param name Name of the Project.
	 * 
	 * @throws DoubleDefinitionException
	 */
	public void existsProjectName(final String name) throws DoubleDefinitionException {
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
	 * @param person IPerson
	 * @throws DoubleDefinitionException
	 */
	public void addPerson(final IPerson person) throws DoubleDefinitionException {
		if (this.getPersons().contains(person)) {
			throw new DoubleDefinitionException(fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
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
	 * @param team ITeam
	 * @throws DoubleDefinitionException
	 */
	public void addTeam(final ITeam team) throws DoubleDefinitionException {
		if (this.getTeams().contains(team)) {
			throw new DoubleDefinitionException(fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
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
	 * @param role IRole
	 * @throws ConsistencyException
	 */
	public void removeRole(final IRole role) throws ConsistencyException {
		if (this.getRoles().contains(role)) {
			final Vector<IPerson> p = role.getPersons();
			if (p == null || p.isEmpty()) {
				this.getRoles().remove(role);
				this.notifyObservers();
			} else {
				throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_STILL_IN_USE_ERROR);
			}
		} else {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		}

	}

	/**
	 * Adds a new Role to the model.
	 * 
	 * 
	 * @param role IRole
	 * @throws DoubleDefinitionException
	 * @throws ConsistencyException
	 */
	public void addRole(final IRole role) throws DoubleDefinitionException {
		if (this.getRoles().contains(role)) {
			throw new DoubleDefinitionException(fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
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
	 * @return the sysManager
	 */
	public SystemManager getSysManager() {
		if (this.sysManager == null) {
			this.sysManager = new SystemManager();
		}
		return sysManager;
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
		result = prime * result + ((this.getPersons() == null) ? 0 : this.getPersons().hashCode());
		result = prime * result + ((this.getProjects() == null) ? 0 : this.getProjects().hashCode());
		result = prime * result + ((this.getRoles() == null) ? 0 : this.getRoles().hashCode());
		result = prime * result + ((this.getTeams() == null) ? 0 : this.getTeams().hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj Object
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

}
