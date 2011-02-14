package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.cellview.client.CellTable;

import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface ISprintTableView {

	/**
	 * Method getCurrentlySelected
	 * Returns the currently selected {@link Sprint}
	 * @return Sprint
	 */
	public abstract Sprint getCurrentlySelected();

	public abstract void refreshSprints(Vector<ISprint> sprints);

	
	/**
	 * Method getTableSprint
	 * Returns celltable with type {@link ISprint}
	 * @return CellTable
	 */
	public abstract CellTable<ISprint> getTableSprint();

}