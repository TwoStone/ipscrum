package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new state type.
 */
public class StateTypeCreateCommand extends Command<StateType> implements ITicketTypesCommand {

	/**
	 * represents the name of the state type to create.
	 */
	private String name;

	/**
	 * represents the description of the state type to create.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private StateTypeCreateCommand() {
		super();
	}

	/**
	 * Constructor of the StateTypeCreateCommand.
	 * 
	 * @param name
	 *            related to the command the new state type should get
	 * @param description
	 *            related to the command the new state type should get
	 */
	public StateTypeCreateCommand(final String name, final String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	protected StateType onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Zustand '%s' erstellt.", this.name));
		final StateType stateType = new StateType(model, this.name, this.description);
		return stateType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleStateTypeCreateCommand(this);
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
