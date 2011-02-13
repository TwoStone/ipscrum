package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface IProductBacklogView extends IView{

	/**
	 * Method addPBIUpEventHandler
	 * Use this to register a handler for an event 
	 * which moves a {@link ProductBacklogItem} in the table up by one step 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBIUpEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addPBIDownEventHandler
	 * Use this to register a handler for an event 
	 * which moves a {@link ProductBacklogItem} in the table down by one step
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBIDownEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addPBITopEventHandler
	 * Use this to register a handler for an event 
	 * which moves a {@link ProductBacklogItem} to the top of the table
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBITopEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addPBIBottomEventHandler
	 * Use this to register a handler for an event 
	 * which moves a {@link ProductBacklogItem} to the bottom of the table
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBIBottomEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addPBIDetailsEventHandler
	 * Use this to register a handler for an event 
	 * which shows the Details of a {@link ProductBacklogItem} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBIDetailsEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addNewPBIEventHandler
	 * Use this to register a handler for an event 
	 * which creates a new {@link ProductBacklogItem} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addNewPBIEventHandler(EventHandler<EventArgs> arg);
	
	/**
	 * Method addDeletePBIEventHandler
	 * Use this to register a handler for an event 
	 * which deletes a {@link ProductBacklogItem} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addDeletePBIEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method addPBISelectedEventHandler
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addPBISelectedEventHandler(EventHandler<PBIArgs> arg);
	
	/**
	 * Method refreshProductBacklog
	 * Refreshes the {@link ProductBacklog} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void refreshProductBacklog(
			Vector<ProductBacklogItem> ProductBacklogItem);

}