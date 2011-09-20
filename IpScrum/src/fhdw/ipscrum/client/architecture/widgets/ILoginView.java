package fhdw.ipscrum.client.architecture.widgets;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * represents the interface of the loginView.
 */
public interface ILoginView {

	/**
	 * represents the EventArgs needed for the login.
	 */
	public class LoggedInEventArgs extends EventArgs {
		private final User user;
		private final Role activeRole;

		/**
		 * constructor of the LoggedInEventArgs.
		 * 
		 * @param user
		 *            to log in
		 * @param activeRole
		 *            is the role with which the user is logged in
		 */
		public LoggedInEventArgs(final User user, final Role activeRole) {
			super();
			this.user = user;
			this.activeRole = activeRole;
		}

		/**
		 * gets the user to log in.
		 * 
		 * @return the current user
		 */
		public User getUser() {
			return this.user;
		}

		/**
		 * gets the active role of the user.
		 * 
		 * @return the current user
		 */
		public Role getRole() {
			return this.activeRole;
		}
	}

	/**
	 * event which handles the login.
	 * 
	 * @param handler
	 *            which handles the login and also knows all relevant data for the login
	 * @return the event fired for the login
	 */
	EventRegistration registerLoginHandler(
			final EventHandler<ILoginView.LoggedInEventArgs> handler);

	/**
	 * shows the popup for the login.
	 */
	void showPopup();

	/**
	 * hides the popoup for the login.
	 */
	void hidePopup();

}
