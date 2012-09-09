package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.TicketTypeCreatePresenter.ITicketTypeCreateView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * represents the view to create ticket types.
 */
public class TicketTypeCreateView extends MasterView implements ITicketTypeCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final TextBox descriptionTextBox;
	private final CellList<TicketType> cellList;
	private final TextArea textAreaDescription;
	private TicketType selectedMainType;
	private final SingleSelectionModel<TicketType> listSelectionModel;

	/**
	 * constructor of the TicketTypeCreateView.
	 */
	public TicketTypeCreateView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel);
		verticalPanel.setHeight("402px");

		final HTML header = new HTML("<h3>Neuen Tickettypen erstellen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(3, 2);
		grid.setCellPadding(5);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid, HasHorizontalAlignment.ALIGN_CENTER);

		final Label firstNameLabel = new Label("Name");
		grid.setWidget(0, 0, firstNameLabel);

		this.descriptionTextBox = new TextBox();
		grid.setWidget(0, 1, this.descriptionTextBox);

		final Label lastNameLabel = new Label("Kategorie");
		grid.setWidget(1, 0, lastNameLabel);

		this.cellList = new CellList<TicketType>(new AbstractCell<TicketType>() {
			@Override
			public void render(final Context context, final TicketType value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getTypeName());
			}
		});
		this.cellList.setStyleName("tableBorder");
		grid.setWidget(1, 1, this.cellList);
		this.cellList.setSize("160px", "60px");

		this.listSelectionModel = new SingleSelectionModel<TicketType>();
		this.listSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(final SelectionChangeEvent event) {
				TicketTypeCreateView.this.selectedMainType =
						TicketTypeCreateView.this.listSelectionModel.getSelectedObject();
			}
		});
		this.cellList.setSelectionModel(this.listSelectionModel);

		final Label lblDescription = new Label("Beschreibung");
		grid.setWidget(2, 0, lblDescription);

		this.textAreaDescription = new TextArea();
		grid.setWidget(2, 1, this.textAreaDescription);
		grid.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Save");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TicketTypeCreateView.this.saveEvent.fire(TicketTypeCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abort");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				TicketTypeCreateView.this.abortEvent.fire(TicketTypeCreateView.this);
			}
		});
		horizontalPanel.add(abortButton);

	}

	@Override
	public void close() {
		this.saveEvent.removeAllHandler();
		this.abortEvent.removeAllHandler();
	}

	@Override
	public EventRegistration registerSave(final DefaultEventHandler handler) {
		return this.saveEvent.add(handler);
	}

	@Override
	public EventRegistration registetAbort(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	@Override
	public String getName() {
		return this.descriptionTextBox.getText();
	}

	@Override
	public TicketType getCategorie() {
		return this.selectedMainType;

	}

	@Override
	public String getDescription() {
		return this.textAreaDescription.getText();
	}

	@Override
	public void refreshMainTypes(final List<TicketType> types) {

		this.getCellList().setRowData(types);
	}

	private CellList<TicketType> getCellList() {
		return this.cellList;
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
