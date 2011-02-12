package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


/**
 */
public interface ITeamView extends IView {

	/**
	 * Method getSelectedPersonOfTree.
	 * @return IPerson
	 */
	public abstract IPerson getSelectedPersonOfTree();

	/**
	 * Method getSelectedTeamOfTree.
	 * @return ITeam
	 */
	public abstract ITeam getSelectedTeamOfTree();

	/**
	 * Method updateTeamTreeData.
	 * @param teamSet HashSet<ITeam>
	 */
	public abstract void updateTeamTreeData(HashSet<ITeam> teamSet);

	/**
	 * Method updatePersonTableData.
	 * @param personSet HashSet<IPerson>
	 */
	public abstract void updatePersonTableData(HashSet<IPerson> personSet);

	/**
	 * Method defineNewTeamEvent.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void defineNewTeamEvent(EventHandler<EventArgs> args);

	/**
	 * Method defineModifyTeamEvent.
	 * @param args EventHandler<PersonTeamArgs>
	 */
	public abstract void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args);

	/**
	 * Method defineRemovePersonFromTeamEvent.
	 * @param args EventHandler<PersonTeamArgs>
	 */
	public abstract void defineRemovePersonFromTeamEvent(
			EventHandler<PersonTeamArgs> args);

	/**
	 * Method defineAddPersonToTeamEvent.
	 * @param args EventHandler<PersonTeamArgs>
	 */
	public abstract void defineAddPersonToTeamEvent(
			EventHandler<PersonTeamArgs> args);

}