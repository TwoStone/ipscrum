package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface ISprintView extends IView {

	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);

	void addSprintDetailsEventHandler(
			EventHandler<SprintArgs> arg);

	void addDeleteReleaseEventHandler(
			EventHandler<SprintArgs> arg);

	void refreshSprints(Vector<ISprint> sprints);
	
}
