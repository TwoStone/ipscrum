package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public interface IReleaseView extends IView{

	public abstract void addReleaseDetailsEventHandler(EventHandler<ReleaseArgs> arg);
	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);
	public abstract void addDeleteReleaseEventHandler(EventHandler<fhdw.ipscrum.client.events.args.ReleaseArgs> args);
	
	
	public abstract void refreshReleases(HashSet<IRelease> release);

	
	
}