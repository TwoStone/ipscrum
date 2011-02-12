package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;


/**
 */
public interface IRootView extends IView{

	public abstract void fillComboBoxUsers(ArrayList<IPerson> tempUserList);

	public abstract void activateLogin();

	public abstract void deactivateLogin();

	public abstract VerticalPanel getContentPanel();

	public void defineLoginEvent(EventHandler<PersonArgs> args);

	public void defineLogoutEvent(EventHandler<EventArgs> args);

}