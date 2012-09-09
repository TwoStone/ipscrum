package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.user.client.Window;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedEvent;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedHandler;
import fhdw.ipscrum.client.architecture.presenter.Presenter;

/**
 * Updates the browsers window title bar.
 */
public class WindowTitleController extends ClientController {

	/**
	 * Creates a new instance in the specified context.
	 * 
	 * @param context
	 *            the actual context
	 */
	public WindowTitleController(final ClientContext context) {
		super(context);
		context.getEventBus().registerHandler(PresenterChangedEvent.class, new PresenterChangedHandler() {

			@Override
			public void handlePresenterChanged(final PresenterChangedEvent event) {
				WindowTitleController.this.doPresenterChanged(event.getObject());
			}
		});
	}

	/**
	 * Updates the window title.
	 * 
	 * @param object
	 *            the currently active presenter
	 */
	private void doPresenterChanged(final Presenter object) {
		Window.setTitle(object.getName());
	}

}
