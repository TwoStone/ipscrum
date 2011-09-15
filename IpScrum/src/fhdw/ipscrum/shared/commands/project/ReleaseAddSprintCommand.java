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
 * Adds a sprint to a Release.
 */
public class ReleaseAddSprintCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Represents the sprint that should be added to the release.
	 */
	private String sprintId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ReleaseAddSprintCommand() {
		super();
	}

	/**
	 * Constructor of the ReleaseAddSprintCommand.
	 * 
	 * @param receiver
	 *            : release the sprint should be added to
	 * @param sprint
	 *            that should be added to the release
	 */
	public ReleaseAddSprintCommand(final Release receiver, final Sprint sprint) {
		super(receiver);
		this.sprintId = sprint.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Release release = (Release) model.getObject(this.getReceiverGuid());
		final Sprint sprint = (Sprint) model.getObject(this.sprintId);

		this.setStringValue(StringUtils.format(
				"Release %s wurde der Sprint %s hinzugefügt.", release.getVersion(),
				sprint.getName()));

		release.addSprint(sprint);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleReleaseAddSprintCommand(this);
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
