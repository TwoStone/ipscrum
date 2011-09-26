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
 * Adds a project to the team.
 */
public class TeamAddProjectCommand extends Command<Void> implements ITeamCommand {
	/**
	 * the project to add.
	 */
	private String projectID;

	/**
	 * default constructor for serialization.
	 */
	@SuppressWarnings("unused")
	private TeamAddProjectCommand() {
		super();
	}

	/**
	 * constructor of the TeamAddProjectCommand.
	 * 
	 * @param receiver
	 *            : the related receiver.
	 * @param project
	 *            : the related project.
	 */
	public TeamAddProjectCommand(final Team receiver, final Project project) {
		super(receiver);
		this.projectID = project.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Project p = (Project) model.getObject(this.projectID);
		final Team t = (Team) model.getObject(this.getReceiverGuid());
		t.addProject(p);
		this.setStringValue(StringUtils.format("Dem Team %s wurde das Projekt %s zugewiesen", t.getDescription(),
				p.getName()));
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTeamAddProjectCommand(this);
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
