package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface IReleaseDetailView extends IView{

	public abstract void addAddSprintEventHandler(EventHandler<EventArgs> arg);

	public abstract void refreshSprints(Vector<ISprint> sprints);

	public void addDeleteSprintEventHandler(EventHandler<SprintArgs> arg);

	public void addCancelReleaseDetailViewHandler(EventHandler<EventArgs> arg);

}