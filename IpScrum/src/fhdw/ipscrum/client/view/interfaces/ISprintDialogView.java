package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

public interface ISprintDialogView {

	public abstract DateBox getStart();

	public abstract DateBox getEnd();

	public abstract ListBox getTeams();

	public abstract Button getZuordnen_button();

	public abstract Button getOk_button();

	public abstract Button getAbb_button();

}