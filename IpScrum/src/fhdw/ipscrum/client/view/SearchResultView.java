package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.viewinterfaces.ISearchResultView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * @author HE
 * 
 */
public class SearchResultView extends Composite implements ISearchResultView {
	private CellTable<Ticket> cellTable;
	private final SingleSelectionModel<Ticket> resultSelModel =
			new SingleSelectionModel<Ticket>();
	private final Event<TypedEventArg<Ticket>> detailsEvent =
			new Event<TypedEventArg<Ticket>>();

	/**
	 * constructor of the SearchesResultView.
	 */
	public SearchResultView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(5);
		verticalPanel.setStyleName("LabelElement");
		this.initWidget(verticalPanel);
		verticalPanel.setSize("600px", "500px");

		final Label lblresult = new Label("Suchergebnisse");
		verticalPanel.add(lblresult);
		verticalPanel.setCellHeight(lblresult, "20px");
		verticalPanel.setCellWidth(lblresult, "590px");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("590px", "470px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_1.add(scrollPanel);
		verticalPanel_1.setCellHorizontalAlignment(scrollPanel,
				HasHorizontalAlignment.ALIGN_CENTER);
		scrollPanel.setStyleName("#mainPanel");
		scrollPanel.setSize("95%", "95%");

		this.cellTable = new CellTable<Ticket>();
		scrollPanel.setWidget(this.cellTable);
		this.cellTable.setSize("95%", "95%");

		final TextColumn<Ticket> nameColumn = new TextColumn<Ticket>() {
			@Override
			public String getValue(final Ticket object) {
				return object.getName();
			}
		};
		this.cellTable.addColumn(nameColumn, "Name");

		final TextColumn<Ticket> statusColumn = new TextColumn<Ticket>() {
			@Override
			public String getValue(final Ticket object) {
				return object.getCurrentState().getName();
			}
		};
		this.cellTable.addColumn(statusColumn, "Status");

		final TextColumn<Ticket> typeColumn = new TextColumn<Ticket>() {
			@Override
			public String getValue(final Ticket object) {
				return object.getTicketType().getTypeName();
			}
		};
		this.cellTable.addColumn(typeColumn, "Typ");

		final TextColumn<Ticket> projectColumn = new TextColumn<Ticket>() {
			@Override
			public String getValue(final Ticket object) {
				return object.getProject().getName();
			}
		};
		this.cellTable.addColumn(projectColumn, "Projekt");

		this.cellTable.setSelectionModel(this.resultSelModel);
		this.resultSelModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {

						SearchResultView.this.detailsEvent.fire(
								SearchResultView.this,
								new TypedEventArg<Ticket>(
										SearchResultView.this.resultSelModel
												.getSelectedObject()));

					}
				});
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSearchResult(final List<Ticket> results) {

		this.getCellTable().setRowData(results);
	}

	private CellTable<Ticket> getCellTable() {
		return this.cellTable;
	}

	@Override
	public void
			registerDetailHandler(final EventHandler<TypedEventArg<Ticket>> handler) {
		this.detailsEvent.add(handler);

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
