package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.TwoStringArgs;

public interface IPersonDialogView extends IView {

	public abstract HasText getVorname();

	public abstract HasText getNachname();

	public abstract void defineCommitEventHandler(EventHandler<TwoStringArgs> args);

	public abstract void defineCancelEventHandler(EventHandler<EventArgs> args);

}