package fhdw.ipscrum.shared.commands.project;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Deletes a project.
 */
public class ProjectDeleteCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ProjectDeleteCommand() {
		super();
	}

	/**
	 * Constructor of the ProjectDeleteCommand.
	 * 
	 * @param project
	 *            to be deleted
	 */
	public ProjectDeleteCommand(final Project project) {
		super(project);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Project project = (Project) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Projekt '%s' entfernt.", project.getName()));
		model.removeProject(project);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleProjectDeleteCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return (Project) model.getObject(this.getReceiverGuid());
	}

}
