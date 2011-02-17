package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Sprint;

/**
 * Interface for Sprints in Scrum. A sprint contains productbacklogitems and has
 * a fixed time frame. The name is used to identify a sprint.
 */
public interface ISprint extends BDACompare, Serializable {
	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	public String getDescription();

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 */
	public void setDescription(String description);

	/**
	 * Method getName.
	 * 
	 * @return String
	 */
	public String getName();

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
	 * Method getBegin.
	 * 
	 * @return Date
	 */
	public Date getBegin();

	/**
	 * Method getEnd.
	 * 
	 * @return Date
	 */
	public Date getEnd();

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
	 * Method getTeam.
	 * 
	 * @return ITeam
	 */
	public ITeam getTeam();

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
	 * Method getRelease.
	 * 
	 * @return IRelease
	 */
	public IRelease getRelease();

	/**
	 * Method getPBIs.
	 * 
	 * @return Vector<ProductBacklogItem>
	 */
	public Vector<ProductBacklogItem> getPBIs();

	/**
	 * Method getToReleaseAssoc.
	 * 
	 * @return ToReleaseAssoc
	 */
	public ToReleaseAssoc getToReleaseAssoc();

	/**
	 * Method getToPBIAssoc.
	 * 
	 * @return ToPBIAssoc
	 */
	public ToPBIAssoc getToPBIAssoc();

	/**
	 */
	class ToReleaseAssoc extends ManyToOne<IRelease.ToSprintAssoc, Sprint> {
		/**
		 * Constructor for ToReleaseAssoc.
		 * 
		 * @param element
		 *            Sprint
		 */
		public ToReleaseAssoc(final Sprint element) {
			super(element);
		}
	}

	/**
	 */
	class ToPBIAssoc extends
			OneToMany<ProductBacklogItem.ToSprintAssoc, Sprint> {
		/**
		 * Constructor for ToPBIAssoc.
		 * 
		 * @param element
		 *            Sprint
		 */
		public ToPBIAssoc(final Sprint element) {
			super(element);
		}
	}
}
