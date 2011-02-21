package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * Class Sprint.
 */
public class Sprint implements ISprint {
	private String name;
	private String description;
	private Date begin;
	private Date end;
	private ITeam team;
	private SprintChartData chartData;

	private ManyToOne<OneToMany, ISprint> toReleaseAssoc;
	private OneToMany<ManyToOne, ISprint> toPBIAssoc;

	@SuppressWarnings("unused")
	private Sprint() {
	}

	/**
	 * Constructor for Sprint.
	 * 
	 * @param name
	 *            String
	 * @param description
	 *            String
	 * @param begin
	 *            Date
	 * @param end
	 *            Date
	 * @param team
	 *            ITeam
	 * @throws NoValidValueException
	 */
	public Sprint(final String name, final String description,
			final Date begin, final Date end, final ITeam team)
	throws NoValidValueException {
		super();
		this.setName(name);
		this.setDescription(description);
		this.setTimeFrame(begin, end);
		this.setTeam(team);
		this.chartData = new SprintChartData();
		this.toReleaseAssoc = new ManyToOne<OneToMany, ISprint>(this);
		this.toPBIAssoc = new OneToMany<ManyToOne, ISprint>(this);
	}

	/**
	 * Method getToReleaseAssoc.
	 * 
	 * @return ToReleaseAssoc
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getToReleaseAssoc()
	 */
	@Override
	public ManyToOne<OneToMany, ISprint> getToReleaseAssoc() {
		return this.toReleaseAssoc;
	}

	/**
	 * Method getToPBIAssoc.
	 * 
	 * @return ToPBIAssoc
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getToPBIAssoc()
	 */
	@Override
	public OneToMany<ManyToOne, ISprint> getToPBIAssoc() {
		return this.toPBIAssoc;
	}

	/**
	 * Method setName.
	 * 
	 * @param name
	 *            String
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#setName(String)
	 */
	@Override
	public void setName(final String name) throws NoValidValueException {
		if (name == null || name.length() == 0 || name.length() > 20) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.SPRINT_NAME_ERROR);
		} else {
			this.name = name;
		}
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#setDescription(String)
	 */
	@Override
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method getChartData.
	 * @return SprintChartData
	 */
	@Override
	public SprintChartData getChartData() {
		return this.chartData;
	}

	/**
	 * Method getBegin.
	 * 
	 * @return Date
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getBegin()
	 */
	@Override
	public Date getBegin() {
		return this.begin;
	}

	/**
	 * Method setTimeFrame.
	 * 
	 * @param begin
	 *            Date
	 * @param end
	 *            Date
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#setTimeFrame(Date,
	 *      Date)
	 */
	@Override
	public void setTimeFrame(final Date begin, final Date end)
	throws NoValidValueException {
		if (begin == null || end == null) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.NO_VALID_DATE_ERROR);
		} else if (end.before(begin)) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		} else {
			this.begin = begin;
			this.end = end;
		}
	}

	/**
	 * Method getEnd.
	 * 
	 * @return Date
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getEnd()
	 */
	@Override
	public Date getEnd() {
		return this.end;
	}

	/**
	 * Method getTeam.
	 * 
	 * @return ITeam
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getTeam()
	 */
	@Override
	public ITeam getTeam() {
		return this.team;
	}

	/**
	 * Method setTeam.
	 * 
	 * @param team
	 *            ITeam
	 * @throws NoValidValueException
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#setTeam(ITeam)
	 */
	@Override
	public void setTeam(final ITeam team) throws NoValidValueException {
		if (team == null) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.NO_TEAM_SELECTED_ERROR);
		} else {
			this.team = team;
		}
	}

	/**
	 * Method getRelease.
	 * 
	 * @return IRelease
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getRelease()
	 */
	@Override
	public IRelease getRelease() {
		return (IRelease) this.getToReleaseAssoc().get();
	}

	/**
	 * Method getPBIs.
	 * 
	 * @return Vector<ProductBacklogItem>
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getPBIs()
	 */
	@Override
	public Vector<ProductBacklogItem> getPBIs() {
		final Vector<ProductBacklogItem> ret = new Vector<ProductBacklogItem>();
		for (final BDACompare pbiAssocs : this.toPBIAssoc.getAssociations()) {
			ret.add((ProductBacklogItem) pbiAssocs);
		}
		return ret;
	}

	/**
	 * Method getName.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.model.interfaces.ISprint#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * Method indirectHashCode.
	 * 
	 * @return int
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectHashCode()
	 */
	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return this.indirectHashCode();
	}

	/**
	 * Method indirectEquals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectEquals(Object)
	 */
	@Override
	public boolean indirectEquals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Sprint other = (Sprint) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object obj) {
		return this.indirectEquals(obj);
	}
}
