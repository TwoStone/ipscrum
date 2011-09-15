package fhdw.ipscrum.client.architecture.menu;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * represents a navigation menu entry.
 */
public class NavigationMenuEntry extends NavigationMenuItem {

	/**
	 * represents a menu command related to this entry to execcute the items in it.
	 */
	private final MenuCommand command;

	/**
	 * constructor of the NavigationMenuEntry.
	 * 
	 * @param caption
	 *            of the entry
	 * @param command
	 *            of the entry
	 */
	public NavigationMenuEntry(final String caption, final MenuCommand command) {
		super(caption);
		this.command = command;
	}

	/**
	 * getter of the current command of the entry.
	 * 
	 * @return the command
	 */
	public MenuCommand getCommand() {
		return this.command;
	}

	@Override
	public MenuItem getGwtMenuItem() {
		return new MenuItem(this.getCaption(), false, new Command() {

			@Override
			public void execute() {
				NavigationMenuEntry.this.command.execute();
			}
		});
	}

	@Override
	public void setContext(final ClientContext context) {
		this.command.setContext(context);
	}
}
