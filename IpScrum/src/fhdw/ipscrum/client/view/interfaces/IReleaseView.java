package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Image;

import fhdw.ipscrum.shared.model.Release;

public interface IReleaseView extends IView{

	public abstract Image getImgNewFile();

	public abstract Image getImgDetails();

	public abstract Image getImgDelete();

	public abstract CellTable<Release> getReleaseTable();

	public abstract CellTable<Release> getSelectedRelease();

	public abstract void refreshProjects(Vector<Release> Release);

}