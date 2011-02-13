package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;

/**
 * This view is used as a dialog to create or modify teams.
 */
public interface ITeamDialogView extends IView {


	/**
	 * This method is called to preset the team description field of the dialog.
	 * @param description
	 */
	public abstract void setTeamDescription(String description);

	/**
	 * use this to define what happens when the user pushes the ok-button.
	 * @param args EventHandler<OneStringArgs> one string argument
	 */
	public abstract void addOkEventHandler(EventHandler<OneStringArgs> args);

	/**
	 * use this to define what happens when the user pushes the cancel-button of the dialogbox.
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}