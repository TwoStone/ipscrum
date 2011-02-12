package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;

/**
 */
public interface ITeamDialogView extends IView {

	/**
	 * Method getTeamDescription.
	 * @return TextBox
	 */
	public abstract TextBox getTeamDescription();

	/**
	 * Method addOkEventHandler.
	 * @param args EventHandler<OneStringArgs>
	 */
	public abstract void addOkEventHandler(EventHandler<OneStringArgs> args);

	/**
	 * Method addCancelEventHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}