package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import fhdw.ipscrum.shared.commands.interfaces.ITeamCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Removes a person from a team.
 */
public class TeamRemoveMemberCommand extends Command<Void> implements ITeamCommand {

	/**
	 * Represents the person that should be removed from the team.
	 */
	private String personId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TeamRemoveMemberCommand() {
		super();
	}

	/**
	 * Constructor of the TeamRemoveMemberCommand.
	 * 
	 * @param receiver
	 *            : team the person should be removed from
	 * @param person
	 *            that should be removed from the team
	 */
	public TeamRemoveMemberCommand(final Team receiver, final Person person) {
		super(receiver);
		this.personId = person.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Team team = (Team) model.getObject(this.getReceiverGuid());
		final Person person = (Person) model.getObject(this.personId);
		this.setStringValue(StringUtils.format("%s wurde aus dem Team '%s' entfernt.",
				person.toString(), team.getDescription()));
		team.removeMember(person);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTeamRemoveMemberCommand(this);
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
