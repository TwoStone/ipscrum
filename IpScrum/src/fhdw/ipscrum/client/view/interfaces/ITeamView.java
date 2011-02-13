package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


/**
 * interface of the view class for the team interface. this composes the team management gui.
 * this view is used to inspect, create and modify teams as well as adding and removing persons to teams.
 */
public interface ITeamView extends IView {

	/**
	 * @return the currently selected Person of the team display (widget:tree)
	 */
	public abstract IPerson getSelectedPersonOfTree();

	/**
	 * @return the currently selected team. if a person is selected, this will return the team, the person is in.
	 */
	public abstract ITeam getSelectedTeamOfTree();

	/**
	 * This method is used to update or fill the entries of the team display.
	 * @param teamSet a set of teams to be displayed.
	 */
	public abstract void updateTeamTreeData(HashSet<ITeam> teamSet);

	/**
	 * This method is used to update or fill the entries of the person display.
	 * @param personSet a set of persons to be displayed.
	 */
	public abstract void updatePersonTableData(HashSet<IPerson> personSet);

	/**
	 * use this method to define the action of the create-team-button.
	 * @param args empty arguments
	 */
	public abstract void defineNewTeamEvent(EventHandler<EventArgs> args);

	/**
	 * use this method to define the action of the modify-team-button.
	 * @param args empty arguments
	 */
	public abstract void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args);

	/**
	 * use this method to define the action of the remove-person-from-team-button.
	 * @param args empty arguments
	 */
	public abstract void defineRemovePersonFromTeamEvent(
			EventHandler<PersonTeamArgs> args);

	/**
	 * use this method to define the action of the add-person-to-team-button.
	 * @param args empty arguments
	 */
	public abstract void defineAddPersonToTeamEvent(
			EventHandler<PersonTeamArgs> args);

}