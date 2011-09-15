package fhdw.ipscrum.client.resources.css;

import com.google.gwt.resources.client.CssResource;

public interface Toast extends CssResource {

	String message();

	@ClassName("toast-message-container")
	String toastMessageContainer();

	@ClassName("state-label")
	String stateLabel();

	@ClassName("toast-panel")
	String toastPanel();

	@ClassName("gwt-Button")
	String gwtButton();

}
