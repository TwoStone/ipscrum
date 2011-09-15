package fhdw.ipscrum.shared.model.metamodel.states;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * Represents the StateProfile of TicketTypes.
 */
public class StateProfile extends IdentifiableObject {

	/**
	 * Represents the serialVerisonUID.
	 */
	private static final long serialVersionUID = -5537373457466520721L;

	/**
	 * Represents the states in the stateProfile.
	 */
	private List<StateType> possibleStates;

	/**
	 * Represents the endStates in the stateProfile.
	 */
	private List<StateType> endStates;

	/**
	 * Represents the startState in the stateProfile.
	 */
	private StateType startState;

	/**
	 * Represents the transitionRule of the stateProfile.
	 */
	private List<TransitionRule> transitionRules;

	/**
	 * Represents the activationRuels of the stateProfile.
	 */
	private List<ActivationRule> activationRules;

	/**
	 * Represents the fact if a field is active.
	 */
	private Boolean isFieldActive;

	/**
	 * determines a change or transition to be allowed.
	 */
	private boolean allowed;

	/**
	 * Constructor of the stateProfile.
	 * 
	 * @param model
	 *            : it is inderted in the model
	 */
	public StateProfile(final Model model) {
		super(model);
		this.possibleStates = new ArrayList<StateType>();
		this.endStates = new ArrayList<StateType>();
		this.startState = null;
		this.transitionRules = new ArrayList<TransitionRule>();
		this.activationRules = new ArrayList<ActivationRule>();
		this.putToObjectStore();
	}

	/**
	 * Constructor without paramters. Needed for serialization.
	 */
	protected StateProfile() {
		super();
	}

	/**
	 * Adds a activationRule.
	 * 
	 * @param ar
	 *            is the activationRule to add
	 * @throws DoubleDefinitionException
	 *             if the activationRule is already added
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public final void addActivationRule(final ActivationRule ar)
			throws DoubleDefinitionException, ConsistencyException {
		if (this.activationRules.contains(ar)) {
			throw new DoubleDefinitionException("Regel bereits definiert!");
		}
		if (!this.possibleStates.contains(ar.getForState())) {
			throw new ConsistencyException(ExceptionConstants.STATE_NOT_DEFINDED);
		}
		this.activationRules.add(ar);
	}

	/**
	 * Add states as endStates.
	 * 
	 * @param state
	 *            that is added as a endState
	 * @throws DoubleDefinitionException
	 *             if the state is already a endState
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public final void addEndState(final StateType state)
			throws DoubleDefinitionException, ConsistencyException {
		if (this.endStates.contains(state)) {
			throw new DoubleDefinitionException("Bereits als Endzustand definiert!");
		}
		if (!this.possibleStates.contains(state)) {
			throw new ConsistencyException(
					"Dieser Zustand ist in diesem Zustandsprofil nicht definiert!");
		}
		this.endStates.add(state);
	}

	/**
	 * Adds states to the stateProfile.
	 * 
	 * @param state
	 *            that should be added
	 * @throws DoubleDefinitionException
	 *             if the state is already added
	 */
	public final void addPossibleState(final StateType state)
			throws DoubleDefinitionException {
		if (state != null) {
			if (this.possibleStates.contains(state)) {
				throw new DoubleDefinitionException("Zustand bereits definiert!");
			}
			this.possibleStates.add(state);
			this.updateActivationRules(state, true);
		}
	}

	/**
	 * adds a transitionRule to the state profile.
	 * 
	 * @param tr
	 *            is the transitionRule to add
	 * @throws DoubleDefinitionException
	 *             if the transitionRule is already defined
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public final void addTransitionRule(final TransitionRule tr)
			throws DoubleDefinitionException, ConsistencyException {
		if (this.transitionRules.contains(tr)) {
			throw new DoubleDefinitionException("Zustandsübergang bereits definiert");
		}
		if (!(this.possibleStates.contains(tr.getFrom()) && this.possibleStates
				.contains(tr.getTo()))) {
			throw new ConsistencyException(
					"Zustände sind in diesem Zustandsprofil nicht definiert");
		}
		if (tr.getFrom().equals(tr.getTo())) {
			throw new ConsistencyException("Die Zustände müssen verschieden sein!");
		}
		this.transitionRules.add(tr);
	}

	/**
	 * iterates over transition rules and checks, if there is a transitionrule with from
	 * == ticket.currentState and to == new state.
	 * 
	 * @param newState
	 *            is the state to which the transitionRule goes
	 * @param ticket
	 *            is the ticket from which the currentState is needed
	 * @throws ForbiddenStateException
	 *             if transition is not allowed
	 */
	public void changeState(final StateType newState, final Ticket ticket)
			throws ForbiddenStateException {
		final Iterator<TransitionRule> trs = this.getTransitionRules().iterator();
		boolean changeAllowed = false;
		while (trs.hasNext()) {
			final TransitionRule current = trs.next();
			if (current.getFrom().equals(ticket.getCurrentState())
					&& current.getTo().equals(newState)) {
				changeAllowed = true;
				break;
			}
		}
		if (!changeAllowed) {
			throw new ForbiddenStateException("Zustandsübergang nicht erlaubt!");
		}
	}

	/**
	 * checks the changability of the field in the current state of the ticket.
	 * 
	 * @param field
	 *            field to be changed
	 * @param ticket
	 *            ticket, which the field belongs to
	 * @throws ForbiddenStateException
	 *             if the current state type of the ticket doesn't allow a field change.
	 */
	public void checkFieldChange(@SuppressWarnings("rawtypes") final Field field,
			final Ticket ticket) throws ForbiddenStateException {
		final StateType currentState = ticket.getCurrentState();
		final FieldType fieldType = field.getType();
		final Iterator<ActivationRule> ars = this.getActivationRules().iterator();
		while (ars.hasNext()) {
			final ActivationRule current = ars.next();
			if (currentState.equals(current.getForState())
					&& fieldType.equals(current.getForField())) {
				current.accept(new ActivationRuleVisitor() {

					@Override
					public void handleActive(final Active active) {
						StateProfile.this.setAllowed(true);
					}

					@Override
					public void handleNonActive(final NonActive nonActive) {
						StateProfile.this.setAllowed(false);
					}
				});
			}
		}
		if (!this.allowed) {
			throw new ForbiddenStateException(
					"Änderung in diesem Zustand nicht erlaubt");
		}
	}

	/**
	 * getter of all activationRules of the state profile.
	 * 
	 * @return the current activation rules
	 */
	public final List<ActivationRule> getActivationRules() {
		return this.activationRules;
	}

	/**
	 * getter of the endstates of the state profile.
	 * 
	 * @return the current endstates
	 */
	public final List<StateType> getEndStates() {
		return this.endStates;
	}

	/**
	 * getter of the possible states of the state profile.
	 * 
	 * @return the current possible states
	 */
	public final List<StateType> getPossibleStates() {
		return this.possibleStates;
	}

	/**
	 * getter of a specified activationRule related to the state an the field.
	 * 
	 * @param forState
	 *            is the state for which the activationRule is searched
	 * @param forField
	 *            is the field for which the activationRule is searched
	 * @return the searched activationRule
	 */
	public final ActivationRule getSpecificActivationRule(final StateType forState,
			final FieldType forField) {
		ActivationRule result = null;
		final Iterator<ActivationRule> ars = this.getActivationRules().iterator();
		while (ars.hasNext()) {
			final ActivationRule current = ars.next();
			if (current.getForField().equals(forField)
					&& current.getForState().equals(forState)) {
				result = current;
				break;
			}
		}
		return result;
	}

	/**
	 * getter of the startState of the state profile.
	 * 
	 * @return the current startState
	 */
	public final StateType getStartState() {
		return this.startState;
	}

	/**
	 * getter of all transitionRules of the state profile.
	 * 
	 * @return all the current transitionRules
	 */
	public List<TransitionRule> getTransitionRules() {
		return this.transitionRules;
	}

	/**
	 * checks if a field is in a selected state active.
	 * 
	 * @param type
	 *            is the selected state
	 * @param field
	 *            is the selected field
	 * @return true, if the field is in the state active
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public Boolean isFieldActive(final StateType type, final FieldType field)
			throws IPScrumGeneralException {

		final ActivationRule ar = this.findActivationRule(type, field);

		ar.accept(new ActivationRuleVisitor() {

			@Override
			public void handleActive(final Active active) {
				StateProfile.this.isFieldActive = true;
			}

			@Override
			public void handleNonActive(final NonActive nonActive) {
				StateProfile.this.isFieldActive = false;
			}
		});
		return this.isFieldActive;
	}

	/**
	 * removes one of the endstates of the state profile.
	 * 
	 * @param state
	 *            is the endstate to remove
	 */
	public final void removeEndState(final StateType state) {
		this.endStates.remove(state);
	}

	/**
	 * Removes a possible state. the state to be removed may not be the start state. If
	 * there exist transition rules which refer to state, they will be removed!
	 * 
	 * @param state
	 *            the state to be removed!
	 * @throws ConsistencyException
	 *             If state is the start state or the state is not defined in the state
	 *             profile
	 */
	public final void removePossibleState(final StateType state)
			throws ConsistencyException {
		if (!this.getPossibleStates().contains(state)) {
			throw new ConsistencyException(
					"Der zu entfernende Zustand ist für diesen Ticket-Typen nicht definiert!");
		}
		if (this.getStartState().equals(state)) {
			throw new ConsistencyException(
					"Der zu löschende Zustand ist der Startzustand. Vor dem Löschen bitte"
							+ " einen anderen Startzustand definieren! ");
		}
		this.possibleStates.remove(state);
		this.updateActivationRules(state, false);
		this.removeTransitionRulesForState(state);
	}

	/**
	 * removes a transitionRule from the state profile.
	 * 
	 * @param tr
	 *            is the transitionRule to remove
	 */
	public final void removeTransitionRule(final TransitionRule tr) {
		this.transitionRules.remove(tr);
	}

	/**
	 * sets a field for a state active.
	 * 
	 * @param forState
	 *            is the state in which the field should be active
	 * @param forFieldType
	 *            is the field which should be active
	 * @throws IPScrumGeneralException
	 *             if something fails.
	 */
	public void setActive(final StateType forState, final FieldType forFieldType)
			throws IPScrumGeneralException {
		final ActivationRule target = this.findActivationRule(forState, forFieldType);
		this.activationRules.remove(target);
		this.addActivationRule(new Active(this.getModel(), forState, forFieldType));
	}

	/**
	 * sets a field or a state non active.
	 * 
	 * @param forState
	 *            in which the field should be non active
	 * @param forFieldType
	 *            which should be non active in the field
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setNonActive(final StateType forState, final FieldType forFieldType)
			throws IPScrumGeneralException {
		final ActivationRule target = this.findActivationRule(forState, forFieldType);
		this.activationRules.remove(target);
		this.addActivationRule(new NonActive(this.getModel(), forState, forFieldType));
	}

	/**
	 * sets a state as the start state.
	 * 
	 * @param startState
	 *            is the state which should be the start state
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public final void setStartState(final StateType startState)
			throws ConsistencyException {
		if (!this.possibleStates.contains(startState)) {
			throw new ConsistencyException(ExceptionConstants.STATE_NOT_DEFINDED);
		}
		this.startState = startState;
	}

	/**
	 * updates the activationRules for a fieldType.
	 * 
	 * @param fieldType
	 *            to update the activationRules for
	 * @param added
	 *            says if a new activationRule should be added
	 */
	public final void updateActivationRules(final FieldType fieldType,
			final boolean added) {
		final Iterator<StateType> stateTypes = this.getPossibleStates().iterator();
		while (stateTypes.hasNext()) {
			final StateType current = stateTypes.next();
			if (added) {
				final ActivationRule ar =
						this.defaultActivationRule(current, fieldType);
				this.activationRules.add(ar);
			} else {
				final ActivationRule ar =
						this.getSpecificActivationRule(current, fieldType);
				this.activationRules.remove(ar);
			}
		}
	}

	/**
	 * sets the default activationRule.
	 * 
	 * @param forState
	 *            the state for which this default activationRule should be set
	 * @param forField
	 *            is the field which should be set default in the selected state
	 * @return the new activationRule
	 */
	private ActivationRule defaultActivationRule(final StateType forState,
			final FieldType forField) {
		ActivationRule result;
		result = new NonActive(this.getModel(), forState, forField);
		return result;
	}

	/**
	 * searches an activationRule related to the state and the field.
	 * 
	 * @param forState
	 *            is the state for which the activationRule is searched
	 * @param forFieldType
	 *            is the field for which the activationRule is searched
	 * @return the found activationRule
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private ActivationRule findActivationRule(final StateType forState,
			final FieldType forFieldType) throws IPScrumGeneralException {
		ActivationRule result = null;
		final Iterator<ActivationRule> ars = this.getActivationRules().iterator();
		while (ars.hasNext()) {
			final ActivationRule current = ars.next();
			if (current.getForState().equals(forState)
					&& current.getForField().equals(forFieldType)) {
				result = current;
			}
		}
		if (result == null) {
			throw new ConsistencyException(""
					+ "Fehler: Es wurde versucht, eine Zugriffsregel zu ändern. "
					+ "Diese kann jedoch im Zustandsprofil nicht gefunden werden!");
		}
		return result;
	}

	/**
	 * getter of all fieldTypes of the state profile.
	 * 
	 * @return all current fieldTypes
	 */
	private List<FieldType> getFieldTypes() {
		final TicketType ticketType = this.getTicketType();
		if (ticketType == null) {
			return null;
		} else {
			return ticketType.getAllFieldTypes();
		}
	}

	/**
	 * getter of the ticketType related to the state profile.
	 * 
	 * @return the related ticketType
	 */
	private TicketType getTicketType() {
		return this.getModel().getTicketTypeByStateProfile(this);
	}

	/**
	 * removes all transition rules for a state that has been removed from the possible
	 * states list.
	 * 
	 * @param state
	 *            from that the transition rule should be removed
	 */
	private void removeTransitionRulesForState(final StateType state) {
		final Iterator<TransitionRule> trs = this.getTransitionRules().iterator();
		while (trs.hasNext()) {
			final TransitionRule current = trs.next();
			if (current.getFrom().equals(state) || current.getTo().equals(state)) {
				trs.remove();
			}
		}
	}

	/**
	 * sets the flag allowed.
	 * 
	 * @param allowed
	 *            must be true if something should be allowed
	 */
	private void setAllowed(final boolean allowed) {
		this.allowed = allowed;

	}

	/**
	 * updates the activation rules of the state profile.
	 * 
	 * @param stateType
	 *            is the related state
	 * @param added
	 *            if it is true a new activationRule for this state is added
	 */
	private void updateActivationRules(final StateType stateType, final boolean added) {
		if (this.getFieldTypes() != null) {
			final Iterator<FieldType> fieldTypes = this.getFieldTypes().iterator();
			while (fieldTypes.hasNext()) {
				final FieldType current = fieldTypes.next();
				if (added) {
					final ActivationRule ar =
							this.defaultActivationRule(stateType, current);
					this.activationRules.add(ar);
				} else {
					final ActivationRule ar =
							this.getSpecificActivationRule(stateType, current);
					this.activationRules.remove(ar);
				}
			}
		}
	}

}
