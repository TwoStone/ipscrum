package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;

public interface IPersonDialogView extends IView {

	public abstract HasClickHandlers getAbb_button();

	public abstract HasText getVorname();

	public abstract HasText getNachname();

	public abstract HasClickHandlers getOk_button();

}