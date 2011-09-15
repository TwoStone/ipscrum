package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.eventargs.MultipleRoleArgs;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.PersonRoleView).
 */
public interface IPersonRoleView extends IView {

	/**
	 * Represents the Event to create a new person.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewPersonEventHandler(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle edit a person.
	 * 
	 * @param args
	 *            needed to handle the event, which knows the person to edit
	 */
	void defineModifyPersonEventHandler(EventHandler<TypedEventArg<Person>> args);

	/**
	 * Represents the Event to handle the edit the rights.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the involved role
	 */
	void defineEditRightsEventHander(EventHandler<TypedEventArg<Role>> handler);

	/**
	 * Represents the Event to handle to remove a role from a person.
	 * 
	 * @param args
	 *            needed to handle the event, which also knows the related person and role
	 */
	void defineRemoveRoleFromPersonEventHandler(
			EventHandler<AssociatePersonAndRoleArgs> args);

	/**
	 * Represents the Event to handle to add roles to a person.
	 * 
	 * @param args
	 *            needed to handle the event, which also knows the related roles and
	 *            person
	 */
	void
			defineAddRoleToPersonEventHandler(
					EventHandler<AssociatePersonAndRoleArgs> args);

	/**
	 * Represents the Event to handle the creation of a new person.
	 * 
	 * @param handler
	 *            needed to handle the event
	 */
	void defineNewRoleEventHandler(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the remove of a role.
	 * 
	 * @param args
	 *            needed to handle the event
	 */
	void defineRemoveRoleEventHandler(EventHandler<MultipleRoleArgs> args);

	/**
	 * gets the currently selected person.
	 * 
	 * @return the selected person
	 */
	Person getSelectedPerson();

	/**
	 * getter of the currently selected assigned roles of the currently selected person.
	 * 
	 * @return the selected roles
	 */
	Role getSelectedAssignedRole();

	/**
	 * getter of the currently selected available roles.
	 * 
	 * @return the selected roles
	 */
	List<Role> getSelectedAvailRoles();

	/**
	 * this method updates the person list in the view.
	 * 
	 * @param persons
	 *            already existing in the IPScrum
	 */
	void updatePersonTable(List<Person> persons);

	/**
	 * this method updates the role list of the available roles.
	 * 
	 * @param roles
	 *            are all roles available in the IPScrum
	 */
	void updateAvailRoleList(List<Role> roles);

	/**
	 * updates the assigned roles of a person, which is attached to the selected person.
	 */
	void updateAssignedRoleDisplay();

}
