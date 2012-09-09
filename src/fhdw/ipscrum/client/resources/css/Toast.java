package fhdw.ipscrum.client.resources.css;

import com.google.gwt.resources.client.CssResource;

/**
 * Represents the css resource of the toast.
 */
public interface Toast extends CssResource {

	/**
	 * represents the message shown in the toast.
	 * 
	 * @return the shown message
	 */
	String message();

	/**
	 * @return the css of the toast message container.
	 */
	@ClassName("toast-message-container")
	String toastMessageContainer();

	/**
	 * @return the css of the state label.
	 */
	@ClassName("state-label")
	String stateLabel();

	/**
	 * @return the css of the toast panel.
	 */
	@ClassName("toast-panel")
	String toastPanel();

	/**
	 * @return the css of the gwt button.
	 */
	@ClassName("gwt-Button")
	String gwtButton();

}
