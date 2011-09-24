package fhdw.ipscrum.client.architecture.controller;

import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.architecture.widgets.FrameDialog;
import fhdw.ipscrum.shared.constants.HelpRessources;

/**
 * This manages the user documentation of IP-Scrum.
 */
public class HelpController {

	/**
	 * This is the frame, the documentation will be loaded into.
	 */
	private FrameDialog helpBox;

	/**
	 * This method is used to launch the documentation to the selected presenter class.
	 * 
	 * @param presenter
	 *            Presenter class
	 */
	public void showHelp(final Presenter presenter) {
		this.dialogHelp(HelpRessources.HELPSRC + HelpRessources.getPresenterHelp(presenter));
	}

	/**
	 * Internal method for launching help-windows.
	 * 
	 * @param url
	 *            URL-String
	 */
	private void dialogHelp(final String url) {
		final String title = "IP Scrum Hilfe";
		if (this.helpBox == null) {
			this.helpBox = new FrameDialog(title);
			this.helpBox.center();
		} else {
			if (!this.helpBox.isVisible()) {
				this.helpBox = new FrameDialog(title);
				this.helpBox.center();
			}
		}

		this.helpBox.setUrl(url);
		this.helpBox.show();
	}

	/**
	 * This method is used to launch the documentation to the selected presenter class.
	 * 
	 * @param url
	 *            URL-String
	 */
	public void showHelp(final String url) {
		this.dialogHelp(HelpRessources.HELPSRC + url);
	}
}
