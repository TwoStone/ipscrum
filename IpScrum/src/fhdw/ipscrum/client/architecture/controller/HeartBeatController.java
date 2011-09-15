package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEventHandler;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEventHandler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus;
import fhdw.ipscrum.client.services.HeartBeatService;
import fhdw.ipscrum.client.services.HeartBeatServiceAsync;

/**
 * Wrapper for a heart beat service. When pulsing is started it sends heart beats in
 * regular intervals to the service. This is necessary to prevent the server from
 * recycling the HttpSession for the client, after some time of inactivity.
 * 
 * @author Niklas
 * 
 */
public class HeartBeatController {

	/**
	 * Seconds to wait between beats.
	 */
	private static final int SENCONDS = 30;

	/**
	 * Conversion milliseconds to seconds.
	 */
	private static final int THOUSAND = 1000;

	/**
	 * Milliseconds between two beats.
	 */
	private static final int FREQ = HeartBeatController.SENCONDS
			* HeartBeatController.THOUSAND;

	/**
	 * Timer that schedules the service calls.
	 */
	private final Timer beat;

	/**
	 * Reference to the underlying service implementation.
	 */
	private final HeartBeatServiceAsync heartBeatService;

	/**
	 * Creates a new heart.
	 * 
	 * @param eventBus
	 *            The global event bus.
	 */
	public HeartBeatController(final EventBus eventBus) {
		this.heartBeatService = HeartBeatService.Util.getInstance();
		this.beat = new Timer() {

			@Override
			public void run() {
				HeartBeatController.this.heartBeatService
						.pulse(new AsyncCallback<Void>() {

							@Override
							public void onSuccess(final Void result) {
							}

							@Override
							public void onFailure(final Throwable caught) {
								GWT.log("[HeartBeatController] Server seems to be dead, "
										+ "life doesn't make sense anymore"
										+ " - I'm going to die too! " + "Goodbye! ",
										caught);
								HeartBeatController.this.beat.cancel();
							}
						});
			}
		};

		eventBus.registerHandler(LoginEvent.class, new LoginEventHandler() {

			@Override
			public void handleLogin(final LoginEvent event) {
				HeartBeatController.this.startPulsing();
			}
		});

		eventBus.registerHandler(LogoutEvent.class, new LogoutEventHandler() {

			@Override
			public void handleLogout(final LogoutEvent event) {
				HeartBeatController.this.stopPulsing();
			}
		});
	}

	/**
	 * Animates the heart to beat.
	 */
	public void startPulsing() {
		this.beat.scheduleRepeating(HeartBeatController.FREQ);
	}

	/**
	 * Stops the beating heart. <br/>
	 * For reanimation use a defibrilator or call
	 * {@link HeartBeatController#startPulsing()}.
	 */
	public void stopPulsing() {
		this.beat.cancel();
	}
}
