package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.viewinterfaces.IWidgetView;

/**
 * Simple view for displaying custom widgets (i.e. charts).
 */
public class WidgetView extends Composite implements IWidgetView {

	private final DefaultEvent closeEvent = new DefaultEvent();

	/**
	 * constructor of the WidgetView.
	 * 
	 * @param widget
	 *            is the related widget.
	 * @param title
	 *            is the title of the view.
	 */
	public WidgetView(final Widget widget, final String title) {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		this.initWidget(verticalPanel);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");
		verticalPanel.setCellWidth(horizontalPanel, "100%");

		final Label header = new Label(title);
		header.setStyleName("header3");
		horizontalPanel.add(header);
		horizontalPanel.setCellHorizontalAlignment(header,
				HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setCellWidth(header, "100%");
		header.setWidth("100%");

		final Image closeButton = new Image("images/closeToast.png");
		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				WidgetView.this.closeEvent.fire(WidgetView.this);
			}
		});
		horizontalPanel.add(closeButton);
		closeButton.setStyleName("hoverEffect");

		final SimplePanel contentPanel = new SimplePanel();
		verticalPanel.add(contentPanel);
		verticalPanel.setCellHeight(contentPanel, "100%");
		verticalPanel.setCellWidth(contentPanel, "100%");
		contentPanel.setSize("100%", "100%");
		contentPanel.setWidget(widget);
	}

	@Override
	public void close() {
		this.closeEvent.removeAllHandler();
	}

	@Override
	public EventRegistration
			registerCloseEventHandler(final DefaultEventHandler handler) {
		return this.closeEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
