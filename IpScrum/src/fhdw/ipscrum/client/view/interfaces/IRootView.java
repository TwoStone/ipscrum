package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Panel;

/**
 */
public interface IRootView extends IView{

	/**
	 * Method getBtnLogin.
	 * @return HasClickHandlers
	 */
	public abstract HasClickHandlers getBtnLogin();

	/**
	 * Method getInputPassword.
	 * @return HasText
	 */
	public abstract HasText getInputPassword();

	/**
	 * Method getInputUserName.
	 * @return HasText
	 */
	public abstract HasText getInputUserName();

	/**
	 * Method getButtonLogout.
	 * @return HasClickHandlers
	 */
	public abstract HasClickHandlers getButtonLogout();
	
	/**
	 * Method getContentPanel.
	 * @return Panel
	 */
	public abstract Panel getContentPanel();
	
	public abstract void deactivateLogin();
	
	public abstract void activateLogin();
	
}