package fhdw.ipscrum.shared.infrastructure;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * Master class for commands according the command pattern.
 * 
 * @param <R>
 *            Defines the result Type of the command
 */
public abstract class Command<R> implements IsSerializable, ICommand {

	/**
	 * represents the receiver GUID.
	 */
	private String receiverGuid;

	/**
	 * getter of the GUID.
	 * 
	 * @return the current GUID
	 */
	protected String getReceiverGuid() {
		return this.receiverGuid;
	}

	/**
	 * sets the GUID of the command.
	 * 
	 * @param receiverGuid
	 *            to set
	 */
	protected void setReceiverGuid(final String receiverGuid) {
		this.receiverGuid = receiverGuid;
	}

	/**
	 * represents the result of the command.
	 */
	private R result;

	/**
	 * represents the exception a command could throw.
	 */
	private IPScrumGeneralException userException;

	/**
	 * represents the string value of the command.
	 */
	private String stringValue = TextConstants.EMPTY_TEXT;

	/**
	 * sets the userExceeption.
	 * 
	 * @param userException
	 *            to set
	 */
	protected void setUserException(final IPScrumGeneralException userException) {
		this.userException = userException;
	}

	/**
	 * getter of the result of the command.
	 * 
	 * @return the result in the attached type
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public R getResult() throws IPScrumGeneralException {
		if (this.userException != null) {
			throw this.userException;
		}
		return this.result;
	}

	/**
	 * sets the result of the command addicted to the type.
	 * 
	 * @param result
	 *            the result to set addicted to the type
	 */
	public void setResult(final R result) {
		this.result = result;
	}

	/**
	 * sets the string value of the command.
	 * 
	 * @param stringValue
	 *            is the string to set
	 */
	public void setStringValue(final String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Command used for Object Creation.
	 */
	public Command() {
		super();
	}

	/**
	 * Command used for changing the receiver class.
	 * 
	 * @param receiver
	 *            Receiver of the command execution
	 */
	public Command(final IdentifiableObject receiver) {
		super();
		this.setReceiverGuid(receiver.getId());
	}

	/**
	 * Execution template method according the command pattern. Executes an authority
	 * check.
	 * 
	 * @param model
	 *            Model where the execution works on.
	 * @param activeRole
	 *            role of the person that executes the command.
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void execute(final Model model, final Role activeRole)
			throws IPScrumGeneralException {
		try {
			model.getAuthorityChecker().canBeExecuted(this, activeRole);
			this.setResult(this.onExecute(model));
		} catch (final InfrastructureException e) {
			this.setUserException(e);
			throw e;
		}
	}

	/**
	 * Execution template method according the command pattern. Variant without authority
	 * check (Important for initial revision with no users!).
	 * 
	 * @param model
	 *            Model where the execution works on.
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void execute(final Model model) throws IPScrumGeneralException {
		try {
			this.setResult(this.onExecute(model));
		} catch (final InfrastructureException e) {
			this.setUserException(e);
			throw e;
		}
	}

	/**
	 * Concrete implementation of the execute method.
	 * 
	 * @param model
	 *            Model where the execution works on.
	 * @return the type of the command to execute
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected abstract R onExecute(Model model) throws IPScrumGeneralException;

	@Override
	public String toString() {
		return this.stringValue;
	}

}
