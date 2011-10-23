/**
 * 
 */
package fhdw.ipscrum.client.utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**

 */
public final class AsyncCallbacks {

	/**
	 * @param clazz
	 *            the class of the return type
	 * @param <R>
	 *            type of the return value
	 * @return Returns a new callback that need no implementation
	 */
	public static <R> AsyncCallback<R> noCallback(final Class<R> clazz) {
		return new AsyncCallback<R>() {

			@Override
			public void onFailure(final Throwable caught) {
				GWT.log("Error", caught);
			}

			@Override
			public void onSuccess(final R result) {
				// TODO Auto-generated method stub

			}
		};
	}

	/**
	 * Constructor.
	 */
	private AsyncCallbacks() {

	}

}
