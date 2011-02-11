package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;

public interface ISprintView extends IView {

	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);

	void addSprintDetailsEventHandler(
			EventHandler<fhdw.ipscrum.client.view.SprintArgs> arg);

	void addDeleteReleaseEventHandler(
			EventHandler<fhdw.ipscrum.client.view.SprintArgs> arg);
	
}
