package fhdw.ipscrum.client.architecture.menu;

import com.google.gwt.user.client.ui.MenuItem;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * represents s navigation menu item.
 */
public abstract class NavigationMenuItem {
	/**
	 * represents the caption of the item to identify it.
	 */
	private final String caption;

	/**
	 * constructor of the NavigationMenuItem.
	 * 
	 * @param caption
	 *            of the item
	 */
	public NavigationMenuItem(final String caption) {
		super();
		this.caption = caption;
	}

	/**
	 * getter of the caption of the item.
	 * 
	 * @return the current caption
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * getter of the menu item.
	 * 
	 * @return the menu item
	 */
	public abstract MenuItem getGwtMenuItem();

	/**
	 * sets the context of the menu item.
	 * 
	 * @param context
	 *            to set
	 */
	public abstract void setContext(ClientContext context);
}
