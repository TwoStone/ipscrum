package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Panel;

public interface IRootView extends IView{

	public abstract HasClickHandlers getBtnLogin();

	public abstract HasText getInputPassword();

	public abstract HasText getInputUserName();

	public abstract HasClickHandlers getButtonLogout();
	
	public abstract Panel getContentPanel();
	
	public abstract void deactivateLogin();
	
	public abstract void activateLogin();
	
}