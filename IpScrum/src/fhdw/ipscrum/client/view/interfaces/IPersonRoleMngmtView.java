package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;

public interface IPersonRoleMngmtView extends IView {

	public abstract HasClickHandlers getButtonRight();

	public abstract HasClickHandlers getButtonLeft();

	public abstract HasClickHandlers getButtonPersonNew();

	public abstract HasClickHandlers getButtonPersonEdit();

	public abstract HasClickHandlers getButtonPersonDelete();

	public abstract HasClickHandlers getButtonRoleNew();

	public abstract HasClickHandlers getButtonRoleRename();

	public abstract HasClickHandlers getButtonRoleDelete();

	public abstract CellList getRoleList();
	public abstract CellTable getPersonTable();
}