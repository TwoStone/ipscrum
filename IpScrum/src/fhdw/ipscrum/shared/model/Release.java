package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Release represents a version of a project. A release could have a number of
 * Sprints.
 * 
 * A Release belongs to explicit one project.
 */
public class Release extends Observable implements IRelease {

	private static final long serialVersionUID = 5237642704820206585L;

	/**
	 * Version of the Relase
	 */
	private String version;

	/**
	 * Release Date
	 */
	private Date releaseDate;

	// @final
	/**
	 * Bidirectional association to project.
	 */
	private ManyToOne<OneToMany, IRelease> projectAssoc;

	// @final
	/**
	 * Bidirectional association to sprint.
	 */
	private OneToMany<ManyToOne, IRelease> sprintAssoc;

	@Override
	public OneToMany<ManyToOne, IRelease> getSprintAssoc() {
		return this.sprintAssoc;
	}

	@Override
	public ManyToOne<OneToMany, IRelease> getProjectAssoc() {
		return this.projectAssoc;
	}

	@SuppressWarnings("unused")
	/**
	 * Default Constructor for GWT serialization.
	 */
	private Release() {
	}

	/**
	 * Model based constructor for a release.
	 * 
	 * @param version
	 *            Version of the Release
	 * @param releaseDate
	 *            Release Date
	 * @param project
	 *            Project where the release belongs to.
	 * @throws DoubleDefinitionException
	 *             If the version - release date combination already exits
	 *             within the project.
	 */
	public Release(final String version, final Date releaseDate,
			final Project project) throws DoubleDefinitionException {
		this.version = version;
		this.releaseDate = releaseDate;
		// this.project = project;
		this.projectAssoc = new ManyToOne<OneToMany, IRelease>(this);
		this.sprintAssoc = new OneToMany<ManyToOne, IRelease>(this);
		project.isReleaseDoubleDefined(version, releaseDate);// can throw
		// DoubleDefinitionException
		this.getProjectAssoc().set(project.getReleaseAssoc());
	}

	@Override
	public String getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(final String version)
	throws DoubleDefinitionException {
		this.getProject().isReleaseDoubleDefined(this.getVersion(),
				this.getReleaseDate());
		this.version = version;
		this.notifyObservers();
	}

	@Override
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	@Override
	public void setReleaseDate(final Date releaseDate)
	throws DoubleDefinitionException {
		this.getProject().isReleaseDoubleDefined(this.getVersion(),
				this.getReleaseDate());
		this.releaseDate = releaseDate;
		this.notifyObservers();
	}

	@Override
	public Vector<ISprint> getSprints() {
		final Vector<ISprint> ret = new Vector<ISprint>();
		for (final BDACompare current : this.getSprintAssoc().getAssociations()) {
			ret.add((ISprint) current);
		}
		return ret;
	}

	@Override
	public void addSprint(final ISprint sprint) throws UserException {
		this.getProject().isSprintDefined(sprint);
		this.getSprintAssoc().add(sprint.getToReleaseAssoc());
	}

	@Override
	public void removeAllSprints() {
		for (final ISprint current : this.getSprints()) {
			this.getSprintAssoc().remove(current.getToReleaseAssoc());
		}
	}

	@Override
	public void removeSprint(final ISprint sprint) {
		this.getSprintAssoc().remove(sprint.getToReleaseAssoc());
	}

	@Override
	public Project getProject() {
		return (Project) this.getProjectAssoc().get();
	}

	@Override
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

	@Override
	public int getOverallEfforts() {
		int overallEfforts = 0;

		for (ISprint sprint : this.getSprints()) {
			for (ProductBacklogItem pbi : sprint.getPBIs()) {
				overallEfforts += pbi.getManDayCosts().getValue();
			}
		}
		return overallEfforts;
	}

	@Override
	public void accept(ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleRelease(this);
	}
}
