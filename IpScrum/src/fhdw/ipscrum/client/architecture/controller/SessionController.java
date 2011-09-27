package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateEvent;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateHandler;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Event;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.SingleObjectEvent;
import fhdw.ipscrum.client.architecture.widgets.ILoginView;
import fhdw.ipscrum.client.architecture.widgets.ILoginView.LoggedInEventArgs;
import fhdw.ipscrum.client.eventargs.UserRoleArgs;
import fhdw.ipscrum.client.services.LoginService;
import fhdw.ipscrum.client.services.LoginService.ResumedSession;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * Controls the session on the client.
 */
public class SessionController {

	/**
	 * The token where the user is stored in the browser cookie.
	 */
	private static final String CURRENT_USER = "currentUser";

	/**
	 * The token where the role id is stored in the browser cookie.
	 */
	private static final String CURRENT_ROLE = "currentRole";

	/**
	 * Occurs when a user has logged in.
	 */
	public static class LoginEvent extends SingleObjectEvent<UserRoleArgs> {

		/**
		 * Creates a new login event.
		 * 
		 * @param user
		 *            the user that has logged in
		 * 
		 * @param role
		 *            the active role of the user
		 */
		public LoginEvent(final User user, final Role role) {
			super(new UserRoleArgs(user, role));
		}
	}

	/**
	 * Base class for handler that handle login events.
	 */
	public abstract static class LoginEventHandler implements Handler<SessionController.LoginEvent> {
		@Override
		public void handle(final LoginEvent event) {
			this.handleLogin(event);
		}

		/**
		 * Handles the login.
		 * 
		 * @param event
		 *            login event
		 */
		public abstract void handleLogin(LoginEvent event);
	}

	/**
	 * Occurs when a user has logged out.
	 */
	public static class LogoutEvent extends Event {
	}

	/**
	 * Base class for handler that handle logout events.
	 */
	public abstract static class LogoutEventHandler implements Handler<SessionController.LogoutEvent> {
		@Override
		public void handle(final LogoutEvent event) {
			this.handleLogout(event);
		}

		/**
		 * Handles the logout.
		 * 
		 * @param event
		 *            logout event
		 */
		public abstract void handleLogout(LogoutEvent event);
	}

	/**
	 * The login mask.
	 */
	private ILoginView loginWidget;

	/**
	 * The currently logged in user, when no one is logged in this will be null.
	 */
	private User currentUser;

	/**
	 * represents the chosen active role of the current user.
	 */
	private Role activeRole;

	/**
	 * The factory for views.
	 */
	private final ViewFactory factory;

	/**
	 * The event bus.
	 */
	private final EventBus eventBus;

	/**
	 * Handles updates of the model and refresh the reference of the current user to his person.
	 */
	private final ModelUpdateHandler modelUpdateHandler = new ModelUpdateHandler() {

		@Override
		public void handleModelUpdated(final ModelUpdateEvent event) {
			if (SessionController.this.currentUser != null) {
				final Model model = event.getObject();
				try {
					SessionController.this.currentUser.updatePerson(model.getObject(SessionController.this.currentUser
							.getPerson()));
				} catch (final NoObjectFindException e) {
					SessionController.this.logout();
				}
			}
		}
	};

	/**
	 * Creates a new SessionController.
	 * 
	 * @param factory
	 *            the view factory
	 * @param eventBus
	 *            the event bus
	 */
	public SessionController(final ViewFactory factory, final EventBus eventBus) {
		this.factory = factory;
		this.eventBus = eventBus;

		this.eventBus.registerHandler(ModelUpdateEvent.class, this.modelUpdateHandler);
	}

	/**
	 * Returns the login mask.
	 * 
	 * @return the login mask
	 */
	private ILoginView getLoginWidget() {
		if (this.loginWidget == null) {
			this.loginWidget = this.factory.createLoginView();
			this.loginWidget.registerLoginHandler(new EventHandler<LoggedInEventArgs>() {

				@Override
				public void onUpdate(final Object sender, final LoggedInEventArgs eventArgs) {
					SessionController.this.loginWidget.hidePopup();

					SessionController.this.doLogin(eventArgs.getUser(), eventArgs.getRole());
					try {
						SessionController.this.setActiveRole(eventArgs.getRole());
					} catch (final ConsistencyException e) {
						SessionController.this.logout();
					}
				}

			});

			this.loginWidget.registerHelpHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					// TODO: Show Help
				}
			});
		}

		return this.loginWidget;
	}

	/**
	 * Starts the login procedure for the client.
	 */
	public void login() {
		final String currentUsername = Cookies.getCookie(SessionController.CURRENT_USER);
		final String currentRoleId = Cookies.getCookie(SessionController.CURRENT_ROLE);
		LoginService.Util.getInstance().tryResumeSession(currentUsername, currentRoleId,
				new AsyncCallback<ResumedSession>() {

					@Override
					public void onSuccess(final ResumedSession result) {
						SessionController.this.doLogin(result.getUser(), result.getRole());
					}

					@Override
					public void onFailure(final Throwable caught) {
						SessionController.this.getLoginWidget().showPopup();
					}
				});
	}

	/**
	 * Logout the client.
	 */
	public void logout() {
		LoginService.Util.getInstance().logout(new AsyncCallback<Void>() {

			@Override
			public void onSuccess(final Void result) {

				// SessionController.this.context.getHeartBeatController()
				// .stopPulsing();
				SessionController.this.currentUser = null;
				SessionController.this.loginWidget = null;
				SessionController.this.eventBus.publish(new LogoutEvent());
				// SessionController.this.login();
			}

			@Override
			public void onFailure(final Throwable caught) {

			}
		});
	}

	/**
	 * Sets the current user and fires the login event.
	 * 
	 * @param user
	 *            the logged in user
	 * 
	 * @param role
	 *            the active role of the user
	 */
	private void doLogin(final User user, final Role role) {
		this.currentUser = user;
		Cookies.setCookie(SessionController.CURRENT_USER, user.getName());
		Cookies.setCookie(SessionController.CURRENT_ROLE, role.getId());
		try {
			this.setActiveRole(role);
		} catch (final ConsistencyException e) {
			Cookies.removeCookie(SessionController.CURRENT_USER);
			Cookies.removeCookie(SessionController.CURRENT_ROLE);
			this.login();
		}

		this.eventBus.publish(new LoginEvent(user, role));

	}

	/**
	 * Returns the current user. if no user is logged in this will be null.
	 * 
	 * @return the current user or null
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * Assigns the active role of the current user. Pre-condition: A current User is assigned (logged in).
	 * 
	 * @param activeRole
	 *            active role.
	 * @throws ConsistencyException
	 *             if the active role is not assigned to the current user.
	 */
	public void setActiveRole(final Role activeRole) throws ConsistencyException {
		if (this.currentUser.getPerson().getRoles().contains(activeRole)) {
			this.activeRole = activeRole;
		} else {
			throw new ConsistencyException(ExceptionConstants.NO_SUCH_ROLE_ERROR);
		}
	}

	/**
	 * Returns the active role of the current user. Pre-condition: A current User is assigned (logged in).
	 * 
	 * @return the active role.
	 */
	public Role getActiveRole() {
		return this.activeRole;
	}
}
