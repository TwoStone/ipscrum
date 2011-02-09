package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;


public interface IRoleDialogView extends IView{

	public abstract HasText getRole();

	public abstract void addOkEventHandler(EventHandler<EventArgs> args);

	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}