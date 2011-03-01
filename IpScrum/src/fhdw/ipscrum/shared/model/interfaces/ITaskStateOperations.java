package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * This interface defines a set of operations which are state-relevant for tasks
 */
public interface ITaskStateOperations {
	//TODO: Exceptions definieren!
	public void setName(String name);
	public void setPBI(ProductBacklogItem pbi);
	public void setResponsibility(IPerson responsiblePerson);
	public void finish();
;
	
	public IPerson getResponsiblePerson();
}
