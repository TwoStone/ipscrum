package fhdw.ipscrum.shared.commands.project;

import java.util.Date;

import fhdw.ipscrum.shared.commands.interfaces.IProjectCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.utils.CalendarUtils;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new release.
 */
public class ReleaseCreateCommand extends Command<Release> implements IProjectCommand {

	/**
	 * Represents the project the release is related to.
	 */
	private String projectId;

	/**
	 * Represents the description of the release.
	 */
	private String versionDescription;

	/**
	 * Represents the date the release is terminated.
	 */
	private Date date;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ReleaseCreateCommand() {
		super();
	}

	/**
	 * Constructor of the ReleaseCreateCommand.
	 * 
	 * @param project
	 *            the release is related to
	 * @param versionDescription
	 *            of the release
	 * @param date
	 *            the release is terminated
	 */
	public ReleaseCreateCommand(final Project project, final String versionDescription, final Date date) {
		super();
		this.projectId = project.getId();
		this.versionDescription = versionDescription;
		this.date = CalendarUtils.copy(date);
	}

	@Override
	protected Release onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neues Release '%s' erstellt.", this.versionDescription));

		final Project project = (Project) model.getObject(this.projectId);
		final Release release = new Release(model, this.versionDescription, this.date, project);
		// Project gets notified about new Release by BDAManager-method.
		return release;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleReleaseCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return (Project) model.getObject(this.projectId);
	}

}
