package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.TicketTypeSelectionPresenter.ITicketTypeSelectionView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * represents the view to select a ticket type.
 */
public class TicketTypeSelectionView extends MasterView implements ITicketTypeSelectionView {

	private final Event<TypedEventArg<TicketType>> gotoTicketTypeAdministrationEvent =
			new Event<TypedEventArg<TicketType>>();
	private SingleSelectionModel<TicketType> selectionModel;
	private CellTable<TicketType> cellTable;

	/**
	 * constructor of the TicketTypeSelectionView.
	 */
	public TicketTypeSelectionView() {
		super();

		this.selectionModel = new SingleSelectionModel<TicketType>();
		this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(final SelectionChangeEvent event) {
				final TicketType selectedObject = TicketTypeSelectionView.this.selectionModel.getSelectedObject();
				TicketTypeSelectionView.this.gotoTicketTypeAdministrationEvent.fire(TicketTypeSelectionView.this,
						new TypedEventArg<TicketType>(selectedObject));
			}
		});

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(10);
		this.add(verticalPanel);
		verticalPanel.setSize("", "");

		final Label lblNewLabel = new Label("Bitte wählen Sie einen Tickettypen aus!");
		verticalPanel.add(lblNewLabel);

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("500px", "500px");

		this.cellTable = new CellTable<TicketType>();
		this.cellTable.setSelectionModel(this.selectionModel);
		scrollPanel.setWidget(this.cellTable);
		this.cellTable.setPageSize(0);
		this.cellTable.setSize("100%", "");

		final TextColumn<TicketType> nameColumn = new TextColumn<TicketType>() {
			@Override
			public String getValue(final TicketType object) {
				return object.getTypeName();
			}
		};
		this.cellTable.addColumn(nameColumn);
		this.cellTable.setColumnWidth(nameColumn, "30%");

		final TextColumn<TicketType> ticketNumColumn = new TextColumn<TicketType>() {

			@Override
			public String getValue(final TicketType object) {
				return object.getTypeDescription();
			}
		};
		this.cellTable.addColumn(ticketNumColumn);
		this.cellTable.setColumnWidth(ticketNumColumn, "30%");

	}

	@Override
	public void close() {
		this.gotoTicketTypeAdministrationEvent.removeAllHandler();
	}

	@Override
	public void setTicketTypes(final List<TicketType> ticketTypes) {
		this.cellTable.setRowData(ticketTypes);
	}

	@Override
	public EventRegistration registerGotoProjectHandler(final EventHandler<TypedEventArg<TicketType>> handler) {
		return this.gotoTicketTypeAdministrationEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hides

	}

}
