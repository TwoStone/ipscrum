package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;

public interface ISprintDialogView extends IView{

	public abstract DateBox getStart();

	public abstract DateBox getEnd();

	public abstract ListBox getTeams();
	
	public abstract HasText getDescription();

	public abstract void addOkHandler(EventHandler<SprintArgs> args);

	public abstract void addCancelHandler(EventHandler<EventArgs> args);

}