package fhdw.ipscrum.client.architecture.menu;

import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * represents the navigation menu.
 */
public class NavigationMenu {
	/**
	 * represents the list of items in the navigation menu.
	 */
	private final List<NavigationMenuItem> items;

	/**
	 * constructor of the navigation menu.
	 */
	public NavigationMenu() {
		this.items = new ArrayList<NavigationMenuItem>();
	}

	/**
	 * adds an item to the navigation menu.
	 * 
	 * @param item
	 *            ti add
	 */
	public void addItem(final NavigationMenuItem item) {
		this.items.add(item);
	}

	/**
	 * sets the context of the navigation menu.
	 * 
	 * @param context
	 *            to set at the items of the menu
	 */
	public void setContext(final ClientContext context) {
		for (final NavigationMenuItem item : this.items) {
			item.setContext(context);
		}
	}

	/**
	 * getter of all items in the navigation menu.
	 * 
	 * @return all items in the menu
	 */
	public List<NavigationMenuItem> getItems() {
		return this.items;
	}
}
