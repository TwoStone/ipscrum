package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedEvent;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedHandler;
import fhdw.ipscrum.client.architecture.presenter.Presenter;

/**
 * Updates the browser history and handles history events.
 */
public class HistoryController extends ClientController {

	/**
	 * Token for the page in the URI.
	 */
	public static final String PAGE = "page=";
	/**
	 * Token for the id in the URI.
	 */
	public static final String IDTOKEN = "id=";
	/**
	 * Seperator between tokens in the URI.
	 */
	public static final String SEPERATOR = "|";

	/**
	 * Handles history events from the browser.
	 */
	private final ValueChangeHandler<String> historyChangeHandler =
			new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(final ValueChangeEvent<String> event) {
					// Here the implementation for a place management starts.

					// final String value = event.getValue();
					// final String[] strings = value.split("[" +
					// HistoryController.SEPERATOR + "]");
					// if (strings.length == 2) {

					// final String clazzToken = strings[0];
					// final String idToken = strings[1];
					// }

				}
			};

	/**
	 * Create a new instance in the specified context.
	 * 
	 * @param context
	 *            the actual context
	 */
	public HistoryController(final ClientContext context) {
		super(context);
		History.addValueChangeHandler(this.historyChangeHandler);

		context.getEventBus().registerHandler(PresenterChangedEvent.class,
				new PresenterChangedHandler() {

					@Override
					public void
							handlePresenterChanged(final PresenterChangedEvent event) {
						// HistoryController.this.updateHistory(event.getObject());
					}
				});
	}

	/**
	 * Updates the browser history.
	 * 
	 * @param presenter
	 *            the currently active presenter
	 */
	public void updateHistory(final Presenter presenter) {
		History.newItem(HistoryController.PAGE + presenter.getClass().getName()
				+ HistoryController.SEPERATOR + HistoryController.IDTOKEN
				+ presenter.getIdentifier());
	}

}
