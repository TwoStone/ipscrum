package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public interface IPersonRoleView extends IView{

	public abstract CellTable<IPerson> getCellTablePersons();

	public abstract CellList<IRole> getCellListAssignedRoles();

	public abstract HasClickHandlers getBtnPersonNew();

	public abstract HasClickHandlers getBtnPersonModify();

	public abstract HasClickHandlers getBtnPersonRemove();

	public abstract HasClickHandlers getButtonRemoveRoleFromPerson();

	public abstract HasClickHandlers getButtonAddRoleToPerson();

	public abstract HasClickHandlers getBtnRoleNew();

	public abstract HasClickHandlers getBtnRoleRemove();

	public abstract CellList<IRole> getCellListRoles();

}