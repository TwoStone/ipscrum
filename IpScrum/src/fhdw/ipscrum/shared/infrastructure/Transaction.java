package fhdw.ipscrum.shared.infrastructure;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Represents a transaction with a list of commands.
 * 
 */
public class Transaction implements IsSerializable {

	/**
	 * represents the related commands.
	 */
	private List<Command<?>> commands;

	/**
	 * represents the revision date.
	 */
	private Date modelRevision;

	/**
	 * represents the exception maybe thrown.
	 */
	private IPScrumGeneralException userException;

	/**
	 * represents the person responsible for the transaction.
	 */
	private String editorId;

	/**
	 * represents the id of the active role of the user at the time when the transaction
	 * has been invoked.
	 */
	private String activeRoleId;

	/**
	 * represents the generated UUIDs related to the transaction.
	 */
	private List<String> generatedUUIDs;

	/**
	 * constructor of the transaction.
	 * 
	 * @param modelRevision
	 *            is the current revision date
	 * @param editor
	 *            who is responsible for this transaction
	 * @param activeRole
	 *            the currently active role
	 * @param generatedUUIDs
	 *            related to the transaction
	 */
	public Transaction(final Date modelRevision, final Person editor,
			final Role activeRole, final List<String> generatedUUIDs) {
		this();
		this.modelRevision = CalendarUtils.copy(modelRevision);
		this.generatedUUIDs = generatedUUIDs;
		this.commands = new ArrayList<Command<?>>();
		if (editor != null) {
			this.editorId = editor.getId();
			this.activeRoleId = activeRole.getId();
		}
	}

	/**
	 * getter of the generated UUIDs.
	 * 
	 * @return all currently related UUIDs
	 */
	public List<String> getGeneratedUUIDs() {
		return this.generatedUUIDs;
	}

	/**
	 * sets the generated UUIDs.
	 * 
	 * @param generatedUUIDs
	 *            to set
	 */
	public void setGeneratedUUIDs(final List<String> generatedUUIDs) {
		this.generatedUUIDs = generatedUUIDs;
	}

	/**
	 * getter of the editor.
	 * 
	 * @return the current editor
	 */
	public String getEditorId() {
		return this.editorId;
	}

	/**
	 * Checks for exceptions while executing.
	 * 
	 * @throws IPScrumGeneralException
	 *             If there was a exception while executing the transaction
	 */
	public void checkUserException() throws IPScrumGeneralException {
		if (this.userException != null) {
			throw this.userException;
		}
	}

	/**
	 * sets the user exception.
	 * 
	 * @param userException
	 *            to set
	 */
	public void setUserException(final IPScrumGeneralException userException) {
		this.userException = userException;
	}

	/**
	 * constructor without parameters. needed for serialization.
	 */
	private Transaction() {

	}

	/**
	 * getter of the commands related to the transaction.
	 * 
	 * @return all currently related commands
	 */
	public List<Command<?>> getCommands() {
		return this.commands;
	}

	/**
	 * getter of the revision date of the model.
	 * 
	 * @return the current revision date
	 */
	public Date getModelRevision() {
		return CalendarUtils.copy(this.modelRevision);
	}

	/**
	 * adds a command to the transaction.
	 * 
	 * @param command
	 *            to add
	 */
	public void addCommand(final Command<?> command) {
		this.commands.add(command);
	}

	/**
	 * add commands to the transaction.
	 * 
	 * @param commandsToAdd
	 *            to add
	 */
	public void addCommand(final List<Command<?>> commandsToAdd) {
		this.commands.addAll(commandsToAdd);
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Transaction");
		builder.append(" Revision:").append(this.modelRevision);
		builder.append(" Commands:").append(this.commands.toString());
		builder.append(" Generated IDs:").append(this.generatedUUIDs.toString());
		return builder.toString();
	}

	/**
	 * Returns the ID of the active role of the user at the time when the transaction has
	 * been invoked.
	 * 
	 * @return role ID.
	 */
	public final String getActiveRoleId() {
		return this.activeRoleId;
	}

}
