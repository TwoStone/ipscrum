package fhdw.ipscrum.shared.commands.admin;

import fhdw.ipscrum.shared.commands.interfaces.IAdminCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new system.
 */
public class SystemCreateCommand extends Command<System> implements IAdminCommand {

	/**
	 * Represents the name of the system.
	 */
	private String name;

	/**
	 * Represents the parentSystem of the new system.
	 */
	private String parentId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SystemCreateCommand() {
		super();
	}

	/**
	 * Constructor of the SystemCreateCommand for a system without a parent.
	 * 
	 * @param name
	 *            of the new system
	 * @param model
	 *            : system is directly added to the model if it doesn't have a parent
	 */
	public SystemCreateCommand(final String name, final Model model) {
		this(name, model.getRootsystem());
	}

	/**
	 * Constructor of the SystemCreateCommand for a system with a parent.
	 * 
	 * @param name
	 *            of the new system
	 * @param parent
	 *            of the new system
	 */
	public SystemCreateCommand(final String name, final AbstractSystem parent) {
		super();
		this.name = name;
		this.parentId = parent.getId();
	}

	@Override
	protected System onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils
				.format("Neues System '%s' erstellt.", this.name));

		final AbstractSystem parent = (AbstractSystem) model.getObject(this.parentId);
		final System system = new System(model, this.name, parent);
		return system;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleSystemCreateCommand(this);
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
