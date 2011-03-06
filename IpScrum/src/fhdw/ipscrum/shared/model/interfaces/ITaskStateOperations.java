package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.TaskInProgress;

/**
 * This interface defines a set of operations which are state-relevant for tasks
 */
public interface ITaskStateOperations extends Serializable {
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException, SprintAssociationException;

	public void finish() throws ForbiddenStateException;
	/**
	 * PRECONDITION: isFinished() == true
	 * @return date when the task has been finished.
	 */
	public Date getFinishDate();

	/**
	 * PRECONDITION: hasResponsiblePerson() == true
	 * 
	 * @return person responsible for the task
	 */
	public IPerson getResponsiblePerson();

	public boolean hasResponsiblePerson();

	public boolean isFinished();

	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException;

	public void setDescription(String description)
			throws ForbiddenStateException, NoValidValueException;

	public void setName(String name) throws ForbiddenStateException,
			NoValidValueException;

	/**
	 * POSTCONDITION: person is assigned to the task & state of task is
	 * {@link TaskInProgress}
	 * 
	 * @param responsiblePerson
	 * @throws ForbiddenStateException
	 * @throws SprintAssociationException 
	 */
	public void setResponsibility(IPerson responsiblePerson)
			throws ForbiddenStateException, SprintAssociationException;
	/**
	 * PRECONDITION: state of task must not be finished
	 * @param planEffort
	 * @throws ForbiddenStateException
	 */
	public void setPlanEffort(Integer planEffort) throws ForbiddenStateException;

}
