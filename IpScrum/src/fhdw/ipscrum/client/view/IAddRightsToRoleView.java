package fhdw.ipscrum.client.view;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * This represents the interface of the view which is needed to add rights to a role.
 */
public interface IAddRightsToRoleView extends IView {

	/**
	 * Updates the list which represents the roles added to the role.
	 * 
	 * @param rights
	 *            added to the role
	 */
	void setAddedRights(List<Right> rights);

	/**
	 * Updates the list which represents the roles to add to the role.
	 * 
	 * @param rights
	 *            to add to the role
	 */
	void setRightsToAdd(List<Right> rights);

	/**
	 * Represents the event needed for handling the addition of rights to a role.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerAdd(EventHandler<TypedEventArg<Right>> handler);

	/**
	 * Represents the event needed for handling the remove of rights to a role.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void registerRemove(EventHandler<TypedEventArg<Right>> handler);

}
