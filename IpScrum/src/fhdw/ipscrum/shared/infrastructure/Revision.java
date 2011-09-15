package fhdw.ipscrum.shared.infrastructure;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Represents a Revision with the changes made within the revision.
 */
public class Revision implements IsSerializable {

	/**
	 * represents all commands related to the revision.
	 */
	private List<Command<?>> commands;

	/**
	 * represents the revision date.
	 */
	private Date revisionDate;

	/**
	 * represents the person that edited something to create this revision.
	 */
	private String editorId;

	/**
	 * represents the related UUIDs.
	 */
	private List<String> generatedUUIDs;

	/**
	 * constructor without parameters. needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Revision() {
		super();
	}

	/**
	 * constructor of the revision.
	 * 
	 * @param commands
	 *            related to the revision
	 * @param revisionDate
	 *            of the revision
	 * @param editorId
	 *            last edited something
	 * @param generatedUUIDs
	 *            related to the revision
	 */
	public Revision(final List<Command<?>> commands, final Date revisionDate,
			final String editorId, final List<String> generatedUUIDs) {
		super();
		this.commands = commands;
		this.revisionDate = CalendarUtils.copy(revisionDate);
		this.editorId = editorId;
		this.generatedUUIDs = generatedUUIDs;
	}

	/**
	 * getter of the related UUIDs.
	 * 
	 * @return all related UUIDs
	 */
	public List<String> getGeneratedUUIDs() {
		return this.generatedUUIDs;
	}

	/**
	 * getter of the commands related to the revision.
	 * 
	 * @return all related commands
	 */
	public List<Command<?>> getCommands() {
		return this.commands;
	}

	/**
	 * Getter of the revision date.
	 * 
	 * @return the current revision date
	 */
	public Date getRevisionDate() {
		return CalendarUtils.copy(this.revisionDate);
	}

	/**
	 * Returns null if no Editor was set!
	 * 
	 * @param model
	 *            related to the revision
	 * @return the person which last edited something
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public Person getEditor(final Model model) throws IPScrumGeneralException {
		if (this.editorId != null) {
			return (Person) model.getObject(this.editorId);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		final StringBuffer result = new StringBuffer();
		final java.util.Iterator<Command<?>> i = this.getCommands().iterator();
		while (i.hasNext()) {
			result.append(i.next().toString());
			if (i.hasNext()) {
				result.append("\n");
			}
		}
		return result.toString();
	}
}
