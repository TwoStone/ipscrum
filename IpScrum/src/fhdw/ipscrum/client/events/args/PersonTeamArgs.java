package fhdw.ipscrum.client.events.args;

import java.util.HashSet;
import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class PersonTeamArgs extends EventArgs {

	private Set<IPerson> persons = null;
	private final ITeam team;

	public PersonTeamArgs(IPerson person, ITeam team) {
		this(createSinglePersonSet(person), team);
	}

	public PersonTeamArgs(Set<IPerson> persons, ITeam team) {
		super();
		this.persons = persons;
		this.team = team;
	}

	public PersonTeamArgs(ITeam selectedTeamOfTree) {
		super();
		this.team = selectedTeamOfTree;
	}


	public Set<IPerson> getPersons() {
		return this.persons;
	}

	public ITeam getTeam() {
		return this.team;
	}

	private static Set<IPerson> createSinglePersonSet(IPerson person) {
		HashSet<IPerson> singlePersonSet = new HashSet<IPerson>();
		singlePersonSet.add(person);
		return singlePersonSet;
	}
}
