package fhdw.ipscrum.client.viewinterfaces;

import java.util.Date;
import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * View interface for creating a new sprint.
 */
public interface ICreateSprintView extends IView {

	/**
	 * Returns the selected team.
	 * 
	 * @return selected team
	 */
	Team getSelectedTeam();

	/**
	 * Sets the selected team.
	 * 
	 * @param team
	 *            selected team
	 */
	void setSelectedTeam(Team team);

	/**
	 * Fills the combobox of possible teams.
	 * 
	 * @param list
	 *            possible teams
	 */
	void fillComboBoxTeams(List<Team> list);

	/**
	 * Registers the handler for the event that the current state should be saved.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 */
	void registerSave(DefaultEventHandler handler);

	/**
	 * Returns the selected start date.
	 * 
	 * @return start date
	 */
	Date getStart();

	/**
	 * Returns the selected end date.
	 * 
	 * @return end date
	 */
	Date getEnd();

	/**
	 * Returns the description for the sprint.
	 * 
	 * @return description
	 */
	String getDescription();

	/**
	 * Return the name for the sprint.
	 * 
	 * @return name
	 */
	String getName();

	/**
	 * Registers the handler for the event that the operation should be aborted.
	 * 
	 * @param handler
	 *            The handler that will be notified.
	 */
	void registetAbort(DefaultEventHandler handler);

}
