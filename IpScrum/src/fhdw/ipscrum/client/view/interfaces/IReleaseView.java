package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Image;

import fhdw.ipscrum.shared.model.Release;

public interface IReleaseView extends IView{

	public abstract HasClickHandlers getImgNewFile();

	public abstract HasClickHandlers getImgDetails();

	public abstract HasClickHandlers getImgDelete();

	public abstract CellTable<Release> getReleaseTable();

	public abstract CellTable<Release> getSelectedRelease();

	public abstract void refreshReleases(Vector<Release> Release);

}