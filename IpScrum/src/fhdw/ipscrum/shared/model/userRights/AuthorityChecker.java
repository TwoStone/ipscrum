package fhdw.ipscrum.shared.model.userRights;

import java.io.Serializable;
import java.util.Iterator;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * An authority checker is needed for authorizing commands for users.
 */
public class AuthorityChecker implements IsSerializable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2411872862074117275L;
	/**
	 * represents the model.
	 */
	private Model model;

	/**
	 * result of authority check.
	 */
	private boolean allowed;

	/**
	 * creates a new instance of {@link AuthorityChecker}.
	 * 
	 * @param model
	 *            the model
	 */
	public AuthorityChecker(final Model model) {
		this.model = model;
	}

	/**
	 * default constructor for serialization.
	 */
	@SuppressWarnings("unused")
	private AuthorityChecker() {
	}

	/**
	 * Performs an authority check for 1 command.
	 * 
	 * @param command
	 *            Command that shall be executed.
	 * @param activeRole
	 *            role of the person that executes the command.
	 * @throws NotAuthorizedException
	 *             Will be thrown when the user isn't authorized.
	 * @throws ConsistencyException
	 *             if a command depends on a project, but the depending project is null.
	 * @throws NoObjectFindException
	 *             if something went wrong in the persistence layer.
	 */
	public void canBeExecuted(final ICommand command, final Role activeRole)
			throws IPScrumGeneralException {
		this.allowed = false;
		if (!command.dependsOnProject()) {
			final Iterator<Right> i = activeRole.getRights().iterator();
			while (i.hasNext()) {
				this.allowed = i.next().canBeExecuted(command);
				if (this.allowed) {
					break;
				}
			}
		} else {
			final Project dependingProject = command.getDependingProject(this.model);
			boolean projectOK = false;
			final Iterator<Team> teams = this.model.getAllTeams().iterator();
			while (teams.hasNext()) {
				final Team current = teams.next();
				if (current.getProjects().contains(dependingProject)) {
					projectOK = true;
				}
			}
			if (!projectOK) {
				this.allowed = false;
			} else {
				final Iterator<Right> i = activeRole.getRights().iterator();
				while (i.hasNext()) {
					this.allowed = i.next().canBeExecuted(command);
					if (this.allowed) {
						break;
					}
				}
			}
		}
		if (!this.allowed) {
			throw new NotAuthorizedException(ExceptionConstants.NOT_AUTHORIZED_ERROR);
		}
	}

	/**
	 * Returns the result of the authority check.
	 * 
	 * @return true, if user is authorized, false, if user is not authorized.
	 */
	protected boolean isAllowed() {
		return this.allowed;
	}
}
