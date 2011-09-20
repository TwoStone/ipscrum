package fhdw.ipscrum.client.architecture.widgets;

import java.util.Date;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.view.IView;

/**
 * represents the interface of the NavigationView.
 */
public interface INavigationView extends IView {

	/**
	 * Represents the handler which is needed to handle the log out.
	 * 
	 * @param handler
	 *            needed to handle the logout
	 * @return the event needed for handling
	 */
	EventRegistration addLogoutHandler(final EventHandler<EventArgs> handler);

	/**
	 * sets the name of the user.
	 * 
	 * @param name
	 *            is the name to set
	 */
	void setUserName(final String name);

	/**
	 * sets the active rule of the user to log in.
	 * 
	 * @param role
	 *            to set as the active role
	 */
	void setActiveRole(final String role);

	/**
	 * Represents the event which handles the refresh of the event handler.
	 * 
	 * @param handler
	 *            to refresh
	 * @return the event to handle the refresh
	 */
	EventRegistration addRefreshHandler(final EventHandler<EventArgs> handler);

	/**
	 * updates the revision date.
	 * 
	 * @param revDate
	 *            is the date of the revision which the user is in.
	 */
	void updateRevisionLabel(final Date revDate);

	/**
	 * sets the navigation menu.
	 * 
	 * @param menu
	 *            to set as the navigation
	 */
	void setMenu(NavigationMenu menu);

}
