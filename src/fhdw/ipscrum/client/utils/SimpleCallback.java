package fhdw.ipscrum.client.utils;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * An interface for receiving callback.
 */
public interface SimpleCallback {
	/**
	 * This is the callback function.
	 */
	void callback();

	/**
	 * A context sensitive call back handler.
	 */
	public abstract class SimpleCallbackWithContext implements SimpleCallback {

		/**
		 * the current context.
		 */
		private final ClientContext context;

		/**
		 * Creates a new {@link SimpleCallback.SimpleCallbackWithContext} object.
		 * 
		 * @param context
		 *            the current context
		 */
		public SimpleCallbackWithContext(final ClientContext context) {
			super();
			this.context = context;
		}

		/**
		 * 
		 * @return the current context
		 */
		public ClientContext getContext() {
			return this.context;
		}

	}
}
