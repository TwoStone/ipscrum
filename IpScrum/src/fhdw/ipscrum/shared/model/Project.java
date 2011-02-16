package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents a Scrum Project.
 */
public class Project extends Observable implements BDACompare, Serializable {

	private static final long serialVersionUID = 6337710256829006568L;

	private String name;
	private Vector<ISprint> sprints;// Not-bidirectional

	private ToReleaseAssoc releaseAssoc;
	private ToBacklogAssoc backlogAssoc;

	public class ToReleaseAssoc extends
			BDAManyToMany<Release.ToProjectAssoc, Project> {
		public ToReleaseAssoc(final Project element) {
			super(element);
		}
	}

	public class ToBacklogAssoc extends
			BDAManyToMany<ProductBacklog.ToProjectAssoc, Project> {
		public ToBacklogAssoc(final Project element) {
			super(element);
		}
	}

	protected ToBacklogAssoc getBacklogAssoc() {
		return this.backlogAssoc;
	}

	protected ToReleaseAssoc getReleaseAssoc() {
		return this.releaseAssoc;
	}

	@SuppressWarnings("unused")
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
		this.setName(name);
		this.releaseAssoc = new ToReleaseAssoc(this);
		this.backlogAssoc = new ToBacklogAssoc(this);
		this.backlogAssoc.finalSet(new ProductBacklog(this).getProjectAssoc());
	}

	public Vector<IRelease> getReleasePlan() {
		final Vector<IRelease> ret = new Vector<IRelease>();
		for (final Release.ToProjectAssoc current : this.getReleaseAssoc()
				.getAssociations()) {
			ret.add(current.getElement());
		}
		return ret;
	}

	public String getName() {
		return this.name;
	}

	// TODO Kommentar
	public void removeRelease(final IRelease release) {
		release.removeAllSprints();
		this.getReleaseAssoc().remove(release.getProjectAssoc());
	}

	/**
	 * Set a new Project name!
	 * 
	 * @param name
	 *            Name of the Project
	 * @throws NoValidValueException
	 *             If the name for the Project is not valid. Valid names are not
	 *             null and have not only whitespace characters.
	 */
	public void setName(final String name) throws NoValidValueException {
		if (name != null && name.trim().length() > 0) {
			this.name = name;
			this.notifyObservers();
		} else {
			throw new NoValidValueException(TextConstants.MISSING_PROJECT_NAME);
		}
	}

	public ProductBacklog getBacklog() {
		if (this.getBacklogAssoc().get() != null) {
			return this.getBacklogAssoc().get().getElement();
		} else {
			return null;
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
		final Iterator<ISprint> i = this.getSprints().iterator();
		while (i.hasNext()) {
			if (i.next().equals(sprint)) {
				return;
			}
		}
		throw new NoSprintDefinedException(TextConstants.SPRINT_ERROR);
	}

	/**
	 * Returns the defined Sprints for this project. <br />
	 * <b>Attention</b><br />
	 * For adding and removing a sprint use the functionalities of the Project,
	 * else we cannot guarantee the consistency!
	 */
	public Vector<ISprint> getSprints() {
		if (this.sprints == null) {
			this.sprints = new Vector<ISprint>();
		}
		return this.sprints;
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param sprint
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

	public void isReleaseDoubleDefined(final String version,
			final Date releaseDate) throws DoubleDefinitionException {
		for (final IRelease current : this.getReleasePlan()) {
			if (current.getVersion().equals(version)
					&& current.getReleaseDate().equals(releaseDate)) {
				throw new DoubleDefinitionException(
						TextConstants.RELEASE_ERROR);
			}
		}
	}

	/**
	 * Returns the number of defined Sprints within the project!
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	@Override
	public String toString() {
		return "Project [name=" + this.name + "]";
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
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
}
