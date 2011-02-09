package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;


public interface IRoleDialogView extends IView{

	public abstract HasText getRole();

	public abstract HasClickHandlers getOk_button();

	public abstract HasClickHandlers getAbb_button_1();

}