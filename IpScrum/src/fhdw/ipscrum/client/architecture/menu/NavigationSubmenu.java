package fhdw.ipscrum.client.architecture.menu;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * represents the navigation submenu.
 */
public class NavigationSubmenu extends NavigationMenuItem {
	/**
	 * represents the items in the submenu.
	 */
	private final List<NavigationMenuItem> items;

	/**
	 * constructor of the NavigationSubmenu.
	 * 
	 * @param caption
	 *            of the submenu
	 */
	public NavigationSubmenu(final String caption) {
		super(caption);
		this.items = new ArrayList<NavigationMenuItem>();
	}

	/**
	 * adds an item to the submenu.
	 * 
	 * @param item
	 *            to add
	 */
	public void addItem(final NavigationMenuItem item) {
		this.items.add(item);
	}

	@Override
	public MenuItem getGwtMenuItem() {
		final MenuBar menuBar = new MenuBar(true);
		final MenuItem item = new MenuItem(this.getCaption(), menuBar);
		for (final NavigationMenuItem current : this.items) {
			menuBar.addItem(current.getGwtMenuItem());
		}
		return item;
	}

	@Override
	public void setContext(final ClientContext context) {
		for (final NavigationMenuItem item : this.items) {
			item.setContext(context);
		}
	}
}
