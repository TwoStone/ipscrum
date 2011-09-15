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
 * Renames a team.
 */
public class TeamSetDescriptionCommand extends Command<Void> implements ITeamCommand {

	/**
	 * Represents the new description of the team.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TeamSetDescriptionCommand() {
		super();
	}

	/**
	 * Constructor of the TeamSetDescriptionCommand.
	 * 
	 * @param receiver
	 *            : team the description should be changed
	 * @param description
	 *            : new description of the team
	 */
	public TeamSetDescriptionCommand(final Team receiver, final String description) {
		super(receiver);
		this.description = description;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Team team = (Team) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Team '%s' umbenannt in '%s'.",
				team.getDescription(), this.description));
		team.setDescription(this.description);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTeamSetDescriptionCommand(this);
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
