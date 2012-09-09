package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand;

/**
 * visitor for field type commands.
 */
public interface FieldTypesCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param acceptanceCriteriaFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleAcceptanceCriteriaFieldTypeCreateCommand(
			AcceptanceCriteriaFieldTypeCreateCommand acceptanceCriteriaFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param dateFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleDateFieldTypeCreateCommand(DateFieldTypeCreateCommand dateFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param effortFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleEffortFieldTypeCreateCommand(EffortFieldTypeCreateCommand effortFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param hintFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleHintFieldTypeCreateCommand(HintFieldTypeCreateCommand hintFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param numberFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleNumberFieldTypeCreateCommand(NumberFieldTypeCreateCommand numberFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param pBIFieldTypeCreateCommand
	 *            specific command.
	 */
	void handlePBIFieldTypeCreateCommand(PBIFieldTypeCreateCommand pBIFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param personFieldTypeCreateCommand
	 *            specific command.
	 */
	void handlePersonFieldTypeCreateCommand(PersonFieldTypeCreateCommand personFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommand releaseFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param sprintFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleSprintFieldTypeCreateCommand(SprintFieldTypeCreateCommand sprintFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param systemFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleSystemFieldTypeCreateCommand(SystemFieldTypeCreateCommand systemFieldTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param textFieldTypeCreateCommand
	 *            specific command.
	 */
	void handleTextFieldTypeCreateCommand(TextFieldTypeCreateCommand textFieldTypeCreateCommand);
}
