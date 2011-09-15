package fhdw.ipscrum.client.architecture.controller;

import java.util.LinkedList;
import java.util.Queue;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PopupPanel.PositionCallback;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.widgets.ToastMessageBox;

/**
 * Controls the display of toast notifications in the application.
 */
public class ToastMessageController {
	/**
	 * Time periods the toast notification should be displayed.
	 */
	public static enum DisplayDuration {
		/**
		 * 
		 */
		INFINITE(0), LONG(6000), MEDIUM(3000), SHORT(1500);

		/**
		 * The time the notification is displayed.
		 */
		private final int length;

		/**
		 * 
		 * @param length
		 *            The time the notification is being displayed.
		 */
		DisplayDuration(final int length) {
			this.length = length;
		}

	}

	/**
	 * Wrapper for a message and a duration.
	 */
	public static class ToastMessage {
		/**
		 * Time the message will be displayed.
		 */
		private final Integer duration;
		/**
		 * Text of the message.
		 */
		private final String message;

		/**
		 * Creates a new toast message.
		 * 
		 * @param duration
		 *            Time the message will be displayed
		 * @param message
		 *            Text of the message
		 */
		public ToastMessage(final Integer duration, final String message) {
			super();
			this.duration = duration;
			this.message = message;
		}

		/**
		 * Returns the time the message will be displayed.
		 * 
		 * @return time in milliseconds.
		 */
		public Integer getDuration() {
			return this.duration;
		}

		/**
		 * Returns the text of the message.
		 * 
		 * @return text of the message
		 */
		public String getMessage() {
			return this.message;
		}
	}

	/**
	 * Default duration a message will be displayed.
	 */
	private static final int DEFAULTDELAY =
			ToastMessageController.DisplayDuration.MEDIUM.length;

	/**
	 * The currently displayed ToastMessageBox.
	 */
	private ToastMessageBox currentToast;

	/**
	 * Timer that manages the displaying of the messages.
	 */
	private Timer timer;

	/**
	 * Determines if currently a toastMessage is displaying in the view.
	 */
	private boolean toastIsDisplaying;

	/**
	 * Queue of waiting messages to be displayed.
	 */
	private final Queue<ToastMessageController.ToastMessage> waitingMessages;

	/**
	 * Creates a new ToastMessageController. Creating more than one instance will result
	 * in strange behaviors.
	 */
	public ToastMessageController() {
		super();
		this.waitingMessages = new LinkedList<ToastMessageController.ToastMessage>();
	}

	/**
	 * Adds a new ToastMessage to the queue to. If no other message is displaying
	 * currently the message will be displayed immediately.
	 * 
	 * @param message
	 *            the message that will be displayed
	 */
	public void addToastMessage(final ToastMessage message) {
		GWT.log("[ToastController] Adding toast message to queue: "
				+ message.getMessage());
		this.waitingMessages.offer(message);
		if (!this.toastIsDisplaying) {
			this.nextToast();
		}
		if (this.currentToast != null) {
			this.currentToast.setCount(this.waitingMessages.size());
		}
	}

	/**
	 * Displays the {@link ToastMessageBox} for the specified time.
	 * 
	 * @param messageBox
	 *            Containing the toast message
	 * @param milliseconds
	 *            time the message will be displayed
	 */
	private void displayToast(final ToastMessageBox messageBox,
			final Integer milliseconds) {
		messageBox.setPopupPositionAndShow(new PositionCallback() {

			@Override
			public void setPosition(final int offsetWidth, final int offsetHeight) {
				final int clientWidth = Window.getClientWidth();

				final int topPosition = 0;
				final int leftPosition = (clientWidth - offsetWidth) / 2;

				messageBox.setPopupPosition(leftPosition, topPosition);
			}
		});

		this.timer = new Timer() {

			@Override
			public void run() {
				messageBox.hide();
			}
		};

		messageBox.registerClickHandler(new DefaultEventHandler() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				ToastMessageController.this.timer.cancel();
			}
		});
		messageBox.registerMouseOverHandler(new DefaultEventHandler() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				ToastMessageController.this.timer.cancel();
			}
		});
		messageBox.registerMouseOutHandler(new DefaultEventHandler() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				if (milliseconds != ToastMessageController.DisplayDuration.INFINITE.length) {
					ToastMessageController.this.timer.schedule(milliseconds);
				}
			}
		});

		if (milliseconds != ToastMessageController.DisplayDuration.INFINITE.length) {
			this.timer.schedule(milliseconds);
		}
	}

	/**
	 * Shows the next toast message.
	 */
	private void nextToast() {
		final ToastMessage message = this.waitingMessages.poll();
		if (message != null) {
			GWT.log("[ToastController]  Showing toast message: " + message.getMessage());
			final ToastMessageBox messageBox =
					new ToastMessageBox(message.getMessage());
			this.currentToast = messageBox;
			messageBox.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(final CloseEvent<PopupPanel> event) {
					ToastMessageController.this.nextToast();
					ToastMessageController.this.currentToast = null;
				}
			});
			messageBox.setCount(this.waitingMessages.size());
			this.toastIsDisplaying = true;
			this.displayToast(messageBox, message.getDuration());
		} else {
			this.toastIsDisplaying = false;
		}
	}

	/**
	 * Displays the message as a toast message for the default duration (3s).
	 * 
	 * @param message
	 *            Message to be displayed.
	 */
	public void toastMessage(final String message) {
		this.toastMessage(message, ToastMessageController.DEFAULTDELAY);
	}

	/**
	 * Displays the message as a toast message for the specified duration.
	 * 
	 * @param message
	 *            Message to be displayed.
	 * @param duration
	 *            duration the message will be displayed
	 */
	public void toastMessage(final String message, final DisplayDuration duration) {
		this.toastMessage(message, duration.length);
	}

	/**
	 * Displays the message as a toast message for the specified duration in milliseconds.
	 * 
	 * @param message
	 *            Message to be displayed.
	 * @param milliseconds
	 *            duration the message will be displayed in milliseconds
	 */
	public void toastMessage(final String message, final int milliseconds) {
		this.addToastMessage(new ToastMessage(milliseconds, message));
	}
}
