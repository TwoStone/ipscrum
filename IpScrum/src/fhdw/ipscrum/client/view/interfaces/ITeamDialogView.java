package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;

public interface ITeamDialogView extends IView {

	public abstract TextBox getTeamDescription();

	public abstract void addOkEventHandler(EventHandler<OneStringArgs> args);

	public abstract void addCancelEventHandler(EventHandler<EventArgs> args);

}