package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.PBIArgs;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.ProductBacklogView).
 */
public interface IProductBacklogView extends IView {

	/**
	 * Represents the Event to handle the delete of a PBI.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the PBI to delete
	 */
	void deletePBIEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the addition of a new ticket.
	 * 
	 * @param arg
	 *            needed to handle the event
	 */
	void addNewTicketEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Represents the Event to handle the decrease of the PBI to the bottom.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBIBottomEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the to show the PBI details.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBIDetailsEventHandler(
			fhdw.ipscrum.client.architecture.events.EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the decrease the priority of a PBI.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBIDownEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the increase of the PBI to the top.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBITopEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the increase of the priority of a PBI.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBIUpEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the selection of a PBI.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBISelectedEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Represents the Event to handle the edit of a PBI.
	 * 
	 * @param arg
	 *            needed to handle the event, which also knows the related PBI
	 */
	void addPBIEditEventHandler(EventHandler<PBIArgs> arg);

	/**
	 * Displays the list of the active ProductBacklogTable.
	 * 
	 * @param pbiSet
	 *            is the list of PBIs not in an end state
	 */
	void updateActiveProductBacklogTable(List<ProductBacklogItem> pbiSet);

	/**
	 * displays the list of the inactive ProductBacklogTable.
	 * 
	 * @param pbiSet
	 *            is the list of PBIs in an end state
	 */
	void updateInactiveProductBacklogTable(List<ProductBacklogItem> pbiSet);

	/**
	 * Represents the Event to handle the switch to the project details.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the switch, and also knows the project to switch to
	 */
	EventRegistration registerGotoProjectHandler(
			EventHandler<TypedEventArg<Project>> handler);

	/**
	 * sets the project the ProductBacklog is related to.
	 * 
	 * @param project
	 *            related to the backlog
	 */
	void setProject(Project project);

	/**
	 * getter of the selected PBI.
	 * 
	 * @return the curretnly selected PBI
	 */
	ProductBacklogItem getSelectedPBI();

}
