package fhdw.ipscrum.client.view;

import java.util.ArrayList;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.shared.model.ProductBacklogItem;



public class ProductBacklogView  extends Composite{
	public ProductBacklogView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("800", "400");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSize("450", "250");
		horizontalPanel.setSpacing(20);
		flowPanel.add(horizontalPanel);
		
		CellTable<ProductBacklogItem> cellTable = new CellTable<ProductBacklogItem>();
		horizontalPanel.add(cellTable);
		horizontalPanel.setCellVerticalAlignment(cellTable, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(cellTable, HasHorizontalAlignment.ALIGN_CENTER);
		
		TextColumn textColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem pbi) {
				return pbi.getName();
			}
		};
		textColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		textColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		cellTable.addColumn(textColumn, "Bezeichnung");
		
		TextColumn textColumn_1 = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem pbi) {
				return pbi.getManDayCosts().toString();
			}
		};
		textColumn_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		textColumn_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		cellTable.addColumn(textColumn_1, "Aufwand (in PT)");
		cellTable.setSize("251px", "154px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setHeight("52px");
		verticalPanel.add(verticalPanel_1);
		
		Grid grid = new Grid(4, 2);
		verticalPanel.add(grid);
		grid.setCellSpacing(5);
		grid.setCellPadding(5);
		grid.setSize("139px", "119px");
		
		Image image = new Image("images/toparrow.png");
		grid.setWidget(0, 0, image);
		
		Image image_6 = new Image("images/newfile.png");
		grid.setWidget(0, 1, image_6);
		
		Image image_2 = new Image("images/uparrow.png");
		grid.setWidget(1, 0, image_2);
		
		Image image_5 = new Image("images/details.png");
		grid.setWidget(1, 1, image_5);
		
		Image image_1 = new Image("images/downarrow.png");
		grid.setWidget(2, 0, image_1);
		
		Image image_4 = new Image("images/delete.png");
		grid.setWidget(2, 1, image_4);
		
		Image image_3 = new Image("images/bottomarrow.png");
		grid.setWidget(3, 0, image_3);
		
		Image image_7 = new Image("images/save.png");
		grid.setWidget(3, 1, image_7);
		
		ProductBacklogItem pbi1 = new ProductBacklogItem("PBI Controller", 3,null) {
		};
		
		ProductBacklogItem pbi2 = new ProductBacklogItem("Feature GUI", 9,null) {
		};
		
		ArrayList list = new ArrayList();
		list.add(pbi1);
		list.add(pbi2);

		cellTable.setRowData(list);
	}

	
	
}
