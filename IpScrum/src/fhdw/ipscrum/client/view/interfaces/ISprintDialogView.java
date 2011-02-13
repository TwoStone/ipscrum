package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;
import java.util.Date;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintDetailArgs;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 */
public interface ISprintDialogView extends IView{

	public abstract void setStart(Date startDate);
	public abstract void setEnd(Date endDate);
	public abstract void setDescription(String description);

	/**
	 * Method addOkHandler.
	 * @param args EventHandler<SprintArgs>
	 */
	public abstract void addOkHandler(EventHandler<SprintDetailArgs> args);

	/**
	 * Method addCancelHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void addCancelHandler(EventHandler<EventArgs> args);

	/**
	 * @param teamList
	 */
	public void fillComboBoxTeams(ArrayList<ITeam> teamList);


	public ITeam getSelectedTeam();

	public void setSelectedTeam(ITeam team);

}