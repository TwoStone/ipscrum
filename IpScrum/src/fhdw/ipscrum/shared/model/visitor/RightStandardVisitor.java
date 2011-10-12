/**
 * 
 */
package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.userRights.FieldTypeAdminRight;
import fhdw.ipscrum.shared.model.userRights.PersonRoleAdminRight;
import fhdw.ipscrum.shared.model.userRights.ProductBacklogRight;
import fhdw.ipscrum.shared.model.userRights.ProjectHistoryRight;
import fhdw.ipscrum.shared.model.userRights.ProjectRight;
import fhdw.ipscrum.shared.model.userRights.Right;
import fhdw.ipscrum.shared.model.userRights.TaskboardRight;
import fhdw.ipscrum.shared.model.userRights.TeamAdminRight;
import fhdw.ipscrum.shared.model.userRights.TicketTypeAdminRight;

/**
 * standard visitor for rights.
 */
public abstract class RightStandardVisitor implements RightVisitor {

	/**
	 * standard handling for rights.
	 * 
	 * @param right
	 *            right.
	 */
	public abstract void standardHandling(Right right);

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.RightVisitor#handleProductBacklogRight(fhdw.ipscrum
	 * .shared.model.userRights.ProductBacklogRight)
	 */
	@Override
	public void handleProductBacklogRight(final ProductBacklogRight productBacklogRight) {
		this.standardHandling(productBacklogRight);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.RightVisitor#handleProjectRight(fhdw.ipscrum.
	 * shared.model.userRights.ProjectRight)
	 */
	@Override
	public void handleProjectRight(final ProjectRight projectRight) {
		this.standardHandling(projectRight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.RightVisitor#handleProjectHistoryRight(fhdw.ipscrum
	 * .shared.model.userRights.ProjectHistoryRight)
	 */
	@Override
	public void handleProjectHistoryRight(final ProjectHistoryRight projectHistoryRight) {
		this.standardHandling(projectHistoryRight);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.RightVisitor#handleTaskboardRight(fhdw.ipscrum
	 * .shared.model.userRights.TaskboardRight)
	 */
	@Override
	public void handleTaskboardRight(final TaskboardRight taskboardRight) {
		this.standardHandling(taskboardRight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.AdminRightVisitor#handleTeamAdminRight(fhdw.ipscrum
	 * .shared.model.userRights.TeamAdminRight)
	 */
	@Override
	public void handleTeamAdminRight(final TeamAdminRight teamAdminRight) {
		this.standardHandling(teamAdminRight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.AdminRightVisitor#handlePersonRoleAdminRight(
	 * fhdw.ipscrum.shared.model.userRights.PersonRoleAdminRight)
	 */
	@Override
	public void handlePersonRoleAdminRight(final PersonRoleAdminRight personRoleAdminRight) {
		this.standardHandling(personRoleAdminRight);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.AdminRightVisitor#handleTicketTypeAdminRight(
	 * fhdw.ipscrum.shared.model.userRights.TicketTypeAdminRight)
	 */
	@Override
	public void handleTicketTypeAdminRight(final TicketTypeAdminRight ticketTypeAdminRight) {
		this.standardHandling(ticketTypeAdminRight);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.visitor.AdminRightVisitor#handleFieldTypeAdminRight(fhdw
	 * .ipscrum.shared.model.userRights.FieldTypeAdminRight)
	 */
	@Override
	public void handleFieldTypeAdminRight(final FieldTypeAdminRight fieldTypeAdminRight) {
		this.standardHandling(fieldTypeAdminRight);

	}

}
