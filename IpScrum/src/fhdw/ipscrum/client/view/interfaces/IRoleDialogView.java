package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.events.args.SingleRoleArgs;


public interface IRoleDialogView extends IView{

	public abstract HasText getRole();

	public abstract void addOkEventHandler(EventHandler<OneStringArgs> args);

	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}