package fhdw.ipscrum.client.architecture.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * represents all views in the IPScrum.
 */
public interface IView extends IsWidget {

	/**
	 * is needed for close a view.
	 */
	void close();

	void setRightVisibility(Boolean value);
}
