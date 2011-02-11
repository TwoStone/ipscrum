package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


public interface ITeamView extends IView {

	public abstract IPerson getSelectedPersonOfTree();

	public abstract ITeam getSelectedTeamOfTree();

	public abstract void updateTeamTreeData(HashSet<ITeam> teamSet);

	public abstract void updatePersonTableData(HashSet<IPerson> personSet);

	public abstract void defineNewTeamEvent(EventHandler<EventArgs> args);

	public abstract void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args);

	public abstract void defineRemovePersonFromTeamEvent(
			EventHandler<PersonTeamArgs> args);

	public abstract void defineAddPersonToTeamEvent(
			EventHandler<PersonTeamArgs> args);

}