package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;


/**
 */
public interface IRoleDialogView extends IView{

	/**
	 * Method getRole.
	 * @return HasText
	 */
	public abstract HasText getRole();

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