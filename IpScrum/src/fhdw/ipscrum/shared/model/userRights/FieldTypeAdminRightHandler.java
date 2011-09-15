/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

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
import fhdw.ipscrum.shared.model.Model;

/**
 * handler for field type administration right.
 */
class FieldTypeAdminRightHandler extends RightHandler {

	/**
	 * creates a new field type admin right handler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	FieldTypeAdminRightHandler(final FieldTypeAdminRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleAcceptanceCriteriaFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes
	 * .AcceptanceCriteriaFieldTypeCreateCommand)
	 */
	@Override
	public
			void
			handleAcceptanceCriteriaFieldTypeCreateCommand(
					final AcceptanceCriteriaFieldTypeCreateCommand acceptanceCriteriaFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleDateFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand)
	 */
	@Override
	public void handleDateFieldTypeCreateCommand(
			final DateFieldTypeCreateCommand dateFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleEffortFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand)
	 */
	@Override
	public void handleEffortFieldTypeCreateCommand(
			final EffortFieldTypeCreateCommand effortFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleHintFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand)
	 */
	@Override
	public void handleHintFieldTypeCreateCommand(
			final HintFieldTypeCreateCommand hintFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleNumberFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand)
	 */
	@Override
	public void handleNumberFieldTypeCreateCommand(
			final NumberFieldTypeCreateCommand numberFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePBIFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand)
	 */
	@Override
	public void handlePBIFieldTypeCreateCommand(
			final PBIFieldTypeCreateCommand pBIFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handlePersonFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand)
	 */
	@Override
	public void handlePersonFieldTypeCreateCommand(
			final PersonFieldTypeCreateCommand personFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleReleaseFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand)
	 */
	@Override
	public void handleReleaseFieldTypeCreateCommand(
			final ReleaseFieldTypeCreateCommand releaseFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleSprintFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand)
	 */
	@Override
	public void handleSprintFieldTypeCreateCommand(
			final SprintFieldTypeCreateCommand sprintFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleSystemFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand)
	 */
	@Override
	public void handleSystemFieldTypeCreateCommand(
			final SystemFieldTypeCreateCommand systemFieldTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#
	 * handleTextFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand)
	 */
	@Override
	public void handleTextFieldTypeCreateCommand(
			final TextFieldTypeCreateCommand textFieldTypeCreateCommand) {
		this.allowed();
	}

}
