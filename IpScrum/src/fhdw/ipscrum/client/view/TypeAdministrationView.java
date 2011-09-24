package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.TicketTypeArgs;
import fhdw.ipscrum.client.viewinterfaces.ITypeAdministrationView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * represents a view to administer ticket types.
 */
public class TypeAdministrationView extends MasterView implements ITypeAdministrationView {

	private final DefaultEvent addTypeEvent = new DefaultEvent();
	private final Event<TicketTypeArgs> deleteTypeEvent = new Event<TicketTypeArgs>();
	private CellTable<TicketType> typeTable;
	private SingleSelectionModel<TicketType> tableSelectionModel;
	private SingleSelectionModel<TicketType> listSelectionModel;
	private TicketType selectedType;
	private TicketType selectedMainType;
	private TextBox textBox;
	private TextArea textArea;
	private CellList<TicketType> cellList;

	/**
	 * constructor of the TypeAdministrationView.
	 */
	public TypeAdministrationView() {
		super();

		final VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(panel);
		panel.setSize("900px", "600px");

		final Label lblHeader = new Label("Tickettypen Administration");
		lblHeader.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblHeader.setStyleName("LabelElement");
		panel.add(lblHeader);
		lblHeader.setSize("600px", "40px");
		panel.setCellHorizontalAlignment(lblHeader, HasHorizontalAlignment.ALIGN_CENTER);

		final FlowPanel createPanel = new FlowPanel();
		panel.add(createPanel);
		panel.setCellHorizontalAlignment(createPanel, HasHorizontalAlignment.ALIGN_CENTER);
		panel.setCellVerticalAlignment(createPanel, HasVerticalAlignment.ALIGN_MIDDLE);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		createPanel.add(horizontalPanel);
		horizontalPanel.setSize("400px", "50px");

		final Label lblName = new Label("Bezeichnung");
		horizontalPanel.add(lblName);
		horizontalPanel.setCellVerticalAlignment(lblName, HasVerticalAlignment.ALIGN_MIDDLE);
		lblName.setSize("120px", "30px");
		lblName.setStyleName("LabelElement");
		lblName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.textBox = new TextBox();
		this.textBox.setStyleName("tableBorder");
		horizontalPanel.add(this.textBox);
		horizontalPanel.setCellVerticalAlignment(this.textBox, HasVerticalAlignment.ALIGN_MIDDLE);
		this.textBox.setSize("160px", "20px");
		horizontalPanel.setCellHorizontalAlignment(this.textBox, HasHorizontalAlignment.ALIGN_RIGHT);

		final HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4.setSpacing(5);
		createPanel.add(horizontalPanel_4);
		horizontalPanel_4.setSize("400px", "50px");

		final Label lblDescription = new Label("Beschreibung");
		lblDescription.setStyleName("LabelElement");
		horizontalPanel_4.add(lblDescription);
		horizontalPanel_4.setCellVerticalAlignment(lblDescription, HasVerticalAlignment.ALIGN_MIDDLE);
		lblDescription.setSize("168px", "30px");

		this.textArea = new TextArea();
		this.textArea.setStyleName("tableBorder");
		horizontalPanel_4.add(this.textArea);
		horizontalPanel_4.setCellVerticalAlignment(this.textArea, HasVerticalAlignment.ALIGN_MIDDLE);
		this.textArea.setSize("160px", "60px");
		horizontalPanel_4.setCellHorizontalAlignment(this.textArea, HasHorizontalAlignment.ALIGN_RIGHT);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setSpacing(5);
		createPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("400px", "50px");

		final Label lblType = new Label("Grundtyp");
		lblType.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		horizontalPanel_1.add(lblType);
		horizontalPanel_1.setCellVerticalAlignment(lblType, HasVerticalAlignment.ALIGN_MIDDLE);
		lblType.setSize("220px", "30px");
		lblType.setStyleName("LabelElement");

		this.cellList = new CellList<TicketType>(new AbstractCell<TicketType>() {
			@Override
			public void render(final Context context, final TicketType value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getTypeName());
			}
		});
		this.cellList.setStyleName("tableBorder");
		horizontalPanel_1.add(this.cellList);
		horizontalPanel_1.setCellHeight(this.cellList, "100%");
		horizontalPanel_1.setCellWidth(this.cellList, "100%");
		horizontalPanel_1.setCellVerticalAlignment(this.cellList, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setCellHorizontalAlignment(this.cellList, HasHorizontalAlignment.ALIGN_CENTER);
		this.cellList.setSize("160px", "55px");

		final HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(5);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		createPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("900px", "");

		final Button btnCreate = new Button("Hinzufügen");

		btnCreate.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				TypeAdministrationView.this.addTypeEvent.fire(TypeAdministrationView.this);
			}
		});
		horizontalPanel_2.add(btnCreate);

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.add(verticalPanel);
		verticalPanel.setSize("900px", "300px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("800px", "250px");
		verticalPanel.setCellHeight(scrollPanel, "95%");
		verticalPanel.setCellWidth(scrollPanel, "95%");

		this.typeTable = new CellTable<TicketType>();
		scrollPanel.setWidget(this.typeTable);
		this.typeTable.setSize("95%", "95%");

		final TextColumn<TicketType> nameColumn = new TextColumn<TicketType>() {
			@Override
			public String getValue(final TicketType object) {
				return object.getTypeName();
			}
		};
		this.typeTable.addColumn(nameColumn, "Bezeichnung");

		final TextColumn<TicketType> typeColumn = new TextColumn<TicketType>() {
			@Override
			public String getValue(final TicketType object) {
				return object.getTypeDescription();
			}
		};
		this.typeTable.addColumn(typeColumn, "Beschreibung");

		this.tableSelectionModel = new SingleSelectionModel<TicketType>();
		this.tableSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(final SelectionChangeEvent event) {
				TypeAdministrationView.this.selectedType =
						TypeAdministrationView.this.tableSelectionModel.getSelectedObject();
			}
		});

		this.typeTable.setSelectionModel(this.tableSelectionModel);

		final TextColumn<TicketType> textColumn = new TextColumn<TicketType>() {
			@Override
			public String getValue(final TicketType object) {
				String result = "";

				if (object instanceof TaskTicketType) {
					result = "Task";
				} else if (object instanceof BugTicketType) {
					result = "Bug";
				} else if (object instanceof FeatureTicketType) {
					result = "Feature";
				}
				return result;
			}
		};
		this.typeTable.addColumn(textColumn, "Grundtyp");

		this.listSelectionModel = new SingleSelectionModel<TicketType>();
		this.listSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(final SelectionChangeEvent event) {
				TypeAdministrationView.this.selectedMainType =
						TypeAdministrationView.this.listSelectionModel.getSelectedObject();
			}
		});

		this.cellList.setSelectionModel(this.listSelectionModel);

		final HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setSpacing(5);
		horizontalPanel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel_3);
		horizontalPanel_3.setWidth("850px");
		verticalPanel.setCellHorizontalAlignment(horizontalPanel_3, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button btnDelete = new Button("Löschen");
		btnDelete.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TypeAdministrationView.this.deleteTypeEvent.fire(TypeAdministrationView.this, new TicketTypeArgs(
						TypeAdministrationView.this.selectedType));

			}
		});
		horizontalPanel_3.add(btnDelete);
	}

	@Override
	public void close() {
		this.addTypeEvent.removeAllHandler();
		this.deleteTypeEvent.removeAllHandler();

	}

	@Override
	public void refreshTypes(final List<TicketType> types) {
		this.getTypeTable().setRowData(types);

	}

	@Override
	public void registerAddType(final DefaultEventHandler handler) {
		this.addTypeEvent.add(handler);

	}

	@Override
	public void registerDeleteType(final EventHandler<TicketTypeArgs> handler) {
		this.deleteTypeEvent.add(handler);

	}

	private CellTable<TicketType> getTypeTable() {
		return this.typeTable;
	}

	@Override
	public String getTypeName() {
		return this.getTextBox().getValue();
	}

	@Override
	public TicketType getType() {
		return this.selectedMainType;
	}

	private TextBox getTextBox() {
		return this.textBox;
	}

	@Override
	public String getDescription() {
		return this.getTextArea().getValue();
	}

	private TextArea getTextArea() {
		return this.textArea;
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
