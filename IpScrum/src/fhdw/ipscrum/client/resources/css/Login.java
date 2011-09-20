package fhdw.ipscrum.client.resources.css;

import com.google.gwt.resources.client.CssResource;

/**
 * Represents the css resource of the login.
 */
public interface Login extends CssResource {

	/**
	 * @return the css of the widget button.
	 */
	@ClassName("login-widget-button")
	String loginWidgetButton();

	/**
	 * @return the css of the login widget error.
	 */
	@ClassName("login-widget-error")
	String loginWidgetError();

	/**
	 * @return the css of the login widget message.
	 */
	@ClassName("login-widget-message")
	String loginWidgetMessage();

	/**
	 * @return the css of the login widget glass.
	 */
	@ClassName("login-widget-glass")
	String loginWidgetGlass();

	/**
	 * @return the css of the login widget container.
	 */
	@ClassName("login-widget-container")
	String loginWidgetContainer();

	/**
	 * @return the css of the login widget label.
	 */
	@ClassName("login-widget-label")
	String loginWidgetLabel();

	/**
	 * @return the css of the login widget textbox.
	 */
	@ClassName("login-widget-textbox")
	String loginWidgetTextbox();

	/**
	 * @return the css of the login widget popup
	 */
	@ClassName("login-widget-popup")
	String loginWidgetPopup();

}
