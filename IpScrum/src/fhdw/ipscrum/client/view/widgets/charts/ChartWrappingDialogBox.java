package fhdw.ipscrum.client.view.widgets.charts;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.shared.constants.TextConstants;

/**
 *	This is just a wrapper for GCharts, which adds a close-button.
 *	Since there is no functionality provided, a separate presenter is not necessary.
 */
public class ChartWrappingDialogBox extends DialogBox {

	/**
	 * Constructor.
	 * @param content the content to be wrapped.
	 */
	public ChartWrappingDialogBox(Composite content) {

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		verticalPanel.add(content);

		Button btnClose = new Button(TextConstants.CHARTPOPUP_CLOSEBUTTON);
		btnClose.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ChartWrappingDialogBox.this.hide();
			}
		});
		verticalPanel.add(btnClose);
		verticalPanel.setCellHorizontalAlignment(btnClose, HasHorizontalAlignment.ALIGN_RIGHT);

		setAnimationEnabled(true);
		setGlassEnabled(true);
		setHTML(TextConstants.CHARTPOPUP_TITLE);
	}

}