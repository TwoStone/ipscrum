package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;
import java.util.Date;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintDetailArgs;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * This view is used as a dialog box for specify the attributes of a sprint.
 */
public interface ISprintDialogView extends IView{

	/**
	 * This is intended to use for presetting the sprint-description.
	 * @param description sprint-description
	 */
	public abstract void setDescription(String description);

	/**
	 * Use this to define what happens if the user pushes the ok-button.
	 * @param args EventHandler<SprintDetailArgs> sprint-attributes
	 */
	public abstract void addOkHandler(EventHandler<SprintDetailArgs> args);

	/**
	 * Use this to define what happens if the user pushes the cancel-button.
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void addCancelHandler(EventHandler<EventArgs> args);

	/**
	 * This method is intended to initialize (or update) the contents of the team-chooser.
	 * @param teamList a list of teams
	 */
	public void fillComboBoxTeams(ArrayList<ITeam> teamList);


	/**
	 * This is used to determine the selected team of the teamchooser-combobox.
	 * @return the selected team (ITeam)
	 */
	public ITeam getSelectedTeam();

	/**
	 * This is intended to use for presetting the team selected in the team-chooser
	 * @param team the team to be selected
	 */
	public void setSelectedTeam(ITeam team);

	/**
	 * This is intended to use for presetting the startdate.
	 * @param startDate date of sprintbegin
	 */
	public void setStart(Date startDate);

	/**
	 * This is intended to use for presetting the enddate.
	 * @param endDate date of sprintend
	 */
	public void setEnd(Date endDate);

}