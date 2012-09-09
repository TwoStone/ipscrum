package fhdw.ipscrum.client.architecture.controller;

import java.util.Date;

import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateEvent;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateHandler;
import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEventHandler;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEventHandler;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.widgets.INavigationView;
import fhdw.ipscrum.shared.constants.HelpResources;

/**
 * Controls the navigation bar of the application.
 */
public class NavigationController extends ClientController {

	/**
	 * Handles login events.
	 */
	private final LoginEventHandler loginHandler = new LoginEventHandler() {

		@Override
		public void handleLogin(final LoginEvent event) {
			NavigationController.this.getNavigationPanel().clear();
			NavigationController.this.getNavigationPanel().add(NavigationController.this.getNavigationWidget());
			NavigationController.this.getNavigationWidget().setUserName(
					event.getObject().getUser().getPerson().getFirstname() + " "
							+ event.getObject().getUser().getPerson().getLastname());
			NavigationController.this.getNavigationWidget().setActiveRole(event.getObject().getRole().getDescription());
		}
	};

	/**
	 * Handles logout events.
	 */
	private final LogoutEventHandler logoutHandler = new LogoutEventHandler() {

		@Override
		public void handleLogout(final LogoutEvent event) {
			NavigationController.this.getNavigationPanel().clear();
		}
	};

	/**
	 * Handles model changes.
	 */
	private final Handler<ModelUpdateEvent> modelChangedHandler = new ModelUpdateHandler() {

		@Override
		public void handleModelUpdated(final ModelUpdateEvent event) {
			NavigationController.this.updateRevisionLabel(event.getObject().getRevisionDate());
		}

	};

	/**
	 * The navigation bar.
	 */
	private INavigationView navigationWidget;

	/**
	 * Creates a new navigation controller for the application. Creating more than one {@link NavigationController} will
	 * result in strange behaviors.
	 * 
	 * @param context
	 *            the current context of the application
	 * @param menu
	 *            the menu for the navigation
	 */
	public NavigationController(final ClientContext context, final NavigationMenu menu) {
		super(context);

		context.getEventBus().registerHandler(ModelUpdateEvent.class, this.modelChangedHandler);
		context.getEventBus().registerHandler(LoginEvent.class, this.loginHandler);
		context.getEventBus().registerHandler(LogoutEvent.class, this.logoutHandler);
		context.getEventBus().registerHandler(ModelUpdateEvent.class, this.modelChangedHandler);

		menu.setContext(context);
		this.getNavigationWidget().setMenu(menu);
	}

	/**
	 * Returns the navigation panel from the host HTML page.
	 * 
	 * @return the tag with the id: navigation
	 */
	public RootPanel getNavigationPanel() {
		return RootPanel.get("navigation");
	}

	/**
	 * Returns the widget that displays the navigation items.
	 * 
	 * @return the navigation bar
	 */
	private INavigationView getNavigationWidget() {
		if (this.navigationWidget == null) {
			this.navigationWidget = this.getContext().getViewFactory().createNavigationView();
			this.navigationWidget.addLogoutHandler(new EventHandler<EventArgs>() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					NavigationController.this.getContext().getSessionController().logout();
				}
			});
			this.navigationWidget.addRefreshHandler(new EventHandler<EventArgs>() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					NavigationController.this.getContext().updateModel();
				}
			});

			this.navigationWidget.registerHelpHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					NavigationController.this.getContext().getHelpController().showHelp(HelpResources.HELPINDEX);
				}
			});
		}
		return this.navigationWidget;
	}

	/**
	 * Updates the label that displays the current revision date.
	 * 
	 * @param revDate
	 *            Timestamp of the revision
	 */
	public void updateRevisionLabel(final Date revDate) {
		this.getNavigationWidget().updateRevisionLabel(revDate);
	}

}
