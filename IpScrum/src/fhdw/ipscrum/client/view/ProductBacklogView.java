package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;




public class ProductBacklogView  extends Composite implements IProductBacklogView{
	private Image imgDoubleArrowUp;
	private Image imgArrowDown;
	private Image imgDoubleArrowDown;
	private Image imgDetails;
	private Image imgNewFile;
	private Image imgDelete;
	private Image imgArrowUp;
	private CellTable<ProductBacklogItem> tableProductbacklog;
	
	public static IProductBacklogView createView(){
		return new ProductBacklogView();
	}
	
	public ProductBacklogView() {
		
		FlowPanel concreteProductBacklogPanel = new FlowPanel();
		concreteProductBacklogPanel.setStyleName("box");
		initWidget(concreteProductBacklogPanel);
		concreteProductBacklogPanel.setSize("500px", "600px");
		
		AbsolutePanel horizontalPanel = new AbsolutePanel();
		horizontalPanel.setSize("500px", "600px");
		concreteProductBacklogPanel.add(horizontalPanel);
		
		tableProductbacklog = new CellTable<ProductBacklogItem>();
		horizontalPanel.add(tableProductbacklog, 10, 39);
		
		TextColumn<ProductBacklogItem> bezeichnung = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem pbi) {
				return pbi.getName();
			}
		};
		bezeichnung.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		bezeichnung.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		tableProductbacklog.addColumn(bezeichnung, "Bezeichnung");
		
		TextColumn<ProductBacklogItem> aufwand = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem pbi) {
				return pbi.getManDayCosts().toString();
			}
		};
		aufwand.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		aufwand.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		tableProductbacklog.addColumn(aufwand, "Aufwand (in PT)");
		tableProductbacklog.setSize("335px", "268px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("box");
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.add(verticalPanel, 351, 39);
		verticalPanel.setSize("139px", "165px");
		
		Grid pbMenu = new Grid(4, 2);
		verticalPanel.add(pbMenu);
		pbMenu.setCellSpacing(5);
		pbMenu.setCellPadding(5);
		pbMenu.setSize("139px", "119px");
		
		imgDoubleArrowUp = new Image("images/toparrow.png");
		pbMenu.setWidget(0, 0, imgDoubleArrowUp);
		
		
		imgNewFile = new Image("images/newfile.png");
		pbMenu.setWidget(0, 1, imgNewFile);
		
		imgArrowUp = new Image("images/uparrow.png");
		pbMenu.setWidget(1, 0, imgArrowUp);
		
		imgDetails = new Image("images/details.png");
		pbMenu.setWidget(1, 1, imgDetails);
		
		imgArrowDown = new Image("images/downarrow.png");
		pbMenu.setWidget(2, 0, imgArrowDown);
		
		imgDoubleArrowDown = new Image("images/bottomarrow.png");
		pbMenu.setWidget(3, 0, imgDoubleArrowDown);
		
		imgDelete = new Image("images/delete.png");
		pbMenu.setWidget(3, 1, imgDelete);
		
		Label lblProductBacklog = new Label("Product Backlog");
		horizontalPanel.add(lblProductBacklog, 10, 10);
	}

	
	

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgDoubleArrowUp()
	 */
	@Override
	public HasClickHandlers getImgDoubleArrowUp() {
		return imgDoubleArrowUp;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgArrowDown()
	 */
	@Override
	public HasClickHandlers getImgArrowDown() {
		return imgArrowDown;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgDoubleArrowDown()
	 */
	@Override
	public HasClickHandlers getImgDoubleArrowDown() {
		return imgDoubleArrowDown;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgDetails()
	 */
	@Override
	public HasClickHandlers getImgDetails() {
		return imgDetails;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgNewFile()
	 */
	@Override
	public HasClickHandlers getImgNewFile() {
		return imgNewFile;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgDelete()
	 */
	@Override
	public HasClickHandlers getImgDelete() {
		return imgDelete;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getImgArrowUp()
	 */
	@Override
	public HasClickHandlers getImgArrowUp() {
		return imgArrowUp;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getTableProductBacklog()
	 */
	@Override
	public CellTable<ProductBacklogItem> getTableProductBacklog() {
		return tableProductbacklog;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#getSelectedProductBacklogItem()
	 */
	@Override
	public CellTable<ProductBacklogItem> getSelectedProductBacklogItem(){
		return tableProductbacklog;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IProductBacklogView#refreshProductBacklog(java.util.Vector)
	 */
	@Override
	public void refreshProductBacklog(Vector<ProductBacklogItem> ProductBacklogItem) {
		this.getTableProductBacklog().setRowData(ProductBacklogItem);
	}
}
