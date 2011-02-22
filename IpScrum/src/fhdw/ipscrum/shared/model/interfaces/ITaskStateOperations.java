package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * This interface defines a set of operations which are state-relevant for tasks
 */
public interface ITaskStateOperations {
	//TODO: Exceptions definieren!
	public void setResponsibility(IPerson responsiblePerson);
	public void changeResponsibility(IPerson responsiblePerson);
	public void close();
	public void changeName(String name);
	
	public IPerson getResponsiblePerson();
	public ISprint getAssignedSprint();
	
	public void addBacklogItem( ProductBacklogItem pbi);
	public void removeBacklogItem (ProductBacklogItem pbi);
}
