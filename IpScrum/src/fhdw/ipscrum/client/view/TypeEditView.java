package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.viewinterfaces.ITypeEditView;
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldTypeVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * represents the view to edit ticket types.
 */
public class TypeEditView extends Composite implements ITypeEditView {

	// EVENTS!!!!!!!!!!!!
	/**
	 * represents the event fired if a state should be deleted.
	 */
	private final DefaultEvent deleteState = new DefaultEvent();
	/**
	 * represents the event fired if a state should be added.
	 */
	private final DefaultEvent addState = new DefaultEvent();
	/**
	 * represents the event fired if a field should be deleted.
	 */
	private final DefaultEvent deleteField = new DefaultEvent();
	/**
	 * represents the event fired if a field should be added.
	 */
	private final DefaultEvent addField = new DefaultEvent();
	/**
	 * represents the event fired if a state is selected.
	 */
	private final DefaultEvent selectState = new DefaultEvent();
	private CellTable<FieldTableData> fieldTable;
	private CellTable<StateTableData> stateTable;
	private FieldType selectedField;
	private StateTableData selectedState;
	private TransitionRule selectedTransition;
	private SingleSelectionModel<FieldTableData> fieldTypeModel;
	private SingleSelectionModel<StateTableData> stateTypeModel;
	private SingleSelectionModel<TransitionRule> TransitionModel;
	private TicketType ticketType;
	private String typeString;
	private final Event<StateTypeArgs> changeStateStartValue =
			new Event<StateTypeArgs>();
	private final Event<StateTypeArgs> changeEndStateValue = new Event<StateTypeArgs>();
	private final Event<FieldTypeArgs> changeActivationValue =
			new Event<FieldTypeArgs>();
	private Label lblheader;
	private CellTable<TransitionRule> transitionTable;
	private final DefaultEvent addTransition = new DefaultEvent();
	private final DefaultEvent deleteTransition = new DefaultEvent();

	/**
	 * Inner class for event-argument transmission (MVC).
	 */
	public static class StateTypeArgs extends EventArgs {
		private final StateTableData stateData;
		private final Boolean bool;

		/**
		 * constructor of the StateTypeArgs.
		 * 
		 * @param stateData
		 *            is the related stateTable
		 * @param bool
		 *            is the true or false value
		 */
		public StateTypeArgs(final StateTableData stateData, final Boolean bool) {
			super();
			this.stateData = stateData;
			this.bool = bool;
		}

		/**
		 * getter of the stateTableData.
		 * 
		 * @return the StateTableData
		 */
		public StateTableData getStateData() {
			return this.stateData;
		}

		/**
		 * getter of the boolean.
		 * 
		 * @return the boolean
		 */
		public Boolean getBool() {
			return this.bool;
		}

	}

	/**
	 * Inner class for event-argument transmission (MVC).
	 */
	public static class FieldTypeArgs extends EventArgs {
		private final FieldTableData fieldData;
		private final Boolean bool;

		/**
		 * constructor of the FieldTypeArgs.
		 * 
		 * @param fieldData
		 *            is the related fieldData
		 * @param bool
		 *            if the field is active
		 */
		public FieldTypeArgs(final FieldTableData fieldData, final Boolean bool) {
			super();
			this.fieldData = fieldData;
			this.bool = bool;
		}

		/**
		 * getter of the fieldTableData.
		 * 
		 * @return the fieldTableData
		 */
		public FieldTableData getFieldData() {
			return this.fieldData;
		}

		/**
		 * getter of the boolean.
		 * 
		 * @return the boolean
		 */
		public Boolean getBool() {
			return this.bool;
		}

	}

	/**
	 * constructor of the TypeEditView.
	 */
	public TypeEditView() {

		final VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.setSpacing(5);
		this.initWidget(mainPanel);
		mainPanel.setSize("800px", "700px");
		final FieldUpdater<StateTableData, Boolean> startStateUpdater =
				new FieldUpdater<StateTableData, Boolean>() {
					@Override
					public void update(final int index, final StateTableData object,
							final Boolean value) {
						TypeEditView.this.changeStateStartValue.fire(TypeEditView.this,
								new StateTypeArgs(object, value));
					}
				};

		final FieldUpdater<StateTableData, Boolean> endStateUpdater =
				new FieldUpdater<StateTableData, Boolean>() {
					@Override
					public void update(final int index, final StateTableData object,
							final Boolean value) {
						TypeEditView.this.changeEndStateValue.fire(TypeEditView.this,
								new StateTypeArgs(object, value));
					}
				};
		final FieldUpdater<FieldTableData, Boolean> checkboxUpdater =
				new FieldUpdater<FieldTableData, Boolean>() {

					@Override
					public void update(final int index, final FieldTableData object,
							final Boolean value) {
						TypeEditView.this.changeActivationValue.fire(TypeEditView.this,
								new FieldTypeArgs(object, value));

					}
				};

		this.fieldTypeModel = new SingleSelectionModel<FieldTableData>();

		this.fieldTypeModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {
						TypeEditView.this.selectedField =
								TypeEditView.this.fieldTypeModel.getSelectedObject()
										.getFieldType();
					}
				});

		this.stateTypeModel = new SingleSelectionModel<StateTableData>();

		this.stateTypeModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {

						TypeEditView.this.selectedState =
								TypeEditView.this.stateTypeModel.getSelectedObject();
						TypeEditView.this.selectState.fire(TypeEditView.this);

					}
				});

		this.lblheader = new Label("New label");
		this.lblheader.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.lblheader.setStyleName("LabelElement");
		mainPanel.add(this.lblheader);

		final HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(5);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.add(horizontalPanel_2);

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel_2.add(verticalPanel_1);
		verticalPanel_1.setSpacing(10);
		verticalPanel_1.setWidth("356px");

		final VerticalPanel statusPanel = new VerticalPanel();
		verticalPanel_1.add(statusPanel);
		statusPanel.setStyleName("LabelElement");
		statusPanel.setSpacing(5);

		final Label lblZustnde = new Label("Zustände:");
		lblZustnde.setStyleName("LabelElement");
		statusPanel.add(lblZustnde);

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel_1.add(scrollPanel);

		this.stateTable = new CellTable<StateTableData>();
		scrollPanel.setWidget(this.stateTable);
		this.stateTable.setSize("100%", "100%");

		final TextColumn<StateTableData> stateNameColumn =
				new TextColumn<StateTableData>() {
					@Override
					public String getValue(final StateTableData object) {
						return object.getState().getName();
					}
				};
		this.stateTable.addColumn(stateNameColumn, "Zustand");

		final Column<StateTableData, Boolean> columnStart =
				new Column<StateTableData, Boolean>(new CheckboxCell()) {
					@Override
					public Boolean getValue(final StateTableData object) {
						return object.getStartState();
					}
				};
		columnStart.setFieldUpdater(startStateUpdater);
		this.stateTable.addColumn(columnStart, "Startzustand");

		final Column<StateTableData, Boolean> columnEnd =
				new Column<StateTableData, Boolean>(new CheckboxCell()) {
					@Override
					public Boolean getValue(final StateTableData object) {
						return object.getEndState();
					}
				};
		columnEnd.setFieldUpdater(endStateUpdater);

		this.stateTable.addColumn(columnEnd, "Endzustand");

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel);

		final Button btndeleteState = new Button("New button");
		horizontalPanel.add(btndeleteState);
		btndeleteState.setText("Entfernen");
		btndeleteState.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TypeEditView.this.deleteState.fire(TypeEditView.this);

			}
		});

		final Button btnAddState = new Button("New button");
		horizontalPanel.add(btnAddState);
		btnAddState.setText("Hinzufügen");
		btnAddState.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TypeEditView.this.addState.fire(TypeEditView.this);

			}
		});
		this.stateTable.setSelectionModel(this.stateTypeModel);

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_2.add(verticalPanel_2);
		verticalPanel_2.setSpacing(10);

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel_2.add(verticalPanel);
		verticalPanel.setSpacing(5);

		final Label lblFields = new Label("Felder:");
		lblFields.setStyleName("LabelElement");
		verticalPanel.add(lblFields);

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		verticalPanel_2.add(scrollPanel_1);

		this.fieldTable = new CellTable<FieldTableData>();
		scrollPanel_1.setWidget(this.fieldTable);
		this.fieldTable.setSize("100%", "100%");

		final TextColumn<FieldTableData> textColumn = new TextColumn<FieldTableData>() {
			@Override
			public String getValue(final FieldTableData object) {
				return object.getFieldType().getName();
			}
		};

		this.fieldTable.addColumn(textColumn, "Bezeichnung");

		final TextColumn<FieldTableData> columnFieldType =
				new TextColumn<FieldTableData>() {
					@Override
					public String getValue(final FieldTableData object) {
						object.getFieldType().accept(new FieldTypeVisitor() {

							@Override
							public void handleTextFieldType(
									final TextFieldType textFieldType) {
								TypeEditView.this.typeString = textFieldType.getName();
								TypeEditView.this.typeString = "Text Feld";

							}

							@Override
							public void handleSystemFieldType(
									final SystemFieldType systemFieldType) {
								TypeEditView.this.typeString = "System Feld";
							}

							@Override
							public void handleSprintFieldType(
									final SprintFieldType sprintFieldType) {
								TypeEditView.this.typeString = "Sprint Feld";
							}

							@Override
							public void handleReleaseFieldType(
									final ReleaseFieldType releaseFieldType) {

								TypeEditView.this.typeString = "Release Feld";
							}

							@Override
							public void handlePersonFieldType(
									final PersonFieldType personFieldType) {

								TypeEditView.this.typeString = "Person Feld";
							}

							@Override
							public void handlePBIFieldType(
									final PBIFieldType pbiFieldType) {

								TypeEditView.this.typeString = "PBI Feld";
							}

							@Override
							public void handleNumberFieldType(
									final NumberFieldType numberFieldType) {

								TypeEditView.this.typeString = "Number Feld";
							}

							@Override
							public void handleHintFieldType(
									final HintFieldType hintFieldType) {
								TypeEditView.this.typeString = "Hint Feld";
							}

							@Override
							public void handleEffortFieldType(
									final EffortFieldType effortFieldType) {

								TypeEditView.this.typeString = "Effort Feld";
							}

							@Override
							public void handleDateFieldType(
									final DateFieldType dateFieldType) {

								TypeEditView.this.typeString = "Date Feld";
							}

							@Override
							public
									void
									handleAcceptanceCriterionFieldType(
											final AcceptanceCriteriaFieldType acceptanceCriteriaFieldType) {

								TypeEditView.this.typeString =
										"Acceptance Criteria Feld";
							}
						});
						return TypeEditView.this.typeString;
					}

				};
		this.fieldTable.addColumn(columnFieldType, "Typ");

		final Column<FieldTableData, Boolean> columnActiv =
				new Column<FieldTableData, Boolean>(new CheckboxCell()) {
					@Override
					public Boolean getValue(final FieldTableData object) {
						return object.getActive();
					}
				};
		this.fieldTable.addColumn(columnActiv, "Aktiv");
		columnActiv.setFieldUpdater(checkboxUpdater);
		this.fieldTable.setSelectionModel(this.fieldTypeModel);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_1);

		final Button btnDeleteField = new Button("New button");
		btnDeleteField.setText("Entfernen");
		horizontalPanel_1.add(btnDeleteField);
		btnDeleteField.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				TypeEditView.this.deleteField.fire(TypeEditView.this);
			}
		});

		final Button btnaddField = new Button("New button");
		btnaddField.setText("Hinzufügen");
		horizontalPanel_1.add(btnaddField);

		final VerticalPanel verticalPanel_3 = new VerticalPanel();
		verticalPanel_3.setSpacing(15);
		mainPanel.add(verticalPanel_3);

		final Label lblNewLabel = new Label("Zustandsübergänge:");
		lblNewLabel.setStyleName("LabelElement");
		verticalPanel_3.add(lblNewLabel);

		final ScrollPanel scrollPanel_2 = new ScrollPanel();
		verticalPanel_3.add(scrollPanel_2);

		this.transitionTable = new CellTable<TransitionRule>();
		scrollPanel_2.setWidget(this.transitionTable);
		this.transitionTable.setSize("100%", "100%");

		final TextColumn<TransitionRule> columnBefore =
				new TextColumn<TransitionRule>() {
					@Override
					public String getValue(final TransitionRule object) {
						return object.getFrom().getName();
					}
				};
		this.transitionTable.addColumn(columnBefore, "Ausgangszustand");

		final TextColumn<TransitionRule> columnAfter =
				new TextColumn<TransitionRule>() {
					@Override
					public String getValue(final TransitionRule object) {
						return object.getTo().getName();
					}
				};
		this.transitionTable.addColumn(columnAfter, "Folgezustand");

		this.TransitionModel = new SingleSelectionModel<TransitionRule>();

		this.TransitionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {

						TypeEditView.this.selectedTransition =
								TypeEditView.this.TransitionModel.getSelectedObject();

					}
				});

		this.transitionTable.setSelectionModel(this.TransitionModel);

		final HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setSpacing(5);
		verticalPanel_3.add(horizontalPanel_3);

		final Button btnDeleteTransition = new Button("Entfernen");
		horizontalPanel_3.add(btnDeleteTransition);

		btnDeleteTransition.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TypeEditView.this.deleteTransition.fire(TypeEditView.this);
			}
		});

		final Button btnAddTransistion = new Button("Hinzufügen");
		btnAddTransistion.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TypeEditView.this.addTransition.fire(TypeEditView.this);
			}
		});

		horizontalPanel_3.add(btnAddTransistion);
		btnaddField.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				TypeEditView.this.addField.fire(TypeEditView.this);
			}
		});
	}

	@Override
	public void close() {
		this.changeStateStartValue.removeAllHandler();
	}

	@Override
	public void registerDeleteState(final DefaultEventHandler handler) {
		this.deleteState.add(handler);
	}

	@Override
	public void registerAddState(final DefaultEventHandler handler) {
		this.addState.add(handler);
	}

	/**
	 * event needed to handle the change of the start state.
	 * 
	 * @param handler
	 *            to handle the event, which nows the stateTypeData
	 * @return event needed for handling the change of the start state
	 */
	public EventRegistration registerChangeStartStateEvent(
			final EventHandler<TypeEditView.StateTypeArgs> handler) {
		return this.changeStateStartValue.add(handler);
	}

	/**
	 * event needed to handle the change of the end state.
	 * 
	 * @param handler
	 *            to handle the event, which nows the stateTypeData
	 */
	public void registerChangeEndStateEvent(
			final EventHandler<TypeEditView.StateTypeArgs> handler) {
		this.changeEndStateValue.add(handler);
	}

	/**
	 * event needed to handle the change of the activation.
	 * 
	 * @param handler
	 *            to handle the event, which nows the fieldTypeData
	 */
	public void registerChangeActivationEvent(
			final EventHandler<TypeEditView.FieldTypeArgs> handler) {
		this.changeActivationValue.add(handler);
	}

	@Override
	public void registerDeleteField(final DefaultEventHandler handler) {
		this.deleteField.add(handler);
	}

	@Override
	public void registerAddField(final DefaultEventHandler handler) {
		this.addField.add(handler);
	}

	@Override
	public void refreshStates(final List<StateTableData> states) {
		this.getStateTable().setRowData(states);
	}

	@Override
	public void refreshFields(final List<FieldTableData> fields) {
		this.getFieldTable().setRowData(fields);
	}

	private CellTable<FieldTableData> getFieldTable() {
		return this.fieldTable;
	}

	private CellTable<StateTableData> getStateTable() {
		return this.stateTable;
	}

	@Override
	public StateTableData getSelectedState() {
		return this.selectedState;
	}

	@Override
	public FieldType getSelectedField() {
		return this.selectedField;
	}

	@Override
	public void registerStateSelect(final DefaultEventHandler handler) {
		this.selectState.add(handler);

	}

	@Override
	public void setTheType(final TicketType type) {
		this.ticketType = type;
		this.getLblheader().setText("Bearbeiten von Ticket-Typ: " + type.getTypeName());
	}

	/**
	 * getter of the ticketType.
	 * 
	 * @return the ticketType
	 */
	public TicketType getTicketType() {
		return this.ticketType;
	}

	private Label getLblheader() {
		return this.lblheader;
	}

	private CellTable<TransitionRule> getTransitionTable() {
		return this.transitionTable;
	}

	/**
	 * displays the transition rules table.
	 * 
	 * @param rules
	 *            are the existing transition rules
	 */
	public void refreshTransitions(final List<TransitionRule> rules) {
		this.getTransitionTable().setRowData(rules);
	}

	/**
	 * getter of the selected transition rule.
	 * 
	 * @return the transition rule
	 */
	public TransitionRule getSelectedTransition() {
		return this.selectedTransition;
	}

	/**
	 * event needed to handle the delete a transition rule.
	 * 
	 * @param handler
	 *            to handle the event
	 */
	public void registerDeleteTransition(final DefaultEventHandler handler) {
		this.deleteTransition.add(handler);
	}

	/**
	 * event needed to handle the addition of a transition rule.
	 * 
	 * @param handler
	 *            to handle the event
	 */
	public void registerAddTransition(final DefaultEventHandler handler) {
		this.addTransition.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
