package fhdw.ipscrum.client.architecture.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;

/**
 * This is a device for displaying external HTML-documents in a dialog-box.
 */
public class FrameDialog extends DialogBox {

	private final FlowPanel flowPanel;
	private final Frame frame;

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            window-title
	 */
	public FrameDialog(final String title) {
		super();

		this.flowPanel = new FlowPanel();
		final Button close = new Button("X");
		close.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				FrameDialog.this.setVisible(false);
			}
		});
		this.flowPanel.add(close);
		this.frame = new Frame();
		this.frame.setPixelSize(700, 500);
		this.flowPanel.add(this.frame);
		this.add(this.flowPanel);
		this.setModal(false);
		this.setGlassEnabled(false);
		this.setHTML("<b>" + title + "</b>");
	}

	/**
	 * This is used to set the url of the HTML-document to be loaded.
	 * 
	 * @param url
	 *            URL-String
	 */
	public void setUrl(final String url) {
		this.frame.setUrl(url);
	}
}
