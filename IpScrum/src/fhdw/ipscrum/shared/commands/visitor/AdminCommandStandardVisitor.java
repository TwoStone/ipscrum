package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.SystemCreateCommand;
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
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;

/**
 * implementing Admin command standard visitor.
 */
public abstract class AdminCommandStandardVisitor
		extends TicketTypesCommandStandardVisitor
		implements AdminCommandStandardVisitorInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleAcceptanceCriteriaFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes
	 * .AcceptanceCriteriaFieldTypeCreateCommand)
	 */
	@Override
	public
			void
			handleAcceptanceCriteriaFieldTypeCreateCommand(
					final AcceptanceCriteriaFieldTypeCreateCommand acceptanceCriteriaFieldTypeCreateCommand) {
		this.standardHandling(acceptanceCriteriaFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleDateFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand)
	 */
	@Override
	public void handleDateFieldTypeCreateCommand(
			final DateFieldTypeCreateCommand dateFieldTypeCreateCommand) {
		this.standardHandling(dateFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.PersonRoleCommandVisitor#handleRoleAddRightCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand)
	 */
	@Override
	public void
			handleRoleAddRightCommand(final RoleAddRightCommand roleAddRightCommand) {
		this.standardHandling(roleAddRightCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.PersonRoleCommandVisitor#
	 * handleRoleRemoveRightCommand
	 * (fhdw.ipscrum.shared.commands.admin.personRoleAdministration
	 * .RoleRemoveRightCommand)
	 */
	@Override
	public void handleRoleRemoveRightCommand(
			final RoleRemoveRightCommand roleRemoveRightCommand) {
		this.standardHandling(roleRemoveRightCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleEffortFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand)
	 */
	@Override
	public void handleEffortFieldTypeCreateCommand(
			final EffortFieldTypeCreateCommand effortFieldTypeCreateCommand) {
		this.standardHandling(effortFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleHintFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand)
	 */
	@Override
	public void handleHintFieldTypeCreateCommand(
			final HintFieldTypeCreateCommand hintFieldTypeCreateCommand) {
		this.standardHandling(hintFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleNumberFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand)
	 */
	@Override
	public void handleNumberFieldTypeCreateCommand(
			final NumberFieldTypeCreateCommand numberFieldTypeCreateCommand) {
		this.standardHandling(numberFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handlePBIFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand)
	 */
	@Override
	public void handlePBIFieldTypeCreateCommand(
			final PBIFieldTypeCreateCommand pBIFieldTypeCreateCommand) {
		this.standardHandling(pBIFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handlePersonFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand)
	 */
	@Override
	public void handlePersonFieldTypeCreateCommand(
			final PersonFieldTypeCreateCommand personFieldTypeCreateCommand) {
		this.standardHandling(personFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleReleaseFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand)
	 */
	@Override
	public void handleReleaseFieldTypeCreateCommand(
			final ReleaseFieldTypeCreateCommand releaseFieldTypeCreateCommand) {
		this.standardHandling(releaseFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleSprintFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand)
	 */
	@Override
	public void handleSprintFieldTypeCreateCommand(
			final SprintFieldTypeCreateCommand sprintFieldTypeCreateCommand) {
		this.standardHandling(sprintFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.AdminCommandVisitor#handleSystemCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.SystemCreateCommand)
	 */
	@Override
	public void
			handleSystemCreateCommand(final SystemCreateCommand systemCreateCommand) {
		this.standardHandling(systemCreateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleSystemFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand)
	 */
	@Override
	public void handleSystemFieldTypeCreateCommand(
			final SystemFieldTypeCreateCommand systemFieldTypeCreateCommand) {
		this.standardHandling(systemFieldTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.TeamCommandVisitor#handleTeamAddMemberCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand)
	 */
	@Override
	public void handleTeamAddMemberCommand(
			final TeamAddMemberCommand teamAddMemberCommand) {
		this.standardHandling(teamAddMemberCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.TeamCommandVisitor#handleTeamCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand)
	 */
	@Override
	public void handleTeamCreateCommand(final TeamCreateCommand teamCreateCommand) {
		this.standardHandling(teamCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.TeamCommandVisitor#handleTeamRemoveMemberCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand)
	 */
	@Override
	public void handleTeamRemoveMemberCommand(
			final TeamRemoveMemberCommand teamRemoveMemberCommand) {
		this.standardHandling(teamRemoveMemberCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.TeamCommandVisitor#handleTeamSetDescriptionCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand)
	 */
	@Override
	public void handleTeamSetDescriptionCommand(
			final TeamSetDescriptionCommand teamSetDescriptionCommand) {
		this.standardHandling(teamSetDescriptionCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.FieldTypesCommandVisitor#
	 * handleTextFieldTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand)
	 */
	@Override
	public void handleTextFieldTypeCreateCommand(
			final TextFieldTypeCreateCommand textFieldTypeCreateCommand) {
		this.standardHandling(textFieldTypeCreateCommand);
	}

	@Override
	public void handlePersonAddRoleCommand(
			final PersonAddRoleCommand personAddRoleCommand) {
		this.standardHandling(personAddRoleCommand);

	}

	@Override
	public void handlePersonChangeNameCommand(
			final PersonChangeNameCommand personChangeNameCommand) {
		this.standardHandling(personChangeNameCommand);

	}

	@Override
	public void
			handlePersonCreateCommand(final PersonCreateCommand personCreateCommand) {
		this.standardHandling(personCreateCommand);

	}

	@Override
	public void handlePersonRemoveRoleCommand(
			final PersonRemoveRoleCommand personRemoveRoleCommand) {
		this.standardHandling(personRemoveRoleCommand);

	}

	@Override
	public void handleRoleCreateCommand(final RoleCreateCommand roleCreateCommand) {
		this.standardHandling(roleCreateCommand);

	}

	@Override
	public void handleRoleDeleteCommand(final RoleDeleteCommand roleDeleteCommand) {
		this.standardHandling(roleDeleteCommand);

	}

	@Override
	public void handleRoleSetDescriptionCommand(
			final RoleSetDescriptionCommand roleSetDescriptionCommand) {
		this.standardHandling(roleSetDescriptionCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.commands.visitor.TeamCommandVisitor#handleTeamAddProjectCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand)
	 */
	@Override
	public void handleTeamAddProjectCommand(
			final TeamAddProjectCommand teamAddProjectCommand) {
		this.standardHandling(teamAddProjectCommand);
	}

}
