package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * Represents the manager that manages the consistency.
 */
public class ConsistencyManager {

	/**
	 * Represents the model the manager is related to.
	 */
	private final Model model;

	/**
	 * Constructor of the ConsistencyManager.
	 * 
	 * @param model
	 *            related to the manager
	 */
	public ConsistencyManager(final Model model) {
		super();
		this.model = model;
	}

	/**
	 * Helper method to ensure that no double project names will exist.
	 * 
	 * @param name
	 *            Name of the Project.
	 * 
	 * @throws DoubleDefinitionException
	 *             if a project with the same name already exists
	 */
	public void existsProjectName(final String name) throws DoubleDefinitionException {
		for (final Project current : this.model.getProjects()) {
			if (current.getName().equals(name)) {
				throw new DoubleDefinitionException(TextConstants.PROJECT_ERROR);
			}
		}
	}

	/**
	 * Helper method to ensure that no double personss will exist.
	 * 
	 * @param person
	 *            the attached person
	 * 
	 * @throws DoubleDefinitionException
	 *             if a person with the same parameters already exists
	 */
	public void checkForDoublePerson(final Person person) throws DoubleDefinitionException {
		for (final Person current : this.model.getAllPersons()) {
			if (current.getFirstname().equals(person.getFirstname())
					&& current.getLastname().equals(person.getLastname())) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
	}

	/**
	 * Helper method to ensure that no double teams will exist.
	 * 
	 * @param team
	 *            the attached team
	 * 
	 * @throws DoubleDefinitionException
	 *             if a team with the same parameters already exists
	 */
	public void checkForDoubleTeams(final Team team) throws DoubleDefinitionException {
		for (final Team current : this.model.getAllTeams()) {
			if (current.getDescription().endsWith(team.getDescription())) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
	}

	/**
	 * Helper method to ensure that no roles use will could be removed.
	 * 
	 * @param role
	 *            the attached role
	 * 
	 * @throws ConsistencyException
	 *             if a role is still in use
	 */
	public void checkForRoleInUse(final Role role) throws ConsistencyException {
		if (this.model.getAllRoles().contains(role)) {
			final Vector<Person> p = role.getPersons();
			if (p != null && !p.isEmpty()) {
				throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_STILL_IN_USE_ERROR);
			}
		} else {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.ROLE_NOT_FOUND_ERROR);
		}
	}

	/**
	 * Helper method to ensure that no double role will exist.
	 * 
	 * @param role
	 *            the attached role
	 * 
	 * @throws DoubleDefinitionException
	 *             if a role with the same parameters already exists
	 */
	public void checkForDoubleRole(final Role role) throws DoubleDefinitionException {
		for (final Role current : this.model.getAllRoles()) {
			if (current.getDescription().equals(role.getDescription())) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
	}

	// public void checkForDoubleIncident(final Incident incident)
	// throws DoubleDefinitionException {
	// if (this.model.getAllGlobalIncidents().contains(incident)) {
	// throw new DoubleDefinitionException(
	// ExceptionConstants.DOUBLE_DEFINITION_ERROR);
	// }
	// }
	//
	// public void checkForDoubleIncidentType(final IncidentType type)
	// throws DoubleDefinitionException {
	// if (this.model.getAllIncidentTypes().contains(type)) {
	// throw new DoubleDefinitionException(
	// ExceptionConstants.DOUBLE_DEFINITION_ERROR);
	// }
	// }

	/**
	 * Helper method to ensure that no double relation types will exist.
	 * 
	 * @param type
	 *            the attached relation type
	 * 
	 * @throws DoubleDefinitionException
	 *             if a type with the same parameters already exists
	 */
	public void checkForDoubleRelationType(final RelationType type) throws DoubleDefinitionException {
		for (final RelationType current : this.model.getAllRelationTypes()) {
			if (current.getDescription().equals(type.getDescription())) {
				throw new DoubleDefinitionException("Beziehungstyp " + type.getDescription() + " bereits vorhanden.");
			}
		}
	}

	/**
	 * Checks if a given date-range is valid.<br/>
	 * A valid date-range is defined by <code>begin<=end</code>
	 * 
	 * @param startDate
	 *            begin
	 * @param endDate
	 *            end
	 * @throws NoValidValueException
	 *             if the given date-range is invalid.
	 */
	public void checkForValidDateRange(final Date startDate, final Date endDate) throws NoValidValueException {
		if (endDate.before(startDate)) {
			throw new NoValidValueException(ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		}
	}

	/**
	 * Checks if a given incident is already in the model defined.<br/>
	 * 
	 * @param name
	 *            Name of the Incident
	 * @throws DoubleDefinitionException
	 *             if the given Incident is already defined.
	 */
	public void checkForDoubleIncident(final String name) throws DoubleDefinitionException {
		try {
			this.model.getIncidentTypeByName(name);
			throw new DoubleDefinitionException(TextConstants.INCIDENTTYPE_DOUBLEDEFINITION);
		} catch (final NoObjectFindException e) {
			// Nothing to do here. Only if the given incident is already defined an
			// exception will be thrown.
		}
	}
}
