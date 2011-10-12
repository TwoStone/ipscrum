package fhdw.ipscrum.shared.commands.project;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Removes a sprint from a release.
 */
public class ReleaseRemoveSprintCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Represents the sprint that should be removed.
	 */
	private String sprintId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ReleaseRemoveSprintCommand() {
		super();
	}

	/**
	 * Constructor of the ReleaseRemoveSprintCommand.
	 * 
	 * @param receiver
	 *            : release the sprint should be removed from
	 * @param sprint
	 *            that should be removed from the release
	 */
	public ReleaseRemoveSprintCommand(final Release receiver, final Sprint sprint) {
		super(receiver);
		this.sprintId = sprint.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Release release = (Release) model.getObject(this.getReceiverGuid());
		final Sprint sprint = (Sprint) model.getObject(this.sprintId);

		this.setStringValue(StringUtils.format("Sprint %s wurde aus Release %s entfernt.", sprint.getName(),
				release.getVersion()));

		release.removeSprint(sprint);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleReleaseRemoveSprintCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		final Release rel = (Release) model.getObject(this.getReceiverGuid());
		return rel.getProject();
	}

}
