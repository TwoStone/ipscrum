package fhdw.ipscrum.client.architecture.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.client.resources.css.Toast;

/**
 * represents the tastMassage which is always shown to inform the user if something special happend.
 */
public class ToastMessageBox extends PopupPanel {

	static {
		MyResources.INSTANCE.toast().ensureInjected();
	}

	private final VerticalPanel contentPanel;

	private final Label toastLabel;
	private final Label lblNewLabel;

	private final DefaultEvent closeEvent = new DefaultEvent();
	private final DefaultEvent clickedEvent = new DefaultEvent();
	private final DefaultEvent mouseOverEvent = new DefaultEvent();
	private final DefaultEvent mouseOutEvent = new DefaultEvent();

	/**
	 * constructor of the ToastMessageBox.
	 * 
	 * @param message
	 *            shown in the Box
	 */
	public ToastMessageBox(final String message) {
		final Toast resource = MyResources.INSTANCE.toast();

		this.setStyleName(resource.toastPanel());
		this.setSize("", "");

		this.contentPanel = new VerticalPanel();
		this.contentPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		this.contentPanel.setSpacing(5);
		this.setWidget(this.contentPanel);
		this.contentPanel.setSize("100%", "100%");

		this.toastLabel = new Label("This is a toast message");
		this.toastLabel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(final MouseOutEvent event) {
				ToastMessageBox.this.mouseOutEvent.fire(ToastMessageBox.this);
			}
		});
		this.toastLabel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(final MouseOverEvent event) {
				ToastMessageBox.this.mouseOverEvent.fire(ToastMessageBox.this);
			}
		});
		this.toastLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ToastMessageBox.this.clickedEvent.fire(ToastMessageBox.this);
			}
		});
		this.toastLabel.setStyleName(resource.message());
		this.toastLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.contentPanel.add(this.toastLabel);
		this.toastLabel.setSize("100%", "100%");
		this.toastLabel.setText(message);

		this.lblNewLabel = new Label("test");
		this.contentPanel.add(this.lblNewLabel);
		this.contentPanel.setCellHorizontalAlignment(this.lblNewLabel, HasHorizontalAlignment.ALIGN_CENTER);
		this.lblNewLabel.setStyleName(resource.stateLabel());

		final Button btnNewButton = new Button("");
		btnNewButton.setStyleName(resource.gwtButton());
		this.contentPanel.add(btnNewButton);
		btnNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ToastMessageBox.this.hide();
			}
		});
		this.contentPanel.setCellHorizontalAlignment(btnNewButton, HasHorizontalAlignment.ALIGN_RIGHT);
	}

	@Override
	public void setPopupPositionAndShow(final PositionCallback callback) {
		super.setPopupPositionAndShow(callback);
		this.setPopupPosition(this.getPopupLeft(), -this.getOffsetHeight());
		final GQuery element = GQuery.$(this);
		element.animate("top: '0' , visibility: 'visible'");
	}

	@Override
	public void hide() {
		final GQuery element = GQuery.$(this);
		element.animate("top: '-=" + this.getOffsetHeight() + "'", new Function() {
			@Override
			public void f() {
				ToastMessageBox.super.hide();
			}
		});
		this.clickedEvent.removeAllHandler();
		this.closeEvent.removeAllHandler();
		this.mouseOutEvent.removeAllHandler();
		this.mouseOverEvent.removeAllHandler();
	}

	// public EventRegistration registerCloseHandler(
	// final DefaultEventHandler handler) {
	// return this.closeEvent.add(handler);
	// }

	/**
	 * Represents the event needed for handle the click event.
	 * 
	 * @param handler
	 *            is the handler needed to handle the event
	 * @return the event needed for handling the click event.
	 */
	public EventRegistration registerClickHandler(final DefaultEventHandler handler) {
		return this.clickedEvent.add(handler);
	}

	/**
	 * Represents the event needed for handle the mouse over effect.
	 * 
	 * @param handler
	 *            is the handler needed to handle the event
	 * @return the event needed for handling the mouse over effect.
	 */
	public EventRegistration registerMouseOverHandler(final DefaultEventHandler handler) {
		return this.mouseOverEvent.add(handler);
	}

	/**
	 * Represents the event needed for handle the mouse out effect.
	 * 
	 * @param handler
	 *            is the handler needed to handle the event
	 * @return the event needed for handling the mouse out effect.
	 */
	public EventRegistration registerMouseOutHandler(final DefaultEventHandler handler) {
		return this.mouseOutEvent.add(handler);
	}

	/**
	 * sets the count how many toast are still waiting to bee shown.
	 * 
	 * @param count
	 *            is the number of toasts still waiting
	 */
	public void setCount(final int count) {
		String text = "";
		if (count > 1) {
			text = "(" + count + " weitere Nachrichten)";
		} else if (count == 1) {
			text = "(" + count + " weitere Nachricht)";
		}
		this.lblNewLabel.setText(text);
	}
}
