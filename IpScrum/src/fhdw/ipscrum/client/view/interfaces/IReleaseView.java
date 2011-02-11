package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.shared.model.Release;

public interface IReleaseView extends IView{

	public abstract void addReleaseDetailsEventHandler(EventHandler<ReleaseArgs> arg);
	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);
	public abstract void addDeleteReleaseEventHandler(EventHandler<ReleaseArgs> arg);
	
	
	public abstract void refreshReleases(HashSet<Release> release);

	
	
}