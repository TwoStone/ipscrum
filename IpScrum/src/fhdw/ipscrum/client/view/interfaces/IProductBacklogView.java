package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;

import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface IProductBacklogView extends IView{

	public abstract HasClickHandlers getImgDoubleArrowUp();

	public abstract HasClickHandlers getImgArrowDown();

	public abstract HasClickHandlers getImgDoubleArrowDown();

	public abstract HasClickHandlers getImgDetails();

	public abstract HasClickHandlers getImgNewFile();

	public abstract HasClickHandlers getImgDelete();

	public abstract HasClickHandlers getImgArrowUp();

	public abstract CellTable<ProductBacklogItem> getTableProductBacklog();

	public abstract CellTable<ProductBacklogItem> getSelectedProductBacklogItem();

	public abstract void refreshProductBacklog(
			Vector<ProductBacklogItem> ProductBacklogItem);

}