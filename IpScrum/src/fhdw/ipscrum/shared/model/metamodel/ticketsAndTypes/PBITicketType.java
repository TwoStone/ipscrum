package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.util.List;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.model.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.visitor.PBITicketTypeVisitor;

/**
 * this class represents the knowledge layer of product backlog items.
 */
public abstract class PBITicketType extends TicketType {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3041093711045601114L;

	/* standard field types, must be initialized externally */
	/**
	 * represents the last editor.
	 */
	private PersonFieldType lastEditorType;

	/**
	 * represents the mandaycosts of the pbi.
	 */
	private EffortFieldType manDayCostsType;

	/**
	 * represents the hints of the pbi.
	 */
	private TextFieldType hintsType;

	/**
	 * represents the acceptanceCritria.
	 */
	private TextFieldType acceptanceCriteriaType;

	/**
	 * represents the sprint related to the pbi.
	 */
	private SprintFieldType sprintType;

	/**
	 * constructor of the PBITicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the PBITicketType
	 * @param description
	 *            of the PBITicketType
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public PBITicketType(final Model model, final String name, final String description)
			throws IPScrumGeneralException {
		super(model, name, description);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected PBITicketType() {
		super();
	}

	/**
	 * constructor of the PBITicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the PBITicketTYpe
	 * @param description
	 *            of the PBITicketType
	 * @param typeManager
	 *            : it is inserted into the TypeManager
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected PBITicketType(final Model model, final String name,
			final String description, final TypeManager typeManager)
			throws IPScrumGeneralException {
		super(model, name, description, typeManager);
	}

	/**
	 * Needed for using a Visitor.
	 * 
	 * @param visitor
	 *            used is the PBITicektTypeVisitor
	 */
	public abstract void accept(PBITicketTypeVisitor visitor);

	/**
	 * Adds a AccaptanceCriterion to the pbi.
	 * 
	 * @param acceptanceCriterion
	 *            to add
	 * @param pbi
	 *            attached
	 * @throws DoubleDefinitionException
	 *             if the criterion is already added
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void addAcceptanceCriterion(final String acceptanceCriterion,
			final ProductBacklogItem pbi) throws DoubleDefinitionException,
			ForbiddenStateException, ConsistencyException {
		@SuppressWarnings("unchecked")
		final ListField<String> target =
				(ListField<String>) this
						.getField(this.getAcceptanceCriteriaType(), pbi);
		target.addValue(acceptanceCriterion, pbi);
	}

	/**
	 * Adds a hint to the pbi.
	 * 
	 * @param hint
	 *            to add
	 * @param pbi
	 *            attached
	 * @throws DoubleDefinitionException
	 *             if the hint is already added
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state this method is forbidden
	 */
	public void addHint(final String hint, final ProductBacklogItem pbi)
			throws DoubleDefinitionException, ConsistencyException,
			ForbiddenStateException {
		@SuppressWarnings("unchecked")
		final ListField<String> field =
				(ListField<String>) this.getField(this.hintsType, pbi);
		field.addValue(hint, pbi);
	}

	/**
	 * Getter of the acceptanceCriteria.
	 * 
	 * @param pbi
	 *            attached
	 * @return all acceptanceCriteria
	 */
	public List<String> getAcceptanceCriteria(final ProductBacklogItem pbi) {
		@SuppressWarnings("unchecked")
		final ListField<String> field =
				(ListField<String>) this.getField(this.acceptanceCriteriaType, pbi);
		return field.getValues();
	}

	/**
	 * Getter of the AcceptanceCriteriType.
	 * 
	 * @return the fieldType
	 */
	public TextFieldType getAcceptanceCriteriaType() {
		return this.acceptanceCriteriaType;
	}

	/**
	 * Getter of the hints.
	 * 
	 * @param pbi
	 *            attached
	 * @return all hints related to the pbi
	 */
	public List<String> getHints(final ProductBacklogItem pbi) {
		@SuppressWarnings("unchecked")
		final ListField<String> field =
				(ListField<String>) this.getField(this.hintsType, pbi);
		return field.getValues();
	}

	/**
	 * Getter of the HintType.
	 * 
	 * @return the fieldType
	 */
	public TextFieldType getHintsType() {
		return this.hintsType;
	}

	/**
	 * Getter of the last Editor.
	 * 
	 * @param pbi
	 *            attached
	 * @return the last editor
	 */
	public Person getLastEditor(final ProductBacklogItem pbi) {
		@SuppressWarnings("unchecked")
		final SingleField<Person> field =
				(SingleField<Person>) this.getField(this.lastEditorType, pbi);
		return field.getValue();
	}

	/**
	 * getter of the field for the last editor.
	 * 
	 * @return the last editor field
	 */
	public PersonFieldType getLastEditorType() {
		return this.lastEditorType;
	}

	/**
	 * getter of the man day costs.
	 * 
	 * @param pbi
	 *            attached
	 * @return the effort of the pbi
	 */
	public Effort getManDayCosts(final ProductBacklogItem pbi) {
		@SuppressWarnings("unchecked")
		final SingleField<Effort> field =
				(SingleField<Effort>) this.getField(this.manDayCostsType, pbi);
		return field.getValue();
	}

	/**
	 * getter of the field of the man day costs.
	 * 
	 * @return the man day costs field
	 */
	public EffortFieldType getManDayCostsType() {
		return this.manDayCostsType;
	}

	/**
	 * gets the sprint related to the pbi.
	 * 
	 * @param pbi
	 *            attached
	 * @return the sprint
	 */
	public Sprint getSprint(final ProductBacklogItem pbi) {
		@SuppressWarnings("unchecked")
		final SingleField<Sprint> field =
				(SingleField<Sprint>) this.getField(this.sprintType, pbi);
		return field.getValue();
	}

	/**
	 * getter of the field of the sprint.
	 * 
	 * @return the sprint field
	 */
	public SprintFieldType getSprintType() {
		return this.sprintType;
	}

	/**
	 * removes an acceptance criterion.
	 * 
	 * @param acceptanceCriterion
	 *            to remove
	 * @param pbi
	 *            attached
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state in which the use of this method is forbidden
	 */
	public void removeAcceptanceCriterion(final String acceptanceCriterion,
			final ProductBacklogItem pbi) throws ConsistencyException,
			ForbiddenStateException {
		@SuppressWarnings("unchecked")
		final ListField<String> target =
				(ListField<String>) this
						.getField(this.getAcceptanceCriteriaType(), pbi);
		target.removeValue(acceptanceCriterion, pbi);
	}

	/**
	 * removes a hint.
	 * 
	 * @param hint
	 *            to remove
	 * @param pbi
	 *            attached
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 */
	public void removeHint(final String hint, final ProductBacklogItem pbi)
			throws ConsistencyException, ForbiddenStateException {

		@SuppressWarnings("unchecked")
		final ListField<String> target =
				(ListField<String>) this.getField(this.getHintsType(), pbi);
		target.removeValue(hint, pbi);
	}

	/**
	 * sets the field for the acceptance criterion.
	 * 
	 * @param acceptanceCriteriaType
	 *            : new field
	 */
	public void setAcceptanceCriteriaType(final TextFieldType acceptanceCriteriaType) {
		if (!(this.acceptanceCriteriaType == null)) {
			return;
		}
		this.acceptanceCriteriaType = acceptanceCriteriaType;
		this.doAddFieldType(acceptanceCriteriaType);
	}

	/**
	 * sets the description of the pbi.
	 * 
	 * @param description
	 *            to set
	 * @param pbi
	 *            attached
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 */
	@SuppressWarnings("unchecked")
	public void setDescription(final String description, final ProductBacklogItem pbi)
			throws ConsistencyException, ForbiddenStateException {
		((SingleField<String>) this.getField(this.getDescriptionType(), pbi)).setValue(
				description, pbi);
	}

	/**
	 * sets the field for the hint.
	 * 
	 * @param hintsType
	 *            : new hint field
	 */
	public void setHintsType(final TextFieldType hintsType) {
		if (!(this.hintsType == null)) {
			return;
		}
		this.hintsType = hintsType;
		this.doAddFieldType(hintsType);
	}

	/**
	 * sets the last editor.
	 * 
	 * @param lastEditor
	 *            : new person as last editor
	 * @param pbi
	 *            attached
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	@SuppressWarnings("unchecked")
	public void setLastEditor(final Person lastEditor, final ProductBacklogItem pbi)
			throws ForbiddenStateException, ConsistencyException {
		((SingleField<Person>) this.getField(this.getLastEditorType(), pbi)).setValue(
				lastEditor, pbi);
	}

	/**
	 * sets the field for the last editor.
	 * 
	 * @param lastEditorType
	 *            : new field
	 */
	public void setLastEditorType(final PersonFieldType lastEditorType) {
		if (!(this.lastEditorType == null)) {
			return;
		}
		this.lastEditorType = lastEditorType;
		this.doAddFieldType(lastEditorType);
	}

	/**
	 * sets the man day costs.
	 * 
	 * @param manDayCosts
	 *            : new effort
	 * @param pbi
	 *            attached
	 * @throws NoValidValueException
	 *             if the value is not valid
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of this method is forbidden
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	@SuppressWarnings("unchecked")
	public void setManDayCosts(final Effort manDayCosts, final ProductBacklogItem pbi)
			throws NoValidValueException, ForbiddenStateException, ConsistencyException {
		((SingleField<Effort>) this.getField(this.manDayCostsType, pbi)).setValue(
				manDayCosts, pbi);
	}

	/**
	 * sets the field for the man day costs.
	 * 
	 * @param manDayCostsType
	 *            : new field
	 */
	public void setManDayCostsType(final EffortFieldType manDayCostsType) {
		if (!(this.manDayCostsType == null)) {
			return;
		}
		this.manDayCostsType = manDayCostsType;
		this.doAddFieldType(manDayCostsType);
	}

	/**
	 * sets the name of the pbi.
	 * 
	 * @param name
	 *            : new name of the pbi
	 * @param pbi
	 *            attached
	 * @throws NoValidValueException
	 *             if the value is not valid
	 * @throws DoubleDefinitionException
	 *             if a pbi with the same name already exists
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the pbi is in a state the use of the method is forbidden
	 */
	@SuppressWarnings("unchecked")
	public void setName(final String name, final ProductBacklogItem pbi)
			throws NoValidValueException, DoubleDefinitionException,
			ConsistencyException, ForbiddenStateException {
		((SingleField<String>) this.getField(this.getDescriptionType(), pbi)).setValue(
				name, pbi);
	}

	/**
	 * sets the sprint.
	 * 
	 * @param sprint
	 *            : new sprint of the PBITicketType
	 * @param pbi
	 *            attached
	 * @throws NoSprintDefinedException
	 *             if the sprint doesn't exists
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             if the wrong state to use this method
	 */
	@SuppressWarnings("unchecked")
	public void setSprint(final Sprint sprint, final ProductBacklogItem pbi)
			throws NoSprintDefinedException, ConsistencyException,
			ForbiddenStateException {
		((SingleField<Sprint>) this.getField(this.sprintType, pbi)).setValue(sprint,
				pbi);
	}

	/**
	 * sets the field for the sprint.
	 * 
	 * @param sprintType
	 *            : current sprint field
	 */
	public void setSprintType(final SprintFieldType sprintType) {
		if (!(this.sprintType == null)) {
			return;
		}
		this.sprintType = sprintType;
		this.doAddFieldType(sprintType);
	}

	@Override
	protected void doInitializeStandard(final TypeManager typeManager)
			throws IPScrumGeneralException {
		this.setDescriptionType(typeManager.getDescriptionType());
		this.setNameType(typeManager.getNameType());
		this.setAcceptanceCriteriaType(typeManager.getAcceptanceCriteriaType());
		this.setHintsType(typeManager.getHintsType());
		this.setLastEditorType(typeManager.getLastEditorType());
		this.setManDayCostsType(typeManager.getManDayCostsType());
		this.setSprintType(typeManager.getSprintType());
		this.setDescriptionType(typeManager.getDescriptionType());
		this.setNameType(typeManager.getNameType());
		// Determine active fields!
		this.doSetActive(typeManager.getOpen(), this.getAcceptanceCriteriaType());
		this.doSetActive(typeManager.getOpen(), this.getDescriptionType());
		this.doSetActive(typeManager.getOpen(), this.getHintsType());
		this.doSetActive(typeManager.getOpen(), this.getLastEditorType());
		this.doSetActive(typeManager.getOpen(), this.getManDayCostsType());
		this.doSetActive(typeManager.getOpen(), this.getSprintType());
		this.doSetActive(typeManager.getOpen(), this.getNameType());
	}

	@Override
	protected void doInitializeStateProfile(final TypeManager typeManager)
			throws IPScrumGeneralException {
		this.doAddPossibleState(typeManager.getOpen());
		this.doAddPossibleState(typeManager.getClosed());
		this.doSetStartState(typeManager.getOpen());
		this.doAddEndState(typeManager.getClosed());
		this.doAddTransitionRule(new TransitionRule(this.getModel(), typeManager
				.getOpen(), typeManager.getClosed()));

	}
}
