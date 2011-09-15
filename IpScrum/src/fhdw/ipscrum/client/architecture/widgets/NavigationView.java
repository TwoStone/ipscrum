package fhdw.ipscrum.client.architecture.widgets;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.menu.NavigationMenuItem;
import fhdw.ipscrum.client.resources.MyResources;

public class NavigationView extends Composite implements INavigationView {

	static {
		MyResources.INSTANCE.navigation().ensureInjected();
	}

	private final Label usernameLable;
	private final Button logoutButton;
	private final MenuBar menuBar;
	private final Event<EventArgs> logoutClicked = new Event<EventArgs>();
	private final Event<EventArgs> refreshClicked = new Event<EventArgs>();
	private final Label revisionLabel;
	private final Label roleLabel;

	public NavigationView() {

		final HorizontalPanel layoutPanel = new HorizontalPanel();
		this.initWidget(layoutPanel);

		this.menuBar = new MenuBar(false);
		this.menuBar.setStyleName("navbar");
		this.menuBar.setAnimationEnabled(true);
		layoutPanel.add(this.menuBar);

		final MenuItem mntmMenu = new MenuItem("Menu", false, (Command) null);
		this.menuBar.addItem(mntmMenu);

		final MenuItem mntmHome = new MenuItem("Home", false, (Command) null);
		this.menuBar.addItem(mntmHome);
		final MenuBar menuBar_1 = new MenuBar(true);

		final MenuItem mntmBla = new MenuItem("Bla", false, menuBar_1);

		final MenuItem mntmItem = new MenuItem("Item 1", false, (Command) null);
		menuBar_1.addItem(mntmItem);
		final MenuBar menuBar_2 = new MenuBar(true);

		final MenuItem mntmNewMenu = new MenuItem("New menu", false, menuBar_2);

		final MenuItem mntmSubitem = new MenuItem("subitem 2", false, (Command) null);
		menuBar_2.addItem(mntmSubitem);
		menuBar_1.addItem(mntmNewMenu);

		final MenuItem mntmNewItem = new MenuItem("New item", false, (Command) null);
		menuBar_1.addItem(mntmNewItem);
		this.menuBar.addItem(mntmBla);

		final HorizontalPanel rightPanel = new HorizontalPanel();
		rightPanel.setStyleName("rightPanel");
		layoutPanel.add(rightPanel);

		final Image refreshImage = new Image("images/refresh_30.png");
		refreshImage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				NavigationView.this.refreshClicked.fire(NavigationView.this,
						new EventArgs());
			}
		});

		this.revisionLabel = new Label("");
		rightPanel.add(this.revisionLabel);
		rightPanel.add(refreshImage);
		refreshImage.setSize("30", "30");

		this.usernameLable = new Label("");
		this.usernameLable.setStyleName("username");
		rightPanel.add(this.usernameLable);

		this.roleLabel = new Label("");
		this.roleLabel.setStyleName("username");
		rightPanel.add(this.roleLabel);

		this.logoutButton = new Button("Logout");
		rightPanel.add(this.logoutButton);
		this.setStyleName("navigation-widget");
		this.logoutButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				NavigationView.this.logoutClicked.fire(NavigationView.this,
						new EventArgs());
			}
		});
	}

	private void buildMenu(final MenuBar menubar,
			final List<fhdw.ipscrum.client.architecture.menu.NavigationMenuItem> menu) {
		for (final NavigationMenuItem navigationMenuItem : menu) {
			menubar.addItem(navigationMenuItem.getGwtMenuItem());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.INavigationView#addLogoutHandler
	 * (fhdw.ipscrum.architecture.client.events.EventHandler)
	 */
	@Override
	public EventRegistration addLogoutHandler(final EventHandler<EventArgs> handler) {
		return this.logoutClicked.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.INavigationView#setUserName(
	 * java.lang.String)
	 */
	@Override
	public void setUserName(final String name) {
		this.usernameLable.setText(name);
	}

	public String getUserName() {
		return this.usernameLable.getText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.INavigationView#addRefreshHandler
	 * (fhdw.ipscrum.architecture.client.events.EventHandler)
	 */
	@Override
	public EventRegistration addRefreshHandler(final EventHandler<EventArgs> handler) {
		return this.refreshClicked.add(handler);
	}

	@Override
	public void close() {

	}

	protected Label getRevisionLabel() {
		return this.revisionLabel;
	}

	@Override
	public void updateRevisionLabel(final Date revDate) {
		this.getRevisionLabel().setText("Aktuelle Revision: " + revDate);
	}

	@Override
	public void setMenu(final NavigationMenu menu) {
		this.menuBar.clearItems();
		this.buildMenu(this.menuBar, menu.getItems());
	}

	protected Label getRoleLabel() {
		return this.roleLabel;
	}

	@Override
	public void setActiveRole(final String role) {
		this.getRoleLabel().setText("Aktive Rolle: " + role);

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
