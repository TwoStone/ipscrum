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
 * Adds a person to a team.
 */
public class TeamAddMemberCommand extends Command<Void> implements ITeamCommand {

	/**
	 * Represents the person that should be added to the team.
	 */
	private String personId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TeamAddMemberCommand() {
		super();
	}

	/**
	 * Constructor of the TeamAddMemberCommand.
	 * 
	 * @param receiver
	 *            : team a person should be added to
	 * @param person
	 *            that should be added to the team
	 */
	public TeamAddMemberCommand(final Team receiver, final Person person) {
		super(receiver);
		this.personId = person.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Team team = (Team) model.getObject(this.getReceiverGuid());
		final Person person = (Person) model.getObject(this.personId);
		this.setStringValue(StringUtils.format("%s wurde dem Team '%s' hinzugefügt.",
				person.toString(), team.getDescription()));
		team.addMember(person);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTeamAddMemberCommand(this);
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
