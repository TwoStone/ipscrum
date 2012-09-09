package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.view.FieldTableData;
import fhdw.ipscrum.client.view.StateTableData;
import fhdw.ipscrum.client.view.TypeEditView;
import fhdw.ipscrum.client.view.TypeEditView.FieldTypeArgs;
import fhdw.ipscrum.client.view.TypeEditView.StateTypeArgs;
import fhdw.ipscrum.client.viewinterfaces.ITypeEditView;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsEndstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsStartstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateProfile;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * This class represents the presenter which controls the view to edit TicketTypes.
 */
public class TypeEditPresenter extends WritePresenter {

	/**
	 * Represents the ticketType related to this presenter which should be edit.
	 */
	private TicketType type;

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private TypeEditView view;

	/**
	 * Handles the event when the start state was changend in the view.
	 */
	private final EventHandler<StateTypeArgs> changeStartStateHandler = new EventHandler<TypeEditView.StateTypeArgs>() {
		@Override
		public void onUpdate(final Object sender, final StateTypeArgs eventArgs) {
			TypeEditPresenter.this.changeStartState(eventArgs.getStateData(), eventArgs.getBool());

		}

	};

	/**
	 * Handles the event when a field should be added.
	 */
	private final DefaultEventHandler addFieldHandler = new DefaultEventHandler() {

		@Override
		public void onUpdate(final Object sender, final EventArgs eventArgs) {
			TypeEditPresenter.this.startPresenter(new AddFieldsToTicketTypePresenter(TypeEditPresenter.this
					.getContext(), TypeEditPresenter.this.type));
		}
	};

	/**
	 * Handles the event when a state should be added.
	 */
	private final DefaultEventHandler addStateHandler = new DefaultEventHandler() {

		@Override
		public void onUpdate(final Object sender, final EventArgs eventArgs) {

			TypeEditPresenter.this.startPresenter(new AddStatesToTicketTypePresenter(TypeEditPresenter.this
					.getContext(), TypeEditPresenter.this.type));

		}
	};

	/**
	 * Handles the event when a field should be deleted.
	 */
	private final DefaultEventHandler deleteFieldHandler = new DefaultEventHandler() {

		@Override
		public void onUpdate(final Object sender, final EventArgs eventArgs) {

			TypeEditPresenter.this.beginTransaction();
			try {
				TypeEditPresenter.this.doCommand(new TicketTypeRemoveFieldTypeCommand(TypeEditPresenter.this.type,
						TypeEditPresenter.this.view.getSelectedField()));
				TypeEditPresenter.this.commitTransaction();
				TypeEditPresenter.this.updateView();
			} catch (final IPScrumGeneralException e) {
				TypeEditPresenter.this.getContext().getToastMessageController().toastMessage(e.getMessage());
				TypeEditPresenter.this.rollbackTransaction();
			}

		}
	};

	/**
	 * Handles the event when a state should be deleted.
	 */
	private final DefaultEventHandler deleteStateHandler = new DefaultEventHandler() {

		@Override
		public void onUpdate(final Object sender, final EventArgs eventArgs) {

			TypeEditPresenter.this.beginTransaction();
			try {
				TypeEditPresenter.this.doCommand(new TicketTypeRemoveStateTypeCommand(TypeEditPresenter.this.type,
						TypeEditPresenter.this.view.getSelectedState().getState()));
				TypeEditPresenter.this.commitTransaction();
				TypeEditPresenter.this.updateView();
			} catch (final IPScrumGeneralException e) {
				TypeEditPresenter.this.getContext().getToastMessageController().toastMessage(e.getMessage());
				TypeEditPresenter.this.rollbackTransaction();
			}

		}
	};

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TypeEditPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param type
	 *            is the related TicketType to edit
	 */
	public TypeEditPresenter(final ClientContext context, final TicketType type) {
		super(context);

		this.type = type;
	}

	@Override
	public String getName() {
		return "Tickettyp bearbeiten";
	}

	@Override
	public ITypeEditView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTypeEditView();

			this.view.registerChangeStartStateEvent(this.changeStartStateHandler);

			this.view.registerAddField(this.addFieldHandler);
			this.view.registerAddState(this.addStateHandler);
			this.view.registerDeleteField(this.deleteFieldHandler);

			this.view.registerDeleteState(this.deleteStateHandler);
			this.view.registerStateSelect(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {

					TypeEditPresenter.this.fillActivatedFields(TypeEditPresenter.this.view.getSelectedState());

				}
			});

			this.view.registerChangeEndStateEvent(new EventHandler<TypeEditView.StateTypeArgs>() {

				@Override
				public void onUpdate(final Object sender, final StateTypeArgs eventArgs) {

					TypeEditPresenter.this.beginTransaction();
					try {
						TypeEditPresenter.this.doCommand(new TicketTypeSetStatetypeAsEndstatetypeCommand(
								TypeEditPresenter.this.type, eventArgs.getStateData().getState()));
						TypeEditPresenter.this.commitTransaction();
						TypeEditPresenter.this.updateView();
					} catch (final IPScrumGeneralException e) {
						TypeEditPresenter.this.getContext().getToastMessageController().toastMessage(e.getMessage());
						TypeEditPresenter.this.rollbackTransaction();

					}

				}
			});

			this.view.registerChangeActivationEvent(new EventHandler<TypeEditView.FieldTypeArgs>() {

				@Override
				public void onUpdate(final Object sender, final FieldTypeArgs eventArgs) {

					if (TypeEditPresenter.this.view.getSelectedState() != null) {

						TypeEditPresenter.this.beginTransaction();
						try {
							TypeEditPresenter.this.doCommand(new TicketTypeSetFieldTypeActivityCommand(
									TypeEditPresenter.this.type, eventArgs.getFieldData().getFieldType(),
									TypeEditPresenter.this.view.getSelectedState().getState(), eventArgs.getBool()));
							TypeEditPresenter.this.commitTransaction();
							TypeEditPresenter.this.updateView();
						} catch (final IPScrumGeneralException e) {
							TypeEditPresenter.this.getContext().getToastMessageController()
									.toastMessage(e.getMessage());
							TypeEditPresenter.this.rollbackTransaction();
						}

					} else {
						TypeEditPresenter.this.getContext().getToastMessageController()
								.toastMessage("Kein Zustand makiert!");
					}
				}
			});

			this.view.registerAddTransition(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {

					TypeEditPresenter.this.startPresenter(new StateTransitionCreatePresenter(TypeEditPresenter.this
							.getContext(), TypeEditPresenter.this.type));
					TypeEditPresenter.this.updateView();

				}
			});

			this.view.registerDeleteTransition(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					if (TypeEditPresenter.this.view.getSelectedTransition() != null) {
						TypeEditPresenter.this.beginTransaction();
						try {
							TypeEditPresenter.this.doCommand(new TransitionRuleDeleteCommand(
									TypeEditPresenter.this.view.getSelectedTransition(), TypeEditPresenter.this.type));
							TypeEditPresenter.this.commitTransaction();
							TypeEditPresenter.this.updateView();
						} catch (final IPScrumGeneralException e) {
							TypeEditPresenter.this.getContext().getToastMessageController()
									.toastMessage(e.getMessage());
							TypeEditPresenter.this.rollbackTransaction();

						}
					} else {
						TypeEditPresenter.this.getContext().getToastMessageController()
								.toastMessage("Kein Übergang makiert");
					}
				}
			});
		}
		return this.view;
	}

	/**
	 * This method is needed to fill the field which shows if a fieldType is active or non active in a state.
	 * 
	 * @param selectedState
	 *            is the state for which this is done
	 */
	protected void fillActivatedFields(final StateTableData selectedState) {

		final List<FieldType> list = this.type.getAllFieldTypes();
		final List<FieldTableData> resultList = new ArrayList<FieldTableData>();

		if (selectedState != null) {
			try {

				final StateProfile stateprofile = this.type.getStateProfile();

				for (final FieldType fieldType : list) {
					Boolean active;

					active = stateprofile.isFieldActive(selectedState.getState(), fieldType);
					resultList.add(new FieldTableData(fieldType, active));
				}
				this.view.refreshFields(resultList);

			} catch (final IPScrumGeneralException e) {
				this.getContext().getToastMessageController().toastMessage(e.getMessage());

			}

		} else {
			for (final FieldType fieldType : list) {

				resultList.add(new FieldTableData(fieldType, false));

				this.view.refreshFields(resultList);
			}
		}
	}

	/**
	 * this method is needed for changing the start state.
	 * 
	 * @param stateData
	 *            is the state which should become the new startState
	 * @param bool
	 *            must be true to set this state as startState
	 */
	private void changeStartState(final StateTableData stateData, final Boolean bool) {
		this.beginTransaction();
		try {
			if (bool) {
				this.doCommand(new TicketTypeSetStatetypeAsStartstatetypeCommand(this.type, stateData.getState()));
				this.commitTransaction();
				this.updateView();
			} else {
				this.getContext().getToastMessageController()
						.toastMessage("Ein Startzustand muss immer vorhanden sein!");
			}
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();

		}
	}

	@Override
	public void updateView() {
		this.fillStateTable();
		this.fillActivatedFields(this.view.getSelectedState());
		this.view.refreshTransitions(this.type.getStateProfile().getTransitionRules());
		this.view.setTheType(this.type);
	}

	/**
	 * this method fills the table of the states related to the ticketType.
	 */
	private void fillStateTable() {
		final List<StateType> list = this.type.getStateProfile().getPossibleStates();

		final StateProfile stateprofile = this.type.getStateProfile();

		final List<StateTableData> resultList = new ArrayList<StateTableData>();
		for (final StateType stateType : list) {
			final Boolean start = stateprofile.getStartState().equals(stateType);
			final Boolean end = stateprofile.getEndStates().contains(stateType);

			resultList.add(new StateTableData(stateType, start, end));
		}

		this.view.refreshStates(resultList);
	}

	@Override
	public void onModelUpdate() {
		this.type = this.updateObject(this.type);
		this.updateView();
	}

}
