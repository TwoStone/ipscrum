package fhdw.ipscrum.shared.model.metamodel.fields;

/**
 * Represents the Visitor needed for handling standard fieldTypes.
 */
public abstract class FieldTypeStandardVisitor implements FieldTypeVisitor {

	/**
	 * Needed for the standard handling of the fieldTypes.
	 */
	public abstract void standardHandling();

	@Override
	public void handleTextFieldType(final TextFieldType textFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleEffortFieldType(final EffortFieldType effortFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleSystemFieldType(final SystemFieldType systemFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleSprintFieldType(final SprintFieldType sprintFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleDateFieldType(final DateFieldType dateFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleNumberFieldType(final NumberFieldType numberFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleReleaseFieldType(final ReleaseFieldType releaseFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleHintFieldType(final HintFieldType hintFieldType) {
		this.standardHandling();
	}

	@Override
	public void handlePersonFieldType(final PersonFieldType personFieldType) {
		this.standardHandling();
	}

	@Override
	public void handleAcceptanceCriterionFieldType(final AcceptanceCriteriaFieldType acceptanceCriteriaFieldType) {
		this.standardHandling();
	}

	@Override
	public void handlePBIFieldType(final PBIFieldType pbiFieldType) {
		this.standardHandling();
	}

}
