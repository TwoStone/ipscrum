package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.PBIArgs;
import fhdw.ipscrum.client.view.widgets.ProductBacklogTable;
import fhdw.ipscrum.client.viewinterfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * view class of the team interface. this composes the team management gui. this view is used to inspect, create and
 * modify teams as well as adding and removing persons to teams.
 */
public class ProductBacklogView extends MasterView implements IProductBacklogView {
	// ########## Events #############
	private final Event<EventArgs> newTicketEvent = new Event<EventArgs>();
	private final Event<PBIArgs> detailPBIEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> editPBIEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiSelectedEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> deleteSelectedEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiDownEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiBottomEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiUpEvent = new Event<PBIArgs>();
	private final Event<PBIArgs> pbiTopEvent = new Event<PBIArgs>();
	// ###### Ende Events ###########

	private Project project;

	@Override
	public void setProject(final Project project) {
		this.project = project;
	}

	private final Event<TypedEventArg<Project>> gotoProjectEvent = new Event<TypedEventArg<Project>>();

	private final SingleSelectionModel<ProductBacklogItem> selModelPBITable;

	private final ProductBacklogTable productBacklogTableAktive;

	private final ProductBacklogTable productBacklogTableInactive;
	private final Button btnEditPBI;
	private final Button btnNeuesAddNewPBI;
	private final Button btnHigherPrio;
	private final Button btnLowerPrio;

	/**
	 * constructor of the ProductBacklogView.
	 */
	public ProductBacklogView() {
		super();

		this.selModelPBITable = new SingleSelectionModel<ProductBacklogItem>();

		final VerticalPanel outerPanel = new VerticalPanel();
		this.add(outerPanel);

		final VerticalPanel firstPanel = new VerticalPanel();
		firstPanel.setSpacing(5);
		firstPanel.setSize("500px", "440px");
		outerPanel.add(firstPanel);

		final HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		firstPanel.add(horizontalPanel_2);

		final VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel_2.add(verticalPanelTeams);
		verticalPanelTeams.setWidth("100%");

		final Label lblTeams = new Label("Aktiver ProductBacklog");
		verticalPanelTeams.add(lblTeams);

		this.productBacklogTableAktive = new ProductBacklogTable();
		// activeProductBacklogDataProvider.addDataDisplay(productBacklogTableAktive);
		verticalPanelTeams.add(this.productBacklogTableAktive);
		this.productBacklogTableAktive.setSize("100%", "80%");
		this.productBacklogTableAktive.setSelectionModel(this.selModelPBITable);

		final HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");

		this.btnNeuesAddNewPBI = new Button("Ticket erstellen");
		horizontalPanelTeamButtons.add(this.btnNeuesAddNewPBI);
		this.btnNeuesAddNewPBI.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogView.this.newTicketEvent.fire(ProductBacklogView.this, new EventArgs());
			}
		});
		horizontalPanelTeamButtons.setCellVerticalAlignment(this.btnNeuesAddNewPBI, HasVerticalAlignment.ALIGN_MIDDLE);
		this.btnNeuesAddNewPBI.setWidth("100%");

		final HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanelTeamButtons.add(horizontalPanel_4);
		horizontalPanelTeamButtons.setCellHorizontalAlignment(horizontalPanel_4, HasHorizontalAlignment.ALIGN_RIGHT);

		this.btnEditPBI = new Button("Bearbeiten");
		horizontalPanel_4.add(this.btnEditPBI);
		this.btnEditPBI.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				// TeamView.this.newTeamEvent.fire(TeamView.this, new
				// EventArgs());
				ProductBacklogView.this.detailPBIEvent.fire(ProductBacklogView.this, new PBIArgs(
						ProductBacklogView.this.selModelPBITable.getSelectedObject()));
			}
		});
		horizontalPanelTeamButtons.setCellHorizontalAlignment(this.btnEditPBI, HasHorizontalAlignment.ALIGN_RIGHT);
		this.btnEditPBI.setWidth("98px");

		this.btnHigherPrio = new Button("Priorität eröhen");
		horizontalPanel_4.add(this.btnHigherPrio);
		this.btnHigherPrio.setWidth("");
		this.btnHigherPrio.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogView.this.pbiUpEvent.fire(ProductBacklogView.this, new PBIArgs(
						ProductBacklogView.this.selModelPBITable.getSelectedObject()));
			}
		});

		this.btnLowerPrio = new Button("Priorität verringern");
		horizontalPanel_4.add(this.btnLowerPrio);
		this.btnLowerPrio.setWidth("");

		this.btnLowerPrio.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogView.this.pbiDownEvent.fire(ProductBacklogView.this, new PBIArgs(
						ProductBacklogView.this.selModelPBITable.getSelectedObject()));
			}
		});

		final HTML htmlNewHtml = new HTML("<hr/>", true);
		firstPanel.add(htmlNewHtml);

		final VerticalPanel verticalPanel = new VerticalPanel();
		firstPanel.add(verticalPanel);
		verticalPanel.setWidth("100%");

		final Label lblInaktiverProductbacklog = new Label("Inaktiver ProductBacklog");
		verticalPanel.add(lblInaktiverProductbacklog);

		this.productBacklogTableInactive = new ProductBacklogTable();
		// inactiveProductBacklogDataProvider.addDataDisplay(productBacklogTableInactive);
		verticalPanel.add(this.productBacklogTableInactive);
		this.productBacklogTableInactive.setSize("100%", "80%");

		final Button btnViewDetails = new Button("Details");
		verticalPanel.add(btnViewDetails);
		verticalPanel.setCellHorizontalAlignment(btnViewDetails, HasHorizontalAlignment.ALIGN_RIGHT);
		btnViewDetails.setWidth("98px");

		final Button btnClose = new Button("Schließen");
		outerPanel.add(btnClose);
		outerPanel.setCellHorizontalAlignment(btnClose, HasHorizontalAlignment.ALIGN_RIGHT);
		btnClose.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogView.this.gotoProjectEvent.fire(ProductBacklogView.this, new TypedEventArg<Project>(
						ProductBacklogView.this.project));
			}
		});
		btnViewDetails.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogView.this.detailPBIEvent.fire(ProductBacklogView.this, new PBIArgs(
						ProductBacklogView.this.selModelPBITable.getSelectedObject()));

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addDeletePBIEventHandler(
	 * fhdw.ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void deletePBIEventHandler(final EventHandler<PBIArgs> arg) {
		this.deleteSelectedEvent.add(arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addNewTicketEventHandler(
	 * fhdw.ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addNewTicketEventHandler(final EventHandler<EventArgs> arg) {
		this.newTicketEvent.add(arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBIBottomEventHandler(
	 * fhdw.ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBIBottomEventHandler(final EventHandler<PBIArgs> arg) {
		this.pbiBottomEvent.add(arg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBIDetailsEventHandler
	 * (fhdw.ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBIDetailsEventHandler(final fhdw.ipscrum.client.architecture.events.EventHandler<PBIArgs> arg) {
		this.editPBIEvent.add(arg);
	};

	@Override
	public void addPBIEditEventHandler(final fhdw.ipscrum.client.architecture.events.EventHandler<PBIArgs> arg) {
		this.detailPBIEvent.add(arg);
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBIDownEventHandler(fhdw
	 * .ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBIDownEventHandler(final EventHandler<PBIArgs> arg) {
		this.pbiDownEvent.add(arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBITopEventHandler(fhdw
	 * .ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBITopEventHandler(final EventHandler<PBIArgs> arg) {
		this.pbiTopEvent.add(arg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBIUpEventHandler(fhdw
	 * .ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBIUpEventHandler(final EventHandler<PBIArgs> arg) {
		this.pbiUpEvent.add(arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IProductBaclogView#addPBISelectedEventHandler
	 * (fhdw.ipscrum.client.architecture.events.EventHandler)
	 */
	@Override
	public void addPBISelectedEventHandler(final EventHandler<PBIArgs> arg) {
		this.pbiSelectedEvent.add(arg);
	}

	@SuppressWarnings("unused")
	private ProductBacklogItem getSelected() {
		return this.selModelPBITable.getSelectedObject();

	}

	@Override
	public void updateActiveProductBacklogTable(final List<ProductBacklogItem> pbiSet) {
		this.productBacklogTableAktive.setRowData(pbiSet);
	}

	@Override
	public void updateInactiveProductBacklogTable(final List<ProductBacklogItem> pbiSet) {
		this.productBacklogTableInactive.setRowData(pbiSet);

	}

	@Override
	public void close() {
		this.deleteSelectedEvent.removeAllHandler();
		this.detailPBIEvent.removeAllHandler();
		this.newTicketEvent.removeAllHandler();
		this.pbiBottomEvent.removeAllHandler();
		this.pbiDownEvent.removeAllHandler();
		this.pbiSelectedEvent.removeAllHandler();
		this.pbiTopEvent.removeAllHandler();
		this.pbiUpEvent.removeAllHandler();
	}

	@Override
	public ProductBacklogItem getSelectedPBI() {
		return this.selModelPBITable.getSelectedObject();
	}

	@Override
	public EventRegistration registerGotoProjectHandler(final EventHandler<TypedEventArg<Project>> handler) {
		return this.gotoProjectEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnEditPBI().setEnabled(value);
		this.getBtnNeuesAddNewPBI().setEnabled(value);
		this.getBtnHigherPrio().setEnabled(value);
		this.getBtnLowerPrio().setEnabled(value);
	}

	protected Button getBtnEditPBI() {
		return this.btnEditPBI;
	}

	protected Button getBtnNeuesAddNewPBI() {
		return this.btnNeuesAddNewPBI;
	}

	protected Button getBtnHigherPrio() {
		return this.btnHigherPrio;
	}

	protected Button getBtnLowerPrio() {
		return this.btnLowerPrio;
	}
}
