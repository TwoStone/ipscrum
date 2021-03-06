package fhdw.ipscrum.client.architecture.menu;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ApplicationController;

/**
 * represents the menu command.
 */
public abstract class MenuCommand {
	/**
	 * represents the client context in which the menu command is used.
	 */
	private ClientContext context;

	/**
	 * getter of the application controller.
	 * 
	 * @return the application controller
	 */
	public ApplicationController getApplicationController() {
		return this.context.getApplicationController();
	}

	/**
	 * sets the context of the menu command.
	 * 
	 * @param context
	 *            to set
	 */
	public void setContext(final ClientContext context) {
		this.context = context;
	}

	/**
	 * getter of the client context.
	 * 
	 * @return the current client context
	 */
	public ClientContext getContext() {
		return this.context;
	}

	/**
	 * method needed to execute the menu command.
	 */
	public abstract void execute();
}
