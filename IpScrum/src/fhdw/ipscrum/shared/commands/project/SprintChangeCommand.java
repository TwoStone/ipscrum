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
 * Changes the attributes of a sprint.
 */
public class SprintChangeCommand extends Command<Void> implements IProjectCommand {

	/**
	 * Represents the new name of the sprint.
	 */
	private String name;

	/**
	 * Represents the new description of the sprint.
	 */
	private String description;

	/**
	 * Represents the new date the sprint starts.
	 */
	private Date startdate;

	/**
	 * Represents the new date the sprint ends.
	 */
	private Date enddate;

	/**
	 * Represents the new team assigned to the sprint.
	 */
	private String assignedTeamId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SprintChangeCommand() {
		super();
	}

	/**
	 * Constructor of the SprintChangeCommand.
	 * 
	 * @param receiver
	 *            : sprint that should be changed
	 * @param name
	 *            : new name of the sprint
	 * @param description
	 *            : new description of the sprint
	 * @param startdate
	 *            : new date for the sprint to start
	 * @param enddate
	 *            : new date for the sprint to end
	 * @param assignedTeam
	 *            : new team assigned to the sprint
	 */
	public SprintChangeCommand(final Sprint receiver, final String name,
			final String description, final Date startdate, final Date enddate,
			final Team assignedTeam) {
		super(receiver);
		this.name = name;
		this.description = description;
		this.startdate = CalendarUtils.copy(startdate);
		this.enddate = CalendarUtils.copy(enddate);
		this.assignedTeamId = assignedTeam.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Sprint sprint = (Sprint) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Sprint %s wurde verändert.",
				sprint.getName()));

		sprint.setName(this.name);
		sprint.setDescription(this.description);
		sprint.setTimeFrame(this.startdate, this.enddate);
		sprint.setTeam((Team) model.getObject(this.assignedTeamId));
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleSprintChangeCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		final Sprint sprint = (Sprint) model.getObject(this.getReceiverGuid());
		return sprint.getProject();
	}

}
