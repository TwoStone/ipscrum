package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
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
 * Represents the manager of the bidirectional associations.
 */
public class BDAManager implements BDAManagerInterface {

	/**
	 * Represent the model the manager is related to.
	 */
	private final Model model;

	/**
	 * Constructor of the BDAManager.
	 * 
	 * @param model
	 *            the manger is related to
	 */
	public BDAManager(final Model model) {
		super();
		this.model = model;
	}

	@Override
	public Vector<Sprint> getSprintsByTeam(final Team team) {
		final Vector<Sprint> sprints = new Vector<Sprint>();
		for (final Sprint current : this.model.getAllSprint()) {
			current.getTeam().equals(team);
			sprints.add(current);
			return sprints;
		}

		return null;
	}

	@Override
	public List<ProductBacklogItem> getPBIsBySprint(final Sprint sprint) {
		final List<ProductBacklogItem> ret = new ArrayList<ProductBacklogItem>();
		for (final ProductBacklogItem current : this.model.getAllPBIs()) {
			if (current.getSprint() != null && current.getSprint().equals(sprint)) {
				ret.add(current);
			}
		}

		return ret;
	}

	@Override
	public Release getReleaseBySprint(final Sprint sprint) {
		for (final Release current : this.model.getAllReleases()) {
			if (current.getSprints().contains(sprint)) {
				return current;
			}
		}

		return null;
	}

	@Override
	public Vector<Person> getPersonsByRole(final Role role) {

		final Vector<Person> persons = new Vector<Person>();

		for (final Person current : this.model.getAllPersons()) {
			if (current.getRoles().contains(role)) {
				persons.add(current);
			}
		}

		return persons;
	}

	@Override
	public List<System> getDirectChildSystems(final AbstractSystem parent) {
		final List<System> ret = new ArrayList<System>();
		for (final System current : this.model.getAllSystems()) {
			if (current.getParent().equals(parent)) {
				ret.add(current);
			}
		}
		return ret;
	}

	@Override
	public TicketType getTicketTypeByStateProfile(final StateProfile sp) {
		TicketType result = null;
		for (final TicketType current : this.model.getAllTicketTypes()) {
			if (current.getStateProfile().equals(sp)) {
				result = current;
				break;
			}
		}
		return result;
	}

	@Override
	public ProductBacklog getBacklogByPBI(final ProductBacklogItem productBacklogItem) {
		for (final ProductBacklog current : this.model.getAllProductBacklogs()) {
			if (current.getItems().contains(productBacklogItem)) {
				return current;
			}
		}
		return null;
	}

	@Override
	public Project getProjectBySprint(final Sprint sprint) {
		for (final Project current : this.model.getAllProjects()) {
			if (current.getSprints().contains(sprint)) {
				return current;
			}
		}

		return null;
	}

	@Override
	public Project getProjectByRelease(final Release release) {
		for (final Project current : this.model.getAllProjects()) {
			if (current.getReleases().contains(release)) {
				return current;
			}
		}

		return null;
	}

	@Override
	public List<Incident> getIncidentsByProject(final Project project) {
		final List<Incident> ret = new ArrayList<Incident>();
		for (final Incident current : this.model.getAllIncidents()) {
			if (current.getProjects().contains(project)) {
				ret.add(current);
			}
		}

		return ret;
	}

	@Override
	public SprintBacklog getSprintBacklogByTask(final Task task) {
		for (final SprintBacklog current : this.model.getAllSprintBacklog()) {
			if (current.getTasks().contains(task)) {
				return current;
			}
		}
		return null;
	}
}
