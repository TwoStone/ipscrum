package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents a Scrum Project.
 */
@SuppressWarnings("serial")
public class Project extends IdentifiableObject
		implements IsSerializable, ITreeVisitorRelevantElement, PersistentObserver {

	/**
	 * All defined {@link System}s for the project.
	 */
	private List<System> possibleSystems;

	/**
	 * Name of the project.
	 */
	private String name;

	/**
	 * All defined sprints for the project.
	 */
	private List<Sprint> sprints; // Not-bidirectional

	/**
	 * Releases of the Project.
	 */
	private List<Release> releases;

	/**
	 * Productbacklog of the Project.
	 */
	private ProductBacklog backlog;

	/**
	 * Default Constructor for GWT serialization.
	 */
	@SuppressWarnings("unused")
	private Project() {
	}

	/**
	 * Constructor of the Project.
	 * 
	 * @param model
	 *            the project is inserted into the model
	 * @param name
	 *            Name of the Project
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public Project(final Model model, final String name) throws IPScrumGeneralException {
		super(model);
		this.setName(name);
		this.releases = new ArrayList<Release>();
		this.possibleSystems = new ArrayList<System>();
		this.backlog = new ProductBacklog(model, this);
		model.addProject(this);
	}

	@Override
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleProject(this);
	}

	/**
	 * Adds a {@link System} to the local list of systems.
	 * 
	 * @param system
	 *            {@link System}
	 * @throws IPScrumGeneralException
	 */
	public void addSystem(final System system) {
		if (!this.isPossibleSystem(system)) {

			final Iterator<System> i = this.possibleSystems.iterator();
			while (i.hasNext()) {
				final System current = i.next();
				if (system.containsAction(current)) {
					i.remove();
				}
			}
			this.possibleSystems.add(system);
		}
	}

	/**
	 * Adds a new sprint to the project.
	 * 
	 * @param sprint
	 *            Spritn for adding.
	 * @throws DoubleDefinitionException
	 *             If the Sprint already exists (equals check).
	 */
	public void addSprint(final Sprint sprint) throws DoubleDefinitionException {
		for (final Sprint current : this.getSprints()) {
			if (current.getName().equals(sprint.getName())) {
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getSprints().add(sprint);
		sprint.addObserver(this);
		this.notifyObservers();
	}

	/**
	 * Returns the number of defined Sprints within the project!
	 * 
	 * @return the number of sprints in the project
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	/**
	 * Getter of the productBacklog of the project.
	 * 
	 * @return the related productkBacklog
	 */
	public ProductBacklog getBacklog() {
		return this.backlog;
	}

	/**
	 * Returns the name of the project.
	 * 
	 * @return the name of the project
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Change the name of the project.
	 * 
	 * @param name
	 *            that the project should have
	 * @throws DoubleDefinitionException
	 *             if a project with the same name already exists
	 * @throws NoValidValueException
	 *             if the name of the project is empty
	 */
	public void setName(final String name) throws DoubleDefinitionException,
			NoValidValueException {
		if (name.isEmpty()) {
			throw new NoValidValueException(
					"Der Name des Projekts darf nicht leer sein!");
		}
		this.getModel().getConsistencyManager().existsProjectName(name);
		this.name = name;
	}

	/**
	 * Method getPossibleSystems.
	 * 
	 * @return {@link List<System>}
	 */
	public List<System> getSystems() {
		return this.possibleSystems;
	}

	/**
	 * Returns all releases to this project. Don't use this list for removing or adding
	 * release. This will have not effects. Instead e.g. use the removeRelease operation
	 * to remove a release from the project.
	 * 
	 * @return the releases related to the project
	 */
	public Vector<Release> getReleasePlan() {
		final Vector<Release> ret = new Vector<Release>();
		for (final Release current : this.releases) {
			ret.add(current);
		}
		return ret;
	}

	/**
	 * Returns the defined Sprints for this project. <br />
	 * <b>Attention</b><br />
	 * For adding and removing a sprint use the functionalities of the Project, else we
	 * cannot guarantee the consistency!
	 * 
	 * @return all sprints related to the project
	 */
	public List<Sprint> getSprints() {
		if (this.sprints == null) {
			this.sprints = new Vector<Sprint>();
		}
		return this.sprints;
	}

	/**
	 * Returns true, is the referenced {@link system} is in the local list of possible
	 * systems.
	 * 
	 * @param system
	 *            is related to the project
	 * @return boolean is true if the system is related
	 */
	public Boolean isPossibleSystem(final System system) {
		Boolean result = false;
		for (final System current : this.possibleSystems) {
			if (current.equals(system)) {
				result = true;
				break;
			} else {
				if (current.containsAction(system)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Check if a release already exist within the project. This depends on the version
	 * and the release date.
	 * 
	 * @param version
	 *            Version of the release.
	 * @param releaseDate
	 *            Release date.
	 * @throws DoubleDefinitionException
	 *             if a release is already related to the project
	 */
	public void isReleaseDoubleDefined(final String version, final Date releaseDate)
			throws DoubleDefinitionException {
		for (final Release current : this.getReleasePlan()) {
			if (current.getVersion().equals(version)
					&& current.getReleaseDate().equals(releaseDate)) {
				throw new DoubleDefinitionException(TextConstants.RELEASE_ERROR);
			}
		}
	}

	/**
	 * Check if the sprint is defined within the project! Throws an
	 * SprintNotDefinedException if not!
	 * 
	 * @param sprint
	 *            Sprint for check!
	 * @throws NoSprintDefinedException
	 *             if no sprint is defined
	 */
	public void isSprintDefined(final Sprint sprint) throws NoSprintDefinedException {
		if (!this.sprints.contains(sprint)) {
			throw new NoSprintDefinedException(TextConstants.SPRINT_ERROR);
		}
	}

	/**
	 * Remove the given release from the project. Also it ensures the consistency.
	 * 
	 * @param release
	 *            Release to remove.
	 */
	public void removeRelease(final Release release) {
		release.removeAllSprints();
		this.releases.remove(release);
		this.getModel().removeObject(release);
	}

	/**
	 * Adds a release to the project.
	 * 
	 * @param release
	 *            that should be add to the project
	 */
	public void addRelease(final Release release) {
		this.releases.add(release);
		this.changed();
	}

	/**
	 * Getter of the releases related to the project.
	 * 
	 * @return all releases related to the project
	 */
	public List<Release> getReleases() {
		return this.releases;
	}

	@Override
	public String toString() {
		return "Project [name=" + this.name + "]";
	}

	/**
	 * Removes a system from a project.
	 * 
	 * @param system
	 *            is the system to remove
	 * 
	 * @see fhdw.ipscrum.shared.model.HasSystems#removeSystem(fhdw.ipscrum.shared
	 *      .model.System)
	 */
	public void removeSystem(final System system) {
		this.possibleSystems.remove(system);
	}

	/**
	 * returns incidents which have been created in this project.
	 * 
	 * @return all Incidents related to the project
	 */
	public List<Incident> getProjectIncidents() {
		return this.getModel().getIncidentsByProject(this);
	}

	// /**
	// * Adds a new Incident to the project. For every incident i.isGlobal() has
	// * to be false. Otherwise the message will be delegated to the root
	// object.
	// */
	// public void addIncident(final Incident incident)
	// throws DoubleDefinitionException {
	// if (incident == null) {
	// return;
	// }
	// if (incident.isGlobal()) {
	// final AddGLobalIncidentMessage message = new AddGLobalIncidentMessage(
	// incident);
	// this.notifyObservers(message);
	// } else {
	// this.getProjectIncidents().add(incident);
	// }
	// this.notifyObservers();
	// }

	// /**
	// * Removes an existing incident from the project. For every incident
	// * i.isGlobal() has to be false. Otherwise the message will be delegated
	// to
	// * the root object. WARNING: Only use for unit testing.
	// *
	// * @deprecated
	// */
	// @Deprecated
	// public void removeIncident(final Incident incident) {
	// if (incident == null) {
	// return;
	// }
	// if (incident.isGlobal()) {
	// final RemoveGlobalIncidentMessage message = new
	// RemoveGlobalIncidentMessage(
	// incident);
	// this.notifyObservers(message);
	// } else {
	// this.getProjectIncidents().remove(incident);
	// }
	// }

	@Override
	public void update(final Observable observable, final Object argument) {
		// TODO Bug 531: Incidents https://fhdwdev.ha.bib.de/bugzilla/show_bug.cgi?id=531

		// if (!(argument instanceof Message)) {
		// return;
		// // TODO: properly specify operation update(Message message)!!!
		// }
		// ((Message) argument).accept(new MessageVisitor() {
		// @Override
		// public void handleTaskCompletionMessage(
		// final TaskCompletionMessage message) {
		// final Incident i = Incident
		// .createTaskCompletionIncident(message.getTask());
		// try {
		// Project.this.addIncident(i);
		// } catch (final DoubleDefinitionException e) {
		// // do nothing, if Incident is already inside the list
		// }
		// }
		//
		// @Override
		// public void handlePBICompletionMessage(
		// final PBICompletionMessage message) {
		// final Incident i = Incident.createPBICompletionIncident(message
		// .getPBI());
		// try {
		// Project.this.addIncident(i);
		// } catch (final DoubleDefinitionException e) {
		// /*
		// * should never happen, every PBICompletionIncident is
		// * unique because every ProductBacklogItem is unique.
		// */
		// }
		//
		// }
		//
		// @Override
		// public void handleAddGlobalIncidentMessage(
		// final AddGLobalIncidentMessage message) {
		// Project.this.update_GlobalIncident(message);
		// }
		//
		// @Override
		// public void handleReleaseCompletionMessage(
		// final ReleaseCompletionMessage message) {
		// try {
		// Project.this.addIncident(Incident
		// .createReleaseCompletionIncident(message
		// .getRelease()));
		// } catch (final DoubleDefinitionException e) {
		// // no exception notification to client necessary
		// }
		// }
		//
		// @Override
		// public void handleSprintCompletionMessage(
		// final SprintCompletionMessage message) {
		// try {
		// Project.this.addIncident(Incident
		// .createSprintCompletionIncident(message.getSprint()));
		// } catch (final DoubleDefinitionException e) {
		// // no exception notification to client necessary
		// }
		// }
		//
		// @Override
		// public void handleRemoveGlobalIncidentMessage(
		// final RemoveGlobalIncidentMessage message) {
		// Project.this.update_GlobalIncident(message);
		// }
		// });

	}

	/**
	 * This method checks, if sprints or releases are completed.
	 */
	public void checkDeadlines() {
		final Iterator<Sprint> i1 = this.sprints.iterator();
		while (i1.hasNext()) {
			i1.next().checkDeadline();
		}
		final Iterator<Release> i2 = this.getReleasePlan().iterator();
		while (i2.hasNext()) {
			i2.next().checkDeadline();
		}
	}

	/**
	 * notifies the root that a new global incident has been created or shall be removed.
	 * 
	 * @param message
	 *            of the incident in the projecthistory
	 */
	@SuppressWarnings("unused")
	private void updateGlobalIncident(final Message message) {
		this.notifyObservers(message);
	}
}
