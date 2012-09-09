package fhdw.ipscrum.shared.commands.project;

import java.util.Date;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.CalendarUtils;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new sprint.
 */
public class SprintCreateCommand extends Command<Sprint> implements IProjectCommand {

	/**
	 * Represents the name of the new sprint.
	 */
	private String name;

	/**
	 * Represents the date the new sprint starts.
	 */
	private Date startDate;

	/**
	 * Represents the date the new sprint ends.
	 */
	private Date endDate;

	/**
	 * Represents the description of the new sprint.
	 */
	private String description;

	/**
	 * Represents the team assigned to the new sprint.
	 */
	private String assignedTeamId;

	/**
	 * Represents the project assigned to the new sprint.
	 */
	private String assignedProjectId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SprintCreateCommand() {
		super();
	}

	/**
	 * Constructor of the SprintCreateCommand.
	 * 
	 * @param name
	 *            of the new sprint
	 * @param startDate
	 *            of the new sprint
	 * @param endDate
	 *            of the new sprint
	 * @param description
	 *            of the new sprint
	 * @param assignedTeam
	 *            of the new sprint
	 * @param assignedProject
	 *            of the new sprint
	 */
	public SprintCreateCommand(final String name, final Date startDate, final Date endDate, final String description,
			final Team assignedTeam, final Project assignedProject) {
		super();
		this.name = name;
		this.startDate = CalendarUtils.copy(startDate);
		this.endDate = CalendarUtils.copy(endDate);
		this.description = description;
		this.assignedTeamId = assignedTeam.getId();
		this.assignedProjectId = assignedProject.getId();
	}

	@Override
	protected Sprint onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Sprint '%s' erstellt.", this.name));

		final Team assignedTeam = (Team) model.getObject(this.assignedTeamId);
		final Project assignedProject = (Project) model.getObject(this.assignedProjectId);
		final Sprint sprint =
				new Sprint(model, this.name, this.description, this.startDate, this.endDate, assignedTeam,
						assignedProject);
		return sprint;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleSprintCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return (Project) model.getObject(this.assignedProjectId);
	}

}
