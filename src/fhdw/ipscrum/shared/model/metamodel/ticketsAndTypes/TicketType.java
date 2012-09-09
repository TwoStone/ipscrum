package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateProfile;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;

/**
 * A ticket-type represents meta-information about tickets. A ticket-system-user can define his own ticket-types by
 * creating instances of the concrete classes of {@link FeatureTicketType}, {@link BugTicketType} and
 * {@link TaskTicketType}.
 */
public abstract class TicketType extends IdentifiableObject {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1089238932119960814L;

	/**
	 * represents the name of the ticket type.
	 */
	private String typeName;

	/**
	 * represents the description of the ticket type.
	 */
	private String typeDescription;

	/**
	 * represents the state profile of the ticket type.
	 */
	private StateProfile stateProfile;

	/**
	 * represents all fields of the ticket type.
	 */
	private List<FieldType> allFieldTypes;

	/**
	 * represents the version number of the ticket type, which increases if the ticket type changes.
	 */
	private Integer versionNumber;
	/**
	 * older instances of this ticket type copy. the older (superseded) instances must stay in the model, because it is
	 * possible that ticket instances are typified in an old ticket type. there is always one up-to-date-object in the
	 * model
	 */
	private List<TicketType> supersededTypes;

	/* standard field types, must be initialized externally */
	/**
	 * represents the field for the name of the ticket type.
	 */
	private TextFieldType nameType;

	/**
	 * represents the field for the description of the ticket type.
	 */
	private TextFieldType descriptionType;

	/**
	 * Constructor for use in Commands!
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the ticket type
	 * @param description
	 *            of the ticket type
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public TicketType(final Model model, final String name, final String description) throws IPScrumGeneralException {
		super(model);
		this.stateProfile = new StateProfile(model);
		this.checkTicketTypeDoublets(name);
		this.typeName = name;
		this.typeDescription = description;
		this.versionNumber = 1;
		this.supersededTypes = new ArrayList<TicketType>();
		this.allFieldTypes = new ArrayList<FieldType>();
		this.putToObjectStore();
		this.initializeStandard(model.getTypeManager());

	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected TicketType() {
		super();
	}

	/**
	 * Constructor for implicit type construction for type manager.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param name
	 *            of the ticket type
	 * @param description
	 *            of the ticket type
	 * @param typeManager
	 *            : it is inserted in the type manager
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected TicketType(final Model model, final String name, final String description, final TypeManager typeManager)
			throws IPScrumGeneralException {
		super(model);
		this.stateProfile = new StateProfile(model);
		this.typeName = name;
		this.typeDescription = description;
		this.versionNumber = 1;
		this.allFieldTypes = new ArrayList<FieldType>();
		this.supersededTypes = new ArrayList<TicketType>();
		this.putToObjectStore();
		this.initializeStandard(typeManager);
	}

	/**
	 * Needed for using a visitor.
	 * 
	 * @param v
	 *            the used visitor
	 */
	public abstract void accept(TicketTypeVisitor v);

	/**
	 * adds end states.
	 * 
	 * @param endState
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addEndState(final StateType endState) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doAddEndState(endState);
		} else {
			this.doAddEndState(endState);
		}

	}

	/**
	 * 
	 * Adds existing field type to this ticket type. The ticket instance will be able to have a field according to the
	 * field type. field types can only be added one time.
	 * 
	 * @param fieldType
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public final void addFieldType(final FieldType fieldType) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.allFieldTypes.contains(fieldType)) {
			throw new DoubleDefinitionException("Feldtyp bereits für diesen Tickettypen definiert!");
		} else {
			if (this.hasInstances()) {
				final TicketType copyOfThis = this.supersedeThis();
				copyOfThis.doAddFieldType(fieldType);
			} else {
				this.doAddFieldType(fieldType);
			}
		}
	}

	/**
	 * adds a state.
	 * 
	 * @param state
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addPossibleState(final StateType state) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doAddPossibleState(state);
		} else {
			this.doAddPossibleState(state);
		}
	}

	/**
	 * adds a supersededType.
	 * 
	 * @param ticketType
	 *            to add
	 */
	public void addSupersededType(final TicketType ticketType) {
		this.supersededTypes.add(ticketType);
	}

	/**
	 * Adds a transition rule.
	 * 
	 * @param tr
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addTransitionRule(final TransitionRule tr) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doAddTransitionRule(tr);
		} else {
			this.doAddTransitionRule(tr);
		}
	}

	/**
	 * 
	 * @param field
	 *            field to be changed
	 * @param ticket
	 *            ticket, which the field belongs to
	 * @throws ConsistencyException
	 *             if the ticket type doesn't know the field type
	 * @throws ForbiddenStateException
	 *             if the current state type of the ticket doesn't allow a field change.
	 */
	public void checkFieldChange(final Field<?> field, final Ticket ticket) throws ConsistencyException,
			ForbiddenStateException {
		if (!this.getAllFieldTypes().contains(field.getType())) {
			throw new ConsistencyException("Dieser Ticket-Typ kennt ein Feld dieses Types nicht!");
		}
		this.stateProfile.checkFieldChange(field, ticket);
	}

	/**
	 * Returns all additional field types.
	 * 
	 * @return list of {@link FieldType}s
	 */
	public final List<FieldType> getAllFieldTypes() {
		return this.allFieldTypes;
	}

	/**
	 * Returns the value of the description field of the ticket.
	 * 
	 * @param ticket
	 *            ticket that contains a description field
	 * @return description of the ticket
	 */
	@SuppressWarnings("unchecked")
	public String getDescription(final Ticket ticket) {
		return ((SingleField<String>) this.getField(this.getDescriptionType(), ticket)).getValue();
	}

	/**
	 * Returns the standard field type for ticket description fields.
	 * 
	 * @return the current descriptionType
	 */
	public TextFieldType getDescriptionType() {
		return this.descriptionType;
	}

	/**
	 * returns a field of a ticket for the given field type.
	 * 
	 * @param fieldType
	 *            of the searched field
	 * @param ticket
	 *            attached
	 * @return Field<?> in the ticket with the searched type
	 */
	public Field<?> getField(final FieldType fieldType, final Ticket ticket) {
		Field<?> result = null;
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fields = ticket.getAllFields().iterator();
		while (fields.hasNext()) {
			final Field<?> current = fields.next();
			if (current.getType().equals(fieldType)) {
				result = current;
				break;
			}
		}
		return result;
	}

	/**
	 * Getter of all instances of tickets with this ticket type.
	 * 
	 * @return all the instances
	 */
	public List<Ticket> getInstances() {
		final List<Ticket> result = new ArrayList<Ticket>();
		final Iterator<Ticket> allTickets = this.getModel().getAllTickets().iterator();
		while (allTickets.hasNext()) {
			final Ticket current = allTickets.next();
			if (current.getTicketType().equals(this)) {
				result.add(current);
			}
		}
		return result;
	}

	/**
	 * Returns the value of the name field of the ticket.
	 * 
	 * @param ticket
	 *            ticket that contains a description field
	 * @return name of the ticket
	 */
	@SuppressWarnings("unchecked")
	public String getName(final Ticket ticket) {
		return ((SingleField<String>) this.getField(this.getNameType(), ticket)).getValue();
	}

	/**
	 * Getter of the fieldType representing the name of the ticketType.
	 * 
	 * @return the current nameType
	 */
	public TextFieldType getNameType() {
		return this.nameType;
	}

	/**
	 * Returns the state profile for this ticket type.
	 * 
	 * @return current stateProfile of the ticket type
	 */
	public final StateProfile getStateProfile() {
		return this.stateProfile;
	}

	/**
	 * Returns an aggregated list of superseded TicketTypes. superseded means older versions of this ticket type. when a
	 * ticket type has instances with instance.type = this and the type is changed, a new version of the type is created
	 * (with a copy of the old type) and the old version is put into this.supersededTypes.
	 * 
	 * @return list of older ticket types, in which ticket instances are typified
	 */
	public final List<TicketType> getSupersededTypes() {
		return this.supersededTypes;
	}

	/**
	 * Getter of the description of the ticket type.
	 * 
	 * @return the ticket type description
	 */
	public final String getTypeDescription() {
		return this.typeDescription;
	}

	/**
	 * Getter of the name of the ticket type.
	 * 
	 * @return the current ticket type name
	 */
	public final String getTypeName() {
		return this.typeName;
	}

	/**
	 * getter of the version number.
	 * 
	 * @return the current version number
	 */
	public final Integer getVersionNumber() {
		return this.versionNumber;
	}

	/**
	 * Returns true, if this ticket type is a standard bug, standard feature or standard task Returns false if this
	 * ticket type is a user defined task type, feature type or bug type!
	 * 
	 * @return true if this ticket type is a standard type
	 */
	public boolean isStandardTicketType() {
		return this.getModel().getTypeManager().fetchStandardTicketTypes().contains(this);
	}

	/**
	 * Removes a field type of an existing TicketType.
	 * 
	 * @param fieldType
	 *            to remove
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public final void removeFieldType(final FieldType fieldType) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.getModel().getTypeManager().fetchStandardFieldTypes().contains(fieldType)) {
			throw new ConsistencyException(ExceptionConstants.NO_CHANGE_ON_STANDARDS);
		}
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doRemoveFieldType(fieldType);
		} else {
			this.doRemoveFieldType(fieldType);
		}

	}

	/**
	 * removes a state.
	 * 
	 * @param state
	 *            to remove
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removePossibleState(final StateType state) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doRemovePossibleState(state);
		} else {
			this.doRemovePossibleState(state);
		}
	}

	/**
	 * removes a transition rule.
	 * 
	 * @param tr
	 *            to remove
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removeTransitionRule(final TransitionRule tr) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doRemoveTransitionRule(tr);
		} else {
			this.doRemoveTransitionRule(tr);
		}
	}

	/**
	 * sets a field in a state active.
	 * 
	 * @param state
	 *            in which the field should be active
	 * @param field
	 *            that should be active in the chosen state
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setActive(final StateType state, final FieldType field) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doSetActive(state, field);
		} else {
			this.doSetActive(state, field);
		}
	}

	/**
	 * Sets the standard field type for ticket description fields.
	 * 
	 * @param descriptionType
	 *            : new fieldType for the descriptionType
	 */
	public void setDescriptionType(final TextFieldType descriptionType) {
		if (!(this.descriptionType == null)) {
			return;
		}
		this.descriptionType = descriptionType;
		this.doAddFieldType(descriptionType);
	}

	/**
	 * changes the new field type for the name type.
	 * 
	 * @param nameType
	 *            : new nameType of the ticket type
	 */
	public void setNameType(final TextFieldType nameType) {
		if (!(this.nameType == null)) {
			return;
		}
		this.nameType = nameType;
		this.doAddFieldType(nameType);
	}

	/**
	 * sets a field in a state non active.
	 * 
	 * @param state
	 *            in which the field is non active
	 * @param field
	 *            that is non active in the chosen state
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setNonActive(final StateType state, final FieldType field) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doSetNonActive(state, field);
		} else {
			this.doSetNonActive(state, field);
		}
	}

	/**
	 * changes the start state.
	 * 
	 * @param startState
	 *            : new start state
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setStartState(final StateType startState) throws IPScrumGeneralException {
		this.checkStandardNotEditable();
		if (this.hasInstances()) {
			final TicketType copyOfThis = this.supersedeThis();
			copyOfThis.doSetStartState(startState);
		} else {
			this.doSetStartState(startState);
		}
	}

	/**
	 * Changes a state profile.
	 * 
	 * @param sp
	 *            to change
	 */
	public void setStateProfile(final StateProfile sp) {
		this.stateProfile = sp;
	}

	/**
	 * sets the description of a ticket.
	 * 
	 * @param description
	 *            : new description of the ticket
	 * @param ticket
	 *            to be changed
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws NoValidValueException
	 *             if the value is not valid
	 * @throws ForbiddenStateException
	 *             if the method is forbidden in the state
	 */
	public void setTicketDescription(final String description, final Ticket ticket) throws ConsistencyException,
			NoValidValueException, ForbiddenStateException {
		ticket.checkDescriptionValidity(description);
		@SuppressWarnings("unchecked")
		final SingleField<String> target = (SingleField<String>) this.getField(this.getDescriptionType(), ticket);
		target.setValue(description, ticket);
	}

	/**
	 * sets the name of a ticket.
	 * 
	 * @param name
	 *            : new name of the ticket
	 * @param ticket
	 *            to be changed
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the method is forbidden in this state
	 * @throws DoubleDefinitionException
	 *             if a ticket with the same name already exists
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */
	public void setTicketName(final String name, final Ticket ticket) throws ConsistencyException,
			ForbiddenStateException, DoubleDefinitionException, NoValidValueException {
		ticket.checkNameValidity(name);
		@SuppressWarnings("unchecked")
		final SingleField<String> target = (SingleField<String>) this.getField(this.getNameType(), ticket);
		target.setValue(name, ticket);
	}

	@Override
	public String toString() {
		return this.typeName + " " + "(Version  " + this.versionNumber + ")";
	}

	/**
	 * delegates to state profile to check if transition is allowed.
	 * 
	 * @param newState
	 *            target state of the transition
	 * @param ticket
	 *            ticket, which is attended to do a state transition
	 * @throws ForbiddenStateException
	 *             if transition is not allowed
	 */
	protected void changeState(final StateType newState, final Ticket ticket) throws ForbiddenStateException {
		this.stateProfile.changeState(newState, ticket);
		// when no exception occurred
		ticket.setState(newState);
	}

	/**
	 * adds end states to the ticket type.
	 * 
	 * @param endState
	 *            to add
	 * @throws DoubleDefinitionException
	 *             if the state is already an end state
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	protected void doAddEndState(final StateType endState) throws DoubleDefinitionException, ConsistencyException {
		this.getStateProfile().addEndState(endState);
		this.changed();
	}

	/**
	 * adds fields to the ticket type.
	 * 
	 * @param fieldType
	 *            to add
	 */
	protected final void doAddFieldType(final FieldType fieldType) {
		this.allFieldTypes.add(fieldType);
		this.getStateProfile().updateActivationRules(fieldType, true);
		this.changed();
	}

	/**
	 * adds states.
	 * 
	 * @param state
	 *            to add
	 * @throws DoubleDefinitionException
	 *             if the state is already added
	 */
	protected void doAddPossibleState(final StateType state) throws DoubleDefinitionException {
		this.getStateProfile().addPossibleState(state);
		this.changed();
	}

	/**
	 * adds the transition rule to the ticket type.
	 * 
	 * @param tr
	 *            to add
	 * @throws DoubleDefinitionException
	 *             if the transition rule is already added
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	protected void doAddTransitionRule(final TransitionRule tr) throws DoubleDefinitionException, ConsistencyException {
		this.getStateProfile().addTransitionRule(tr);
		this.changed();
	}

	/**
	 * initializes the standards.
	 * 
	 * @param typeManager
	 *            which manages the ticket type
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected abstract void doInitializeStandard(TypeManager typeManager) throws IPScrumGeneralException;

	/**
	 * initializes the stateProfile.
	 * 
	 * @param typeManager
	 *            which manages the ticket type
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected abstract void doInitializeStateProfile(TypeManager typeManager) throws IPScrumGeneralException;

	/**
	 * removes a field type form the ticket type.
	 * 
	 * @param fieldType
	 *            to remove
	 */
	protected void doRemoveFieldType(final FieldType fieldType) {
		this.allFieldTypes.remove(fieldType);
		this.getStateProfile().updateActivationRules(fieldType, false);
		this.changed();
	}

	/**
	 * removes a state from the ticket type.
	 * 
	 * @param state
	 *            to remove
	 * @throws DoubleDefinitionException
	 *             if the state is already removed
	 * @throws ConsistencyException
	 *             if the consitency is hurt
	 */
	protected void doRemovePossibleState(final StateType state) throws DoubleDefinitionException, ConsistencyException {
		this.getStateProfile().removePossibleState(state);
		this.changed();
	}

	/**
	 * removes a transition rule from the ticket type.
	 * 
	 * @param tr
	 *            to remove
	 */
	protected void doRemoveTransitionRule(final TransitionRule tr) {
		this.getStateProfile().removeTransitionRule(tr);
		this.changed();
	}

	/**
	 * sets a field active in a state.
	 * 
	 * @param state
	 *            in which the field is active
	 * @param field
	 *            that is active in the chosen state
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected void doSetActive(final StateType state, final FieldType field) throws IPScrumGeneralException {
		this.getStateProfile().setActive(state, field);
		this.changed();
	}

	/**
	 * sets a field non active in a state.
	 * 
	 * @param state
	 *            in which the field is non active
	 * @param field
	 *            that is non active in the chosen state
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected void doSetNonActive(final StateType state, final FieldType field) throws IPScrumGeneralException {
		this.getStateProfile().setNonActive(state, field);
		this.changed();
	}

	/**
	 * Setter of the start state.
	 * 
	 * @param startState
	 *            the state that should become the start state
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	protected void doSetStartState(final StateType startState) throws ConsistencyException {
		this.getStateProfile().setStartState(startState);
		this.changed();
	}

	/**
	 * increments the version number if the ticket type changed.
	 */
	protected void incrementVersionNumber() {
		this.versionNumber++;
	}

	/**
	 * Setter of the version number of the ticket type.
	 * 
	 * @param versionNumber
	 *            the new version number
	 */
	protected void setVersionNumber(final Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	/**
	 * checks if a standard ticket type wanted to be changed and informs that this is forbidden.
	 * 
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	private void checkStandardNotEditable() throws ConsistencyException {
		if (this.isStandardTicketType()) {
			throw new ConsistencyException("Änderungen am Standard sind nicht erlaubt!");
		}
	}

	/**
	 * Checks if doublets of ticket types exist.
	 * 
	 * @param name
	 *            of the ticket type
	 * @throws DoubleDefinitionException
	 *             if doublets exist
	 */
	private void checkTicketTypeDoublets(final String name) throws DoubleDefinitionException {
		final Iterator<TicketType> activeTicketTypesIterator =
				this.getModel().getTypeManager().getActiveTicketTypes().iterator();
		while (activeTicketTypesIterator.hasNext()) {
			final TicketType current = activeTicketTypesIterator.next();
			if (current.getTypeName().equals(name)) {
				throw new DoubleDefinitionException("Fehler: Ein Ticket-Typ mit diesem Namen existiert bereits!");
			}
		}

	}

	/**
	 * Checks if instances of the ticket type exist.
	 * 
	 * @return true, if instances exist
	 */
	private boolean hasInstances() {
		boolean result = false;
		if (!this.getInstances().isEmpty()) {
			result = true;
		}
		return result;
	}

	/**
	 * Initializes the standards of the ticket types.
	 * 
	 * @param typeManager
	 *            the ticket type is related to
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private void initializeStandard(final TypeManager typeManager) throws IPScrumGeneralException {
		this.doInitializeStateProfile(typeManager);
		this.doInitializeStandard(typeManager);
	}

	/**
	 * Provides a copy of this and adds this to copyOfThis.supersededTypes. Instances of this will keep their
	 * associations, if a ticket type changes!
	 * 
	 * @return the copy of the current ticket type
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private TicketType supersedeThis() throws IPScrumGeneralException {
		final TicketType copyOfThis = this.getModel().getTypeManager().provideTicketTypeCopy(this);
		final Iterator<TicketType> supersededFieldTypesIterator = this.supersededTypes.iterator();
		while (supersededFieldTypesIterator.hasNext()) {
			final TicketType current = supersededFieldTypesIterator.next();
			copyOfThis.addSupersededType(current);
		}
		copyOfThis.addSupersededType(this);
		return copyOfThis;
	}

}
