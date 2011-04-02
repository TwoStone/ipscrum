package fhdw.ipscrum.client.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.logging.client.ConsoleLogHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.shared.constants.TextConstants;

public final class GwtUtils {

	private static Logger logger = Logger.getLogger("ErrorLogger");

	static {
		// logger.addHandler(new DevelopmentModeLogHandler());
		logger.addHandler(new ConsoleLogHandler());
	}

	/**
	 * Creates a new modal dialog box. Lays a dark transparent layer over the
	 * background.
	 * 
	 * @param title
	 *            The text in the caption field.
	 * @return
	 */
	public static DialogBox createDialog(final String title) {
		final DialogBox dialog = new DialogBox();
		// dialog.setAnimationEnabled(true);
		dialog.setModal(true);
		dialog.setGlassEnabled(true);
		dialog.setHTML("<b>" + title + "</b>");
		return dialog;
	}

	/**
	 * <b>Use void <i>displayError(Throwable error)</i> instead. If you want to
	 * display own text use <i>displayWarning(String warning)</i> or
	 * <i>showErrorBox(String caption,String error)</i> for box with custom
	 * caption. </b> <br/>
	 * Displays an error in an dialog box with close button.
	 * 
	 * @param error
	 */
	@Deprecated
	public static void displayError(final String error) {
		logger.log(Level.WARNING, error);
		showErrorBox(TextConstants.UTILS_ERROR, error);
	}

	/**
	 * @param error
	 */
	private static void showErrorBox(String caption, final String error) {
		final DialogBox dialog = createDialog(caption);
		final VerticalPanel panel = new VerticalPanel();
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		panel.setSpacing(5);
		dialog.add(panel);

		if (error != null) {
			final Label errorText = new Label(escapeString(error));
			panel.add(errorText);
		}
		final Button okayButton = new Button(TextConstants.CLOSE);
		okayButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				dialog.hide();
			}
		});
		panel.add(okayButton);

		dialog.center();
	}

	/**
	 * Displays an error in an dialog box with close button.
	 * 
	 * @param error
	 */
	public static void displayError(Throwable error) {
		logger.log(Level.WARNING, TextConstants.UTILS_ERROR, error);
		showErrorBox(TextConstants.UTILS_ERROR, error.getMessage());
	}

	/**
	 * Displays a warning in an dialog box with close button.
	 * 
	 * @param error
	 */
	public static void displayWarning(String warning) {
		showErrorBox(TextConstants.UTILS_WARNING, warning);
	}

	public static String escapeString(final String input) {
		final SafeHtmlBuilder htmlBuilder = new SafeHtmlBuilder();
		htmlBuilder.appendEscaped(input);
		return htmlBuilder.toSafeHtml().asString();
	}

	public static void setFocus(final Focusable focusable) {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				focusable.setFocus(true);
			}
		});
	}
}
