package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.user.cellview.client.AbstractHasData;
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

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ProductBacklogView extends Composite implements
		IProductBacklogView {

	// ########## Events #############
	private final Event<EventArgs> newPBIEvent = new Event<EventArgs>();

	// ###### Ende Events ###########

	private Image imgDoubleArrowUp;
	private Image imgArrowDown;
	private Image imgDoubleArrowDown;
	private Image imgDetails;
	private Image imgNewFile;
	private Image imgDelete;
	private Image imgArrowUp;
	private CellTable<ProductBacklogItem> tableProductbacklog;
	private Label lblAktionen;

	public static IProductBacklogView createView() {
		return new ProductBacklogView();
	}

	public ProductBacklogView() {

		FlowPanel concreteProductBacklogPanel = new FlowPanel();
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
		bezeichnung.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		tableProductbacklog.addColumn(bezeichnung, "Bezeichnung");

		TextColumn<ProductBacklogItem> aufwand = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem pbi) {
				return pbi.getManDayCosts().toString();
			}
		};
		aufwand.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		aufwand.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		tableProductbacklog.addColumn(aufwand, "Aufwand (in PT)");
		tableProductbacklog.setSize("335px", "268px");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("box");
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.add(verticalPanel, 351, 68);
		verticalPanel.setSize("139px", "165px");

		Grid pbMenu = new Grid(4, 2);
		verticalPanel.add(pbMenu);
		pbMenu.setCellSpacing(5);
		pbMenu.setCellPadding(5);
		pbMenu.setSize("139px", "119px");

		imgDoubleArrowUp = new Image("images/toparrow.png");
		pbMenu.setWidget(0, 0, imgDoubleArrowUp);

		imgNewFile = new Image("images/newfile.png");
		imgNewFile.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				newPBIEvent.fire(ProductBacklogView.this, new EventArgs());
			}
		});
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

		Label lblProductBacklog = new Label("Product Backlog Eintr\u00E4ge");
		lblProductBacklog.setStyleName("LabelElement");
		horizontalPanel.add(lblProductBacklog, 10, 10);

		lblAktionen = new Label("Aktionen");
		lblAktionen.setStyleName("LabelElement");
		horizontalPanel.add(lblAktionen, 351, 39);
		lblAktionen.setSize("122px", "23px");
	}

	@Override
	public void addDeletePBIEventHandler(EventHandler<PBIArgs> arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewPBIEventHandler(EventHandler<EventArgs> arg) {
		newPBIEvent.add(arg);
	}

	@Override
	public void addPBIBottomEventHandler(EventHandler<PBIArgs> arg) {
		// TODO Auto-generated method stub

	}

	public void addPBIDetailsEventHandler(
			fhdw.ipscrum.client.events.EventHandler<PBIArgs> arg) {

	};

	@Override
	public void addPBIDownEventHandler(EventHandler<PBIArgs> arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPBITopEventHandler(EventHandler<PBIArgs> arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPBIUpEventHandler(EventHandler<PBIArgs> arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshProductBacklog(
			Vector<ProductBacklogItem> ProductBacklogItem) {
		this.getTableProductBacklog().setRowData(ProductBacklogItem);
	}

	private AbstractHasData<ProductBacklogItem> getTableProductBacklog() {
		return this.tableProductbacklog;
	}
}
