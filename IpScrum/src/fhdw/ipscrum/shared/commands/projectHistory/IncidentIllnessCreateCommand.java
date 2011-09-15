package fhdw.ipscrum.shared.commands.projectHistory;

import java.util.Date;

import fhdw.ipscrum.shared.commands.interfaces.IProjectHistoryCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;
import fhdw.ipscrum.shared.model.nonMeta.incidents.OneParticipantIncident;
import fhdw.ipscrum.shared.utils.CalendarUtils;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new illness incident.
 */
public class IncidentIllnessCreateCommand extends Command<OneParticipantIncident>
		implements IProjectHistoryCommand {

	/**
	 * Represents the date the IllnessIncident started.
	 */
	private Date startDate;

	/**
	 * Represents the date the IllnessIncident ended.
	 */
	private Date endDate;

	/**
	 * Represents the person the IllnessIncident is related to.
	 */
	private String personId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private IncidentIllnessCreateCommand() {
		super();
	}

	/**
	 * Constructor of the IncidentIllnessCreateCommand.
	 * 
	 * @param startDate
	 *            of the IllnessIncident
	 * @param endDate
	 *            of the IllnessIncident
	 * @param person
	 *            the incident is related to
	 */
	public IncidentIllnessCreateCommand(final Date startDate, final Date endDate,
			final Person person) {
		super();
		this.startDate = CalendarUtils.copy(startDate);
		this.endDate = CalendarUtils.copy(endDate);
		this.personId = person.getId();
	}

	@Override
	protected OneParticipantIncident onExecute(final Model model)
			throws IPScrumGeneralException {
		final Person person = (Person) model.getObject(this.personId);
		this.setStringValue(StringUtils.format("Krankheit von '%s' eingestellt.",
				person.toString()));

		final IncidentType incidentType =
				model.getIncidentTypeByName(TextConstants.INCIDENT_ILLNESS_NAME);
		final String description =
				person.toString() + TextConstants.INCIDENT_ILLNESS_DESCR_SUFFIX;

		final OneParticipantIncident incident =
				new OneParticipantIncident(model, this.startDate, this.endDate, person);
		incident.setType(incidentType);
		incident.setDescription(description);
		incident.setGlobal(true);

		return incident;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleIncidentIllnessCreateCommand(this);
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
