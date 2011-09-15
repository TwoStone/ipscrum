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
 * Creates a new project.
 */
public class ProjectCreateCommand extends Command<Project> implements IProjectCommand {

	/**
	 * Represents the description/name of the new project.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ProjectCreateCommand() {
		super();
	}

	/**
	 * Constructor of the ProjectCreateCommand.
	 * 
	 * @param description
	 *            of the new project
	 */
	public ProjectCreateCommand(final String description) {
		super();
		this.description = description;
	}

	@Override
	protected Project onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neues Projekt '%s' erstellt.",
				this.description));

		final Project project = new Project(model, this.description);
		return project;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleProjectCreateCommand(this);
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
