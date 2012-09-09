/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;
import fhdw.ipscrum.shared.model.Model;

/**
 * Handler for team admin right.
 */
class TeamAdminRightHandler extends RightHandler {

	/**
	 * creates a new team admin right handler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	TeamAdminRightHandler(final TeamAdminRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor# handleTeamAddMemberCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand)
	 */
	@Override
	public void handleTeamAddMemberCommand(final TeamAddMemberCommand teamAddMemberCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor# handleTeamCreateCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand)
	 */
	@Override
	public void handleTeamCreateCommand(final TeamCreateCommand teamCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor# handleTeamRemoveMemberCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand)
	 */
	@Override
	public void handleTeamRemoveMemberCommand(final TeamRemoveMemberCommand teamRemoveMemberCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor# handleTeamSetDescriptionCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand)
	 */
	@Override
	public void handleTeamSetDescriptionCommand(final TeamSetDescriptionCommand teamSetDescriptionCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor# handleTeamAddProjectCommand
	 * (fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand)
	 */
	@Override
	public void handleTeamAddProjectCommand(final TeamAddProjectCommand teamAddProjectCommand) {
		this.allowed();
	}

}
