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
 * Changes the name of a project.
 */
public class ProjectChangeNameCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Represents the name/description of the project.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ProjectChangeNameCommand() {
		super();
	}

	/**
	 * Constructor of the ProjectChangeNameCommand.
	 * 
	 * @param receiver
	 *            : the project of which the name should be changed
	 * @param description
	 *            new name/description of the project
	 */
	public ProjectChangeNameCommand(final Project receiver, final String description) {
		super(receiver);
		this.description = description;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Project project = (Project) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Projekt %s wurde umbenannt in %s.",
				project.getName(), this.description));

		project.setName(this.description);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleProjectChangeNameCommand(this);
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
