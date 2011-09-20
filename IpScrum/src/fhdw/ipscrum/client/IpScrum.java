package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ApplicationController;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.ApplicationStartedEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController;
import fhdw.ipscrum.client.architecture.controller.ViewFactory;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus;
import fhdw.ipscrum.client.architecture.menu.MenuCommand;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.menu.NavigationMenuEntry;
import fhdw.ipscrum.client.architecture.menu.NavigationSubmenu;
import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.presenter.PersonRolePresenter;
import fhdw.ipscrum.client.presenter.ProjectSelectionPresenter;
import fhdw.ipscrum.client.presenter.RevisionControlPresenter;
import fhdw.ipscrum.client.presenter.SearchAllPresenter;
import fhdw.ipscrum.client.presenter.SearchPresenter;
import fhdw.ipscrum.client.presenter.SearchesPresenter;
import fhdw.ipscrum.client.presenter.StateFieldAndTickettypeAdministrationPresenter;
import fhdw.ipscrum.client.presenter.SystemManagementPresenter;
import fhdw.ipscrum.client.presenter.TeamPresenter;
import fhdw.ipscrum.client.presenter.TicketTypeSelectionPresenter;
import fhdw.ipscrum.client.presenter.UserManagementPresenter;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.utils.SimpleCallback;
import fhdw.ipscrum.client.view.widgets.GWTCanvasBasedCanvasFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	// This line "teaches" GChart how to create the canvas
	// widgets it needs to render any continuous,
	// non-rectangular, chart aspects (solid fill pie slices,
	// continously connected lines, etc.) clearly and
	// efficiently. It's generally best to do this exactly once,
	// when your entire GWT application loads.
	static {
		GChart.setCanvasFactory(new GWTCanvasBasedCanvasFactory());
		MyResources.INSTANCE.architecture().ensureInjected();
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final ViewFactory factory = new ViewFactory();
		final EventBus eventBus = new EventBus();
		final SessionController sessionController =
				new SessionController(factory, eventBus);
		sessionController.login();

		this.registerResizeHandler(eventBus);

		GWT.runAsync(new RunAsyncCallback() {

			@Override
			public void onSuccess() {
				final Presenter startPresenter = new ProjectSelectionPresenter(null);

				final ClientContext clientContext =
						new ClientContext.ClientContextBuilder(factory, startPresenter,
								IpScrum.this.buildMenu(), sessionController, eventBus)
								.getContext();
				startPresenter.setContext(clientContext);
			}

			@Override
			public void onFailure(final Throwable reason) {

			}
		});
	}

	/**
	 * Represents the handler to handle the resize event.
	 * 
	 * @param eventBus
	 *            representing the eventBus needed for handling
	 */
	private void registerResizeHandler(final EventBus eventBus) {
		Window.addResizeHandler(new ResizeHandler() {

			@Override
			public void onResize(final ResizeEvent event) {
				GwtUtils.setMainHeight();
				GWT.log("Resized");
			}
		});

		eventBus.registerHandler(ApplicationStartedEvent.class,
				new ApplicationController.ApplicationStartedHandler() {

					@Override
					public void handle(final ApplicationStartedEvent event) {
						GwtUtils.setMainHeight();
					}
				});

	}

	public NavigationMenu buildMenu() {
		final NavigationMenu menu = new NavigationMenu();
		menu.addItem(new NavigationMenuEntry("Projekte", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new ProjectSelectionPresenter(getContext()));
					}
				});
			}
		}));
		final NavigationSubmenu submenu = new NavigationSubmenu("Verwaltung");
		menu.addItem(submenu);
		submenu.addItem(new NavigationMenuEntry("Personen und Rollen",
				new MenuCommand() {

					@Override
					public void execute() {
						this.getApplicationController().newStack(new SimpleCallback() {

							@Override
							public void callback() {
								getApplicationController().showPresenter(
										new PersonRolePresenter(getContext()));
							}
						});
					}
				}));
		submenu.addItem(new NavigationMenuEntry("Teams", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new TeamPresenter(getContext()));
					}
				});

			}
		}));
		submenu.addItem(new NavigationMenuEntry("Revisionsverwaltung",
				new MenuCommand() {

					@Override
					public void execute() {
						this.getApplicationController().newStack(new SimpleCallback() {

							@Override
							public void callback() {
								getApplicationController().showPresenter(
										new RevisionControlPresenter(getContext()));
							}
						});

					}
				}));
		submenu.addItem(new NavigationMenuEntry(
				"Feldtypen-, Zustands- und Tickettypen-Erzeugung", new MenuCommand() {

					@Override
					public void execute() {
						this.getApplicationController().newStack(new SimpleCallback() {

							@Override
							public void callback() {
								getApplicationController()
										.showPresenter(
												new StateFieldAndTickettypeAdministrationPresenter(
														getContext()));
							}
						});

					}
				}));
		submenu.addItem(new NavigationMenuEntry("Tickettypen-Administration",
				new MenuCommand() {

					@Override
					public void execute() {
						this.getApplicationController().newStack(new SimpleCallback() {

							@Override
							public void callback() {

								getApplicationController().showPresenter(
										new TicketTypeSelectionPresenter(getContext()));

							}
						});
					}
				}));
		submenu.addItem(new NavigationMenuEntry("Systeme", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new SystemManagementPresenter(getContext()));
					}
				});

			}
		}));
		submenu.addItem(new NavigationMenuEntry("Benutzer", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new UserManagementPresenter(getContext()));
					}
				});
			}
		}));

		final NavigationSubmenu submenu2 = new NavigationSubmenu("Suche");
		menu.addItem(submenu2);
		submenu2.addItem(new NavigationMenuEntry("Scruumle", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new SearchAllPresenter(getContext()));

					}
				});

			}
		}));

		submenu2.addItem(new NavigationMenuEntry("Detailsuche", new MenuCommand() {

			@Override
			public void execute() {
				this.getApplicationController().newStack(new SimpleCallback() {

					@Override
					public void callback() {
						getApplicationController().showPresenter(
								new SearchPresenter(getContext()));

					}
				});

			}
		}));

		submenu2.addItem(new NavigationMenuEntry("Gespeicherte Suchen",
				new MenuCommand() {

					@Override
					public void execute() {
						this.getApplicationController().newStack(new SimpleCallback() {

							@Override
							public void callback() {
								getApplicationController().showPresenter(
										new SearchesPresenter(getContext()));
							}
						});
					}
				}));

		return menu;
	}
}
