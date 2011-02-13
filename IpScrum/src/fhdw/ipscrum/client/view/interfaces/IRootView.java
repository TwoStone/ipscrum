package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface IRootView extends IView{

	/**
	 * Fills the UserCombobox with all entries of the <code>tempUserList</code>
	 * @param tempUserList a list of available users
	 */
	public abstract void fillComboBoxUsers(ArrayList<IPerson> tempUserList);

	/**
	 * This enables the login elements of the login-form.
	 */
	public abstract void activateLogin();

	/**
	 * This disables the login elements of the login-form.
	 */
	public abstract void deactivateLogin();

	/**
	 * Returns the main content panel.
	 * @return content panel
	 */
	public abstract VerticalPanel getContentPanel();

	/**
	 * This is used to define the behaviour of the login-action externally. (MVP)
	 * @param args IPerson to sign on
	 */
	public void defineLoginEvent(EventHandler<PersonArgs> args);

	/**
	 * This is used to define the behaviour of the logout-action externally. (MVP)
	 * @param args empty arguments
	 */
	public void defineLogoutEvent(EventHandler<EventArgs> args);

}