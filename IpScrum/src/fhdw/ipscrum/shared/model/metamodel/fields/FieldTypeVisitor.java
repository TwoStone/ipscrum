package fhdw.ipscrum.shared.model.metamodel.fields;

/**
 * Represents the Visitor needed for handling all FieldTypes.
 */
public interface FieldTypeVisitor {

	/**
	 * Needed for handling TextFieldTypes.
	 * 
	 * @param textFieldType
	 *            : concrete type that need to be handled
	 */
	void handleTextFieldType(TextFieldType textFieldType);

	/**
	 * Needed for handling EffordFieldTypes.
	 * 
	 * @param effortFieldType
	 *            : concrete type that need to be handled
	 */
	void handleEffortFieldType(EffortFieldType effortFieldType);

	/**
	 * Needed for handling SystemFieldTypes.
	 * 
	 * @param systemFieldType
	 *            : concrete type that need to be handled
	 */
	void handleSystemFieldType(SystemFieldType systemFieldType);

	/**
	 * Needed for handling SprintFieldTypes.
	 * 
	 * @param sprintFieldType
	 *            : concrete type that need to be handled
	 */
	void handleSprintFieldType(SprintFieldType sprintFieldType);

	/**
	 * Needed for handling DateFieldTypes.
	 * 
	 * @param dateFieldType
	 *            : concrete type that need to be handled
	 */
	void handleDateFieldType(DateFieldType dateFieldType);

	/**
	 * Needed for handling NumberFieldTypes.
	 * 
	 * @param numberFieldType
	 *            : concrete type that need to be handled
	 */
	void handleNumberFieldType(NumberFieldType numberFieldType);

	/**
	 * Needed for handling ReleaseFieldTypes.
	 * 
	 * @param releaseFieldType
	 *            : concrete type that need to be handled
	 */
	void handleReleaseFieldType(ReleaseFieldType releaseFieldType);

	/**
	 * Needed for handling HintFieldTypes.
	 * 
	 * @param hintFieldType
	 *            : concrete type that need to be handled
	 */
	void handleHintFieldType(HintFieldType hintFieldType);

	/**
	 * Needed for handling PersonFieldTypes.
	 * 
	 * @param personFieldType
	 *            : concrete type that need to be handled
	 */
	void handlePersonFieldType(PersonFieldType personFieldType);

	/**
	 * Needed for handling AcceptanceCriterionFieldTypes.
	 * 
	 * @param acceptanceCriteriaFieldType
	 *            : concrete type that need to be handled
	 */
	void handleAcceptanceCriterionFieldType(
			AcceptanceCriteriaFieldType acceptanceCriteriaFieldType);

	/**
	 * Needed for handling PBIFieldTypes.
	 * 
	 * @param pbiFieldType
	 *            : concrete type that need to be handled
	 */
	void handlePBIFieldType(PBIFieldType pbiFieldType);

}
