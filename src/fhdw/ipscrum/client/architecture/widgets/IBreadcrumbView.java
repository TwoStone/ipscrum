package fhdw.ipscrum.client.architecture.widgets;

import java.util.List;

import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.utils.SimpleCallback;

/**
 * represents the interface to the breadcrumbView.
 */
public interface IBreadcrumbView extends IView {

	/**
	 * Represents an item in the breadcrumb.
	 */
	public static class BreadcrumbItem {
		private final SimpleCallback callback;
		private final String caption;

		/**
		 * Creates a new {@link IBreadcrumbView.BreadcrumbItem} object.
		 * 
		 * @param callback
		 *            the callback is called when the user clicks on the item
		 * @param caption
		 *            the text that is shown
		 */
		public BreadcrumbItem(final SimpleCallback callback, final String caption) {
			super();
			this.callback = callback;
			this.caption = caption;
		}

		/**
		 * @return the callback handler that handles clicks
		 */
		public SimpleCallback getCallback() {
			return this.callback;
		}

		/**
		 * @return the text of the item
		 */
		public String getCaption() {
			return this.caption;
		}

	}

	/**
	 * sets the content.
	 * 
	 * @param breadcrumbItems
	 *            the item to be displayed
	 */
	void setContent(List<IBreadcrumbView.BreadcrumbItem> breadcrumbItems);

}
