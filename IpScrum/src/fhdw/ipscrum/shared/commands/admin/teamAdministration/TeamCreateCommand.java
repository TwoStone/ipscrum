package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import fhdw.ipscrum.shared.commands.interfaces.ITeamCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new team.
 */
public class TeamCreateCommand extends Command<Team> implements ITeamCommand {

	/**
	 * Represents the description of the new team.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TeamCreateCommand() {
		super();
	}

	/**
	 * Constructor of the TeamCreateCommand.
	 * 
	 * @param description
	 *            of the new team
	 */
	public TeamCreateCommand(final String description) {
		super();
		this.description = description;
	}

	@Override
	protected Team onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neues Team '%s' erstellt.",
				this.description));

		final Team team = new Team(model, this.description);
		return team;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTeamCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

}
