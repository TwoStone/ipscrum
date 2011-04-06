package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.SprintBacklog;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;
import fhdw.ipscrum.shared.observer.IObservable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Interface for Sprints in Scrum. A sprint contains productbacklogitems and has
 * a fixed time frame. The name is used to identify a sprint.
 */
public interface ISprint extends BDACompare, Serializable,
		ITreeVisitorRelevantElement, PersistentObserver, IObservable {
	/**
	 * Method getBegin.
	 * 
	 * @return Date
	 */
	public Date getBegin();

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	public String getDescription();

	/**
	 * Method getEnd.
	 * 
	 * @return Date
	 */
	public Date getEnd();

	/**
	 * Method getName.
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * Method getPBIs.
	 * 
	 * @return Vector<ProductBacklogItem>
	 */
	public Vector<ProductBacklogItem> getPBIs();

	/**
	 * Method getRelease.
	 * 
	 * @return IRelease
	 */
	public IRelease getRelease();

	/**
	 * Method getSprintBacklog.
	 * 
	 * @return SprintBacklog
	 */
	public SprintBacklog getSprintBacklog();

	/**
	 * Method getTeam.
	 * 
	 * @return ITeam
	 */
	public ITeam getTeam();

	/**
	 * Method getToPBIAssoc.
	 * 
	 * @return ToPBIAssoc
	 */
	public OneToMany<ManyToOne<?, ?>, ISprint> getToPBIAssoc();

	/**
	 * Method getToReleaseAssoc.
	 * 
	 * @return ToReleaseAssoc
	 */
	public ManyToOne<OneToMany<?, ?>, ISprint> getToReleaseAssoc();

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 */
	public void setDescription(String description);

	/**
	 * Method setName.
	 * 
	 * @param description
	 *            String
	 * @throws NoValidValueException
	 *             thrown, if name is empty or longer than 20.
	 */
	public void setName(String description) throws NoValidValueException;

	/**
	 * Method setTeam.
	 * 
	 * @param team
	 *            ITeam
	 * @throws NoValidValueException
	 *             thrown, if team is null.
	 */
	public void setTeam(ITeam team) throws NoValidValueException;

	/**
	 * Method setTimeFrame.
	 * 
	 * @param begin
	 *            Date
	 * @param end
	 *            Date
	 * @throws NoValidValueException
	 *             thrown, if begin is null or end is null or begin > end.
	 */
	public void setTimeFrame(Date begin, Date end) throws NoValidValueException;

	/**
	 * Method getCumulatedManDayCosts
	 * 
	 * @return cumulated Efforts
	 * @throws NoValidValueException
	 */
	public abstract Effort getCumulatedManDayCosts()
			throws NoValidValueException;

	/**
	 * Method getCumulatedManDayCostsOfClosedPbis
	 * 
	 * @return cumulated Efforts of Closed PBIs
	 * @throws NoValidValueException
	 */
	public abstract Effort getCumulatedManDayCostsOfClosedPbis()
			throws NoValidValueException;

	/**
	 * Method getCumulatedManDayCostsOfClosedFeatures
	 * 
	 * @return cumulated Efforts of Closed Features
	 * @throws NoValidValueException
	 */
	public abstract Effort getCumulatedManDayCostsOfClosedFeatures()
			throws NoValidValueException;

	/**
	 * @param item
	 *            PBI to check
	 * @return true, if the item is associated with the sprint
	 */
	public boolean hasPBI(ProductBacklogItem item);

	/**
	 * if the end date of the sprint has been reached, the sprint will make a
	 * notification
	 */
	public void checkDeadline();

}
