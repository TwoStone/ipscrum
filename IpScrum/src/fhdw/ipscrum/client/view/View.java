package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.EventRegistration;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IView;

public abstract class View extends Composite implements IView {
	private final Event<EventArgs> closed;

	public View() {
		super();
		this.closed = new Event<EventArgs>();
	}

	public EventRegistration registerCloseHandler(
			EventHandler<EventArgs> handler) {
		return this.closed.add(handler);
	}

	public void close() {
		this.closed.fire(this, new EventArgs());
	}

	public void showDialog(String title, View contents) {
		final DialogBox dialog = GwtUtils.createDialog(title);
		dialog.add(contents);
		contents.registerCloseHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				dialog.hide();
			}
		});
		dialog.center();
	}
}
