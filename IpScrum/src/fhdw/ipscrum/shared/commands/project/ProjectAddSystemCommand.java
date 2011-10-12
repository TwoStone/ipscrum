package fhdw.ipscrum.shared.commands.project;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Adds a system to a Project.
 */
public class ProjectAddSystemCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Represents the system which should be added to the project.
	 */
	private String systemId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ProjectAddSystemCommand() {
		super();
	}

	/**
	 * Constructor of the ProjectAddSystemCommand.
	 * 
	 * @param receiver
	 *            : project the system should be added to
	 * @param system
	 *            which should be added to the project
	 */
	public ProjectAddSystemCommand(final Project receiver, final System system) {
		super(receiver);
		this.systemId = system.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final fhdw.ipscrum.shared.model.nonMeta.Project project = (Project) model.getObject(this.getReceiverGuid());
		final System system = (System) model.getObject(this.systemId);

		this.setStringValue(StringUtils.format("Projekt %s wurde System %s hinzugefügt.", project.getName(),
				system.getName()));

		project.addSystem(system);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleProjectAddSystemCommand(this);
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
