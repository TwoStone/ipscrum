package fhdw.ipscrum.client.utils;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Some utilities for working in the GWT environment.
 */
public final class GwtUtils {

	/**
	 * Hides the default constructor.
	 */
	private GwtUtils() {

	}

	/**
	 * Sets the browser focus to the {@link Focusable} object. This is a workaround because just calling
	 * {@link Focusable#setFocus(true)} sometimes has no affect.
	 * 
	 * @param focusable
	 *            the object that should be focused
	 */
	public static void setFocus(final Focusable focusable) {
		Scheduler.get().scheduleFinally(new ScheduledCommand() {

			@Override
			public void execute() {
				focusable.setFocus(true);
			}
		});
	}

	/**
	 * Determines if the enter key was pressed in the {@link KeyPressEvent}.
	 * 
	 * @param event
	 *            the {@link KeyPressEvent}
	 * @return <code>true</code> if enter was pressed
	 */
	public static boolean enterPressed(final KeyPressEvent event) {
		return event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER;
	}

	/**
	 * Adjusts the height of the three areas in the HTML host.
	 */
	public static void setMainHeight() {
		final RootPanel header = RootPanel.get("header");
		final RootPanel main = RootPanel.get("middle");
		final RootPanel footer = RootPanel.get("footer");

		final int headerHeight = header.getOffsetHeight();
		final int footerHeight = footer.getOffsetHeight();
		final int windowHeight = Window.getClientHeight();

		final int mainHeight = windowHeight - headerHeight - footerHeight;
		main.setHeight(mainHeight + "px");
	}
}
