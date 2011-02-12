package fhdw.ipscrum.client.events.args;

import java.util.HashSet;
import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 */
public class PersonTeamArgs extends EventArgs {

	private Set<IPerson> persons = null;
	private final ITeam team;

	/**
	 * Constructor for PersonTeamArgs.
	 * @param person IPerson
	 * @param team ITeam
	 */
	public PersonTeamArgs(IPerson person, ITeam team) {
		this(createSinglePersonSet(person), team);
	}

	/**
	 * Constructor for PersonTeamArgs.
	 * @param persons Set<IPerson>
	 * @param team ITeam
	 */
	public PersonTeamArgs(Set<IPerson> persons, ITeam team) {
		super();
		this.persons = persons;
		this.team = team;
	}

	/**
	 * Constructor for PersonTeamArgs.
	 * @param selectedTeamOfTree ITeam
	 */
	public PersonTeamArgs(ITeam selectedTeamOfTree) {
		super();
		this.team = selectedTeamOfTree;
	}


	/**
	 * Method getPersons.
	 * @return Set<IPerson>
	 */
	public Set<IPerson> getPersons() {
		return this.persons;
	}

	/**
	 * Method getTeam.
	 * @return ITeam
	 */
	public ITeam getTeam() {
		return this.team;
	}

	/**
	 * Method createSinglePersonSet.
	 * @param person IPerson
	 * @return Set<IPerson>
	 */
	private static Set<IPerson> createSinglePersonSet(IPerson person) {
		HashSet<IPerson> singlePersonSet = new HashSet<IPerson>();
		singlePersonSet.add(person);
		return singlePersonSet;
	}
}
