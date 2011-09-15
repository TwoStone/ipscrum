package fhdw.ipscrum.shared.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.BuildModelException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.infrastructure.UUIDReceiver;
import fhdw.ipscrum.shared.model.Model;

/**
 * represents the utils needed for the infrastructure of the IPScrum.
 */
public final class InfrastructureUtils {

	/**
	 * constructor of the InfrastructureUtils.
	 */
	private InfrastructureUtils() {

	}

	/**
	 * Returns a List of all Commands up to the given Revision Date.
	 * 
	 * @param revisionDate
	 *            to which the commands should be related
	 * @param allRevisions
	 *            related to the date
	 * @return all revisions related to the given date
	 */
	private static List<Revision> getAllRevisionsToDate(final Date revisionDate,
			final Map<Date, Revision> allRevisions) {
		final List<Revision> ret = new ArrayList<Revision>();
		for (final Map.Entry<Date, Revision> current : allRevisions.entrySet()) {
			if (current.getValue().getRevisionDate().before(revisionDate)
					|| current.getValue().getRevisionDate().equals(revisionDate)) {
				ret.add(current.getValue());
			}
		}

		java.util.Collections.sort(ret, new Comparator<Revision>() {

			@Override
			public int compare(final Revision o1, final Revision o2) {
				return o1.getRevisionDate().compareTo(o2.getRevisionDate());
			}
		});

		return ret;
	}

	/**
	 * Sets the model object to view only mode.
	 * 
	 * @param model
	 *            which should be set in the view only mode
	 */
	public static void lockModel(final Model model) {
		model.setViewOnlyFlag(true);
	}

	/**
	 * Builds a specific Model based on the given revision date.
	 * 
	 * @param revisionDate
	 *            to which the model should be related
	 * @param allRevisions
	 *            related to the date
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the model related to the given date
	 */
	public static Model buildSpecificModel(final Date revisionDate,
			final Map<Date, Revision> allRevisions) throws IPScrumGeneralException {
		final Model specificModel = new Model(revisionDate);

		// --- ... Sämtliche Generated IDs werder ermittelt
		final List<String> generatedIDs = new ArrayList<String>();
		for (final Revision current : InfrastructureUtils.getAllRevisionsToDate(
				revisionDate, allRevisions)) {
			generatedIDs.addAll(current.getGeneratedUUIDs());
		}
		// --- ... UUID Receiver wird gesetzt
		specificModel.setUuidManager(new UUIDReceiver(generatedIDs));

		// --- ... eigentlicher Replay
		try {
			for (final Revision current : InfrastructureUtils.getAllRevisionsToDate(
					revisionDate, allRevisions)) {

				for (final Command<?> curCommand : current.getCommands()) {
					curCommand.execute(specificModel);
				}

				for (final IdentifiableObject curObject : specificModel
						.getChangedObjects()) {
					curObject.setRevisionDate(current.getRevisionDate());
					curObject.undoChangeFlag();
				}
			}
			return specificModel;
		} catch (final IPScrumGeneralException e) {
			throw new BuildModelException(
					"Beim Laden der Revision ist der folgende Fehler aufgetreten:\n"
							+ e.getMessage());
		}
	}
}
