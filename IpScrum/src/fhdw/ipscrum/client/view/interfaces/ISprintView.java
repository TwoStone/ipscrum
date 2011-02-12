package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface ISprintView extends IView {

	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);

	void addSprintDetailsEventHandler(
			EventHandler<fhdw.ipscrum.client.view.SprintArgs> arg);

	void addDeleteReleaseEventHandler(
			EventHandler<fhdw.ipscrum.client.view.SprintArgs> arg);

	void refreshSprints(Vector<ISprint> sprints);
	
}
