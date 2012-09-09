package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.userRights.FieldTypeAdminRight;
import fhdw.ipscrum.shared.model.userRights.PersonRoleAdminRight;
import fhdw.ipscrum.shared.model.userRights.TeamAdminRight;
import fhdw.ipscrum.shared.model.userRights.TicketTypeAdminRight;

/**
 * visitor for admin rights.
 */
public interface AdminRightVisitor {
	/**
	 * handles concrete admin right.
	 * 
	 * @param teamAdminRight
	 *            concrete admin right.
	 */
	void handleTeamAdminRight(TeamAdminRight teamAdminRight);

	/**
	 * handles concrete admin right.
	 * 
	 * @param personRoleAdminRight
	 *            concrete admin right.
	 */
	void handlePersonRoleAdminRight(PersonRoleAdminRight personRoleAdminRight);

	/**
	 * handles concrete admin right.
	 * 
	 * @param ticketTypeAdminRight
	 *            concrete admin right.
	 */
	void handleTicketTypeAdminRight(TicketTypeAdminRight ticketTypeAdminRight);

	/**
	 * handles concrete admin right.
	 * 
	 * @param fieldTypeAdminRight
	 *            concrete admin right.
	 */
	void handleFieldTypeAdminRight(FieldTypeAdminRight fieldTypeAdminRight);
}
