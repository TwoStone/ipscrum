package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.PersonTeamArgs;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.TeamView).
 */
public interface ITeamView extends IView {

	/**
	 * getter of the selected person in the list of persons.
	 * 
	 * @return the currently selected person
	 */
	Person getSelectedPersonOfTree();

	/**
	 * getter of the selected team in the list of teams.
	 * 
	 * @return the currently selected team
	 */
	Team getSelectedTeamOfTree();

	/**
	 * Represents the Event to handle the definition of a new team.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewTeamEvent(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the modification of a team.
	 * 
	 * @param args
	 *            needed to handle the event, which also knows the team and persons
	 */
	void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args);

	/**
	 * Represents the Event to handle the addition of projects.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the team
	 */
	void defineAddProjectsEvent(EventHandler<TypedEventArg<Team>> handler);

	/**
	 * Represents the Event to handle the move to the velocity chart.
	 * 
	 * @param handler
	 *            needed to handle the event which also knows the team
	 */
	void defineVelocityChartEvent(EventHandler<TypedEventArg<Team>> handler);

	/**
	 * Represents the Event to handle the addition of persons to a team.
	 * 
	 * @param args
	 *            needed to handle the event which also know the persons and the team
	 */
	void defineAddPersonToTeamEvent(EventHandler<PersonTeamArgs> args);

	/**
	 * Represents the Event to handle the remove of persons from a team.
	 * 
	 * @param args
	 *            needed to handle the event which also know the persons and the team
	 */
	void defineRemovePersonFromTeamEvent(EventHandler<PersonTeamArgs> args);

	/**
	 * displays the list of teams.
	 * 
	 * @param teamSet
	 *            are all existing teams
	 */
	void updateTeamTreeData(List<Team> teamSet);

	/**
	 * displays the list of persons.
	 * 
	 * @param personSet
	 *            are all existing persons
	 */
	void updatePersonTableData(List<Person> personSet);

}
