package fhdw.ipscrum.shared.commands.projectHistory;

import java.util.Date;
import java.util.List;

import fhdw.ipscrum.shared.commands.interfaces.IProjectHistoryCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;
import fhdw.ipscrum.shared.model.nonMeta.incidents.MultipleParticipantIncident;
import fhdw.ipscrum.shared.utils.CalendarUtils;
import fhdw.ipscrum.shared.utils.ListUtils;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new customized incident.
 */
public class IncidentOtherIssueCreateCommand
		extends Command<MultipleParticipantIncident> implements IProjectHistoryCommand {

	/**
	 * Represents the date the Incident started.
	 */
	private Date startDate;

	/**
	 * Represents the date the Incident ended.
	 */
	private Date endDate;

	/**
	 * Represents the type of the Incident.
	 */
	private String incidentTypeId;

	/**
	 * Represents the description of the Incident.
	 */
	private String description;

	/**
	 * Represents the persons the Incident is related to.
	 */
	private List<String> personIds;

	/**
	 * Represents the projects the Incident is related to.
	 */
	private List<String> projectIds;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private IncidentOtherIssueCreateCommand() {
		super();
	}

	/**
	 * Constructor of the IncidentOtherIssueCreateCommand.
	 * 
	 * @param startDate
	 *            of the Incident
	 * @param endDate
	 *            if the Incident
	 * @param incidentTypeId
	 *            of the Incident
	 * @param description
	 *            of the Incident
	 * @param persons
	 *            related to the Incident
	 * @param projects
	 *            related to the Incident
	 */
	public IncidentOtherIssueCreateCommand(final Date startDate, final Date endDate,
			final String incidentTypeId, final String description,
			final List<Person> persons, final List<Project> projects) {
		super();
		this.startDate = CalendarUtils.copy(startDate);
		this.endDate = CalendarUtils.copy(endDate);
		this.incidentTypeId = incidentTypeId;
		this.description = description;
		this.personIds = ListUtils.convertObjListToIdList(persons);
		this.projectIds = ListUtils.convertObjListToIdList(projects);
	}

	@Override
	protected MultipleParticipantIncident onExecute(final Model model)
			throws IPScrumGeneralException {
		final IncidentType incidentType =
				(IncidentType) model.getObject(this.incidentTypeId);
		this.setStringValue(StringUtils.format("Ereignis vom Typ '%s' eingetragen.",
				incidentType.getName()));

		final MultipleParticipantIncident incident =
				new MultipleParticipantIncident(model, this.startDate, this.endDate);
		incident.setType(incidentType);
		incident.setDescription(this.description);

		final List<Person> persons =
				ListUtils.convertIdListToObjList(this.personIds, model);
		final List<Project> projects =
				ListUtils.convertIdListToObjList(this.projectIds, model);
		incident.addPartipants(persons);
		incident.addProjects(projects);

		return incident;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleIncidentOtherIssueCreateCommand(this);
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
