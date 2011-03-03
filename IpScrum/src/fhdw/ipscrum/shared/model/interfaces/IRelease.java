package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;

/**
 * This interface represents a Release. The Interfaces was mainly created to
 * ensure independent implementations of group 1 and 3 of phase 2.
 * 
 */
public interface IRelease extends BDACompare, Serializable, ITreeVisitorRelevantElement {

	/**
	 * Returns a list with all sprints connected to the Release.
	 */
	public abstract Vector<ISprint> getSprints();

	/**
	 * Adds a new sprint to the release if the sprint was defined within the
	 * project where the release belongs to. If the given sprint belongs to
	 * another release the release for this sprint will be changed.
	 * 
	 * @param sprint
	 *            Sprint to be add.
	 * @throws UserException
	 *             Throws if the sprint was not defined within project
	 */
	public abstract void addSprint(ISprint sprint) throws UserException;

	/**
	 * Removes a sprint from the release.
	 * 
	 * @param sprint
	 *            Sprint for removing.
	 */
	public abstract void removeSprint(ISprint sprint);

	/**
	 * Returns the project where the release belongs to.
	 */
	public abstract Project getProject();

	/**
	 * Returns the number of sprints within the release.
	 */
	public abstract Integer countSprints();

	/**
	 * Returns the version of the release.
	 */
	public abstract String getVersion();

	/**
	 * Set the version of the release if no other release within the project has
	 * the same version and release date combination.
	 * 
	 * @param version
	 *            New Version.
	 */
	public abstract void setVersion(String version)
	throws DoubleDefinitionException;

	/**
	 * Returns the release date
	 */
	public abstract Date getReleaseDate();

	/**
	 * Set the release date of the release if no other release within the
	 * project has the same version and release date combination.
	 * 
	 * @param releaseDate
	 *            New release date
	 */
	public abstract void setReleaseDate(Date releaseDate)
	throws DoubleDefinitionException;

	/**
	 * Returns the bidirectional association to the project.
	 */
	public abstract ManyToOne<OneToMany, IRelease> getProjectAssoc();

	/**
	 * Returns the bidirectional association to the sprints.
	 */
	public abstract OneToMany<ManyToOne, IRelease> getSprintAssoc();

	/**
	 * This will remove all sprints from the release.
	 */
	public abstract void removeAllSprints();

	/**
	 * This is to calculate the overall Effort of a release.
	 * @return int, containing overall efforts
	 */
	public abstract int getOverallEfforts();
}