package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.cellview.client.CellTable;

import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface ISprintTableView {

	public abstract Sprint getCurrentlySelected();

	public abstract void refreshSprints(Vector<ISprint> sprints);

	public abstract CellTable<ISprint> getTableSprint();

}