package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.TaskInProgress;

/**
 * This interface defines a set of operations which are state-relevant for tasks
 */
public interface ITaskStateOperations extends Serializable {
	/**
	 * Adds a new product backlog item to the task. then the task represents an activity for implementing this PBI.
	 * @param pbi
	 * @throws ForbiddenStateException will be raised if the task is already finished.
	 * @throws SprintAssociationException will be raised if the PBI doesn't match to the sprint, 
	 * to which the task belongs to
	 * @throws DoubleDefinitionException 
	 */
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException, SprintAssociationException, DoubleDefinitionException;
	/**
	 * 
	 * @throws ForbiddenStateException
	 */
	public void finish() throws ForbiddenStateException;
	/**
	 * 
	 * @param finishDate
	 * @throws ForbiddenStateException
	 */
	public void finish(Date finishDate) throws ForbiddenStateException;
	
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
	
	/**
	 * @return true, whether the task has already a responsible person
	 */
	public boolean hasResponsiblePerson();
	/**
	 * @return true, if the task workflow is finished
	 */
	public boolean isFinished();
	/**
	 * removes a product backlog item from the task.
	 * @param pbi the item to be deleted
	 * @throws ForbiddenStateException will be raised if the task is already finished.
	 */
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException;
	/**
	 * passes a description to the task.
	 * @param description the new description
	 * @throws ForbiddenStateException will be raised if the task is already finished.
	 * @throws NoValidValueException will be raised if the description is empty.
	 */
	public void setDescription(String description)
			throws ForbiddenStateException, NoValidValueException;
	/**
	 * passes a name to the task.
	 * @param name the new name
	 * @throws ForbiddenStateException will be raised if the task is already finished.
	 * @throws NoValidValueException will be raised if the name is empty.
	 */
	public void setName(String name) throws ForbiddenStateException,
			NoValidValueException;

	/**
	 * POSTCONDITION: person is assigned to the task & state of task is
	 * {@link TaskInProgress}
	 * 
	 * @param responsiblePerson
	 * @throws ForbiddenStateException will be raised if the task is already finished.
	 * @throws SprintAssociationException will be raised if the person doesn't match to the sprint team
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
