package fhdw.ipscrum.client.eventargs;

import java.util.Date;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * represents an event argument which knows the details of a sprint.
 */
public class SprintDetailArgs extends EventArgs {

	/**
	 * represents the name of the known sprint.
	 */
	private final String name;
	/**
	 * represents the begin date of the known sprint.
	 */
	private final Date beginDate;
	/**
	 * represents the end date of the known sprint.
	 */
	private final Date endDate;
	/**
	 * represents the team of the known sprint.
	 */
	private final Team team;
	/**
	 * represents the description of the known sprint.
	 */
	private final String description;

	/**
	 * constructor of the SprintDetailArgs.
	 * 
	 * @param name
	 *            of the sprint
	 * @param beginDate
	 *            of the sprint
	 * @param endDate
	 *            of the sprint
	 * @param team
	 *            of the sprint
	 * @param description
	 *            of the sprint
	 */
	public SprintDetailArgs(final String name, final Date beginDate,
			final Date endDate, final Team team, final String description) {
		super();
		this.name = name;
		this.beginDate = CalendarUtils.copy(beginDate);
		this.endDate = CalendarUtils.copy(endDate);
		this.team = team;
		this.description = description;
	}

	/**
	 * getter of the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter of the begin date.
	 * 
	 * @return the begin date
	 */
	public Date getBeginDate() {
		return CalendarUtils.copy(this.beginDate);
	}

	/**
	 * getter of the end date.
	 * 
	 * @return the end date
	 */
	public Date getEndDate() {
		return CalendarUtils.copy(this.endDate);
	}

	/**
	 * getter of the team.
	 * 
	 * @return the team
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * getter of the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

}
