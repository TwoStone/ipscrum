package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public interface ITaskDetailView extends IView {

	public String getName();
	public String getDescription();
	public IPerson getPerson();
	public Integer getEffort();
	public Boolean isFinished();
	public void refreshPBIs(Vector<ProductBacklogItem> pbis);
	public void refreshPersons(Vector<IPerson> pbis);

	public void setName(String name);
	public void setDescription(String description);
	public void setPerson(IPerson person);
	public void setEffort(Integer effort);
	public void setFinished(Boolean finish);
	
	public void initTaskView(ITask task);
	
	public abstract void initSpecificTaskView(ITask task);

	public void addOkayEventHandler(EventHandler<EventArgs> arg);
	public void addCancelEventHandler(EventHandler<EventArgs> arg);
	public void addAddPBIsEventHandler(EventHandler<MultiplePBIArgs> arg);
	public void addRemovePBIsEventHandler(EventHandler<MultiplePBIArgs> arg);

}
