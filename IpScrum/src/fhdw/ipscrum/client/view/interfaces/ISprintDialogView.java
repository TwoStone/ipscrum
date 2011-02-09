package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

public interface ISprintDialogView extends IView{

	public abstract DateBox getStart();

	public abstract DateBox getEnd();

	public abstract ListBox getTeams();

	public abstract HasClickHandlers getZuordnen_button();

	public abstract HasClickHandlers getOk_button();

	public abstract HasClickHandlers getAbb_button();

}