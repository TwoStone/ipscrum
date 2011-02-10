package fhdw.ipscrum.client.utils;

import com.google.gwt.user.client.ui.DialogBox;

public final class GwtUtils {
	
	/**
	 * Creates a new modal dialog box.
	 * Lays a dark transparent layer over the background.
	 * @param title The text in the caption field.
	 * @return
	 */
	public static DialogBox createDialog(String title) {
		DialogBox dialog = new DialogBox();
		dialog.setAnimationEnabled(true);
		dialog.setModal(true);
		dialog.setGlassEnabled(true);
		dialog.setText(title);
		return dialog;
	}
}
