package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.TwoStringArgs;

/**
 */
public interface IPersonDialogView extends IView {

	/**
	 * Method getVorname.
	 * @return HasText
	 */
	public abstract HasText getVorname();

	/**
	 * Method getNachname.
	 * @return HasText
	 */
	public abstract HasText getNachname();

	/**
	 * Method defineCommitEventHandler.
	 * @param args EventHandler<TwoStringArgs>
	 */
	public abstract void defineCommitEventHandler(EventHandler<TwoStringArgs> args);

	/**
	 * Method defineCancelEventHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void defineCancelEventHandler(EventHandler<EventArgs> args);

}