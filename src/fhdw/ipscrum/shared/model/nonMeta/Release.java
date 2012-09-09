package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.ModelException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.messages.ReleaseCompletionMessage;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Release represents a version of a project. A release could have a number of Sprints.
 * 
 * A Release belongs to explicit one project.
 */
public class Release extends IdentifiableObject implements PersistentObserver {

	/**
	 * Represents the serailVersionUID.
	 */
	private static final long serialVersionUID = 5237642704820206585L;

	/**
	 * Version of the Release.
	 */
	private String version;

	/**
	 * Release Date.
	 */
	private Date currentReleaseDate;

	// @final
	/**
	 * Sprints of the Release..
	 */
	private List<Sprint> sprints;

	/**
	 * Default Constructor for GWT serialization.
	 */
	@SuppressWarnings("unused")
	private Release() {
	}

	/**
	 * Model based constructor for a release.
	 * 
	 * @param model
	 *            the release is inserted in the model
	 * 
	 * @param version
	 *            Version of the Release
	 * @param releaseDate
	 *            Release Date
	 * @param project
	 *            Project where the release belongs to.
	 * @throws ModelException
	 *             if the consistency rules for the release do not match
	 */
	public Release(final Model model, final String version, final Date releaseDate, final Project project)
			throws ModelException {
		super(model);
		this.version = version;
		this.currentReleaseDate = CalendarUtils.copy(releaseDate);
		this.sprints = new ArrayList<Sprint>();
		this.checkConsistency(project);
		project.isReleaseDoubleDefined(version, releaseDate); // can throw
		project.addRelease(this);
		this.addObserver(project);
		this.putToObjectStore();
	}

	/**
	 * Checks the consistencies for the release.
	 * 
	 * @param project
	 *            the project containing the release
	 * @throws ModelException
	 *             if the consistency rules for the release are corrupted
	 * 
	 */
	private void checkConsistency(final Project project) throws ModelException {
		if (this.version == null || this.version.trim().isEmpty()) {
			throw new NoValidValueException("Die Version des Release darf nicht leer sein!");
		}
		if (this.currentReleaseDate == null) {
			throw new NoValidValueException("Das Releasedatum darf nicht leer sein!");
		}
		project.isReleaseDoubleDefined(this.getVersion(), this.getReleaseDate());
	}

	/**
	 * getter of the version of the release.
	 * 
	 * @return the current version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * sets the version of the release.
	 * 
	 * @param version
	 *            is the new version to set
	 * @throws DoubleDefinitionException
	 *             if a release with the same version already exists
	 */
	public void setVersion(final String version) throws DoubleDefinitionException {
		this.getProject().isReleaseDoubleDefined(version, this.getReleaseDate());
		this.version = version;
		this.notifyObservers();
		this.changed();
	}

	/**
	 * getter of the releaseDate of the release.
	 * 
	 * @return the current releaseDate
	 */
	public Date getReleaseDate() {
		return CalendarUtils.copy(this.currentReleaseDate);
	}

	/**
	 * sets the releaseDate of the release.
	 * 
	 * @param releaseDate
	 *            the new releaseDate to set
	 * @throws DoubleDefinitionException
	 *             if a release with the same releaseDate already exists
	 */
	public void setReleaseDate(final Date releaseDate) throws DoubleDefinitionException {
		this.getProject().isReleaseDoubleDefined(this.getVersion(), releaseDate);
		this.currentReleaseDate = CalendarUtils.copy(releaseDate);
		this.notifyObservers();
		this.changed();
	}

	/**
	 * getter of all sprints of the release.
	 * 
	 * @return all current sprints related to the release
	 */
	public List<Sprint> getSprints() {
		return this.sprints;
	}

	/**
	 * adds a sprint to the release.
	 * 
	 * @param sprint
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addSprint(final Sprint sprint) throws IPScrumGeneralException {
		this.getProject().isSprintDefined(sprint);
		this.getSprints().add(sprint);
		sprint.addObserver(this);
		this.changed();
	}

	/**
	 * removes all sprints from the release.
	 */
	public void removeAllSprints() {
		final Iterator<Sprint> i = this.getSprints().iterator();
		while (i.hasNext()) {
			i.next().deleteObserver(this);
		}
		this.sprints.clear();
		this.changed();
	}

	/**
	 * removes a sprint from the release.
	 * 
	 * @param sprint
	 *            to remove
	 */
	public void removeSprint(final Sprint sprint) {
		this.getSprints().remove(sprint);
		sprint.deleteObserver(this);
		this.changed();
	}

	/**
	 * getter of the project related to the release.
	 * 
	 * @return the related project
	 */
	public Project getProject() {
		return this.getModel().getProjectByRelease(this);
	}

	/**
	 * counts how many sprints are related to the release.
	 * 
	 * @return the number counted
	 */
	public Integer countSprints() {
		return this.getSprints().size();
	}

	@Override
	public String toString() {
		return "Release [releaseDate=" + this.currentReleaseDate + ", version=" + this.version + "]";
	}

	/**
	 * calculates the overall effort of all PBIs related to the release by it's sprints.
	 * 
	 * @return the calculated number
	 */
	public int getOverallEfforts() {
		int overallEfforts = 0;

		for (final Sprint sprint : this.getSprints()) {
			for (final ProductBacklogItem pbi : sprint.getPBIs()) {
				overallEfforts += pbi.getManDayCosts().getValue();
			}
		}
		return overallEfforts;
	}

	/**
	 * needed to use a visitor.
	 * 
	 * @param treeVisitor
	 *            is the concrete visitor to use
	 */
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleRelease(this);
	}

	/**
	 * checks the deadline of the release.
	 */
	@SuppressWarnings("deprecation")
	public void checkDeadline() {
		final Date today = new Date();
		if (today.getDay() == this.currentReleaseDate.getDay()
				&& today.getMonth() == this.currentReleaseDate.getMonth()
				&& today.getYear() == this.currentReleaseDate.getYear() || today.after(this.currentReleaseDate)) {
			final ReleaseCompletionMessage message = new ReleaseCompletionMessage(this);
			this.notifyObservers(message);
		}

	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}

}
