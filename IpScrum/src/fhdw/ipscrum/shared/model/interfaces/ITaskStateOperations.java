package fhdw.ipscrum.shared.model.interfaces;

import java.util.Date;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * This interface defines a set of operations which are state-relevant for tasks
 */
public interface ITaskStateOperations {
	//TODO: Exceptions definieren!
	public void setName(String name) throws ForbiddenStateException, NoValidValueException;
	public void setDescription(String description) throws ForbiddenStateException, NoValidValueException;
	public void setResponsibility(IPerson responsiblePerson) throws ForbiddenStateException;
	public void finish() throws ForbiddenStateException;
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException;
	public void removePBI(ProductBacklogItem pbi) throws ForbiddenStateException;
	public boolean hasResponsiblePerson();
	public boolean isFinished();
	public IPerson getResponsiblePerson();
	public Date getFinishDate();
	
}
