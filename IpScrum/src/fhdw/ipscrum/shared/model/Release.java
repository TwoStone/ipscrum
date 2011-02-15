package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Release represents a version of a project. A release could have a number of
 * Sprints.
 * 
 * A Release belongs to explicit one project.
 */
public class Release extends Observable implements IRelease {

	private static final long serialVersionUID = 5237642704820206585L;
	private String version;
	private Date releaseDate;

	private ToProjectAssoc projectAssoc;
	private ToSprintAssoc sprintAssoc;

	@Override
	public ToSprintAssoc getSprintAssoc() {
		return this.sprintAssoc;
	}

	public ToProjectAssoc getProjectAssoc() {
		return this.projectAssoc;
	}

	@SuppressWarnings("unused")
	private Release() {
	}

	public Release(final String version, final Date releaseDate,
			final Project project) throws DoubleDefinitionException {
		this.version = version;
		this.releaseDate = releaseDate;
		// this.project = project;
		this.projectAssoc = new ToProjectAssoc(this);
		this.sprintAssoc = new ToSprintAssoc(this);
		project.isReleaseDoubleDefined(version, releaseDate);// can throw
		// DoubleDefinitionException
		this.getProjectAssoc().finalSet(project.getReleaseAssoc());
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(final String version) {
		this.version = version;
		this.notifyObservers();
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(final Date releaseDate) {
		this.releaseDate = releaseDate;
		this.notifyObservers();
	}

	/**
	 * Return all Sprints which are added to the release. <br />
	 * <b>Attention</b><br />
	 * In fact of providing the consistency you have to use, for adding and
	 * removing a sprint to a release, the methods of the release.
	 */
	public Vector<ISprint> getSprints() {
		final Vector<ISprint> ret = new Vector<ISprint>();
		for (final ISprint.ToReleaseAssoc current : this.getSprintAssoc()
				.getAssociations()) {
			ret.add(current.getElement());
		}
		return ret;
	}

	/**
	 * Adds a Sprint to the release only if the Sprint was defined within the
	 * Project.
	 * 
	 * @throws NoSprintDefinedException
	 *             If the sprint wasn't defined within the project.
	 */
	public void addSprint(final ISprint sprint) throws UserException {
		this.getProject().isSprintDefined(sprint);
		if (sprint.getRelease() == null) {
			this.getSprintAssoc().add(sprint.getToReleaseAssoc());
		} else if (!sprint.getRelease().equals(this)) {
			sprint.getRelease().removeSprint(sprint);
			this.getSprintAssoc().add(sprint.getToReleaseAssoc());
		}
	}

	@Override
	// TODO Kommentar
	public void removeAllSprints() {
		for (final ISprint current : this.getSprints()) {
			this.getSprintAssoc().remove(current.getToReleaseAssoc());
		}
	}

	/**
	 * Removes the given Sprint from the Release.
	 */
	public void removeSprint(final ISprint sprint) {
		this.getSprintAssoc().remove(sprint.getToReleaseAssoc());
	}

	public Project getProject() {
		if (this.getProjectAssoc().get() != null) {
			return this.getProjectAssoc().get().getElement();
		} else {
			return null;
		}
	}

	/**
	 * Returns the Number of all defined Sprints within the
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	@Override
	public String toString() {
		return "Release [releaseDate=" + this.releaseDate + ", version="
				+ this.version + "]";
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((this.releaseDate == null) ? 0 : this.releaseDate.hashCode());
		result = prime * result
				+ ((this.version == null) ? 0 : this.version.hashCode());
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = this.indirectHashCode();
		result = prime
				* result
				+ ((this.projectAssoc == null) ? 0 : this.projectAssoc
						.hashCode());
		result = prime
				* result
				+ ((this.sprintAssoc == null) ? 0 : this.sprintAssoc.hashCode());
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
		final Release other = (Release) obj;
		if (this.releaseDate == null) {
			if (other.releaseDate != null) {
				return false;
			}
		} else if (!this.releaseDate.equals(other.releaseDate)) {
			return false;
		}
		if (this.version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!this.version.equals(other.version)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!this.indirectEquals(obj)) {
			return false;
		} else {
			final Release other = (Release) obj;
			if (this.projectAssoc == null) {
				if (other.projectAssoc != null) {
					return false;
				}
			} else if (!this.projectAssoc.equals(other.projectAssoc)) {
				return false;
			}
			if (this.sprintAssoc == null) {
				if (other.sprintAssoc != null) {
					return false;
				}
			} else if (!this.sprintAssoc.equals(other.sprintAssoc)) {
				return false;
			}
			return true;
		}
	}
}
