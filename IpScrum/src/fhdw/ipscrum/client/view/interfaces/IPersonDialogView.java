package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public interface IPersonDialogView {

	public abstract Button getAbb_button();

	public abstract TextBox getVorname();

	public abstract TextBox getNachname();

	public abstract Button getOk_button();

}