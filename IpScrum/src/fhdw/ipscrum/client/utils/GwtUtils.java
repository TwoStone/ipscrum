package fhdw.ipscrum.client.utils;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public final class GwtUtils {

	/**
	 * Creates a new modal dialog box. Lays a dark transparent layer over the
	 * background.
	 * 
	 * @param title
	 *            The text in the caption field.
	 * @return
	 */
	public static DialogBox createDialog(String title) {
		final DialogBox dialog = new DialogBox();
		dialog.setAnimationEnabled(true);
		dialog.setModal(true);
		dialog.setGlassEnabled(true);
		dialog.setHTML("<b>" + title + "</b>");
		return dialog;
	}

	public static void displayError(String error) {
		final DialogBox dialog = createDialog("Fehler");
		final VerticalPanel panel = new VerticalPanel();
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		panel.setSpacing(5);
		dialog.add(panel);

		final Label errorText = new Label(error);
		panel.add(errorText);

		final Button okayButton = new Button("Okay");
		okayButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
		});
		panel.add(okayButton);

		dialog.center();
	}
}
