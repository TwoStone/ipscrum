package fhdw.ipscrum.shared.model.userRights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * The right manager allows access to all right-objects.
 */
public class RightManager implements IsSerializable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8167020216188268631L;
	/**
	 * represents the right for editing the product backlog.
	 */
	private ProductBacklogRight pblRight;
	/**
	 * represents the right for editing the sprint backlog.
	 */
	private TaskboardRight taskboardRight;
	/**
	 * represents the right for creating and managing projects.
	 */
	private ProjectRight projectRight;
	/**
	 * represents the right for creating incidents.
	 */
	private ProjectHistoryRight projectHistoryRight;
	/**
	 * represents the right for managing persons, roles and rights.
	 */
	private PersonRoleAdminRight personRoleAdminRight;
	/**
	 * represents the right for managing teams.
	 */
	private TeamAdminRight teamAdminRight;
	/**
	 * represents the right for creating and managing ticket types.
	 */
	private TicketTypeAdminRight ticketTypeAdminRight;
	/**
	 * represents the right for creating field types.
	 */
	private FieldTypeAdminRight fieldTypeAdminRight;

	/**
	 * master role contains all rights.
	 */
	private Role masterRole;

	/**
	 * Creates a new Right Manager.
	 * 
	 */
	public RightManager() {
		super();
	}

	/**
	 * Returns all rights.
	 * 
	 * @return all instances of {@link Right} that exist in the model.
	 */
	public List<Right> getAllRights() {
		final List<Right> result = new ArrayList<Right>();
		result.add(this.getFieldTypeAdminRight());
		result.add(this.getTicketTypeAdminRight());
		result.add(this.getTeamAdminRight());
		result.add(this.getPersonRoleAdminRight());
		result.add(this.getPblRight());
		result.add(this.getProjectRight());
		result.add(this.getProjectHistoryRight());
		result.add(this.getTaskboardRight());
		return result;
	}

	/**
	 * @return the fieldTypeAdminRight
	 */
	public FieldTypeAdminRight getFieldTypeAdminRight() {
		return this.fieldTypeAdminRight;
	}

	/**
	 * @return the pblRight
	 */
	public ProductBacklogRight getPblRight() {
		return this.pblRight;
	}

	/**
	 * @return the personRoleAdminRight
	 */
	public PersonRoleAdminRight getPersonRoleAdminRight() {
		return this.personRoleAdminRight;
	}

	/**
	 * @return the projectHistoryRight
	 */
	public ProjectHistoryRight getProjectHistoryRight() {
		return this.projectHistoryRight;
	}

	/**
	 * @return the projectRight
	 */
	public ProjectRight getProjectRight() {
		return this.projectRight;
	}

	/**
	 * @return the taskboardRight
	 */
	public TaskboardRight getTaskboardRight() {
		return this.taskboardRight;
	}

	/**
	 * @return the teamAdminRight
	 */
	public TeamAdminRight getTeamAdminRight() {
		return this.teamAdminRight;
	}

	/**
	 * @return the ticketTypeAdminRight
	 */
	public TicketTypeAdminRight getTicketTypeAdminRight() {
		return this.ticketTypeAdminRight;
	}

	/**
	 * @param fieldTypeAdminRight
	 *            the fieldTypeAdminRight to set
	 */
	public void setFieldTypeAdminRight(final FieldTypeAdminRight fieldTypeAdminRight) {
		if (this.fieldTypeAdminRight == null) {
			this.fieldTypeAdminRight = fieldTypeAdminRight;
		}
	}

	/**
	 * @param pblRight
	 *            the pblRight to set
	 */
	public void setPblRight(final ProductBacklogRight pblRight) {
		if (this.pblRight == null) {
			this.pblRight = pblRight;
		}
	}

	/**
	 * @param personRoleAdminRight
	 *            the personRoleAdminRight to set
	 */
	public void
			setPersonRoleAdminRight(final PersonRoleAdminRight personRoleAdminRight) {
		if (this.personRoleAdminRight == null) {
			this.personRoleAdminRight = personRoleAdminRight;
		}
	}

	/**
	 * @param projectHistoryRight
	 *            the projectHistoryRight to set
	 */
	public void setProjectHistoryRight(final ProjectHistoryRight projectHistoryRight) {
		if (this.projectHistoryRight == null) {
			this.projectHistoryRight = projectHistoryRight;
		}
	}

	/**
	 * @param projectRight
	 *            the projectRight to set
	 */
	public void setProjectRight(final ProjectRight projectRight) {
		if (this.projectRight == null) {
			this.projectRight = projectRight;
		}
	}

	/**
	 * @param taskboardRight
	 *            the taskboardRight to set
	 */
	public void setTaskboardRight(final TaskboardRight taskboardRight) {
		if (this.taskboardRight == null) {
			this.taskboardRight = taskboardRight;
		}
	}

	/**
	 * @param teamAdminRight
	 *            the teamAdminRight to set
	 */
	public void setTeamAdminRight(final TeamAdminRight teamAdminRight) {
		if (this.teamAdminRight == null) {
			this.teamAdminRight = teamAdminRight;
		}
	}

	/**
	 * @param ticketTypeAdminRight
	 *            the ticketTypeAdminRight to set
	 */
	public void
			setTicketTypeAdminRight(final TicketTypeAdminRight ticketTypeAdminRight) {
		if (this.ticketTypeAdminRight == null) {
			this.ticketTypeAdminRight = ticketTypeAdminRight;
		}
	}

	/**
	 * @return the masterRole
	 */
	public Role getMasterRole() {
		return this.masterRole;
	}

	/**
	 * @param masterRole
	 *            the masterRole to set
	 */
	public void setMasterRole(final Role masterRole) {
		if (this.masterRole == null) {
			this.masterRole = masterRole;
		}
	}

}
