package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;


/**
 * This view is used as a dialogbox to create or modify roles.
 */
public interface IRoleDialogView extends IView{


	/**
	 * This is used to preset the value of the role-field.
	 * @param role rolename
	 */
	public abstract void setRole(String role);

	/**
	 * Use this to define the EventHandler for the OK-Button.
	 * @param args EventHandler<OneStringArgs> one String-argument
	 */
	public abstract void addOkEventHandler(EventHandler<OneStringArgs> args);

	/**
	 * Use this to define the EventHandler for the Cancel-Button.
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}