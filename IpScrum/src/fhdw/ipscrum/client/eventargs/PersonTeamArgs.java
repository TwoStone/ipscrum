package fhdw.ipscrum.client.eventargs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * container for person and team arguments.
 */
public class PersonTeamArgs extends EventArgs {

	/**
	 * represents the persons attached to the event argument.
	 */
	private Collection<Person> persons = null;
	/**
	 * represents the team attached to the event argument.
	 */
	private final Team team;

	/**
	 * constructor of the PersonTeamArgs with only one person.
	 * 
	 * @param person
	 *            related to the argument
	 * @param team
	 *            related to the argument
	 */
	public PersonTeamArgs(final Person person, final Team team) {
		this(PersonTeamArgs.createSinglePersonSet(person), team);
	}

	/**
	 * constructor of the PersonTeamArgs with many persons.
	 * 
	 * @param persons
	 *            related to the argument
	 * @param team
	 *            related to the argument
	 */
	public PersonTeamArgs(final Collection<Person> persons, final Team team) {
		super();
		this.persons = persons;
		this.team = team;
	}

	/**
	 * constructor of the PersonTeamArgs with only a team.
	 * 
	 * @param selectedTeamOfTree
	 *            related team
	 */
	public PersonTeamArgs(final Team selectedTeamOfTree) {
		super();
		this.team = selectedTeamOfTree;
	}

	/**
	 * getter of the persons.
	 * 
	 * @return the persons
	 */
	public Collection<Person> getPersons() {
		return this.persons;
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
	 * creates a list of persons.
	 * 
	 * @param person
	 *            to add to the list
	 * @return list of persons
	 */
	private static List<Person> createSinglePersonSet(final Person person) {
		final List<Person> singlePersonSet = new ArrayList<Person>();
		singlePersonSet.add(person);
		return singlePersonSet;
	}
}
