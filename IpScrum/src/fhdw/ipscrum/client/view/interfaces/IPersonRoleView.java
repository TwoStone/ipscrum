package fhdw.ipscrum.client.view.interfaces;

import java.util.Set;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;

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
 */
public interface IPersonRoleView extends IView{

	/**
	 * Method getCellTablePersons.
	 * @return CellTable<IPerson>
	 */
	public abstract CellTable<IPerson> getCellTablePersons();

	/**
	 * Method getCellListAssignedRoles.
	 * @return CellList<IRole>
	 */
	public abstract CellList<IRole> getCellListAssignedRoles();

	/**
	 * Method defineNewPersonEventHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void defineNewPersonEventHandler(EventHandler<EventArgs> args);
	
	/**
	 * Method defineModifyPersonEventHandler.
	 * @param args EventHandler<PersonArgs>
	 */
	public abstract void defineModifyPersonEventHandler(EventHandler<PersonArgs> args);
	
	/**
	 * Method defineRemoveRoleFromPersonEventHandler.
	 * @param args EventHandler<AssociatePersonAndRoleArgs>
	 */
	public abstract void defineRemoveRoleFromPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);
	
	/**
	 * Method defineAddRoleToPersonEventHandler.
	 * @param args EventHandler<AssociatePersonAndRoleArgs>
	 */
	public abstract void defineAddRoleToPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);
	
	/**
	 * Method defineNewRoleEventHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void defineNewRoleEventHandler(EventHandler<EventArgs> args);
	
	/**
	 * Method defineRemoveRoleEventHandler.
	 * @param args EventHandler<MultipleRoleArgs>
	 */
	public abstract void defineRemoveRoleEventHandler(EventHandler<MultipleRoleArgs> args);
	
	/**
	 * Method getCellListRoles.
	 * @return CellList<IRole>
	 */
	public abstract CellList<IRole> getCellListRoles();
	
	/**
	 * Method getSelectedPerson.
	 * @return Person
	 */
	public abstract Person getSelectedPerson();
	
	/**
	 * Method getSelectedAssignedRole.
	 * @return Role
	 */
	public abstract Role getSelectedAssignedRole();
	
	/**
	 * Method getSelectedAvailRoles.
	 * @return Set<IRole>
	 */
	public abstract Set<IRole> getSelectedAvailRoles();

}