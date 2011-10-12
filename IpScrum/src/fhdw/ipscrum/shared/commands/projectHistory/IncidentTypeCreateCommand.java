package fhdw.ipscrum.shared.commands.projectHistory;

import fhdw.ipscrum.shared.commands.interfaces.IProjectHistoryCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new incident type.
 */
public class IncidentTypeCreateCommand extends Command<IncidentType> implements IProjectHistoryCommand {

	/**
	 * Represents the description of the IncidentType.
	 */
	private String description;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private IncidentTypeCreateCommand() {
		super();
	}

	/**
	 * Constructor of the IncidentTypeCreateCommand.
	 * 
	 * @param description
	 *            of the IncidentType
	 */
	public IncidentTypeCreateCommand(final String description) {
		super();
		this.description = description;
	}

	@Override
	protected IncidentType onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Ereignistyp '%s' erstellt.", this.description));

		final IncidentType incidentType = new IncidentType(model, this.description);
		return incidentType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleIncidentTypeCreateCommand(this);
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
