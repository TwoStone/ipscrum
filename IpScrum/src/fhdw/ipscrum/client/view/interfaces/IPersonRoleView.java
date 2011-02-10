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

public interface IPersonRoleView extends IView{

	public abstract CellTable<IPerson> getCellTablePersons();

	public abstract CellList<IRole> getCellListAssignedRoles();

	public abstract void defineNewPersonEventHandler(EventHandler<EventArgs> args);
	
	public abstract void defineModifyPersonEventHandler(EventHandler<PersonArgs> args);
	
	public abstract void defineRemoveRoleFromPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);
	
	public abstract void defineAddRoleToPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args);
	
	public abstract void defineNewRoleEventHandler(EventHandler<EventArgs> args);
	
	public abstract void defineRemoveRoleEventHandler(EventHandler<MultipleRoleArgs> args);
	
	public abstract CellList<IRole> getCellListRoles();
	
	public abstract Person getSelectedPerson();
	
	public abstract Role getSelectedAssignedRole();
	
	public abstract Set<IRole> getSelectedAvailRoles();

}