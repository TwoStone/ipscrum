package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.Date;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * Represents an incident in which only one person is involved.
 */
public class OneParticipantIncident extends Incident {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4826959493418850283L;

	/**
	 * represents the participant related to the incident.
	 */
	private Person participant;

	/**
	 * constructor of the OneParticipantIncident.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param start
	 *            start date of the incident
	 * @param end
	 *            end date of the incident
	 * @param participant
	 *            related to the incident
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public OneParticipantIncident(final Model model, final Date start, final Date end, final Person participant)
			throws IPScrumGeneralException {
		super(model, start, end);
		this.participant = participant;
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	public OneParticipantIncident() {
		super();
	}

	/**
	 * getter of the related participant.
	 * 
	 * @return the current participant
	 */
	public Person getParticipant() {
		return this.participant;
	}

	@Override
	public void accept(final IncidentVisitor visitor) {
		visitor.handleOneParticipantIncident(this);
	}
}
