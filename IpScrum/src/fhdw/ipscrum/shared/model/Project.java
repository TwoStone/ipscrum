package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToMany;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.bdas.OneToOne;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.messages.AddGLobalIncidentMessage;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.messages.MessageStandardVisitor;
import fhdw.ipscrum.shared.model.messages.MessageVisitor;
import fhdw.ipscrum.shared.model.messages.PBICompletionMessage;
import fhdw.ipscrum.shared.model.messages.ReleaseCompletionMessage;
import fhdw.ipscrum.shared.model.messages.SprintCompletionMessage;
import fhdw.ipscrum.shared.model.messages.TaskCompletionMessage;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

/**
 * Represents a Scrum Project.
 */
@SuppressWarnings("rawtypes")
public class Project extends Observable implements BDACompare, Serializable,
		ITreeVisitorRelevantElement, Observer {

	private static final long serialVersionUID = 6337710256829006568L;

	/**
	 * All defined {@link System}s for the project
	 */
	private List<System> possibleSystems;

	/**
	 * Name of the project.
	 */
	private String name;

	/**
	 * All defined sprints for the project.
	 */
	private List<ISprint> sprints;// Not-bidirectional

	/**
	 * Bidirectional association to releases.
	 */
	private OneToMany<ManyToOne, Project> releaseAssoc;

	/**
	 * Bidirectional association to the product backlog.
	 */
	private OneToOne<OneToOne, Project> backlogAssoc;
	
	/**
	 * Bidirectional association to the incidents.
	 */
	private ManyToMany<ManyToMany, Project> incidentAssoc;
	@SuppressWarnings("unused")
	/**
	 * Default Constructor for GWT serialization.
	 */
	private Project() {
	}

	/**
	 * @param name
	 *            Name of the Project
	 * @throws NoValidValueException
	 *             If the name for the Project is not valid. Valid names are not
	 *             null and have not only whitespace characters.
	 */
	public Project(final String name) throws NoValidValueException,
			ConsistencyException {
		super();
		this.name = name;
		this.releaseAssoc = new OneToMany<ManyToOne, Project>(this);
		this.backlogAssoc = new OneToOne<OneToOne, Project>(this);
		this.backlogAssoc.set(new ProductBacklog(this).getProjectAssoc());
		this.possibleSystems = new ArrayList<System>();
		this.incidentAssoc = new ManyToMany<ManyToMany, Project> (this);
		// project registers for events of product backlog
		this.getBacklog().addObserver(this);
	}

	@Override
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleProject(this);
	}

	/**
	 * Adds a {@link System} to the local list of possible systems
	 * 
	 * @param system
	 *            {@link System}
	 */
	public void addPossibleSystem(final System system) {
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
	public void addSprint(final ISprint sprint)
			throws DoubleDefinitionException {
		if (this.getSprints().contains(sprint)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getSprints().add(sprint);
			this.notifyObservers();
		}
	}

	/**
	 * Returns the number of defined Sprints within the project!
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	@Override
	public boolean equals(final Object obj) {
		if (!this.indirectEquals(obj)) {
			return false;
		} else {
			final Project other = (Project) obj;
			if (this.backlogAssoc == null) {
				if (other.backlogAssoc != null) {
					return false;
				}
			} else if (!this.backlogAssoc.equals(other.backlogAssoc)) {
				return false;
			}
			if (this.releaseAssoc == null) {
				if (other.releaseAssoc != null) {
					return false;
				}
			} else if (!this.releaseAssoc.equals(other.releaseAssoc)) {
				return false;
			}
			if (this.sprints == null) {
				if (other.sprints != null) {
					return false;
				}
			} else if (!this.sprints.equals(other.sprints)) {
				return false;
			}
			return true;
		}
	}

	public ProductBacklog getBacklog() {
		return (ProductBacklog) this.getBacklogAssoc().get();
	}

	/**
	 * Returns the bidirectional association to the backlog.
	 */
	protected OneToOne<OneToOne, Project> getBacklogAssoc() {
		return this.backlogAssoc;
	}

	/**
	 * Returns the name of the project.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method getPossibleSystems.
	 * 
	 * @return {@link List<System>}
	 */
	public List<System> getPossibleSystems() {
		return this.possibleSystems;
	}

	/**
	 * Returns the bidirectional association to the releases.
	 */
	protected OneToMany<ManyToOne, Project> getReleaseAssoc() {
		return this.releaseAssoc;
	}

	/**
	 * Returns all releases to this project. Don't use this list for removing or
	 * adding release. This will have not effects. Instead e.g. use the
	 * removeRelease operation to remove a release from the project.
	 */
	public Vector<IRelease> getReleasePlan() {
		final Vector<IRelease> ret = new Vector<IRelease>();
		for (final BDACompare current : this.getReleaseAssoc()
				.getAssociations()) {
			ret.add((IRelease) current);
		}
		return ret;
	}

	/**
	 * Returns the defined Sprints for this project. <br />
	 * <b>Attention</b><br />
	 * For adding and removing a sprint use the functionalities of the Project,
	 * else we cannot guarantee the consistency!
	 */
	public List<ISprint> getSprints() {
		if (this.sprints == null) {
			this.sprints = new Vector<ISprint>();
		}
		return this.sprints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		result = prime
				* result
				+ ((this.releaseAssoc == null) ? 0 : this.releaseAssoc
						.hashCode());
		result = prime
				* result
				+ ((this.backlogAssoc == null) ? 0 : this.backlogAssoc
						.hashCode());
		result = prime * result
				+ ((this.sprints == null) ? 0 : this.sprints.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Project other = (Project) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * Returns true, is the referenced {@link system} is in the local list of
	 * possible systems
	 * 
	 * @param system
	 * @return boolean
	 */
	public Boolean isPossibleSystem(final System system) {
		final Boolean result = false;
		for (final System current : this.possibleSystems) {
			if (current.equals(system)) {
				return true;
			} else {
				if (current.containsAction(system)) {
					return true;
				}
			}
		}
		return result;
	}

	/**
	 * Check if a release already exist within the project. This depends on the
	 * version and the release date.
	 * 
	 * @param version
	 *            Version of the release.
	 * @param releaseDate
	 *            Release date.
	 * @throws DoubleDefinitionException
	 */
	public void isReleaseDoubleDefined(final String version,
			final Date releaseDate) throws DoubleDefinitionException {
		for (final IRelease current : this.getReleasePlan()) {
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
	 */
	public void isSprintDefined(final ISprint sprint)
			throws NoSprintDefinedException {
		if (!this.sprints.contains(sprint)) {
			throw new NoSprintDefinedException(TextConstants.SPRINT_ERROR);
		}
	}

	/**
	 * Remove the given release from the project. Also it ensures the
	 * consistency.
	 * 
	 * @param release
	 *            Release to remove.
	 */
	public void removeRelease(final IRelease release) {
		release.removeAllSprints();
		this.getReleaseAssoc().remove(release.getProjectAssoc());
	}

	@Override
	public String toString() {
		return "Project [name=" + this.name + "]";
	}

	public void removeSystem(System system) {
		this.possibleSystems.remove(system);
	}
	
	public ManyToMany<ManyToMany, Project> getIncidentAssoc(){
		return this.incidentAssoc;
	}
	
	public void addIncident(final Incident incident) throws DoubleDefinitionException{
		if (incident == null) return;
		if (incident.isGlobal()){
			AddGLobalIncidentMessage message = new AddGLobalIncidentMessage(incident);
			this.notifyObservers(message);
		} else {
			this.getIncidentAssoc().add(incident.getProjectAssoc());
		}
		this.notifyObservers();
	}

	@Override
	public void update(Observable observable, Object argument) {
		if (!(argument instanceof Message)){
			return;
			//TODO: properly specify operation update(Message message)!!!
		}
		((Message) argument).accept(new MessageVisitor() {
			@Override
			public void handleTaskCompletionMessage(TaskCompletionMessage message) {
				Incident i = Incident.createTaskCompletionIncident(message.getTask());
				try {
					Project.this.addIncident(i);
				} catch (DoubleDefinitionException e) {
					// do nothing, if Incident is already inside the list
				}
			}

			@Override
			public void handlePBICompletionMessage(PBICompletionMessage message) {
				Incident i = Incident.createPBICompletionIncident(message.getPBI());
				try {
					Project.this.addIncident(i);
				} catch (DoubleDefinitionException e) {
					/*
					 * should never happen, every PBICompletionIncident is unique because
					 * every ProductBacklogItem is unique.
					 */
				}
				
			}

			@Override
			public void handleAddGlobalIncidentMessage(
					AddGLobalIncidentMessage message) {
				Project.this.update_GlobalIncident(message);
			}
			
			@Override
			public void handleReleaseCompletionMessage(
					ReleaseCompletionMessage message) {
				try {
					Project.this.addIncident(
							Incident.createReleaseCompletionIncident(message.getRelease()));
				} catch (DoubleDefinitionException e) {
					// no exception notification to client necessary
				}
			}

			@Override
			public void handleSprintCompletionMessage(
					SprintCompletionMessage message) {
				try {
					Project.this.addIncident(
							Incident.createSprintCompletionIncident(message.getSprint()));
				} catch (DoubleDefinitionException e) {
					// no exception notification to client necessary
				}
			}
		});
		
	}
	
	public void checkDeadlines(){
		Iterator<ISprint> i1 = this.sprints.iterator();
		while (i1.hasNext()){i1.next().checkDeadline();}
		Iterator<IRelease> i2 = this.getReleasePlan().iterator();
		while (i2.hasNext()){i2.next().checkDeadline();}
	}
	
	/**
	 * notifies the root that a new global incident has been created
	 */
	private void update_GlobalIncident(AddGLobalIncidentMessage message) {
		this.notifyObservers(message);
	}
}
