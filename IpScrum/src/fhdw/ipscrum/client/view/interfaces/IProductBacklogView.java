package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface IProductBacklogView extends IView{

	public abstract void addPBIUpEventHandler(EventHandler<PBIArgs> arg);
	public abstract void addPBIDownEventHandler(EventHandler<PBIArgs> arg);
	public abstract void addPBITopEventHandler(EventHandler<PBIArgs> arg);
	public abstract void addPBIBottomEventHandler(EventHandler<PBIArgs> arg);
	public abstract void addPBIDetailsEventHandler(EventHandler<PBIArgs> arg);
	public abstract void addNewPBIEventHandler(EventHandler<EventArgs> arg);
	public abstract void addDeletePBIEventHandler(EventHandler<PBIArgs> arg);
	
	public abstract void addPBISelectedEventHandler(EventHandler<PBIArgs> arg);
	
	public abstract void refreshProductBacklog(
			Vector<ProductBacklogItem> ProductBacklogItem);

}