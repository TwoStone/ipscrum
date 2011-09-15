package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;

/**
 * visitor for team commands.
 */
public interface TeamCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param teamAddMemberCommand
	 *            specific command.
	 */
	void handleTeamAddMemberCommand(TeamAddMemberCommand teamAddMemberCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param teamCreateCommand
	 *            specific command.
	 */
	void handleTeamCreateCommand(TeamCreateCommand teamCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param teamRemoveMemberCommand
	 *            specific command.
	 */
	void handleTeamRemoveMemberCommand(TeamRemoveMemberCommand teamRemoveMemberCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param teamSetDescriptionCommand
	 *            specific command.
	 */
	void handleTeamSetDescriptionCommand(
			TeamSetDescriptionCommand teamSetDescriptionCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param teamAddProjectCommand
	 *            specific command.
	 */
	void handleTeamAddProjectCommand(TeamAddProjectCommand teamAddProjectCommand);

}
