package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ICreateReleaseView extends IView{

	public abstract void addSaveVersionHandler(EventHandler<EventArgs> args);

	public abstract String getReleaseVersion();

	public abstract void addCancelCreateReleaseHandler(
			EventHandler<EventArgs> args);

	public abstract DateBox getDateBox();

}