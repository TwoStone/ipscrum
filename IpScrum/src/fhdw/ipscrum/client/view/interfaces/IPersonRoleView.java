package fhdw.ipscrum.client.view.interfaces;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.events.args.MultipleRoleArgs;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * This view is intended to be a central management console for persons and roles.
 * It provides controls for creating, modifying and deleting persons and roles as well associate roles to persons or remove associations.
 */
public interface IPersonRoleView extends IView{

	/**
	 * This method is used to fill or update the list of persons displayed.
	 * @param personSet a set of persons (IPerson)
	 */
	public abstract void updatePersonTable(HashSet<IPerson> personSet);

	/**
	 * This method is used to fill or update the list of assigned roles to the selected person.
	 * @param roleList a list of assigned roles (IRole)
	 */
	public abstract void updateAssignedRoles(Vector<IRole> roleList);

	/**
	 * This method is used to fill or update the list of available roles.
	 * @param roleSet a set of available roles (IRole)
	 */
	public abstract void updateAvailRoleList(HashSet<IRole> roleSet);

	/**
	 * Use this to define what happens if the Create-Person-Button is clicked.
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void defineNewPersonEventHandler(EventHandler<EventArgs> args);

	/**
	 * Use this to define what happens if the Modify-Person-Button is clicked.
	 * @param args EventHandler<PersonArgs> the Person to be modified
	 */
	public abstract void defineModifyPersonEventHandler(EventHandler<PersonArgs> args);

	/**
	 * Use this to define what happens if the user wants to remove roles from a person.
	 * @param args EventHandler<AssociatePersonAndRoleArgs> person and set of roles
	 */
	public abstract void defineRemoveRoleFromPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);

	/**
	 * Use this to define what happens if the user wants to add roles to a person
	 * @param args EventHandler<AssociatePersonAndRoleArgs> person and set of roles
	 */
	public abstract void defineAddRoleToPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);

	/**
	 * Use this to define what happens if the Create-Role-Button is clicked.
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void defineNewRoleEventHandler(EventHandler<EventArgs> args);

	/**
	 * Use this to define what happens if the Remove-Role-Button is clicked.
	 * @param args EventHandler<MultipleRoleArgs> contains a set of roles.
	 */
	public abstract void defineRemoveRoleEventHandler(EventHandler<MultipleRoleArgs> args);

	/**
	 * This method is used to obtain the selected person of the person-table.
	 * @return Person the selected person
	 */
	public abstract Person getSelectedPerson();

	/**
	 * This method is used to obtain the selected role from the assigned-roles-list.
	 * @return Role assigned role
	 */
	public abstract Role getSelectedAssignedRole();

	/**
	 * This method is used to obtain the set of selected roles from the available-roles-list.
	 * @return Set<IRole> a set of selected roles.
	 */
	public abstract Set<IRole> getSelectedAvailRoles();

}