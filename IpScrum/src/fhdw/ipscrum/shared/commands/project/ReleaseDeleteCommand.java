package fhdw.ipscrum.shared.commands.project;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Deletes a release.
 */
public class ReleaseDeleteCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ReleaseDeleteCommand() {
		super();
	}

	/**
	 * Constructor of the ReleaseDeleteComand.
	 * 
	 * @param release
	 *            that should be deleted
	 */
	public ReleaseDeleteCommand(final Release release) {
		super(release);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Release release = (Release) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Release '%s' entfernt.",
				release.getVersion()));
		release.getProject().removeRelease(release);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleReleaseDeleteCommand(this);
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
