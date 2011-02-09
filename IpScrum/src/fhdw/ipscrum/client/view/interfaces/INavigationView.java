package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface INavigationView extends IView{

	public abstract void addProjectEventHandler(EventHandler<EventArgs> arg);
	public abstract void addPersonEventHandler(EventHandler<EventArgs> arg);
	public abstract void addTeamEventHandler(EventHandler<EventArgs> arg);
	
	public abstract Panel getContentPanel();
}
