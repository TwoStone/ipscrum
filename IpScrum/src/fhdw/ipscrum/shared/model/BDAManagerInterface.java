package fhdw.ipscrum.shared.model;

import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.model.metamodel.states.StateProfile;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;

/**
 * Represents the interface of the BDAManager.
 */
public interface BDAManagerInterface {

	/**
	 * Getter of all sprints of a team.
	 * 
	 * @param team
	 *            attached
	 * @return all sprints of the attached team
	 */
	Vector<Sprint> getSprintsByTeam(final Team team);

	/**
	 * Getter of all PBIs related to a sprint.
	 * 
	 * @param sprint
	 *            attached
	 * @return all PBIs related to the attached sprint
	 */
	List<ProductBacklogItem> getPBIsBySprint(final Sprint sprint);

	/**
	 * Getter of the releases related to a sprint.
	 * 
	 * @param sprint
	 *            attached
	 * @return the release related to the attached sprint
	 */
	Release getReleaseBySprint(final Sprint sprint);

	/**
	 * Getter of all persons related to a role.
	 * 
	 * @param role
	 *            attached
	 * @return the persons related to the attached role
	 */
	Vector<Person> getPersonsByRole(final Role role);

	/**
	 * Getter of all direct children related to a system.
	 * 
	 * @param parent
	 *            : the attached system
	 * @return all direct children of the attached parent system
	 */
	List<System> getDirectChildSystems(AbstractSystem parent);

	/**
	 * Getter of the ticketType related to a statProfile.
	 * 
	 * @param sp
	 *            attached stateProfile
	 * @return the ticketType related to the attached stateProfile
	 */
	TicketType getTicketTypeByStateProfile(StateProfile sp);

	/**
	 * Getter of the backlog related to a PBI.
	 * 
	 * @param productBacklogItem
	 *            attached
	 * @return the backlog of the attached PBI
	 */
	ProductBacklog getBacklogByPBI(ProductBacklogItem productBacklogItem);

	/**
	 * Getter of the project related to a sprint.
	 * 
	 * @param sprint
	 *            attached
	 * @return the project related to the attached sprint
	 */
	Project getProjectBySprint(Sprint sprint);

	/**
	 * Getter of the project related to a release.
	 * 
	 * @param release
	 *            attached
	 * @return the project related to the attached release
	 */
	Project getProjectByRelease(Release release);

	/**
	 * Getter of the sprintBacklog related to a task.
	 * 
	 * @param task
	 *            attached
	 * @return the sprintBacklog related to the attached task
	 */
	SprintBacklog getSprintBacklogByTask(Task task);

	/**
	 * Getter of all incidents related to a project.
	 * 
	 * @param project
	 *            attached
	 * @return all incident related to the attached project
	 */
	List<Incident> getIncidentsByProject(Project project);
}
