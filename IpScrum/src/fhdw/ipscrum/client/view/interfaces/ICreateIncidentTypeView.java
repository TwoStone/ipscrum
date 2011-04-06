package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ICreateIncidentTypeView extends IView {

	String getName();
	
	public void addCreateTypeHandler(EventHandler<EventArgs> args);

	public void addCancelEventHandler(EventHandler<EventArgs> args);
	
}
