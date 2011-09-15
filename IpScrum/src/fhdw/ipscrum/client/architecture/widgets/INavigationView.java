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

	EventRegistration addLogoutHandler(final EventHandler<EventArgs> handler);

	void setUserName(final String name);

	void setActiveRole(final String role);

	EventRegistration addRefreshHandler(final EventHandler<EventArgs> handler);

	void updateRevisionLabel(final Date revDate);

	void setMenu(NavigationMenu menu);

}
