package fhdw.ipscrum.client.view;

import java.util.Vector;

import org.apache.tools.ant.Project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ProductBacklogView extends Composite implements
		IProductBacklogView {

	// ########## Events #############
	private final Event<EventArgs> newPBIEvent = new Event<EventArgs>();
	private final Event<PBIArgs> detailPBIEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiSelectedEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> deleteSelectedEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiDownEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiBottomEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiUpEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiTopEvent = new Event<PBIArgs>();
	
	// ###### Ende Events ###########

	// TMP Arguments
	private ProductBacklogItem currentlySelected;
	
	private Image imgDoubleArrowUp;
	private Image imgArrowDown;
	private Image imgDoubleArrowDown;
	private Image imgDetails;
	private Image imgNewFile;
	private Image imgDelete;
	private Image imgArrowUp;
	private CellTable<ProductBacklogItem> tableProductbacklog;
	private Label lblAktionen;
	private ScrollPanel scrollPanel;
	private TextColumn<ProductBacklogItem> sprint;
	private TextColumn<ProductBacklogItem> release;

	public static IProductBacklogView createView() {
		return new ProductBacklogView();
	}

	@SuppressWarnings("unchecked")
	public ProductBacklogView() {

		FlowPanel concreteProductBacklogPanel = new FlowPanel();
		initWidget(concreteProductBacklogPanel);
		concreteProductBacklogPanel.setSize("500px", "600px");

		AbsolutePanel horizontalPanel = new AbsolutePanel();
		horizontalPanel.setSize("500px", "600px");
		concreteProductBacklogPanel.add(horizontalPanel);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("box");
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.add(verticalPanel, 438, 67);
		verticalPanel.setSize("50", "165px");

		Grid pbMenu = new Grid(7, 1);
		verticalPanel.add(pbMenu);
		pbMenu.setCellSpacing(5);
		pbMenu.setCellPadding(5);
		pbMenu.setSize("50", "471px");
						
								imgNewFile = new Image("images/newfile.png");
								imgNewFile.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										newPBIEvent.fire(ProductBacklogView.this, new EventArgs());
									}
								});
								pbMenu.setWidget(0, 0, imgNewFile);
						
								imgDetails = new Image("images/details.png");
								imgDetails.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										detailPBIEvent.fire(ProductBacklogView.this, new PBIArgs(ProductBacklogView.this.currentlySelected));
									}
								});
								pbMenu.setWidget(1, 0, imgDetails);
						
								imgDelete = new Image("images/delete.png");
								imgDelete.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										if(currentlySelected!=null){
											deleteSelectedEvent.fire(ProductBacklogView.this, new PBIArgs(currentlySelected));
										}
									}
								});
								pbMenu.setWidget(2, 0, imgDelete);
				
						imgDoubleArrowUp = new Image("images/toparrow.png");
						imgDoubleArrowUp.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								if(currentlySelected!=null){
									pbiTopEvent.fire(ProductBacklogView.this, new PBIArgs(currentlySelected));
								}
								
							}
						});
						pbMenu.setWidget(3, 0, imgDoubleArrowUp);
				
						imgArrowUp = new Image("images/uparrow.png");
						imgArrowUp.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								if(currentlySelected!=null){
									pbiUpEvent.fire(ProductBacklogView.this, new PBIArgs(currentlySelected));
								}
								
							}
						});
						pbMenu.setWidget(4, 0, imgArrowUp);
				
						imgArrowDown = new Image("images/downarrow.png");
						pbMenu.setWidget(5, 0, imgArrowDown);
						imgArrowDown.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								pbiDownEvent.fire(ProductBacklogView.this, new PBIArgs(currentlySelected));
							}
						});
		
				imgDoubleArrowDown = new Image("images/bottomarrow.png");
				imgDoubleArrowDown.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						if(currentlySelected!=null){
					pbiBottomEvent.fire(ProductBacklogView.this, new PBIArgs(currentlySelected));		
						}	
					}
				});
				pbMenu.setWidget(6, 0, imgDoubleArrowDown);

		Label lblProductBacklog = new Label("Product Backlog Eintr\u00E4ge");
		lblProductBacklog.setStyleName("LabelElement");
		horizontalPanel.add(lblProductBacklog, 10, 10);

		lblAktionen = new Label("Aktionen");
		lblAktionen.setStyleName("LabelElement");
		horizontalPanel.add(lblAktionen, 422, 10);
		lblAktionen.setSize("59px", "23px");
		
		scrollPanel = new ScrollPanel();
		horizontalPanel.add(scrollPanel, 10, 40);
		scrollPanel.setSize("400px", "500px");
		
				tableProductbacklog = new CellTable<ProductBacklogItem>();
				
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
				
				sprint = new TextColumn<ProductBacklogItem>() {
					@Override
					public String getValue(ProductBacklogItem pbi) {
						return pbi.getSprint().toString();
					}
				};
				tableProductbacklog.addColumn(sprint, "Sprint");
				
				release = new TextColumn<ProductBacklogItem>() {
					@Override
					public String getValue(ProductBacklogItem pbi) {
						return pbi.getSprint().getRelease().toString();
					}
				};
				tableProductbacklog.addColumn(release, "Release");
				scrollPanel.setWidget(tableProductbacklog);
				tableProductbacklog.setSize("100%", "100%");
								tableProductbacklog.setSelectionModel(new SingleSelectionModel());
								tableProductbacklog.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
									
									public void onSelectionChange(SelectionChangeEvent event) {
										SingleSelectionModel<ProductBacklogItem> model = (SingleSelectionModel<ProductBacklogItem>)tableProductbacklog.getSelectionModel();
										currentlySelected = model.getSelectedObject();
									}
								});
	}

	@Override
	public void addDeletePBIEventHandler(EventHandler<PBIArgs> arg) {
		deleteSelectedEvent.add(arg);
	}

	@Override
	public void addNewPBIEventHandler(EventHandler<EventArgs> arg) {
		newPBIEvent.add(arg);
	}

	@Override
	public void addPBIBottomEventHandler(EventHandler<PBIArgs> arg) {
		pbiBottomEvent.add(arg);

	}

	public void addPBIDetailsEventHandler(
			fhdw.ipscrum.client.events.EventHandler<PBIArgs> arg) {
		detailPBIEvent.add(arg);
	};

	@Override
	public void addPBIDownEventHandler(EventHandler<PBIArgs> arg) {
		pbiDownEvent.add(arg);
	}

	@Override
	public void addPBITopEventHandler(EventHandler<PBIArgs> arg) {
		pbiTopEvent.add(arg);

	}

	@Override
	public void addPBIUpEventHandler(EventHandler<PBIArgs> arg) {
		pbiUpEvent.add(arg);
	}
	
	@Override
	public void addPBISelectedEventHandler(EventHandler<PBIArgs> arg) {
		pbiSelectedEvent.add(arg);
	}

	@Override
	public void refreshProductBacklog(
			Vector<ProductBacklogItem> ProductBacklogItem) {
		this.getTableProductBacklog().setRowData(ProductBacklogItem);
	}

	private CellTable<ProductBacklogItem> getTableProductBacklog() {
		return this.tableProductbacklog;
	}
	
}
