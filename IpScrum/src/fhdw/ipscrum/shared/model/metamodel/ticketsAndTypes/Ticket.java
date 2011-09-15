package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldTypeStandardVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Hint;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;

/**
 * A ticket central objects of the ticket-system. product backlog items and tasks are
 * defined as tickets. this class defines the general behaviour of tickets. tickets are
 * always typified in ticket types (See {@link TicketType} for more information. All
 * attributes of tickets are modeled as fields (See class {@link Field}). the state of a
 * ticket ist defined his reference to a {@link StateType}. States are managed by the
 * state profile of the ticket-type.
 */
public abstract class Ticket extends IdentifiableObject {

	/**
	 * represents the serialVerisonUID.
	 */
	private static final long serialVersionUID = 1403934647404318208L;
	/**
	 * the ticket type, which defines the behaviour of the ticket. a ticket never changes
	 * its type.
	 */
	private TicketType ticketType;
	/**
	 * represents the current state of the ticket.
	 */
	private StateType currentState;

	/**
	 * represents all fields of the ticket.
	 */
	@SuppressWarnings("rawtypes")
	private List<Field> allFields;

	/*
	 * helper attributes for getAllXXXFields-methods
	 */
	/**
	 * represents all textFields of the ticket.
	 */
	private List<Field<String>> textFieldList;

	/**
	 * represents all dateFields of the ticket.
	 */
	private List<Field<Date>> dateFieldList;

	/**
	 * represents all numberFields of the ticket.
	 */
	private List<Field<Long>> numberFieldList;

	/**
	 * represents all personFields of the ticket.
	 */
	private List<Field<Person>> personFieldList;

	/**
	 * represents all effortFields of the ticket.
	 */
	private List<Field<Effort>> effortFieldList;

	/**
	 * represents all sprintFields of the ticket.
	 */
	private List<Field<Sprint>> sprintFieldList;

	/**
	 * represents all releaseFields of the ticket.
	 */
	private List<Field<Release>> releaseFieldList;

	/**
	 * represents all pbiFields of the ticket.
	 */
	private List<Field<ProductBacklogItem>> pbiFieldList;

	/**
	 * represents all systemFields of the ticket.
	 */
	private List<Field<fhdw.ipscrum.shared.model.nonMeta.System>> systemFieldList;

	/**
	 * represents all acceptanceCriteriaFields of the ticket.
	 */
	private List<Field<AcceptanceCriterion>> acceptanceCriteriaFieldList;

	/**
	 * represents all hintFields of the ticket.
	 */
	private List<Field<Hint>> hintFieldList;

	/**
	 * Constructor of the Ticket.
	 * 
	 * @param model
	 *            : the ticket is inserted in the model
	 * @param ticketType
	 *            of the ticket
	 * @param name
	 *            of the ticket
	 * @param description
	 *            of ticket
	 * @throws NoValidValueException
	 *             if one value is not valid
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the ticket is in a fobidden state to do this
	 * @throws DoubleDefinitionException
	 *             if a ticket with the same parameters already exists
	 */
	@SuppressWarnings("rawtypes")
	public Ticket(final Model model, final TicketType ticketType, final String name,
			final String description)
			throws NoValidValueException, ConsistencyException,
			ForbiddenStateException, DoubleDefinitionException {
		super(model);
		this.ticketType = ticketType;
		this.currentState = ticketType.getStateProfile().getStartState();
		this.allFields = new ArrayList<Field>();
		this.initializeFields(ticketType);
		this.initializeFieldLists();
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected Ticket() {
		super();
	}

	/**
	 * Changes the state of the ticket.
	 * 
	 * @param newState
	 *            of the ticket after the change
	 * @throws ForbiddenStateException
	 *             if the state is forbidden or a change from the current state in the new
	 *             is forbidden
	 */
	public void changeState(final StateType newState) throws ForbiddenStateException {
		this.getTicketType().changeState(newState, this);
	}

	/**
	 * checks the conditions to change a field. If the conditions doesn't allow a change,
	 * an exception will be thrown.
	 * 
	 * @param field
	 *            the field to be changed
	 * @throws ConsistencyException
	 *             if the ticket type doesn't know the field type
	 * @throws ForbiddenStateException
	 *             if the current state type of the ticket doesn't allow a field change.
	 */
	public void checkFieldChange(@SuppressWarnings("rawtypes") final Field field)
			throws ConsistencyException, ForbiddenStateException {
		this.getTicketType().checkFieldChange(field, this);
	}

	/**
	 * Getter of all AcceptanceCritiriaFields of the ticket.
	 * 
	 * @return all AcceptanceCriteriaFields of the ticket
	 */
	public List<Field<AcceptanceCriterion>> getAllAcceptanceCriteriaFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void handleAcceptanceCriterionFieldType(
						final AcceptanceCriteriaFieldType acceptanceCriteriaFieldType) {
					Ticket.this
							.addToAcceptanceCriteriaFieldList((Field<AcceptanceCriterion>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.acceptanceCriteriaFieldList;
	}

	/**
	 * Getter of all DateFields of the ticket.
	 * 
	 * @return all DateFields of the ticket
	 */
	public List<Field<Date>> getAllDateFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void handleDateFieldType(final DateFieldType dateFieldType) {
					Ticket.this.addToDateFieldList((Field<Date>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.dateFieldList;
	}

	/**
	 * Getter of all EffortFields of the ticket.
	 * 
	 * @return all EffortFields of the ticket
	 */
	public List<Field<Effort>> getAllEffortFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void
						handleEffortFieldType(final EffortFieldType effortFieldType) {
					Ticket.this.addToEffortFieldList((Field<Effort>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.effortFieldList;
	}

	/**
	 * Getter of all Fields of the ticket.
	 * 
	 * @return all Fields of the ticket
	 */
	@SuppressWarnings("rawtypes")
	public final List<Field> getAllFields() {
		return this.allFields;
	}

	/**
	 * Getter of all HintFields of the ticket.
	 * 
	 * @return all HintFields of the ticket
	 */
	public List<Field<Hint>> getAllHintFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void handleHintFieldType(final HintFieldType hintFieldType) {
					Ticket.this.addToHintFieldList((Field<Hint>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.hintFieldList;
	}

	/**
	 * Getter of all NumberFields of the ticket.
	 * 
	 * @return all NumberFields of the ticket
	 */
	public List<Field<Long>> getAllNumberFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void
						handleNumberFieldType(final NumberFieldType numberFieldType) {
					Ticket.this.addToNumberFieldList((Field<Long>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.numberFieldList;
	}

	/**
	 * Getter of all PBIFields of the ticket.
	 * 
	 * @return all PBIFields of the ticket
	 */
	public List<Field<ProductBacklogItem>> getAllPBIFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void handlePBIFieldType(final PBIFieldType pbiFieldType) {
					Ticket.this.addToPBIFieldList((Field<ProductBacklogItem>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.pbiFieldList;
	}

	/**
	 * Getter of all PersonFields of the ticket.
	 * 
	 * @return all PersonFields of the ticket
	 */
	public List<Field<Person>> getAllPersonFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void
						handlePersonFieldType(final PersonFieldType personFieldType) {
					Ticket.this.addToPersonFieldList((Field<Person>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.personFieldList;
	}

	/**
	 * Getter of all ReleaseFields of the ticket.
	 * 
	 * @return all ReleaseFields of the ticket
	 */
	public List<Field<Release>> getAllReleaseFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void handleReleaseFieldType(
						final ReleaseFieldType releaseFieldType) {
					Ticket.this.addToReleaseFieldList((Field<Release>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.releaseFieldList;
	}

	/**
	 * Getter of all SprintFields of the ticket.
	 * 
	 * @return all SprintFields of the ticket
	 */
	public List<Field<Sprint>> getAllSprintFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void
						handleSprintFieldType(final SprintFieldType sprintFieldType) {
					Ticket.this.addToSprintFieldList((Field<Sprint>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.sprintFieldList;
	}

	/**
	 * Getter of all SystemFields of the ticket.
	 * 
	 * @return all SystemFields of the ticket
	 */
	public List<Field<fhdw.ipscrum.shared.model.nonMeta.System>> getAllSystemFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {

				@SuppressWarnings("unchecked")
				@Override
				public void
						handleSystemFieldType(final SystemFieldType systemFieldType) {
					Ticket.this
							.addToSystemFieldList((Field<fhdw.ipscrum.shared.model.nonMeta.System>) current);
				}

				@Override
				public void standardHandling() {
				}

			});
		}
		return this.systemFieldList;
	}

	/**
	 * Getter of all TextFields of the ticket.
	 * 
	 * @return all TextFields of the ticket
	 */
	public List<Field<String>> getAllTextFields() {
		this.initializeFieldLists();
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldsIterator = this.getAllFields().iterator();
		while (fieldsIterator.hasNext()) {
			final Field<?> current = fieldsIterator.next();
			current.getType().accept(new FieldTypeStandardVisitor() {
				@SuppressWarnings("unchecked")
				@Override
				public void handleTextFieldType(final TextFieldType textFieldType) {
					Ticket.this.addToTextFieldList((Field<String>) current);
				}

				@Override
				public void standardHandling() {
					// nothing
				}
			});

		}
		return this.textFieldList;
	}

	/**
	 * Getter of the current state of the ticket.
	 * 
	 * @return the current state of the ticket
	 */
	public final StateType getCurrentState() {
		return this.currentState;
	}

	/**
	 * Getter of the description of the ticket.
	 * 
	 * @return the description of the ticket
	 */
	public String getDescription() {
		return this.getTicketType().getDescription(this);
	}

	/**
	 * Getter of the name of the ticket.
	 * 
	 * @return the name of the ticket
	 */
	public String getName() {
		return this.getTicketType().getName(this);
	}

	/**
	 * Returns the project that the ticket belongs to.
	 * 
	 * @return the related project
	 */
	public abstract Project getProject();

	/**
	 * Getter of the ticketType of the ticket.
	 * 
	 * @return the tickettype related to the ticket
	 */
	public TicketType getTicketType() {
		return this.ticketType;
	}

	/**
	 * Setter of the description of the ticket.
	 * 
	 * @param description
	 *            : new description of the ticket
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws NoValidValueException
	 *             if the value is not valid
	 * @throws ForbiddenStateException
	 *             if the ticket is in a state this method is forbidden
	 */
	public void setDescription(final String description) throws ConsistencyException,
			NoValidValueException, ForbiddenStateException {
		this.getTicketType().setTicketDescription(description, this);
	}

	/**
	 * Ticket type (the class) differentiation.
	 * 
	 * @param visitor
	 *            {@link TicketVisitor}.
	 */
	public abstract void accept(TicketVisitor visitor);

	/**
	 * validity check for ticket descriptions.
	 * 
	 * @param description
	 *            of the ticket
	 * @throws NoValidValueException
	 *             if the description is not valid
	 */
	protected abstract void checkDescriptionValidity(String description)
			throws NoValidValueException;

	/**
	 * validity check for ticket names.
	 * 
	 * @param name
	 *            of the ticket
	 * @throws NoValidValueException
	 *             if the name is not valid
	 * @throws DoubleDefinitionException
	 *             if a ticket with the name already exists
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	protected abstract void checkNameValidity(String name)
			throws NoValidValueException, DoubleDefinitionException,
			ConsistencyException;

	/**
	 * Setter of the name of the ticket.
	 * 
	 * @param name
	 *            : new name of the ticket
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the ticket is in a state this method is forbidden
	 * @throws DoubleDefinitionException
	 *             if a ticket with this name already exists
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */
	protected void setName(final String name) throws ConsistencyException,
			ForbiddenStateException, DoubleDefinitionException, NoValidValueException {
		this.getTicketType().setTicketName(name, this);
	}

	/**
	 * Setter of a state of the ticket.
	 * 
	 * @param newState
	 *            : new state of the ticket
	 */
	protected void setState(final StateType newState) {
		this.currentState = newState;
	}

	/**
	 * adds a field to the ticket.
	 * 
	 * @param field
	 *            to add
	 * @throws DoubleDefinitionException
	 *             if the field is already added
	 */
	private void addField(final Field<?> field) throws DoubleDefinitionException {
		boolean doubleDefined = false;
		@SuppressWarnings("rawtypes")
		final Iterator<Field> fieldIterator = this.getAllFields().iterator();
		while (fieldIterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			final Field current = fieldIterator.next();
			if (current.getType().equals(field.getType())) {
				doubleDefined = true;
				break;
			}
		}
		if (doubleDefined) {
			throw new DoubleDefinitionException(
					"Fehler: Es wurde versucht, dem Ticket ein "
							+ "zweites Feld eines gleichen Feldtypen hinzuzufügen! ");
		} else {
			this.allFields.add(field);
		}
	}

	/**
	 * Adds a field to the AccaptanceCriteriaFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void
			addToAcceptanceCriteriaFieldList(final Field<AcceptanceCriterion> field) {
		this.acceptanceCriteriaFieldList.add(field);
	}

	/**
	 * Adds a field to the DateFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToDateFieldList(final Field<Date> field) {
		this.dateFieldList.add(field);
	}

	/**
	 * Adds a field to the EffortFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToEffortFieldList(final Field<Effort> field) {
		this.effortFieldList.add(field);
	}

	/**
	 * Adds a field to the HintFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToHintFieldList(final Field<Hint> field) {
		this.hintFieldList.add(field);
	}

	/**
	 * Adds a field to the NumberFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToNumberFieldList(final Field<Long> field) {
		this.numberFieldList.add(field);
	}

	/**
	 * Adds a field to the PBIFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToPBIFieldList(final Field<ProductBacklogItem> field) {
		this.pbiFieldList.add(field);
	}

	/**
	 * Adds a field to the PersonFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToPersonFieldList(final Field<Person> field) {
		this.personFieldList.add(field);
	}

	/**
	 * Adds a field to the ReleaseFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToReleaseFieldList(final Field<Release> field) {
		this.releaseFieldList.add(field);
	}

	/**
	 * Adds a field to the SprintFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToSprintFieldList(final Field<Sprint> field) {
		this.sprintFieldList.add(field);
	}

	/**
	 * Adds a field to the SystemFieldList.
	 * 
	 * @param current
	 *            to add
	 */
	private void addToSystemFieldList(
			final Field<fhdw.ipscrum.shared.model.nonMeta.System> current) {
		this.systemFieldList.add(current);
	}

	/**
	 * Adds a field to the TextFieldList.
	 * 
	 * @param field
	 *            to add
	 */
	private void addToTextFieldList(final Field<String> field) {
		this.textFieldList.add(field);
	}

	/**
	 * Initializes all FieldLists which include all fields of the ticket.
	 */
	private void initializeFieldLists() {

		this.textFieldList = new ArrayList<Field<String>>();
		this.dateFieldList = new ArrayList<Field<Date>>();
		this.numberFieldList = new ArrayList<Field<Long>>();
		this.personFieldList = new ArrayList<Field<Person>>();
		this.effortFieldList = new ArrayList<Field<Effort>>();
		this.sprintFieldList = new ArrayList<Field<Sprint>>();
		this.releaseFieldList = new ArrayList<Field<Release>>();
		this.pbiFieldList = new ArrayList<Field<ProductBacklogItem>>();
		this.systemFieldList =
				new ArrayList<Field<fhdw.ipscrum.shared.model.nonMeta.System>>();
		this.acceptanceCriteriaFieldList = new ArrayList<Field<AcceptanceCriterion>>();
		this.hintFieldList = new ArrayList<Field<Hint>>();

	}

	/**
	 * Initializes the all fields of the ticketType.
	 * 
	 * @param initializingTicketType
	 *            attached
	 * @throws DoubleDefinitionException
	 * 
	 *             if a field is already initialized
	 */
	private void initializeFields(final TicketType initializingTicketType)
			throws DoubleDefinitionException {
		final Iterator<FieldType> fieldTypeIterator =
				initializingTicketType.getAllFieldTypes().iterator();
		while (fieldTypeIterator.hasNext()) {
			final FieldType current = fieldTypeIterator.next();
			final Field<?> newField = current.createField();
			this.addField(newField);
		}
	}

	/**
	 * Returns the field with the specific field type.
	 * 
	 * @param fieldType
	 *            the type of the field
	 * @param <T>
	 *            the type of the returned ticket
	 * @return the field with the specified field type
	 */
	@SuppressWarnings("unchecked")
	public <T extends Field<? extends Serializable>> T getField(
			final FieldType fieldType) {
		for (final Field<Serializable> field : this.getAllFields()) {
			if (field.getType().equals(fieldType)) {
				return (T) field;
			}
		}
		return null;
	}
}
