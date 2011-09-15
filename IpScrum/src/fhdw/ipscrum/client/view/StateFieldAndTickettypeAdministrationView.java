package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.viewinterfaces.IStateFieldAndTickettypeAdministrationView;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.MultiplicityVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.One;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * view class of the team interface. this composes the team management gui. this view is
 * used to inspect, create and modify teams as well as adding and removing persons to
 * teams.
 */
public class StateFieldAndTickettypeAdministrationView extends Composite
		implements IStateFieldAndTickettypeAdministrationView {
	private final Event<EventArgs> newStateTypeEvent = new Event<EventArgs>();
	private final Event<EventArgs> newFieldTypeEvent = new Event<EventArgs>();
	private final Event<EventArgs> newTicketTypeEvent = new Event<EventArgs>();
	private ListDataProvider<TicketType> ticketTypeDataProvider;
	private MultiSelectionModel<TicketType> selModelTicketTypesTable;

	private ListDataProvider<StateType> stateTypeDataProvider;
	private MultiSelectionModel<StateType> selModelStateTypeTable;

	private ListDataProvider<FieldType> fieldTypeDataProvider;
	private MultiSelectionModel<FieldType> selModelFieldTypeTable;
	private CellTable<FieldType> cellTableFieldTypes;
	private String multiplicity;
	private Button btnZustandAnlegen;
	private Button btnNeuenTicketTypenAnlegen;
	private Button btnFeldAnlegen;

	/**
	 * constructor of the StateFieldAndTickettypeAdministrationView.
	 */
	public StateFieldAndTickettypeAdministrationView() {

		this.stateTypeDataProvider = new ListDataProvider<StateType>();
		this.ticketTypeDataProvider = new ListDataProvider<TicketType>();
		this.fieldTypeDataProvider = new ListDataProvider<FieldType>();

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.initWidget(horizontalPanel);

		final VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel.add(verticalPanelTeams);

		final Label lblTicketTypes = new Label("Tickettypen");
		verticalPanelTeams.add(lblTicketTypes);

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setStyleName("tableBorder");
		verticalPanelTeams.add(scrollPanel_1);
		scrollPanel_1.setSize("250px", "425px");

		final CellTable<TicketType> cellTableTicketTypes = new CellTable<TicketType>();
		this.ticketTypeDataProvider.addDataDisplay(cellTableTicketTypes);
		scrollPanel_1.setWidget(cellTableTicketTypes);
		cellTableTicketTypes.setSize("100%", "100%");
		this.selModelTicketTypesTable =
				new MultiSelectionModel<TicketType>(this.ticketTypeDataProvider);
		cellTableTicketTypes.setSelectionModel(this.selModelTicketTypesTable);

		final TextColumn<TicketType> colName = new TextColumn<TicketType>() {

			@Override
			public String getValue(final TicketType object) {
				return object.getTypeName();
			}

		};
		cellTableTicketTypes.addColumn(colName, "Name");

		final TextColumn<TicketType> colDescription = new TextColumn<TicketType>() {

			@Override
			public String getValue(final TicketType object) {
				return object.getTypeDescription();
			}

		};
		cellTableTicketTypes.addColumn(colDescription, "Beschreibung");

		final HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");

		this.btnNeuenTicketTypenAnlegen = new Button("Tickettypen anlegen");
		this.btnNeuenTicketTypenAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				StateFieldAndTickettypeAdministrationView.this.newTicketTypeEvent
						.fire(StateFieldAndTickettypeAdministrationView.this,
								new EventArgs());
			}
		});
		horizontalPanelTeamButtons.add(this.btnNeuenTicketTypenAnlegen);
		this.btnNeuenTicketTypenAnlegen.setWidth("100%");

		final VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);
		verticalPanelAllocationButtons.setWidth("10px");

		final VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanel.add(verticalPanelPersons);
		verticalPanelPersons.setHeight("479px");
		this.selModelFieldTypeTable =
				new MultiSelectionModel<FieldType>(this.fieldTypeDataProvider);

		final Label lblStates = new Label("Zustände");
		verticalPanelPersons.add(lblStates);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("tableBorder");
		verticalPanelPersons.add(scrollPanel);
		scrollPanel.setSize("250px", "425px");

		final CellTable<StateType> cellTableStates = new CellTable<StateType>();
		this.stateTypeDataProvider.addDataDisplay(cellTableStates);
		scrollPanel.setWidget(cellTableStates);
		cellTableStates.setSize("100%", "100%");
		this.selModelStateTypeTable =
				new MultiSelectionModel<StateType>(this.stateTypeDataProvider);
		cellTableStates.setSelectionModel(this.selModelStateTypeTable);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanelPersons.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");

		this.btnZustandAnlegen = new Button("Zustand anlegen");
		this.btnZustandAnlegen.setText("Zustand anlegen");
		this.btnZustandAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				StateFieldAndTickettypeAdministrationView.this.newStateTypeEvent
						.fire(StateFieldAndTickettypeAdministrationView.this,
								new EventArgs());

			}

		});

		final TextColumn<StateType> colStateName = new TextColumn<StateType>() {

			@Override
			public String getValue(final StateType object) {
				return object.getName();
			}

		};
		cellTableStates.addColumn(colStateName, "Name");

		final TextColumn<StateType> colStateDescription = new TextColumn<StateType>() {

			@Override
			public String getValue(final StateType object) {
				return object.getDescription();
			}

		};
		cellTableStates.addColumn(colStateDescription, "Beschreibung");

		horizontalPanel_1.add(this.btnZustandAnlegen);
		this.btnZustandAnlegen.setWidth("100%");

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanel_2);
		verticalPanel_2.setWidth("10px");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_1);

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel_1.add(verticalPanel);
		verticalPanel.setHeight("482px");

		final Label label = new Label("Feldtypen");
		verticalPanel.add(label);

		final ScrollPanel scrollPanel_2 = new ScrollPanel();
		scrollPanel_2.setStyleName("tableBorder");
		verticalPanel.add(scrollPanel_2);
		scrollPanel_2.setSize("250px", "425px");

		this.cellTableFieldTypes = new CellTable<FieldType>();
		this.fieldTypeDataProvider.addDataDisplay(this.cellTableFieldTypes);
		scrollPanel_2.setWidget(this.cellTableFieldTypes);
		this.cellTableFieldTypes.setSize("100%", "100%");
		this.selModelFieldTypeTable =
				new MultiSelectionModel<FieldType>(this.fieldTypeDataProvider);
		this.cellTableFieldTypes.setSelectionModel(this.selModelFieldTypeTable);

		final TextColumn<FieldType> textColumn = new TextColumn<FieldType>() {
			@Override
			public String getValue(final FieldType object) {
				return object.getName();
			}
		};
		this.cellTableFieldTypes.addColumn(textColumn, "Name");

		final TextColumn<FieldType> textColumn_1 = new TextColumn<FieldType>() {
			@Override
			public String getValue(final FieldType object) {

				object.getMultiplicity().accept(new MultiplicityVisitor() {
					@Override
					public void handleOne(final One one) {
						StateFieldAndTickettypeAdministrationView.this.multiplicity =
								"1";

					}

					@Override
					public void handleMany(final Many many) {
						StateFieldAndTickettypeAdministrationView.this.multiplicity =
								"*";
					}

				});

				return StateFieldAndTickettypeAdministrationView.this.multiplicity;
			}
		};
		this.cellTableFieldTypes.addColumn(textColumn_1, "Multiplizität");

		final HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setWidth("100%");

		this.btnFeldAnlegen = new Button("Feldtypen anlegen");
		horizontalPanel_2.add(this.btnFeldAnlegen);
		this.btnFeldAnlegen.setWidth("100%");
		this.btnFeldAnlegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				StateFieldAndTickettypeAdministrationView.this.newFieldTypeEvent
						.fire(StateFieldAndTickettypeAdministrationView.this,
								new EventArgs());

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IStateFieldAndTickettypeAdministrationView#
	 * defineNewStateTypeEvent
	 * (fhdw.ipscrum.client.architecture.events.DefaultEventHandler)
	 */
	@Override
	public void defineNewStateTypeEvent(final DefaultEventHandler handler) {
		this.newStateTypeEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IStateFieldAndTickettypeAdministrationView#
	 * defineNewFieldTypeEvent
	 * (fhdw.ipscrum.client.architecture.events.DefaultEventHandler)
	 */

	@Override
	public void defineNewFieldTypeEvent(final DefaultEventHandler handler) {
		this.newFieldTypeEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IStateFieldAndTickettypeAdministrationView#
	 * defineNewTickettypeEvent
	 * (fhdw.ipscrum.client.architecture.events.DefaultEventHandler)
	 */

	@Override
	public void defineNewTickettypeEvent(final DefaultEventHandler handler) {
		this.newTicketTypeEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ITeamView#updatePersonTableData(java.util.HashSet )
	 */
	@Override
	public void updateStateTypeTableData(final List<StateType> stateTypeSet) {

		this.stateTypeDataProvider.getList().clear();
		this.stateTypeDataProvider.getList().addAll(stateTypeSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ITeamView#updatePersonTableData(java.util.HashSet )
	 */
	@Override
	public void updateFieldTypeTableData(final List<FieldType> fieldTypeSet) {
		this.cellTableFieldTypes.setRowData(fieldTypeSet);

		this.fieldTypeDataProvider.getList().clear();
		this.fieldTypeDataProvider.getList().addAll(fieldTypeSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ITeamView#updatePersonTableData(java.util.HashSet )
	 */
	@Override
	public void updateTicketTypeTableData(final List<TicketType> ticketTypeSet) {

		this.ticketTypeDataProvider.getList().clear();
		this.ticketTypeDataProvider.getList().addAll(ticketTypeSet);
	}

	@Override
	public void close() {
		this.newStateTypeEvent.removeAllHandler();
		this.newFieldTypeEvent.removeAllHandler();
		this.newTicketTypeEvent.removeAllHandler();

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnFeldAnlegen().setEnabled(value);
		this.getBtnZustandAnlegen().setEnabled(value);
		this.getBtnNeuenTicketTypenAnlegen().setEnabled(value);

	}

	protected Button getBtnZustandAnlegen() {
		return this.btnZustandAnlegen;
	}

	protected Button getBtnNeuenTicketTypenAnlegen() {
		return this.btnNeuenTicketTypenAnlegen;
	}

	protected Button getBtnFeldAnlegen() {
		return this.btnFeldAnlegen;
	}
}
