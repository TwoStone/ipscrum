package fhdw.ipscrum.shared.model.nonMeta.incidents;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * represents an incident in which many participants could be involved.
 */
public class MultipleParticipantIncident extends Incident {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -5434093482723105160L;

	/**
	 * represents the related persons.
	 */
	private Vector<Person> participants;

	/**
	 * constructor of the MultiParticipantIncident.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param start
	 *            start date of the incident
	 * @param end
	 *            end date of the incident
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public MultipleParticipantIncident(final Model model, final Date start, final Date end)
			throws IPScrumGeneralException {
		super(model, start, end);
		this.participants = new Vector<Person>();
	}

	/**
	 * constructor without parameters. needed for serialization.
	 */
	@SuppressWarnings("unused")
	private MultipleParticipantIncident() {
	}

	/**
	 * getter of all related participants.
	 * 
	 * @return the currently related participants
	 */
	public final Vector<Person> getParticipants() {
		return this.participants;
	}

	/**
	 * Adds a person to this.
	 * 
	 * @param person
	 *            Person
	 */
	public void addParticipant(final Person person) {
		if (!this.participants.contains(person)) {
			this.participants.add(person);
		}
		this.changed();
	}

	/**
	 * Adds a list of persons to the incident.
	 * 
	 * @param list
	 *            list of persons
	 */
	public void addPartipants(final List<Person> list) {
		for (final Person person : list) {
			this.addParticipant(person);
		}
	}

	@Override
	public void accept(final IncidentVisitor visitor) {
		visitor.handleMultipleParticipantIncident(this);
	}
}
