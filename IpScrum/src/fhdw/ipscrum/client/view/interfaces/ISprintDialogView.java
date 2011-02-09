package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ISprintDialogView extends IView{

	public abstract DateBox getStart();

	public abstract DateBox getEnd();

	public abstract ListBox getTeams();

	public abstract void addRelateHandler(EventHandler<EventArgs> args);

	public abstract void addOkHandler(EventHandler<EventArgs> args);

	public abstract void addCancelHandler(EventHandler<EventArgs> args);

}