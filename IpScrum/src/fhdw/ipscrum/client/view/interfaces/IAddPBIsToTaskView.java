package fhdw.ipscrum.client.view.interfaces;

import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface IAddPBIsToTaskView extends IView{

	public void refreshSprintPBIs(Vector<ProductBacklogItem> pbis);

	public void refreshTaskPBIs(Vector<ProductBacklogItem> pbis);

	public Set<ProductBacklogItem> getSelectedPBIs();

	public void addAddPBIsToTaskEventHandler(EventHandler<MultiplePBIArgs> handler);

	public void addCloseEventHandler(EventHandler<EventArgs> handler);
}